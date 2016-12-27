package controlador;


import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.maps.*;
import com.google.maps.model.AddressComponent;
import com.google.maps.model.GeocodingResult;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Properties;

import com.csvreader.CsvReader;
import com.csvreader.CsvWriter;


import dao.DAO;
import dao.DAOSolicitud;
import gson.GeoResponse;
import gson.GeoResponseParser;
import negocio.*;

public class Sistema {

	private static Sistema instancia = null;
	List<Solicitud> solicitudes = null;
	
	public static Sistema getInstancia(){
		if(instancia==null){
			instancia =  new Sistema();
		}
		return instancia;
	}
	
	private Sistema(){
		/*Inicializo listas*/
		solicitudes = new ArrayList<Solicitud>();
	}

	/*Inicio en CP*/
	
	public List<String> getLocalidadByCp(int cp){
		return DAO.getInstancia().getLocalidadbyCP(cp);
	}
	
	public List<String> getParajeByCp(int cp){
		return DAO.getInstancia().getParajebyCP(cp);
	}
	
	public List<String> getCalleByCp(int cp){
		return DAO.getInstancia().getCallebyCP(cp);
	}
	
	public List<Object[]> getCPAGui(int cp, String calle, int altura){
		return DAO.getInstancia().getCPAGui(cp, calle, altura);
	}
	
	public List<Object[]> getCPAGuiBarrio(String barrio){
		return DAO.getInstancia().getCPAGuiBarrio(barrio);
	}
	
	
	
	/* Actualizar Base de datos - Toma los datos del archivo c:/CPA/Excel/surveymonkey.csv y actualiza la base de datos del sistema */
	public int actualizarSolicitudes(){
		return ControladorArchivos.getInstancia().importarCSV_SM();
	}
	
	
	/* Buscar CPA desde las solicitudes persistidas en la base de datos
	 * Si la solicitud ya paso el proceso de busqueda no lo repite. 
	 */
	
	public int buscarCPASolicitudes() throws Exception{
		
		int encontradas = 0;
		
		//Traigo las solicitudes desde la BD
		solicitudes = this.getSolicitudes();
		
		//Recorro, busco CPA y actualizo la BD, devuelve la cantidad de encontrados
		for (Solicitud solicitud : solicitudes) {
			if(solicitud.getCpa().equals("")){
				if(!ControladorCP.getInstancia().getCPA(solicitud).equals("SIN CPA")){
					solicitud.setCpa(ControladorCP.getInstancia().getCPA(solicitud));
					DAOSolicitud.getInstancia().guardarSolicitud(solicitud);
					encontradas++;
				}
			}
		}
		
		return encontradas;

	}
	
	/* Exportar solicitudes a un CSV */
	public void exportarCSV (){
		ControladorArchivos.getInstancia().exportarCSV(getSolicitudes());
	}
	
	
	
	public boolean getCPAdesdeCSV(String nombreArchivo) throws Exception{
		
		System.out.println(nombreArchivo);
		
		/*Importo el archivo y pongo el resultado en la list de Solicitudes*/
		if(ControladorArchivos.getInstancia().importarCSV(nombreArchivo)){
			//Pudo importar el archivo correctamente
			
			for (Solicitud s : solicitudes) {
				
				String resultadoCA = ControladorCP.getInstancia().getCPACA(s.getCp(), s.getCalle(), s.getAltura());
				
				if(!resultadoCA.equals("SIN CPA")){
					//Encontro el resultado en Correo Argentino, lo asigno y pongo método CA
					s.setCpa(resultadoCA);
					s.setMetodo("CA");
				
				}else{
					//Busco el CPA en Google
					String resultadoGoogle = ControladorCP.getInstancia().consultaCPAGoogle(s.getCalle()+" "+s.getAltura()+", "+s.getLocalidad()+", "+s.getProvincia());
					
					if(!resultadoGoogle.equals("SIN CPA")){
						//Encontro el resultado en API Google, lo asigno y pongo método GOOGLE
						s.setCpa(resultadoGoogle);
						s.setMetodo("GOOGLE");
					}else{
						// No encontro por ninguno de los 2 métodos, sumo 1 pendiente
						s.setCpa("SIN CPA");
						s.setMetodo("");
					}
				}
			}
			
			
			ControladorArchivos.getInstancia().exportarCSV(this.solicitudes);
			return true;
			
		}else{
			System.out.println("Error al importar el archivo");
			return false;
		}
		
		
	}
	
	

	/* GET CPA DESDE UN CSV - Busqueda en ambos Sistemas Google y Correo Argentino 
	 * Recibe como parametro el archivo de datos */
	
	public String getCPAUnico(int cp, String calle, int altura, String localidad, String provincia) throws Exception{
		
		String resultadoCA = ControladorCP.getInstancia().getCPACA(cp, calle,altura);
			
		if(!resultadoCA.equals("SIN CPA")){
			return resultadoCA;
			
		}else{
			
			String resultadoGoogle = ControladorCP.getInstancia().consultaCPAGoogle(calle+" "+altura+", "+localidad+", "+provincia);
				
			if(!resultadoGoogle.equals("SIN CPA")){
				return resultadoGoogle;
			}else{
				return "Sin CPA";
			}
		}
	}
	
	
	
	
	
	
	public List<Provincia> getProvincias (){
		return DAO.getInstancia().getProvincia();
	}
	
	public List<String> getParajesByProvincia (String provincia){
		return DAO.getInstancia().getParajeByProvincia(provincia);
	}
	
	public void setSolicitudes(List<Solicitud> solicitudes) {
		this.solicitudes = solicitudes;
	}

	public List<Solicitud> getSolicitudes() {
		return DAOSolicitud.getInstancia().getSolicitudes();
	}

	public List<String> getLocalidadByParaje (String paraje){
		return DAO.getInstancia().getLocalidadesByParaje(paraje);
	}
	
	
	
}

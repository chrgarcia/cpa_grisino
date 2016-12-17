package Test;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.Timer;

import org.apache.jasper.tagplugins.jstl.core.ForEach;

import com.google.maps.model.AddressComponent;
import com.google.maps.model.AddressComponentType;
import com.google.maps.model.GeocodingResult;

import controlador.ControladorArchivos;
import controlador.Sistema;
import dao.DAO;
import dao.DAOSolicitud;
import negocio.Provincia;
import negocio.Solicitud;

public class AppTestLocal {

	public static void main(String[] args) throws Exception {
		
		//System.out.println(Sistema.getInstancia().getCPAUnico(1416, "helguera", 1291, "CABA", "CABA"));
		
		//Solicitud s = new Solicitud(1, "helguera", 1200, 1212, "caba", "caba");
		//DAOSolicitud.getInstancia().guardarSolicitud(s);
		
		//ControladorArchivos.getInstancia().importarCSV_SM();
		
		Timer timer = new Timer(20, new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				System.out.println("Ejecutado!!");
				try {
					
				} catch (Exception e) {
					e.printStackTrace();
				}
				Sistema.getInstancia().exportarCSV();
		     
			}
		});
				
		timer.start();
		
		
		//Sistema.getInstancia().getCPAdesdeCSV("C:/CPA/solicitudes.csv");
				
		//Sistema s = new Sistema();
		/*Testing GUI*/
		//System.out.println(s.getCPAGui(1439, "miralla", 4052));
		//System.out.println(DAO.getInstancia().getCPAGui(1439, "miralla", 4052));
		
		/*Ejemplo*/
		//System.out.println("-*-");
		//s.getCPA(1419, "VALLEJOS", 3148);
		//System.out.println("-*-");
		
		//System.out.println(s.consultaCPAGoogle("helguera 1291, caba"));

		//Imprimir provincias
		/*List<Provincia> provincias = Sistema.getInstancia().getProvincias();
		for (Provincia provincia : provincias) {
			System.out.println(provincia.getNombre());
		}*/
		
		/*Importación de Datos de solicitudes*/
		/*System.out.println("Importación de Solicitudes");
		Sistema.getInstancia().importarCSV();
		System.out.println("--------------------------");
		
		System.out.println("Resultados busqueda CPA");
		System.out.println("--------------------------");*/
		//List<Solicitud> solicitudes = Sistema.getInstancia().getSolicitudes();
		
		/*int pendientes = 0;
		int total = solicitudes.size();
		
		for(Solicitudes solicitud : solicitudes){

			/*Consulto BD de Correo Argentino*/
			/*String resultadoCA = Sistema.getInstancia().getCPA(solicitud.getCp(), solicitud.getCalle(), solicitud.getAltura());
			
			if(!resultadoCA.equals("SIN CPA")){
				//Encontro el resultado en Correo Argentino, lo asigno y pongo método CA
				solicitud.setCpa(resultadoCA);
				solicitud.setMetodo("CA");
			
			}else{
				//Busco el CPA en Google
				String resultadoGoogle = Sistema.getInstancia().consultaCPAGoogle(solicitud.getCalle()+" "+solicitud.getAltura()+", "+solicitud.getLocalidad()+", "+solicitud.getProvincia());
				
				if(!resultadoGoogle.equals("SIN CPA")){
					//Encontro el resultado en API Google, lo asigno y pongo método GOOGLE
					solicitud.setCpa(resultadoGoogle);
					solicitud.setMetodo("GOOGLE");
				}else{
					// No encontro por ninguno de los 2 métodos, sumo 1 pendiente
					solicitud.setCpa("SIN CPA");
					solicitud.setMetodo("");
					pendientes++;
				}
				
			}
			
					
			/*System.out.println(solicitud.getId() + "," + solicitud.getCalle() + "," + solicitud.getAltura() + ","+ solicitud.getCp() + "," +
				solicitud.getLocalidad() + "," + solicitud.getProvincia() + "," + solicitud.getCpa());*/
				
		//}
			
		System.out.println("--------------------------");
		//System.out.println("---------RESULTADOS-------");
		//System.out.println("--------------------------");
		/*System.out.println("Total Importados: "+total);
		System.out.println("CON CPA: "+(total-pendientes));
		System.out.println("Pendientes: "+pendientes);
		System.out.println("--------------------------");*/
		//System.out.println();
				
		//Sistema.getInstancia().exportarCSV(solicitudes);
		//System.out.println("Exportación a CSV");
		//System.out.println("--------------------------");
		
		
		
	}

}

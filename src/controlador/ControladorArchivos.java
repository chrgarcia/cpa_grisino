package controlador;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;

import com.csvreader.CsvReader;
import com.csvreader.CsvWriter;

import dao.DAOSolicitud;
import negocio.Solicitud;

public class ControladorArchivos {

	private static ControladorArchivos instancia = null;
	
	public static ControladorArchivos getInstancia(){
		if(instancia==null){
			instancia =  new ControladorArchivos();
		}
		return instancia;
	}
	
	public void importarCSV_SM() {
		try {
						
			CsvReader solicitudes_import = new CsvReader("C:/CPA/Excel/SurveyMonkey.csv");
			solicitudes_import.readHeaders();
			//ID	Calle	Altura	CP	Localidad	Provincia
		
			int alturaInt = 0;
			int cpInt = 0;
			int idInt = 0;
			
			while (solicitudes_import.readRecord()) {
				String id = solicitudes_import.get("ID");
				String calle = solicitudes_import.get("Calle");
				String altura = solicitudes_import.get("Numero");
				String cp = solicitudes_import.get("Código Postal");
				String localidad = solicitudes_import.get("Localidad");
				String provincia = solicitudes_import.get("Provincia");
				
				//System.out.println(id + " - " + calle + " - " + altura + " - "+ cp + " - " + localidad + " - " + provincia);
				
				//Valido que el ID sea un número, sino lo es, asigno cero
				try{
					idInt = Integer.valueOf(id);
				}catch (Exception e) {
					idInt = 0;
				}
								
				//Valido que la altura sea un número, sino lo es, asigno cero
				try{
					alturaInt = Integer.valueOf(altura);
				}catch (Exception e) {
					alturaInt = 0;
				}
				
				//Valido que el CP sea un número, sino lo es, asigno cero
				try{
					cpInt = Integer.valueOf(cp);
				}catch (Exception e) {
					cpInt = 0;
				}
				
				if(idInt>=3300 && DAOSolicitud.getInstancia().getSolicitud(idInt)==null){				
					Solicitud aux = new Solicitud(Integer.valueOf(id), calle, alturaInt, cpInt, localidad, provincia);
					DAOSolicitud.getInstancia().guardarSolicitud(aux);
				}
			}
			
			solicitudes_import.close();
			System.out.println("Solicitudes importadas correctamente");
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public boolean importarCSV(String nombreArchivo) {
		try {
			
			//Borro el contenido de la lista de solicitudes
			List<Solicitud> solicitudes = new ArrayList<Solicitud>();
			
			CsvReader solicitudes_import = new CsvReader("C:/CPA/Subidas/"+nombreArchivo);
			solicitudes_import.readHeaders();
			//ID	Calle	Altura	CP	Localidad	Provincia
		
			while (solicitudes_import.readRecord()) {
				String id = solicitudes_import.get("ID");
				String calle = solicitudes_import.get("Calle");
				String altura = solicitudes_import.get("Altura");
				String cp = solicitudes_import.get("CP");
				String localidad = solicitudes_import.get("Localidad");
				String provincia = solicitudes_import.get("Provincia");
				//String cpa = solicitudes_import.get("CPA");
				
				System.out.println(id + " - " + calle + " - " + altura + " - "+ cp + " - " + localidad + " - " + provincia);
				
				solicitudes.add(new Solicitud(Integer.valueOf(id), calle, Integer.valueOf(altura), Integer.valueOf(cp), localidad, provincia));
			}

			solicitudes_import.close();
			
			if(!solicitudes.isEmpty()){
				return true;
			}
			
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			return false;
		} catch (IOException e) {
			e.printStackTrace();
			return false;
		}
		return false;
	}
	
	public void exportarCSV(List<Solicitud> solicitudes) {
	         
	        String outputFile = "C:/CPA/Excel/solicitudes_final.csv";
	        boolean alreadyExists = new File(outputFile).exists();
	         
	        if(alreadyExists){
	            File ArchivoEmpleados = new File(outputFile);
	            ArchivoEmpleados.delete();
	        }        
	         
	        try {
	 
	            CsvWriter csvOutput = new CsvWriter(new FileWriter(outputFile, true), ',');
	             
	            csvOutput.write("ID");
	            /*csvOutput.write("Calle");
	            csvOutput.write("Altura");
	            csvOutput.write("Localidad");
	            csvOutput.write("Provincia");*/
	            csvOutput.write("CP");
	            csvOutput.write("CPA");
	            //csvOutput.write("METODO");
	            csvOutput.endRecord();
	 
	            for (Solicitud solicitudes2 : solicitudes) {
	                csvOutput.write(String.valueOf(solicitudes2.getId()));
	                /*csvOutput.write(String.valueOf(solicitudes2.getCalle()));
	                csvOutput.write(String.valueOf(solicitudes2.getAltura()));
	                csvOutput.write(String.valueOf(solicitudes2.getLocalidad()));
	                csvOutput.write(String.valueOf(solicitudes2.getProvincia()));*/
	                csvOutput.write(String.valueOf(solicitudes2.getCp()));
	                csvOutput.write(solicitudes2.getCpa());
	                //csvOutput.write(solicitudes2.getMetodo());
	                csvOutput.endRecord();                   
	            }
	             
	            csvOutput.close();
	            System.out.println("Solicitudes exportadas correctamente");
	            
	            
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	 
	    }
	
	
}

	


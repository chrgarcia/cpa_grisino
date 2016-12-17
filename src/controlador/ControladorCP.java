package controlador;
import java.util.List;

import com.google.maps.GeoApiContext;
import com.google.maps.GeocodingApi;
import com.google.maps.model.AddressComponent;
import com.google.maps.model.GeocodingResult;

import dao.DAO;
import negocio.Solicitud;


public class ControladorCP {

	private static ControladorCP instancia = null;
	
	public static ControladorCP getInstancia(){
		if(instancia==null){
			instancia =  new ControladorCP();
		}
		return instancia;
	}
	
	
	/* GET CPA DESDE UNA SOLICITUD - Busqueda en ambos Sistemas Google y Correo Argentino 
	 * Recibe como parametro el archivo de datos */
	
	public String getCPA(Solicitud s) throws Exception{
		
		String resultadoCA = ControladorCP.getInstancia().getCPACA(s.getCp(), s.getCalle(),s.getAltura());
			
		if(!resultadoCA.equals("SIN CPA")){
			return resultadoCA;
		}else{
			
			String resultadoGoogle = ControladorCP.getInstancia().consultaCPAGoogle(s.getCalle()+" "+s.getAltura()+", "+s.getLocalidad()+", "+s.getProvincia());
				
			if(!resultadoGoogle.equals("SIN CPA")){
				return resultadoGoogle;
			}else{
				return "SIN CPA";
			}
		}
	}
	
	
	
	/* Get CPA - Busqueda en la base de Correo Argentino */
	public String getCPACA(int cp, String calle, int altura){

		List<Object[]> list = DAO.getInstancia().getCPA(cp, calle, altura);
		if(list.size() == 2){
			if(altura%2 == 0){
				//Es Par
				return (String) list.get(1)[1];
			}else{
				//Es Impar
				return (String) list.get(0)[1];
			}
		}else{
			return "SIN CPA";
		}
	}
	
	
	/* Busco CPA en base de correo argentino */
	public String consultaCPAGoogle(String direccion) throws Exception {
		
		/* Replace the API key below with a valid API key.
		GeoApiContext context = new GeoApiContext().setApiKey("YOUR_API_KEY");
		GeocodingResult[] results =  GeocodingApi.geocode(context,
		    "1600 Amphitheatre Parkway Mountain View, CA 94043").await();
		System.out.println(results[0].formattedAddress);*/
		
		String cpa = "SIN CPA";
		String sufijo = null;
		String prefijo = null;
		
		//Request WebSite
		GeoApiContext context = new GeoApiContext().setApiKey("AIzaSyBbkL6G4gv9wUTNoOZ29zJxlL6Jx0EEd4w");
		GeocodingResult[] results =  GeocodingApi.geocode(context,direccion).await();
		
		try{
		for (GeocodingResult geocodingResult : results) {
			AddressComponent[] componente = geocodingResult.addressComponents;
			for(int i=0; i<componente.length; i++){
				AddressComponent a = geocodingResult.addressComponents[i];
				
				//Si existe Postal Code
				if(a.types[0].toString().equals("postal_code")){
					//System.out.println(a.longName);
					sufijo = a.longName;
				}
				if(a.types[0].toString().equals("postal_code_suffix")){
					prefijo = a.longName;
				}

			}
		}
		}catch (Exception e) {
			e.printStackTrace();
		}		
		
		if(sufijo!=null && prefijo!=null){
			return sufijo+prefijo;
		}
		
		return cpa;
		
	}
	
	
}

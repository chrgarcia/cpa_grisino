package Test;

import javax.swing.JOptionPane;

import controlador.Sistema;

class BuscadorCPA {
    public static void main(String arglist[]) {
   
    	try{
    			int contador = Sistema.getInstancia().actualizarSolicitudes();
        		int encontradas = Sistema.getInstancia().buscarCPASolicitudes();
        		Sistema.getInstancia().exportarCSV();
        		JOptionPane.showMessageDialog(null, "Busqueda CPA Correcta!. Nuevas solicitudes: "+contador+", con CPA: "+encontradas+". Exportada a CSV.");
        		
        	}catch (Exception e) {
				e.printStackTrace();
			}
        }
    
}
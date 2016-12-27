package Test;

import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

import controlador.Sistema;

class TimerEx {
    public static void main(String arglist[]) {
    
    	Timer timer;
    timer = new Timer();

    TimerTask task = new TimerTask() {
        int tic=0;

        @Override
        public void run(){
        	try{
        		System.out.println("------------------------------------------------------------");
        		System.out.println("Fecha: "+new Date());
        		Sistema.getInstancia().actualizarSolicitudes();
        		Sistema.getInstancia().buscarCPASolicitudes();
        		Sistema.getInstancia().exportarCSV();
        		System.out.println("------------------------------------------------------------");
        	}catch (Exception e) {
				e.printStackTrace();
			}
        }
        };
        
        // 10ms y luego lanzamos la tarea cada 5 minutos
    timer.schedule(task, 10, 300000);
    }
}
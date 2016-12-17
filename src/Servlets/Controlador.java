package Servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.rmi.RemoteException;
import java.sql.Date;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.taglibs.standard.tag.common.core.ForEachSupport;

import controlador.Sistema;

@WebServlet("/Controlador")

public class Controlador extends HttpServlet {

	private static final long serialVersionUID = 1087702007634924546L;
	
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
    	
			Controlador c = new Controlador();
    	
        	String action = request.getParameter("action");
        	String jspPage = "/index.jsp";
        	
        	switch(action){

	        	case("buscarCPA"):{
        		
		            String calle = request.getParameter("calle");
		            int altura = Integer.valueOf(request.getParameter("altura"));
		            int cp = Integer.valueOf(request.getParameter("cp"));
		            String localidad = request.getParameter("localidad");
		            String provincia = request.getParameter("provincia");
    
		            String resultado = "";
					try {
						resultado = Sistema.getInstancia().getCPAUnico(cp, calle, altura, localidad, provincia);
					} catch (Exception e) {
						e.printStackTrace();
					}
		            
		            request.setAttribute("resultado", resultado);
	        		dispatch ("/mostrarResultado.jsp",request,response);

		            break;
	        	}
	        	
	        	
	        	
	        	
	        	
        	}
        	
        	
     	}
	        	
    
        protected void dispatch(String jsp, HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
            if (jsp != null)
            {
            	/*Envía el control al JSP que pasamos como parámetro, y con los 
            	 * request / response cargados con los parámetros */
                RequestDispatcher rd = request.getRequestDispatcher(jsp);
                rd.forward(request, response);
            }
        }

        protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
          	doPost(request, response);     		
	
        }
        	
       
        

        
    

        
}

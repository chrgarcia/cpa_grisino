package Servlets;

import java.io.File;
import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.tomcat.util.http.fileupload.FileItem;
import org.apache.tomcat.util.http.fileupload.disk.DiskFileItemFactory;
import org.apache.tomcat.util.http.fileupload.servlet.ServletFileUpload;
import org.apache.tomcat.util.http.fileupload.servlet.ServletRequestContext;

import controlador.Sistema;

/**
 * Servlet implementation class ControladorArchivos
 */
@WebServlet("/ControladorArchivos")
public class ControladorArchivos extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ControladorArchivos() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try{
		
		File destino = new File("C:\\CPA\\Subidas\\");
		ServletRequestContext src = new ServletRequestContext(request);
 
		if(ServletFileUpload.isMultipartContent(src)){
			DiskFileItemFactory factory = new DiskFileItemFactory((1024*1024),destino);
			ServletFileUpload upload = new  ServletFileUpload(factory);
 
			java.util.List lista = upload.parseRequest(src);
			File file = null;
			java.util.Iterator it = lista.iterator();
 
			while(it.hasNext()){
				FileItem item=(FileItem)it.next();
				if(item.isFormField()){
					//out.println(item.getFieldName()+"<br>");
				}else{
					file=new File(item.getName());
					item.write(new File(destino,file.getName()));
					//out.println("Fichero subido");
					if(Sistema.getInstancia().getCPAdesdeCSV(item.getName())){
						request.setAttribute("solicitudes", Sistema.getInstancia().getSolicitudes());
		        		dispatch ("/mostrarSolicitudes.jsp",request,response);
						
						
					}else{
						response.sendRedirect("./subidaError.jsp");
					}
				} 
			}
		}
		
		
		
		}catch (Exception e) {
			e.printStackTrace();
		}
		

		
	}
	
    protected void dispatch(String jsp, HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        if (jsp != null){
        	RequestDispatcher rd = request.getRequestDispatcher(jsp);
            rd.forward(request, response);
        }
    }


}



import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

/**
 * Servlet implementation class ActualizarPartido
 */
@WebServlet("/ActualizarPartido")
@MultipartConfig
public class ActualizarPartido extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ActualizarPartido() {
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
	private String obtenerNombreFichero (Part part)
	{
		String nombre = null;
		
			for (String cd : part.getHeader("content-disposition").split(";"))
			{
				if (cd.trim().startsWith("filename"))
				{
					String filename = 
					cd.substring(cd.indexOf('=')+1).trim().replace("\"", "");
					nombre
					=filename.substring(filename.lastIndexOf('/')+1)
					.substring(filename.lastIndexOf('\\')+1);
				}
			}
		
		return nombre;
	}
	
	private void guardarFichero (Part fichero, String nombrefichero) throws Exception
	{
		String ruta_serv = getServletContext().getRealPath("");
		File server_file = new File (ruta_serv + File.separator + nombrefichero);
		byte[] buffer_read = new byte[1024];
		
		try (BufferedInputStream bis = 
			new BufferedInputStream(fichero.getInputStream()); 
			BufferedOutputStream bos = 
			new BufferedOutputStream(new FileOutputStream(server_file)))
		{
			int bytesleidos = 0;
			
			while ((bytesleidos= bis.read(buffer_read))!=-1)
			{
				bos.write(buffer_read, 0, bytesleidos);
			}
		}
	}
	
	
	private boolean formatoFicheroValido (String nombre_fichero)
	{
		//TODO COMPROBAR QUE NOMBRE_FICHERO ACABA EN JPG
		return true;
	}
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Recoger los datos de la web
		String goll = request.getParameter("goll");
		String golv = request.getParameter("golv");
		String minuto = request.getParameter("minuto");
		String comentario = request.getParameter("comentario");
		
		//TODO GUARDAR LOS DATOS
		int goles_local = Integer.parseInt(goll);
		int goles_visitante = Integer.parseInt(golv);
		Marcador marcador_nuevo = new Marcador(goles_local, goles_visitante);
		ConsultarResultado.actualizarMarcador(marcador_nuevo);
		
		int minuto_int = Integer.parseInt(minuto);
		Comentario comentario_nuevo = new Comentario(minuto_int, comentario);
		ConsultarResultado.actualizarComentarios(comentario_nuevo);
		
		//PROCESAR LA SUBIDA DEL FICHERO
		Part filePart = null;
		String nombre_fichero = null;
		
		filePart = request.getPart("file");
		nombre_fichero = obtenerNombreFichero (filePart);
		
		if (formatoFicheroValido (nombre_fichero))
		{
			try {
				guardarFichero (filePart, nombre_fichero);
				ConsultarResultado.actualizarFoto(nombre_fichero);
				
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				throw new ServletException();
			}
			
		}
		
	}

}



import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

/**
 * Servlet implementation class ActualizarInfoPartido
 */
@WebServlet("/ActualizarInfoPartido")
public class ActualizarInfoPartido extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ActualizarInfoPartido() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//TODO Obtener la �ltima infor del partido
		// y devolver un JSON de ella
		Marcador marcador = ConsultarResultado.obtenerLastMarcador();
		List<Comentario> lista =  ConsultarResultado.getListaComentarios();
		String fotopartido = ConsultarResultado.obtenerUltimaFoto();
		
		InfoPartido info = new InfoPartido(marcador, lista, fotopartido);
		
		Gson gson = new Gson();
		String infojson = gson.toJson(info);
		
		PrintWriter pw = response.getWriter();
		pw.write(infojson);
		response.setContentType("application/json");
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
	}

}

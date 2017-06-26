

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ConsultarResultado
 */
@WebServlet("/ConsultarResultado")
public class ConsultarResultado extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static List<Comentario> lista_comentarios = null;
	private static Marcador marcador = null;
	private static Imagen imagen = null;
       
	
	public static void actualizarMarcador (Marcador marcador_nuevo)
	{
		marcador = marcador_nuevo;
	}
	
	public static void actualizarComentarios (Comentario comentario_nuevo)
	{
		lista_comentarios.add(comentario_nuevo);
	}
	
	public static Marcador obtenerLastMarcador ()
	{
		return marcador;
	}
	
	public static List<Comentario> getListaComentarios ()
	{
		return lista_comentarios;
	}
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ConsultarResultado() {
        super();
        // TODO Auto-generated constructor stub
    }

    @Override
    public void init() throws ServletException {
    	// TODO Auto-generated method stub
    	super.init();
    	
    	Comentario comentario = new Comentario(1, "Empieza el partido");
    	lista_comentarios = new ArrayList<Comentario>();
    	lista_comentarios.add(comentario);
    	
    	marcador = new Marcador(0, 0);
    	imagen = new Imagen("inicio.jpg");
    }
    
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
	
		request.setAttribute("imagen", imagen);
		request.setAttribute("marcador", marcador);
		request.setAttribute("comentario", lista_comentarios.get(0));
		
		request.getRequestDispatcher("resultado.jsp").forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
}









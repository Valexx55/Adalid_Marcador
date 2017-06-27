import java.util.List;

public class InfoPartido {
	//BEAN POJO PLAIN OLD JAVA OBJECT
	
	private Marcador marcador;
	private List<Comentario> listacomentarios;
	private String fotopartido;
	
	public InfoPartido(Marcador marcador, List<Comentario> listacomentarios, String fotopartido) {
		super();
		this.marcador = marcador;
		this.listacomentarios = listacomentarios;
		this.fotopartido = fotopartido;
	}
	public String getFotopartido() {
		return fotopartido;
	}
	public void setFotopartido(String fotopartido) {
		this.fotopartido = fotopartido;
	}
	public Marcador getMarcador() {
		return marcador;
	}
	public void setMarcador(Marcador marcador) {
		this.marcador = marcador;
	}
	public List<Comentario> getListacomentarios() {
		return listacomentarios;
	}
	public void setListacomentarios(List<Comentario> listacomentarios) {
		this.listacomentarios = listacomentarios;
	}
	public InfoPartido(Marcador marcador, List<Comentario> listacomentarios) {
		super();
		this.marcador = marcador;
		this.listacomentarios = listacomentarios;
	}
	
	

}

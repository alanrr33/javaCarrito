package libros;

public class Ejemplares extends Libros{
	private String tipouso;
	private boolean disponibilidad;
	
	public Ejemplares() {
		
	}
	
	

	public Ejemplares(String tipouso,boolean disponibilidad) {
		this.tipouso=tipouso;
		this.disponibilidad=disponibilidad;
		
	}



	public boolean isDisponibilidad() {
		return disponibilidad;
	}



	public void setDisponibilidad(boolean disponibilidad) {
		this.disponibilidad = disponibilidad;
	}



	public String getTipouso() {
		return tipouso;
	}



	public void setTipouso(String tipouso) {
		this.tipouso = tipouso;
	}
	
	public void imprimirEjemplar() {
		System.out.println(this.getNombre());
		System.out.println(this.getDescripcion());
		System.out.println(this.getIsbn());
		System.out.println(this.tipouso);
		System.out.println(this.disponibilidad);
	}
	

}

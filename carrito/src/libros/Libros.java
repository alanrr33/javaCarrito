package libros;

import java.sql.Date;

public class Libros {
	

	private Integer isbn;
	private String nombre;
	private String descripcion;


	public Libros() {
		
	}
	
		public Libros (Integer isbn, String nombre,String descripcion ) {
			
		
		this.isbn=isbn;
		this.nombre=nombre;
		this.descripcion=descripcion;
		
		
			
		}
		
		
	public void imprimirLibro() {
			
			System.out.println("ISBN: "+this.isbn);
			System.out.println("Nombre: "+this.nombre);
			System.out.println("Descripcion: "+this.descripcion);
		
		}

		
		// getters & setters

	

		public String getNombre() {
			return nombre;
		}

		public void setNombre(String nombre) {
			this.nombre = nombre;
		}

		public Integer getIsbn() {
			return isbn;
		}

		public void setIsbn(Integer isbn) {
			this.isbn = isbn;
		}

	

		public String getDescripcion() {
			return descripcion;
		}

		public void setDescripcion(String descripcion) {
			this.descripcion = descripcion;
		}

	

		
		
		
		
		
		
		
		
		
	

}

package socios;

public class socioPND extends Socios {

	public socioPND() {
		setCat("Personal no Docente");
	}
	
	public socioPND(String nombre, String apellido, String dni, String direccion, String email,
			String  telefono, String  categoria, String  fechaalta, int cantMaxLibros, int cantLibros, int libro_1,
			int  libro_2, int  libro_3, int  libro_4, int  libro_5) {
		super( nombre,  apellido,  dni,  direccion,  email,  telefono,  categoria,  fechaalta,  cantMaxLibros,
				 cantLibros,  libro_1,  libro_2,  libro_3,  libro_4,  libro_5);
		// TODO Auto-generated constructor stub
		
		
	}
	
	
		
	
	public void imprimirPnD() {
		
		
		
		System.out.println("Nombre: "+getNombre());
		System.out.println("Apellido: "+getApellido());
		System.out.println("Dni: "+getDni());
		System.out.println("Direccion: "+getDireccion());
		System.out.println("Email: "+getEmail());
		System.out.println("Telefono: "+getTel());
		System.out.println("Categoria: "+getCat());
		System.out.println("CML: "+getCantML());
		System.out.println("CL: "+getCantL());
		System.out.println("Libro 1: "+getLibro_1());
		System.out.println("Libro 2: "+getLibro_2());
		System.out.println("Libro 3: "+getLibro_3());
		System.out.println("Libro 4: "+getLibro_4());
		System.out.println("Libro 5: "+getLibro_5());
		
		
		
		
	}

}

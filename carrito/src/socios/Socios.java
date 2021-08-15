package socios;

import java.util.Date;

public class Socios {
	
	
	
	private String nombre;
	private String apellido;
	private String dni;
	private String direccion;
	private String email;
	private String telefono;
	private String categoria;
	private String fechaalta;

	private int cantMaxLibros;
	private int cantLibros;
	private int libro_1;
	private int libro_2;
	private int libro_3;
	private int libro_4;
	private int libro_5;
	
	

	public Socios() {
		
	
	}
	
	public Socios(String nombre,String apellido, String dni, String direccion,String email, String telefono, String categoria,String fechaalta,int cantMaxLibros,int cantLibros,int libro_1,int libro_2,int libro_3,int libro_4,int libro_5 ){
		
		
		this.nombre=nombre;
		this.apellido=apellido;
		this.dni=dni;
		this.direccion=direccion;
		this.email=email;
		this.telefono=telefono;
		this.categoria=categoria;
		this.fechaalta=fechaalta;
		this.cantMaxLibros=cantMaxLibros;
		this.cantLibros=cantLibros;
		this.libro_1=libro_1;
		this.libro_2=libro_2;
		this.libro_3=libro_3;
		this.libro_4=libro_4;
		this.libro_5=libro_5;
		
	
		
		
		
		
	}
	
	public void imprimirSocios() {
		
		System.out.println("Nombre: "+this.nombre);
		System.out.println("Apellido: "+this.apellido);
		System.out.println("Dni: "+this.dni);
		System.out.println("Direccion: "+this.direccion);
		System.out.println("Email: "+this.email);
		System.out.println("Telefono: "+this.telefono);
		System.out.println("Categoria: "+this.categoria);
		System.out.println("CML: "+this.cantMaxLibros);
		System.out.println("CL: "+this.cantLibros);
		
		
		
	}
	
	
	// getters

	
	public String getNombre () {
		return nombre;
	}
	
	public String getApellido() {
		return apellido;
	}
	
	public String getDni() {
		return dni;
	}
	
	public String getDireccion() {
		return direccion;
	}
	
	public String getEmail() {
		return email;
	}
	
	public String getTel() {
		return telefono;
	}
	
	public String getCat() {
		return categoria;
	}
	
	public int getCantML() {
		return cantMaxLibros;
	}
	
	public int getCantL() {
		return cantLibros;
	}
	
	//setters
	

	
	public void setNom(String nombre) {
		this.nombre=nombre;
	}
	
	public void setApe(String apellido) {
		this.apellido=apellido;
	}
	
	public void setDni(String dni) {
		this.dni=dni;
	}
	
	public void setDir(String direccion) {
		this.direccion=direccion;
	}
	
	public void setEmail(String email) {
		this.email=email;
	}
	
	public void setTel(String telefono) {
		this.telefono=telefono;
	}
	
	public void setCat(String categoria) {
		this.categoria=categoria;
	}
	
	public void setCML(int cantMaxLibros) {
		this.cantMaxLibros=cantMaxLibros;
	}
	
	public void setCantL(int cantLibros) {
		this.cantLibros=cantLibros;
		
	}

	public int getLibro_1() {
		return libro_1;
	}

	public void setLibro_1(int libro_1) {
		this.libro_1 = libro_1;
	}

	public int getLibro_2() {
		return libro_2;
	}

	public void setLibro_2(int libro_2) {
		this.libro_2 = libro_2;
	}

	public int getLibro_3() {
		return libro_3;
	}

	public void setLibro_3(int libro_3) {
		this.libro_3 = libro_3;
	}

	public int getLibro_4() {
		return libro_4;
	}

	public void setLibro_4(int libro_4) {
		this.libro_4 = libro_4;
	}

	public int getLibro_5() {
		return libro_5;
	}

	public void setLibro_5(int libro_5) {
		this.libro_5 = libro_5;
	}

	public String getFechaalta() {
		return fechaalta;
	}

	public void setFechaalta(String fechaalta) {
		this.fechaalta = fechaalta;
	}
	

	
}

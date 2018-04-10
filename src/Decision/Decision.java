package Decision;


import java.util.ArrayList;

public class Decision {

	
	private ArrayList<Infor> opciones;
	private String nombre;
	
	public Decision(String nombre) {
		
		this.nombre=nombre;
		opciones = new ArrayList<Infor>();
		
	}
	
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public ArrayList<Infor> getopcioness() {
		return opciones;
	}
	public void setopciones(ArrayList<Infor>opciones) {
		this.opciones = opciones;
	}
	
	
}

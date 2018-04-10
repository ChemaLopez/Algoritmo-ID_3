package Decision;

import java.util.ArrayList;

public class Atributo {

	private ArrayList<Decision>  opciones;
	private String nombre;
	
	public Atributo(String nombre) {
		opciones = new ArrayList<Decision>();
		this.nombre = nombre;
	}
	
	

	

	public ArrayList<Decision> getOpciones() {
		return opciones;
	}




	public void setAtributo(ArrayList<Decision> opciones) {
		this.opciones = opciones;
	}
	
	
	public void addOpcion(String opcion){
		
		
		Decision op = new Decision(opcion);
		this.opciones.add(op);
	
		
		
	}
	
	
	
	public String getName(){
		
		return nombre;
	}
}

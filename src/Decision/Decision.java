package Decision;


import java.util.ArrayList;

public class Decision {

	
	private ArrayList<Infor> listaAtributos;
	private String nombre;
	
	
	public Decision(String nombre) {
		
		this.nombre=nombre;
		listaAtributos = new ArrayList<Infor>();
		
	}
	
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public ArrayList<Infor> getListaAtributos() {
		return listaAtributos;
	}
	public void setListaAtributos(ArrayList<Infor> listaAtributos) {
		this.listaAtributos = listaAtributos;
	}
	
	
}

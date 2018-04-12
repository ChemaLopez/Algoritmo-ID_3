package Decision;

import java.util.HashMap;


public class Atributo {

	private HashMap<String,Integer> p;
	private HashMap<String, Integer> s;
	private String nombre;
	
	public Atributo(String nombre) {
		this.nombre = nombre;
		p = new HashMap<String, Integer>();
		s = new HashMap<String, Integer>();

	}
	
	

	
	
	
	public void addElement(String opcion, boolean v){
		if(v){
			if(p.containsKey(opcion))
				p.put(opcion, p.get(opcion)+1);
			else
				p.put(opcion,1);
		}else{
			if(s.containsKey(opcion))
				s.put(opcion, s.get(opcion)+1);
			else
				s.put(opcion,1);

		}
	}

	
	public String getP(){
		
		String cadena="";
		
		cadena=p.toString()+" "+s.toString();
		
		return cadena;
		
		
	}
	
	public String getName(){
		
		return nombre;
	}
}

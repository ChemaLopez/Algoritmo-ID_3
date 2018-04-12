package Decision;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;


public class Atributo {

	private HashMap<String,Double> p;
	private HashMap<String, Double> s;
	private HashMap<String, Integer> n;
	private int total;
	private String nombre;
	
	public Atributo(String nombre) {
		this.nombre = nombre;
		p = new HashMap<String, Double>();
		s = new HashMap<String, Double>();
		n = new HashMap<String, Integer>();

	}
	
	

	
	
	
	public void addElement(String opcion, boolean v){
		if(v){
			if(p.containsKey(opcion))
				p.put(opcion, p.get(opcion)+1.0);
			else
				p.put(opcion,1d);
		}else{
			if(s.containsKey(opcion))
				s.put(opcion, s.get(opcion)+1.0);
			else
				s.put(opcion,1d);

		}
		
	}

	
	public void actualiza(){
		
		Set<String> llavero= new HashSet(p.keySet());
		for(String clave :s.keySet()) {
			
			if(!llavero.contains(clave)) {
				
				llavero.add(clave);
			}
		}
		
 		for(String clave : llavero){
			if(p.containsKey(clave) && s.containsKey(clave)) {
			 total+=(p.get(clave).intValue()+s.get(clave).intValue());
			 	n.put(clave,p.get(clave).intValue()+s.get(clave).intValue());
				p.put(clave, p.get(clave)/total);
				s.put(clave, s.get(clave)/total);
				
			}
			else
				if(p.containsKey(clave)) {
					total+=p.get(clave).intValue();
				 	n.put(clave,p.get(clave).intValue());
					p.put(clave, p.get(clave)/total);
				}
				else {
					total+=s.get(clave).intValue();
				 	n.put(clave, s.get(clave).intValue());
					s.put(clave, s.get(clave)/total);

				}

		}
		
	}
	
	public String getP(){
		
		String cadena="";
		
		cadena=p.toString()+" "+s.toString() +" "+n.toString()+" "+ total;
		
		return cadena;
		
		
	}
	
	public String getName(){
		
		return nombre;
	}
}

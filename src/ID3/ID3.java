package ID3;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
 
import Decision.Atributo;
import Decision.Nodo;

public class ID3 {

	private ArrayList<Atributo> listaAtributos;
	private ArrayList<ArrayList<String[]>> entradas;
	
	
	public ID3(){
		listaAtributos = new ArrayList<Atributo>();
		entradas = new ArrayList<ArrayList<String[]>>();
		
		entradas.add(new ArrayList<String[]>());
		entradas.add(new ArrayList<String[]>());

	}

	
	public void leerListaAtributos(String archivo) throws IOException{
		
		String currentDir = new File("").getAbsolutePath();
	
	    File newFile = new File(currentDir,archivo);
		
		String cadena;
		FileReader lector = new FileReader(newFile);
		BufferedReader buffer = new BufferedReader(lector);
		 
		//LEER EL ARCHIVO HASTA EL FINAL DE ARCHIVO
		while((cadena = buffer.readLine())!=null) {
			//PARSEAR CADA LINEA
			String op[] = cadena.split(",");
			for(String decision : op) {
				
				Atributo nuevoAtributo = new Atributo(decision);
				listaAtributos.add(nuevoAtributo);
			}
		
		
			
		}
		      buffer.close();
		
	}
	
	
	
	
public void leerOpciones(String archivo) throws IOException{
		
		String currentDir = new File("").getAbsolutePath();
	
	    File newFile = new File(currentDir,archivo);
		
		String cadena;
		FileReader lector = new FileReader(newFile);
		BufferedReader buffer = new BufferedReader(lector);
		String solucion="";

		//LEER EL ARCHIVO HASTA EL FINAL DE ARCHIVO
		while((cadena = buffer.readLine())!=null) {
			//PARSEAR CADA LINEA
			String op[] = cadena.split(",");
			int i =0;
			if(solucion=="") {
				solucion=op[op.length-1];				
			}
			for(String decision : op) {
				if(op[op.length-1].compareTo(solucion)==0)
					listaAtributos.get(i).addElement(decision,false);
				else
					listaAtributos.get(i).addElement(decision,true);

				i++;
			}
		
			
		}
		      buffer.close();
			     System.out.println(toString());

		     for( Atributo atr : listaAtributos) {
		    	 if(atr!=listaAtributos.get(listaAtributos.size()-1)){
		    		 atr.actualiza();
		    	 }
		     
		     }
		     System.out.println(toString());
		     listaAtributos.remove(listaAtributos.size()-1);
		     
		    Nodo mejor= actualizaLista(listaAtributos);

		    recursividadTotal(mejor, listaAtributos);
		    
		    System.out.println("aqui");
}
	




private Nodo actualizaLista(ArrayList<Atributo> lista){
	Atributo atrMejor = lista.get(0);
	double meritoMejor=Double.MAX_VALUE;
	for(Atributo atr: lista){

		double aux= atr.getMerito();
		if(aux<meritoMejor){
			meritoMejor=aux;
			atrMejor=atr;
		}
	}
	
	Nodo mejor= new Nodo(new ArrayList<Nodo>(), atrMejor.getPositivos(), atrMejor.getNegativos(), 0, atrMejor.getMerito(), atrMejor.getName());
	
	for(String atr: atrMejor.getClaves()){
		Nodo aux= new Nodo(new ArrayList<Nodo>(), atrMejor.getPositivos(atr), atrMejor.getNegativos(atr), atrMejor.getNum(atr), atrMejor.getMerito(atr), atr);
		mejor.addHijo(aux);
	}

	
	return mejor;
}








private void recursividadTotal(Nodo mejor, ArrayList<Atributo> atributos){
	ArrayList<Atributo> aux = new ArrayList<Atributo>();
	
	if(atributos.size() == 1){
		for(Nodo hijo: mejor.getHijos()){
			if(hijo.getPositivos() > 0 && hijo.getNegativos() == 0){
				hijo.addHijo(new Nodo("SI"));
			} else if (hijo.getNegativos() > 0 && hijo.getPositivos() == 0){
				hijo.addHijo(new Nodo("NO"));
			} 
		}		
	}
	else{
		// Quitamos el mejor anterior
		for(int i = 0; i < atributos.size(); i++){
			if(!atributos.get(i).getName().equals(mejor.getNombre()))
				aux.add(atributos.get(i));
		}
		
		for(Nodo hijo: mejor.getHijos()){
			//ELIMINAR LOS EJEMPLOS DE 
	
			if(hijo.getPositivos() > 0 && hijo.getNegativos() == 0){
				hijo.addHijo(new Nodo("SI"));
			} else if (hijo.getNegativos() > 0 && hijo.getPositivos() == 0){
				hijo.addHijo(new Nodo("NO"));
			} else {	
				Nodo nuevoMejor = actualizaLista(aux);		
				hijo.addHijo(nuevoMejor);
				recursividadTotal(nuevoMejor, aux);
			}	
			
			
		}		
	}		
}




public String toString() {
	
	String cadena="";
	
	
	for(Atributo atributo :listaAtributos){
			cadena+=' '+atributo.getName();
			cadena+=' '+ atributo.getP();
		cadena+=("\n");
	}
	
	
	return cadena;
}


	
}

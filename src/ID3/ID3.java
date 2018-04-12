package ID3;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Map;

import Decision.Atributo;
import Decision.Decision;

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
					listaAtributos.get(i).addElement(decision,true);
				else
					listaAtributos.get(i).addElement(decision,false);

				i++;
			}
		
			
		}
		      buffer.close();
		
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

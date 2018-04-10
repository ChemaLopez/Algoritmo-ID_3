package Decision;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class ListaAtributos {

	private ArrayList<Decision>  atributos;
	
	
	public ListaAtributos() {
		atributos = new ArrayList<Decision>();
		
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
				
				Decision nuevoAtributo = new Decision("decision");
			
				atributos.add(nuevoAtributo);
				
			}
			
		}
		      buffer.close();
		
	}
}

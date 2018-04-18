package main;

import java.io.IOException;

import Decision.Nodo;
import GUI.VistaPrincipal;
import ID3.ID3;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	
		ID3 id3 = new  ID3();
		Nodo arbol;
		
		try {
			id3.leerListaAtributos("AtributosJuego.txt");
			arbol= id3.leerOpciones("Juego.txt");
			
			
			VistaPrincipal vista = VistaPrincipal.getInstance();
			
		
			vista.setArbol(arbol);
			
			
			vista.initView();
			vista.setVisible(true);
			System.out.println(id3.toString());
		
		
		}catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
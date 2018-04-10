package main;

import java.io.IOException;

import ID3.ID3;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	
		ID3 id3 = new  ID3();
		
		
		try {
			id3.leerListaAtributos("AtributosJuego.txt");
			id3.leerOpciones("Juego.txt");
			
			
			System.out.println(id3.toString());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
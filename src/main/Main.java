package main;

import java.io.IOException;

import Decision.ListaAtributos;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

			ListaAtributos lista = new ListaAtributos();
			
			
			try {
				
				lista.leerListaAtributos("AtributosJuego.txt");
			
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}



}
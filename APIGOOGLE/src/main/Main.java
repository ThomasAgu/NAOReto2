package main;

import java.io.IOException;
import apigoogle.Utils.ConexionDB;
import apigoogle.Views.Vista;

public class Main {
	
	public static Vista vista = new Vista();

	public static void main(String[] args) throws IOException, InterruptedException {
		// TODO Auto-generated method stub
		/* Estos metodos estan para crear la base de datos, crear las tablas si no existen. Y vaciarlas ya que cada 2 meses queremos nuevos articulos*/
		ConexionDB.createDataBase();
		ConexionDB.generarTablas();
		ConexionDB.vaciarTablas();
		vista.getAuthors();
		
	}

}

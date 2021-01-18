package Controlador;

import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Scanner;

import Modelo.Cliente;

public class ClaseSecundaria {
	static private String opc, opc2;
	static ArrayList<LocalDate> fechas=new ArrayList<LocalDate>();
	static ArrayList<String> fechas2 = new ArrayList<String>();
	private static String columna;
	private static int p;
	
	public static void opcionUno() {
		System.out.println("Ha seleccionado la opción uno: mostrar los clientes de la base de datos");
		System.out.println("A continuación se lista los clientes de la base de datos");
		CRUD.consultaSQL();
	}
	public static void opcionDos() throws SQLException {
		Scanner scan = new Scanner (System.in);
		Scanner scan2 = new Scanner (System.in);
		Scanner scan3 = new Scanner (System.in);
		String fechita;
		System.out.println("Ha seleccionado la opción dos: insertar los clientes de la base de datos");
		System.out.println("Nos encontramos en mantenimiento el usuario que se va a generar por defecto es:");
		System.out.println("Introduzca el nombre del cliente");
		String nombre = scan.nextLine();
		System.out.println("El nombre seleccionado es: " + nombre);
		System.out.println("Introduzca el primer apellido del cliente");
		String apellido1=scan.nextLine();
		System.out.println("El primer apellido seleccionado es: " + apellido1);
		System.out.println("Introduzca el segundo apellido del cliente");
		String apellido2=scan.nextLine();
		System.out.println("El segundo apellido seleccionado es: " + apellido2);
		System.out.println("Introduzca el comercial que atiende al cliente");
		String comercial=scan.nextLine();
		System.out.println("El comercial seleccionado es: " + comercial);
		System.out.println("Introduzca la ID de la empresa");
		int idempresa=scan.nextInt();
		System.out.println("La ID de empresa seleccionada es: " + idempresa);
		int j=0;
		do {
			System.out.println("Introduzca la fecha de visita del cliente con el siguiente formato (yyyy-mm-dd)");
			fechita=scan2.nextLine();
			fechas2.add(fechita);
			System.out.println(fechas2.get(j));
			j++;
			System.out.println("¿Quieres introducir más visitas al cliente " + nombre + "?");
			opc=scan3.nextLine();
		}while(opc.equalsIgnoreCase("y"));
		System.out.println("Las fechas seleccionadas son: \n");
		for(int k=0; k<j; k++) {
			System.out.println(fechas2.get(k));
		}
		int y=0;
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-d");
		for(int k=0; k<j;k++) {
			String date = fechas2.get(k);
			 fechas.add(LocalDate.parse(date, formatter));
			 System.out.println(fechas.get(k));
			y++;
		}
		Cliente cliente2 = new Cliente (nombre, apellido1, apellido2, comercial, idempresa, fechas);
		CRUD.insertaSQL(cliente2);
		fechas.clear();
		fechas2.clear();
	}
	public static void opcionTres() throws SQLException{
		Scanner scan4 = new Scanner (System.in);
		int p=0;
		System.out.println("Has escogido la tercera opción: Eliminar un cliente a partir de su idcliente");
		System.out.println("Por favor, introduzca la id del cliente que desea borrar. La idcliente son números enteros");
		p=scan4.nextInt();
		System.out.println("La idcliente que ha introducido es: " + p);
		System.out.println("Has continuación se procederá a conectarse a la base de datos y borrar el cliente con idcliente: " + p);
		CRUD.borrarFilaSQL(p);
		}
	public static void opcionCuatro() throws SQLException{
		Scanner scan5 = new Scanner (System.in);
		Scanner scan6 = new Scanner (System.in);
		Scanner scan7 = new Scanner (System.in);
		int q=0;
		int p=0;
		System.out.println("Has escogido la cuarta opción: modificar una columna de un cliente a partir de su idcliente");
		System.out.println("Por favor, introduzca la id del cliente que desea borrar. La idcliente son números enteros");
		p=scan5.nextInt();
		System.out.println("La idcliente que ha introducido es: " + p);
		do{
			System.out.println("¿Qué dato quiere modificar del cliente con idcliente: " +p+ "?");
		
		System.out.println("Escriba el nombre del campo que desea modificar");
		System.out.println("Los diversos campos a modificar son: nombre apellido1 apellido2 comercial idempresa fechas");
		System.out.println("¿Cuál desea modificar?");
		columna=scan6.nextLine();
		if(columna.equalsIgnoreCase("nombre")) {
			System.out.println("El campo a modificar es: nombre");
			System.out.println("Introduzca el nuevo nombre");
			 String nombre=scan7.nextLine();
			System.out.println("Al cliente con id " + p + "se le cambiara el nombre a " + nombre);
			CRUD.modificarnombre( p, nombre);
			
		} else if (columna.equalsIgnoreCase("apellido1")) {
			System.out.println("El campo a modificar es: apellido1");
			System.out.println("Introduzca el nuevo apellido");
			String apellido1=scan7.nextLine();
			System.out.println("Al cliente con id " + p + "se le cambiara el apellido a " + apellido1);
			CRUD.modificarapellido1( p, apellido1);
			
		}else if (columna.equalsIgnoreCase("apellido2")) {
			System.out.println("El campo a modificar es: apellido2");
			System.out.println("Introduzca el nuevo apellido");
			String apellido2=scan7.nextLine();
			System.out.println("Al cliente con id " + p + "se le cambiara el apellido a " + apellido2);
			CRUD.modificarapellido2( p, apellido2);
			
		}else if (columna.equalsIgnoreCase("comercial")) {
			System.out.println("El campo a modificar es: comercial");
			System.out.println("Introduzca el nuevo comercial");
			String comercial=scan7.nextLine();
			System.out.println("Al cliente con id " + p + "se le cambiara el comercial a " + comercial);
			CRUD.modificarcomercial( p, comercial);
		}else if (columna.equals("idempresa")) {
			System.out.println("El campo a modificar es: idempresa");
			System.out.println("Introduzca la nueva idempresa");
			int idempresa=scan7.nextInt();
			System.out.println("Al cliente con id " + p + "se le cambiara la idempresa a " + idempresa);
			CRUD.modificaridempresa( p, idempresa);
		} else if (columna.equalsIgnoreCase("fechas")) {
			Scanner scan9= new Scanner(System.in);
			String fechita;
			System.out.println("El campo a modificar es: fechas");
			int n=0;
			do {
				System.out.println("Introduzca una nueva fecha con formato (yyyy-mm-dd)");
				fechita=scan7.nextLine();
				fechas2.add(fechita);
				n++;
				System.out.println("¿Quieres introducir más visitas al cliente con id" + p + "?");
				
				opc2=scan9.nextLine();
			}while(opc2.equalsIgnoreCase("y"));
			for(int k=0; k<n; k++) {
				System.out.println(fechas2.get(k));
			}
			int y=0;
			DateTimeFormatter formatter2 = DateTimeFormatter.ofPattern("yyyy-MM-d");
			for(int k=0; k<n;k++) {
				String date = fechas2.get(k);
				 fechas.add(LocalDate.parse(date, formatter2));
				y++;
			}
			System.out.println("Al cliente con id " + p + "se le cambiaran las fechas a " + fechas);
			CRUD.modificarfechas( p, fechas);
			fechas.clear();
			fechas2.clear();
			fechita="";
		}else {
			System.out.println("Ha ocurrido un error inesperado");
		}
		}while(!columna.equalsIgnoreCase("apellido1") ||!columna.equalsIgnoreCase("apellido1") || !columna.equalsIgnoreCase("apellido2") || !columna.equalsIgnoreCase("comercial") || !columna.equals("idempresa") || !columna.equalsIgnoreCase("fechas"));
		
		System.out.println("Has continuación se procederá a conectarse a la base de datos y borrar el cliente con idcliente: " + p);
		CRUD.borrarFilaSQL(p);
	}
public static void opcionCinco() throws SQLException{
	LocalDate date;
	String date2;
	Scanner scan8 = new Scanner(System.in);
	Scanner scan9 = new Scanner(System.in);
	Scanner scan10 = new Scanner(System.in);
	String opc3, fechita;
	int j=0;
	System.out.println("Ha elegido la opción cinco: desea añadir nuevas fechas de visita al cliente.");
	System.out.println("Escriba el idcliente del cliente al que desea añadir nuevas fechas de visita.");
	p=scan8.nextInt();
	do {
		System.out.println("Introduzca la fecha de visita del cliente con el siguiente formato (yyyy-mm-dd)");
		date2=scan9.nextLine();
		String sDate = "23/08/1999";
        //convirtiendolo a java.time.LocalDate
        date = LocalDate.parse(date2, DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        System.out.println("¿desea instroducir nuevas fechas?");
        opc3=scan9.nextLine();
		}while(opc3.equalsIgnoreCase("y"));
		CRUD.anadirfechas(date, p);
		fechas.clear();
		fechas2.clear();
		System.out.println("¿Quieres introducir más visitas al cliente con idcliente " + p + "?");
		opc3=scan10.nextLine();
	}
public static void opcionSeis() throws SQLException{
	System.out.println("La aplicación va a finalizar. Esperamos haber sido de ayuda.");
	System.exit(0);
	}
}

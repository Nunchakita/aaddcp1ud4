package Controlador;
import java.sql.*;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;

import Modelo.Cliente;
public class Conexion{
static Connection conexion1=null;
private static Connection conect;
private static ResultSet rs, rs2;
private static Statement secc;
private static PreparedStatement pst;
private StringBuilder stb = new StringBuilder();
	 public static Connection accesoBD(){
		 try{
			 // Se carga el driver postresql de la siguiente forma:
			 Class.forName("org.postgresql.Driver");
			 // Crear un objeto conexión:
			 conexion1 = DriverManager.getConnection ("jdbc:postgresql://localhost:5432/aaddcp1ud4","postgres", "laura");
			 System.out.println("Conexión establecida");
			 // Se crea un objeto de tipo Statement, para realizar la consulta:
			 secc = conexion1.createStatement();
		 }catch (Exception e){
			 e.printStackTrace();
		}
		 return conexion1;
	 }
	 
}
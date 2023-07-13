package PDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import Connessione.ConnessioneDB;
import GUI.ErroreAccesso;
import Model.Studente;

public class ImpStud {

	private Connection connection;
	
	public ImpStud() {
		try {
			connection = ConnessioneDB.getInstance().getConnection();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	//Controllo credenziali
	public boolean Controlla(Studente s) {
		String a=s.getPassword();
		String k=s.getUsername();
		
		try {
		PreparedStatement leggiup;
		
			leggiup = connection.prepareStatement(
					
			"SELECT * FROM studente where username='"+k+"'"+"AND password='"+a+"'");

			ResultSet rs = leggiup.executeQuery();
			if(rs.next()) {
				while (rs.next()) {
				if (rs.getString("username").equals(s.getUsername()) && rs.getString("password").equals(s.getPassword())) {
				rs.close();
				connection.close();
				}
				}
			}else throw new Exception();
			
		}catch(Exception e) {
			e.printStackTrace();
			return false;
			}
		
		return true;
		
		}
	
	//prendo mat di stud
	public int GetMat(Studente s)
	{
		String a=s.getPassword();
		String k=s.getUsername();
		
		
		PreparedStatement leggi;
		
		try {
			leggi = connection.prepareStatement(
					
					"SELECT matricola FROM studente where username='"+k+"'"+"AND password='"+a+"'");
			
			ResultSet rs = leggi.executeQuery();
			while (rs.next()) {
				s.matricola = (rs.getInt("matricola"));
				connection.close();
			}
			rs.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return s.matricola;
				
	}
	
	//registro un nuovo stud
	public boolean RegistraStud(Studente s1)
	{
		String n=s1.getNome();
		String c=s1.getCognome();
		String u=s1.getUsername();
		String p=s1.getPassword();
		
		
		try {
			PreparedStatement inserimento;
		
			inserimento = connection.prepareStatement("INSERT INTO studente(nome, cognome, username, password) values ('"+n+"', '"+c+"', '"+u+"', '"+p+"')");
					
			inserimento.executeUpdate();
			
			connection.close();
			
		}catch(Exception e) {
			return false;
			}
		
		return true;
}
	
	//tramite  mat prendo nome stud
	public String getInfoNomeS(Studente s) 
	{
		int m = s.getMat();
		String nomeS = null;
		
			PreparedStatement leggi;
			
			try {
				leggi = connection.prepareStatement("SELECT nome FROM studente WHERE matricola = "+m);
			
			ResultSet rs =leggi.executeQuery();
			
			if(rs.next()) {
				nomeS = rs.getString("nome");
			}
			
			rs.close();
			
			connection.close();
			
			}catch (Exception e) {
				e.printStackTrace();
				return null;
			}
			
			return nomeS;
}


//tramite  mat prendo cognome stud
public String getInfoCognomeS(Studente s) 
{
	int m = s.getMat();
	String cognomeS = null;
	
		PreparedStatement leggi;
		
		try {
			leggi = connection.prepareStatement("SELECT cognome FROM studente WHERE matricola = "+m);
		
		ResultSet rs =leggi.executeQuery();
		
		if(rs.next()) {
			cognomeS = rs.getString("cognome");
		}
		
		rs.close();
		
		connection.close();
		
		}catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		
		return cognomeS;
}


//tramite  mat prendo username stud
public String getInfoUsernameS(Studente s) 
{
	int m = s.getMat();
	String usernameS = null;
	
		PreparedStatement leggi;
		
		try {
			leggi = connection.prepareStatement("SELECT username FROM studente WHERE matricola = "+m);
		
		ResultSet rs =leggi.executeQuery();
		
		if(rs.next()) {
			usernameS = rs.getString("username");
		}
		
		rs.close();
		
		connection.close();
		
		}catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		
		return usernameS;
}

//tramite  mat prendo psw stud
public String getInfoPswS(Studente s) 
{
	int m = s.getMat();
	String pswS = null;
	
		PreparedStatement leggi;
		
		try {
			leggi = connection.prepareStatement("SELECT password FROM studente WHERE matricola = "+m);
		
		ResultSet rs =leggi.executeQuery();
		
		if(rs.next()) {
			pswS = rs.getString("password");
		}
		
		rs.close();
		
		connection.close();
		
		}catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		
		return pswS;
}

//modifica cred Studente
public boolean modificaS(Studente s, String newus, String newpsw)
{
	String oldus = s.getUsername();
	String oldpsw = s.getPassword();
	
	PreparedStatement leggi;
	
	try {
		leggi =  connection.prepareStatement("UPDATE studente SET username = '"+newus+"' , password = '"+newpsw+"' WHERE username = '"+oldus+"' AND password = '"+oldpsw+"'");
		
		leggi.executeUpdate();
		
		connection.close();
		
	}catch(SQLException e){
		e.printStackTrace();
		return false;
	}
	
	return true;
}

//elimina studente
public boolean EliminaS(Studente s) {
	int m = s.getMat();
	
	PreparedStatement leggi;
	
	try {
		leggi =  connection.prepareStatement("DELETE FROM studente WHERE matricola = "+m);
		
		leggi.executeUpdate();
		
		connection.close();
		
	}catch(SQLException e){
		e.printStackTrace();
		return false;
	}
	
	return true;
}

}

package PDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import Connessione.ConnessioneDB;
import Model.Insegnante;
import Model.Studente;

public class ImpIns {
	
private Connection connection;
	
	public ImpIns() {
		try {
			connection = ConnessioneDB.getInstance().getConnection();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	//controlla
	public boolean Controlla(Insegnante s){
		String a=s.getPassword();
		String k=s.getUsername();
		
		try {
		PreparedStatement leggiup;
		
			leggiup = connection.prepareStatement(
					
			"SELECT * FROM insegnante where username='"+k+"'"+"AND password='"+a+"'");

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
				return false;
				}
			
			return true;
			
			}

	//registrazione
	public boolean RegistraIns(Insegnante s1)
	{
		String n=s1.getNome();
		String c=s1.getCognome();
		String u=s1.getUsername();
		String p=s1.getPassword();
		
		
		try {
			PreparedStatement inserimento;
		
			inserimento = connection.prepareStatement("INSERT INTO insegnante(nome, cognome, username, password) values ('"+n+"', '"+c+"', '"+u+"', '"+p+"')");
					
			inserimento.executeUpdate();
			
			connection.close();
			
		}catch(Exception e) {
			return false;
			}
		
		return true;
	}
	
	//get id ins
	public int GetIdI(Insegnante s)
	{
		String a=s.getPassword();
		String k=s.getUsername();
		
		
		PreparedStatement leggi;
		
		try {
			leggi = connection.prepareStatement(
					
					"SELECT identificativo FROM insegnante where username='"+k+"'"+"AND password='"+a+"'");
			
			ResultSet rs = leggi.executeQuery();
			while (rs.next()) {
				s.identificativo = (rs.getInt("identificativo"));
				connection.close();
			}
			rs.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return s.identificativo;
				
	}
	
	//get info ins da is
	public String getInfoNomeI(Insegnante s) 
	{
		int m = s.getID();
		String nomeI = null;
		
			PreparedStatement leggi;
			
			try {
				leggi = connection.prepareStatement("SELECT nome FROM insegnante WHERE identificativo = "+m);
			
			ResultSet rs =leggi.executeQuery();
			
			if(rs.next()) {
				nomeI = rs.getString("nome");
			}
			
			rs.close();
			
			connection.close();
			
			}catch (Exception e) {
				e.printStackTrace();
				return null;
			}
			
			return nomeI;
	}
	
	
	public String getInfoCognomeI(Insegnante s) 
	{
		int m = s.getID();
		String cognomeI = null;
		
			PreparedStatement leggi;
			
			try {
				leggi = connection.prepareStatement("SELECT cognome FROM insegnante WHERE identificativo = "+m);
			
			ResultSet rs =leggi.executeQuery();
			
			if(rs.next()) {
				cognomeI = rs.getString("cognome");
			}
			
			rs.close();
			
			connection.close();
			
			}catch (Exception e) {
				e.printStackTrace();
				return null;
			}
			
			return cognomeI;
	}	
	
	public String getInfoUsernameI(Insegnante s) 
	{
		int m = s.getID();
		String usernameI = null;
		
			PreparedStatement leggi;
			
			try {
				leggi = connection.prepareStatement("SELECT username FROM insegnante WHERE identificativo = "+m);
			
			ResultSet rs =leggi.executeQuery();
			
			if(rs.next()) {
				usernameI = rs.getString("username");
			}
			
			rs.close();
			
			connection.close();
			
			}catch (Exception e) {
				e.printStackTrace();
				return null;
			}
			
			return usernameI;
	}

	public String getInfoPswI(Insegnante s) 
	{
		int m = s.getID();
		String pswI = null;
		
			PreparedStatement leggi;
			
			try {
				leggi = connection.prepareStatement("SELECT password FROM insegnante WHERE identificativo = "+m);
			
			ResultSet rs =leggi.executeQuery();
			
			if(rs.next()) {
				pswI = rs.getString("password");
			}
			
			rs.close();
			
			connection.close();
			
			}catch (Exception e) {
				e.printStackTrace();
				return null;
			}
			
			return pswI;
	}
	
	//modifica ins
	public boolean modificaIns(Insegnante s, String newus, String newpsw)
	{
		String oldus = s.getUsername();
		String oldpsw = s.getPassword();
		
		PreparedStatement leggi;
		
		try {
			leggi =  connection.prepareStatement("UPDATE insegnante SET username = '"+newus+"' , password = '"+newpsw+"' WHERE username = '"+oldus+"' AND password = '"+oldpsw+"'");
			
			leggi.executeUpdate();
			
			connection.close();
			
		}catch(SQLException e){
			e.printStackTrace();
			return false;
		}
		
		return true;
	}
	
	//elimina ins
	public boolean EliminaIns(Insegnante s) {
		int m = s.getID();
		
		PreparedStatement leggi;
		
		try {
			leggi =  connection.prepareStatement("DELETE FROM insegnante WHERE identificativo = "+m);
			
			leggi.executeUpdate();
			
			connection.close();
			
		}catch(SQLException e){
			e.printStackTrace();
			return false;
		}
		
		return true;
	}
	
	
	
	
	
	
	
	
	
	
}
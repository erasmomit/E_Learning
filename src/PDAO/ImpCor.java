package PDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import Connessione.ConnessioneDB;
import Model.Correzione;
import Model.Studente;
import Model.Test;

public class ImpCor {
private Connection connection;
	
	public ImpCor() {
		try {
			connection = ConnessioneDB.getInstance().getConnection();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
			
	public ArrayList<Test> TabTest(Correzione c)
	{
		int idins = c.getIdI();
		PreparedStatement tab;
		ArrayList<Test> test = new ArrayList<Test>();
		
		try {
			tab=connection.prepareStatement("SELECT distinct idt FROM correzione WHERE identificativo = '"+idins+"' AND correzionecompletata = 0");
			
			ResultSet rs =tab.executeQuery();
			
			while(rs.next())
			{
				Test t = new Test(rs.getInt("idt"));
				test.add(t);
			}
			
			rs.close();
			
			connection.close();
			
		}catch(SQLException e) {
			return test;
		}
		
		return test;
	}
	
	public ArrayList<Studente> StudPerE(Correzione c)
	{
		int idtest = c.getidT();
		int idins = c.getIdI();
		PreparedStatement tab;
		ArrayList<Studente> Stud = new ArrayList<Studente>();
		
		try {
			tab=connection.prepareStatement("SELECT distinct matricola FROM correzione WHERE idt = '"+idtest+"' AND identificativo = '"+idins+"' AND correzionecompletata = 0");
			
			ResultSet rs =tab.executeQuery();
			
			while(rs.next())
			{
				Studente t = new Studente(rs.getInt("matricola"));
				Stud.add(t);
			}
			
			rs.close();
			
			connection.close();
			
		}catch(SQLException e) {
			return Stud;
		}
		
		return Stud;
	}
	
	public void Flag(Correzione c)
	{
		int idtest = c.getidT();
		int mat = c.getIdI();
		
		try {
			PreparedStatement up=connection.prepareStatement("UPDATE correzione SET correzionecompletata = 1 WHERE idt = '"+idtest+"' AND matricola = '"+mat+"'");
			
			up.executeUpdate();
			
			connection.close();
			
		}catch(SQLException e) {
			return;
		}
		
		return;
	}
}

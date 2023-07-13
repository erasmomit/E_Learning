package PDAO;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;

import Connessione.ConnessioneDB;
import Model.AmmetteQuizA;
import Model.Test;
import Model.quizAperto;

public class ImpQuizA {
private Connection connection;
	
	public ImpQuizA() {
		try {
			connection = ConnessioneDB.getInstance().getConnection();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	//crea quiz
	public void creaQuiz(quizAperto q) {
		String td = q.getTD();
		int pmax = q.getPMax();
		int pmin = q.getPMin();
		int cm = q.getC();
		String mat = q.getMat();
		
		try {
			PreparedStatement inserimento=connection.prepareStatement("INSERT INTO quizaperta(testodomanda, punteggiomax, punteggiomin, maxcaratteri, materia) values('"+td+"', '"+pmax+"', '"+pmin+"', '"+cm+"', '"+mat+"')");
			
			inserimento.executeUpdate();
			
			connection.close();
			
		}catch(Exception e) {
			e.printStackTrace();
			return;
		}
		
		return;
	}
	
	public void creaAmmQ(AmmetteQuizA q)
	{
		int idt = q.getIdt();
		int idqa = q.getIdqa();
		Date data = Date.valueOf(LocalDate.now());
		try {
			PreparedStatement inserimento=connection.prepareStatement("INSERT INTO ammettequiza values('"+data+"', '"+idqa+"', '"+idt+"')");
			
			inserimento.executeUpdate();
			
			connection.close();
			
		}catch(Exception e) {
			e.printStackTrace();
			return;
		}
		
		return;
	}
	
	public int getIDQA1(quizAperto q)
	{
		String td = q.getTD();
		int pmax = q.getPMax();
		int pmin = q.getPMin();
		int cm = q.getC();
		String mat = q.getMat();
		int idqa = 0;
		
		try {
			PreparedStatement leggi=connection.prepareStatement("SELECT idqa FROM quizaperta WHERE testodomanda = '"+td+"' AND punteggiomax = '"+pmax+"' AND punteggiomin = '"+pmin+"' AND maxcaratteri = '"+cm+"' AND materia = '"+mat+"'");
			
			ResultSet rs = leggi.executeQuery();
			
			if(rs.next()) {
				idqa = rs.getInt("idqa");
			}
			
			rs.close();
					
			connection.close();
			
		}catch(Exception e) {
			e.printStackTrace();
			return 0;
		}
		
		return idqa;
	}

	public ArrayList<quizAperto> getQA1(AmmetteQuizA q)
	{
		ArrayList<quizAperto> quiz = new ArrayList<quizAperto>();
		
		int idt = q.getIdt();
		
		int idqa;
		
		quizAperto q1;
		try {
			PreparedStatement leggi = connection.prepareStatement("SELECT idqa FROM ammettequiza WHERE idt ='"+idt+"'");
			
			ResultSet rs = leggi.executeQuery();
			
			while(rs.next()) {
					idqa = rs.getInt("idqa");
					System.out.println(idqa);
					q1 = new quizAperto(idqa);
					quiz.add(q1);
				}
			
			rs.close();
			
			connection.close();
		}catch(SQLException e) {
			e.printStackTrace();
			return null;
		}
		
		return quiz;
	}
	
	public String getDomandaA1(quizAperto q)
	{
		int idqa = q.getId();
		String domanda = null;
		
		try {
			PreparedStatement leggi = connection.prepareStatement("SELECT testodomanda FROM quizaperta WHERE idqa ='"+idqa+"'");
			
			ResultSet rs = leggi.executeQuery();
			
			if(rs.next()) {
				domanda=rs.getString("testodomanda");
			}
			
			rs.close();
			
			connection.close();
		}catch(SQLException e) {
			e.printStackTrace();
			return domanda;
		}
		return domanda;
	}
	
	public void Eliminazione(quizAperto q)
	{
		int idqa = q.getId();
		
		try {
			PreparedStatement elimina = connection.prepareStatement("DELETE FROM quizaperta WHERE idqa = '"+idqa+"'");
			
			elimina.executeUpdate();
			
			connection.close();
		}catch(SQLException e) {
			e.printStackTrace();
			return;
		}
		
		return;
	}
	
	public ArrayList<quizAperto> getIDQAtest(AmmetteQuizA q)
	{
		int idt = q.getIdt();
		ArrayList<quizAperto> qa = new ArrayList<quizAperto>();
		
		try {
			PreparedStatement tabella = connection.prepareStatement("SELECT idqa FROM ammettequiza WHERE idt = '"+idt+"'");
			
			ResultSet rs = tabella.executeQuery();
			
			while(rs.next())
			{
				quizAperto a = new quizAperto(rs.getInt("idqa"));
				qa.add(a);
			}
			
			rs.close();
			
			connection.close();
		}catch(SQLException e) {
			e.printStackTrace();
			return qa;
		}
		
		return qa;
	}
	
	public int getPmax(quizAperto q)
	{
		int idqa = q.getId();
		int p = 0;
		
		try {
			PreparedStatement tabella = connection.prepareStatement("SELECT punteggiomax FROM quizaperta WHERE idqa = '"+idqa+"'");
			
			ResultSet rs = tabella.executeQuery();
			
			if(rs.next())
			{
				p = rs.getInt("punteggiomax");
			}
			
			rs.close();
			
			connection.close();
		}catch(SQLException e) {
			e.printStackTrace();
			return p;
		}
		
		return p;
	}
	
	public int getPmin(quizAperto q)
	{
		int idqa = q.getId();
		int p = 0;
		
		try {
			PreparedStatement tabella = connection.prepareStatement("SELECT punteggiomin FROM quizaperta WHERE idqa = '"+idqa+"'");
			
			ResultSet rs = tabella.executeQuery();
			
			if(rs.next())
			{
				p = rs.getInt("punteggiomin");
			}
			
			rs.close();
			
			connection.close();
		}catch(SQLException e) {
			e.printStackTrace();
			return p;
		}
		
		return p;
	}
}

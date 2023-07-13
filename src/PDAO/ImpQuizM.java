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
import Model.AmmetteQuizM;
import Model.quizAperto;
import Model.quizMultiplo;

public class ImpQuizM {
private Connection connection;
	
	public ImpQuizM() {
		try {
			connection = ConnessioneDB.getInstance().getConnection();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void creaQuiz(quizMultiplo q) {
		String td = q.getTD();
		int pb = q.getPB();
		int pm = q.getPM();
		String mat = q.getMat();
		String rg = q.getRG();
		String rs1 = q.getRs1();
		String rs2 = q.getRs2();
		String rs3 = q.getRs3();
		
		try {
			PreparedStatement inserimento=connection.prepareStatement("INSERT INTO quizmultipla(domanda, punteggiobonus, punteggiomalus, materia, rispostagiusta, rispostasbagliata1, rispostasbagliata2, rispostasbagliata3) values('"+td+"', '"+pb+"', '"+pm+"', '"+mat+"', '"+rg+"', '"+rs1+"', '"+rs2+"', '"+rs3+"')");
			
			inserimento.executeUpdate();
			
			connection.close();
			
		}catch(Exception e) {
			e.printStackTrace();
			return;
		}
		
		return;
	}
	
	public void creaAmmQ(AmmetteQuizM q)
	{
		int idt = q.getIdt();
		int idqm = q.getIdqm();
		Date data = Date.valueOf(LocalDate.now());
		try {
			PreparedStatement inserimento=connection.prepareStatement("INSERT INTO ammettequizm values('"+data+"', '"+idqm+"', '"+idt+"')");
			
			inserimento.executeUpdate();
			
			connection.close();
			
		}catch(Exception e) {
			e.printStackTrace();
			return;
		}
		
		return;
	}
	
	public int getIDQM1(quizMultiplo q)
	{
		String td = q.getTD();
		int pb = q.getPB();
		int pm = q.getPM();
		String mat = q.getMat();
		String rg = q.getRG();
		String rs1 = q.getRs1();
		String rs2 = q.getRs2();
		String rs3 = q.getRs3();
		
		int idqm = 0;
		
		try {
			PreparedStatement leggi=connection.prepareStatement("SELECT idqm FROM quizmultipla WHERE domanda = '"+td+"' AND punteggiobonus = '"+pb+"' AND punteggiomalus = '"+pm+"' AND materia = '"+mat+"' AND rispostagiusta = '"+rg+"' AND rispostasbagliata1 = '"+rs1+"' AND rispostasbagliata2 = '"+rs2+"' AND rispostasbagliata3 = '"+rs3+"'");
			
			ResultSet rs = leggi.executeQuery();
			
			if(rs.next()) {
				idqm = rs.getInt("idqm");
			}
			
			rs.close();
					
			connection.close();
			
		}catch(Exception e) {
			e.printStackTrace();
			return 0;
		}
		
		return idqm;
	}
	
	public ArrayList<quizMultiplo> getQM1(AmmetteQuizM q)
	{
		ArrayList<quizMultiplo> quiz = new ArrayList<quizMultiplo>();
		
		int idt = q.getIdt();
		
		int idqm;
		
		quizMultiplo q1;
		try {
			PreparedStatement leggi = connection.prepareStatement("SELECT idqm FROM ammettequizm WHERE idt ='"+idt+"'");
			
			ResultSet rs = leggi.executeQuery();
			
			while(rs.next()) {
					idqm = rs.getInt("idqm");
					q1 = new quizMultiplo(idqm);
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
	
	public String getDomandaM1(quizMultiplo q)
	{
		int idqm = q.getIDQM();
		String domanda = null;
		
		try {
			PreparedStatement leggi = connection.prepareStatement("SELECT domanda FROM quizmultipla WHERE idqm ='"+idqm+"'");
			
			ResultSet rs = leggi.executeQuery();
			
			if(rs.next()) {
				domanda=rs.getString("domanda");
			}
			
			rs.close();
			
			connection.close();
		}catch(SQLException e) {
			e.printStackTrace();
			return domanda;
		}
		return domanda;
	}
	
	public void Eliminazione(quizMultiplo q)
	{
		int idqm = q.getIDQM();
		
		try {
			PreparedStatement elimina = connection.prepareStatement("DELETE FROM quizmultipla WHERE idqm = '"+idqm+"'");
			
			elimina.executeUpdate();
			
			connection.close();
		}catch(SQLException e) {
			e.printStackTrace();
			return;
		}
		
		return;
	}
	
	public ArrayList<quizMultiplo> getIDQMtest(AmmetteQuizM q)
	{
		int idt = q.getIdt();
		ArrayList<quizMultiplo> qm = new ArrayList<quizMultiplo>();
		
		try {
			PreparedStatement tabella = connection.prepareStatement("SELECT idqm FROM ammettequizm WHERE idt = '"+idt+"'");
			
			ResultSet rs = tabella.executeQuery();
			
			while(rs.next())
			{
				quizMultiplo a = new quizMultiplo(rs.getInt("idqm"));
				qm.add(a);
			}
			
			rs.close();
			
			connection.close();
		}catch(SQLException e) {
			e.printStackTrace();
			return qm;
		}
		
		return qm;
	}
	
	public ArrayList<String> getRIS(quizMultiplo q)
	{
		int idqm = q.getIDQM();
		
		ArrayList<String> ris = new ArrayList<String>();
		
		try {
			PreparedStatement tabella = connection.prepareStatement("SELECT rispostagiusta, rispostasbagliata1,rispostasbagliata2, rispostasbagliata3 FROM quizmultipla WHERE idqm = '"+idqm+"'");
			
			ResultSet rs = tabella.executeQuery();
			
			if(rs.next())
			{
				String a = rs.getString("rispostagiusta");
				ris.add(a);
				String b = rs.getString("rispostasbagliata1");
				ris.add(b);
				String c = rs.getString("rispostasbagliata2");
				ris.add(c);
				String d = rs.getString("rispostasbagliata3");
				ris.add(d);
			}
			
			rs.close();
			
			connection.close();
		}catch(SQLException e) {
			e.printStackTrace();
			return ris;
		}
		
		return ris;
	}
}

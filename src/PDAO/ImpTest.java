package PDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;

import Connessione.ConnessioneDB;
import Model.Test;

public class ImpTest {

		private Connection connection;
		
		public ImpTest() {
			try {
				connection = ConnessioneDB.getInstance().getConnection();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		public boolean Creazione(Test t)
		{
			String n = t.getNome();
			Date data = t.getDT();
			Date dii = t.getDII();
			Date dfi = t.getDFI();
			int ts = t.getTempo();
			int pm = t.getPM();
			Date dop = t.getDataOP();
			int iden = t.getidI();
			
			PreparedStatement inserimento;
			
			try {
				inserimento=connection.prepareStatement("INSERT INTO test(nometest, datatest, datainizioiscr, datafineiscr, temposvolgimento, punteggiominpos, dataoperazione, identificativo) VALUES('"+n+"','"+data+"','"+dii+"','"+dfi+"','"+ts+"','"+pm+"','"+dop+"','"+iden+"')");
				
				inserimento.executeUpdate();
				
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
				return false;
			}
			
			return true;
			
		}
		
		public ArrayList<Test> TabTestE(Test t)
		{
			int id = t.getidI();
			ArrayList<Test> test = new ArrayList();
			Date data = java.sql.Date.valueOf(LocalDate.now());
			
			PreparedStatement leggi;
			
			try {
				leggi=connection.prepareStatement("SELECT idt, nometest, datainizioiscr  FROM test WHERE identificativo = '"+id+"' AND datainizioiscr > '"+data+"'");
				
				ResultSet rs2 = leggi.executeQuery();
				
				while(rs2.next())
				{
					Test t1 = new Test(rs2.getInt("idt"), rs2.getString("nometest"), rs2.getDate("datainizioiscr"));
					test.add(t1);
				}

				rs2.close();
				connection.close();
				
			} catch (SQLException e) {
				e.printStackTrace();
				return null;
			}
			
			return test;
			
		}
		
		public void EliminaTest1(Test t)
		{
			int idtest = t.getIdt();
			
			PreparedStatement elimina;
			
			try {
				elimina=connection.prepareStatement("DELETE FROM test WHERE idt = '"+idtest+"'");
				
				elimina.executeUpdate();
				
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
				return;
			}
			
			return;
		}
		
		public boolean Modifica(Test t)
		{
			int idt = t.getIdt();
			String n = t.getNome();
			Date data = t.getDT();
			Date dii = t.getDII();
			Date dfi = t.getDFI();
			int ts = t.getTempo();
			int pm = t.getPM();
			Date dop = t.getDataOP();
			int iden = t.getidI();
			
			PreparedStatement inserimento;
			
			try {
				inserimento=connection.prepareStatement("UPDATE test SET nometest = '"+n+"', datatest = '"+data+"', datainizioiscr = '"+dii+"', datafineiscr = '"+dfi+"', temposvolgimento = '"+ts+"', punteggiominpos = '"+pm+"', dataoperazione = '"+dop+"', identificativo = '"+iden+"' WHERE idt = '"+idt+"'");
				inserimento.executeUpdate();
				
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
				return false;
			}
			
			return true;
			
		}
		
		public ArrayList<Test> TTP(Test t)
		{
			Date data = java.sql.Date.valueOf(LocalDate.now());
			ArrayList<Test> test = new ArrayList<Test>();
			
			PreparedStatement tabella;
			
			try {
				tabella=connection.prepareStatement("SELECT idt, nometest FROM Test WHERE '"+data+"' BETWEEN datainizioiscr AND datafineiscr");
				
				ResultSet rs = tabella.executeQuery();
				
				while(rs.next())
				{
					Test t1 = new Test(rs.getInt("idt"), rs.getString("nometest"));
					test.add(t1);
				}
				
				rs.close();
				
				connection.close();
			} catch (Exception e) {
				e.printStackTrace();
				return test;
			}
			
			return test;
		}
		
		public boolean Prenota(Test t)
		{
			int idt = t.getIdt();
			int mat = t.getidI();
			Date data =java.sql.Date.valueOf(LocalDate.now());
			PreparedStatement inserimento;
			
			try {
				inserimento=connection.prepareStatement("INSERT INTO testscelti(idt, matricola, dataiscrizione) VALUES('"+idt+"', '"+mat+"', '"+data+"')");
				
				inserimento.executeUpdate();
				
				connection.close();
			} catch (Exception e) {
				return false;
			}
			
			return true;
		}
		
		public ArrayList<Test> TestS(Test t)
		{
			int mat = t.getidI();
			ArrayList<Test> testscelti = new ArrayList<Test>();
			PreparedStatement tabella;
			
			try {
				tabella=connection.prepareStatement("SELECT idt FROM testscelti WHERE matricola = '"+mat+"'");
				
				ResultSet rs = tabella.executeQuery();
				
				while(rs.next())
				{
					Test t1 = new Test(rs.getInt("idt"), mat);
					testscelti.add(t1);
				}
				
				rs.close();
				
				connection.close();
			} catch (Exception e) {
				e.printStackTrace();
				return testscelti;
			}
			
			return testscelti;
		}
		
		public String getNomeTest(Test t)
		{
			int idt = t.getidI();
			PreparedStatement tabella;
			String nome = null;
			try {
				tabella=connection.prepareStatement("SELECT nometest FROM test WHERE idt = '"+idt+"'");
				
				ResultSet rs = tabella.executeQuery();
				
				if(rs.next())
				{
					nome = rs.getString("nometest");
				}
				
				rs.close();
				
				connection.close();
			} catch (Exception e) {
				e.printStackTrace();
				return nome;
			}
			
			return nome;
		}
		
		public java.sql.Date getDataTest(Test t)
		{
			int idt = t.getidI();
			PreparedStatement tabella;
			java.sql.Date data = null;
			try {
				tabella=connection.prepareStatement("SELECT datatest FROM test WHERE idt = '"+idt+"'");
				
				ResultSet rs = tabella.executeQuery();
				
				if(rs.next())
				{
					data = rs.getDate("datatest");
				}
				
				rs.close();
				
				connection.close();
			} catch (Exception e) {
				e.printStackTrace();
				return data;
			}
			
			return data;
		}
		
		public java.sql.Date getDataIscr(Test t)
		{
			int idt = t.getIdt();
			int mat = t.getidI();
			
			PreparedStatement tabella;
			java.sql.Date data = null;
			try {
				tabella=connection.prepareStatement("SELECT dataiscrizione FROM testscelti WHERE idt = '"+idt+"' AND matricola = '"+mat+"'");
				
				ResultSet rs = tabella.executeQuery();
				
				if(rs.next())
				{
					data = rs.getDate("dataiscrizione");
				}
				
				rs.close();
				
				connection.close();
			} catch (Exception e) {
				e.printStackTrace();
				return data;
			}
			
			return data;
		}
		
		public Time getTTest(Test t)
		{
			int idt = t.getidI();
			PreparedStatement tabella;
			Time tempo = null;
			try {
				tabella=connection.prepareStatement("SELECT temposvolgimento FROM test WHERE idt = '"+idt+"'");
				
				ResultSet rs = tabella.executeQuery();
				
				if(rs.next())
				{
					tempo = rs.getTime("temposvolgimento");
				}
				
				rs.close();
				
				connection.close();
			} catch (Exception e) {
				e.printStackTrace();
				return tempo;
			}
			
			return tempo;
		}
		
		public int getPMIN(Test t)
		{
			int idt = t.getidI();
			PreparedStatement tabella;
			int pmin = 0;
			try {
				tabella=connection.prepareStatement("SELECT punteggiominpos FROM test WHERE idt = '"+idt+"'");
				
				ResultSet rs = tabella.executeQuery();
				
				if(rs.next())
				{
					pmin = rs.getInt("punteggiominpos");
				}
				
				rs.close();
				
				connection.close();
			} catch (Exception e) {
				e.printStackTrace();
				return pmin;
			}
			
			return pmin;
		}
		
		public ArrayList<Test> studentiEs(Test t)
		{
			int mat = t.getidI();
			ArrayList<Test> esami = new ArrayList<Test>();
			PreparedStatement tabella;
			
			try {
				tabella=connection.prepareStatement("SELECT * FROM studentiesaminati WHERE matricola = '"+mat+"'");
				
				ResultSet rs = tabella.executeQuery();
				
				while(rs.next())
				{
					Test t1 = new Test(rs.getInt("idt"), rs.getString("nometest"), rs.getInt("matricola"), rs.getString("esito"), rs.getInt("punteggiotot"), rs.getInt("punteggiominpos"), rs.getDate("datatest"));
					esami.add(t1);
				}
				
				rs.close();
				
				connection.close();
			} catch (Exception e) {
				e.printStackTrace();
				return esami;
			}
			
			return esami;
		}
		
		public ArrayList<Test> TSID(Test t)
		{
			int mat = t.getidI();
			ArrayList<Test> esami = new ArrayList<Test>();
			PreparedStatement tabella;
			try {
				tabella=connection.prepareStatement("SELECT distinct idt FROM testscelti WHERE matricola = '"+mat+"'");
				
				ResultSet rs = tabella.executeQuery();
				
				while(rs.next())
				{
					Test t1 = new Test(rs.getInt("idt"), mat);
					esami.add(t1);
				}
				
				rs.close();
				
				connection.close();
			} catch (Exception e) {
				e.printStackTrace();
				return esami;
			}
			
			return esami;
		}
		
		public int getIdINS(Test t)
		{
			int idt = t.getidI();
			int idins = 0;
			
			PreparedStatement tabella;
			
			try {
				tabella=connection.prepareStatement("SELECT distinct identificativo FROM test WHERE idt = '"+idt+"'");
				
				ResultSet rs = tabella.executeQuery();
				
				if(rs.next())
				{
					idins=rs.getInt("identificativo");
				}
				
				rs.close();
				
				connection.close();
			} catch (Exception e) {
				e.printStackTrace();
				return idins;
			}
			
			return idins;
		}
}


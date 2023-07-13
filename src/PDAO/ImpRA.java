package PDAO;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import Connessione.ConnessioneDB;
import Model.RisAperta;
import Model.quizAperto;

public class ImpRA {
private Connection connection;
	
	public ImpRA() {
		try {
			connection = ConnessioneDB.getInstance().getConnection();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public boolean IRA(RisAperta r)
	{
		String TR=r.getTR();
		int mat=r.getMat(); 
		int idqa=r.getIdqa();
		Date data=r.getD();
		int idins = r.getIdI();
		try {
			PreparedStatement ins = connection.prepareStatement("INSERT INTO rispostaaperta(testorisposta, matricola, idqa, dataconsegna, identificativo) VALUES('"+TR+"', '"+mat+"', '"+idqa+"', '"+data+"', '"+idins+"')");
			
			ins.executeUpdate();
			
			connection.close();
		}catch(SQLException e) {
			e.printStackTrace();
			return false;
		}
		
		return true;
	}

	public String getTR(RisAperta r) {
		String TR = new String();
		int mat = r.getMat();
		int idqa = r.getIdqa();
		
		try {
			PreparedStatement tabella = connection.prepareStatement("SELECT testorisposta FROM rispostaaperta WHERE matricola = '"+mat+"' AND idqa = '"+idqa+"'");
			
			ResultSet rs = tabella.executeQuery(); 
			
			if(rs.next())
			{
				TR = rs.getString("testorisposta");
			}
			
			connection.close();
		}catch(SQLException e) {
			e.printStackTrace();
			return TR;
		}
		
		return TR;
		
		
	}

	public boolean update(RisAperta r) {
		int p = r.getPA();
		String c = r.getCorr();
		int mat = r.getMat();
		int idqa = r.getIdqa();
		String TR = r.getTR();
		
		try {
			PreparedStatement up = connection.prepareStatement("UPDATE rispostaaperta SET punteggioassegnato = '"+p+"', correzioni = '"+c+"' WHERE matricola = '"+mat+"' AND testorisposta = '"+TR+"' AND idqa = '"+idqa+"'");
			
			up.executeUpdate();
			
			connection.close();
		}catch(SQLException e) {
			return false;
		}
		
		return true;
	}
}

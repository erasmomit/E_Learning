package PDAO;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import Connessione.ConnessioneDB;
import Model.RisAperta;
import Model.RisChiusa;

public class ImpRM {
	private Connection connection;

	public ImpRM() {
		try {
			connection = ConnessioneDB.getInstance().getConnection();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public boolean IRM(RisChiusa r)
	{
		String TR=r.getTR();
		int mat=r.getMat(); 
		int idqm=r.getIdqm();
		Date data=r.getD();
		
		try {
			PreparedStatement ins = connection.prepareStatement("INSERT INTO rispostachiusa(testorisposta, matricola, idqm, dataconsegna) VALUES('"+TR+"', '"+mat+"', '"+idqm+"', '"+data+"')");
			
			ins.executeUpdate();
			
			connection.close();
		}catch(SQLException e) {
			e.printStackTrace();
			return false;
		}
		
		return true;
	}
}

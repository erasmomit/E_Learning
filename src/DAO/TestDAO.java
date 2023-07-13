package DAO;

import java.sql.Time;
import java.util.ArrayList;

import Model.Test;

public interface TestDAO {

	public boolean Creazione(Test t);
	
	public ArrayList<Test> TabTestE(Test t);
	
	public void EliminaTest1(Test t);
	
	public boolean Modifica(Test t);
	
	public ArrayList<Test> TTP(Test t);
	
	public boolean Prenota(Test t);
	
	public ArrayList<Test> TestS(Test t);
	
	public String getNomeTest(Test t);
	
	public java.sql.Date getDataTest(Test t);
	
	public java.sql.Date getDataIscr(Test t);
	
	public Time getTTest(Test t);
	
	public int getPMIN(Test t);
	
	public ArrayList<Test> studentiEs(Test t);
	
	public ArrayList<Test> TSID(Test t);
	
	public int getIdINS(Test t);
	
	
	
	
}

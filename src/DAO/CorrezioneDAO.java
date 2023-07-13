package DAO;

import java.util.ArrayList;

import Model.Correzione;
import Model.Studente;
import Model.Test;

public interface CorrezioneDAO {

	public ArrayList<Test> TabTest(Correzione c);
	
	public ArrayList<Studente> StudPerE(Correzione c);
	
	public void Flag(Correzione c);
		
	
}

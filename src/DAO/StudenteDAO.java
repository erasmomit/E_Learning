package DAO;

import Model.Studente;

public interface StudenteDAO {
	
	public boolean Controlla(Studente s);
	
	public boolean RegistraStud(Studente s1);
	
	public int GetMat(Studente s);
	
	public String getInfoNomeS(Studente s);
	
	public String getInfoCognomeS(Studente s);
	
	public String getInfoUsernameS(Studente s) ;
	
	public String getInfoPswS(Studente s) ;
	
	public boolean modificaS(Studente s, String newus, String newpsw);
	
	public boolean EliminaS(Studente s);
	
	
	
}

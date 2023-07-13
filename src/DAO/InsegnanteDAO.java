package DAO;

import Model.Insegnante;

public interface InsegnanteDAO {

	public boolean Controlla(Insegnante s);
	
	public boolean RegistraIns(Insegnante s1);
	
	public int GetIdI(Insegnante s);
	
	public String getInfoNomeI(Insegnante s);
	
	public String getInfoCognomeI(Insegnante s);
	
	public String getInfoUsernameI(Insegnante s);
	
	public String getInfoPswI(Insegnante s) ;
	
	public boolean modificaIns(Insegnante s, String newus, String newpsw);
	
	public boolean EliminaIns(Insegnante s);
	
	
}

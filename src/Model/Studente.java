package Model;

public class Studente {
	public String nome;
	public String cognome;
	private String usernameS;
	private String passwordS;
	public int matricola;
	private String erroreU;
	private String erroreP;
		
	public Studente(String n, String c, String u, String p) {
		
		nome=n;
		cognome=c;
		try {
			controlloP(p);
		}catch(Exception e){
			erroreU="Password troppo corta!";
		}
		passwordS = p;	
		
		try {
			controlloU(u);
		}catch(Exception e){
			erroreP="Username troppo corta!";
		}
		usernameS = u;
	}
	
	public void controlloP(String p) throws Exception {
		if (p.length()<7)
		throw new Exception("Password troppo corta!");
	}
	
	public void controlloU(String u) throws Exception {
		if (u.length()<7)
		throw new Exception("Username troppo corta!");
	}
	
	//costrutto login
	public Studente(String u, String p) {
		usernameS=u;
		passwordS=p;
	}
	
	//costrutto info
	public Studente(int mat) {
		matricola = mat;
	}

	
	public String getNome() {
		
		return nome;
	}
	
	public String getCognome() {
		
		return cognome;
	}
	public String getPassword() {
		
		return passwordS;
	}
	
	public String getUsername() {
		
		return usernameS;
	}
	
	public int getMat() {
		return matricola;
	}
	
	
}

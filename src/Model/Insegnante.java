package Model;

public class Insegnante {
	private String nome;
	private String cognome;
	private String usernameI;
	private String passwordI;
	public int identificativo;
	private String erroreU;
	private String erroreP;
	
public Insegnante(String n, String c, String u, String p) {
		
		nome=n;
		cognome=c;
		try {
			controlloP(p);
		}catch(Exception e){
			erroreU="Password troppo corta!";
		}
		passwordI = p;	
		
		try {
			controlloU(u);
		}catch(Exception e){
			erroreP="Username troppo corta!";
		}
		usernameI = u;
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
	public Insegnante(String u, String p) {
		usernameI=u;
		passwordI=p;

	}

	
	public String getNome() {
		
		return nome;
	}
	
	public String getCognome() {
		
		return cognome;
	}
	
	public String getPassword() {
		
		return passwordI;
	}
	
	public String getUsername() {
		
		return usernameI;
	}
	
	public int getID() {
		
		return identificativo;
	}
	
	//costrutto info
	public Insegnante(int id) {
		identificativo = id;
	}
}

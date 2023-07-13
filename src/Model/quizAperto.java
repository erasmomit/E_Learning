package Model;

public class quizAperto {
	private int idqa;
	private	String testoD;
	private int Pmax;
	private int Pmin;
	private int Cmax;
	private String mat;
	
	public quizAperto(String t, int pmax, int pmin, int c, String materia) {
		testoD = t;
		Pmax = pmax;
		Pmin = pmin;
		Cmax = c;
		mat = materia;
	}
	
public quizAperto(int idqa2) {
		idqa = idqa2;
	}

public quizAperto(int id, String domandaA) {
	idqa = id;
	testoD = domandaA;
}

public int getId() {
		
		return idqa;
	}

public String getTD() {
	
	return testoD;
}

public int getPMax() {
	
	return Pmax;
}

public int getPMin() {
	
	return Pmin;
}

public int getC() {
	
	return Cmax;
}

public String getMat() {
	
	return mat;
}
}

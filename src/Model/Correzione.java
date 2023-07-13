package Model;

public class Correzione {
	private int effettuata;
	private int mat;
	private int idtest;
	private int idins;
	
	
	public Correzione(int m, int idt, int idi) {
		mat=m;
		idtest=idt;
		idins=idi;
	}
	
	public Correzione(int idt, int idins2) {
		idtest=idt;
		idins=idins2;
	}

	public Correzione(int idins2) {
		idins=idins2;
	}

	public int getMat()
	{
		return mat;
	}
	
	public int getidT()
	{
		return idtest;
	}
	
	public int getIdI()
	{
		return idins;
	}
	
}

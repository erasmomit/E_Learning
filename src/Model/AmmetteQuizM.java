package Model;

public class AmmetteQuizM {
	private int idtest;
	private int idquiz;
	
	public AmmetteQuizM(int idt, int idqm)
	{
		idtest = idt;
		idquiz = idqm;
	}
	
	public AmmetteQuizM(int idt) {
		idtest=idt;
	}

	public int getIdt()
	{
		return idtest;
	}
	
	public int getIdqm()
	{
		return idquiz;
	}
}

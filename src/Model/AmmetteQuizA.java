package Model;

public class AmmetteQuizA {
	private int idtest;
	private int idquiz;
	
	public AmmetteQuizA(int idt, int idqa)
	{
		idtest = idt;
		idquiz = idqa;
	}
	
	public int getIdt()
	{
		return idtest;
	}
	
	public int getIdqa()
	{
		return idquiz;
	}
	
	public AmmetteQuizA(int idt)
	{
		idtest = idt;
	}
}

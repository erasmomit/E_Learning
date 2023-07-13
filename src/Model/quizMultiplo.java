package Model;

public class quizMultiplo {
	private int idqm;
	private String dom;
	private int pb;
	private int pm;
	private String mat;
	private String rg;
	private String rs1;
	private String rs2;
	private String rs3;
	
	public quizMultiplo(String d, int p1, int p2, String m, String r1, String r2, String r3, String r4)
	{
		dom = d;
		pb = p1;
		pm = p2;
		mat = m;
		rg = r1;
		rs1 = r2;
		rs2 = r3;
		rs3 = r4;
	}
	
	public quizMultiplo(int idqm2) {
		idqm = idqm2;
	}

	public quizMultiplo(int idqm2, String domandaA) {
		idqm = idqm2;
		dom = domandaA;
	}

	public int getIDQM()
	{
		return idqm;
	}
	
	public String getTD()
	{
		return dom;
	}
	
	public int getPB()
	{
		return pb;
	}
	
	public int getPM()
	{
		return pm;
	}
	
	public String getMat()
	{
		return mat;
	}
	
	public String getRG()
	{
		return rg;
	}
	
	public String getRs1()
	{
		return rs1;
	}
	
	public String getRs2()
	{
		return rs2;
	}
	
	public String getRs3()
	{
		return rs3;
	}
	
}

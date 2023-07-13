package Model;

import java.sql.Date;

public class RisAperta {
	private String TR;
	private int mat;
	private int idqa;
	private Date dataconsegna;
	private int punteggioass;
	private String correzioni;
	private int idins;
	
	public RisAperta(String t, int m, int id, Date d, int idi)
	{
		TR=t;
		mat=m;
		idqa=id;
		dataconsegna=d;
		idins=idi;
	}
	
	public RisAperta(int idqa2, int mat2) {
		idqa = idqa2;
		mat = mat2;
	}

	public RisAperta(int punteggioass2, String correzioni2, String TR1, int m, int idqa1) {
		punteggioass=punteggioass2;
		correzioni=correzioni2;
		TR=TR1;
		mat=m;
		idqa=idqa1;
	}

	public int getIdqa()
	{
		return idqa;
	}
	
	public int getMat()
	{
		return mat;
	}
	
	public String getTR()
	{
		return TR;
	}
	
	public Date getD()
	{
		return dataconsegna;
	}
	
	public int getPA()
	{
		return punteggioass;
	}
	
	public int getIdI()
	{
		return idins;
	}
	
	public String getCorr()
	{
		return correzioni;
	}
	
}

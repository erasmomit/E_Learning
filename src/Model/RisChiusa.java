package Model;

import java.sql.Date;

public class RisChiusa {
	private String TR;
	private int mat;
	private int idqm;
	private Date dataconsegna;
	
	public RisChiusa(String t, int m, int id, Date d)
	{
		TR=t;
		mat=m;
		idqm=id;
		dataconsegna=d;
	}
	
	public int getIdqm()
	{
		return idqm;
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
}

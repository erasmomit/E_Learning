package Model;

import java.sql.Date;
import java.sql.Time;

public class Test {
	private int idt;
	private String nome;
	private Date datatest;
	private Date dataInizioIscr;
	private Date dataFineIscr;
	private int tempoS;
	private int PMin;
	private Date dataop;
	private int id;
	private String Esito;
	private int punttot;
	private Time ts;
	public Test(String n, Date data, Date dii, Date dfi, int ts, int pm, Date dop, int iden)
	{
		nome=n;
		datatest=data;
		dataInizioIscr=dii;
		dataFineIscr=dfi;
		tempoS=ts;
		PMin=pm;
		id=iden;
		dataop=dop;
	}
	
	public int getIdt()
	{
		return idt;
	}
	
	public String getNome()
	{
		return nome;
	}
	
	public Date getDT()
	{
		return datatest;
	}
	
	public Date getDII()
	{
		return dataInizioIscr;
	}
	
	public Date getDFI()
	{
		return dataFineIscr;
	}
	
	public int getTempo()
	{
		return tempoS;
	}
	
	public int getPM()
	{
		return PMin;
	}
	
	public Date getDataOP()
	{
		return dataop;
	}
	
	public int getidI()
	{
		return id;
	}
	
	public String getEsito()
	{
		return Esito;
	}
	
	public int getPT()
	{
		return punttot;
	}
	
	public Time getTime()
	{
		return ts;
	}
	
	//costrutto tabella test
	public Test(int iden)
	{
		id=iden;
	}
	
	//costrutto lista
	public Test(int idtest, String n, Date data)
	{
		idt=idtest;
		nome=n;
		dataInizioIscr=data;
	}

	public Test(int valueAt, String valueAt2) {
		idt=valueAt;
		nome=valueAt2;
	}

	public Test(int idtest, String n, Date data, Date dii, Date dfi, int ts, int pm, Date dop, int iden) {
		idt=idtest;
		nome=n;
		datatest=data;
		dataInizioIscr=dii;
		dataFineIscr=dfi;
		tempoS=ts;
		PMin=pm;
		id=iden;
		dataop=dop;
	}

	public Test() {
	}

	public Test(int idt2, int mat) {
		idt = idt2;
		id=mat;
	}
	
	public Test(int idtest, String n, int mat, String e, int pt, int pm, Date data) {
		idt=idtest;
		nome=n;
		id=mat;
		Esito=e;
		punttot=pt;
		PMin=pm;
		datatest=data;
	}

	public Test(int idt2, String nt, int time, int getpuntmin) {
		idt = idt2;
		nome=nt;
		tempoS=time;
		PMin=getpuntmin;
	}

	public Test(int idt2, String nt, int getpuntmin) {
		idt=idt2;
		nome=nt;
		PMin=getpuntmin;
	}
}

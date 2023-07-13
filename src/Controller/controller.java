package Controller;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.Time;
import java.time.LocalDate;
import java.util.ArrayList;

import GUI.DatiErrati;
import Model.AmmetteQuizA;
import Model.AmmetteQuizM;
import Model.Correzione;
import Model.Insegnante;
import Model.RisAperta;
import Model.RisChiusa;
import Model.Studente;
import Model.Test;
import Model.quizAperto;
import Model.quizMultiplo;
import PDAO.ImpCor;
import PDAO.ImpIns;
import PDAO.ImpQuizA;
import PDAO.ImpQuizM;
import PDAO.ImpRA;
import PDAO.ImpRM;
import PDAO.ImpStud;
import PDAO.ImpTest;

public class controller {
	Studente s;
	
	Insegnante i;
	
	//costrutto controller
	public controller() {
	}
	
	//studente accesso
	public boolean AccessoS (String u, String p)
	{
		Studente s1 = new Studente(u, p);
		ImpStud a =new ImpStud();
		try {
			return a.Controlla(s1);
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	
	//mat studente
	public int getMatricola(String u, String p)
	{
		Studente s1 = new Studente(u, p);
		ImpStud a =new ImpStud();
		return a.GetMat(s1);
	}

	
	//registrazione stud nel db
	public boolean RegistraS(String nome, String cognome, String username, String psw)
	{
		boolean registrato;
		Studente s1 = new Studente(nome, cognome, username, psw);
		ImpStud a =new ImpStud();
		return a.RegistraStud(s1);
	}
	
	//tramite matricola prendo le info dello studente
	
	public String getInfoNome(int mat) {
		Studente s = new Studente(mat);
		ImpStud a = new ImpStud();
		return a.getInfoNomeS(s);
	}
	
	public String getInfoCognome(int mat) {
		Studente s = new Studente(mat);
		ImpStud a = new ImpStud();
		return a.getInfoCognomeS(s);
	}
	
	public String getInfoUsername(int mat) {
		Studente s = new Studente(mat);
		ImpStud a = new ImpStud();
		return a.getInfoUsernameS(s);
	}
	
	public String getInfoPsw(int mat) {
		Studente s = new Studente(mat);
		ImpStud a = new ImpStud();
		return a.getInfoPswS(s);
	}
	
	
	//modifica cred studente
	public boolean Modifica(String oldus, String oldpsw, String newus, String newpsw)
	{
		Studente s = new Studente(oldus, oldpsw);
		ImpStud a = new ImpStud();
		return a.modificaS(s, newus, newpsw);
	}

	//elimino account studente
	public boolean Elimina(int mat)
	{
		Studente s = new Studente(mat);
		ImpStud a = new ImpStud();
		return a.EliminaS(s);
	}
	
	
	//---------------------------
	
	//insegnante
	
	//accesso ins
	public boolean AccessoI(String u, String p)
	{
		Insegnante s1 = new Insegnante(u, p);
		ImpIns a =new ImpIns();
		try {
			return a.Controlla(s1);
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	
	//registarzione ins
	public boolean RegistraI(String nome, String cognome, String username, String psw)
	{
		boolean registrato;
		Insegnante s1 = new Insegnante(nome, cognome, username, psw);
		ImpIns a =new ImpIns();
		return a.RegistraIns(s1);
	}
	
	//getinfo ins
	public int getId(String u, String p)
	{
		Insegnante s1 = new Insegnante(u, p);
		ImpIns a =new ImpIns();
		return a.GetIdI(s1);
	}
	
	//tramite id prendo info ins
	
		public String getInfoNomeI(int id) {
			Insegnante s1 = new Insegnante(id);
			ImpIns a =new ImpIns();
			return a.getInfoNomeI(s1);
		}
		
		public String getInfoCognomeI(int id) {
			Insegnante s1 = new Insegnante(id);
			ImpIns a =new ImpIns();
			return a.getInfoCognomeI(s1);
		}
		
		public String getInfoUsernameI(int id) {
			Insegnante s1 = new Insegnante(id);
			ImpIns a =new ImpIns();
			return a.getInfoUsernameI(s1);
		}
		
		public String getInfoPswI(int id) {
			Insegnante s1 = new Insegnante(id);
			ImpIns a =new ImpIns();
			return a.getInfoPswI(s1);
		}
		
		//modifica ins
		public boolean ModificaI(String oldus, String oldpsw, String newus, String newpsw)
		{
			Insegnante s = new Insegnante(oldus, oldpsw);
			ImpIns a = new ImpIns();
			return a.modificaIns(s, newus, newpsw);
		}
		
		//elimina ins
		public boolean EliminaI(int id)
		{
			Insegnante s = new Insegnante(id);
			ImpIns a = new ImpIns();
			return a.EliminaIns(s);
		}
		
		//--------------------------
		
		//test
		
		//controllo
		public boolean ControlloDataT(Date datatest)
		{
			if(datatest.before(Date.valueOf(LocalDate.now())))
			{
				return false;
			}else return true;
		}
		
		//createst
		public boolean CreazioneT(String n, Date data, Date dii, Date dfi, int ts, int pm, Date dop, int iden)
		{
			Test t = new Test(n, data, dii, dfi, ts, pm, dop, iden);
			ImpTest a = new ImpTest();
			if(a.Creazione(t)) {
				return true;
			}else return false;
		}
		
		//prendo la tabella test 
		public ArrayList<Test> TabTest(int id)
		{
			Test t = new Test(id);
			ImpTest a = new ImpTest();
			return a.TabTestE(t);
		}
		
		//elimina test
		public void EliminaTest(int idtest, String nome)
		{
			Test t = new Test(idtest, nome);
			ImpTest a = new ImpTest();
			a.EliminaTest1(t);
		}
		
		//modificatest
		public boolean ModificaT(int idtest, String n, Date data, Date dii, Date dfi, int ts, int pm, Date dop, int iden)
		{
			Test t = new Test(idtest, n, data, dii, dfi, ts, pm, dop, iden);
			ImpTest a = new ImpTest();
			if(a.Modifica(t)) {
				return true;
			}else return false;
		}
		
		//tabTest per prenotare il test
		public ArrayList<Test> tabTestP(){
			Test t = new Test();
			ImpTest a = new ImpTest();
			return a.TTP(t);
		}
			
		//prenota Test
		public boolean PrenotaT(int mat, int idt)
		{
			Test t = new Test(idt, mat);
			ImpTest a = new ImpTest();
			return a.Prenota(t);
		}
		
		//tabtestscelti
		public ArrayList<Test> TestScelti(int mat){
			Test t = new Test(mat);
			ImpTest a = new ImpTest();
			return a.TestS(t);
		}
		
		//nometest
		public String getNT(int idt)
		{
			Test t = new Test(idt);
			ImpTest a = new ImpTest();
			return a.getNomeTest(t);
		}
		
		//Datatest
		public Date getDT(int idt)
		{
			Test t = new Test(idt);
			ImpTest a = new ImpTest();
			return a.getDataTest(t);
		}
		
		//Datatest iscr
		public Date getDI(int idt, int mat)
		{
			Test t = new Test(idt, mat);
			ImpTest a = new ImpTest();
			return a.getDataIscr(t);
		}
		
		//temposvolgimento
		public Time getTempoTest(int idt)
		{
			Test t = new Test(idt);
			ImpTest a = new ImpTest();
			return a.getTTest(t);
		}
		
		//puntmin
		public int getpuntmin(int idt)
		{
			Test t = new Test(idt);
			ImpTest a = new ImpTest();
			return a.getPMIN(t);
		}
		//studesaminati
		public ArrayList<Test> studEsaminati(int mat)
		{
			Test t = new Test(mat);
			ImpTest a = new ImpTest();
			return a.studentiEs(t);
		}
		
		//idtestscelti
		public ArrayList<Test> testsceltiID(int mat)
		{
			Test t = new Test(mat);
			ImpTest a = new ImpTest();
			return a.TSID(t);
		}
		
		//recuper id ins da test
		public int getIdI(int idt)
		{
			Test t = new Test(idt);
			ImpTest a = new ImpTest();
			return a.getIdINS(t);
		}
		//--------------------------
		
		//quiz
		
		//quiz aperto creazione
		public void creaQA(String td, int pmax, int pmin, int cm, String materia) {
			quizAperto a = new quizAperto(td, pmax, pmin, cm, materia);
			ImpQuizA s= new ImpQuizA();
			s.creaQuiz(a);
		}
		
		//creo la tupla in ammette quiz a
		public void creaAmQ(int idtest, int idquiz) {
			AmmetteQuizA q = new AmmetteQuizA(idtest, idquiz);
			ImpQuizA s= new ImpQuizA();
			s.creaAmmQ(q);
		}
		
		//recupero idqa da quiza
		public int getIDQA(String td, int pmax, int pmin, int cm, String materia)
		{
			quizAperto a = new quizAperto(td, pmax, pmin, cm, materia);
			ImpQuizA s= new ImpQuizA();
			return s.getIDQA1(a);
		}
		
		//quiz multiplo creazione
		public void creaQM(String td, int pb, int pm, String materia, String rg, String rs1, String rs2, String rs3) {
			quizMultiplo a = new quizMultiplo(td, pb, pm, materia, rg, rs1, rs2, rs3);
			ImpQuizM s= new ImpQuizM();
			s.creaQuiz(a);
		}
		
		//creo la tupla in ammette quiz m
		public void creaAmQM(int idtest, int idquiz) {
			AmmetteQuizM q = new AmmetteQuizM(idtest, idquiz);
			ImpQuizM s= new ImpQuizM();
			s.creaAmmQ(q);
		}
		
		//recupero idqm da quizm
		public int getIDQM(String td, int pb, int pm, String materia, String rg, String rs1, String rs2, String rs3)
		{
			quizMultiplo a = new quizMultiplo(td, pb, pm, materia, rg, rs1, rs2, rs3);
			ImpQuizM s= new ImpQuizM();
			return s.getIDQM1(a); 
		}

		//prendo i quiz a da ammettequiza
		public ArrayList<quizAperto> getQA(int idt) {
			AmmetteQuizA a = new AmmetteQuizA(idt);
			ImpQuizA s= new ImpQuizA();
			return s.getQA1(a);
		}
		
		//tramite idqa prendo domanda quiza
		public String getDomandaA(int idqa)
		{
			quizAperto a = new quizAperto(idqa);
			ImpQuizA s= new ImpQuizA();
			return s.getDomandaA1(a); 
		}
		
		//elimina quiz a
		public void EliminaQuizA(int idqa)
		{
			quizAperto a = new quizAperto(idqa);
			ImpQuizA s= new ImpQuizA();
			s.Eliminazione(a);
		}
		
		//prendo i quiz m da ammettequizm
		public ArrayList<quizMultiplo> getQM(int idt) {
			AmmetteQuizM a = new AmmetteQuizM(idt);
			ImpQuizM s= new ImpQuizM();
			return s.getQM1(a);
		}
		
		//elimina quiz m
		public void EliminaQuizM(int idqm)
		{
			quizMultiplo a = new quizMultiplo(idqm);
			ImpQuizM s= new ImpQuizM();
			s.Eliminazione(a);
		}
		
		public String getDomandaM(int idqm)
		{
			quizMultiplo a = new quizMultiplo(idqm);
			ImpQuizM s= new ImpQuizM();
			return s.getDomandaM1(a); 
		}
		
		public ArrayList<quizAperto> idqaQuiz(int idt)
		{
			AmmetteQuizA a = new AmmetteQuizA(idt);
			ImpQuizA s= new ImpQuizA();
			return s.getIDQAtest(a);
		}
		
		public ArrayList<quizMultiplo> idqmQuiz(int idt)
		{
			AmmetteQuizM a = new AmmetteQuizM(idt);
			ImpQuizM s= new ImpQuizM();
			return s.getIDQMtest(a);
		}
		
		public int getPMAX(int idqa)
		{
			quizAperto a = new quizAperto(idqa);
			ImpQuizA s= new ImpQuizA();
			return s.getPmax(a);
		}
		
		public int getPMIN(int idqa)
		{
			quizAperto a = new quizAperto(idqa);
			ImpQuizA s= new ImpQuizA();
			return s.getPmin(a);
		}
		
		//-------------------------
		
		//risposte
		public boolean InsRA(String TR, int mat, int idqa, Date data, int idins)
		{
			RisAperta r = new RisAperta(TR, mat, idqa, data, idins);
			ImpRA a = new ImpRA();
			return a.IRA(r);
		}
		
		public ArrayList<String> getRisposte(int idqm)
		{
			quizMultiplo q = new quizMultiplo(idqm);
			ImpQuizM a = new ImpQuizM();
			return a.getRIS(q);
		}
		
		public boolean InsRM(String TR, int mat, int idqm, Date data)
		{
			RisChiusa r = new RisChiusa(TR, mat, idqm, data);
			ImpRM a = new ImpRM();
			return a.IRM(r);
		}
		
		public String getTR(int idqa, int mat)
		{
			RisAperta r = new RisAperta(idqa, mat);
			ImpRA a = new ImpRA();
			return a.getTR(r);
		}
		
		public boolean updateRA(int punteggioass, String correzioni, String TR, int mat, int idqa)
		{
			RisAperta r = new RisAperta(punteggioass, correzioni, TR, mat, idqa);
			ImpRA a = new ImpRA();
			return a.update(r);
		}
		//---------------------------------------------
		//correzione
		
		//reupero id test in correzione
		public ArrayList<Test> TestCorr(int idins)
		{
			Correzione c = new Correzione(idins);
			ImpCor i = new ImpCor();
			return i.TabTest(c);
		}
		
		//recuper mat da correzione con idt
		public ArrayList<Studente> StudentiPerEsame(int idtest, int idins)
		{
			Correzione c = new Correzione(idtest, idins);
			ImpCor i = new ImpCor();
			return i.StudPerE(c);
		}
		
		public void cambioFlag(int idt, int mat)
		{
			Correzione c = new Correzione(idt, mat);
			ImpCor i = new ImpCor();
			i.Flag(c);
		}
}


package DAO;

import java.util.ArrayList;

import Model.AmmetteQuizM;
import Model.quizMultiplo;

public interface QuizMultipla {

	public void creaQuiz(quizMultiplo q);
	
	public void creaAmmQ(AmmetteQuizM q);
	
	public int getIDQM1(quizMultiplo q);
	
	public ArrayList<quizMultiplo> getQM1(AmmetteQuizM q);
	
	public String getDomandaM1(quizMultiplo q);
	
	public void Eliminazione(quizMultiplo q);
	
	public ArrayList<quizMultiplo> getIDQMtest(AmmetteQuizM q);
	
	public ArrayList<String> getRIS(quizMultiplo q);
	
	
}

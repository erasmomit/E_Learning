package DAO;

import java.util.ArrayList;

import Model.AmmetteQuizA;
import Model.quizAperto;

public interface QuizAperta {

	public void creaQuiz(quizAperto q);
	
	public void creaAmmQ(AmmetteQuizA q);
	
	public int getIDQA1(quizAperto q);
	
	public ArrayList<quizAperto> getQA1(AmmetteQuizA q);
	
	public String getDomandaA1(quizAperto q);
	
	public void Eliminazione(quizAperto q);
	
	public ArrayList<quizAperto> getIDQAtest(AmmetteQuizA q);
	
	public int getPmax(quizAperto q);
	
	public int getPmin(quizAperto q);
	
	
	
}

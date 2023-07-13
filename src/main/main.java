package main;

import Controller.controller;
import GUI.Accesso;

public class main {
	
	public static void main(String[] args)
	{
		controller c = new controller();
		Accesso frame = new Accesso(c);
		frame.show();
	}
	
}


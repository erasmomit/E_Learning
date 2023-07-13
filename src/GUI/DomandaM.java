package GUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Controller.controller;
import Model.quizMultiplo;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JRadioButton;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.awt.event.ActionEvent;
import javax.swing.JList;
import java.awt.Choice;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import javax.swing.ButtonGroup;
import javax.swing.ButtonModel;
import javax.swing.JFrame;
import javax.swing.JRadioButton;
import java.awt.Toolkit;

public class DomandaM extends JFrame {

	private JPanel contentPane;


	/**
	 * Create the frame.
	 * @param idtest 
	 */
	public DomandaM(controller c, ArrayList<quizMultiplo> qm, int indicearray, int mat,  int idins, int idtest) {
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\User\\Desktop\\progetto\\download.jpg"));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 476, 327);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.CYAN);
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addComponent(panel, GroupLayout.DEFAULT_SIZE, 450, Short.MAX_VALUE)
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addComponent(panel, GroupLayout.DEFAULT_SIZE, 278, Short.MAX_VALUE)
		);
		
		JLabel lblNewLabel = new JLabel("DOMANDA : "+ c.getDomandaM(qm.get(indicearray).getIDQM()));
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		
		
		ArrayList<String> a = c.getRisposte(qm.get(indicearray).getIDQM());
		
		JRadioButton rdbtnNewRadioButton = new JRadioButton(""+a.get(0));
		rdbtnNewRadioButton.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		JRadioButton rdbtnC = new JRadioButton(""+a.get(1));
		rdbtnC.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		JRadioButton rdbtnD = new JRadioButton(""+a.get(2));
		rdbtnD.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		JRadioButton rdbtnA = new JRadioButton(""+a.get(3));
		rdbtnA.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		ButtonGroup gruppo = new ButtonGroup();
		gruppo.add(rdbtnA);
		gruppo.add(rdbtnD);
		gruppo.add(rdbtnC);
		gruppo.add(rdbtnNewRadioButton);
		
		
		JButton btnNewButton = new JButton("AVANTI");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String A = new String();
				
				if(rdbtnNewRadioButton.isSelected()){
					 A = rdbtnNewRadioButton.getText();
				}else if(rdbtnC.isSelected()) {
					 A = rdbtnC.getText();
				}else if(rdbtnD.isSelected()) {
					 A = rdbtnD.getText();
				}else if(rdbtnA.isSelected()) {
					 A = rdbtnA.getText();
				}
				
				if(c.InsRM(A, mat, qm.get(indicearray).getIDQM(), java.sql.Date.valueOf(LocalDate.now())))
				{
					if(qm.size() > (indicearray + 1))
					{
						DomandaM n = new DomandaM(c, qm, (indicearray+1), mat, idins, idtest);
						n.show();
						dispose();
					}else {
						TestConcluso a = new TestConcluso(c, mat, idins, idtest);
						a.show();
						dispose();
					}
				}
			}
		});
		
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 20));
		
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createSequentialGroup()
							.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
								.addComponent(rdbtnA, GroupLayout.PREFERRED_SIZE, 137, GroupLayout.PREFERRED_SIZE)
								.addComponent(rdbtnD, GroupLayout.PREFERRED_SIZE, 137, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblNewLabel)
								.addGroup(gl_panel.createParallelGroup(Alignment.TRAILING, false)
									.addComponent(rdbtnNewRadioButton, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
									.addComponent(rdbtnC, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 137, Short.MAX_VALUE)))
							.addGap(278))
						.addGroup(Alignment.TRAILING, gl_panel.createSequentialGroup()
							.addComponent(btnNewButton, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE)
							.addGap(21))))
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblNewLabel)
					.addGap(28)
					.addComponent(rdbtnA, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(rdbtnNewRadioButton)
					.addGap(18)
					.addComponent(rdbtnC, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(rdbtnD, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED, 13, Short.MAX_VALUE)
					.addComponent(btnNewButton, GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE)
					.addContainerGap())
		);
		panel.setLayout(gl_panel);
		contentPane.setLayout(gl_contentPane);
	}
}

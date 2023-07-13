package GUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Controller.controller;
import DAO.QuizAperta;
import Model.quizAperto;

import java.awt.Toolkit;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextPane;
import javax.swing.JTextField;

public class CorrezioneDomandaA extends JFrame {

	private JPanel contentPane;
	private JTextField textField;

	/**
	 * Create the frame.
	 */
	public CorrezioneDomandaA(controller c, int mat, int idtest, int idins, ArrayList<quizAperto> idquiz, int indicearray) {
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\EliteBook\\OneDrive\\Desktop\\progetto\\download.jpg"));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 593, 367);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.CYAN);
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addComponent(panel, GroupLayout.DEFAULT_SIZE, 424, Short.MAX_VALUE)
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addComponent(panel, GroupLayout.DEFAULT_SIZE, 251, Short.MAX_VALUE)
		);
		
		JLabel lblNewLabel = new JLabel("Testo Domanda : "+ c.getDomandaA(idquiz.get(indicearray).getId()));
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		JButton btnNewButton = new JButton("ANNULLA");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MatricolaCorr m = new MatricolaCorr(c, idins, idtest);
				m.show();
				dispose();
			}
		});
		
		JLabel lblNewLabel_1 = new JLabel("Testo Risposta : ");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		JScrollPane scrollPane = new JScrollPane();
		
		JLabel lblNewLabel_2 = new JLabel("Punteggio Risposta (range punteggio della risposta "+c.getPMIN(idquiz.get(indicearray).getId())+" - "+c.getPMAX(idquiz.get(indicearray).getId())+") : ");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		textField = new JTextField();
		textField.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textField.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("Inserire Correzioni (facoltativo)");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		JScrollPane scrollPane_1 = new JScrollPane();
		
		JTextPane textPane = new JTextPane();
		textPane.setFont(new Font("Tahoma", Font.PLAIN, 15));
		scrollPane_1.setViewportView(textPane);
		
		JButton btnNewButton_1 = new JButton("AVANTI");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(c.updateRA(Integer.parseInt(textField.getText()), textPane.getText(), c.getTR(idquiz.get(indicearray).getId(), mat), mat, idquiz.get(indicearray).getId())) 
				{
					if(idquiz.size() > (indicearray + 1)) {
						CorrezioneDomandaA a = new CorrezioneDomandaA(c, mat, idtest, idins, idquiz, (indicearray+1));
						a.show();
						dispose();
					}else {
						c.cambioFlag(idtest, mat);;					
						CorrezioneTerminata s = new CorrezioneTerminata(c, idins);
						s.show();
						dispose();
					}
				}else {
					DatiErrati e1 = new DatiErrati();
					e1.show();
				}
			}
		});
		btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createSequentialGroup()
							.addContainerGap()
							.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_panel.createSequentialGroup()
									.addComponent(lblNewLabel)
									.addPreferredGap(ComponentPlacement.RELATED, 273, Short.MAX_VALUE)
									.addComponent(btnNewButton))
								.addComponent(lblNewLabel_1)
								.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 517, GroupLayout.PREFERRED_SIZE)
								.addGroup(gl_panel.createSequentialGroup()
									.addComponent(lblNewLabel_2)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(textField, GroupLayout.PREFERRED_SIZE, 69, GroupLayout.PREFERRED_SIZE))
								.addComponent(lblNewLabel_3)))
						.addGroup(Alignment.TRAILING, gl_panel.createSequentialGroup()
							.addGap(12)
							.addComponent(scrollPane_1, GroupLayout.DEFAULT_SIZE, 442, Short.MAX_VALUE)
							.addGap(18)
							.addComponent(btnNewButton_1)))
					.addContainerGap())
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(25)
							.addComponent(lblNewLabel))
						.addGroup(gl_panel.createSequentialGroup()
							.addContainerGap()
							.addComponent(btnNewButton)))
					.addGap(18)
					.addComponent(lblNewLabel_1)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 63, GroupLayout.PREFERRED_SIZE)
					.addGroup(gl_panel.createParallelGroup(Alignment.TRAILING)
						.addGroup(Alignment.LEADING, gl_panel.createSequentialGroup()
							.addGap(18)
							.addGroup(gl_panel.createParallelGroup(Alignment.TRAILING)
								.addComponent(lblNewLabel_2)
								.addComponent(textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addGap(18)
							.addComponent(lblNewLabel_3)
							.addGap(15)
							.addComponent(scrollPane_1, GroupLayout.DEFAULT_SIZE, 62, Short.MAX_VALUE))
						.addGroup(gl_panel.createSequentialGroup()
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(btnNewButton_1)))
					.addContainerGap())
		);
		
		
		
		JTextPane txtpnCiao = new JTextPane();
		txtpnCiao.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtpnCiao.setText(""+c.getTR(idquiz.get(indicearray).getId(), mat));
		txtpnCiao.setEditable(false);
		scrollPane.setViewportView(txtpnCiao);
		panel.setLayout(gl_panel);
		contentPane.setLayout(gl_contentPane);
		
		
	}
}

package GUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import Controller.controller;
import Model.Test;
import Model.quizAperto;

import java.awt.Toolkit;
import java.util.ArrayList;
import java.util.stream.Stream;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JScrollPane;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class SceltaQuizAEl extends JFrame {

	private JPanel contentPane;
	private JTable table;

	/**
	 * Create the frame.
	 */
	public SceltaQuizAEl(controller c, int id, ArrayList<Test> test) {
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\EliteBook\\OneDrive\\Desktop\\progetto\\download.jpg"));
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 513, 285);
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
		
		JLabel lblNewLabel = new JLabel("Scegli Quiz");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		
		JScrollPane scrollPane = new JScrollPane();
		
		JButton btnNewButton = new JButton("ANNULLA");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		
		ArrayList<quizAperto> quizdael = new ArrayList<quizAperto>();
		
		JButton btnNewButton_1 = new JButton("ELIMINA");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				for(int i=0; i<table.getRowCount(); i++)
				{
					Boolean checked = Boolean.valueOf(table.getValueAt(i, 0).toString());
					if(checked)
					{
						quizAperto nuovo = new quizAperto((int) table.getValueAt(i, 1));
						quizdael.add(nuovo);
					}
				}
				
				for(int i = 0; i<quizdael.size(); i++)
				{
					c.EliminaQuizA(quizdael.get(i).getId());
				}
				
				ElimEffettuata gg = new ElimEffettuata();
				gg.show();
				dispose();
			}
		});
		btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(Alignment.TRAILING, gl_panel.createSequentialGroup()
							.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 253, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED, 107, Short.MAX_VALUE)
							.addComponent(btnNewButton_1))
						.addGroup(gl_panel.createSequentialGroup()
							.addComponent(lblNewLabel)
							.addPreferredGap(ComponentPlacement.RELATED, 212, Short.MAX_VALUE)
							.addComponent(btnNewButton)))
					.addContainerGap())
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel)
						.addComponent(btnNewButton))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_panel.createParallelGroup(Alignment.TRAILING)
						.addComponent(btnNewButton_1)
						.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 175, Short.MAX_VALUE))
					.addContainerGap())
		);
		
		table = new JTable();
		
		DefaultTableModel model = new DefaultTableModel()
		{
			public Class<?> getColumnClass(int column)
			{
				switch(column) {
				case 0:
					return Boolean.class;
				case 1:
					return int.class;
				case 2:
					return String.class;
					default:
						return String.class;
				}
			}
		};
		
		table.setModel(model);
		
		model.addColumn("Selezionato");
		model.addColumn("CodiceQuiz");
		model.addColumn("TestoDomanda");
		
		//prendo tutti i codici dei quiz presenti nei test selezionati
		ArrayList<quizAperto> qaCodici = new ArrayList<quizAperto>();
		for(int i=0; i<test.size(); i++)
		{
			qaCodici.addAll(c.getQA(test.get(i).getIdt()));
		}
		
		ArrayList<quizAperto> qa = new ArrayList<quizAperto>();;
		for(int i=0; i<qaCodici.size(); i++)
		{
			quizAperto nuovo = new quizAperto(qaCodici.get(i).getId(), c.getDomandaA(qaCodici.get(i).getId()));
			qa.add(nuovo);
		}
		
		int rows = qa.size();
		
		for(int i=0; i<rows; i++) {
			model.addRow(new Object[0]);
			model.setValueAt(false, i, 0);
			model.setValueAt(qa.get(i).getId(), i, 1);
			model.setValueAt(qa.get(i).getTD(), i, 2);
		}
		table.setBackground(Color.CYAN);
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		
		table.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		scrollPane.setViewportView(table);
		panel.setLayout(gl_panel);
		contentPane.setLayout(gl_contentPane);
	}
}

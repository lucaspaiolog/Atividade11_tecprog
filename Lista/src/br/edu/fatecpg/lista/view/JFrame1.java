package br.edu.fatecpg.lista.view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class JFrame1 extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txt_nome;
	private JTextField txt_telefone;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JFrame1 frame = new JFrame1();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public JFrame1() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		txt_nome = new JTextField();
		txt_nome.setBounds(32, 30, 377, 19);
		contentPane.add(txt_nome);
		txt_nome.setColumns(10);
		
		txt_telefone = new JTextField();
		txt_telefone.setBounds(32, 74, 377, 19);
		contentPane.add(txt_telefone);
		txt_telefone.setColumns(10);
		
		JButton btn_cadastrar = new JButton("Cadastrar");
		btn_cadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btn_cadastrar.setBounds(32, 128, 377, 25);
		contentPane.add(btn_cadastrar);
		
		JButton btn_listar = new JButton("Listar");
		btn_listar.setBounds(321, 226, 117, 25);
		contentPane.add(btn_listar);
	}
}

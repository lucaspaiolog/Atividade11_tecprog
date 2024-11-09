package br.edu.fatecpg.lista.view;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import br.edu.fatecpg.lista.model.Aluno;

import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class JFrame1 extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JTextField txt_nome;
    private JTextField txt_telefone;
    private ArrayList<Aluno> listaAlunos = new ArrayList<>(); 

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
                String nome = txt_nome.getText();
                String telefone = txt_telefone.getText();

                if (!nome.isEmpty() && !telefone.isEmpty()) {
                    listaAlunos.add(new Aluno(nome, telefone));
                    JOptionPane.showMessageDialog(null, "Aluno cadastrado com sucesso!");
                    txt_nome.setText("");
                    txt_telefone.setText("");
                } else {
                    JOptionPane.showMessageDialog(null, "Por favor, preencha todos os campos.");
                }
            }
        });
        btn_cadastrar.setBounds(32, 128, 377, 25);
        contentPane.add(btn_cadastrar);

        JButton btn_listar = new JButton("Listar");
        btn_listar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                StringBuilder lista = new StringBuilder("Lista de Alunos:\n");
                for (Aluno aluno : listaAlunos) {
                    lista.append("Nome: ").append(aluno.getNome()).append(", Telefone: ").append(aluno.getTelefone()).append("\n");
                }
                JOptionPane.showMessageDialog(null, lista.toString());
            }
        });
        btn_listar.setBounds(321, 226, 117, 25);
        contentPane.add(btn_listar);
    }
}


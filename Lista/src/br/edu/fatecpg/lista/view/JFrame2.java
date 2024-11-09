package br.edu.fatecpg.lista.view;

import javax.swing.*;
import br.edu.fatecpg.lista.model.Aluno;

import java.awt.FlowLayout;
import java.util.ArrayList;

public class JFrame2 extends JFrame {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JComboBox<Aluno> alunoComboBox;
    private JTextField nomeField;
    private JTextField telefoneField;
    private JButton atualizarButton;
    private JButton excluirButton;
    private ArrayList<Aluno> listaAlunos;

    public JFrame2(ArrayList<Aluno> listaAlunos) {
        this.listaAlunos = listaAlunos;
        initializeComponents();
    }

    private void initializeComponents() {
        alunoComboBox = new JComboBox<>(new DefaultComboBoxModel<>(listaAlunos.toArray(new Aluno[0])));
        nomeField = new JTextField(20);
        telefoneField = new JTextField(15);
        atualizarButton = new JButton("Atualizar");
        excluirButton = new JButton("Excluir");

        alunoComboBox.addActionListener(e -> {
            Aluno alunoSelecionado = (Aluno) alunoComboBox.getSelectedItem();
            if (alunoSelecionado != null) {
                nomeField.setText(alunoSelecionado.getNome());
                telefoneField.setText(alunoSelecionado.getTelefone());
            }
        });

        atualizarButton.addActionListener(e -> {
            Aluno alunoSelecionado = (Aluno) alunoComboBox.getSelectedItem();
            if (alunoSelecionado != null) {
                alunoSelecionado.setNome(nomeField.getText());
                alunoSelecionado.setTelefone(telefoneField.getText());
                JOptionPane.showMessageDialog(null, "Aluno atualizado com sucesso!");
                alunoComboBox.repaint();
            }
        });

        excluirButton.addActionListener(e -> {
            Aluno alunoSelecionado = (Aluno) alunoComboBox.getSelectedItem();
            if (alunoSelecionado != null) {
                int confirm = JOptionPane.showConfirmDialog(null, "Tem certeza que deseja excluir o aluno?", "Confirmação", JOptionPane.YES_NO_OPTION);
                if (confirm == JOptionPane.YES_OPTION) {
                    listaAlunos.remove(alunoSelecionado);
                    alunoComboBox.removeItem(alunoSelecionado);
                    JOptionPane.showMessageDialog(null, "Aluno excluído com sucesso!");
                    nomeField.setText("");
                    telefoneField.setText("");
                }
            }
        });

        setLayout(new FlowLayout());
        add(new JLabel("Selecione o Aluno:"));
        add(alunoComboBox);
        add(new JLabel("Nome:"));
        add(nomeField);
        add(new JLabel("Telefone:"));
        add(telefoneField);
        add(atualizarButton);
        add(excluirButton);

        setSize(300, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                ArrayList<Aluno> listaAlunos = new ArrayList<>();
                listaAlunos.add(new Aluno("João", "123456789"));
                listaAlunos.add(new Aluno("Maria", "987654321"));

                JFrame2 frame = new JFrame2(listaAlunos);
                frame.setVisible(true);
            }
        });
    }
}


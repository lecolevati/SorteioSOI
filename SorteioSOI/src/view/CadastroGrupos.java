package view;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;

import dao.Dao;

public class CadastroGrupos extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField tfLider;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CadastroGrupos frame = new CadastroGrupos();
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
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public CadastroGrupos() {
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		setBounds(100, 100, 800, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		tfLider = new JTextField();
		tfLider.setBounds(96, 62, 236, 20);
		contentPane.add(tfLider);
		tfLider.setColumns(10);
		
		JLabel lblNome = new JLabel("Nome");
		lblNome.setBounds(10, 65, 46, 14);
		contentPane.add(lblNome);
		
		final JComboBox cbTurno = new JComboBox();
		cbTurno.setModel(new DefaultComboBoxModel(new String[] {"T", "N"}));
		cbTurno.setBounds(526, 62, 46, 20);
		contentPane.add(cbTurno);
		
		JLabel lblTurno = new JLabel("Turno");
		lblTurno.setBounds(464, 65, 46, 14);
		contentPane.add(lblTurno);
		
		JButton btnCadastrar = new JButton("Cadastrar");
		btnCadastrar.setBounds(10, 115, 105, 23);
		contentPane.add(btnCadastrar);
		
		JButton btnFechar = new JButton("FECHAR");
		btnFechar.setBounds(10, 211, 105, 23);
		contentPane.add(btnFechar);
		
		btnCadastrar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				String lider = tfLider.getText();
				String turno = "";
				if (cbTurno.getSelectedIndex() == 0){
					turno = "T";
				} else {
					turno = "N";
				}
				Dao dao = new Dao();
				boolean inserido = dao.insereGrupo(lider, turno);
				if (inserido){
					JOptionPane.showMessageDialog(null, "Inserido com Sucesso", "Mensagem", JOptionPane.INFORMATION_MESSAGE);
				} else {
					JOptionPane.showMessageDialog(null, "Não Inserido", "ERRO !!!", JOptionPane.ERROR_MESSAGE);
				}
				tfLider.setText("");
			}
		});
		
		btnFechar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				dispose();
			}
		});
		
	}
}

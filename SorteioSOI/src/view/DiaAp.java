package view;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JButton;

import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

import controller.RodarController;

public class DiaAp extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField tfLider;
	private static JButton btnSortear = new JButton("Sortear Apresenta\u00E7\u00E3o");

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DiaAp frame = new DiaAp();
					frame.setVisible(true);
					btnSortear.requestFocus();
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
	public DiaAp() {
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		setBounds(100, 100, 800, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		tfLider = new JTextField();
		tfLider.setEditable(false);
		tfLider.setBounds(109, 65, 160, 20);
		contentPane.add(tfLider);
		tfLider.setColumns(10);
		
		JLabel lblGrupo = new JLabel("Grupo");
		lblGrupo.setBounds(25, 68, 46, 14);
		contentPane.add(lblGrupo);
		
		
		btnSortear.setBounds(25, 134, 179, 23);
		contentPane.add(btnSortear);
		
		
		JButton btnFechar = new JButton("FECHAR");
		btnFechar.setBounds(25, 236, 89, 23);
		contentPane.add(btnFechar);
		
		JLabel lblTurno = new JLabel("Turno");
		lblTurno.setBounds(369, 68, 46, 14);
		contentPane.add(lblTurno);
		
		final JComboBox cbTurno = new JComboBox();
		cbTurno.setModel(new DefaultComboBoxModel(new String[] {"T", "N"}));
		cbTurno.setBounds(425, 65, 51, 20);
		contentPane.add(cbTurno);
		
		btnFechar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				dispose();
			}
		});
		
		RodarController rc = new RodarController(tfLider, cbTurno, btnSortear);
		btnSortear.addActionListener(rc);
	}
}

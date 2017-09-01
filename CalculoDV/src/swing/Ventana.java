package swing;

import java.awt.EventQueue;


import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JTextField;

import org.jb2011.lnf.beautyeye.BeautyEyeLNFHelper;

import algoritmo.CalculoDigitoVerificador;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;

public class Ventana {

	private JFrame frmCalculoDigitoVerificador;
	private JTextField tfRuc;
	private JTextField tfDigito;
	private JButton btnNewButton;
	private JLabel lblformatoInvlido;

	/**
	 * Launch the application.
	 */
	/*
	 * El metodo debe recibir el R.U.C. en tipo de dato String e Integer, los mismo valores deben de ser cargados a una
	 * variable antes de pasar al metodo de calculo
	 * 
	 * */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				
				try {
					BeautyEyeLNFHelper.frameBorderStyle = BeautyEyeLNFHelper.FrameBorderStyle.osLookAndFeelDecorated ;
					org.jb2011
					.lnf.beautyeye.BeautyEyeLNFHelper.launchBeautyEyeLNF();
				} catch (Exception e) {
				}
				
				try {
					Ventana window = new Ventana();
					window.frmCalculoDigitoVerificador.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Ventana() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmCalculoDigitoVerificador = new JFrame();
		frmCalculoDigitoVerificador.setTitle("Calcular D\u00EDgito");
		frmCalculoDigitoVerificador.setBounds(100, 100, 266, 235);
		frmCalculoDigitoVerificador.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmCalculoDigitoVerificador.getContentPane().setLayout(null);
		
		frmCalculoDigitoVerificador.setLocationRelativeTo(null);
		
		JLabel lblCalculoDelDigito = new JLabel("C\u00E1lculo del D\u00EDgito Verificador");
		lblCalculoDelDigito.setFont(new Font("Century Gothic", Font.BOLD | Font.ITALIC, 14));
		lblCalculoDelDigito.setForeground(new Color(0, 0, 0));
		lblCalculoDelDigito.setBounds(20, 11, 205, 31);
		frmCalculoDigitoVerificador.getContentPane().add(lblCalculoDelDigito);
		
		tfRuc = new JTextField();
		tfRuc.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent arg0) {
				tfRuc.selectAll();
			}
		});
		tfRuc.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				lblformatoInvlido.setVisible(false);
				tfDigito.setText("");
			}
		});
		tfRuc.setBounds(65, 78, 114, 20);
		frmCalculoDigitoVerificador.getContentPane().add(tfRuc);
		tfRuc.setColumns(10);
		
		JLabel lblIngreseSuRuc = new JLabel("Ingrese su R.U.C sin d\u00EDgito verificador");
		lblIngreseSuRuc.setBounds(35, 53, 205, 14);
		frmCalculoDigitoVerificador.getContentPane().add(lblIngreseSuRuc);
		
		tfDigito = new JTextField();
		tfDigito.setEditable(false);
		tfDigito.setBounds(143, 125, 36, 20);
		frmCalculoDigitoVerificador.getContentPane().add(tfDigito);
		tfDigito.setColumns(10);
		
		JLabel lblSuDgitoEs = new JLabel("Su d\u00EDgito es:");
		lblSuDgitoEs.setBounds(79, 128, 65, 14);
		frmCalculoDigitoVerificador.getContentPane().add(lblSuDgitoEs);
		
		btnNewButton = new JButton("Calcular");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				iniciarCalculo();
			}
		});
		btnNewButton.setBounds(20, 162, 205, 23);
		frmCalculoDigitoVerificador.getContentPane().add(btnNewButton);
		
		lblformatoInvlido = new JLabel("*Formato inv\u00E1lido");
		lblformatoInvlido.setVisible(false);
		lblformatoInvlido.setForeground(Color.RED);
		lblformatoInvlido.setBounds(65, 109, 93, 14);
		frmCalculoDigitoVerificador.getContentPane().add(lblformatoInvlido);
	}
	
	private void calcular(){
		
		int ruc = Integer.parseInt(tfRuc.getText());
		String rucChar = tfRuc.getText();
		
		/*
		 * El metodo debe recibir el R.U.C. en tipo de dato String e Integer, los mismo valores deben de ser cargados a una
		 * variable antes de pasar al metodo de calculo
		 * 
		 * */
		
		int resultado = CalculoDigitoVerificador.calculandoDigito(rucChar, ruc);
		tfDigito.setText(resultado+"");
	}
	
	private void iniciarCalculo(){
		try {
			if(!tfRuc.getText().isEmpty()){
				calcular();
			}
		} catch (Exception e) {
			e.printStackTrace();
			lblformatoInvlido.setVisible(true);
			tfRuc.requestFocus();
		}
	}
}

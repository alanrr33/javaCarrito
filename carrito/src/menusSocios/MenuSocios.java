package menusSocios;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import menus.MenuPrincipal;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class MenuSocios extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MenuSocios frame = new MenuSocios();
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
	public MenuSocios() {
		setTitle("Menu");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 300, 375);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btn_alta = new JButton("Alta");
		btn_alta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				VerificarDni obj = new VerificarDni();
				obj.setVisible(true);
				 dispose();
				
			}
		});
		btn_alta.setBounds(90, 50, 100, 23);
		contentPane.add(btn_alta);
		
		JButton btn_mod = new JButton("Modificacion");
		btn_mod.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				MenuMod obj = new MenuMod();
				obj.setVisible(true);
			}
		});
		btn_mod.setBounds(90, 100, 100, 23);
		contentPane.add(btn_mod);
		
		JButton btn_busq = new JButton("Busqueda");
		btn_busq.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				MenuBusqDni obj=new MenuBusqDni();
				obj.setVisible(true);
				
			}
		});
		btn_busq.setBounds(90, 150, 100, 23);
		contentPane.add(btn_busq);
		
		JButton btn_volver = new JButton("Volver");
		btn_volver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				 dispose();
				MenuPrincipal obj = new MenuPrincipal();
				obj.setVisible(true);
				
			}
		});
		btn_volver.setBounds(90, 252, 100, 23);
		contentPane.add(btn_volver);
	}
}

package menusLibros;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import menus.MenuPrincipal;
import menusSocios.VerificarDni;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class MenuLibros extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MenuLibros frame = new MenuLibros();
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
	public MenuLibros() {
		setTitle("Menu libros");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 275, 410);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btn_alta = new JButton("Alta");
		btn_alta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				VerificarIsbn obj = new VerificarIsbn();
				obj.setVisible(true);
				 dispose();
			}
		});
		btn_alta.setBounds(80, 50, 100, 23);
		contentPane.add(btn_alta);
		
		JButton btn_mod = new JButton("Modificacion");
		btn_mod.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				ModLibro obj=new ModLibro();
				obj.setVisible(true);
			}
		});
		btn_mod.setBounds(80, 100, 100, 23);
		contentPane.add(btn_mod);
		
		JButton btn_busq = new JButton("Busqueda");
		btn_busq.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				BusquedaLibros obj =new BusquedaLibros();
				obj.setVisible(true);
				
				
			}
		});
		btn_busq.setBounds(80, 150, 100, 23);
		contentPane.add(btn_busq);
		
		JButton btn_volver = new JButton("Volver");
		btn_volver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 dispose();
				MenuPrincipal obj = new MenuPrincipal();
				obj.setVisible(true);
				
				
			}
		});
		btn_volver.setBounds(80, 320, 89, 23);
		contentPane.add(btn_volver);
		
		JButton btnNewButton = new JButton("Alta ejemplar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				MenuAltaEjemplar obj= new MenuAltaEjemplar();
				obj.setVisible(true);
				
				
			}
		});
		btnNewButton.setBounds(80, 200, 100, 23);
		contentPane.add(btnNewButton);
	}
}

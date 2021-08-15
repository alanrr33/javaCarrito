package menus;

import java.awt.BorderLayout;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import menusLibros.MenuLibros;
import menusSocios.MenuSocios;
import menusSocios.VerificarDni;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class MenuPrincipal extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MenuPrincipal frame = new MenuPrincipal();
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
	public MenuPrincipal() {
		setTitle("Menu Principal");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 300, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnAltaSocio = new JButton("Socios");
		btnAltaSocio.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				MenuSocios obj = new MenuSocios();
				obj.setVisible(true);
				 dispose();
			
			}
		});
		btnAltaSocio.setBounds(90, 44, 100, 33);
		contentPane.add(btnAltaSocio);
		
		JButton btnAltaLibro = new JButton("Libros");
		btnAltaLibro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MenuLibros obj = new MenuLibros();
				obj.setVisible(true);
				 dispose();
			}
		});
		btnAltaLibro.setBounds(90, 101, 100, 33);
		contentPane.add(btnAltaLibro);
		
		JButton btnPrestamo = new JButton("Prestamo");
		btnPrestamo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setTitle("Consulta");
			}
		});
		btnPrestamo.setBounds(90, 158, 100, 33);
		contentPane.add(btnPrestamo);
	}
	
	
	
	
}

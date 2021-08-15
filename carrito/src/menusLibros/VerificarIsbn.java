package menusLibros;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import conectarBd.Conexion;
import funcionesControl.Controles;
import menus.MenuPrincipal;
import menusSocios.VerificarDni;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.event.ActionEvent;

public class VerificarIsbn extends JFrame {

	private JPanel contentPane;
	private static JTextField entry_isbn;
	private static String isbn;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VerificarIsbn frame = new VerificarIsbn();
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
	
	
	public VerificarIsbn() {
		setTitle("Verificar Isbn");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 250, 200);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Isbn");
		lblNewLabel.setBounds(10, 40, 46, 14);
		contentPane.add(lblNewLabel);
		
		entry_isbn = new JTextField();
		entry_isbn.setBounds(66, 37, 132, 20);
		contentPane.add(entry_isbn);
		entry_isbn.setColumns(10);
		
		JButton btn_volver = new JButton("Volver");
		btn_volver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				MenuLibros obj = new MenuLibros();
				obj.setVisible(true);
			}
		});
		btn_volver.setBounds(10, 127, 89, 23);
		contentPane.add(btn_volver);
		
		JButton btn_entrar = new JButton("Entrar");
		btn_entrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MenuAltaLibro obj = new MenuAltaLibro();
				obj.setVisible(true);
				 dispose();
			}
		});
		btn_entrar.setBounds(109, 127, 89, 23);
		contentPane.add(btn_entrar);
		btn_entrar.setEnabled(false);
		
		JButton btn_verificar = new JButton("Verficar");
		btn_verificar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				
				
				Statement stm= null;
				Connection con=null;
				ResultSet rs=null;
				
				String sql="SELECT isbn FROM libros WHERE isbn="+entry_isbn.getText();
				
				
				if (Controles.isISBN(entry_isbn.getText())==true) {
					
				
				try {			
					con= Conexion.conectar();
					stm=con.createStatement();
					rs=stm.executeQuery(sql);
					isbn=entry_isbn.getText();
					if (rs.next()!=true) {
						JOptionPane.showMessageDialog(rootPane,"ISBN disponible","Info",1);
						btn_entrar.setEnabled(true);
					} else {
						JOptionPane.showMessageDialog(rootPane,"ISBN no disponible","Info",1);
						btn_entrar.setEnabled(false);
					}
					
					stm.close();
					con.close();
				} catch (SQLException ef) {
					System.out.println("Error Verificar ISBN");
					ef.printStackTrace();
				}
				
				}
				else {
					JOptionPane.showMessageDialog(rootPane,"ISBN debe ser 5 numeros","Info",1);
				}
				
				
				
				
				
				
				
			}
		});
		btn_verificar.setBounds(126, 65, 72, 23);
		contentPane.add(btn_verificar);
		
		
		
	}
	
public static Integer obtenerISBN() {
		String a=entry_isbn.getText();
		int y = Integer.parseInt(a);		
		return y;
	}

public static String getIsbn() {
	return isbn;
}
	
}

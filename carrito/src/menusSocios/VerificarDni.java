package menusSocios;

import conectarBd.Conexion;

import menus.MenuPrincipal;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;



public class VerificarDni extends JFrame {
	
	private JPanel contentPane;
	private static JTextField entry_Dni;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {

		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VerificarDni frame = new VerificarDni();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
					
				}
			}
		});
	}

	
	// checkear si la cadena es numerica
	public static boolean isNumeric(String cadena) {

	   boolean resultado;

	        try {
	            Integer.parseInt(cadena);
	            resultado = true;
	        } catch (NumberFormatException excepcion) {
	            resultado = false;
	        }

	        return resultado;
	   }
	
	/**
	 * Create the frame.
	 */
	
	public VerificarDni() {
		setTitle("Verificacion");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 250, 200);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Dni:");
		lblNewLabel.setBounds(10, 40, 46, 14);
		contentPane.add(lblNewLabel);
		
		entry_Dni = new JTextField();
		entry_Dni.setBounds(80, 37, 125, 20);
		contentPane.add(entry_Dni);
		entry_Dni.setColumns(10);
		
		JButton btnNewButton = new JButton("Volver");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MenuSocios obj = new MenuSocios();
				obj.setVisible(true);
				 dispose();
			
				
			}
		});
		btnNewButton.setBounds(10, 127, 89, 23);
		contentPane.add(btnNewButton);
		
		JButton btn_entrar = new JButton("Entrar");
		btn_entrar.setEnabled(false);
		
		btn_entrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				MenuAltaSocio obj = new MenuAltaSocio();
				obj.setVisible(true);
				
				
			}
		});
		btn_entrar.setBounds(116, 127, 89, 23);
		contentPane.add(btn_entrar);
		
		JButton btnNewButton_2 = new JButton("Verficar");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Statement stm= null;
				Connection con=null;
				ResultSet rs=null;
				
				String sql="SELECT * FROM socios WHERE dni="+entry_Dni.getText();
				
				
				if (isNumeric(entry_Dni.getText())==true) {
					
				
				try {			
					con= Conexion.conectar();
					stm=con.createStatement();
					rs=stm.executeQuery(sql);
					if (rs.next()!=true) {
						JOptionPane.showMessageDialog(rootPane,"Dni disponible","Info",1);
						btn_entrar.setEnabled(true);
					} else {
						JOptionPane.showMessageDialog(rootPane,"Dni no disponible","Info",1);
						btn_entrar.setEnabled(false);
					}
					
					stm.close();
					con.close();
				} catch (SQLException ef) {
					System.out.println("Error Verificar dni");
					ef.printStackTrace();
				}
				
				}
				else {
					JOptionPane.showMessageDialog(rootPane,"Dni debe ser solo numeros","Info",1);
				}
				
				
				
				
			
		
				
			}
		});
		btnNewButton_2.setFont(new Font("Tahoma", Font.PLAIN, 9));
		btnNewButton_2.setBounds(132, 68, 73, 23);
		contentPane.add(btnNewButton_2);
		
		

	}
	public static String obtenerDni() {
		
		return entry_Dni.getText();
	}
	
	 
	

}

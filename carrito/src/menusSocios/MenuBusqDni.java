package menusSocios;

import conectarBd.Conexion;

import funcionesControl.Controles;


import java.awt.BorderLayout; 

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
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

public class MenuBusqDni extends JFrame {

	private JPanel contentPane;
	private JTextField entry_dni;
	private JTextField TF_nombre;
	private JTextField TF_ape;
	private JTextField TF_dni;
	private JTextField TF_dir;
	private JTextField TF_email;
	private JTextField TF_año;
	private JTextField TF_legajo;
	private JTextField TF_cat;
	private JTextField TF_tel;
	//private JLabel label_legajo;
//	private JLabel label_año;
	private String a,x,y,z;
	private JButton btn_volver;
	private JTextField entry_ape;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MenuBusqDni frame = new MenuBusqDni();
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
	public MenuBusqDni() {
		setTitle("Menu Busqueda");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 450);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Ingrese dni");
		lblNewLabel.setBounds(30, 35, 105, 14);
		contentPane.add(lblNewLabel);
		
		entry_dni = new JTextField();
		entry_dni.setBounds(145, 32, 105, 20);
		contentPane.add(entry_dni);
		entry_dni.setColumns(10);
		
		JLabel label_legajo = new JLabel("Legajo");
		label_legajo.setBounds(230, 200, 46, 14);
		contentPane.add(label_legajo);
		label_legajo.setVisible(false);
		
		JLabel label_año = new JLabel("A\u00F1o Ingreso");
		label_año.setBounds(230, 235, 69, 14);
		contentPane.add(label_año);
		label_año.setVisible(false);
		
		JButton btn_buscardni = new JButton("Buscar");
		btn_buscardni.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				TF_nombre.setText("");
				TF_ape.setText("");
				TF_dni.setText("");
				TF_dir.setText("");
				TF_email.setText("");
				TF_tel.setText("");
				TF_cat.setText("");
				TF_legajo.setText("");
				TF_año.setText("");
				
				
				Statement stm= null;
				Connection con=null;
				ResultSet rs=null;
				

				String sql="SELECT nombre,apellido,dni,direccion,email,telefono,categoria,legajo,añoingreso  FROM socios WHERE dni="+entry_dni.getText();
				

				
				if (Controles.isNumeric(entry_dni.getText())==true) {
					
					
					try {			
						con= Conexion.conectar();
						stm=con.createStatement();
						rs=stm.executeQuery(sql);
						//System.out.println("Solo me conecte aca");
						
					
						if (rs.next() == false) {
							JOptionPane.showMessageDialog(rootPane,"No se han encontrado resultados con ee dni","Info",1);
					      } else {

					        do {
					        	
					        	if (rs.getString(7).equals("Alumno")) {
									

									TF_nombre.setText(rs.getString(1));
									TF_ape.setText(rs.getString(2));
									TF_dni.setText(rs.getString(3));
									TF_dir.setText(rs.getString(4));
									TF_email.setText(rs.getString(5));
									TF_tel.setText(rs.getString(6));
									TF_cat.setText(rs.getString(7));
									TF_legajo.setText(rs.getString(8));
									TF_año.setText(rs.getString(9));
									label_legajo.setVisible(true);
									label_año.setVisible(true);
									TF_legajo.setVisible(true);
									TF_año.setVisible(true);
										
									
										}
									else 
																
									if(!rs.getString(7).equals("Alumno")) {
										
									TF_nombre.setText(rs.getString(1));
									TF_ape.setText(rs.getString(2));
									TF_dni.setText(rs.getString(3));
									TF_dir.setText(rs.getString(4));
									TF_email.setText(rs.getString(5));
									TF_tel.setText(rs.getString(6));
									TF_cat.setText(rs.getString(7));
									label_legajo.setVisible(false);
									label_año.setVisible(false);
									TF_legajo.setVisible(false);
									TF_año.setVisible(false);
										
									
										
									}
									
					        	
					        	
									
					        } while (rs.next());
					      }
						
						
						
						
						
						stm.close();
						con.close();
					} catch (SQLException ef) {
						System.out.println("Error Verificar dni");
						ef.printStackTrace();
					}
					
					
					
				
				}
				else {
					JOptionPane.showMessageDialog(rootPane,"El dni tiene caracteres no validos","Info",1);
					entry_dni.requestFocusInWindow();
				}
				
				
			}
		});
		btn_buscardni.setBounds(260, 31, 89, 23);
		contentPane.add(btn_buscardni);
		
		JLabel lblNewLabel_1 = new JLabel("Nombre");
		lblNewLabel_1.setBounds(30, 130, 46, 14);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Apellido");
		lblNewLabel_2.setBounds(30, 165, 46, 14);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Dni");
		lblNewLabel_3.setBounds(30, 200, 46, 14);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Direccion");
		lblNewLabel_4.setBounds(30, 235, 46, 14);
		contentPane.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("Email");
		lblNewLabel_5.setBounds(30, 270, 46, 14);
		contentPane.add(lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel("Telefono");
		lblNewLabel_6.setBounds(230, 130, 46, 14);
		contentPane.add(lblNewLabel_6);
		
		JLabel lblNewLabel_7 = new JLabel("Categoria");
		lblNewLabel_7.setBounds(230, 165, 57, 14);
		contentPane.add(lblNewLabel_7);
		
		
		TF_nombre = new JTextField();
		TF_nombre.setBounds(86, 127, 86, 20);
		contentPane.add(TF_nombre);
		TF_nombre.setColumns(10);
		
		TF_ape = new JTextField();
		TF_ape.setBounds(86, 162, 86, 20);
		contentPane.add(TF_ape);
		TF_ape.setColumns(10);
		
		TF_dni = new JTextField();
		TF_dni.setBounds(86, 197, 86, 20);
		contentPane.add(TF_dni);
		TF_dni.setColumns(10);
		
		TF_dir = new JTextField();
		TF_dir.setBounds(86, 230, 86, 20);
		contentPane.add(TF_dir);
		TF_dir.setColumns(10);
		
		TF_email = new JTextField();
		TF_email.setBounds(86, 267, 134, 20);
		contentPane.add(TF_email);
		TF_email.setColumns(10);
		
		TF_año = new JTextField();
		TF_año.setBounds(300, 232, 86, 20);
		contentPane.add(TF_año);
		TF_año.setColumns(10);
		TF_año.setVisible(false);
		
		TF_legajo = new JTextField();
		TF_legajo.setBounds(300, 197, 86, 20);
		contentPane.add(TF_legajo);
		TF_legajo.setColumns(10);
		TF_legajo.setVisible(false);
		
		TF_cat = new JTextField();
		TF_cat.setBounds(300, 162, 86, 20);
		contentPane.add(TF_cat);
		TF_cat.setColumns(10);
		
		TF_tel = new JTextField();
		TF_tel.setBounds(300, 127, 86, 20);
		contentPane.add(TF_tel);
		TF_tel.setColumns(10);
		
		btn_volver = new JButton("Volver");
		btn_volver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				MenuSocios obj = new MenuSocios();
				obj.setVisible(true);
				
			}
		});
		btn_volver.setBounds(161, 377, 89, 23);
		contentPane.add(btn_volver);
		
		JLabel lblIngreseApellidoA = new JLabel("Ingrese apellido ");
		lblIngreseApellidoA.setBounds(30, 78, 105, 14);
		contentPane.add(lblIngreseApellidoA);
		
		entry_ape = new JTextField();
		entry_ape.setBounds(145, 75, 105, 20);
		contentPane.add(entry_ape);
		entry_ape.setColumns(10);
		
		JButton btn_buscar_ape = new JButton("Buscar");
		btn_buscar_ape.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				TF_nombre.setText("");
				TF_ape.setText("");
				TF_dni.setText("");
				TF_dir.setText("");
				TF_email.setText("");
				TF_tel.setText("");
				TF_cat.setText("");
				TF_legajo.setText("");
				TF_año.setText("");
				
				
				Statement stm= null;
				Connection con=null;
				ResultSet rs=null;
				

				String sql="SELECT nombre,apellido,dni,direccion,email,telefono,categoria,legajo,añoingreso  FROM socios WHERE apellido LIKE '%" + entry_ape.getText() + "%'";
				

				
				if ((entry_ape.getText().isEmpty())==false) {
					
					
					try {			
						con= Conexion.conectar();
						stm=con.createStatement();
						rs=stm.executeQuery(sql);
						//System.out.println("Solo me conecte aca");
						
					
						if (rs.next() == false) {
							JOptionPane.showMessageDialog(rootPane,"No se han encontrado resultados con ese apellido","Info",1);
					      } else {

					        do {
					        	if (rs.getString(7).equals("Alumno")) {
									

									TF_nombre.setText(rs.getString(1));
									TF_ape.setText(rs.getString(2));
									TF_dni.setText(rs.getString(3));
									TF_dir.setText(rs.getString(4));
									TF_email.setText(rs.getString(5));
									TF_tel.setText(rs.getString(6));
									TF_cat.setText(rs.getString(7));
									TF_legajo.setText(rs.getString(8));
									TF_año.setText(rs.getString(9));
									label_legajo.setVisible(true);
									label_año.setVisible(true);
									TF_legajo.setVisible(true);
									TF_año.setVisible(true);
										
									
										}
									else 
																
									if(!rs.getString(7).equals("Alumno")) {
										
									TF_nombre.setText(rs.getString(1));
									TF_ape.setText(rs.getString(2));
									TF_dni.setText(rs.getString(3));
									TF_dir.setText(rs.getString(4));
									TF_email.setText(rs.getString(5));
									TF_tel.setText(rs.getString(6));
									TF_cat.setText(rs.getString(7));
									label_legajo.setVisible(false);
									label_año.setVisible(false);
									TF_legajo.setVisible(false);
									TF_año.setVisible(false);
										
									
										
									}
									
					        } while (rs.next());
					      }
						
						
				
						
						
						stm.close();
						con.close();
					} catch (SQLException ef) {
						System.out.println("Error busqueda por apellido");
						ef.printStackTrace();
					}
					
					
					
				
				}
				else {
					JOptionPane.showMessageDialog(rootPane,"El campo se encuentra vacio","Info",1);
					entry_ape.requestFocusInWindow();
				}
				
				
			}
				
				
				
				
			
		});
		btn_buscar_ape.setBounds(260, 74, 89, 23);
		contentPane.add(btn_buscar_ape);
	}
}

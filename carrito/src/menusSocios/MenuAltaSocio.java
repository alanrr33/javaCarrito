package menusSocios;

import funcionesControl.Controles;


import menus.MenuPrincipal;
import conectarBd.Conexion; 

import socios.Socios;
import socios.socioAlumno;
import socios.socioPND;
import socios.socioProfesor;

import java.awt.BorderLayout;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.FlowLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JButton;
import java.awt.Button;
import javax.swing.JPopupMenu;
import java.awt.Component;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.PreparedStatement;



public class MenuAltaSocio extends JFrame {

	private JPanel contentPane;
	private JTextField entry_Nombre;
	private JTextField entry_Ape;
	private JTextField entry_Dni;
	private JTextField entry_Dir;
	private JTextField entry_Tel;
	private JTextField entry_Email;
	private JTextField entry_Año;
	private JTextField entry_Legajo;
	private String a;

	/**
	 * Launch the application.
	 */
	
	
	
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MenuAltaSocio frame = new MenuAltaSocio();
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
	public MenuAltaSocio() {
		
		setTitle("Alta Socio");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 325, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		JLabel lblNewLabel = new JLabel("Nombre: ");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel.setBounds(10, 85, 74, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Apellido");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_1.setBounds(10, 110, 74, 14);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Dni");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_2.setBounds(10, 135, 74, 14);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Direccion");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_3.setBounds(10, 160, 74, 14);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Telefono");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_4.setBounds(10, 185, 74, 14);
		contentPane.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("Email");
		lblNewLabel_5.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_5.setBounds(10, 210, 74, 14);
		contentPane.add(lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel("Categoria");
		lblNewLabel_6.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_6.setBounds(10, 235, 74, 14);
		contentPane.add(lblNewLabel_6);
		
		JLabel lblNewLabel_7 = new JLabel("A\u00F1o ingreso");
		lblNewLabel_7.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_7.setBounds(10, 260, 74, 14);
		lblNewLabel_7.setVisible(false);
		contentPane.add(lblNewLabel_7);
		
		JLabel lblNewLabel_8 = new JLabel("Legajo");
		lblNewLabel_8.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_8.setBounds(10, 285, 74, 14);
		lblNewLabel_8.setVisible(false);
		contentPane.add(lblNewLabel_8);
		
		entry_Nombre = new JTextField();
		entry_Nombre.setBounds(80, 83, 120, 18);
		contentPane.add(entry_Nombre);
		entry_Nombre.setColumns(10);
		
		entry_Ape = new JTextField();
		entry_Ape.setColumns(10);
		entry_Ape.setBounds(80, 108, 120, 18);
		contentPane.add(entry_Ape);
		
		entry_Dni = new JTextField();
		a=VerificarDni.obtenerDni();
		entry_Dni.setText(a);
		entry_Dni.setColumns(10);
		entry_Dni.setBounds(80, 133, 120, 18);
		entry_Dni.setEnabled(false);
		contentPane.add(entry_Dni); 
		
		
		entry_Dir = new JTextField();
		entry_Dir.setColumns(10);
		entry_Dir.setBounds(80, 158, 120, 18);
		contentPane.add(entry_Dir);
		
		entry_Tel = new JTextField();
		entry_Tel.setColumns(10);
		entry_Tel.setBounds(80, 183, 120, 18);
		contentPane.add(entry_Tel);
		
		entry_Email = new JTextField();
		entry_Email.setColumns(10);
		entry_Email.setBounds(80, 208, 120, 18);
		contentPane.add(entry_Email);
		
		entry_Año = new JTextField();
		entry_Año.setColumns(10);
		entry_Año.setBounds(80, 258, 120, 18);
		entry_Año.setVisible(false);
		contentPane.add(entry_Año);
		
		entry_Legajo = new JTextField();
		entry_Legajo.setColumns(10);
		entry_Legajo.setBounds(80, 283, 120, 18);
		entry_Legajo.setVisible(false);
		contentPane.add(entry_Legajo);
		
		JComboBox comboCat = new JComboBox();
		comboCat.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			    if (e.getSource()==comboCat) {
		            int seleccionado=comboCat.getSelectedIndex();
		            if (seleccionado==1){
		            	lblNewLabel_7.setVisible(true);
		            	lblNewLabel_8.setVisible(true);
		            	entry_Año.setVisible(true);
		            	entry_Legajo.setVisible(true);
		            	}
		            	else {
		            		entry_Año.setText("");
		    				entry_Legajo.setText("");
		            	   	lblNewLabel_7.setVisible(false);
			            	lblNewLabel_8.setVisible(false);
			            	entry_Año.setVisible(false);
			            	entry_Legajo.setVisible(false);
		            	}
		            }
		        }
			
		});
		comboCat.setModel(new DefaultComboBoxModel(new String[] {"<<Seleccione>>", "Alumno", "Profesor", "Personal no docente"}));
		comboCat.setToolTipText("");
		comboCat.setMaximumRowCount(4);
		comboCat.setBounds(80, 232, 120, 18);
		contentPane.add(comboCat);
		
		JButton btnAlta = new JButton("Alta");
		btnAlta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String textoCombo= comboCat.getSelectedItem().toString();
				
				int seleccionado=comboCat.getSelectedIndex();
				
				
				
				
			
				
				
				// chequeo que el campo no este vacio ni contega caracteres invalidos con la funcion isAlpha
				
				//nombre
				if (Controles.isAlpha(entry_Nombre.getText())==true) {
			
				}
				else {
					JOptionPane.showMessageDialog(rootPane,"El nombre tiene caracteres no validos","Info",1);
					entry_Nombre.requestFocusInWindow();
				}
				
				
				//apellido
				if (Controles.isAlpha(entry_Ape.getText())==true) {
					
				}
				else {
					JOptionPane.showMessageDialog(rootPane,"El apellido tiene caracteres no validos","Info",1);
					entry_Ape.requestFocusInWindow();
				}
				
	
				//Direccion
				
				if (Controles.isDir(entry_Dir.getText())==true) {
										
				}
				else {
					JOptionPane.showMessageDialog(rootPane,"La direccion tiene caracteres no validos","Info",1);
					entry_Dir.requestFocusInWindow();
					
				}

				//Telefono
				if (Controles.isNumeric(entry_Tel.getText())==true){

				}
				else {
					JOptionPane.showMessageDialog(rootPane,"El telefono tiene caracteres no validos","Info",1);
					entry_Tel.requestFocusInWindow();
				}
				
				// Email
				
				if (Controles.isEmail(entry_Email.getText())==true) {

				}
				else {
					JOptionPane.showMessageDialog(rootPane,"Mail tiene que ser de la forma 'xxxxxx@xxxx.com' ","Info",1);
					entry_Dir.requestFocusInWindow();
					
				}
				
				
				//Combo categoria
			  
			    if (seleccionado==-1|| seleccionado==0){
			     	JOptionPane.showMessageDialog(rootPane,"Seleccione una opcion valida del combo","Info",1);

			            }
			            else {

			            	}

			    
	
				// uso la sentencia switch con las variables del combo categoria
				switch (seleccionado) {
				
				case 1:
				
				
					if (Controles.isAño(entry_Año.getText())==true){
					
					}
					else {
						JOptionPane.showMessageDialog(rootPane,"El año contiene caracteres no validos, Forma correcta: '2008' ","Info",1);
						entry_Año.requestFocusInWindow();
					
					}
					if (Controles.isLegajo(entry_Legajo.getText())==true){
						
					}
					else {
						JOptionPane.showMessageDialog(rootPane,"El legajo contiene caracteres no validos, Forma correcta: '123456' ","Info",1);
						entry_Legajo.requestFocusInWindow();
					
					}
				    
					
				
						//instanciamos el objeto alumno que se crea a partir de los campos entry para luego recuperarlo mediante el getter para introducirlos a la bd
						//socioAlumno socio1 = new socioAlumno(0,entry_Nombre.getText(),entry_Ape.getText(),a,entry_Dir.getText(),entry_Email.getText(),entry_Tel.getText(),null,null, 0,0,0,0,0,0,0,entry_Legajo.getText(),entry_Año.getText());
						socioAlumno socio1=new socioAlumno();
						socio1.setNom(entry_Nombre.getText());
						socio1.setApe(entry_Ape.getText());
						socio1.setDni(a);
						socio1.setDir(entry_Dir.getText());
						socio1.setEmail(entry_Email.getText());
						socio1.setTel(entry_Tel.getText());
						socio1.setLegajo(entry_Legajo.getText());
						socio1.setAñoingreso(entry_Año.getText());
						socio1.imprimirSocioAlu();
						
						Connection con1=null;
						PreparedStatement pstmt1 = null;
						
						
						String sql1="INSERT INTO socios (socio_id,nombre,apellido,dni,direccion,email,telefono,categoria,legajo,añoingreso,fechaAlta,cantMaxLibros,cantLibros) values (NULL,?,?,?,?,?,?,?,?,?,NOW(),?,?)";
						
		
						try {			
							con1= Conexion.conectar();
							pstmt1 = con1.prepareStatement(sql1);
							
							pstmt1.setString(1, socio1.getNombre());
							pstmt1.setString(2, socio1.getApellido());
							pstmt1.setString(3,socio1.getDni());
							pstmt1.setString(4,socio1.getDireccion());
							pstmt1.setString(5, socio1.getEmail());
							pstmt1.setString(6, socio1.getTel());
							pstmt1.setString(7, socio1.getCat());
							pstmt1.setString(8, socio1.getLegajo());
							pstmt1.setString(9, socio1.getAñoingreso());
							//fechalta
							pstmt1.setInt(10,socio1.getCantML()); 
							pstmt1.setInt(11,socio1.getCantL());
						
							pstmt1.execute();
							JOptionPane.showMessageDialog(rootPane,"Alta alumno exitosa ","Info",1);
							
							pstmt1.close();
							con1.close();
							dispose();
							MenuPrincipal obj = new MenuPrincipal();
							obj.setVisible(true);
							
							
						} catch (SQLException ef) {
							System.out.println("Error en insertar socio alumno");
							ef.printStackTrace();
						}
						
					
					; // fin del case 1
				break;
					
					
				case 2:
				case 3:
				
						
						
						Connection con=null;
						PreparedStatement pstmt = null;
						String comboTexto= comboCat.getSelectedItem().toString();

						
						//instanciamos el objeto socio que se crea a partir de los campos entry para luego recuperarlo mediante el getter para introducirlos a la bd
						//Socios socio2 = new Socios(0,entry_Nombre.getText(),entry_Ape.getText(),a,entry_Dir.getText(),entry_Email.getText(),entry_Tel.getText(),comboTexto,null, 0,0,0,0,0,0,0);
						Socios socio2=new Socios();
						socio2.setNom(entry_Nombre.getText());
						socio2.setApe(entry_Ape.getText());
						socio2.setDni(a);
						socio2.setDir(entry_Dir.getText());
						socio2.setEmail(entry_Email.getText());
						socio2.setTel(entry_Tel.getText());
						socio2.setCat(comboTexto);
		
						socio2.imprimirSocios();
						
						
						
						
						String sql="INSERT INTO socios (socio_id,nombre,apellido,dni,direccion,email,telefono,categoria,fechaAlta,cantMaxLibros,cantLibros) values (NULL,?,?,?,?,?,?,?,NOW(),?,?)";
						
		
						try {			
							con= Conexion.conectar();
							pstmt = con.prepareStatement(sql);
							
							pstmt.setString(1, socio2.getNombre());
							pstmt.setString(2, socio2.getApellido());
							pstmt.setString(3,socio2.getDni());
							pstmt.setString(4,socio2.getDireccion());
							pstmt.setString(5, socio2.getEmail());
							pstmt.setString(6, socio2.getTel());
							pstmt.setString(7, socio2.getCat());
							//fechalta
							pstmt.setInt(8,socio2.getCantML()); 
							pstmt.setInt(9,socio2.getCantL());
						
							pstmt.execute();
							JOptionPane.showMessageDialog(rootPane,"Alta socio exitosa ","Info",1);
							
							pstmt.close();
							con.close();
							dispose();
							MenuPrincipal obj = new MenuPrincipal();
							obj.setVisible(true);
						} catch (SQLException ef) {
							System.out.println("Error en insertar socio socio");
							ef.printStackTrace();
						}
						
				
					; // fin del case 2 y 3
					break;
					
					
					

					
				
			    }
			
			}	
		});
		btnAlta.setBounds(111, 427, 89, 23);
		contentPane.add(btnAlta);
		
		JButton btnVolver = new JButton("Volver");
		btnVolver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				VerificarDni obj = new VerificarDni();
				obj.setVisible(true);
				 
			}
		});
		btnVolver.setBounds(10, 427, 89, 23);
		contentPane.add(btnVolver);
		
		JButton btn_Limpiar = new JButton("Limpiar");
		btn_Limpiar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				entry_Nombre.setText("");
				entry_Ape.setText("");
				entry_Dir.setText("");
				entry_Tel.setText("");
				entry_Email.setText("");
				entry_Año.setText("");
				entry_Legajo.setText("");
				comboCat.setSelectedIndex(0);
				
				
			}
		});
		btn_Limpiar.setBounds(111, 312, 89, 23);
		contentPane.add(btn_Limpiar);
		
		
	}
	private static void addPopup(Component component, final JPopupMenu popup) {
		component.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				if (e.isPopupTrigger()) {
					showMenu(e);
				}
			}
			public void mouseReleased(MouseEvent e) {
				if (e.isPopupTrigger()) {
					showMenu(e);
				}
			}
			private void showMenu(MouseEvent e) {
				popup.show(e.getComponent(), e.getX(), e.getY());
			}
		});
	}
}

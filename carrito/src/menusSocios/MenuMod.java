package menusSocios;

import conectarBd.Conexion;

import funcionesControl.Controles;
import socios.Socios;
import socios.socioAlumno;

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
import java.awt.event.ItemEvent;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import javax.swing.JSeparator;
import javax.swing.JFormattedTextField;
import javax.swing.JList;
import javax.swing.JCheckBox;
import javax.swing.event.ChangeListener;
import javax.swing.event.ChangeEvent;
import java.awt.event.ItemListener;
import javax.swing.JToggleButton;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

public class MenuMod extends JFrame {

	private JPanel contentPane;
	private JTextField entry_dni;
	private JTextField TF_nom;
	private JTextField TF_ape;
	private JTextField TF_dni;
	private JTextField TF_dir;
	private JTextField TF_email;
	private JTextField TF_tel;
	private JTextField TF_cat;
	private JTextField TF_legajo;
	private JTextField TF_año;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MenuMod frame = new MenuMod();
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
	public MenuMod() {
		setTitle("Menu mod");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 350);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Ingrese el dni");
		lblNewLabel.setBounds(10, 40, 75, 14);
		contentPane.add(lblNewLabel);
		
		entry_dni = new JTextField();
		entry_dni.setBounds(95, 37, 86, 20);
		contentPane.add(entry_dni);
		entry_dni.setColumns(10);
		
		JLabel label_legajo = new JLabel("Legajo");
		label_legajo.setBounds(234, 177, 46, 14);
		contentPane.add(label_legajo);
		label_legajo.setVisible(false);

		
		JLabel label_año = new JLabel("A\u00F1o ingreso");
		label_año.setBounds(234, 212, 66, 14);
		contentPane.add(label_año);
		label_año.setVisible(false);
		
		JCheckBox check_nom = new JCheckBox("");
		check_nom.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				 if (e.getStateChange() == ItemEvent.SELECTED) {
				        TF_nom.setEnabled(true);
				     } else {
				        TF_nom.setEnabled(false);
				     }
				
			}
		});
	
	
		
		check_nom.setBounds(183, 88, 21, 23);
		contentPane.add(check_nom);
		
		JCheckBox check_ape = new JCheckBox("");
		check_ape.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				
				 if (e.getStateChange() == ItemEvent.SELECTED) {
				        TF_ape.setEnabled(true);
				     } else {
				        TF_ape.setEnabled(false);
				     }
				
			}
		});
		check_ape.setBounds(183, 117, 21, 23);
		contentPane.add(check_ape);
		
		JCheckBox check_dir = new JCheckBox("");
		check_dir.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				
				 if (e.getStateChange() == ItemEvent.SELECTED) {
				        TF_dir.setEnabled(true);
				     } else {
				        TF_dir.setEnabled(false);
				     }
				
			}
		});
		check_dir.setBounds(183, 177, 21, 23);
		contentPane.add(check_dir);
		
		JCheckBox check_email = new JCheckBox("");
		check_email.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				
				 if (e.getStateChange() == ItemEvent.SELECTED) {
				        TF_email.setEnabled(true);
				     } else {
				        TF_email.setEnabled(false);
				     }
			}
		});
		
		check_email.setBounds(183, 203, 21, 23);
		contentPane.add(check_email);
		
		JCheckBox check_tel = new JCheckBox("");
		check_tel.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				 if (e.getStateChange() == ItemEvent.SELECTED) {
				        TF_tel.setEnabled(true);
				     } else {
				        TF_tel.setEnabled(false);
				     }
			}
		});
		check_tel.setBounds(402, 87, 21, 23);
		contentPane.add(check_tel);
		
		JCheckBox check_leg = new JCheckBox("");
		check_leg.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				
				 if (e.getStateChange() == ItemEvent.SELECTED) {
				        TF_legajo.setEnabled(true);
				     } else {
				        TF_legajo.setEnabled(false);
				     }
			}
		});
		check_leg.setBounds(402, 177, 21, 23);
		contentPane.add(check_leg);
		check_leg.setVisible(false);
		
		JCheckBox check_año = new JCheckBox("");
		check_año.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				
				 if (e.getStateChange() == ItemEvent.SELECTED) {
				        TF_año.setEnabled(true);
				     } else {
				        TF_año.setEnabled(false);
				     }
			}
		});
		check_año.setBounds(402, 205, 21, 23);
		contentPane.add(check_año);
		check_año.setVisible(false);
		
		JComboBox comboCat = new JComboBox();
		comboCat.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String a1=comboCat.getSelectedItem().toString();
				
				if (!a1.contentEquals("<<Seleccione>>")) {
					TF_cat.setText(a1);
				}
				if(a1.contentEquals("Alumno")) {
					TF_año.setVisible(true);
					TF_legajo.setVisible(true);
					label_año.setVisible(true);
					label_legajo.setVisible(true);
					check_año.setVisible(true);
					check_leg.setVisible(true);
				
					
				}
				else {
					TF_año.setVisible(false);
					TF_legajo.setVisible(false);
					label_año.setVisible(false);
					label_legajo.setVisible(false);
					check_año.setVisible(false);
					check_leg.setVisible(false);
					
					
				}
				
				
				}
				
			
		});
		comboCat.setEnabled(false);
		comboCat.setModel(new DefaultComboBoxModel(new String[] {"<<Seleccione>>", "Alumno", "Profesor", "Personal no docente"}));
		comboCat.setBounds(310, 147, 113, 22);
		contentPane.add(comboCat);
		
		JCheckBox check_cat = new JCheckBox("");
		check_cat.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				
				 if (e.getStateChange() == ItemEvent.SELECTED) {
					 	
				        comboCat.setEnabled(true);
				     } else {
				        comboCat.setEnabled(false);
				     }
				
				
			}
		});
		check_cat.setBounds(402, 117, 21, 23);
		contentPane.add(check_cat);
		
	
		check_año.setBounds(402, 205, 21, 23);
		contentPane.add(check_año);
		check_año.setVisible(false);

		
		JButton btn_busq = new JButton("Buscar");
		btn_busq.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
			
				check_nom.setSelected(false);
				check_ape.setSelected(false);
				check_dir.setSelected(false);
				check_email.setSelected(false);
				check_tel.setSelected(false);
				check_cat.setSelected(false);
				check_año.setSelected(false);
				check_leg.setSelected(false);
				TF_nom.setText("");
				TF_ape.setText("");
				TF_dir.setText("");
				TF_email.setText("");
				TF_tel.setText("");
				TF_cat.setText("");
				TF_año.setText("");
				TF_legajo.setText("");
				comboCat.setSelectedIndex(0);
				
				Statement stm= null;
				Connection con=null;
				ResultSet rs=null;
				
				String sql="SELECT nombre,apellido,dni,direccion,email,telefono,categoria,legajo,añoingreso  FROM socios WHERE dni="+entry_dni.getText();
				Socios socio1=new Socios();
				
				
				
				if (Controles.isNumeric(entry_dni.getText())==true) {
					
					
					try {			
						con= Conexion.conectar();
						stm=con.createStatement();
						rs=stm.executeQuery(sql);
					
						
						
						while (rs.next()) {

							if (rs.getString(7).equals("Alumno")) {
								
						
							TF_nom.setText(rs.getString(1));
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
							check_leg.setVisible(true);
							check_año.setVisible(true);
								}
							else {
						
							TF_nom.setText(rs.getString(1));
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
							check_leg.setVisible(false);
							check_año.setVisible(false);
								
							}
							
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
		btn_busq.setBounds(191, 36, 89, 23);
		contentPane.add(btn_busq);
		
		JLabel lblNewLabel_1 = new JLabel("Nombre");
		lblNewLabel_1.setBounds(10, 91, 46, 14);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Apellido");
		lblNewLabel_2.setBounds(10, 121, 46, 14);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Dni");
		lblNewLabel_3.setBounds(10, 151, 46, 14);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Direccion");
		lblNewLabel_4.setBounds(10, 181, 66, 14);
		contentPane.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("Email");
		lblNewLabel_5.setBounds(10, 211, 46, 14);
		contentPane.add(lblNewLabel_5);
		
		TF_nom = new JTextField();
		TF_nom.setBounds(95, 88, 86, 20);
		contentPane.add(TF_nom);
		TF_nom.setColumns(10);
		TF_nom.setEnabled(false);
		
		TF_ape = new JTextField();
		TF_ape.setBounds(95, 118, 86, 20);
		contentPane.add(TF_ape);
		TF_ape.setColumns(10);
		TF_ape.setEnabled(false);
		
		TF_dni = new JTextField();
		TF_dni.setEnabled(false);
		TF_dni.setBounds(95, 148, 86, 20);
		contentPane.add(TF_dni);
		TF_dni.setColumns(10);
		
		TF_dir = new JTextField();
		TF_dir.setBounds(95, 178, 86, 20);
		contentPane.add(TF_dir);
		TF_dir.setColumns(10);
		TF_dir.setEnabled(false);
		
		TF_email = new JTextField();
		TF_email.setBounds(54, 208, 127, 20);
		contentPane.add(TF_email);
		TF_email.setColumns(10);
		TF_email.setEnabled(false);
		
		JLabel lblNewLabel_6 = new JLabel("Telefono");
		lblNewLabel_6.setBounds(234, 91, 66, 14);
		contentPane.add(lblNewLabel_6);
		
		JLabel lblNewLabel_7 = new JLabel("Categoria");
		lblNewLabel_7.setBounds(234, 121, 56, 14);
		contentPane.add(lblNewLabel_7);
		
	
		
		TF_tel = new JTextField();
		TF_tel.setBounds(310, 88, 86, 20);
		contentPane.add(TF_tel);
		TF_tel.setColumns(10);
		TF_tel.setEnabled(false);
		
		TF_cat = new JTextField();
		TF_cat.setBounds(310, 118, 86, 20);
		contentPane.add(TF_cat);
		TF_cat.setColumns(10);
		
		TF_cat.setText(comboCat.getSelectedItem().toString());
		TF_cat.setEnabled(false);
		
		TF_legajo = new JTextField();
		TF_legajo.setBounds(310, 177, 86, 20);
		contentPane.add(TF_legajo);
		TF_legajo.setColumns(10);
		TF_legajo.setVisible(false);
		TF_legajo.setEnabled(false);

		
		TF_año = new JTextField();
		TF_año.setBounds(310, 209, 86, 20);
		contentPane.add(TF_año);
		TF_año.setColumns(10);
		TF_año.setVisible(false);
		TF_año.setEnabled(false);

		
		JButton btn_volver = new JButton("Volver");
		btn_volver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				MenuSocios obj = new MenuSocios();
				obj.setVisible(true);
				
			}
		});
		btn_volver.setBounds(10, 277, 89, 23);
		contentPane.add(btn_volver);
		
		JButton btn_mod = new JButton("Modificar");
		btn_mod.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Statement stm1= null;
				Connection con1=null;
				ResultSet rs1=null;
				String comboTexto=TF_cat.getText();
				
				if (comboTexto.contentEquals("<<Seleccione>>")) {
				comboTexto=""; 
				
				String sql1="UPDATE socios SET nombre='"+TF_nom.getText()+"', apellido='"+TF_ape.getText()+"', direccion='"+TF_dir.getText()+"', email='"+TF_email.getText()+"', telefono='"+TF_tel.getText()+"', categoria='"+comboTexto+"', legajo='"+TF_legajo.getText()+"', añoingreso='"+TF_año.getText()+"'" +" WHERE dni="+TF_dni.getText();

				
				
				
				try {			
					con1= Conexion.conectar();
					stm1=con1.createStatement();
					stm1.executeUpdate(sql1);
					JOptionPane.showMessageDialog(rootPane,"Datos actualizados","Info",1);

					stm1.close();
					con1.close();
				} catch (SQLException ef) {
					System.out.println("Error actuualizar");
					ef.printStackTrace();
				}
				
				
				}
				
				
				else {
					
					try {
						TF_año.setText("");
						TF_legajo.setText("");
						String sql2="UPDATE socios SET nombre='"+TF_nom.getText()+"', apellido='"+TF_ape.getText()+"', direccion='"+TF_dir.getText()+"', email='"+TF_email.getText()+"', telefono='"+TF_tel.getText()+"', categoria='"+TF_cat.getText()+"', legajo='"+TF_legajo.getText()+"', añoingreso='"+TF_año.getText()+"'" +" WHERE dni="+TF_dni.getText();

						con1= Conexion.conectar();
						stm1=con1.createStatement();
						stm1.executeUpdate(sql2);
						JOptionPane.showMessageDialog(rootPane,"Datos actualizados","Info",1);

						stm1.close();
						con1.close();
					} catch (SQLException ef) {
						System.out.println("Error actuualizar");
						ef.printStackTrace();
					}
					

					
				}
				
	
			}
		});
		btn_mod.setBounds(307, 277, 89, 23);
		contentPane.add(btn_mod);
		
		
		
		JLabel lblNewLabel_8 = new JLabel("Tilde la casilla que desea modificar");
		lblNewLabel_8.setBounds(10, 252, 386, 14);
		contentPane.add(lblNewLabel_8);
		
		
		
	
	}
}

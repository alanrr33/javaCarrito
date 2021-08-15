package menusLibros;

import java.awt.BorderLayout;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import org.w3c.dom.Text;

import com.mysql.cj.jdbc.result.ResultSetMetaData;

import conectarBd.Conexion;
import menus.MenuPrincipal;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.sound.sampled.Line;
import javax.swing.JButton;
import javax.swing.JTextArea;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.event.ActionEvent;

public class BusquedaLibros extends JFrame {

	private JPanel contentPane;
	private JTextField entry_autor;
	private JTextField entry_titulo;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BusquedaLibros frame = new BusquedaLibros();
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
	public BusquedaLibros() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 335, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Autor");
		lblNewLabel.setBounds(10, 55, 46, 14);
		contentPane.add(lblNewLabel);
		
		entry_autor = new JTextField();
		entry_autor.setBounds(120, 52, 130, 20);
		contentPane.add(entry_autor);
		entry_autor.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Titulo");
		lblNewLabel_1.setBounds(10, 100, 46, 14);
		contentPane.add(lblNewLabel_1);
		
		entry_titulo = new JTextField();
		entry_titulo.setBounds(120, 97, 130, 20);
		contentPane.add(entry_titulo);
		entry_titulo.setColumns(10);
		
		JTextArea text_libros = new JTextArea();
		text_libros.setLineWrap(true);
		text_libros.setBounds(10, 201, 299, 195);
		contentPane.add(text_libros);
		
		JButton btn_buscar = new JButton("Buscar");
		btn_buscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				text_libros.setText("");
				
				Statement stm= null;
				Connection con=null;
				ResultSet rs=null;
				java.sql.ResultSetMetaData rsmd=null;
				
				
				String sql="SELECT DISTINCT isbn, titulo,nombre,apellido FROM libros l LEFT JOIN autores_libros al ON (l.libro_id = al.libro_id) LEFT JOIN autor a ON (al.autor_id = a.autor_id) WHERE apellido LIKE '%" + entry_autor.getText().trim() + "%'";
				String sql1="SELECT DISTINCT isbn, titulo,nombre,apellido FROM libros l LEFT JOIN autores_libros al ON (l.libro_id = al.libro_id) LEFT JOIN autor a ON (al.autor_id = a.autor_id) WHERE titulo LIKE '%" + entry_titulo.getText().trim() + "%'";
				String sql2="SELECT DISTINCT isbn, titulo,nombre,apellido FROM libros l LEFT JOIN autores_libros al ON (l.libro_id = al.libro_id) LEFT JOIN autor a ON (al.autor_id = a.autor_id) WHERE apellido LIKE '%" + entry_autor.getText().trim() + "%' AND titulo LIKE '%" + entry_titulo.getText().trim() + "%'"; 
			           
				

				

				if (((entry_autor.getText().isEmpty())==false) && (entry_titulo.getText().isEmpty()==true)) {
					
					try {			
						con= Conexion.conectar();
						stm=con.createStatement();
						rs=stm.executeQuery(sql);
						rsmd=rs.getMetaData();
						int cantCol=rsmd.getColumnCount();
						
						if (rs.next() == false) {
							JOptionPane.showMessageDialog(rootPane,"No se han encontrado resultados con ese autor","Info",1);
					      } else {

					        do {
					        	for(int i=1;i<=cantCol;i++) {
									text_libros.append(rsmd.getColumnName(i)+": "+rs.getString(i)+"\r\n");

									}
									
					        } while (rs.next());
					      }
						
						
						
					
						
						
						stm.close();
						con.close();
					} catch (SQLException ef) {
						System.out.println("Error busqueda por autor");
						ef.printStackTrace();
					}	
			
					
					
				}
				else 
				if (((entry_autor.getText().isEmpty())==true) && (entry_titulo.getText().isEmpty()==false)) {
					
					
					try {			
						con= Conexion.conectar();
						stm=con.createStatement();
						rs=stm.executeQuery(sql1);
						rsmd=rs.getMetaData();
						int cantCol=rsmd.getColumnCount();
						
						if (rs.next() == false) {
							JOptionPane.showMessageDialog(rootPane,"No se han encontrado resultados con ese titulo","Info",1);
					      } else {

					        do {
					        	for(int i=1;i<=cantCol;i++) {
									text_libros.append(rsmd.getColumnName(i)+": "+rs.getString(i)+"\r\n");

									}
									
					        } while (rs.next());
					      }
						
						
						
					
						
						
						stm.close();
						con.close();
					} catch (SQLException ef) {
						System.out.println("Error busqueda por autor");
						ef.printStackTrace();
					}	
				
				}
				else 
					if (((entry_autor.getText().isEmpty())==false) && (entry_titulo.getText().isEmpty()==false)) {
						
						
						try {			
							con= Conexion.conectar();
							stm=con.createStatement();
							rs=stm.executeQuery(sql2);
							rsmd=rs.getMetaData();
							int cantCol=rsmd.getColumnCount();
							
							if (rs.next() == false) {
								JOptionPane.showMessageDialog(rootPane,"No se han encontrado resultados con ese autor y titulo","Info",1);
						      } else {

						        do {
						        	for(int i=1;i<=cantCol;i++) {
										text_libros.append(rsmd.getColumnName(i)+": "+rs.getString(i)+"\r\n");

										}
										
						        } while (rs.next());
						      }
							
							
							
						
							
							
							stm.close();
							con.close();
						} catch (SQLException ef) {
							System.out.println("Error busqueda por autor");
							ef.printStackTrace();
						}
						
					
						
					
					}
				
					else 
						if (((entry_autor.getText().isEmpty())==true) && (entry_titulo.getText().isEmpty()==true)) {
							JOptionPane.showMessageDialog(rootPane,"Ambos campos estan vacios","Info",1);

						}
				
	
			}
		});
		btn_buscar.setBounds(161, 142, 89, 23);
		contentPane.add(btn_buscar);
		
	
		
		JButton btn_volver = new JButton("Volver");
		btn_volver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				MenuLibros obj =new MenuLibros();
				obj.setVisible(true);
				
			}
		});
		btn_volver.setBounds(120, 427, 89, 23);
		contentPane.add(btn_volver);
	}
}

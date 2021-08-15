package menusLibros;

import funcionesControl.Controles;
import conectarBd.Conexion; 
import libros.Libros;
import menus.MenuPrincipal;
import menusSocios.VerificarDni;

import java.awt.BorderLayout;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;


import conectarBd.Conexion;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.event.ActionEvent;

public class MenuAltaLibro extends JFrame {
	
	Conexion conexion = new Conexion();
	private JPanel contentPane;
	private JTextField entry_isbn;
	private JTextField entry_titulo;
	private boolean check1,check2,check3;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MenuAltaLibro frame = new MenuAltaLibro();
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
	public MenuAltaLibro() {
		
		setTitle("Alta Libro");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 250, 360);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Isbn");
		lblNewLabel.setBounds(10, 50, 46, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Titulo");
		lblNewLabel_1.setBounds(10, 75, 46, 14);
		contentPane.add(lblNewLabel_1);
		
		entry_isbn = new JTextField();
		entry_isbn.setEnabled(false);
		entry_isbn.setBounds(85, 47, 139, 20);
		contentPane.add(entry_isbn);
		
		
		entry_isbn.setText(Integer.toString(VerificarIsbn.obtenerISBN()));
		entry_isbn.setColumns(10);
		
		entry_titulo = new JTextField();
		entry_titulo.setBounds(85, 72, 139, 20);
		contentPane.add(entry_titulo);
		entry_titulo.setColumns(10);
		
		JTextArea text_desc = new JTextArea();
		text_desc.setBounds(85, 103, 139, 65);
		contentPane.add(text_desc);
		
		JLabel lblNewLabel_2_1 = new JLabel("Descripcion");
		lblNewLabel_2_1.setBounds(10, 100, 65, 14);
		contentPane.add(lblNewLabel_2_1);
		
		JButton btn_Limpiar = new JButton("Limpiar");
		btn_Limpiar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				entry_isbn.setText("");
				entry_titulo.setText("");
				text_desc.setText("");
			}
		});
		btn_Limpiar.setBounds(135, 179, 89, 23);
		contentPane.add(btn_Limpiar);
		
		JButton btn_Volver = new JButton("Volver");
		btn_Volver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				MenuLibros obj = new  MenuLibros();
				obj.setVisible(true);
			}
		});
		btn_Volver.setBounds(0, 277, 89, 23);
		contentPane.add(btn_Volver);
		
		JButton btn_Alta = new JButton("Alta");
		btn_Alta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				check1=false;
				check2=false;
				check3=false;
				
				
				
				// chequeo que los campos no esten vacios ni contegan caracteres invalidos con las funciones
				
				//titulo
				String b=entry_titulo.getText();
				
				if (!b.isEmpty()) {
					check1=true;
				}
				else {
					JOptionPane.showMessageDialog(rootPane,"El titulo esta vacio","Info",1);
					entry_titulo.requestFocusInWindow();
					check1=false;
				}
				
				
				//isbn
				if (Controles.isISBN(entry_isbn.getText())==true) {
					check2=true;
				}
				else {
					JOptionPane.showMessageDialog(rootPane,"El isbn tiene caracteres no validos","Info",1);
					entry_isbn.requestFocusInWindow();
					check2=false;
				}
				
	
				//descripcion
				
				String a =text_desc.getText();
				
				if (!a.isEmpty()) {
					check3=true;
										
				}
				else {
					JOptionPane.showMessageDialog(rootPane,"La descripcion esta vacia","Info",1);
					text_desc.requestFocusInWindow();
					check3=false;
					
				}
				
				
				if (check1==true && check2==true && check3==true) {
					
					Connection con=null;
					PreparedStatement pstmt = null;
					String x=entry_isbn.getText();
					int y = Integer.parseInt(x);
				
					
					Libros libro = new Libros();
					libro.setIsbn(y);
					libro.setNombre(entry_titulo.getText());
					libro.setDescripcion(text_desc.getText());
					libro.imprimirLibro();
					
					String sql="INSERT INTO libros (libro_id,isbn,titulo,descripcion) values (NULL,?,?,?)";
					
					try {			
						con= Conexion.conectar();
						pstmt = con.prepareStatement(sql);
						
						pstmt.setInt(1, libro.getIsbn());
						pstmt.setString(2, libro.getNombre());
						pstmt.setString(3,libro.getDescripcion());
				
			
					
						pstmt.execute();
						JOptionPane.showMessageDialog(rootPane,"Alta libro exitosa ","Info",1);
						
						pstmt.close();
						con.close();
						dispose();
						MenuLibros obj = new MenuLibros();
						obj.setVisible(true);
						
						
					} catch (SQLException ef) {
						System.out.println("Error en insertar libro");
						ef.printStackTrace();
					}

					
					
					
					
					
					
					
					
					
				}

				
				
				
				
				
				
				
			}
		});
		btn_Alta.setBounds(135, 277, 89, 23);
		contentPane.add(btn_Alta);
		
	}
	
	  
	
}



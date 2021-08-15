package menusLibros;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import conectarBd.Conexion;
import funcionesControl.Controles;

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

public class ModLibroVerificar extends JFrame {

	private JPanel contentPane;
	private JTextField entry_isbn;
	private static String isbn,titulo,descripcion;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ModLibroVerificar frame = new ModLibroVerificar();
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
	public ModLibroVerificar() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 260, 200);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Isbn");
		lblNewLabel.setBounds(10, 30, 46, 14);
		contentPane.add(lblNewLabel);
		
		entry_isbn = new JTextField();
		entry_isbn.setBounds(80, 27, 155, 20);
		contentPane.add(entry_isbn);
		entry_isbn.setColumns(10);
		
		JButton btn_entrar = new JButton("Entrar");
		btn_entrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				ModLibro obj =new ModLibro();
				obj.setVisible(true);
				
			}
		});
		btn_entrar.setEnabled(false);
		btn_entrar.setBounds(146, 127, 89, 23);
		contentPane.add(btn_entrar);
		
		JButton btn_verificar = new JButton("Verificar");
		btn_verificar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				

				
				Statement stm= null;
				Connection con=null;
				ResultSet rs=null;
				
				String sql="SELECT isbn,titulo,descripcion FROM libros WHERE isbn="+entry_isbn.getText();
				
				
				if (Controles.isISBN(entry_isbn.getText())==true) {
					
				
				try {			
					con= Conexion.conectar();
					stm=con.createStatement();
					rs=stm.executeQuery(sql);
					isbn=entry_isbn.getText();
					if (rs.next()==true) {
						JOptionPane.showMessageDialog(rootPane,"ISBN disponible","Info",1);
						titulo=rs.getString(2);
						descripcion=rs.getString(3);
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
		btn_verificar.setBounds(146, 58, 89, 23);
		contentPane.add(btn_verificar);
		
		
		
		JButton btn_volver = new JButton("Volver");
		btn_volver.setBounds(0, 127, 89, 23);
		contentPane.add(btn_volver);
	}

	public static String getIsbn() {
		return isbn;
	}

	public static String getTitulo() {
		return titulo;
	}

	public static String getDescripcion() {
		return descripcion;
	}

}

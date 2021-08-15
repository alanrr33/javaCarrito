package menusLibros;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import conectarBd.Conexion;
import libros.Ejemplares;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

public class MenuAltaEjemplar2 extends JFrame {

	private JPanel contentPane;
	private JTextField entry_titulo;
	private JTextField entry_isbn;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MenuAltaEjemplar2 frame = new MenuAltaEjemplar2();
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
	public MenuAltaEjemplar2() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 253, 410);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Isbn");
		lblNewLabel.setBounds(10, 50, 46, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Titulo");
		lblNewLabel_1.setBounds(10, 85, 46, 14);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Descripcion");
		lblNewLabel_2.setBounds(10, 120, 57, 14);
		contentPane.add(lblNewLabel_2);
		
		JTextArea text_desc = new JTextArea();
		text_desc.setEnabled(false);
		text_desc.setBounds(77, 120, 139, 65);
		text_desc.setText(MenuAltaEjemplar.getDescripcion());
		contentPane.add(text_desc);
		
		entry_titulo = new JTextField();
		entry_titulo.setEnabled(false);
		entry_titulo.setColumns(10);
		entry_titulo.setBounds(77, 82, 139, 20);
		entry_titulo.setText(MenuAltaEjemplar.getTitulo());
		contentPane.add(entry_titulo);
		
		entry_isbn = new JTextField();
		entry_isbn.setText(MenuAltaEjemplar.obtenerISBN());
		entry_isbn.setEnabled(false);
		entry_isbn.setColumns(10);
		entry_isbn.setBounds(77, 47, 139, 20);
		contentPane.add(entry_isbn);
		
		JLabel lblNewLabel_3 = new JLabel("Tipo de uso");
		lblNewLabel_3.setBounds(10, 205, 57, 14);
		contentPane.add(lblNewLabel_3);
		
		JComboBox combo_tipouso = new JComboBox();
		combo_tipouso.setModel(new DefaultComboBoxModel(new String[] {"<<Seleccione>>","Local", "Prestamo"}));
		combo_tipouso.setBounds(77, 205, 139, 22);
		contentPane.add(combo_tipouso);
		
		JButton btn_volver = new JButton("Volver");
		btn_volver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				MenuLibros obj=new MenuLibros();
				obj.setVisible(true);
			}
		});
		btn_volver.setBounds(0, 337, 89, 23);
		contentPane.add(btn_volver);
		
		JButton btn_alta = new JButton("Alta");
		btn_alta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Integer Seleccionado = combo_tipouso.getSelectedIndex();
				
				if (Seleccionado!=0) {
					
					Connection con=null;
					PreparedStatement pstmt = null;
					Ejemplares Ejemplar = new Ejemplares();
					Integer z=Integer.parseInt(entry_isbn.getText());
					Ejemplar.setIsbn(z);
					Ejemplar.setTipouso(combo_tipouso.getSelectedItem().toString());
					Ejemplar.setDisponibilidad(true);
					Ejemplar.imprimirEjemplar();
					
					String sql="INSERT INTO ejemplares (ejemplar_id,isbn,tipouso,disponibilidad) values (NULL,?,?,?)";
					
					
					try {			
						con= Conexion.conectar();
						pstmt = con.prepareStatement(sql);
						
						pstmt.setInt(1, Ejemplar.getIsbn());
						pstmt.setString(2, Ejemplar.getTipouso());
						pstmt.setBoolean(3,Ejemplar.isDisponibilidad());
				
			
					
						pstmt.execute();
						JOptionPane.showMessageDialog(rootPane,"Alta ejemplar exitosa ","Info",1);
						
						pstmt.close();
						con.close();
						dispose();
						MenuLibros obj = new MenuLibros();
						obj.setVisible(true);
						
						
					} catch (SQLException ef) {
						System.out.println("Error en insertar ejemplar");
						ef.printStackTrace();
					}

					
					
					
					
					
				}
				else {
					JOptionPane.showMessageDialog(rootPane,"Elija una opcion valida del combo","Info",1);	
				}
				
				
				
				
				
				
			}
		});
		btn_alta.setBounds(127, 337, 89, 23);
		contentPane.add(btn_alta);
	}
}

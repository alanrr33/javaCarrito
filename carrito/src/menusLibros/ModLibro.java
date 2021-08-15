package menusLibros;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JCheckBox;
import javax.swing.JTextArea;

public class ModLibro extends JFrame {

	private JPanel contentPane;
	private JTextField entry_isbn;
	private JTextField entry_titulo;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ModLibro frame = new ModLibro();
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
	public ModLibro() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 300, 400);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Isbn");
		lblNewLabel.setBounds(10, 50, 46, 14);
		contentPane.add(lblNewLabel);
		
		JTextArea text_desc = new JTextArea();
		text_desc.setEnabled(false);
		text_desc.setBounds(90, 125, 155, 99);
		text_desc.setText(ModLibroVerificar.getDescripcion());
		contentPane.add(text_desc);
		
		entry_isbn = new JTextField();
		entry_isbn.setEnabled(false);
		entry_isbn.setBounds(90, 47, 155, 20);
		entry_isbn.setText(ModLibroVerificar.getIsbn());
		contentPane.add(entry_isbn);
		entry_isbn.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Titulo");
		lblNewLabel_1.setBounds(10, 90, 46, 14);
		contentPane.add(lblNewLabel_1);
		
		entry_titulo = new JTextField();
		entry_titulo.setEnabled(false);
		entry_titulo.setBounds(90, 87, 155, 20);
		entry_titulo.setText(ModLibroVerificar.getTitulo());
		contentPane.add(entry_titulo);
		entry_titulo.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Descripcion");
		lblNewLabel_2.setBounds(10, 130, 64, 14);
		contentPane.add(lblNewLabel_2);
		
		JButton btn_limpiar = new JButton("Limpiar");
		btn_limpiar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				entry_titulo.setText("");
				text_desc.setText("");
				
			}
		});
		btn_limpiar.setBounds(156, 235, 89, 23);
		contentPane.add(btn_limpiar);
		
		JButton btnNewButton = new JButton("Modificar");
		btnNewButton.setBounds(156, 327, 89, 23);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Volver");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				MenuLibros obj = new MenuLibros();
				obj.setVisible(true);
				
				
			}
		});
		btnNewButton_1.setBounds(10, 327, 89, 23);
		contentPane.add(btnNewButton_1);
		
		JCheckBox check_titulo = new JCheckBox("");
		check_titulo.setBounds(251, 87, 21, 23);
		contentPane.add(check_titulo);
		
		JCheckBox check_desc = new JCheckBox("");
		check_desc.setBounds(249, 127, 23, 23);
		contentPane.add(check_desc);
		
	
	}
}

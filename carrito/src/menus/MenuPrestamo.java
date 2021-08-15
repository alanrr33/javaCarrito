package menus;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JButton;

public class MenuPrestamo extends JFrame {

	private JPanel contentPane;
	private JTextField entry_nombre;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MenuPrestamo frame = new MenuPrestamo();
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
	public MenuPrestamo() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 350);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Nombre");
		lblNewLabel.setBounds(10, 45, 46, 14);
		contentPane.add(lblNewLabel);
		
		entry_nombre = new JTextField();
		entry_nombre.setBounds(85, 42, 165, 20);
		contentPane.add(entry_nombre);
		entry_nombre.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Libros");
		lblNewLabel_1.setBounds(10, 90, 46, 14);
		contentPane.add(lblNewLabel_1);
		
		JTextArea text_libros = new JTextArea();
		text_libros.setBounds(85, 85, 313, 147);
		contentPane.add(text_libros);
		
		JButton btn_buscar = new JButton("Buscar");
		btn_buscar.setBounds(309, 41, 89, 23);
		contentPane.add(btn_buscar);
	}

}

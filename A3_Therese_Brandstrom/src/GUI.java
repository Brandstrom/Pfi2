import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JScrollBar;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.border.TitledBorder;


public class GUI extends JFrame {


	
	private JPanel contentPane;
	private JTextField txtNyCykel;
	private JTextField textField;
	private JTextField textField_1;
	private JPanel panel;
	
	private BikeStore ThereseCyklar= new BikeStore();
	private JTextArea textArea;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUI frame = new GUI();
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
	public GUI() {
		
		ThereseCyklar.addBike("white","20","400");
		ThereseCyklar.addBike("white","20","400");
		ThereseCyklar.addBike("white","20","400");
		ThereseCyklar.addBike("white","20","400");
		ThereseCyklar.addBike("white","20","400");
		ThereseCyklar.addBike("white","20","400");
		System.out.println(ThereseCyklar.getAllBikes());
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 695, 487);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnJbutton_1 = new JButton("Add new Bike");
		btnJbutton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
			
			{
				//anropar
			ThereseCyklar.addBike(textField_1.getText(),textField.getText() , txtNyCykel.getText());
				
				textArea.setText(ThereseCyklar.getAllBikes());

				
				
			}
		});
		btnJbutton_1.setBounds(448, 287, 112, 20);
		contentPane.add(btnJbutton_1);
		
		panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "Therése Cyklar", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setBounds(76, 26, 515, 20);
		contentPane.add(panel);
		panel.setLayout(null);
		
		txtNyCykel = new JTextField();
		txtNyCykel.setText("Prize");
		txtNyCykel.setBounds(555, 235, 63, 20);
		contentPane.add(txtNyCykel);
		txtNyCykel.setColumns(10);
		
		textField = new JTextField();
		textField.setText("Size");
		textField.setColumns(10);
		textField.setBounds(377, 235, 63, 20);
		contentPane.add(textField);
		
		
		textField_1 = new JTextField();
		textField_1.setText("Color");
		textField_1.setColumns(10);
		textField_1.setBounds(463, 235, 63, 20);
		contentPane.add(textField_1);
		
		textArea = new JTextArea();
		textArea.setText(ThereseCyklar.getAllBikes());
		textArea.setEditable(false);
		textArea.setBounds(10, 58, 338, 361);
		contentPane.add(textArea);
		System.out.println();
		
	}
}

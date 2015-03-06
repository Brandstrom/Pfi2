import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTextArea;
import javax.swing.JLabel;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Label;
import javax.swing.border.BevelBorder;


public class Gui extends JFrame {

	private JPanel contentPane;
	private JTextField textFieldHuman;
	private JTextField textFieldDog;
	Human human1;
	Dog dog1;
	
	private JTextField textFieldError;
	private JTextField textFieldInfo;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Gui frame = new Gui();
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
	public Gui() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(Color.PINK);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		textFieldHuman = new JTextField();
		textFieldHuman.setBounds(19, 18, 134, 28);
		contentPane.add(textFieldHuman);
		textFieldHuman.setColumns(10);
		
		textFieldDog = new JTextField();
		textFieldDog.setBounds(19, 57, 134, 28);
		contentPane.add(textFieldDog);
		textFieldDog.setColumns(10);
		
		JButton btnNewHuman = new JButton("New Human");
		btnNewHuman.setBackground(new Color(255, 182, 193));
		btnNewHuman.setOpaque(true);
		btnNewHuman.setBorder(new BevelBorder(BevelBorder.RAISED, Color.DARK_GRAY, null, null, null));
		btnNewHuman.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String humanName = textFieldHuman.getText();	
				if(humanName.length() < 3){
					textFieldError.setText("minst 3 bokstäver inte mindre för 'FUUN'");
					
				}else {
					human1 = new Human(humanName);
					
				}
				
				
			}
		});
		btnNewHuman.setForeground(Color.DARK_GRAY);
		btnNewHuman.setBounds(313, 18, 117, 29);
		contentPane.add(btnNewHuman);
		
		JButton btnBuyDog = new JButton("Buy Dog");
		btnBuyDog.setBorder(new BevelBorder(BevelBorder.RAISED, Color.DARK_GRAY, null, null, null));
		btnBuyDog.setOpaque(true);
		btnBuyDog.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String dog = textFieldDog.getText();
				if(human1 != null){
					
					dog1 = new Dog(dog);
					human1.buyDog(dog1);
				}else{
					
					textFieldError.setText("Sorry, no owner, no dog!");
					
				}
			}
		});
		btnBuyDog.setForeground(Color.DARK_GRAY);
		btnBuyDog.setBackground(new Color(255, 182, 193));
		btnBuyDog.setBounds(313, 58, 117, 29);
		contentPane.add(btnBuyDog);
		
		JButton btnPrintInfo = new JButton("Print Info");
		btnPrintInfo.setBackground(new Color(255, 182, 193));
		btnPrintInfo.setOpaque(true);
		btnPrintInfo.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		btnPrintInfo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				textFieldInfo.setText(human1.getInfo());
			}
		});
		btnPrintInfo.setForeground(Color.DARK_GRAY);
		btnPrintInfo.setBounds(313, 99, 117, 29);
		contentPane.add(btnPrintInfo);
		
		JLabel lblInfo = new JLabel("Info");
		lblInfo.setForeground(Color.DARK_GRAY);
		lblInfo.setBounds(19, 123, 61, 16);
		contentPane.add(lblInfo);
		
		JLabel lblErrormessage = new JLabel(" Error Message");
		lblErrormessage.setForeground(Color.DARK_GRAY);
		lblErrormessage.setBounds(19, 195, 92, 16);
		contentPane.add(lblErrormessage);
		
		textFieldError = new JTextField();
		textFieldError.setBounds(19, 218, 411, 54);
		contentPane.add(textFieldError);
		textFieldError.setColumns(10);
		
		textFieldInfo = new JTextField();
		textFieldInfo.setColumns(10);
		textFieldInfo.setBounds(19, 141, 411, 54);
		contentPane.add(textFieldInfo);
		
		JLabel lblNewLabel = new JLabel("Human's name");
		lblNewLabel.setBounds(169, 15, 134, 35);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Dog's name");
		lblNewLabel_1.setBounds(163, 54, 155, 35);
		contentPane.add(lblNewLabel_1);
	}
}

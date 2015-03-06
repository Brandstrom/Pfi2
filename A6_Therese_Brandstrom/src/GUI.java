import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTextArea;

import se.mah.k3lara.skaneAPI.control.Constants;
import se.mah.k3lara.skaneAPI.model.Journey;
import se.mah.k3lara.skaneAPI.model.Journeys;
import se.mah.k3lara.skaneAPI.xmlparser.Parser;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.Calendar;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;


public class GUI extends JFrame {

	private JPanel contentPane;
	public JTextField StartStationTxt;
	public JTextField EndStationTxt;
	 public  JTextArea Displaytxt = new JTextArea();
	public int siffra=2;
	public AnimationThread a;
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
	
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 528, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 39, 482, 181);
		panel.add(scrollPane);
		
		
		scrollPane.setViewportView(Displaytxt);
		Displaytxt.setText("");
		
		
		JButton btnSearch = new JButton("Search");
		btnSearch.setBounds(281, 5, 65, 23);
		panel.add(btnSearch);

		
		EndStationTxt = new JTextField();
		EndStationTxt.setText("To");
		EndStationTxt.setColumns(10);
		EndStationTxt.setBounds(185, 8, 86, 20);
		panel.add(EndStationTxt);
		
		
		
		StartStationTxt = new JTextField();
		StartStationTxt.setBounds(93, 8, 82, 20);
		panel.add(StartStationTxt);
		StartStationTxt.setText("SearchString");
		StartStationTxt.setColumns(10);
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				a = new AnimationThread(GUI.this);
				a.start();
				
				//Result.setText("searching...");
				String id="";
				String id2="";
				// ta data från sökfält
				String text=StartStationTxt.getText(); // sparar i text variabel
				String text2=EndStationTxt.getText(); // sparar i text variabel
				
				if (text.equals("Malmö")){
					id = "80000";
				}else if (text.equals("Lund")){
					id = "81216";
				}else if (text.equals("Emmaboda")){
					id = "8000";
				}else{
					id=text;
				}
				
				if (text2.equals("Malmö")){
					id2 = "80000";
				}else if (text2.equals("Lund")){
					id2 = "81216";
				}else if (text2.equals("Emmaboda")){
					id2 = "8000";
				}else{
					id2=text2;
				}
				
				ParserThread t = new ParserThread(GUI.this,id,id2);
				t.start();
				
			}
		});

	
		//System.out.println();
		JPanel panel_1 = new JPanel();
		contentPane.add(panel_1, BorderLayout.SOUTH);
	}
}

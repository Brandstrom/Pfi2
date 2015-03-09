package gym;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import java.awt.Color;

import javax.swing.ImageIcon;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.UIManager;
import javax.swing.JTextArea;
import javax.swing.JList;
import javax.swing.ScrollPaneConstants;
import java.awt.Dimension;

public class medlemsregister extends JFrame {

	private JPanel contentPane;
	private JMenuBar menuBar;
	private JMenu mnMedlem;
	private JMenu mnArkiv;
	private JMenu menu;
	private JMenu mnHjlp;
	private JTable table_1;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					medlemsregister frame = new medlemsregister();
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
	public medlemsregister() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 476);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel Arkiv = new JPanel();
		Arkiv.setBackground(new Color(204, 153, 102));
		Arkiv.setBounds(0, 21, 774, 405);
		contentPane.add(Arkiv);
		Arkiv.setLayout(null);
		
		JLabel lblBild = new JLabel("");
		lblBild.setIcon(new ImageIcon(medlemsregister.class.getResource("/bilder/gymnasium-cutout-vector-541748.jpg")));
		lblBild.setBounds(351, 182, 359, 129);
		Arkiv.add(lblBild);
		
		JButton btnSpara = new JButton("Spara");
		btnSpara.setBounds(113, 213, 89, 23);
		Arkiv.add(btnSpara);
		
		JPanel panel = new JPanel();
		panel.setBounds(351, 42, 359, 129);
		Arkiv.add(panel);
		panel.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Members", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setPreferredSize(new Dimension(500, 500));
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane.setBounds(10, 22, 339, 96);
		panel.add(scrollPane);
		
		table_1 = new JTable();
		table_1.setPreferredSize(new Dimension(500, 500));
		scrollPane.setViewportView(table_1);
		table_1.setModel(new DefaultTableModel(
			new Object[][] {
				{"Therese", "Gamla V\u00E4gen 33"},
				{"John Br\u00E4ndstr\u00F6m", "Perugatan 49B"},
				{"Elsa Jonsson", "Solgatan 44B"},
				{"Edvin Edvinsson", "Fejkstigen 7C"},
				{"Albert Einstein", "Geniv\u00E4gen 53C"},
				{"Lady Gaga", null},
				{null, null},
				{null, null},
				{null, null},
				{null, null},
				{null, null},
				{null, null},
				{null, null},
				{null, null},
			},
			new String[] {
				"Members", "Adress"
			}
		));
		
		JLabel lblNamn = new JLabel("Namn");
		lblNamn.setBounds(40, 76, 46, 14);
		Arkiv.add(lblNamn);
		
		textField = new JTextField();
		textField.setBounds(116, 138, 86, 20);
		Arkiv.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(116, 107, 86, 20);
		Arkiv.add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(116, 76, 86, 20);
		Arkiv.add(textField_2);
		
		JLabel lbllder = new JLabel("Age");
		lbllder.setBounds(40, 110, 46, 14);
		Arkiv.add(lbllder);
		
		JLabel lblAdress = new JLabel("Address");
		lblAdress.setBounds(40, 135, 46, 14);
		Arkiv.add(lblAdress);
		
		menuBar = new JMenuBar();
		menuBar.setBounds(0, 0, 97, 21);
		contentPane.add(menuBar);
		
		mnArkiv = new JMenu("Arkiv");
		menuBar.add(mnArkiv);
		
		JMenuItem mntmSkrivUt = new JMenuItem("Skriv ut");
		mnArkiv.add(mntmSkrivUt);
		
		JMenuItem mntmAvsluta = new JMenuItem("Avsluta");
		mnArkiv.add(mntmAvsluta);
		
		mnMedlem = new JMenu("Medlem");
		mnMedlem.setBounds(99, 0, 107, 22);
		contentPane.add(mnMedlem);
		
		JLabel lblNewMember = new JLabel("New member");
		mnMedlem.add(lblNewMember);
		
		menu = new JMenu("New menu");
		mnMedlem.add(menu);
		
		mnHjlp = new JMenu("Hj\u00E4lp");
		mnHjlp.setBounds(261, 0, 107, 22);
		contentPane.add(mnHjlp);
		
		JLabel lblOmProgrammet = new JLabel("Om programmet");
		mnHjlp.add(lblOmProgrammet);
		
		JLabel lblHjlp = new JLabel("Hj\u00E4lp");
		mnHjlp.add(lblHjlp);
	}
}

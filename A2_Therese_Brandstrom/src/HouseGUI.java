import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextArea;

import java.util.ArrayList;
import java.util.Random;

public class HouseGUI extends JFrame {

	private JPanel contentPane;
	private Random random = new Random();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					HouseGUI frame = new HouseGUI();
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
	public HouseGUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 748, 349);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);

		JTextArea textArea = new JTextArea();

		// ArrayList neo kodad/ super snygg kod / dynamisk
		ArrayList <House> radHus = new ArrayList<House>(); // arrayList av House


		//Stoppar in husen i arraylisten i en for loop

		for(int i = 0; i < 100; i++){
		radHus.add(getRandomHouse());	
	
		}


		

		//Mina Hus

		// gamla sätt manualla sätter/ hårtkodad
		House myNewHouse1;
		House myNewHouse2;
		House myNewHouse3;
		myNewHouse1 = new House(100,2012);// 1 huset
		myNewHouse2 = new House (200,2013);// 2 huset
		myNewHouse3 = new House (300,1800);// 3 huset

		textArea.append(String.valueOf(myNewHouse1.getYearBuilt()));
		textArea.append(" "+String.valueOf(radHus.get(0).getSize()) + "m2");
		contentPane.add(textArea, BorderLayout.NORTH);

		// classic codad/ bra statisk men bra
		House husArray[]=new House[10]; //array av House
		husArray[0]= new House(101,2000); // första
		husArray[1]= new House(102,2001);// andra
		husArray[2]= new House(103,2002);// tredje
		husArray[3]= new House(104,2000); // fjärde etc...
		husArray[4]= new House(125,2001);//
		husArray[5]= new House(306,2002);//
		husArray[6]= new House(107,2000); // 
		husArray[7]= new House(128,2001);// 
		husArray[8]= new House(309,2002);// 
		husArray[9]= new House(110,2000); // 
		
		for(House i : husArray){
			textArea.append("\nHuset är såhär stort "+i.getSize()+" och är byggt"+i.getYearBuilt());
		}

		for(int i = 0; i<100 ;i++){
			textArea.append("\nHuset är såhär stort "+radHus.get(i).getSize()+" och är byggt"+radHus.get(i).getYearBuilt());
		}

		//for(int i=0; i<10 ; i++){	//loop
		//System.out.println(husArray[i].yearBuilt); // första husets size
		//}

		System.out.println("uppgift 1,3");
		for(House i : husArray){ //loop
			System.out.print("storlek: ");
			System.out.println(i.size);
			System.out.print("byggår: ");
			System.out.println(i.yearBuilt);
		}






		//radHus.remove(0); tarbort från index 0

		//System.out.println(husArray[0].size); // första husets size

	}
	private House getRandomHouse() { //stoppa in den i en for loop
		int year = random.nextInt(2015-1800) + 1800;
		int size = random.nextInt(1000-10) + 10;

		House house = new House(year, size);
		return house;
	}
}


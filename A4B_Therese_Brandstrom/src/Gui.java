//import java.awt.BorderLayout;
import java.awt.EventQueue;


import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.SystemColor;
import java.awt.Color;
import java.awt.Font;


public class Gui extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

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
	
	public Gui() {
			
			ArrayList<Animal> zoo = new ArrayList<Animal>();
			
			zoo.add(new Dog("canis lupus", 4, true));
			zoo.add(new Dog("canis lupus", 4, false, "brasse"));
			zoo.add(new Cat("lynx lynx", 3, 9));
			Cat cat = new Cat("lynx lynx", 3, 9);
			cat.setFriendlyName("misse");
			zoo.add(cat);
			zoo.add(new Snake("python skitfarlig", true));
			Snake snake = new Snake("python", false);
			snake.setFriendlyName("Bengt");
			zoo.add(snake);
			
			for(Animal animal : zoo) {
				System.out.println(animal.getInfo());
			}
	
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 569, 358);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 128, 0));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 67, 433, 241);
		contentPane.add(scrollPane);
		
		JTextArea textArea = new JTextArea();
		scrollPane.setViewportView(textArea);
		
		JLabel lblAnimals = new JLabel("Animals!!!!");
		lblAnimals.setFont(new Font("Berlin Sans FB Demi", Font.PLAIN, 21));
		lblAnimals.setForeground(new Color(255, 105, 180));
		lblAnimals.setBackground(SystemColor.inactiveCaptionText);
		lblAnimals.setHorizontalAlignment(SwingConstants.CENTER);
		lblAnimals.setBounds(10, 11, 433, 45);
		contentPane.add(lblAnimals);
		
		for(Animal a : zoo){
			textArea.append(a.getInfo()+ "\n");
			
		}
		
		
		
	}
}

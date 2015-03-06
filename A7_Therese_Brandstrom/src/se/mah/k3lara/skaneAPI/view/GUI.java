package se.mah.k3lara.skaneAPI.view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

import se.mah.k3lara.skaneAPI.model.Line;
import se.mah.k3lara.skaneAPI.model.Lines;
import se.mah.k3lara.skaneAPI.model.Station;
import se.mah.k3lara.skaneAPI.xmlparser.Parser;

import java.awt.Color;
import java.awt.Font;
import java.util.Calendar;
import javax.swing.UIManager;

@SuppressWarnings("serial")
public class GUI extends JFrame {

	private JPanel contentPane;

	private UpdateMe searchThread;

	JLabel labelTitle = new JLabel("Ub\u00E5tshallen");
	JLabel lblLinje = new JLabel("Linje");
	JLabel lblNewLabel = new JLabel("Destination");
	JLabel lblNewLabel_1 = new JLabel("Avgångstid");

	JLabel labelLinje1 = new JLabel("");
	JLabel labelLinje2 = new JLabel("");
	JLabel labelLinje3 = new JLabel("");
	JLabel labelLinje4 = new JLabel("");

	JLabel labelDes1 = new JLabel("");
	JLabel labelDes2 = new JLabel("");
	JLabel labelDes3 = new JLabel("");
	JLabel labelDes4 = new JLabel("");

	JLabel labelTime1 = new JLabel("");
	JLabel labelTime2 = new JLabel("");
	JLabel labelTime3 = new JLabel("");
	JLabel labelTime4 = new JLabel("");

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
	 * Create frame.
	 */
	public GUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 409, 218);
		contentPane = new JPanel();
		contentPane.setBackground(UIManager.getColor("OptionPane.foreground"));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		labelTitle.setForeground(new Color(255, 255, 255));
		labelTitle.setFont(new Font("Eurostile", Font.PLAIN, 20));
		labelTitle.setBounds(157, 11, 136, 35);
		labelTitle.setHorizontalAlignment(SwingConstants.CENTER);
		contentPane.add(labelTitle);
		lblLinje.setHorizontalAlignment(SwingConstants.CENTER);
		lblLinje.setFont(new Font("Eurostile", Font.PLAIN, 14));

		lblLinje.setForeground(new Color(255, 255, 255));
		lblLinje.setBounds(6, 57, 72, 14);
		contentPane.add(lblLinje);
		lblNewLabel.setFont(new Font("Eurostile", Font.PLAIN, 14));

		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setBounds(88, 57, 124, 14);
		contentPane.add(lblNewLabel);
		lblNewLabel_1.setFont(new Font("Eurostile", Font.PLAIN, 14));

		lblNewLabel_1.setForeground(new Color(255, 255, 255));
		lblNewLabel_1.setBounds(302, 57, 75, 14);
		contentPane.add(lblNewLabel_1);

		labelLinje1.setForeground(new Color(255, 140, 0));
		labelLinje1.setBounds(31, 82, 20, 14);
		contentPane.add(labelLinje1);

		labelLinje2.setForeground(new Color(255, 140, 0));
		labelLinje2.setBounds(31, 107, 20, 14);
		contentPane.add(labelLinje2);

		labelLinje3.setForeground(new Color(255, 140, 0));
		labelLinje3.setBounds(31, 132, 20, 14);
		contentPane.add(labelLinje3);

		labelLinje4.setForeground(new Color(255, 140, 0));
		labelLinje4.setBounds(31, 157, 20, 14);
		contentPane.add(labelLinje4);

		labelDes1.setForeground(new Color(255, 140, 0));
		labelDes1.setBounds(86, 82, 173, 14);
		contentPane.add(labelDes1);

		labelDes2.setForeground(new Color(255, 140, 0));
		labelDes2.setBounds(88, 107, 171, 14);
		contentPane.add(labelDes2);

		labelDes3.setForeground(new Color(255, 140, 0));
		labelDes3.setBounds(88, 132, 171, 14);
		contentPane.add(labelDes3);

		labelDes4.setForeground(new Color(255, 140, 0));
		labelDes4.setBounds(88, 157, 171, 14);
		contentPane.add(labelDes4);

		labelTime1.setForeground(new Color(255, 140, 0));
		labelTime1.setBounds(302, 82, 46, 14);
		contentPane.add(labelTime1);

		labelTime2.setForeground(new Color(255, 140, 0));
		labelTime2.setBounds(302, 107, 46, 14);
		contentPane.add(labelTime2);

		labelTime3.setForeground(new Color(255, 140, 0));
		labelTime3.setBounds(302, 132, 46, 14);
		contentPane.add(labelTime3);

		labelTime4.setForeground(new Color(255, 140, 0));
		labelTime4.setBounds(302, 157, 46, 14);
		contentPane.add(labelTime4);

		UpdateLabels();

		Thread searchThread = new UpdateMe(this);
		searchThread.start();
		System.out.println("thread started");
	}

	public void UpdateLabels() {
		Lines lines = Parser.getStationResults(new Station("80046"));

		labelLinje1.setText(lines.getLines().get(0).getLine());
		labelLinje2.setText(lines.getLines().get(1).getLine());
		labelLinje3.setText(lines.getLines().get(2).getLine());
		labelLinje4.setText(lines.getLines().get(3).getLine());

		labelDes1.setText(lines.getLines().get(0).getDestination());
		labelDes2.setText(lines.getLines().get(1).getDestination());
		labelDes3.setText(lines.getLines().get(2).getDestination());
		labelDes4.setText(lines.getLines().get(3).getDestination());

		labelTime1.setText(FixThatClock(lines.getLines().get(0).getDepTime()
				.get(Calendar.HOUR_OF_DAY))
				+ ":"
				+ FixThatClock(lines.getLines().get(0).getDepTime()
						.get(Calendar.MINUTE)));
		labelTime2.setText(FixThatClock(lines.getLines().get(1).getDepTime()
				.get(Calendar.HOUR_OF_DAY))
				+ ":"
				+ FixThatClock(lines.getLines().get(1).getDepTime()
						.get(Calendar.MINUTE)));
		labelTime3.setText(FixThatClock(lines.getLines().get(2).getDepTime()
				.get(Calendar.HOUR_OF_DAY))
				+ ":"
				+ FixThatClock(lines.getLines().get(2).getDepTime()
						.get(Calendar.MINUTE)));
		labelTime4.setText(FixThatClock(lines.getLines().get(3).getDepTime()
				.get(Calendar.HOUR_OF_DAY))
				+ ":"
				+ FixThatClock(lines.getLines().get(3).getDepTime()
						.get(Calendar.MINUTE)));

		// if delay=0, it won't show. Otherwise the table will show + in front of delay
//		     if (lines.getLines().get(0).getDepTimeDeviation() != "") {
//				JLabel label = new JLabel("+");
//				label.setForeground(new Color(255, 255, 255));
//				label.setBounds(392, 82, 20, 14);
//				contentPane.add(label);
//				labelLate1.setText(lines.getLines().get(0).getDepTimeDeviation() + " min");
//			}
//		
//		     if (lines.getLines().get(1).getDepTimeDeviation() != "") {
//				JLabel label_1 = new JLabel("+");
//				label_1.setForeground(Color.WHITE);
//				label_1.setBounds(392, 107, 20, 14);
//				contentPane.add(label_1);
//				labelLate2.setText(lines.getLines().get(1).getDepTimeDeviation() + " min");
//			}
//		     if (lines.getLines().get(2).getDepTimeDeviation() != "") {
//				JLabel label_2 = new JLabel("+");
//				label_2.setForeground(Color.WHITE);
//				label_2.setBounds(392, 132, 20, 14);
//				contentPane.add(label_2);
//				labelLate3.setText(lines.getLines().get(2).getDepTimeDeviation() + " min");
//			}
//		    if (lines.getLines().get(3).getDepTimeDeviation() != "") {
//			JLabel label_3 = new JLabel("+");
//			label_3.setForeground(Color.WHITE);
//			label_3.setBounds(392, 157, 20, 14);
//			contentPane.add(label_3);
//			labelLate4.setText(lines.getLines().get(3).getDepTimeDeviation()+ " min");
//
//				
//			}
			

			

	}

	public String FixThatClock(int time) {
		// variables
		String zero = "";

		if (time < 10) {
			zero = "0";
		}

		// Compiles 
		String finalTimeString = zero + Integer.toString(time);

		zero = "";

		return finalTimeString;
	}
}
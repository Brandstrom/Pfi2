import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JTextArea;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;


public class ClockGUI extends JFrame {
	private String time;
	private String _hours;
	private String _minutes;
	private String _seconds;
	
	private String myHour;
	private String myMin;
	private String mySec;
	
	
	private JTextArea Timmar;
	private JTextArea Minuter;
	private JTextArea Sekunder;
	private JLabel clockLabel;

	int alarmHour;
	int alarmMinute;
	int alarmSecond;
	
	
	
	
	private ClockLogic myClock;

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ClockGUI frame = new ClockGUI();
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
	
	
	public ClockGUI() {
		this.setTitle("Min Klocka");
		myClock = new ClockLogic(ClockGUI.this);
		myClock.execute();//Execute the Clock
		
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 489, 323);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(153, 102, 102));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		Timmar=new JTextArea();
		Timmar.setBounds(60, 146, 98, 34);
		contentPane.add(Timmar);
		
		Minuter=new JTextArea();
Minuter.setBounds(195, 146, 98, 34);
		contentPane.add(Minuter);
		
		Sekunder=new JTextArea();

		Sekunder.setBounds(321, 146, 98, 34);
		contentPane.add(Sekunder);
		
		JButton btnSetAlarm = new JButton("Set alarm lazy!");
		btnSetAlarm.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnSetAlarm.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				
		myHour = new String (Timmar.getText());
		myMin = new String (Minuter.getText());
		mySec = new String (Sekunder.getText());
		
			int _alarmHour =Integer.parseInt(myHour);
			int _alarmMinute = Integer.parseInt(myMin);
			int _alarmSecond = Integer.parseInt(mySec);
			
			//Tilldelar variablerna värdena
			
			alarmHour = _alarmHour;
			alarmMinute = _alarmMinute;
			alarmSecond = _alarmSecond;
			
			myClock.setBoolean(true);
			
			myClock.setAlarm(alarmHour,alarmMinute,alarmSecond);
			
			//Variabler som skapar för att använda med If satserna /Lägger till 0 ifall siffran är mindre än 10
			
			String hours= Integer.toString(alarmHour);
			String minute= Integer.toString(alarmMinute);
			String seconds= Integer.toString(alarmSecond);
			
			if(alarmHour <10){
				hours= "0" + alarmHour;
			}
				if(alarmMinute <10){
					minute= "0" + alarmMinute;
				}
				if(alarmSecond <10){
					seconds= "0" + alarmSecond;
				}
				
				System.out.println("Alarmet är inställt på:  " + hours + " : " + minute + " : " + seconds);
				
			}
		});
		
		clockLabel=new JLabel("");
		clockLabel.setHorizontalAlignment(SwingConstants.CENTER);
		
		clockLabel.setBackground(new Color(255, 255, 255));
		clockLabel.setForeground(new Color(250, 250, 210));
		clockLabel.setFont(new Font("Showcard Gothic", Font.PLAIN, 50));
		clockLabel.setBounds(32, 23, 414, 87);
		contentPane.add(clockLabel);
		btnSetAlarm.setBounds(21, 231, 202, 42);
		contentPane.add(btnSetAlarm);
		
		
		JButton btnReset = new JButton("Reset");
		btnReset.setFont(new Font("Tahoma", Font.BOLD, 17));
		btnReset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
		myClock.reset();
		
		Timmar.setText("0" + String.valueOf(ClockLogic.alarm_hours));
		Minuter.setText("0" + String.valueOf(ClockLogic.alarm_minutes));
		Sekunder.setText("0" + String.valueOf(ClockLogic.alarm_second));
		
		System.out.println("Du har ställt alarmet!");
			}
		});
		btnReset.setBounds(233, 231, 213, 42);
		contentPane.add(btnReset);
		
		
		
		
		
		
		JLabel lblTimmar = new JLabel("Timmar");
		lblTimmar.setBounds(90, 121, 46, 14);
		contentPane.add(lblTimmar);
		
		JLabel lblMinuter = new JLabel("Minuter");
		lblMinuter.setBounds(233, 121, 46, 14);
		contentPane.add(lblMinuter);
		
		JLabel lblSekunder = new JLabel("Sekunder");
		lblSekunder.setBounds(352, 121, 46, 14);
		contentPane.add(lblSekunder);
	}
	
	
	
	public void setTime(int hour, int minutes, int seconds){
        
        /**
         * this method makes the clock work on the ClockLabel
         */
         
        _hours=Integer.toString(hour);
        _minutes=Integer.toString(minutes);
        _seconds=Integer.toString(seconds);
         
        /**
         * the if help to put a 0 if it is necessary
         */
         
        if(hour < 10){
                
               _hours = "0" + _hours;
           }
            
           if(minutes < 10)
           {
               _minutes = "0" + _minutes;
           }
           if(seconds < 10)
           {
               _seconds = "0" + _seconds;
           }
         
        time = _hours + ":" +   _minutes + ":" + _seconds;
         
        clockLabel.setText(time); //Paint the clock on the ClockLabel
         
    }
     
    public void invokeAlarm(){
        /**
         * Changes the color of the background when the alarm starts
         * and changes the color of text background, text color, and font
         */
    	  
    	 Color d = new Color((float) Math.random(), (float) Math.random(),(float) Math.random());
         contentPane.setBackground(d); 
     
          Timmar.setText("");
          Minuter.setText("");
          Sekunder.setText("");
    }
}


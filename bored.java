import java.awt.*;
import java.awt.event.*;  
import javax.swing.*; 
import java.util.Random;
import javax.swing.Timer;
import javax.swing.border.*;

public class bored extends JFrame implements ActionListener{
	//making a button that does random not-at-all useful things because I'm bored
	JButton b;
	Timer timer;
	Random r;
	int c;
	int count6;
	Image icon;
	int count7;
	JDialog d;
	JButton dButton;
	//int r2;
	
	public bored() {
		super("The most code ever");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(600, 600);
		setLayout(null);
		setVisible(true);
		
		b = new JButton("Click for a suprise");
		b.setBounds(220, 100, 150, 30);
		b.addActionListener(this);
		add(b);
		
		timer = new Timer(3000, this);
        timer.setRepeats(false);
		c = 0;
		count6 = 0; //some methods needed their own counter
		
		icon = Toolkit.getDefaultToolkit().getImage("1.png");
		count7 = 0;
		
		d = new JDialog(this, "WARNING", true);
		d.setLayout(new FlowLayout());
		dButton = new JButton("Okay");
		dButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				d.setVisible(false);
				//System.out.println("Inbox empty");
			}
		});
		d.add(new JLabel("This popup window just opened."));  
        d.add(dButton);   
        d.setSize(300,300); 
	}
	
	public void actionPerformed(ActionEvent e) {
		r = new Random();
		//System.out.println("Picking random number...");
		int r2 = r.nextInt(10); //pick a random number between 0 and 10
		//each number will trigger a random change. Why? Idk just for kicks I guess
		//only 5-9 do something at the moment. Might add more later if I feel like it
		//System.out.println("Random # is " + r2);
		
		if(r2 == 5) { //5 = force close immediatly
			System.out.println("lol");
			System.exit(0);
		}
		else if(r2 == 6) { //6 = add bevel border to button
			//System.out.println("Bevel time");
			//System.out.println("Counter was " + c);
			c++;
			//System.out.println("Now it's " + c);
			if(count6 != 0) {
				b.setText("Sorry I got nothin'");
			}
			else {
				b.setBorder(new BevelBorder(BevelBorder.RAISED));
				b.setText("Woah! It's 3D now!");
				//System.out.println("Count6 was " + count6);
				count6++;
				//System.out.println("Now it's " + count6);
			}
			
			timer.start();
			if(c == 2) {
				timer.stop();
			}
			if(!timer.isRunning()) {
				b.setText("Click for a suprise");
				//System.out.println("Resetting counter");
				c = 0;
				//System.out.println("It is now " + c);
				timer.stop();
			}
			//System.out.println("No more bevel time");
		}
		else if(r2 == 7) { //7 = change icon  of window to random panda emoji
			//System.out.println("Panda");
			//System.out.println("Counter was " + c);
			c++;
			//System.out.println("Now it's " + c);
			if(count7 > 0) {
				b.setText("Come again?");
			}
			else {
				//System.out.println("Changing...");
				setIconImage(icon);
				b.setText("Quick change!");
				//System.out.println("...icon");
			}
			//System.out.println("Count7 was " + count7);
			count7++;
			//System.out.println("Now it's " + count7);
			timer.start();
			if(c == 2) {
				timer.stop();
			}
			if(!timer.isRunning()) {
				b.setText("Click for a suprise");
				//System.out.println("Resetting counter");
				c = 0;
				//System.out.println("It is now " + c);
				timer.stop();
			}
			//System.out.println("monium");
		}
		else if(r2 == 8) { //8 = make button blue
			//System.out.println("I'm blue");
			//System.out.println("Counter is at " + c);
			c++;
			//System.out.println("Actually now it's " + c);
			//System.out.println("Changing...");
			b.setBackground(Color.BLUE);
			b.setText("ba buh dee ba buh di");
			//System.out.println("...colors");
			
			timer.start();
			if(c == 2) {
				timer.stop();
			}
			if(!timer.isRunning()) {
				//System.out.println("Changing colors...");
				b.setBackground(null);
				b.setText("Click for a suprise");
				//System.out.println("...again");
				//System.out.println("Resetting counter...");
				c = 0;
				//System.out.println("Counter is now " + c);
			}
			//System.out.println("I'm not blue");
		}
		else if(r2 == 9) {
			//System.out.println("You've got mail");
			d.setVisible(true);
		}
		else { //default/0 is to just say nothing happened and then reset
			//System.out.println("It's quiet in here...");
			c++;
			b.setText("Nothing happened!");
			timer.start();
			if(c == 2) {
				timer.stop();
			}
			if(!timer.isRunning()) {
				b.setText("Click for a suprise");
				c = 0;
			}
			//System.out.println("Make some noise already!");
		}
	}
	
	public static void main(String[] args) {
		new bored();
	}
	
	
}
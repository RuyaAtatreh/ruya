package time;
import java.util.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
public class time extends JFrame {
	private JLabel l1,l2,l3;
	MyThread t;
	GregorianCalendar gc;
	public time() {
		super("TimeDemo");
		l1=new JLabel();
		l2=new JLabel();
		l3=new JLabel();
		add(l1,BorderLayout.NORTH);
		add(l2,BorderLayout.CENTER);
		add(l3,BorderLayout.SOUTH);
		gc= new GregorianCalendar();
		l1.setText(gc.getTime().toString());
		l2.setText("date="+gc.get(gc.DATE)
		+"Month="+gc.get(gc.MONTH)
		+"Year="+gc.get(gc.YEAR));
		l3.setText(gc.get(gc.HOUR)+":"+gc.get(gc.MINUTE)+":"+gc.get(gc.SECOND));
		t=new MyThread("Timer");
		setSize(200,200);
		setVisible(true);
	}
	public static void main (String args[]) {
		time app=new time();
		app.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	class MyThread extends Thread{
		public MyThread(String sn) {
			super(sn);
			start();
		}
		public void run() {
			while(true) {
				try {
					Thread.sleep(1000);
					gc=new GregorianCalendar();
					l1.setText(gc.getTime().toString());
					l3.setText(gc.get(gc.HOUR)+":"+gc.get(gc.MINUTE)+":"+gc.get(gc.SECOND));
				}
				catch(InterruptedException in) {System.out.println(in.toString());}
			}
		}
	}
}


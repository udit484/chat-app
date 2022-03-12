package chatting.application;

import java.awt.Color;

import java.awt.event.*;
import java.awt.Font;
import java.awt.Image;
import java.net.*;
import java.io.*;

import javax.swing.*;

public class Server extends JFrame implements ActionListener{
	
	JPanel p1;
	JTextField t1;
	JButton b1;
	static JTextArea a1;
	
	static ServerSocket skt;
	static Socket s;
	static DataInputStream din;
	static DataOutputStream dout;
	
	Server(){
		setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
		
		p1 = new JPanel();
		p1.setLayout(null);
		p1.setBackground(new Color(7,94,84));
		p1.setBounds(0,0,450,70);
		add(p1);
		
		ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("chatting/application/icons/3.png"));
		Image i2 = i1.getImage().getScaledInstance(30,30, Image.SCALE_DEFAULT);
		ImageIcon i3 = new ImageIcon(i2);
		JLabel l1 = new JLabel(i3);
		l1.setBounds(5,17,30,30);
		p1.add(l1);
		
		l1.addMouseListener(new MouseAdapter() {
			public void mouseClicked (MouseEvent ae) {
				
			System.exit(0);
			
		}
		});
		
		
		
		ImageIcon i4 = new ImageIcon(ClassLoader.getSystemResource("chatting/application/icons/2.png"));
		Image i5 = i4.getImage().getScaledInstance(45,45, Image.SCALE_DEFAULT);
		ImageIcon i6 = new ImageIcon(i5);
		JLabel l2 = new JLabel(i6);
		l2.setBounds(40,12,45,45);
		p1.add(l2);
		
		
		ImageIcon i7 = new ImageIcon(ClassLoader.getSystemResource("chatting/application/icons/video.png"));
		Image i8 = i7.getImage().getScaledInstance(30,30, Image.SCALE_DEFAULT);
		ImageIcon i9 = new ImageIcon(i8);
		JLabel l5 = new JLabel(i9);
		l5.setBounds(320,20,30,30);
		p1.add(l5);
		
		
		ImageIcon i11 = new ImageIcon(ClassLoader.getSystemResource("chatting/application/icons/phone.png"));
		Image i12 = i11.getImage().getScaledInstance(30,30, Image.SCALE_DEFAULT);
		ImageIcon i13 = new ImageIcon(i12);
		JLabel l6= new JLabel(i13);
		l6.setBounds(370,20,30,30);
		p1.add(l6);
		
		
		ImageIcon i14 = new ImageIcon(ClassLoader.getSystemResource("chatting/application/icons/3icon.png"));
		Image i15 = i14.getImage().getScaledInstance(25,25, Image.SCALE_DEFAULT);
		ImageIcon i16 = new ImageIcon(i15);
		JLabel l7 = new JLabel(i16);
		l7.setBounds(410,21,25,25);
		p1.add(l7);
		
		
		
		JLabel l3 = new JLabel("Rambo");
		l3.setFont(new Font("SAN_SERIF",Font.BOLD,18));
		l3.setForeground(Color.white);
		l3.setBounds(105,15,100,18);
		p1.add(l3);
		
		
		JLabel l4 = new JLabel("Active Now");
		l4.setFont(new Font("SAN_SERIF",Font.PLAIN,13));
		l4.setForeground(Color.white);
		l4.setBounds(105,35,100,20);
		p1.add(l4);
		
		a1=new JTextArea();
		a1.setBounds(5,70,460,550);
		a1.setLineWrap(true);
		a1.setWrapStyleWord(true);
		add(a1);
		
		t1=new JTextField();
		t1.setBounds(5,620,320,50);
		t1.setFont(new Font("SAN_SERIF",Font.PLAIN,16));
		add(t1);
	
		b1=new JButton("Send");
		b1.setBounds(335,625,100,40);
		b1.setBackground(new Color(7,94,84));
		b1.addActionListener(this);
		add(b1);
		
		
		getContentPane().setBackground(Color.white);
		setLayout(null);
		setSize(450,700);
		setLocation(400,200);
		//setUndecorated(true);
		setVisible(true);
		
		
	}
	
	public void actionPerformed(ActionEvent ae) {
		try {
		String out = t1.getText();
		a1.setText(a1.getText()+"\n\t\t\t"+out);
		dout.writeUTF(out);
		a1.setFont(new Font("SAN_SERIF",Font.PLAIN,18) );
		a1.setEditable(false);
		t1.setText(" ");
		}catch(Exception e) {}
		
		
	}
	
	public static void main(String[] args) {
		new Server().setVisible(true);
		
		String msginput = " ";
		try {
			 skt = new ServerSocket(6001);
	            while(true){
	                s = skt.accept();
	                din = new DataInputStream(s.getInputStream());
	                dout = new DataOutputStream(s.getOutputStream());

		        while(true){
		                msginput = din.readUTF();
	        		a1.setText(a1.getText()+"\n"+msginput);
	        		   
	            	}

	            }
			
			
			
			
			
			}catch(Exception e) {}
	}

}
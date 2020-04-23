package view;


import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class LoginView {

	private JLabel user =new JLabel("username:");
	private JLabel pass=new JLabel("password:");
	
	private JTextField username=new JTextField();
	private JPasswordField password=new JPasswordField();
	
	private JButton login=new JButton("Login");
	JFrame frame=new JFrame("Login");
	
	public LoginView(){
		frame = new JFrame();
		frame.setBounds(100, 100, 935, 677);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setSize(new Dimension(1920,840));
		frame.setLocationRelativeTo(null);
		
		
		user.setBounds(572,300,85,21);
		user.setForeground(Color.WHITE);
		user.setFont(new Font("Cambria", Font.BOLD, 16));
		frame.getContentPane().add(user);
		pass.setBounds(572,400,85,21);
		pass.setForeground(Color.WHITE);
		pass.setFont(new Font("Cambria", Font.BOLD, 16));
		frame.getContentPane().add(pass);
		username.setBounds(655,300,160,21);
		frame.getContentPane().add(username);
		password.setBounds(655,400,160,21);
		frame.getContentPane().add(password);
		login.setBounds(655, 500, 83, 21);
		login.setBackground(Color.WHITE);
		frame.getContentPane().add(login);
		
		
		JLabel background = new JLabel("New label");
		ImageIcon imageIcon = new ImageIcon("p3.png"); // load the image to a imageIcon
		Image image = imageIcon.getImage(); // transform it 
		Image newimg = image.getScaledInstance(1550, 870,  java.awt.Image.SCALE_SMOOTH); // scale it the smooth way  
		imageIcon = new ImageIcon(newimg);
		background.setIcon(imageIcon);
		background.setBounds(0, 0, 1550,810);
		frame.getContentPane().add(background);
		
		frame.setVisible(true);
		
	}
	
	public void addLoginListener(ActionListener listen)
	{
		login.addActionListener(listen);
		
	}
	public JButton getLogin()
	{
		return login;
	}
	public String getUser()
	{
		return username.getText();
	}
	public String getPass()
	{
		return password.getText();
	}
	public void closeFrame()
	{
		frame.setVisible(false);
	}
	
	public  void showMessage(String message)
	{
		JOptionPane.showMessageDialog(null,message);
	}
	
}
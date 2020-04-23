package view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JToggleButton;

import javax.swing.JEditorPane;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.Font;

public class AdminView {

	private JFrame frame;
	private JTextField nameTextField;
	private JTextField ageTextField;
	private JTextField codeTextField;
	private JTable table_1;
	private JTextField usernameTextField;
	private JTextField passwordTextField;
	private JButton viewDoctorsButton;
	private JButton viewEmployeesButton;
	private JButton addButton;
	private JButton deleteButton;
	private JButton updateButton;
	private JButton viewAllButton;
	private JFrame frame1;
	private JRadioButton doctorRdButton;
	private JRadioButton employeeRdButton;
	private JScrollPane scrollPane ;

	


	public AdminView() {
		initialize();
		display();
		
	}
	public void display()
	{
		frame.setVisible(true);
	}

	private void initialize() {
		frame = new JFrame("Administrator");
		frame.setBounds(100, 100, 935, 677);
		//frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setSize(new Dimension(1920,840));
		frame.setLocationRelativeTo(null);
	
		
		 addButton = new JButton("Add");
		addButton.setBounds(37, 498, 146, 21);
		addButton.setBackground(new Color(244, 164, 96));
		frame.getContentPane().add(addButton);
		
		updateButton = new JButton("Update");
		updateButton.setBounds(37, 706, 146, 21);
		updateButton.setBackground(new Color(244, 164, 96));
		frame.getContentPane().add(updateButton);
		
		deleteButton = new JButton("Delete");
		deleteButton.setBounds(37, 752, 146, 21);
		deleteButton.setBackground(new Color(244, 164, 96));
		frame.getContentPane().add(deleteButton);
		
		 doctorRdButton = new JRadioButton("Doctor");
		 doctorRdButton.setBackground(new Color(244, 164, 96));
		doctorRdButton.setBounds(37, 172, 111, 21);
		frame.getContentPane().add(doctorRdButton);
		
		employeeRdButton = new JRadioButton("Employee");
		employeeRdButton.setBackground(new Color(244, 164, 96));
		employeeRdButton.setBounds(203, 172, 105, 21);
		frame.getContentPane().add(employeeRdButton);
		
		JLabel nameLabel = new JLabel("Nume");
		nameLabel.setFont(new Font("Cambria", Font.BOLD, 14));
		nameLabel.setBounds(37, 235, 46, 13);
		nameLabel.setForeground(Color.WHITE);
		frame.getContentPane().add(nameLabel);
		
		JLabel ageLabel = new JLabel("Varsta");
		ageLabel.setFont(new Font("Cambria", Font.BOLD, 14));
		ageLabel.setBounds(37, 288, 46, 13);
		ageLabel.setForeground(Color.WHITE);
		frame.getContentPane().add(ageLabel);
		
		JLabel codeLabel = new JLabel("Cod");
		codeLabel.setFont(new Font("Cambria", Font.BOLD, 14));
		codeLabel.setBounds(37, 340, 46, 13);
		codeLabel.setForeground(Color.WHITE);
		frame.getContentPane().add(codeLabel);
		
		nameTextField = new JTextField();
		nameTextField.setBounds(203, 233, 105, 19);
		frame.getContentPane().add(nameTextField);
		nameTextField.setColumns(10);
		
		ageTextField = new JTextField();
		ageTextField.setBounds(203, 286, 105, 19);
		frame.getContentPane().add(ageTextField);
		ageTextField.setColumns(10);
		
		codeTextField = new JTextField();
		codeTextField.setBounds(203, 338, 105, 19);
		frame.getContentPane().add(codeTextField);
		codeTextField.setColumns(10);
		
		viewDoctorsButton = new JButton("View All Doctors");
		viewDoctorsButton.setBounds(37, 604, 144, 21);
		viewDoctorsButton.setBackground(new Color(244, 164, 96));
		frame.getContentPane().add(viewDoctorsButton);
		
		JLabel usenameLabel = new JLabel("username");
		usenameLabel.setFont(new Font("Cambria", Font.BOLD, 14));
		usenameLabel.setBounds(37, 389, 85, 13);
		usenameLabel.setForeground(Color.WHITE);
		frame.getContentPane().add(usenameLabel);
		
		JLabel passwordLabel = new JLabel("parola");
		passwordLabel.setFont(new Font("Cambria", Font.BOLD, 14));
		passwordLabel.setBounds(37, 442, 64, 13);
		passwordLabel.setForeground(Color.WHITE);
		frame.getContentPane().add(passwordLabel);
		
		usernameTextField = new JTextField();
		usernameTextField.setBounds(203, 387, 105, 19);
		frame.getContentPane().add(usernameTextField);
		usernameTextField.setColumns(10);
		
		passwordTextField = new JTextField();
		passwordTextField.setBounds(203, 440, 105, 19);
		frame.getContentPane().add(passwordTextField);
		passwordTextField.setColumns(10);
		
		 viewEmployeesButton = new JButton("View All Employees");
		viewEmployeesButton.setBounds(37, 655, 146, 21);
		viewEmployeesButton.setBackground(new Color(244, 164, 96));
		frame.getContentPane().add(viewEmployeesButton);
		
	    scrollPane =new JScrollPane();
	    frame.getContentPane().add(scrollPane);
		
	    viewAllButton = new JButton("View All");
		viewAllButton.setBounds(37, 550, 144, 21);
		viewAllButton.setBackground(new Color(244, 164, 96));
		frame.getContentPane().add(viewAllButton);
		
		JLabel lblNewLabel_10 = new JLabel("New label");
		ImageIcon imageIcon = new ImageIcon("p3.png"); // load the image to a imageIcon
		Image image = imageIcon.getImage(); // transform it 
		Image newimg = image.getScaledInstance(1570, 830,  java.awt.Image.SCALE_SMOOTH); // scale it the smooth way  
		imageIcon = new ImageIcon(newimg);
		lblNewLabel_10.setIcon(imageIcon);
		lblNewLabel_10.setBounds(0, -24, 1594, 878);
		frame.getContentPane().add(lblNewLabel_10);
		
		
		

		
	}
	
	public String[] getUserInput()
	{
		String[] inputs=new String[5];
		inputs[0]=(nameTextField.getText());
		inputs[1]=(ageTextField.getText());
		inputs[2]=(codeTextField.getText());
		inputs[3]=(usernameTextField.getText());
		inputs[4]=(passwordTextField.getText());
		
		return inputs;
		
	}
	public String[] getUpdateData()
	{
		String[] values=new String[5];
		values[0]=nameTextField.getText();
		values[1]=ageTextField.getText();
		values[2]=codeTextField.getText();
		values[3]=usernameTextField.getText();
		values[4]=passwordTextField.getText();
		return values;
		
	}
	
	
	public String getRol()
	{
		if (doctorRdButton.isSelected())
			return "DOCTOR";
		else return "ANGAJAT";
	}
	
	public void addViewAllListener(ActionListener listen)
	{
		viewAllButton.addActionListener(listen);
	}
	public void addViewAllDoctorsListener(ActionListener listen)
	{
		viewDoctorsButton.addActionListener(listen);
	}
	public void addViewAllEmployeesListener(ActionListener listen)
	{
		viewEmployeesButton.addActionListener(listen);
	}
	public void addAddListener(ActionListener listen)
	{
		addButton.addActionListener(listen);
	}
	
	public void addDeleteListener(ActionListener listen)
	{
		deleteButton.addActionListener(listen);
	}
	public void addUpdateListener(ActionListener listen)
	{
		updateButton.addActionListener(listen);
	}
	public void viewAll(Object[] columns, Object[][] data)
	{
		
		this.table_1=new JTable(data,columns); 
		table_1.setFillsViewportHeight(true); 
	    table_1.setPreferredScrollableViewportSize(new Dimension(300, 80)); 
	   
	    scrollPane.setViewportView(table_1);
	    scrollPane.setBounds(420,170,730,300);

	}
	public void closeTable()
	{
		this.frame1.dispose();
		
	}
	public int getSelectedRow()
	{
		return table_1.getSelectedRow();
	}
	public String[] getRowData()
	{
		String values[]=new String[table_1.getColumnCount()];
		int row=table_1.getSelectedRow();
		for (int column=0;column<table_1.getColumnCount();column++)
		{
			String s=table_1.getModel().getValueAt(row,column).toString();
			values[column]=s;
		}
		return values;
		
	}
	public  void showMessage(String message)
	{
		JOptionPane.showMessageDialog(null,message);
	}
}

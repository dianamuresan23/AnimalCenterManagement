package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.SwingUtilities;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;


import model.Persistence;

import java.lang.reflect.Field;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.util.ArrayList;

import java.awt.event.ActionEvent;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTextArea;



import org.jfree.chart.JFreeChart;
import org.jfree.chart.labels.PieSectionLabelGenerator;
import org.jfree.chart.labels.StandardPieSectionLabelGenerator;
import org.jfree.chart.plot.PiePlot;
import org.jfree.chart.plot.PiePlot3D;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartFrame;
import org.jfree.data.general.DefaultPieDataset;


public class EmployeeView {

	private JFrame frame;

	
	private JTextField filterTextField;
	private JTextField foodTypeTextField; 
	private JTextField locomotionTextField;
	private JTextField nameTextField;
	private JTextField speciesTextField;
	private JButton addAnimalButton;
    private JButton	viewAllAnimalsButton;
    private JButton	filterButton;
    private JButton deleteAnimalUpdate;
    private JButton updateAnimalButton;
    private JTable animalsTable;;
    private JComboBox filterComboBox;
    private JTable appointmentsTable;
    private JLabel doctorLabel;
    private JTextField doctorTextField;
    private JTextArea textArea;
    private JLabel availableDocsLabel;
    private JButton statisticsButton;
    private JScrollPane scrollPane;
    private JScrollPane scrollPane2;
    private JLabel dayLabel;
    private JLabel hourLabel;
    private JComboBox comboBox_1;
    private JComboBox comboBox_2;
    private JButton checkButton;
    private JTextField docTextField;
    private JTextField infoTextField;
    private JButton makeAppointmentButton;
    private JLabel monthLabel;
    private JComboBox comboBox_3;
    private JButton viewAppointmentsButton;
    private JButton deleteAppointmentButton;
    private JButton saveReportsButton;
    private JTextField animalIdTextField;
    private JTextField idTextField;
    
 
	
	public EmployeeView() {
		initialize();
		frame.setVisible(true);
		
	}
 
	
	private void initialize() {
		frame = new JFrame("Angajat");
		frame.setBounds(100, 100, 450, 300);
		//frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setSize(new Dimension(1543, 840));
		frame.setLocationRelativeTo(null);
		
		filterButton = new JButton("Filter");
		filterButton.setBackground(new Color(244, 164, 96));
		filterButton.setBounds(780, 369, 146, 21);
		frame.getContentPane().add(filterButton);
		
		filterComboBox = new JComboBox();
		filterComboBox.setModel(new DefaultComboBoxModel(new String[] {"Specie", "Tip Alimentatie", "Tip Locomotie", "Diagnostic"}));
		filterComboBox.setEditable(true);
		filterComboBox.setBounds(334, 369, 146, 21);
		
		
		
		frame.getContentPane().add(filterComboBox);
		
		filterTextField = new JTextField();
		filterTextField.setBounds(548, 370, 146, 19);
		frame.getContentPane().add(filterTextField);
		filterTextField.setColumns(10);
		
		JLabel foodTypeLabel = new JLabel("Tip Alimentatie");
		foodTypeLabel.setBounds(59, 281, 136, 21);
		foodTypeLabel.setForeground(Color.WHITE);
		foodTypeLabel.setFont(new Font("Cambria", Font.BOLD, 16));
		frame.getContentPane().add(foodTypeLabel);
		
		foodTypeTextField = new JTextField();
		foodTypeTextField.setBounds(193, 284, 96, 19);
		frame.getContentPane().add(foodTypeTextField);
		foodTypeTextField.setColumns(10);
		
		JLabel locomotionLabel = new JLabel("Tip Locomotie");
		locomotionLabel.setForeground(Color.WHITE);
		locomotionLabel.setFont(new Font("Cambria", Font.BOLD, 16));
		locomotionLabel.setBounds(59, 322, 124, 25);
		frame.getContentPane().add(locomotionLabel);
		
		locomotionTextField = new JTextField();
		locomotionTextField.setBounds(193, 327, 96, 19);
		frame.getContentPane().add(locomotionTextField);
		locomotionTextField.setColumns(10);
		
		
		JLabel nameLabel = new JLabel("Nume");
		nameLabel.setForeground(Color.WHITE);
		nameLabel.setFont(new Font("Cambria", Font.BOLD, 16));
		nameLabel.setBounds(59, 190, 46, 13);
		frame.getContentPane().add(nameLabel);
		
		nameTextField = new JTextField();
		nameTextField.setBounds(193, 189, 96, 19);
		frame.getContentPane().add(nameTextField);
		nameTextField.setColumns(10);
		
		addAnimalButton = new JButton("Add");
		addAnimalButton.setBackground(new Color(244, 164, 96));
		addAnimalButton.setBounds(334, 141, 146, 21);
		frame.getContentPane().add(addAnimalButton);
		
		
		updateAnimalButton = new JButton("Update");
		updateAnimalButton.setBackground(new Color(244, 164, 96));
		updateAnimalButton.setBounds(334, 238, 146, 21);
		frame.getContentPane().add(updateAnimalButton);
		
		deleteAnimalUpdate = new JButton("Delete");
		deleteAnimalUpdate.setBackground(new Color(244, 164, 96));
		deleteAnimalUpdate.setBounds(334, 283, 146, 21);
		frame.getContentPane().add(deleteAnimalUpdate);
		
		 viewAllAnimalsButton = new JButton("View All");
		 viewAllAnimalsButton.setForeground(Color.BLACK);
		 viewAllAnimalsButton.setBackground(new Color(244, 164, 96));
		viewAllAnimalsButton.setBounds(334, 188, 146, 21);
		frame.getContentPane().add(viewAllAnimalsButton);
		
		 statisticsButton = new JButton("Statistics");
		 statisticsButton.setBackground(new Color(244, 164, 96));
		statisticsButton.setBounds(1027, 369, 146, 21);
		frame.getContentPane().add(statisticsButton);
		
		JLabel speciesLabel = new JLabel("Specie");
		speciesLabel.setForeground(Color.WHITE);
		speciesLabel.setFont(new Font("Cambria", Font.BOLD, 16));
		speciesLabel.setBounds(59, 235, 79, 22);
		frame.getContentPane().add(speciesLabel);
		
		speciesTextField = new JTextField();
		speciesTextField.setBounds(193, 239, 96, 19);
		frame.getContentPane().add(speciesTextField);
		speciesTextField.setColumns(10);
		
		doctorLabel = new JLabel("Doctor");
		doctorLabel.setForeground(Color.WHITE);
		doctorLabel.setFont(new Font("Cambria", Font.BOLD, 16));
		doctorLabel.setBounds(59, 369, 79, 13);
		frame.getContentPane().add(doctorLabel);
		
		doctorTextField = new JTextField();
		doctorTextField.setBounds(193, 368, 96, 19);
		frame.getContentPane().add(doctorTextField);
		doctorTextField.setColumns(10);
		JScrollPane scrollPane1=new JScrollPane();
		scrollPane1.setBounds(59, 651, 421, 142);
		frame.getContentPane().add(scrollPane1);
		
		
		textArea = new JTextArea();
		scrollPane1.setViewportView(textArea);
		
		availableDocsLabel = new JLabel("Doctori disponibili");
		availableDocsLabel.setBounds(195, 625, 167, 16);
		availableDocsLabel.setForeground(Color.WHITE);
		availableDocsLabel.setFont(new Font("Cambria", Font.BOLD, 16));
		frame.getContentPane().add(availableDocsLabel);
		
		scrollPane =new JScrollPane(); 
        frame.getContentPane().add(scrollPane);
        
        scrollPane2=new JScrollPane();
        frame.getContentPane().add(scrollPane2);
        
        dayLabel = new JLabel("Zi");
        dayLabel.setForeground(Color.WHITE);
        dayLabel.setFont(new Font("Cambria", Font.BOLD, 16));
        dayLabel.setBounds(149, 429, 46, 13);
        frame.getContentPane().add(dayLabel);
        
        hourLabel = new JLabel("Ora");
        hourLabel.setFont(new Font("Cambria", Font.BOLD, 16));
        hourLabel.setForeground(Color.WHITE);
        hourLabel.setBounds(223, 429, 46, 13);
        frame.getContentPane().add(hourLabel);
        
        comboBox_1 = new JComboBox();
        comboBox_1.setModel(new DefaultComboBoxModel(new String[] {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31"}));
        comboBox_1.setBounds(149, 452, 51, 21);
        frame.getContentPane().add(comboBox_1);
        
        comboBox_2 = new JComboBox();
        comboBox_2.setModel(new DefaultComboBoxModel(new String[] {"8:00", "9:00", "10:00", "11:00", "12:00", "13:00", "14:00", "15:00", "16:00", "17:00", "18:00", "19:00"}));
        comboBox_2.setBounds(210, 452, 79, 21);
        frame.getContentPane().add(comboBox_2);
        
        checkButton = new JButton("Check Disponibility");
        checkButton.setBackground(new Color(244, 164, 96));
        checkButton.setBounds(334, 452, 146, 21);
        frame.getContentPane().add(checkButton);
        
        docTextField = new JTextField();
        docTextField.setBounds(149, 543, 140, 19);
        frame.getContentPane().add(docTextField);
        docTextField.setColumns(10);
        
        JLabel docLabel = new JLabel("Doctor");
        docLabel.setFont(new Font("Cambria", Font.BOLD, 16));
        docLabel.setForeground(Color.WHITE);
        docLabel.setBounds(59, 544, 85, 13);
        frame.getContentPane().add(docLabel);
        
        JLabel infoLabel = new JLabel("Info");
        infoLabel.setFont(new Font("Cambria", Font.BOLD, 16));
        infoLabel.setForeground(Color.WHITE);
        infoLabel.setBounds(59, 584, 68, 13);
        frame.getContentPane().add(infoLabel);
        
        infoTextField = new JTextField();
        infoTextField.setBounds(149, 583, 140, 19);
        frame.getContentPane().add(infoTextField);
        infoTextField.setColumns(10);
        
        makeAppointmentButton = new JButton("Make \r\nAppointment");
        makeAppointmentButton.setBackground(new Color(244, 164, 96));
        makeAppointmentButton.setBounds(334, 500, 146, 21);
        frame.getContentPane().add(makeAppointmentButton);
		
		
		
		
		monthLabel = new JLabel("Luna");
		monthLabel.setFont(new Font("Cambria", Font.BOLD, 16));
		monthLabel.setForeground(Color.WHITE);
		monthLabel.setBackground(Color.WHITE);
		monthLabel.setBounds(59, 429, 46, 13);
		frame.getContentPane().add(monthLabel);
		
		comboBox_3 = new JComboBox();
		comboBox_3.setModel(new DefaultComboBoxModel(new String[] {"Ianuarie", "Februarie", "Martie", "Aprilie", "Mai", "Iunie", "Iulie", "August", "Septembrie", "Octombrie", "Noiembrie", "Decembrie"}));
		comboBox_3.setBounds(59, 452, 85, 21);
		frame.getContentPane().add(comboBox_3);
		
		viewAppointmentsButton = new JButton("View Appointments");
		viewAppointmentsButton.setBackground(new Color(244, 164, 96));
		viewAppointmentsButton.setBounds(334, 582, 146, 21);
		frame.getContentPane().add(viewAppointmentsButton);
		
		deleteAppointmentButton = new JButton("Delete");
		deleteAppointmentButton.setBackground(new Color(244, 164, 96));
		deleteAppointmentButton.setBounds(809, 731, 85, 21);
		frame.getContentPane().add(deleteAppointmentButton);
		
		saveReportsButton = new JButton("Save reports");
		saveReportsButton.setBackground(new Color(244, 164, 96));
		saveReportsButton.setBounds(334, 326, 146, 21);
		frame.getContentPane().add(saveReportsButton);
		
		JLabel animalIdLabel = new JLabel("ID");
		animalIdLabel.setForeground(Color.WHITE);
		animalIdLabel.setFont(new Font("Cambria", Font.BOLD, 16));
		animalIdLabel.setBounds(59, 143, 46, 13);
		frame.getContentPane().add(animalIdLabel);
		
		animalIdTextField = new JTextField();
		animalIdTextField.setBounds(193, 142, 96, 19);
		frame.getContentPane().add(animalIdTextField);
		animalIdTextField.setColumns(10);
		
		JLabel idLabel = new JLabel("ID");
		idLabel.setFont(new Font("Cambria", Font.BOLD, 16));
		idLabel.setForeground(Color.WHITE);
		idLabel.setBounds(59, 502, 46, 13);
		frame.getContentPane().add(idLabel);
		
		idTextField = new JTextField();
		idTextField.setBounds(149, 501, 140, 19);
		frame.getContentPane().add(idTextField);
		idTextField.setColumns(10);
		
		
		
		
		JLabel lblNewLabel_12 = new JLabel("New label");
		ImageIcon imageIcon = new ImageIcon("p3.png"); // load the image to a imageIcon
		Image image = imageIcon.getImage(); // transform it 
		Image newimg = image.getScaledInstance(1570, 830,  java.awt.Image.SCALE_SMOOTH); // scale it the smooth way  
		imageIcon = new ImageIcon(newimg);
		lblNewLabel_12.setIcon(imageIcon);
		lblNewLabel_12.setBounds(0, -24, 1594, 878);
		
		frame.getContentPane().add(lblNewLabel_12);
		
		
		
		
		
		
		
				
	}
	
	public void addAddListener(ActionListener listen)
	{
		addAnimalButton.addActionListener(listen);
	}
	public void addViewAllListener(ActionListener listen)
	{
		viewAllAnimalsButton.addActionListener(listen);
	}
	public void addFilterListener(ActionListener listen)
	{
		filterComboBox.addActionListener(listen);
		filterButton.addActionListener(listen);
		
	}
	public void addSaveReportsListener(ActionListener listen)
	{
		filterComboBox.addActionListener(listen);
		saveReportsButton.addActionListener(listen);
	}
	public void addDeleteListener(ActionListener listen)
	{
		deleteAnimalUpdate.addActionListener(listen);
	}
	public void addUpdateListener(ActionListener listen)
	{
		updateAnimalButton.addActionListener(listen);
	}
	public void addViewAppointmentsListener(ActionListener listen)
	{
		viewAppointmentsButton.addActionListener(listen);
	}
	public void addStatisticsListener(ActionListener listen)
	{
		filterComboBox.addActionListener(listen);
		statisticsButton.addActionListener(listen);
	}
	public void addCheckListener(ActionListener listen)
	{
		comboBox_1.addActionListener(listen);
		comboBox_2.addActionListener(listen);
		comboBox_3.addActionListener(listen);
		checkButton.addActionListener(listen);
		makeAppointmentButton.addActionListener(listen);
	}
	
	public void addDeleteAppointmentListener(ActionListener listen)
	{
		deleteAppointmentButton.addActionListener(listen);
	}
	
	
	public ArrayList<String> getAddUserInput()
	{
		ArrayList<String> inputs=new ArrayList<String>();
		inputs.add(animalIdTextField.getText());
		inputs.add(nameTextField.getText());
		inputs.add(speciesTextField.getText());
		inputs.add(foodTypeTextField.getText());
		inputs.add(locomotionTextField.getText());
		inputs.add("-");
		inputs.add("-");
		inputs.add("-");
		inputs.add(doctorTextField.getText());
		
		return inputs;
		
	}
	

	public void viewAll(Object[] columns, Object[][] data)
	{
		
		this.animalsTable=new JTable(data,columns); 
		animalsTable.setFillsViewportHeight(true); 
		animalsTable.setPreferredScrollableViewportSize(new Dimension(300, 80)); 
	   
	    scrollPane.setViewportView(animalsTable);
	    scrollPane.setBounds(510,142,700,205);
		
	}
	
	public void viewAll2(Object[] columns, Object[][] data)
	{
		
		
		this.appointmentsTable=new JTable(data,columns); 
		appointmentsTable.setFillsViewportHeight(true); 
		appointmentsTable.setPreferredScrollableViewportSize(new Dimension(300, 80)); 
	   
	    scrollPane2.setViewportView(appointmentsTable);
	    scrollPane2.setBounds(510,450,700,230);
	
	}
	
	public String[] getRowData()
	{
		String values[]=new String[animalsTable.getColumnCount()];
		int row=animalsTable.getSelectedRow();
		for (int column=0;column<animalsTable.getColumnCount();column++)
		{
			String s=animalsTable.getModel().getValueAt(row,column).toString();
			values[column]=s;
		}
		return values;
		
	}
	public String[] getUpdateData()
	{
		String[] values=new String[6];
		values[0]=animalIdTextField.getText();
		values[1]=nameTextField.getText();
		values[2]=speciesTextField.getText();
		values[3]=foodTypeTextField.getText();
		values[4]=locomotionTextField.getText();
		values[5]=doctorTextField.getText();
		return values;
		
	}
	
	public void addAvailableDoctor(String str)
	{
		if (str.equals(""))
			{
				this.textArea.append("Nu este disponibil!");
				this.textArea.append("\n");
			}
			
		else
		{
			this.textArea.append(str);
			this.textArea.append("\n");
		}
	}
	public void clearAvailableDoctor()
	{
		this.textArea.setText("");
	}
	
	
	public int getSelectedRow()
	{
		return animalsTable.getSelectedRow();
	}
	public int getSelectedRowAppointment()
	{
		return appointmentsTable.getSelectedRow();
	}
	public JComboBox getFilterComboBox()
	{
		return filterComboBox;
	}
	public JComboBox getMonthComboBox()
	{
		return comboBox_3;
	}
	public JComboBox getDayComboBox()
	{
		return comboBox_1;
	}
	public JComboBox getHourComboBox()
	{
		return comboBox_2;
	}
	public String getFilterTextField()
	{
		return filterTextField.getText();
	}
	public JButton getFilterButton()
	{
		return this.filterButton;
	}
	public JButton getCheckButton()
	{
		return this.checkButton;
	}
	public JButton getMakeAppointmentButton()
	{
		return this.makeAppointmentButton;
	}
	public JButton getStatisticsButton()
	{
		return this.statisticsButton;
	}
	public JButton getSaveReportsButton()
	{
		return this.saveReportsButton;
	}
	public String getDoctorAppointment()
	{
		return docTextField.getText();
	}
	public String getAppointmentInfo()
	{
		return infoTextField.getText();
	}
	public String getAnimalIdAppointment()
	{
		return idTextField.getText();
	}
	public  void showMessage(String message)
	{
		JOptionPane.showMessageDialog(null,message);
	}
	
	public void pieChart(String[] keys, Integer[] values,String criteriu)
	{
		DefaultPieDataset piedataset= new DefaultPieDataset();
		final PieSectionLabelGenerator labelGenerator = new StandardPieSectionLabelGenerator("{0} = {2}");

		for (int i=0;i<keys.length;i++)
		{
			piedataset.setValue(keys[i], values[i]);
			
		}
		JFreeChart chart=ChartFactory.createPieChart(
				"Statistici"+" dupa " +criteriu ,
				piedataset,
				true,
				true,
				false);
		
		PiePlot P=(PiePlot)chart.getPlot();
		P.setLabelGenerator(labelGenerator);
		ChartFrame fr=new ChartFrame("Statistici",chart);
		fr.setVisible(true);
		fr.setSize(450,500);
		
		
		
		try {
			ChartUtilities.saveChartAsJPEG(new File("D:\\diverse\\an3\\PS\\tema1\\T1\\pieEmp.jpeg"),chart,500,300);
			
		}catch(Exception e)
		{
			System.out.println("eroare"+e);
		}
				
		
	}
}

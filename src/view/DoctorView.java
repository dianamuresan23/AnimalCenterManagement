package view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;

import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.ArrayList;

import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JTextField;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartFrame;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.labels.PieSectionLabelGenerator;
import org.jfree.chart.labels.StandardPieSectionLabelGenerator;
import org.jfree.chart.plot.PiePlot;
import org.jfree.data.general.DefaultPieDataset;

import javax.swing.JTable;

public class DoctorView {

	private JFrame frame;
	private JTextField filterTextField;
	private JButton filterButton ;
	private JComboBox filterComboBox;
	private JComboBox statisticsComboBox;
	private JTable table;
	private JTextField symptomsTextField;
	private JTextField diagnosisTextField;
	private JTextField treatmentTextField;
	private JButton viewAllButton;
	private JButton updateButton;
	private JButton viewStatisticsButton;
	private JScrollPane scrollPane;
	private JTextField mondayStartTextField;
	private JTextField tuesdayStartTextField;
	private JTextField wednesdayStartTextField;
	private JTextField thursdayStartTextField;
	private JTextField fridayStartTextField;
	private JButton changeScheduleLabel ;
	private JLabel lblNewLabel_11;
	private JTextField mondayEndTextField;
	private JLabel lblNewLabel_12;
	private JTextField tuesdayEndTextField;
	private JLabel lblNewLabel_13;
	private JTextField wednesdayEndTextField;
	private JLabel lblNewLabel_14;
	private JTextField thursdayEndTextField;
	private JLabel lblNewLabel_15;
	private JTextField fridayEndTextField;
	private JButton viewAppointmentsButton;


	
	public DoctorView() {
		initialize();
		frame.setVisible(true);
	}

	private void initialize() {
		frame = new JFrame("Doctor");
		frame.setBounds(100, 100, 450, 300);
		//frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel statisticsLabel = new JLabel("Statistics");
		statisticsLabel.setFont(new Font("Tahoma", Font.BOLD, 20));
		statisticsLabel.setBounds(776, 523, 178, 25);
		statisticsLabel.setForeground(Color.BLACK);
		frame.getContentPane().add(statisticsLabel);
		
		statisticsComboBox = new JComboBox();
		statisticsComboBox.setModel(new DefaultComboBoxModel(new String[] {"Simptome", "Diagnostic"}));
		statisticsComboBox.setBounds(773, 571, 116, 21);
		frame.getContentPane().add(statisticsComboBox);
		
		viewStatisticsButton = new JButton("View Statistics");
		viewStatisticsButton.setBounds(773, 621, 116, 21);
		
		frame.getContentPane().add(viewStatisticsButton);
		
		JLabel filterLabel = new JLabel("Filter");
		filterLabel.setFont(new Font("Tahoma", Font.BOLD, 20));
		filterLabel.setBounds(44, 523, 115, 25);
		filterLabel.setForeground(Color.BLACK);
		frame.getContentPane().add(filterLabel);
		
		filterComboBox = new JComboBox();
		filterComboBox.setModel(new DefaultComboBoxModel(new String[] {"Diagnostic", "Tratament"}));
		filterComboBox.setBounds(44, 571, 116, 21);
		frame.getContentPane().add(filterComboBox);
		
		filterTextField = new JTextField();
		filterTextField.setBounds(44, 622, 116, 19);
		frame.getContentPane().add(filterTextField);
		filterTextField.setColumns(10);
		
		filterButton = new JButton("FIlter");
		filterButton.setBounds(44, 678, 115, 21);
		filterButton.setBackground(new Color(244, 164, 96));
		frame.getContentPane().add(filterButton);
		
		viewAllButton = new JButton("View All");
		viewAllButton.setBounds(44, 150, 85, 21);
		viewAllButton.setBackground(new Color(244, 164, 96));
		frame.getContentPane().add(viewAllButton);
		
		JLabel symptomsLabel = new JLabel("Simptome");
		symptomsLabel.setForeground(Color.WHITE);
		symptomsLabel.setFont(new Font("Cambria", Font.BOLD, 16));
		symptomsLabel.setBounds(44, 222, 85, 21);
		frame.getContentPane().add(symptomsLabel);
		
		JLabel diagnosisLabel = new JLabel("Diagnostic");
		diagnosisLabel.setForeground(Color.WHITE);
		diagnosisLabel.setFont(new Font("Cambria", Font.BOLD, 16));
		diagnosisLabel.setBounds(44, 295, 85, 31);
		frame.getContentPane().add(diagnosisLabel);
		
		symptomsTextField = new JTextField();
		symptomsTextField.setBounds(153, 224, 153, 21);
		frame.getContentPane().add(symptomsTextField);
		symptomsTextField.setColumns(10);
		
		JLabel treatmentLabel = new JLabel("Tratament");
		treatmentLabel.setForeground(Color.WHITE);
		treatmentLabel.setFont(new Font("Cambria", Font.BOLD, 16));
		treatmentLabel.setBounds(44, 370, 85, 13);
		frame.getContentPane().add(treatmentLabel);
		
		diagnosisTextField = new JTextField();
		diagnosisTextField.setBounds(153, 303, 153, 19);
		frame.getContentPane().add(diagnosisTextField);
		diagnosisTextField.setColumns(10);
		
		treatmentTextField = new JTextField();
		treatmentTextField.setBounds(153, 369, 153, 19);
		frame.getContentPane().add(treatmentTextField);
		treatmentTextField.setColumns(10);
		
	    updateButton = new JButton("Update");
		updateButton.setBounds(44, 433, 85, 21);
		updateButton.setBackground(new Color(244, 164, 96));
		frame.getContentPane().add(updateButton);
		frame.setSize(new Dimension(1920,840));
		frame.setLocationRelativeTo(null);
		
		scrollPane =new JScrollPane(); 
        frame.getContentPane().add(scrollPane);
        
        JLabel scheduleLabel = new JLabel("Work Schedule");
        scheduleLabel.setFont(new Font("Tahoma", Font.BOLD, 20));
        scheduleLabel.setForeground(Color.BLACK);
        scheduleLabel.setBounds(394, 520, 178, 31);
        frame.getContentPane().add(scheduleLabel);
        
        JLabel mondayLabel = new JLabel("Luni");
        mondayLabel.setFont(new Font("Cambria", Font.BOLD, 16));
        mondayLabel.setForeground(Color.WHITE);
        mondayLabel.setBounds(395, 573, 46, 13);
        frame.getContentPane().add(mondayLabel);
        
        JLabel tuesdayLabel = new JLabel("Marti");
        tuesdayLabel.setFont(new Font("Cambria", Font.BOLD, 16));
        tuesdayLabel.setForeground(Color.WHITE);
        tuesdayLabel.setBounds(395, 609, 46, 21);
        frame.getContentPane().add(tuesdayLabel);
        
        JLabel wednesdayLabel = new JLabel("Miercuri");
        wednesdayLabel.setFont(new Font("Cambria", Font.BOLD, 16));
        wednesdayLabel.setForeground(Color.WHITE);
        wednesdayLabel.setBounds(394, 640, 78, 22);
        frame.getContentPane().add(wednesdayLabel);
        
        JLabel thursdayLabel = new JLabel("Joi");
        thursdayLabel.setFont(new Font("Cambria", Font.BOLD, 16));
        thursdayLabel.setForeground(Color.WHITE);
        thursdayLabel.setBounds(395, 672, 46, 28);
        frame.getContentPane().add(thursdayLabel);
        
        JLabel fridayLabel = new JLabel("Vineri");
        fridayLabel.setFont(new Font("Cambria", Font.BOLD, 16));
        fridayLabel.setForeground(Color.WHITE);
        fridayLabel.setBounds(395, 718, 46, 13);
        frame.getContentPane().add(fridayLabel);
        
        mondayStartTextField = new JTextField();
        mondayStartTextField.setBounds(489, 572, 23, 19);
        frame.getContentPane().add(mondayStartTextField);
        mondayStartTextField.setColumns(10);
        
        tuesdayStartTextField = new JTextField();
        tuesdayStartTextField.setBounds(489, 604, 23, 19);
        frame.getContentPane().add(tuesdayStartTextField);
        tuesdayStartTextField.setColumns(10);
        
        wednesdayStartTextField = new JTextField();
        wednesdayStartTextField.setBounds(489, 638, 23, 19);
        frame.getContentPane().add(wednesdayStartTextField);
        wednesdayStartTextField.setColumns(10);
        
        thursdayStartTextField = new JTextField();
        thursdayStartTextField.setBounds(489, 679, 23, 19);
        frame.getContentPane().add(thursdayStartTextField);
        thursdayStartTextField.setColumns(10);
        
        fridayStartTextField = new JTextField();
        fridayStartTextField.setBounds(489, 717, 23, 19);
        frame.getContentPane().add(fridayStartTextField);
        fridayStartTextField.setColumns(10);
        
        changeScheduleLabel = new JButton("Change");
        changeScheduleLabel.setBounds(397, 759, 85, 21);
        
		changeScheduleLabel.setBackground(new Color(244, 164, 96));
        frame.getContentPane().add(changeScheduleLabel);
        
        
		
		
		lblNewLabel_11 = new JLabel("-");
		lblNewLabel_11.setBounds(532, 575, 9, 13);
		frame.getContentPane().add(lblNewLabel_11);
		
		mondayEndTextField = new JTextField();
		mondayEndTextField.setBounds(555, 572, 23, 19);
		frame.getContentPane().add(mondayEndTextField);
		mondayEndTextField.setColumns(10);
		
		lblNewLabel_12 = new JLabel("-");
		lblNewLabel_12.setBounds(532, 607, 9, 13);
		frame.getContentPane().add(lblNewLabel_12);
		
		tuesdayEndTextField = new JTextField();
		tuesdayEndTextField.setBounds(555, 604, 23, 19);
		frame.getContentPane().add(tuesdayEndTextField);
		tuesdayEndTextField.setColumns(10);
		
		lblNewLabel_13 = new JLabel("-");
		lblNewLabel_13.setBounds(532, 646, 9, 13);
		frame.getContentPane().add(lblNewLabel_13);
		
		wednesdayEndTextField = new JTextField();
		wednesdayEndTextField.setBounds(555, 638, 23, 19);
		frame.getContentPane().add(wednesdayEndTextField);
		wednesdayEndTextField.setColumns(10);
		
		lblNewLabel_14 = new JLabel("-");
		lblNewLabel_14.setBounds(532, 682, 9, 13);
		frame.getContentPane().add(lblNewLabel_14);
		
		thursdayEndTextField = new JTextField();
		thursdayEndTextField.setBounds(555, 678, 23, 19);
		frame.getContentPane().add(thursdayEndTextField);
		thursdayEndTextField.setColumns(10);
		
		lblNewLabel_15 = new JLabel("-");
		lblNewLabel_15.setBounds(532, 720, 9, 13);
		frame.getContentPane().add(lblNewLabel_15);
		
		fridayEndTextField = new JTextField();
		fridayEndTextField.setBounds(555, 717, 23, 19);
		frame.getContentPane().add(fridayEndTextField);
		fridayEndTextField.setColumns(10);
		
		viewAppointmentsButton = new JButton("View Appointments");
		viewAppointmentsButton.setBackground(new Color(244, 164, 96));
		viewAppointmentsButton.setBounds(151, 150, 155, 21);
		viewStatisticsButton.setBackground(new Color(244, 164, 96));
		frame.getContentPane().add(viewAppointmentsButton);
		
		JLabel lblNewLabel_12 = new JLabel("New label");
		ImageIcon imageIcon = new ImageIcon("p3.png"); // load the image to a imageIcon
		Image image = imageIcon.getImage(); // transform it 
		Image newimg = image.getScaledInstance(1550, 850,  java.awt.Image.SCALE_SMOOTH); // scale it the smooth way  
		imageIcon = new ImageIcon(newimg);
		lblNewLabel_12.setIcon(imageIcon);
		lblNewLabel_12.setBounds(0, 0, 1634,821);
		frame.getContentPane().add(lblNewLabel_12);
		
		
	}
	public void viewAll(Object[] columns, Object[][] data)
	{
			
		this.table=new JTable(data,columns); 
		table.setFillsViewportHeight(true); 
	    table.setPreferredScrollableViewportSize(new Dimension(300, 80)); 
	   
	    scrollPane.setViewportView(table);
	    scrollPane.setBounds(400,150,800,300);
		
	}
	public String[] getRowData()
	{
		String values[]=new String[table.getColumnCount()];
		int row=table.getSelectedRow();
		for (int column=0;column<table.getColumnCount();column++)
		{
			String s=table.getModel().getValueAt(row,column).toString();
			values[column]=s;
		}
		return values;
		
	}
	public String[] getUpdateData()
	{
		String[] values=new String[5];
		values[0]=symptomsTextField.getText();
		values[1]=diagnosisTextField.getText();
		values[2]=treatmentTextField.getText();
		return values;
		
	}
	public ArrayList<String[]> getWorkScheduleData()
	{
		ArrayList<String[]> schedule=new ArrayList<String[]>();
		schedule.add(new String[]{"Luni",mondayStartTextField.getText(),mondayEndTextField.getText()});
		schedule.add(new String[]{"Marti",tuesdayStartTextField.getText(),tuesdayEndTextField.getText()});
		schedule.add(new String[]{"Miercuri",wednesdayStartTextField.getText(),wednesdayEndTextField.getText()});
		schedule.add(new String[]{"Joi",thursdayStartTextField.getText(),thursdayEndTextField.getText()});
		schedule.add(new String[]{"Vineri",fridayStartTextField.getText(),fridayEndTextField.getText()});
		return schedule;
		
	}
	public void setWorkSchedule(int startHours[],int endHours[])
	{
		String[] start=new String[5];
		String[] end=new String[5];
		for (int i=0;i<startHours.length;i++)
		{
			if (startHours[i]==0)
				start[i]="";
			else start[i]=String.valueOf(startHours[i]);
			if (endHours[i]==0)
				end[i]="";
			else end[i]=String.valueOf(endHours[i]);	
		}
		mondayStartTextField.setText(start[0]);
		tuesdayStartTextField.setText(start[1]);
		wednesdayStartTextField.setText(start[2]);
		thursdayStartTextField.setText(start[3]);
		fridayStartTextField.setText(start[4]);
		
		mondayEndTextField.setText(end[0]);
		tuesdayEndTextField.setText(end[1]);
		wednesdayEndTextField.setText(end[2]);
		thursdayEndTextField.setText(end[3]);
		fridayEndTextField.setText(end[4]);
		
	}
	public void addFilterListener(ActionListener listen)
	{
		this.filterButton.addActionListener(listen);
		this.filterComboBox.addActionListener(listen);
	}
	public void addViewAllListener(ActionListener listen)
	{
		this.viewAllButton.addActionListener(listen);
	}
	public void addUpdateListener(ActionListener listen)
	{
		this.updateButton.addActionListener(listen);
	}
	public void addStatisticsListener(ActionListener listen)
	{
		this.viewStatisticsButton.addActionListener(listen);
	}
	public void addWorkScheduleListener(ActionListener listen)
	{
		this.changeScheduleLabel.addActionListener(listen);
	}
	public void addViewAppointmentsListener(ActionListener listen)
	{
		this.viewAppointmentsButton.addActionListener(listen);
	}
	public JComboBox getFilterComboBox()
	{
		return filterComboBox;
	}
	public JComboBox getStatisticsComboBox()
	{
		return statisticsComboBox;
	}
	public JButton getFilterButton()
	{
		return this.filterButton;
	}
	public JButton getStatisticsButton()
	{
		return this.viewStatisticsButton;
	}
	public String getFilterTexField()
	{
		return filterTextField.getText();
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
			ChartUtilities.saveChartAsJPEG(new File("D:\\diverse\\an3\\PS\\tema1\\T1\\pieDoc.jpeg"),chart,500,300);
			
		}catch(Exception e)
		{
			System.out.println("eroare"+e);
		}
				
		
	}
}

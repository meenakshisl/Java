import java.awt.EventQueue;
import java.sql.*;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import aoc.dao.AcadamicDAO;
import aoc.dto.AcademicDTO;

import java.awt.Color;

import javax.swing.JButton;
import javax.swing.JSeparator;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JRadioButton;
import javax.swing.JComboBox;
import javax.swing.JPasswordField;



public class Register extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField namet;
	private JTextField rollf;
	private JTextField emailf;
	private JTextField phonef;
	private JTextField proff;

	private JPasswordField passwordField;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			Connection myConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/project","admin","admin");
			Statement myStmt = myConn.createStatement();
			myStmt.executeQuery("use project;");
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Register frame = new Register();
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
	public Register() {
		setTitle("Register");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 805, 504);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
	/*	for(int i = 1990;i<2050;i++)
		{
			years[1990-i] = i;
		}
		*/
		
		

		
		JButton btnCancel = new JButton("Cancel");
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
			}
		});
		btnCancel.setBounds(652, 422, 114, 25);
		contentPane.add(btnCancel);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(397, 12, 0, 402);
		contentPane.add(separator);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(35, 54, 741, 14);
		contentPane.add(separator_1);
		
		JLabel lblAlumniRegistrationForm = new JLabel("Alumni Registration Form");
		lblAlumniRegistrationForm.setFont(new Font("Jamrul", Font.PLAIN, 20));
		lblAlumniRegistrationForm.setBounds(40, 0, 308, 68);
		contentPane.add(lblAlumniRegistrationForm);
		
		JLabel lblNewLabel = new JLabel("Welcome to the registration page for alumni. Please take a moment to fill out the form below. \n" );
		lblNewLabel.setBounds(35, 80, 741, 23);
		contentPane.add(lblNewLabel);
		
		JLabel lblpleaseSupplyAll = new JLabel("Please supply all the requested information and click on SUBMIT, below.");
		lblpleaseSupplyAll.setBounds(35, 104, 649, 15);
		contentPane.add(lblpleaseSupplyAll);
		
		JLabel lblName = new JLabel("Name            :");
		lblName.setFont(new Font("Dialog", Font.PLAIN, 14));
		lblName.setBounds(35, 142, 108, 34);
		contentPane.add(lblName);
		
		JSeparator separator_2 = new JSeparator();
		separator_2.setBounds(183, 344, 0, -200);
		contentPane.add(separator_2);
		
		namet = new JTextField();
		namet.setBounds(151, 145, 234, 31);
		contentPane.add(namet);
		namet.setColumns(10);
		
		JLabel lblRollNo = new JLabel("Roll No          :");
		lblRollNo.setFont(new Font("Dialog", Font.PLAIN, 14));
		lblRollNo.setBounds(35, 186, 108, 34);
		contentPane.add(lblRollNo);
		
		JSeparator separator_3 = new JSeparator();
		separator_3.setBounds(33, 408, 0, -264);
		contentPane.add(separator_3);
		
		rollf = new JTextField();
		rollf.setColumns(10);
		rollf.setBounds(151, 188, 234, 31);
		contentPane.add(rollf);
		
		JLabel lblPhoneNo = new JLabel("Phone No      :");
		lblPhoneNo.setFont(new Font("Dialog", Font.PLAIN, 14));
		lblPhoneNo.setBounds(35, 322, 98, 34);
		contentPane.add(lblPhoneNo);
		
		emailf = new JTextField();
		emailf.setColumns(10);
		emailf.setBounds(151, 279, 234, 31);
		contentPane.add(emailf);
		
		JLabel lblEmailId = new JLabel("E-mail id       :");
		lblEmailId.setFont(new Font("Dialog", Font.PLAIN, 14));
		lblEmailId.setBounds(35, 277, 108, 34);
		contentPane.add(lblEmailId);
		
		JLabel lblDepartment = new JLabel("Gender    :");
		lblDepartment.setFont(new Font("Dialog", Font.PLAIN, 14));
		lblDepartment.setBounds(35, 228, 108, 34);
		contentPane.add(lblDepartment);
		
		phonef = new JTextField();
		phonef.setColumns(10);
		phonef.setBounds(151, 322, 234, 31);
		contentPane.add(phonef);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(255, 255, 153));
		panel_1.setBounds(12, 0, 764, 50);
		contentPane.add(panel_1);
		
		JRadioButton rm = new JRadioButton("Male");
		rm.setBackground(Color.WHITE);
		rm.setBounds(151, 234, 86, 23);
		contentPane.add(rm);
		
		JRadioButton rf = new JRadioButton("Female");
		rf.setBackground(Color.WHITE);
		rf.setBounds(263, 234, 144, 23);
		contentPane.add(rf);
		
		
		
		JLabel lblYearOfJoin = new JLabel("Year of join \t  :");
		lblYearOfJoin.setFont(new Font("Dialog", Font.PLAIN, 14));
		lblYearOfJoin.setBounds(426, 142, 108, 34);
		contentPane.add(lblYearOfJoin);
		
		JLabel lblYearOfPass = new JLabel("Year of pass\t  :");
		lblYearOfPass.setFont(new Font("Dialog", Font.PLAIN, 14));
		lblYearOfPass.setBounds(426, 186, 108, 34);
		contentPane.add(lblYearOfPass);
		
		JComboBox<Integer> comboBox = new JComboBox<Integer>();
		for(int i=1990;i<=2035;i++){
	        comboBox.addItem(i);
	}
		comboBox.setBounds(552, 142, 114, 30);
		contentPane.add(comboBox);
		
		JComboBox<Integer> comboBox_1 = new JComboBox<Integer>();
		for(int i=1990;i<=2040;i++){
	        comboBox_1.addItem(i);
	}
		comboBox_1.setBounds(552, 191, 114, 30);
		contentPane.add(comboBox_1);
		
		JLabel lblProfession = new JLabel("Profession  \t    :");
		lblProfession.setFont(new Font("Dialog", Font.PLAIN, 14));
		lblProfession.setBounds(426, 238, 108, 34);
		contentPane.add(lblProfession);
		
		proff = new JTextField();
		proff.setColumns(10);
		proff.setBounds(552, 236, 197, 50);
		contentPane.add(proff);
		
		
		JLabel lblPassword = new JLabel("Password\t:");
		lblPassword.setFont(new Font("Dialog", Font.PLAIN, 14));
		lblPassword.setBounds(426, 295, 108, 34);
		contentPane.add(lblPassword);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(552, 298, 158, 30);
		contentPane.add(passwordField);
		
		JButton btnNext = new JButton("Submit");
		btnNext.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent arg0) {
				
				try
				{
					String st = null ;
					if(rm.isSelected())
						st = "M";
					if(rf.isSelected())
						st = "F";
					String name = namet.getText();
					String rollno = rollf.getText();
					String email = emailf.getText();
					long no = Long.parseLong(phonef.getText());
					int yoj = (int) comboBox.getSelectedItem();
					int yop = (int)comboBox_1.getSelectedItem();
					String prof = proff.getText();
					char[] pass1 = passwordField.getPassword();
					String pass = new String(pass1);
					
					//System.out.println(name + rollno+email+no+yoj+yop+st);
					AcademicDTO adto = new AcademicDTO(rollno,name,st,email,no,yoj,yop,prof,pass);
					
				
					AcadamicDAO add = new AcadamicDAO();
					//System.out.println("2 "+name + rollno+email+no+yoj+yop+st);
					add.registerAcadamicDetails(adto);
					
					
					
				}
				catch(Exception e)
				{
					e.printStackTrace();
				}
					
				
				dispose();
				Login l = new Login();
				l.setVisible(true);
			}
		});
		btnNext.setBounds(510, 422, 114, 25);
		contentPane.add(btnNext);

	}
}

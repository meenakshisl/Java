import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import java.util.*;
import aoc.utility.*;

import aoc.dao.AcadamicDAO;
import aoc.dto.AcademicDTO;

import java.awt.Color;
import javax.swing.JLabel;
import java.awt.CardLayout;
import java.awt.Font;
import javax.swing.JLayeredPane;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import javax.swing.JTextField;
import java.io.IOException;
import javax.swing.JTextArea;

public class Home extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField;
	private JTable table;
	private AcadamicDAO adao;
	private AcademicDTO adto;
	private JTextField txtMeenu;
	private JTextField rno_text;
	private JTextField gender;
	private JTextField email_text;
	private JTextField phone_t;
	private JTextField prof_t;
	private JTextField pass;
	private JTextField textField_yoj;
	private JTextField textField_yop;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Home frame = new Home("xxx");
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * 
	 * @throws IOException
	 */
	public Home(String usr) throws IOException {
		
		//user = usr;

		try {
			adao = new AcadamicDAO();
		} catch (Exception exc) {
			JOptionPane.showMessageDialog(this, "Error: " + exc, "Error", JOptionPane.ERROR_MESSAGE);
		}
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 853, 505);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 153));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel panel = new JPanel();
		panel.setBackground(new Color(204, 0, 102));
		panel.setBounds(0, 0, 178, 475);
		contentPane.add(panel);
		panel.setLayout(null);

		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(204, 0, 102));
		panel_1.setBounds(177, 0, 676, 52);
		contentPane.add(panel_1);
		panel_1.setLayout(new CardLayout(0, 0));

		JLabel lblAmritaAlumniPortal = new JLabel("AMRITA ALUMNI PORTAL");
		lblAmritaAlumniPortal.setForeground(new Color(255, 255, 255));
		lblAmritaAlumniPortal.setFont(new Font("Kinnari", Font.PLAIN, 26));
		panel_1.add(lblAmritaAlumniPortal, "name_3454479448267");

		JLayeredPane layeredPanel = new JLayeredPane();
		layeredPanel.setBounds(197, 64, 644, 384);
		contentPane.add(layeredPanel);
		layeredPanel.setLayout(new CardLayout(0, 0));

		ImagePanel pic = new ImagePanel("src/Images/people.jpg");
		JPanel about = new JPanel();
		about.add(pic);
		layeredPanel.add(about, "name_19999376033936");
		about.setLayout(null);

		JTextArea txtrWeBelieveThat = new JTextArea();
		txtrWeBelieveThat.setForeground(new Color(0, 0, 102));
		txtrWeBelieveThat.setFont(new Font("Jamrul", Font.BOLD, 14));
		txtrWeBelieveThat.setText(
				"We believe that the alumni of an institution are its ambassadors. Their character, personality, intellect, achievement, success and recognition add great value to the positioning of the alma mater as a prestigious educational institution producing high quality professionals. The stronger the network of alumni, the greater is the impact.");
		txtrWeBelieveThat.setEditable(false);
		txtrWeBelieveThat.setLineWrap(true);
		txtrWeBelieveThat.setWrapStyleWord(true);
		txtrWeBelieveThat.setOpaque(false);

		txtrWeBelieveThat.setBounds(12, 12, 632, 178);
		about.add(txtrWeBelieveThat);

		JTextArea txtrConnect = new JTextArea();
		txtrConnect.setForeground(new Color(255, 255, 255));
		txtrConnect.setFont(new Font("Kinnari", Font.BOLD, 16));
		txtrConnect.setText(
				"Amritians is an excellent platform to network with your fellow batchmates and interact with great alumni from your institution, School, Programme, Branch, Batch and Section, as well as others... Get Connected!");
		txtrConnect.setBounds(12, 284, 620, 88);
		txtrConnect.setOpaque(false);
		txtrConnect.setEditable(false);
		txtrConnect.setLineWrap(true);
		txtrConnect.setWrapStyleWord(true);

		about.add(txtrConnect);

		JLabel lblNewLabel = new JLabel("About");
		lblNewLabel.setBounds(0, 0, 644, 384);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setIcon(new ImageIcon(Login.class.getResource("/Images/campus.jpg")));
		about.add(lblNewLabel);

		JPanel Search = new JPanel();
		Search.setBackground(new Color(255, 255, 255));
		layeredPanel.add(Search, "name_20060551295865");
		Search.setLayout(new BorderLayout(0, 0));

		JPanel panel_2 = new JPanel();
		panel_2.setForeground(new Color(255, 255, 255));
		panel_2.setBackground(new Color(51, 0, 153));
		FlowLayout flowLayout = (FlowLayout) panel_2.getLayout();
		flowLayout.setAlignment(FlowLayout.LEFT);
		Search.add(panel_2, BorderLayout.NORTH);

		JLabel lblName = new JLabel("Enter the name     :");
		lblName.setForeground(new Color(255, 255, 255));
		panel_2.add(lblName);

		textField = new JTextField();
		panel_2.add(textField);
		textField.setColumns(10);


		JScrollPane scrollPane = new JScrollPane();
		Search.add(scrollPane, BorderLayout.CENTER);

		table = new JTable();
		scrollPane.setViewportView(table);

		JButton btnSearch_1 = new JButton("Search");
		btnSearch_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				try

				{
					String name = textField.getText();
					// int yoj = comboBox
					// String
					List<AcademicDTO> alum_l = null;

					if (name != null && name.trim().length() != 0) {
						alum_l = adao.searchAlumni(name);
					} else {
						alum_l = adao.getAllAlumni();
					}
					for (AcademicDTO temp : alum_l) {
						System.out.println(temp);
					}

					AcademicTableModel model = new AcademicTableModel(alum_l);

					table.setModel(model);

				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		
		JLabel label_1 = new JLabel("                                                            ");
		panel_2.add(label_1);
		panel_2.add(btnSearch_1);

		JPanel Events = new JPanel();
		layeredPanel.add(Events, "name_20127558317424");
		Events.setLayout(null);

		JLabel lblEvents_1 = new JLabel("Events");
		lblEvents_1.setBounds(229, 163, 66, 15);
		Events.add(lblEvents_1);

		JPanel Profile = new JPanel();
		Profile.setBackground(new Color(255, 255, 255));
		layeredPanel.add(Profile, "name_20210266485587");
		Profile.setLayout(null);
		
		adto = adao.getAcademicDetails(usr);

		JLabel lblName_1 = new JLabel("Name :");
		lblName_1.setFont(new Font("FreeMono", Font.BOLD, 17));
		lblName_1.setBounds(37, 56, 112, 35);
		Profile.add(lblName_1);

		txtMeenu = new JTextField();
		txtMeenu.setText(adto.getLoginname());
		txtMeenu.setBounds(143, 64, 195, 27);
		Profile.add(txtMeenu);
		txtMeenu.setColumns(10);

		JLabel lblRollNo = new JLabel("Roll No  :");
		lblRollNo.setFont(new Font("FreeMono", Font.BOLD, 17));
		lblRollNo.setBounds(37, 111, 112, 35);
		Profile.add(lblRollNo);

		rno_text = new JTextField();
		rno_text.setText(adto.getRollno());
		rno_text.setColumns(10);
		rno_text.setBounds(143, 119, 195, 27);
		Profile.add(rno_text);

		JLabel lblGender = new JLabel("Gender  :");
		lblGender.setFont(new Font("FreeMono", Font.BOLD, 17));
		lblGender.setBounds(37, 163, 112, 35);
		Profile.add(lblGender);

		gender = new JTextField();
		gender.setText(adto.getGender());
		System.out.println(adto.getGender());
		
		gender.setColumns(10);
		gender.setBounds(143, 167, 195, 27);
		Profile.add(gender);

		JLabel lblEmail = new JLabel("Email :");
		lblEmail.setFont(new Font("FreeMono", Font.BOLD, 17));
		lblEmail.setBounds(37, 210, 112, 35);
		Profile.add(lblEmail);

		email_text = new JTextField();
		email_text.setText(adto.getEmail());
		email_text.setColumns(10);
		email_text.setBounds(143, 210, 195, 27);
		Profile.add(email_text);

		JLabel lblPhoneNo = new JLabel("Phone No:");
		lblPhoneNo.setFont(new Font("FreeMono", Font.BOLD, 17));
		lblPhoneNo.setBounds(37, 249, 112, 35);
		Profile.add(lblPhoneNo);

		JLabel lblProfession = new JLabel("Profession:");
		lblProfession.setFont(new Font("FreeMono", Font.BOLD, 16));
		lblProfession.setBounds(37, 303, 127, 35);
		Profile.add(lblProfession);

		phone_t = new JTextField();
		phone_t.setText(Long.toString(adto.getPhone()));
		phone_t.setColumns(10);
		phone_t.setBounds(143, 249, 195, 27);
		Profile.add(phone_t);

		prof_t = new JTextField();
		prof_t.setText(adto.getProfession());
		prof_t.setColumns(10);
		prof_t.setBounds(151, 303, 187, 27);
		Profile.add(prof_t);
		
		
		JLabel lblYearOfJoining = new JLabel("Year of joining :");
		lblYearOfJoining.setFont(new Font("FreeMono", Font.BOLD, 15));
		lblYearOfJoining.setBounds(414, 56, 154, 25);
		Profile.add(lblYearOfJoining);


		JLabel lblYearOfPass = new JLabel("Year of Pass :");
		lblYearOfPass.setFont(new Font("FreeMono", Font.BOLD, 15));
		lblYearOfPass.setBounds(414, 128, 154, 25);
		Profile.add(lblYearOfPass);
		
		textField_yoj = new JTextField();
		textField_yoj.setText(Integer.toString(adto.getYearofjoin()));
		textField_yoj.setBounds(414, 89, 124, 27);
		Profile.add(textField_yoj);
		textField_yoj.setColumns(10);
		
		textField_yop = new JTextField();
		textField_yop.setText(Integer.toString(adto.getYearofpass()));
		textField_yop.setColumns(10);
		textField_yop.setBounds(414, 163, 124, 27);
		Profile.add(textField_yop);
		
		JLabel label = new JLabel("Password :");
		label.setFont(new Font("FreeMono", Font.BOLD, 15));
		label.setBounds(414, 210, 154, 25);
		Profile.add(label);

		pass = new JTextField();
		pass.setText(adto.getPass());
		pass.setBounds(414, 239, 154, 27);
		Profile.add(pass);
		pass.setColumns(10);

		
		JButton btnNewButton = new JButton("Update :");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int yearoj = Integer.parseInt(textField_yoj.getText());
				int yearop = Integer.parseInt(textField_yop.getText());
				AcademicDTO upd = new AcademicDTO(rno_text.getText(),txtMeenu.getText(),gender.getText(),email_text.getText(),Long.parseLong(phone_t.getText()),yearoj,yearop,prof_t.getText(),pass.getText());
				System.out.println(upd.getEmail());
				AcadamicDAO ad = new AcadamicDAO();
				ad.updateAcadamicDetails(upd);
			}
		});
		btnNewButton.setToolTipText("j ");
		btnNewButton.setBounds(443, 286, 114, 25);
		Profile.add(btnNewButton);
		

		

		


		JLabel lblProfile = new JLabel("Profile");
		lblProfile.setBounds(12, 12, 620, 360);
		lblProfile.setIcon(new ImageIcon(Login.class.getResource("/Images/people.jpg")));
		Profile.add(lblProfile);
		


		

		


		JButton btnAboutUs = new JButton("About Us");
		btnAboutUs.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				layeredPanel.removeAll();
				layeredPanel.add(about);
				layeredPanel.repaint();
				layeredPanel.revalidate();

			}
		});
		btnAboutUs.setBackground(new Color(255, 255, 153));
		btnAboutUs.setFont(new Font("Latin Modern Math", Font.PLAIN, 17));
		btnAboutUs.setBounds(0, 145, 178, 34);
		panel.add(btnAboutUs);

		JButton btnSearch = new JButton("Search");
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				layeredPanel.removeAll();
				layeredPanel.add(Search);
				layeredPanel.repaint();
				layeredPanel.revalidate();
			}

		});
		btnSearch.setFont(new Font("Latin Modern Math", Font.PLAIN, 17));
		btnSearch.setBackground(new Color(255, 255, 153));
		btnSearch.setBounds(0, 205, 178, 34);
		panel.add(btnSearch);

		JButton btnLogin = new JButton("Login");
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
				Login l = new Login();
				l.setVisible(true);

			}
		});
		btnLogin.setFont(new Font("Latin Modern Math", Font.PLAIN, 17));
		btnLogin.setBackground(new Color(255, 255, 153));
		btnLogin.setBounds(0, 332, 178, 34);
		panel.add(btnLogin);

		
		JButton btnViewProfile = new JButton("View Profile");
		btnViewProfile.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				layeredPanel.removeAll();
				layeredPanel.add(Profile);
				layeredPanel.repaint();
				layeredPanel.revalidate();
			}
		});
		btnViewProfile.setFont(new Font("Latin Modern Math", Font.PLAIN, 17));
		btnViewProfile.setBackground(new Color(255, 255, 153));
		btnViewProfile.setBounds(0, 270, 178, 34);
		panel.add(btnViewProfile);

		// ImageIcon icon = new ImageIcon(ImageTest.class.getResource("icloud.jpg"));
	}
}

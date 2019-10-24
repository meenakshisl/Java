import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import aoc.dao.AcadamicDAO;

import java.awt.Color;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.awt.event.ActionEvent;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JSeparator;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.ImageIcon;

public class Login extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField user;
	private JTextField pass;
	private final JPanel panel_1 = new JPanel();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login frame = new Login();
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
	public Login() {
		setTitle("Login");
		setBackground(Color.WHITE);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 810, 502);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNewButton = new JButton("Register");
		btnNewButton.setForeground(new Color(255, 255, 255));
		btnNewButton.setFont(new Font("Noto Sans CJK JP Regular", Font.BOLD, 13));
		btnNewButton.setBackground(new Color(220, 20, 60));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Register r  = new Register();
				r.setVisible(true);
			}
		});
		btnNewButton.setBounds(539, 332, 170, 33);
		contentPane.add(btnNewButton);
		
		user = new JTextField();
		user.setBounds(484, 97, 281, 33);
		contentPane.add(user);
		user.setColumns(10);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(457, 59, 15, 334);
		contentPane.add(separator);
		
		JLabel label = new JLabel("Username");
		label.setFont(new Font("Jamrul", Font.PLAIN, 14));
		label.setBounds(484, 59, 88, 26);
		contentPane.add(label);
		
		JLabel label_1 = new JLabel("Password");
		label_1.setFont(new Font("Jamrul", Font.PLAIN, 14));
		label_1.setBounds(484, 142, 88, 26);
		contentPane.add(label_1);
		
		pass = new JPasswordField();
		pass.setColumns(10);
		pass.setBounds(484, 176, 281, 33);
		contentPane.add(pass);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 255, 153));
		panel.setBounds(12, 434, 798, 26);
		contentPane.add(panel);
		
		JLabel lblaumAmriteshyaryaiNamah = new JLabel("\"AUM AMRITESHYARYAI NAMAH\"");
		lblaumAmriteshyaryaiNamah.setBackground(new Color(255, 204, 51));
		lblaumAmriteshyaryaiNamah.setFont(new Font("DejaVu Math TeX Gyre", Font.BOLD, 14));
		panel.add(lblaumAmriteshyaryaiNamah);
		panel_1.setBackground(new Color(255, 255, 153));
		panel_1.setBounds(12, 0, 798, 33);
		contentPane.add(panel_1);
		
		JLabel lblNobodyIsBothered = new JLabel("\"Nobody is bothered about an institution more than its alumni\"");
		lblNobodyIsBothered.setFont(new Font("Mukti Narrow", Font.BOLD | Font.ITALIC, 14));
		panel_1.add(lblNobodyIsBothered);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setBounds(12, 45, 400, 400);
		contentPane.add(lblNewLabel_1);
		lblNewLabel_1.setBackground(new Color(199, 21, 133));
		lblNewLabel_1.setIcon(new ImageIcon(Login.class.getResource("/Images/amriatlogo.jpg")));
		
		JButton btnOk = new JButton("OK");
		btnOk.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				AcadamicDAO ad = new AcadamicDAO();
				String us = user.getText();
				String pwd = pass.getText();
				if(ad.checkAcadamicDetails(us.trim(),pwd.trim() ))
				{
					
					dispose();
					Home h = null;
					try {
						h = new Home(us);
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					h.setVisible(true);
				}

			}
		});
		btnOk.setForeground(Color.WHITE);
		btnOk.setFont(new Font("Noto Sans CJK JP Regular", Font.BOLD, 13));
		btnOk.setBackground(new Color(220, 20, 60));
		btnOk.setBounds(539, 270, 170, 33);
		contentPane.add(btnOk);
	}
}

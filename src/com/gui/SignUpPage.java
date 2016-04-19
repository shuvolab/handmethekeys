package com.gui;
/**
 * 
 * This class creates the JFrame window for the Sign Up page of Hand Me the Keys and this is also our home page 
 * for our application.
 */
import java.awt.EventQueue;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JTextField;
import java.awt.GridLayout;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JButton;

public class SignUpPage {

	JFrame frame;
	private JTextField UsernameTextField;
	private JTextField PasswordTextField;
	private JTextField ConfirmPasswordTextField;
	private JLabel ConfPassErrorMessage;

	/**
	 * Launch the builder application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SignUpPage window = new SignUpPage();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the SignUpPage frame.
	 */
	public SignUpPage() {
		initializeFrame();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initializeFrame() { 
		frame = new JFrame();
		frame.setBounds(100, 100, 998, 594);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JPanel CompleteSignUpPanel = new JPanel();
		CompleteSignUpPanel.setForeground(Color.BLACK);
		CompleteSignUpPanel.setBounds(313, 154, 331, 247);
		frame.getContentPane().add(CompleteSignUpPanel);
		CompleteSignUpPanel.setLayout(new BorderLayout(10, 25));
		
		JPanel PleaseSignUpPanel = new JPanel();
		CompleteSignUpPanel.add(PleaseSignUpPanel, BorderLayout.NORTH);
		CompleteSignUpPanel.setBorder(BorderFactory.createEmptyBorder());
		
		JLabel lblPleaseSignUp = new JLabel("PLEASE SIGN UP");
		PleaseSignUpPanel.add(lblPleaseSignUp);
		PleaseSignUpPanel.setBorder(BorderFactory.createEmptyBorder());
		
		JPanel userPassConfPanel = new JPanel();
		CompleteSignUpPanel.add(userPassConfPanel, BorderLayout.CENTER);
		userPassConfPanel.setLayout(new GridLayout(3, 0, 10, 10));
		userPassConfPanel.setBorder(BorderFactory.createEmptyBorder());
		
		JPanel UsernamePanel = new JPanel();
		userPassConfPanel.add(UsernamePanel);
		UsernamePanel.setLayout(new BorderLayout(0, 0));
		UsernamePanel.setBorder(BorderFactory.createEmptyBorder());
		
		JLabel lblUsername = new JLabel("Username");
		UsernamePanel.add(lblUsername, BorderLayout.NORTH);
		
		UsernameTextField = new JTextField();
		UsernameTextField.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
			}
		    });
		UsernamePanel.add(UsernameTextField, BorderLayout.CENTER);
		UsernameTextField.setColumns(10);
		
		JPanel PasswordPanel = new JPanel();
		userPassConfPanel.add(PasswordPanel);
		PasswordPanel.setLayout(new BorderLayout(0, 0));
		PasswordPanel.setBorder(BorderFactory.createEmptyBorder());
		
		JLabel lblPassword = new JLabel("Password");
		PasswordPanel.add(lblPassword, BorderLayout.NORTH);
		
		PasswordTextField = new JTextField();
		PasswordTextField.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
			}
		    });
		PasswordPanel.add(PasswordTextField, BorderLayout.CENTER);
		PasswordTextField.setColumns(10);
		
		
		JPanel ConfirmPassPanel = new JPanel();
		userPassConfPanel.add(ConfirmPassPanel);
		ConfirmPassPanel.setLayout(new BorderLayout(0, 0));
		ConfirmPassPanel.setBorder(BorderFactory.createEmptyBorder());
		
		JLabel lblConfirmPassword = new JLabel("Confirm Password");
		ConfirmPassPanel.add(lblConfirmPassword, BorderLayout.NORTH);
		
		ConfirmPasswordTextField = new JTextField("");
		ConfirmPasswordTextField.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) 
			{
				if(ConfirmPasswordTextField.getText().equals(PasswordTextField.getText()))
				{
					JOptionPane.showMessageDialog(null, "Please make sure the two passwords match!");
				}
				
			}
		    });
		ConfirmPassPanel.add(ConfirmPasswordTextField, BorderLayout.CENTER);
		ConfirmPasswordTextField.setColumns(10);
		
		JPanel HMTKLoginPanel = new JPanel();
		HMTKLoginPanel.setBounds(6, 6, 986, 24);
		frame.getContentPane().add(HMTKLoginPanel);
		HMTKLoginPanel.setLayout(new BorderLayout(0, 0));
		HMTKLoginPanel.setBorder(BorderFactory.createEmptyBorder());
		
		JPanel HandMeTheKeysPanel = new JPanel();
		HMTKLoginPanel.add(HandMeTheKeysPanel, BorderLayout.WEST);
		HandMeTheKeysPanel.setBorder(BorderFactory.createEmptyBorder());
		
		JLabel SoftwareTitlelabel = new JLabel("HAND ME THE KEYS");
		SoftwareTitlelabel.setFont(new Font("Skia", Font.PLAIN, 20));
		HandMeTheKeysPanel.add(SoftwareTitlelabel);
		
		JPanel LoginPanel = new JPanel();
		HMTKLoginPanel.add(LoginPanel, BorderLayout.EAST);
		LoginPanel.setBorder(BorderFactory.createEmptyBorder());
		
		JLabel textPaneLogin = new JLabel();
		textPaneLogin.addMouseListener(new MouseAdapter() {

	        public void mouseClicked(MouseEvent e) 
	        {
	            System.out.print("You Successfully Logged Out");
	        }

	    });
		LoginPanel.add(textPaneLogin);
		textPaneLogin.setText("LOG IN");
		textPaneLogin.setBackground(SystemColor.window);
		
		JButton SignUpButton = new JButton("Sign Up");
		SignUpButton.setBounds(414, 413, 117, 29);
		frame.getContentPane().add(SignUpButton);
		SignUpButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) 
			{
				if(ConfirmPasswordTextField.getText().equals("") || PasswordTextField.getText().equals("") || UsernameTextField.getText().equals(""))
				{
					JOptionPane.showMessageDialog(null, "Please make sure all fields are filled!");
				}
				
			}
		    });
	
	}
}

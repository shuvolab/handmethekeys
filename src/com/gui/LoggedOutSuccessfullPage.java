package com.gui;

/**
 * This class creates the JFrame window for the Logged out page of Hand Me the Keys
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

public class LoggedOutSuccessfullPage {

	private JFrame frame;
	private JLabel ConfPassErrorMessage;

	/**
	 * Launch the builder application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoggedOutSuccessfullPage window = new LoggedOutSuccessfullPage();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the SignUpPage frame.
	 * @wbp.parser.entryPoint
	 */
	public LoggedOutSuccessfullPage() {
		initializeFrame();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initializeFrame() { 
		frame = new JFrame();
		frame.setBounds(100, 100, 998, 594);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JPanel CompleteSignUpPanel = new JPanel();
		CompleteSignUpPanel.setForeground(Color.BLACK);
		CompleteSignUpPanel.setBounds(313, 154, 331, 247);
		frame.getContentPane().add(CompleteSignUpPanel);
		CompleteSignUpPanel.setLayout(new BorderLayout(10, 25));
		
		JPanel PleaseSignUpPanel = new JPanel();
		CompleteSignUpPanel.add(PleaseSignUpPanel, BorderLayout.NORTH);
		CompleteSignUpPanel.setBorder(BorderFactory.createEmptyBorder());
		PleaseSignUpPanel.setBorder(BorderFactory.createEmptyBorder());
		
		JPanel userPassConfPanel = new JPanel();
		CompleteSignUpPanel.add(userPassConfPanel, BorderLayout.CENTER);
		userPassConfPanel.setLayout(new GridLayout(3, 0, 10, 10));
		userPassConfPanel.setBorder(BorderFactory.createEmptyBorder());
		
		JPanel UsernamePanel = new JPanel();
		userPassConfPanel.add(UsernamePanel);
		UsernamePanel.setLayout(new BorderLayout(0, 0));
		UsernamePanel.setBorder(BorderFactory.createEmptyBorder());
		
		JLabel lblPleaseSignUp = new JLabel("YOU ARE SUCCESFULLY LOGGED OUT!!");
		UsernamePanel.add(lblPleaseSignUp, BorderLayout.CENTER);
		
		
		
		
		
		
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

	     

	    });
		LoginPanel.add(textPaneLogin);
		textPaneLogin.setText("LOG IN");
		textPaneLogin.setBackground(SystemColor.window);
	
	}
	
	/**
	 * sets the frame visible for the class
	 */
	
	public void setvisible(){
		
		frame.setVisible(true);
	}
	
	
}


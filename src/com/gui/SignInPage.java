package com.gui;
import com.database.Connection;
/**
 * @author Aidan Battad
 * This class creates the JFrame window for the Sign IN page of Hand Me the Keys
 */
import com.engine.mediator.*;
import com.engine.mediator.data.User;

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

public class SignInPage {

	private JFrame frame;
	private JTextField UsernameTextField;
	private JTextField PasswordTextField;
	//private JTextField ConfirmPasswordTextField;


	/**
	 * Launch the builder application.
	 */
	public static void start(final Mediator mediator) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SignInPage window = new SignInPage(mediator);
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
	public SignInPage(final Mediator mediator) {
		initializeFrame(mediator);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initializeFrame(final Mediator mediator) { 
		frame = new JFrame();
		frame.setBounds(100, 100, 998, 594);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JPanel CompleteSignInPanel = new JPanel();
		CompleteSignInPanel.setForeground(Color.BLACK);
		CompleteSignInPanel.setBounds(313, 154, 331, 247);
		frame.getContentPane().add(CompleteSignInPanel);
		CompleteSignInPanel.setLayout(new BorderLayout(10, 25));
		
		JPanel PleaseSignUpPanel = new JPanel();
		CompleteSignInPanel.add(PleaseSignUpPanel, BorderLayout.NORTH);
		CompleteSignInPanel.setBorder(BorderFactory.createEmptyBorder());
		
		JLabel lblPleaseSignIn = new JLabel("PLEASE SIGN IN");
		PleaseSignUpPanel.add(lblPleaseSignIn);
		PleaseSignUpPanel.setBorder(BorderFactory.createEmptyBorder());
		
		JPanel userPassConfPanel = new JPanel();
		CompleteSignInPanel.add(userPassConfPanel, BorderLayout.CENTER);
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
		
		JLabel lbl_test_confirmation = new JLabel("");
		lbl_test_confirmation.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lbl_test_confirmation.setForeground(Color.RED);
		lbl_test_confirmation.setBounds(28, 192, 137, 28);
		CompleteSignInPanel.add(lbl_test_confirmation, BorderLayout.SOUTH);
		
		
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
	            //this would normally be a redirect to the SignInPage
	        }

	    });
		LoginPanel.add(textPaneLogin);
		textPaneLogin.setText("LOG IN");
		textPaneLogin.setBackground(SystemColor.window);
		
		JButton SignInButton = new JButton("Sign In");
		SignInButton.setBounds(350, 413, 117, 29);
		frame.getContentPane().add(SignInButton);
		
		JButton SignUpButton = new JButton("Sign Up");
		SignUpButton.setBounds(500, 413, 117, 29);
		frame.getContentPane().add(SignUpButton);
		
		
		SignInButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) 
			{
				
				if(PasswordTextField.getText().equals("") || UsernameTextField.getText().equals(""))
				{
					JOptionPane.showMessageDialog(null, "Please make sure all fields are filled!");
				} else{
				int userId = new Connection().
						getUserId(
								UsernameTextField.getText(), PasswordTextField.getText()
								);
				if(userId==-1) 
				{
					lbl_test_confirmation.setText("Login Failed");
				}
				else
				{
					lbl_test_confirmation.setText("Login Successful");
					//every object retrieved from the database
					//should be passed to the mediator 
					//which represents a web session
					//that will be passed across windows
					mediator.setUser(
							new User(
							userId, UsernameTextField.getText(), PasswordTextField.getText()));
					//this is where we would launch the next window?
					frame.setVisible(false);
					UserViewPage.start(mediator);
				}
				}
			}
		    });
		
		SignUpButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) 
			{
				frame.setVisible(false);
				SignUpPage.start(mediator);
			}
		});
		

	}
	
	/**
	 * sets the frame visible for the class
	 */
	 public void setvisible()
	 {
		 frame.setVisible(true);
	 }
}
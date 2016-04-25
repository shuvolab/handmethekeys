package com.gui;
import com.database.Connection;
/**
 * 
 * This class creates the JFrame window for the Sign Up page of Hand Me the Keys and this is also our home page 
 * for our application.
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

public class SignUpPage {

	JFrame frame;
	private JTextField UsernameTextField;
	private JTextField PasswordTextField;
	private JTextField ConfirmPasswordTextField;
	private JLabel ConfPassErrorMessage;

	/**
	 * Launch the builder application.
	 */
	public static void start(final Mediator mediator) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SignUpPage window = new SignUpPage(mediator);
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
	public SignUpPage(final Mediator mediator) {
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
				if(!ConfirmPasswordTextField.getText().equals(PasswordTextField.getText()))
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
	            frame.setVisible(false);
	            SignInPage.start(mediator);
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
				} else {
					int userId = new Connection().
							getUserId(
									UsernameTextField.getText(), PasswordTextField.getText()
									);
					if(userId==-1) 
					{
						//addUser, get UserId, set mediator user, start UserViewPage sending new mediator
						Connection connection = new Connection();
						User user=new User();
						user.setUsername(UsernameTextField.getText()); user.setPassword(PasswordTextField.getText());
						connection.addUser(user.getUsername(),user.getPassword());
						user.setID(connection.getUserId(user.getUsername(), user.getPassword()));
						mediator.setUser(user);
						frame.setVisible(false);
						UserViewPage.start(mediator);
					}
					else
					{
						JOptionPane.showMessageDialog(null, "This user already exists! Try another username.");
					}
				}
				
			}
		    });
	
	}
	/**
	 * sets the frame visible for the class
	 */
	
	public void setvisible(){
		
		frame.setVisible(true);
	}
}

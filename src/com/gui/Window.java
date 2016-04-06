package com.gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;

import com.database.Connection;
import com.engine.mediator.Mediator;
import com.engine.mediator.data.User;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.Font;

public class Window extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtLogin;
	private JTextField txtPassword;

	/**
	 * Launch the application.
	 */
	public void start(final Mediator mediator) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Window frame = new Window(mediator);
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
	public Window(final Mediator mediator) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JLabel lblLogin = new JLabel("Login:");
		lblLogin.setBounds(47, 53, 61, 16);
		panel.add(lblLogin);
		
		JLabel lblPassword = new JLabel("Password:");
		lblPassword.setBounds(28, 93, 75, 16);
		panel.add(lblPassword);
		
		txtLogin = new JTextField();
		txtLogin.setBounds(113, 47, 242, 28);
		panel.add(txtLogin);
		txtLogin.setColumns(10);
		
		txtPassword = new JTextField();
		txtPassword.setBounds(113, 87, 242, 28);
		panel.add(txtPassword);
		txtPassword.setColumns(10);
		
		final JLabel lbl_test_confirmation = new JLabel("");
		lbl_test_confirmation.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lbl_test_confirmation.setForeground(Color.RED);
		lbl_test_confirmation.setBounds(28, 192, 137, 28);
		panel.add(lbl_test_confirmation);
		
		JButton btnSubmit = new JButton("Submit");
		btnSubmit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//get userId from the database
				int userId = new Connection().
						getUserId(
								txtLogin.getText(), txtPassword.getText()
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
							userId, txtLogin.getText(), txtPassword.getText()));
				}
				
			}
		});
		btnSubmit.setBounds(238, 140, 117, 29);
		panel.add(btnSubmit);
	}
}

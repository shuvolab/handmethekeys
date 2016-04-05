package com.gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;

import com.engine.mediator.Mediator;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Window extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtLabel;
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
	public Window(Mediator mediator) {
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
		lblLogin.setBounds(47, 97, 61, 16);
		panel.add(lblLogin);
		
		JLabel lblPassword = new JLabel("Password:");
		lblPassword.setBounds(47, 136, 75, 16);
		panel.add(lblPassword);
		
		txtLabel = new JTextField();
		txtLabel.setBounds(135, 91, 215, 28);
		panel.add(txtLabel);
		txtLabel.setColumns(10);
		
		txtPassword = new JTextField();
		txtPassword.setBounds(134, 130, 216, 28);
		panel.add(txtPassword);
		txtPassword.setColumns(10);
		
		JButton btnSubmit = new JButton("Submit");
		btnSubmit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnSubmit.setBounds(233, 180, 117, 29);
		panel.add(btnSubmit);
	}
}

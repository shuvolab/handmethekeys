package com.gui;


import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import com.engine.mediator.Mediator;
import com.engine.mediator.data.User;

public class CarAddSuccessfullPage {

private JFrame frame;


/**
* This is the successful frame for added car into our Database.
*/
public static void start(final Mediator mediator) {
	EventQueue.invokeLater(new Runnable() {
		public void run() {
			try {
				CarAddSuccessfullPage window = new CarAddSuccessfullPage(mediator);
				window.frame.setVisible(true);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	});
}

/**
* Create the application.
*/
public CarAddSuccessfullPage(final Mediator mediator) {
		initialize(mediator);
	}

/**
* Initialize the contents of the frame.
*/
private void initialize(final Mediator mediator) 
{
	frame = new JFrame();
	frame.setBounds(100, 100, 998, 594);
	frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	frame.getContentPane().setLayout(null);
	
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

	JPanel UserAndLogOutPanel = new JPanel();
	HMTKLoginPanel.add(UserAndLogOutPanel, BorderLayout.EAST);
	UserAndLogOutPanel.setLayout(new GridLayout(1, 2, 0, 0));
	UserAndLogOutPanel.setBorder(BorderFactory.createEmptyBorder());
	
	JPanel UserAccountTextPanel = new JPanel();
	UserAccountTextPanel.addMouseListener(new MouseAdapter() {
    public void mouseClicked(MouseEvent e) 
    {
      frame.setVisible(false);
      UserViewPage.start(mediator);
    }
	});
	FlowLayout fl_UserAccountTextPanel = (FlowLayout) UserAccountTextPanel.getLayout();
	fl_UserAccountTextPanel.setVgap(10);
	UserAndLogOutPanel.add(UserAccountTextPanel);
	UserAccountTextPanel.setBorder(BorderFactory.createEmptyBorder());
	
	JLabel UserTextLabel = new JLabel();
	UserAccountTextPanel.add(UserTextLabel);
	UserTextLabel.setText(mediator.getUser().getUsername());
	UserTextLabel.setBackground(SystemColor.window);

	JPanel LogoutTextPanel = new JPanel();
	LogoutTextPanel.addMouseListener(new MouseAdapter() {
    public void mouseClicked(MouseEvent e) 
    {
      frame.setVisible(false);
      mediator.setUser(new User());
      LoggedOutSuccessfullPage.start(mediator);
    }
});
	FlowLayout fl_LogoutTextPanel = (FlowLayout) LogoutTextPanel.getLayout();
	fl_LogoutTextPanel.setVgap(10);
	UserAndLogOutPanel.add(LogoutTextPanel);
	LogoutTextPanel.setBorder(BorderFactory.createEmptyBorder());
	
	JLabel UserLogoutLabel = new JLabel();
	UserLogoutLabel.setText("LOG OUT");
	UserLogoutLabel.setBackground(SystemColor.window);
	LogoutTextPanel.add(UserLogoutLabel);
	
	JPanel panel = new JPanel();
	panel.setBounds(224, 245, 538, 50);
	frame.getContentPane().add(panel);
	
	JLabel lblSdsdsadsad = new JLabel("You car is successfully added in our data base !!! ");
	lblSdsdsadsad.setFont(new Font("Lucida Grande", Font.PLAIN, 13));
	panel.add(lblSdsdsadsad);

}


public void actionPerformed(ActionEvent e) 
{
// Action performed
}

/**
 * sets the frame visible for the class
 */

public void setvisible(){
	
	frame.setVisible(true);
}
}

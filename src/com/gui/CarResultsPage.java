package com.gui;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.BorderFactory;
import java.awt.FlowLayout;
import javax.swing.SwingConstants;
import javax.swing.JButton;

public class CarResultsPage {

	private JFrame frame;
	private ArrayList<String> CarObjects=new ArrayList<String>(); //will hold matching car objects results. Change Wrapper Class to cars later
	private JPanel CarObjectResultsPanel;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args)
	{
		EventQueue.invokeLater(new Runnable() 
		{
			public void run() 
			{
				try 
				{
					CarResultsPage window = new CarResultsPage();
					window.frame.setVisible(true);
				} 
				catch (Exception e) 
				{
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the Car Results Page.
	 */
	public CarResultsPage()
	{
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() 
	{
		frame = new JFrame();
		frame.setBounds(100, 100, 998, 594);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
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
		FlowLayout fl_UserAccountTextPanel = (FlowLayout) UserAccountTextPanel.getLayout();
		fl_UserAccountTextPanel.setVgap(10);
		UserAndLogOutPanel.add(UserAccountTextPanel);
		UserAccountTextPanel.setBorder(BorderFactory.createEmptyBorder());
		
		JLabel UserTextLabel = new JLabel();
		UserTextLabel.addMouseListener(new MouseAdapter() {

	        public void mouseClicked(MouseEvent e) 
	        {
	            System.out.print("You Successfully Logged Out");
	        }

	    });
		UserAccountTextPanel.add(UserTextLabel);
		UserTextLabel.setText("USER");
		UserTextLabel.setBackground(SystemColor.window);
		
		JPanel LogoutTextPanel = new JPanel();
		FlowLayout fl_LogoutTextPanel = (FlowLayout) LogoutTextPanel.getLayout();
		fl_LogoutTextPanel.setVgap(10);
		UserAndLogOutPanel.add(LogoutTextPanel);
		LogoutTextPanel.setBorder(BorderFactory.createEmptyBorder());
		
		JLabel UserLogoutLabel = new JLabel();
		UserLogoutLabel.setText("LOG OUT");
		UserLogoutLabel.setBackground(SystemColor.window);
		LogoutTextPanel.add(UserLogoutLabel);
		
		JPanel ResultsConfirmationTextPanel = new JPanel();
		ResultsConfirmationTextPanel.setBorder(BorderFactory.createEmptyBorder());
		ResultsConfirmationTextPanel.setBounds(31, 110, 303, 30);
		frame.getContentPane().add(ResultsConfirmationTextPanel);
		
		JLabel FoundCarsLabel = new JLabel("Found " + /*count car objects CarObjects.size() +*/ " car(s) that meet(s) your specification!");
		ResultsConfirmationTextPanel.add(FoundCarsLabel);
		
		CarObjectResultsPanel = new JPanel();
		CarObjectResultsPanel.setForeground(Color.BLACK);
		CarObjectResultsPanel.setBorder(BorderFactory.createEmptyBorder());
		CarObjectResultsPanel.setBounds(6, 152, 386, 367);
		frame.getContentPane().add(CarObjectResultsPanel);
		CarObjectResultsPanel.setLayout(new GridLayout(5, 1, 0, 0));
	}
		
		/*JPanel CarObjectPanel = new JPanel();
		CarObjectResultsPanel.add(CarObjectPanel);
		CarObjectPanel.setLayout(new BorderLayout(0, 10));
		CarObjectPanel.setBorder(BorderFactory.createEmptyBorder());
		
		JPanel RentMePanel = new JPanel();
		CarObjectPanel.add(RentMePanel, BorderLayout.EAST);
		RentMePanel.setBorder(BorderFactory.createEmptyBorder());
		
		JButton RentMeButton = new JButton("RENT ME");
		RentMePanel.add(RentMeButton);
		RentMeButton.addActionListener(new ActionListener()
		{

			@Override
			public void actionPerformed(ActionEvent e) {
				// Rent Car object
				
			}
			
		});
		
		JPanel ModelYearBrandPanel = new JPanel();
		CarObjectPanel.add(ModelYearBrandPanel, BorderLayout.CENTER);
		ModelYearBrandPanel.setLayout(new GridLayout(2, 1, 0, 0));
		ModelYearBrandPanel.setBorder(BorderFactory.createEmptyBorder());
		
		JPanel ModelYearPanel = new JPanel();
		ModelYearBrandPanel.add(ModelYearPanel);
		ModelYearPanel.setLayout(new GridLayout(1, 2, 0, 0));
		ModelYearPanel.setBorder(BorderFactory.createEmptyBorder());
		
		JPanel ModelPanel = new JPanel();
		FlowLayout flowLayout = (FlowLayout) ModelPanel.getLayout();
		flowLayout.setVgap(0);
		flowLayout.setHgap(0);
		ModelYearPanel.add(ModelPanel);
		ModelPanel.setBorder(BorderFactory.createEmptyBorder());
		
		JLabel ModelLabel = new JLabel("MODEL");
		ModelPanel.add(ModelLabel);
		
		JPanel CarYearPanel = new JPanel();
		FlowLayout flowLayout_1 = (FlowLayout) CarYearPanel.getLayout();
		flowLayout_1.setVgap(0);
		flowLayout_1.setHgap(0);
		ModelYearPanel.add(CarYearPanel);
		CarYearPanel.setBorder(BorderFactory.createEmptyBorder());
		
		JLabel CarYearLabel = new JLabel("CAR YEAR");
		CarYearPanel.add(CarYearLabel);
		
		JPanel BrandPanel = new JPanel();
		ModelYearBrandPanel.add(BrandPanel);
		BrandPanel.setBorder(BorderFactory.createEmptyBorder());
		
		JLabel lblBrand = new JLabel("BRAND");
		BrandPanel.add(lblBrand);
	
	
	}*/
	
	
	 public void populateCarObjectArrayList()
	 {
		CarObjects.add(null); //from database, change null later on
	 }
	 
	 public void populateCarObjectResultList() //
	 {
	 	while(!CarObjects.isEmpty() || CarObjects.size()<5)
	 	{
	 		CarObjectResultsPanel.add(createCarObjectPanel());
	 	}
	 }
	 
	 public JPanel createCarObjectPanel()
	 {//will create a JPanel for each car object from the query
		JPanel CarObjectPanel = new JPanel();
		CarObjectPanel.setBounds(84, 249, 260, 62);
		frame.getContentPane().add(CarObjectPanel);
		CarObjectPanel.setLayout(new BorderLayout(0, 10));
		CarObjectPanel.setBorder(BorderFactory.createEmptyBorder());
		
		JPanel RentMePanel = new JPanel();
		CarObjectPanel.add(RentMePanel, BorderLayout.EAST);
		RentMePanel.setBorder(BorderFactory.createEmptyBorder());
		
		JButton RentMeButton = new JButton("RENT ME");
		RentMePanel.add(RentMeButton);
		RentMeButton.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e) 
			{
				// Rent Car object
				
			}
			
		});
		
		JPanel ModelYearBrandPanel = new JPanel();
		CarObjectPanel.add(ModelYearBrandPanel, BorderLayout.CENTER);
		ModelYearBrandPanel.setLayout(new GridLayout(2, 1, 0, 0));
		ModelYearBrandPanel.setBorder(BorderFactory.createEmptyBorder());
		
		JPanel ModelYearPanel = new JPanel();
		ModelYearBrandPanel.add(ModelYearPanel);
		ModelYearPanel.setLayout(new GridLayout(1, 2, 0, 0));
		ModelYearPanel.setBorder(BorderFactory.createEmptyBorder());
		
		JPanel ModelPanel = new JPanel();
		FlowLayout flowLayout = (FlowLayout) ModelPanel.getLayout();
		flowLayout.setVgap(0);
		flowLayout.setHgap(0);
		ModelYearPanel.add(ModelPanel);
		ModelPanel.setBorder(BorderFactory.createEmptyBorder());
		
		JLabel ModelLabel = new JLabel("MODEL");
		ModelPanel.add(ModelLabel);
		
		JPanel CarYearPanel = new JPanel();
		FlowLayout flowLayout_1 = (FlowLayout) CarYearPanel.getLayout();
		flowLayout_1.setVgap(0);
		flowLayout_1.setHgap(0);
		ModelYearPanel.add(CarYearPanel);
		CarYearPanel.setBorder(BorderFactory.createEmptyBorder());
		
		JLabel CarYearLabel = new JLabel("CAR YEAR");
		CarYearPanel.add(CarYearLabel);
		
		JPanel BrandPanel = new JPanel();
		ModelYearBrandPanel.add(BrandPanel);
		BrandPanel.setBorder(BorderFactory.createEmptyBorder());
		
		JLabel lblBrand = new JLabel("BRAND");
		BrandPanel.add(lblBrand);
		return CarObjectPanel;
		
	}
}

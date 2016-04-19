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

public class CarRecommendationResultsPage {

	private JFrame frame;
	private ArrayList<String> RecommendationObjects=new ArrayList<String>(); //will hold matching car objects results. Change Wrapper Class to Cars/Recommendations? later
	private JPanel RecommendationObjectResultsPanel;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CarRecommendationResultsPage window = new CarRecommendationResultsPage();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the Car Recommendations Page.
	 */
	public CarRecommendationResultsPage() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() 
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
	           //opens user page
	        }

	    });
		FlowLayout fl_UserAccountTextPanel = (FlowLayout) UserAccountTextPanel.getLayout();
		fl_UserAccountTextPanel.setVgap(10);
		UserAndLogOutPanel.add(UserAccountTextPanel);
		UserAccountTextPanel.setBorder(BorderFactory.createEmptyBorder());
		
		JLabel UserTextLabel = new JLabel();
		UserAccountTextPanel.add(UserTextLabel);
		UserTextLabel.setText("USER");
		UserTextLabel.setBackground(SystemColor.window);
		
		JPanel LogoutTextPanel = new JPanel();
		LogoutTextPanel.addMouseListener(new MouseAdapter() {

	        public void mouseClicked(MouseEvent e) 
	        {
	        	frame.dispose();
	           //opens logoutpage
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
		 
		
		JPanel ResultsConfirmationTextPanel = new JPanel();
		ResultsConfirmationTextPanel.setBorder(BorderFactory.createEmptyBorder());
		ResultsConfirmationTextPanel.setBounds(6, 107, 704, 24);
		frame.getContentPane().add(ResultsConfirmationTextPanel);
		
		JLabel FoundRecommendationsLabel = new JLabel("Sorry, we don't have any car that meets your specification. But we have some suggestions you would like.");
		ResultsConfirmationTextPanel.add(FoundRecommendationsLabel);
		
		RecommendationObjectResultsPanel = new JPanel();
		RecommendationObjectResultsPanel.setForeground(Color.BLACK);
		RecommendationObjectResultsPanel.setBorder(BorderFactory.createEmptyBorder());
		RecommendationObjectResultsPanel.setBounds(6, 152, 386, 367);
		frame.getContentPane().add(RecommendationObjectResultsPanel);
		RecommendationObjectResultsPanel.setLayout(new GridLayout(5, 1, 0, 0));
	}
		//code of what a panel for each car would look like
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
	
	/**
	 * Populate the ArrayList with Car Recommendation objects from the database
	 */
	 public void populateRecommendationObjectArrayList()
	 {
		RecommendationObjects.add(null); //from database, change null later on
	 }
	 
	 /**
	* Populate the CarObjectResultsPanel with createCarRecommendationPanel() JPanels constructed from each Car/Recommendation? object from the ArrayList
	*/
	 public void populateRecommendationObjectResultList() //5 recommendation objects max
	 {
	 	while(!RecommendationObjects.isEmpty() || RecommendationObjects.size()<5)
	 	{
	 		RecommendationObjectResultsPanel.add(createCarRecommendationPanel());
	 	}
	 }
	 
	 /**
	* Create a Car Recommendation Panel with with Car objects from the ArrayList
	* @return JPanel Car Recommendation Object
	*/
	 public JPanel createCarRecommendationPanel()
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

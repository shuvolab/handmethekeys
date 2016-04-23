package com.gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EtchedBorder;
import javax.swing.border.MatteBorder;

public class ListedCarsPage {

	private JFrame frame;
	private JTextField txtCarYear;
	private JTextField txtModel_1;
	private JTextField txtBrand;
	private JTextField textField;

	/**
	 * This is the successful frame for added car into our Database.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ListedCarsPage window = new ListedCarsPage();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the Listed Cars Page.
	 */
	public ListedCarsPage() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
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
			public void mouseClicked(MouseEvent e) {

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
			public void mouseClicked(MouseEvent e) {
				frame.dispose();
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
		JPanel LISTEDorRENTEDButton = new JPanel();
		LISTEDorRENTEDButton.setBorder(new EtchedBorder(EtchedBorder.RAISED, null, null));
		LISTEDorRENTEDButton.setBounds(47, 116, 290, 50);
		frame.getContentPane().add(LISTEDorRENTEDButton);
		LISTEDorRENTEDButton.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		JButton btnRentedCar_1 = new JButton("RENTED CAR");
		LISTEDorRENTEDButton.add(btnRentedCar_1);
		JButton btnRentedCar = new JButton("LISTED CAR");
		btnRentedCar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		LISTEDorRENTEDButton.add(btnRentedCar);

		JPanel RentedCarList = new JPanel();
		RentedCarList.setBounds(21, 221, 385, 329);
		frame.getContentPane().add(RentedCarList);
		RentedCarList.setLayout(new GridLayout(5, 1, 0, 5));

		JPanel YourRentedCarsText = new JPanel();
		YourRentedCarsText.setBorder(BorderFactory.createEmptyBorder());
		YourRentedCarsText.setBounds(6, 185, 155, 24);
		frame.getContentPane().add(YourRentedCarsText);
		JLabel lblYourRentedCars = new JLabel("YOUR LISTED CARS");
		YourRentedCarsText.add(lblYourRentedCars);
		//UNCOMMENT THIS BLOCK OF CODE TO SEE WHAT THE LISTED CAR PANEL LOOKS LIKE
		/*JPanel ListedCar = new JPanel();
		ListedCar.setBounds(421, 398, 403, 84);
		frame.getContentPane().add(ListedCar);
		ListedCar.setLayout(new BorderLayout(0, 0));

		JPanel YearModelBrandZipPanel = new JPanel();
		ListedCar.add(YearModelBrandZipPanel, BorderLayout.WEST);
		YearModelBrandZipPanel.setLayout(new BorderLayout(0, 0));
		YearModelBrandZipPanel.setBorder(BorderFactory.createEmptyBorder());

		JPanel BrandZipPanel = new JPanel();
		YearModelBrandZipPanel.add(BrandZipPanel, BorderLayout.SOUTH);
		BrandZipPanel.setLayout(new BorderLayout(0, 0));
		BrandZipPanel.setBorder(BorderFactory.createEmptyBorder());

		JPanel ZIPCODEPanel = new JPanel();
		BrandZipPanel.add(ZIPCODEPanel, BorderLayout.EAST);
		ZIPCODEPanel.setLayout(new BorderLayout(0, 0));
		ZIPCODEPanel.setBorder(BorderFactory.createEmptyBorder());

		JLabel lblZipCode = new JLabel("ZIP CODE");
		ZIPCODEPanel.add(lblZipCode, BorderLayout.NORTH);

		textField = new JTextField();
		ZIPCODEPanel.add(textField, BorderLayout.CENTER);
		textField.setColumns(10);

		JPanel BrandPanel = new JPanel();
		BrandZipPanel.add(BrandPanel, BorderLayout.WEST);
		BrandPanel.setBorder(BorderFactory.createEmptyBorder());
		BrandPanel.setLayout(new BorderLayout(0, 0));
		txtBrand = new JTextField();
		BrandPanel.add(txtBrand, BorderLayout.CENTER);
		txtBrand.setColumns(10);

		JLabel lblBrand = new JLabel("BRAND");
		BrandPanel.add(lblBrand, BorderLayout.NORTH);

		JPanel YearModelPanel = new JPanel();
		YearModelBrandZipPanel.add(YearModelPanel, BorderLayout.NORTH);
		YearModelPanel.setLayout(new BorderLayout(0, 0));
		YearModelPanel.setBorder(BorderFactory.createEmptyBorder());

		JPanel CarYearPanel = new JPanel();
		YearModelPanel.add(CarYearPanel, BorderLayout.WEST);
		CarYearPanel.setBorder(BorderFactory.createEmptyBorder());
		CarYearPanel.setLayout(new BorderLayout(0, 0));
		txtCarYear = new JTextField();
		CarYearPanel.add(txtCarYear, BorderLayout.CENTER);
		txtCarYear.setColumns(10);

		JLabel lblCarYear = new JLabel("CAR YEAR");
		CarYearPanel.add(lblCarYear, BorderLayout.NORTH);

		JPanel ModelPanel = new JPanel();
		YearModelPanel.add(ModelPanel, BorderLayout.EAST);
		ModelPanel.setBorder(BorderFactory.createEmptyBorder());
		ModelPanel.setLayout(new BorderLayout(0, 0));

		JLabel lblModel = new JLabel("MODEL");
		ModelPanel.add(lblModel, BorderLayout.NORTH);
		txtModel_1 = new JTextField();
		ModelPanel.add(txtModel_1, BorderLayout.CENTER);
		txtModel_1.setColumns(10);
		
		JPanel EditDeletePanel = new JPanel();
		ListedCar.add(EditDeletePanel, BorderLayout.CENTER);
		EditDeletePanel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		EditDeletePanel.setBorder(BorderFactory.createEmptyBorder());
		
		JButton btnEdit = new JButton("EDIT");
		EditDeletePanel.add(btnEdit);
		
		JButton btnDelete = new JButton("DELETE");
		EditDeletePanel.add(btnDelete);
		// Displays ON RENT or AVAILABLE if the car is currently us
		*/
	}

	public void actionPerformed(ActionEvent e) {
		// Action performed
	}

	/**
	 * sets the frame visible for the class
	 */

	public JPanel createListedCarPanel() {
		JPanel ListedCar = new JPanel();
		ListedCar.setBounds(421, 398, 403, 84);
		frame.getContentPane().add(ListedCar);
		ListedCar.setLayout(new BorderLayout(0, 0));

		JPanel YearModelBrandZipPanel = new JPanel();
		ListedCar.add(YearModelBrandZipPanel, BorderLayout.WEST);
		YearModelBrandZipPanel.setLayout(new BorderLayout(0, 0));
		YearModelBrandZipPanel.setBorder(BorderFactory.createEmptyBorder());

		JPanel BrandZipPanel = new JPanel();
		YearModelBrandZipPanel.add(BrandZipPanel, BorderLayout.SOUTH);
		BrandZipPanel.setLayout(new BorderLayout(0, 0));
		BrandZipPanel.setBorder(BorderFactory.createEmptyBorder());

		JPanel ZIPCODEPanel = new JPanel();
		BrandZipPanel.add(ZIPCODEPanel, BorderLayout.EAST);
		ZIPCODEPanel.setLayout(new BorderLayout(0, 0));
		ZIPCODEPanel.setBorder(BorderFactory.createEmptyBorder());

		JLabel lblZipCode = new JLabel("ZIP CODE");
		ZIPCODEPanel.add(lblZipCode, BorderLayout.NORTH);

		textField = new JTextField();
		ZIPCODEPanel.add(textField, BorderLayout.CENTER);
		textField.setColumns(10);

		JPanel BrandPanel = new JPanel();
		BrandZipPanel.add(BrandPanel, BorderLayout.WEST);
		BrandPanel.setBorder(BorderFactory.createEmptyBorder());
		BrandPanel.setLayout(new BorderLayout(0, 0));
		txtBrand = new JTextField();
		BrandPanel.add(txtBrand, BorderLayout.CENTER);
		txtBrand.setColumns(10);

		JLabel lblBrand = new JLabel("BRAND");
		BrandPanel.add(lblBrand, BorderLayout.NORTH);

		JPanel YearModelPanel = new JPanel();
		YearModelBrandZipPanel.add(YearModelPanel, BorderLayout.NORTH);
		YearModelPanel.setLayout(new BorderLayout(0, 0));
		YearModelPanel.setBorder(BorderFactory.createEmptyBorder());

		JPanel CarYearPanel = new JPanel();
		YearModelPanel.add(CarYearPanel, BorderLayout.WEST);
		CarYearPanel.setBorder(BorderFactory.createEmptyBorder());
		CarYearPanel.setLayout(new BorderLayout(0, 0));
		txtCarYear = new JTextField();
		CarYearPanel.add(txtCarYear, BorderLayout.CENTER);
		txtCarYear.setColumns(10);

		JLabel lblCarYear = new JLabel("CAR YEAR");
		CarYearPanel.add(lblCarYear, BorderLayout.NORTH);

		JPanel ModelPanel = new JPanel();
		YearModelPanel.add(ModelPanel, BorderLayout.EAST);
		ModelPanel.setBorder(BorderFactory.createEmptyBorder());
		ModelPanel.setLayout(new BorderLayout(0, 0));

		JLabel lblModel = new JLabel("MODEL");
		ModelPanel.add(lblModel, BorderLayout.NORTH);
		txtModel_1 = new JTextField();
		ModelPanel.add(txtModel_1, BorderLayout.CENTER);
		txtModel_1.setColumns(10);
		
		JPanel EditDeletePanel = new JPanel();
		ListedCar.add(EditDeletePanel, BorderLayout.CENTER);
		EditDeletePanel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		EditDeletePanel.setBorder(BorderFactory.createEmptyBorder());
		
		JButton btnEdit = new JButton("EDIT");
		EditDeletePanel.add(btnEdit);
		
		JButton btnDelete = new JButton("DELETE");
		EditDeletePanel.add(btnDelete);
		// Displays ON RENT or AVAILABLE if the car is currently us
		return ListedCar;
	}

	public void setvisible() {

		frame.setVisible(true);
	}
}

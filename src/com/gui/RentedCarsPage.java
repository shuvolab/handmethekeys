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
import java.util.ArrayList;

import javax.swing.*;
import javax.swing.border.EtchedBorder;
import javax.swing.border.MatteBorder;

import com.database.Connection;
import com.engine.mediator.Mediator;
import com.engine.mediator.data.Car;
import com.engine.mediator.data.User;

public class RentedCarsPage {

    private JFrame frame;
    private JTextField txtCarYear;
    private JTextField txtModel_1;
    private JTextField txtBrand;
    private JTextField textField;

    /**
     * This is the successful frame for added car into our Database.
     */
    public static void start(final Mediator mediator) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    RentedCarsPage window = new RentedCarsPage(mediator);
                    window.frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    /**
     * Create the Rented Cars Page.
     */
    public RentedCarsPage(final Mediator mediator) {
        initialize(mediator);
    }

    /**
     * Initialize the contents of the frame.
     */
    private void initialize(final Mediator mediator) {
        frame = new JFrame();
        frame.setBounds(100, 100, 1010, 594);
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
        SoftwareTitlelabel.setFont(new Font("Skia", Font.PLAIN, 18));
        HandMeTheKeysPanel.add(SoftwareTitlelabel);

        JPanel UserAndLogOutPanel = new JPanel();
        HMTKLoginPanel.add(UserAndLogOutPanel, BorderLayout.EAST);
        UserAndLogOutPanel.setLayout(new GridLayout(1, 2, 0, 0));
        UserAndLogOutPanel.setBorder(BorderFactory.createEmptyBorder());

        JPanel UserAccountTextPanel = new JPanel();
        UserAccountTextPanel.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
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
            public void mouseClicked(MouseEvent e) {
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
                frame.setVisible(false);
                ListedCarsPage.start(mediator);
            }
        });
        LISTEDorRENTEDButton.add(btnRentedCar);

        JPanel RentedCarList = new JPanel();
        RentedCarList.setBounds(21, 221, 385, 329);
        frame.getContentPane().add(RentedCarList);
        RentedCarList.setLayout(new GridLayout(6, 1, 0, 5));

        JScrollPane scrPane = new JScrollPane(RentedCarList);
        frame.getContentPane().add(scrPane);

        JPanel YourRentedCarsText = new JPanel();
        YourRentedCarsText.setBorder(BorderFactory.createEmptyBorder());
        YourRentedCarsText.setBounds(6, 185, 155, 24);
        frame.getContentPane().add(YourRentedCarsText);

        JLabel lblYourRentedCars = new JLabel("YOUR RENTED CARS");
        YourRentedCarsText.add(lblYourRentedCars);

        ArrayList<Car> rentedCarList = new Connection().getRentedCars(mediator.getUser());
        ArrayList<ArrayList<JPanel>> panels = new ArrayList<>(); ArrayList<ArrayList<JLabel>> labels = new ArrayList<>();
        ArrayList<ArrayList<JTextField>> textFields = new ArrayList<>();
        for (int i=0;i<rentedCarList.size();i++) {
            panels.add(new ArrayList<JPanel>());
            labels.add(new ArrayList<JLabel>());
            textFields.add(new ArrayList<JTextField>());
            createRentedCarPanel(rentedCarList.get(i), panels.get(i), labels.get(i),textFields.get(i),i);
        }
        //UNCOMMENT THIS BLOCK OF CODE TO SEE WHAT THE LISTED CAR PANEL LOOKS LIKE
        /*
		JPanel RentedCar = new JPanel();
		frame.getContentPane().add(RentedCar);
		RentedCar.setLayout(new GridLayout(rentedCarList.size(),1));
		for(int i=0;i<rentedCarList.size();i++){
			display.add(i, new JLabel());
			display.get(i).setText(rentedCarList.get(i).toString());
			RentedCar.add(display.get(i));
		}
/*
		JPanel EDITDELETEPanel = new JPanel();
		EDITDELETEPanel.setBorder(BorderFactory.createEmptyBorder());
		EDITDELETEPanel.setBounds(336, 383, 224, 71);
		RentedCar.add(EDITDELETEPanel, BorderLayout.EAST);
		EDITDELETEPanel.setLayout(new BorderLayout(0, 0));

		JPanel RENTALSTATUSPANEL = new JPanel();
		RENTALSTATUSPANEL.setBorder(BorderFactory.createEmptyBorder());
		EDITDELETEPanel.add(RENTALSTATUSPANEL, BorderLayout.CENTER);

		JLabel RentalStatusPanel = new JLabel();
		RentalStatusPanel.setText("RENTED OR NOT");
		RENTALSTATUSPANEL.add(RentalStatusPanel);

		JPanel YearModelBrandZipPanel = new JPanel();
		RentedCar.add(YearModelBrandZipPanel, BorderLayout.WEST);
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

		JPanel BrandPanel = new JPanel();
		BrandZipPanel.add(BrandPanel, BorderLayout.WEST);
		BrandPanel.setBorder(BorderFactory.createEmptyBorder());
		BrandPanel.setLayout(new BorderLayout(0, 0));

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

		JLabel lblCarYear = new JLabel("CAR YEAR");
		CarYearPanel.add(lblCarYear, BorderLayout.NORTH);

		JPanel ModelPanel = new JPanel();
		YearModelPanel.add(ModelPanel, BorderLayout.EAST);
		ModelPanel.setBorder(BorderFactory.createEmptyBorder());
		ModelPanel.setLayout(new BorderLayout(0, 0));

		JLabel lblModel = new JLabel("MODEL");
		ModelPanel.add(lblModel, BorderLayout.NORTH);
		*/

    }

    /**
     * sets the frame visible for the class
     */

    public JPanel createRentedCarPanel(Car car,
                                       ArrayList<JPanel> panels, ArrayList<JLabel> labels, ArrayList<JTextField> textFields,
                                       int num) {
        //panels 0
        panels.add(new JPanel());
        panels.get(0).setBounds(101, 225 + num * 100, 403, 84);
        frame.getContentPane().add(panels.get(0));
        panels.get(0).setLayout(new BorderLayout(0, 0));

        //panels 1
        panels.add(new JPanel());
        panels.get(1).setBorder(BorderFactory.createEmptyBorder());
        panels.get(1).setBounds(336, 383, 224, 71);
        panels.get(0).add(panels.get(1), BorderLayout.EAST);
        panels.get(1).setLayout(new BorderLayout(0, 0));

        //panels 2
        panels.add(new JPanel());
        panels.get(2).setBorder(BorderFactory.createEmptyBorder());
        panels.get(1).add(panels.get(2), BorderLayout.CENTER);

        //labels 0
        labels.add(new JLabel());
        labels.get(0).setText("RENTED");
        panels.get(2).add(labels.get(0));

        //panels 3
        panels.add(new JPanel());
        panels.get(0).add(panels.get(3), BorderLayout.WEST);
        panels.get(3).setLayout(new BorderLayout(0, 0));
        panels.get(3).setBorder(BorderFactory.createEmptyBorder());

        //panels 4
        panels.add(new JPanel());
        panels.get(3).add(panels.get(4), BorderLayout.SOUTH);
        panels.get(4).setLayout(new BorderLayout(0, 0));
        panels.get(4).setBorder(BorderFactory.createEmptyBorder());

        //panels 5
        panels.add(new JPanel());
        panels.get(4).add(panels.get(5), BorderLayout.EAST);
        panels.get(5).setLayout(new BorderLayout(0, 0));
        panels.get(5).setBorder(BorderFactory.createEmptyBorder());

        //labels 1
        labels.add(new JLabel("ZIP CODE"));
        panels.get(5).add(labels.get(1), BorderLayout.NORTH);

        //textFields 0
        textFields.add(new JTextField());
        textFields.get(0).setText(String.valueOf(car.getZip()));
        panels.get(5).add(textFields.get(0), BorderLayout.CENTER);
        textFields.get(0).setColumns(10);

        //panels 6
        panels.add(new JPanel());
        panels.get(4).add(panels.get(6), BorderLayout.WEST);
        panels.get(6).setBorder(BorderFactory.createEmptyBorder());
        panels.get(6).setLayout(new BorderLayout(0, 0));

        //textFields 1
        textFields.add(new JTextField());
        textFields.get(1).setText(car.getMake());
        panels.get(6).add(textFields.get(1), BorderLayout.CENTER);
        textFields.get(1).setColumns(10);

        //labels 2
        labels.add(new JLabel("BRAND"));
        panels.get(6).add(labels.get(2), BorderLayout.NORTH);

        //panels 7
        panels.add(new JPanel());
        panels.get(3).add(panels.get(7), BorderLayout.NORTH);
        panels.get(7).setLayout(new BorderLayout(0, 0));
        panels.get(7).setBorder(BorderFactory.createEmptyBorder());

        //panels 8
        panels.add(new JPanel());
        panels.get(7).add(panels.get(8), BorderLayout.WEST);
        panels.get(8).setBorder(BorderFactory.createEmptyBorder());
        panels.get(8).setLayout(new BorderLayout(0, 0));

        //textFields 2
        textFields.add(new JTextField());
        textFields.get(2).setText(car.getYear());
        panels.get(8).add(textFields.get(2), BorderLayout.CENTER);
        textFields.get(2).setColumns(10);

        //labels 3
        labels.add(new JLabel("CAR YEAR"));
        panels.get(8).add(labels.get(3), BorderLayout.NORTH);

        //panels 9
        panels.add(new JPanel());
        panels.get(7).add(panels.get(9), BorderLayout.EAST);
        panels.get(9).setBorder(BorderFactory.createEmptyBorder());
        panels.get(9).setLayout(new BorderLayout(0, 0));

        //labels 4
        labels.add(new JLabel("MODEL"));
        panels.get(9).add(labels.get(4), BorderLayout.NORTH);

        //textFields 3
        textFields.add(new JTextField());
        textFields.get(3).setText(car.getModel());
        panels.get(9).add(textFields.get(3), BorderLayout.CENTER);
        textFields.get(3).setColumns(10);

        return panels.get(0);
    }

    public void setvisible() {

        frame.setVisible(true);
    }
}

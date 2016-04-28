package com.gui;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.*;

import com.database.Connection;
import com.engine.mediator.Mediator;
import com.engine.mediator.data.Car;
import com.engine.mediator.data.User;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;

public class CarResultsPage {

    private JFrame frame;
    private ArrayList<Car> CarObjects = new ArrayList<>(); //will hold matching car objects results. Change Wrapper Class to cars later
    private JPanel CarObjectResultsPanel;
    private Mediator mediator;


    /**
     * Launch the application.
     */
    public static void start(final Mediator mediator) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    CarResultsPage window = new CarResultsPage(mediator);
                    window.frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    /**
     * Create the Car Results Page.
     */
    public CarResultsPage(final Mediator mediator) {
        initialize(mediator);
    }

    /**
     * Initialize the contents of the frame.
     */
    private void initialize(final Mediator mediator) {
        this.mediator=mediator;

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
        UserTextLabel.setText("USER");
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

        populateCarObjectArrayList(mediator.getCarList());
        populateCarObjectResultList();

    }

    /*code of what a panel for each car would look like
        JPanel CarObjectPanel = new JPanel();
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

        JPanel BrandZipPanel = new JPanel();
        ModelYearBrandPanel.add(BrandZipPanel);
        BrandZipPanel.setLayout(new GridLayout(0, 2, 0, 0));
        BrandZipPanel.setBorder(BorderFactory.createEmptyBorder());

        JPanel BrandPanel = new JPanel();
        FlowLayout flowLayout_2 = (FlowLayout) BrandPanel.getLayout();
        flowLayout_2.setHgap(50);
        BrandZipPanel.add(BrandPanel);
        BrandPanel.setBorder(BorderFactory.createEmptyBorder());

        JLabel lblBrand = new JLabel("BRAND");
        BrandPanel.add(lblBrand);

        JPanel Zippanel = new JPanel();
        BrandZipPanel.add(Zippanel);
        Zippanel.setBorder(BorderFactory.createEmptyBorder());

        JLabel lblZipCode = new JLabel("ZIP CODE");
        Zippanel.add(lblZipCode);
    }

    /**
     * Populate the ArrayList with Car objects from the database
     */
    public void populateCarObjectArrayList(ArrayList<Car> cars) {
        for (Car car : cars) {
            CarObjects.add(car); //from database, change null later on
        }

    }

    /**
     * Populate the CarObjectResultsPanel with createCarObjectPanel() JPanels constructed from each Car object from the ArrayList
     */
    public void populateCarObjectResultList() //5 objects displayed max
    {
        ArrayList<ArrayList<JPanel>> panels = new ArrayList<>();
        ArrayList<ArrayList<JLabel>> labels = new ArrayList<>();
        ArrayList<JButton> buttons = new ArrayList<>();
        int count = 0;
        while (!CarObjects.isEmpty() && count < 5) {
            panels.add(new ArrayList<JPanel>());
            labels.add(new ArrayList<JLabel>());
            buttons.add(new JButton("RENT"));
            CarObjectResultsPanel.add(createCarObjectPanel(CarObjects.get(count), panels.get(count), labels.get(count), buttons.get(count), count));
            count++;
        }
    }

    /**
     * Create a Car Object Panel with with Car objects from the ArrayList
     *
     * @return JPanel Car Object
     */
    public JPanel createCarObjectPanel(Car car,
                                       ArrayList<JPanel> panels, ArrayList<JLabel> labels, JButton button,
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
        labels.get(0).setText("");

        //button
        panels.get(2).add(button);
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new Connection().rentCar(mediator.getStartDate(),mediator.getEndDate(),car,mediator.getUser());
                frame.setVisible(false);
                RentedCarSuccessfullyPage.start(mediator);
            }
        });

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
        labels.add(new JLabel("ZIP CODE: "+car.getZip()));
        panels.get(5).add(labels.get(1), BorderLayout.NORTH);



        //panels 6
        panels.add(new JPanel());
        panels.get(4).add(panels.get(6), BorderLayout.WEST);
        panels.get(6).setBorder(BorderFactory.createEmptyBorder());
        panels.get(6).setLayout(new BorderLayout(0, 0));



        //labels 2
        labels.add(new JLabel("BRAND: "+car.getMake()));
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



        //labels 3
        labels.add(new JLabel("CAR YEAR: "+car.getYear()));
        panels.get(8).add(labels.get(3), BorderLayout.NORTH);

        //panels 9
        panels.add(new JPanel());
        panels.get(7).add(panels.get(9), BorderLayout.EAST);
        panels.get(9).setBorder(BorderFactory.createEmptyBorder());
        panels.get(9).setLayout(new BorderLayout(0, 0));

        //labels 4
        labels.add(new JLabel("MODEL: "+car.getModel()));
        panels.get(9).add(labels.get(4), BorderLayout.NORTH);



        return panels.get(0);
    }/*
    {//will create a JPanel for each car object from the query
        JPanel CarObjectPanel = new JPanel();
        CarObjectResultsPanel.add(CarObjectPanel);
        CarObjectPanel.setLayout(new BorderLayout(0, 10));
        CarObjectPanel.setBorder(BorderFactory.createEmptyBorder());

        JPanel RentMePanel = new JPanel();
        CarObjectPanel.add(RentMePanel, BorderLayout.EAST);
        RentMePanel.setBorder(BorderFactory.createEmptyBorder());

        JButton RentMeButton = new JButton("RENT ME");
        RentMePanel.add(RentMeButton);
        RentMeButton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                // Rent Car object
                new Connection().addCar(car);
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

        JLabel ModelLabel = new JLabel("MODEL: " + car.getModel());
        ModelPanel.add(ModelLabel);

        JPanel CarYearPanel = new JPanel();
        FlowLayout flowLayout_1 = (FlowLayout) CarYearPanel.getLayout();
        flowLayout_1.setVgap(0);
        flowLayout_1.setHgap(0);
        ModelYearPanel.add(CarYearPanel);
        CarYearPanel.setBorder(BorderFactory.createEmptyBorder());

        JLabel CarYearLabel = new JLabel("CAR YEAR: " + car.getYear());
        CarYearPanel.add(CarYearLabel);

        JPanel BrandZipPanel = new JPanel();
        ModelYearBrandPanel.add(BrandZipPanel);
        BrandZipPanel.setLayout(new GridLayout(0, 2, 0, 0));
        BrandZipPanel.setBorder(BorderFactory.createEmptyBorder());

        JPanel BrandPanel = new JPanel();
        FlowLayout flowLayout_2 = (FlowLayout) BrandPanel.getLayout();
        flowLayout_2.setHgap(50);
        BrandZipPanel.add(BrandPanel);
        BrandPanel.setBorder(BorderFactory.createEmptyBorder());

        JLabel lblBrand = new JLabel("BRAND: ");
        BrandPanel.add(lblBrand);

        JPanel Zippanel = new JPanel();
        BrandZipPanel.add(Zippanel);
        Zippanel.setBorder(BorderFactory.createEmptyBorder());

        JLabel lblZipCode = new JLabel("ZIP CODE: " + car.getZip());
        Zippanel.add(lblZipCode);
        return CarObjectPanel;

    }

    /**
     * sets the frame visible for the class
     */

    public void setvisible() {
        frame.setVisible(true);
    }
}

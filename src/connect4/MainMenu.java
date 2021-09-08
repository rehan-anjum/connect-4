/**
 * Name: Alex Chen
 * Date: August 24th, 2021
 * File Name: MainMenu
 * Description: This program will open up the main menu of the program, allowing 
 *              the user to navigate to other menus in the application (such as 
 *              the actual game and the help menu) and exit the program.
 */

package connect4;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/**
 *
 * @author Alex Chen
 */
public class MainMenu extends JFrame implements ActionListener {
    // Create JLabels to store images
    JLabel lblBackground = new JLabel();        // JLabel storing background image
    JLabel lblLogo = new JLabel();              // JLabel storing game's logo
    JLabel lblImage1 = new JLabel();            // JLabel storing image #1 (right of menu btns)
    JLabel lblImage2 = new JLabel();            // JLabel storing image #2 (left of menu btns)

    // Create JPanel to organize JFrame elements
    JPanel pnlBtns = new JPanel();              // JPanel for holding menu buttons
    JPanel pnlPaddingWest = new JPanel();       // JPanel for holding left image and creating padding west of menu btns
    JPanel pnlPaddingNorth = new JPanel();      // JPanel for holding Connect 4 logo and creating padding north of menu btns
    JPanel pnlPaddingEast = new JPanel();       // JPanel for holding right image and creating padding east of menu btns
    
    // Create JButtons for menu (Play, Help & Credits, and Exit button respectively)
    JButton[] menuBtns = {new JButton("Play"), new JButton("Help & Credits"), new JButton("Exit")};
    
    // Options for exit dialogue (when pressing "Exit" button)
    Object[] options = {"Exit Program", "Back to Menu"};
    
    // Create layouts for JPanels and JFrame
    BoxLayout layoutBtns = new BoxLayout(pnlBtns, BoxLayout.Y_AXIS);                  // Layout for menu buttons (in center JPanel)
    BoxLayout layoutPaddingEast = new BoxLayout(pnlPaddingEast, BoxLayout.Y_AXIS);    // Layout for JPanel east of menu buttons (holding east image)
    BoxLayout layoutPaddingWest = new BoxLayout(pnlPaddingWest, BoxLayout.Y_AXIS);    // Layout for JPanel west of menu buttons (holding west image)
    BoxLayout layoutPaddingNorth = new BoxLayout(pnlPaddingNorth, BoxLayout.Y_AXIS);  // Layout for JPanel north of menu buttons (holding Connect 4 logo)
    
    // Constant to store menu button dimensions
    final Dimension MENU_BTN_SIZE = new Dimension(415, 135);               // size of each individual button
    final Dimension MENU_PADDING_WEST = new Dimension(710, 690);           // size of west JPanel containing left image
    final Dimension MENU_PADDING_EAST = new Dimension(710, 690);           // size of east JPanel containing right image
    final Dimension MENU_PADDING_NORTH = new Dimension(1920, 390);         // size of top JPanel containing logo
    
    // Import images in ImageIcon objects for background and game logo
    ImageIcon background = new ImageIcon("MenuBackgroundLight.png");       // ImageIcon for storing background of JFrame
    ImageIcon logo = new ImageIcon("Connect4Logo.png");                    // ImageIcon for storing Connect 4 logo
    
    // Import images in ImageIcon arrays for each button in their different states (normal states, pressed states, and mouse hover states)
    ImageIcon[] imgMenuBtns = {new ImageIcon("ButtonPlay.png"), new ImageIcon("ButtonHelp.png"), new ImageIcon("ButtonExit.png")};
    ImageIcon[] imgMenuBtnsPressed = {new ImageIcon("ButtonPlayDown.png"), new ImageIcon("ButtonHelpDown.png"), new ImageIcon("ButtonExitDown.png")};
    ImageIcon[] imgMenuBtnsRollover = {new ImageIcon("ButtonPlayHover.png"), new ImageIcon("ButtonHelpHover.png"), new ImageIcon("ButtonExitHover.png")};

    // Import images in ImageIcon objects for pictures on either side of menu btns
    ImageIcon sideImage1 = new ImageIcon("Image1.png");                    // ImageIcon for right image
    ImageIcon sideImage2 = new ImageIcon("Image 2 temp.png");              // ImageIcon for left image
     
    public MainMenu() {
        // Set up details of main JFrame
        super ("Connect 4 | Main Menu");        // sets name of window to "Connect 4 | Main Menu"
        setSize(1920, 1080);                    // sets dimensions of window to 1080p
        setLocationRelativeTo(null);            // centers program window
        setResizable(false);                    // sets window to NOT be resizable        
        setLayout(new BorderLayout(0, 0));      // uses Border Layout for frame
        
        // Set background of JFrame to Jlabel w/ image "background"
        lblBackground.setIcon(background); 
        lblBackground.setLayout(new BorderLayout());      // Set to BorderLayout in order to display img (does not display with "null" layout)
        setContentPane(lblBackground);                    // Set background Jlabel to screen
        
        // Set JPanel for buttons to BoxLayout "layoutBtns"
        pnlBtns.setLayout(layoutBtns);          // Set layout of buttons JPanel to predeclared BoxLayout "layoutBtns"
        pnlBtns.setOpaque(false);               // Make empty space in button Jpanel transparent
        
        pnlBtns.add(Box.createVerticalStrut(75));    // Create vertical spacing of 75 pixels in pnlBtns
        
        // Add menu buttons to JPanel "menuBtns" 
        for (int x = 0; x < menuBtns.length; x++) {
            // Set size (original, minimum, maximum, and preferred size) of each menu button
            menuBtns[x].setSize(MENU_BTN_SIZE);   
            menuBtns[x].setMinimumSize(MENU_BTN_SIZE);
            menuBtns[x].setMaximumSize(MENU_BTN_SIZE);
            menuBtns[x].setPreferredSize(MENU_BTN_SIZE);
            
            // Set button images for various states (normal, pressed, and hover over w/ mouse) 
            menuBtns[x].setIcon(imgMenuBtns[x]);
            menuBtns[x].setPressedIcon(imgMenuBtnsPressed[x]);
            menuBtns[x].setRolloverIcon(imgMenuBtnsRollover[x]);
            
            // Set background and border of each button to be transparent
            menuBtns[x].setOpaque(false);
            menuBtns[x].setContentAreaFilled(false);
            menuBtns[x].setBorderPainted(false);
            
            // Add each button to pnlBtns (centered) and add ActionListeners to each button
            pnlBtns.add(menuBtns[x]);
            menuBtns[x].addActionListener(this);
            menuBtns[x].setAlignmentX(Component.CENTER_ALIGNMENT);
            
            // After all buttons, add a 40 pixel gap
            if (x != (menuBtns.length - 1)) {
                pnlBtns.add(Box.createVerticalStrut(40));
            }
        }
        
        // Add pnlBtns to main JFrame window
        add(pnlBtns, BorderLayout.CENTER);
        
        // Set up image and padding on the right of menu buttons
        lblImage1.setIcon(sideImage1);
        
        // Set layout and size of east JPanel
        pnlPaddingEast.setLayout(layoutPaddingEast);
        pnlPaddingEast.setPreferredSize(MENU_PADDING_EAST);
        
        // Add image #1 to east JPanel and center image
        pnlPaddingEast.add(lblImage1);
        lblImage1.setAlignmentX(Component.CENTER_ALIGNMENT);     // centers panel contents on X axis
        lblImage1.setAlignmentY(Component.CENTER_ALIGNMENT);     // centers panel contents on Y axis
        
        // Set background of JPanel to be transparent
        pnlPaddingEast.setOpaque(false);
        add(pnlPaddingEast, BorderLayout.EAST);
        
        // Set up image and padding on the left of menu buttons
        lblImage2.setIcon(sideImage2);
        
        // Set layout and size of west JPanel
        pnlPaddingWest.setLayout(layoutPaddingWest);
        pnlPaddingWest.setPreferredSize(MENU_PADDING_WEST);
        
        // Add image #2 to west JPanel and center image
        pnlPaddingWest.add(lblImage2);
        lblImage2.setAlignmentX(Component.CENTER_ALIGNMENT);     // centers panel contents on X axis
        lblImage2.setAlignmentY(Component.CENTER_ALIGNMENT);     // centers panel contents on Y axis
        
        // Set background of JPanel to be transparent
        pnlPaddingWest.setOpaque(false);
        add(pnlPaddingWest, BorderLayout.WEST);
        
        // Set up Connect 4 logo and padding above menu buttons
        lblLogo.setIcon(logo);
        
        // Set layout and size of north JPanel
        pnlPaddingNorth.setLayout(layoutPaddingNorth);
        pnlPaddingNorth.setPreferredSize(MENU_PADDING_NORTH);
        
        // Add logo to north JPanel (with necessary spacing) and center image
        pnlPaddingNorth.add(Box.createVerticalStrut(75));
        pnlPaddingNorth.add(lblLogo);
        lblLogo.setAlignmentX(Component.CENTER_ALIGNMENT);     // centers panel contents on X axis
        lblLogo.setAlignmentY(Component.CENTER_ALIGNMENT);     // centers panel contents on Y axis
        
        // Set background of JPanel to be transparent
        pnlPaddingNorth.setOpaque(false);
        add(pnlPaddingNorth, BorderLayout.NORTH);

    }
    
    /**
     * Method that detects any activity with the menu buttons and calls the 
     * respective function (based on what button is pressed).
     * 
     * @param ae Parameter storing the action performed
     */
    @Override
    public void actionPerformed(ActionEvent ae) {
        if (ae.getActionCommand().equals("Play")) {                       // If Play button is pressed, call the playGame() method
            playGame();
        } else if (ae.getActionCommand().equals("Help & Credits")) {      // If Help & Credits button is pressed, call the helpMenu() method
            helpMenu(); 
        } else if (ae.getActionCommand().equals("Exit")) {                // If Exit button is pressed, call the exitConfirm() method
            exitConfirm();
        }
        
        // throw new UnsupportedOperationException("Not supported yet."); // To change body of generated methods, choose Tools | Templates.
    }
    
    /**
     * Method that exits the current JFrame and opens the main game screen.
     */
    private void playGame() {        
        Connect4BoardGame myGame = new Connect4BoardGame();
        myGame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        myGame.setVisible(true);               // Display the new JFrame for main game
        this.dispose();                        // Closes current main menu JFrame
    }
    
    /**
     * Method that exits the current JFrame and opens the help & credits screen.
     */
    private void helpMenu() {
        HelpScreen help = new HelpScreen();
        help.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        help.setVisible(true);                 // Displays the new JFrame for the help & credits menu
        this.dispose();                        // Closes current main menu JFrame
    }
    
    /**
     * Method that brings up a dialogue prompt confirming if the user wants to exit the program.
     * Selecting "Exit Program" will close all windows and terminate the application, while 
     * selecting "Back to Menu" will close the dialogue prompt and return the user to
     * the main menu.
     */
    private void exitConfirm() {
        // Declare variable to store user button input from the JOptionPane dialogue box
        int selection;
        // Opens the dialogue box, then waits for user input and stores it in "selection"
        selection = JOptionPane.showOptionDialog(this, "Are you sure you want to exit the program?", "Exit Confirmation", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[1]);
        
        //If selection corresponds with the Yes option ("Exit Program") in the dialogue, then close the JFrame and terminate the application.
        if (selection == JOptionPane.YES_OPTION) {
            dispose();
            System.exit(0); 
        }
    
    }
    
}

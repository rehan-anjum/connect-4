/**
 * Name: Syed Rehan Anjum
 * Date: August 24th, 2021 
 * File Name: HelpScreen
 * Description: This program will open a "Help" menu with tutorials to inform 
 *              the end-user on how to play the game, as well as credits to
 *              the game developers and the sources of all original used images.
 */

package connect4;

// import necessary classes
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.ArrayList;
import javax.swing.*;

/**
 *
 * @author Rehan
 */
public class HelpScreen extends JFrame implements ActionListener {
    
    // Create JLabels to store images
    JLabel lblBackground = new JLabel();        // JLabel storing background image
    JLabel lblLogo = new JLabel();              // JLabel storing game's logo
    
    // Create (nested) JPanels to organize JFrame elements
    JPanel pnlBtns = new JPanel();              // center JPanel storing menu buttons
    JPanel pnlPaddingNorth = new JPanel();      // north JPanel storing Connect4 logo
        
    // Create JButtons (in an array) for each of the help menu's options
    JButton[] menuBtns = {new JButton("Controls"), new JButton("Objectives"), new JButton("Credits"), new JButton("Home")};
    
    // Import images for background, logos, and buttons
    ImageIcon background = new ImageIcon("MenuBackgroundLight.png");       // for background
    ImageIcon logo = new ImageIcon("Connect4Logo.png");                    // for the Connect 4 logo
    
    // Import images (in an array) for menu buttons and their various states (when pressed down and when mouse hovers over btn)
    ImageIcon[] imgMenuBtns = {new ImageIcon("ButtonControls.png"), new ImageIcon("ButtonObjectives.png"), new ImageIcon("ButtonCredits.png"), new ImageIcon ("ButtonHome.png")};
    ImageIcon[] imgMenuBtnsPressed = {new ImageIcon("ButtonControlsDown.png"), new ImageIcon("ButtonObjectivesDown.png"), new ImageIcon("ButtonCreditsDown.png"), new ImageIcon ("ButtonHomeDown.png")};
    ImageIcon[] imgMenuBtnsRollover = {new ImageIcon("ButtonControlsHover.png"), new ImageIcon("ButtonObjectivesHover.png"), new ImageIcon("ButtonCreditsHover.png"), new ImageIcon ("ButtonHomeHover.png")};
    
    // Create an ArrayList of Strings to store all the instructions and info from the external "help.txt" file
    ArrayList<String> strInstructionsList = new ArrayList<String>();

    // Create BoxLayouts to format JPanels
    BoxLayout layoutBtns = new BoxLayout(pnlBtns, BoxLayout.Y_AXIS);          
    BoxLayout layoutPaddingNorth = new BoxLayout(pnlPaddingNorth, BoxLayout.Y_AXIS);
    
    // Create Dimension object constants to store dimensions of menu buttons and other JPanels
    final Dimension MENU_BTN_SIZE = new Dimension(415, 135);               // size of each individual button
    final Dimension MENU_PADDING_WEST = new Dimension(710, 690);           // size of west JPanel containing left image
    final Dimension MENU_PADDING_EAST = new Dimension(710, 690);           // size of east JPanel containing right image
    final Dimension MENU_PADDING_NORTH = new Dimension(1920, 390);         // size of top JPanel containing logo
    
    public HelpScreen() {
        // Set up details of main JFrame
        super("Connect 4 | Help Screen");       // sets name of window to "Connect 4 | Help Screen"
        setSize(1920, 1080);                    // sets dimensions of window to 1080p
        setLocationRelativeTo(null);            // centers program window
        setResizable(false);                    // sets window to not be resizable        
        setLayout(new BorderLayout(0, 0));      // uses Border Layout for frame

        // Set background of JFrame to Jlabel w/ image "background"
        lblBackground.setIcon(background);                // Set label to ImageIcon "background"
        lblBackground.setLayout(new BorderLayout());      // Set to BorderLayout in order to display img (does not display with "null" layout)
        setContentPane(lblBackground);                    // Set background Jlabel to screen
        
        // Set JPanel for buttons to BoxLayout "layoutBtns"
        pnlBtns.setLayout(layoutBtns);          // Set layout of "pnlBtns" JPanel to set layout "layoutBtns"
        pnlBtns.setOpaque(false);               // Make empty space in button Jpanel transparent
        
        // try-catch to read and store information from "help.txt" file
        try {
            FileReader fr = new FileReader("help.txt");           // Declaring a new FileReader
            BufferedReader br = new BufferedReader(fr);           // Declaring a new BufferedReader
            String strLine = br.readLine();
            // All the files keep
            // a system generated character to terminate a new line
            // when the line that read is a null then that's the end of tbe file
            
            // Using a while loop to add every non-empty line from "help.txt" to the ArrayList
            while (strLine != null) {
                strInstructionsList.add(strLine);
                strLine = br.readLine();

            }
            br.close();
        } catch (IOException e) {        // If "help.txt" file is misplaced, display a message dialogue instructing the user to redownload the application or place the txt file back to its original location
            JOptionPane.showMessageDialog(this, "NOTICE: The \"help.txt\" file was moved or misplaced. Please either place the \"help.txt\" file back to the root directory of the program or redownload the application.");
        }
        
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

            // After all buttons, add a 20 pixel gap
            if (x != (menuBtns.length - 1)) {
                pnlBtns.add(Box.createVerticalStrut(20));
            }
        }
        
        add(pnlBtns, BorderLayout.CENTER);        
        
        // Set up Connect 4 logo and padding above menu buttons
        lblLogo.setIcon(logo);
        
        //
        pnlPaddingNorth.setLayout(layoutPaddingNorth);
        pnlPaddingNorth.setPreferredSize(MENU_PADDING_NORTH);

        pnlPaddingNorth.add(Box.createVerticalStrut(75));
        pnlPaddingNorth.add(lblLogo);
        lblLogo.setAlignmentX(Component.CENTER_ALIGNMENT);     // centers panel contents on X axis
        lblLogo.setAlignmentY(Component.CENTER_ALIGNMENT);     // centers panel contents on Y axis
        
        pnlPaddingNorth.setOpaque(false);
        add(pnlPaddingNorth, BorderLayout.NORTH);
    }
    
    // The following three methods use for loops to iterate through the ArrayList 
    // storing information from the "help.txt" file and displays the info in a 
    // dialogue box.
    
    /**
     * Method that displays text for the "Controls" pop-up dialogue box.
     */
    private void controlPopUp() {
        String currentText = "";
        for (int i = 0; i < 5; i++) {
            currentText += strInstructionsList.get(i) + "\n";            
        }
        JOptionPane.showMessageDialog(this, currentText);
    }
    
    /**
     * Method that displays text for the "Objectives" pop-up dialogue box.
     */
    private void objectivesPopUp() {
        String currentText = "";
        for (int i = 5; i < 9; i++) {
            currentText += strInstructionsList.get(i) + "\n";
        }
        JOptionPane.showMessageDialog(this, currentText);
    }

    /**
    * Method that displays text for the "Credits" pop-up dialogue box. 
     */
    private void creditsPopUp() {
        String currentText = "";
        for (int i = 9; i < 31 ; i++) {
            currentText += strInstructionsList.get(i) + "\n";
        }
        JOptionPane.showMessageDialog(this, currentText);
    }
    
    /**
     * Method that exits the current JFrame and reopens the main menu.
     */
    private void mainMenu() {
        MainMenu menu = new MainMenu();
        menu.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        menu.setVisible(true);      // Displays JFrame
        this.dispose();
    }
    
    /**
     * Method that detects any activity with the menu buttons and calls the 
     * respective function (based on what button is pressed).
     * 
     * @param ae Parameter storing the action performed
     */
    @Override
    public void actionPerformed(ActionEvent ae) {
        if (ae.getActionCommand().equals("Controls")) {          // If controls button is pressed, call controlPopUp() method
            controlPopUp();
        } else if (ae.getActionCommand().equals("Objectives")) { // If objectives button is pressed, call objectivesPopUp() method
            objectivesPopUp();
        } else if (ae.getActionCommand().equals("Credits")) {    // If credits button is pressed, call creditsPopUp() method
            creditsPopUp();
        } else {                                                 // Otherwise (if home button is pressed), call mainMenu() method
            mainMenu();
        }
    }
    
}

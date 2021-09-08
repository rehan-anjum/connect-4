/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package connect4menu;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import connect4.Connect4BoardGame;
//import com.sun.awt.AWTUtilities.*;

//import java.awt.event.ActionEvent;
//import javax.swing.JFrame;
//import javax.swing.BoxLayout;
//import javax.swing.JLabel;
//import javax.swing.Icon;
//import javax.swing.ImageIcon;
//import javax.swing.JPanel;
//import javax.swing.JButton;

//import java.awt.event.ActionListener;




// NOTE: use "JPanel.setAlignmentX(Component.CENTER_ALIGNMENT);" to center elements in BoxLayout (use for side images)

/**
 *
 * @author achen
 */
public class MainMenu extends JFrame implements ActionListener {
    
    //JFrame frame = new JFrame("Connect4 Main Menu Prototype");
    
    // Create JLabels to store images
    JLabel lblBackground = new JLabel();        // JLabel storing background image
    JLabel lblLogo = new JLabel();              // JLabel storing game's logo
    JLabel lblPowerup = new JLabel();           // JLabel for storing text advertising powerups
    JLabel lblImage1 = new JLabel();            // temporary JLabel object for image #1
    JLabel lblImage2 = new JLabel();            // temporary JLabel object for image #2

    // Create JPanel to organize JFrame elements
    JPanel pnlBtns = new JPanel();
    JPanel pnlPaddingWest = new JPanel();
    JPanel pnlPaddingNorth = new JPanel();
    JPanel pnlPaddingEast = new JPanel();
    
    // Create JButtons for menu
    JButton[] menuBtns = {new JButton("Play"), new JButton("Help & Credits"), new JButton("Exit")};
    //JButton btnPlay = new JButton("Play");
    //JButton btnHelp = new JButton("Help & Credits");
    //JButton btnExit = new JButton("Exit");
    
    // Options for exit dialogue
    Object[] options = {"Exit Program", "Back to Menu"};
    
    // Create layouts for JPanels and JFrame
    BoxLayout layoutBtns = new BoxLayout(pnlBtns, BoxLayout.Y_AXIS);
    BoxLayout layoutPaddingEast = new BoxLayout(pnlPaddingEast, BoxLayout.Y_AXIS);
    BoxLayout layoutPaddingWest = new BoxLayout(pnlPaddingWest, BoxLayout.Y_AXIS);
    BoxLayout layoutPaddingNorth = new BoxLayout(pnlPaddingNorth, BoxLayout.Y_AXIS);
    
    // Constant to store menu button dimensions
    final Dimension MENU_BTN_SIZE = new Dimension(415, 135);               // size of each individual button
    final Dimension MENU_PADDING_WEST = new Dimension(710, 690);           // size of west JPanel containing left image
    final Dimension MENU_PADDING_EAST = new Dimension(710, 690);           // size of east JPanel containing right image
    final Dimension MENU_PADDING_NORTH = new Dimension(1920, 390);         // size of top JPanel containing logo
    
    // Import images for background, logos, and buttons
    ImageIcon background = new ImageIcon("MenuBackgroundLight.png");
    ImageIcon logo = new ImageIcon("Connect4Logo.png");
    
    ImageIcon[] imgMenuBtns = {new ImageIcon("ButtonPlay.png"), new ImageIcon("ButtonHelp.png"), new ImageIcon("ButtonExit.png")};
    ImageIcon[] imgMenuBtnsPressed = {new ImageIcon("ButtonPlayDown.png"), new ImageIcon("ButtonHelpDown.png"), new ImageIcon("ButtonExitDown.png")};
    ImageIcon[] imgMenuBtnsRollover = {new ImageIcon("ButtonPlayHover.png"), new ImageIcon("ButtonHelpHover.png"), new ImageIcon("ButtonExitHover.png")};

    ImageIcon sideImage1 = new ImageIcon("Image1.png");
    ImageIcon sideImage2 = new ImageIcon("Image 2 temp.png");
    
    public MainMenu() {
        
        
        // Set up details of main JFrame
        super ("Connect4 Main Menu Prototype"); // sets name of window to "Connect4 Main Menu Prototype"
        setSize(1920, 1080);                    // sets dimensions of window to 1080p
        setLocationRelativeTo(null);            // centers program window
        setResizable(false);                    // sets window to not be resizable        
        setLayout(new BorderLayout(0, 0));      // uses Border Layout for frame
        
        // Set background of JFrame to Jlabel w/ image "background"
        lblBackground.setIcon(background);
        lblBackground.setLayout(new BorderLayout());      // Set to BorderLayout in order to display img (does not display with "null" layout)
        setContentPane(lblBackground);                    // Set background Jlabel to screen
        
        // Set JPanel for buttons to BoxLayout "layoutBtns"
        pnlBtns.setLayout(layoutBtns);
        pnlBtns.setOpaque(false);               // Make empty space in button Jpanel transparent
        
        pnlBtns.add(Box.createVerticalStrut(75));
        
        // Add menu buttons to JPanel "menuBtns" 
        for (int x = 0; x < menuBtns.length; x++) {
            menuBtns[x].setSize(MENU_BTN_SIZE);
            menuBtns[x].setMinimumSize(MENU_BTN_SIZE);
            menuBtns[x].setMaximumSize(MENU_BTN_SIZE);
            menuBtns[x].setPreferredSize(MENU_BTN_SIZE);
            
            // TEMPORARY IF STATEMENT to set button images; will remove once all button images have been made and added to dir
            menuBtns[x].setIcon(imgMenuBtns[x]);
            menuBtns[x].setPressedIcon(imgMenuBtnsPressed[x]);
            menuBtns[x].setRolloverIcon(imgMenuBtnsRollover[x]);
            menuBtns[x].setOpaque(false);
            menuBtns[x].setContentAreaFilled(false);
            menuBtns[x].setBorderPainted(false);
            
            pnlBtns.add(menuBtns[x]);
            menuBtns[x].addActionListener(this);
            menuBtns[x].setAlignmentX(Component.CENTER_ALIGNMENT);
            
            if (x != (menuBtns.length - 1)) {
                pnlBtns.add(Box.createVerticalStrut(40));
            }
        }
        
        
        add(pnlBtns, BorderLayout.CENTER);
        
        // Set up image and padding on the right of menu buttons
        lblImage1.setIcon(sideImage1);
        
        pnlPaddingEast.setLayout(layoutPaddingEast);
        pnlPaddingEast.setPreferredSize(MENU_PADDING_EAST);
        
        
        pnlPaddingEast.add(lblImage1);
        lblImage1.setAlignmentX(Component.CENTER_ALIGNMENT);     // centers panel contents on X axis
        lblImage1.setAlignmentY(Component.CENTER_ALIGNMENT);     // centers panel contents on Y axis
        
        pnlPaddingEast.setOpaque(false);
        add(pnlPaddingEast, BorderLayout.EAST);
        
        // Set up image and padding on the left of menu buttons
        lblImage2.setIcon(sideImage2);
        
        pnlPaddingWest.setLayout(layoutPaddingWest);
        pnlPaddingWest.setPreferredSize(MENU_PADDING_WEST);
        
        pnlPaddingWest.add(lblImage2);
        lblImage2.setAlignmentX(Component.CENTER_ALIGNMENT);     // centers panel contents on X axis
        lblImage2.setAlignmentY(Component.CENTER_ALIGNMENT);     // centers panel contents on Y axis
        
        pnlPaddingWest.setOpaque(false);
        add(pnlPaddingWest, BorderLayout.WEST);
        
        // Set up Connect 4 logo and padding above menu buttons
        lblLogo.setIcon(logo);
        
        pnlPaddingNorth.setLayout(layoutPaddingNorth);
        pnlPaddingNorth.setPreferredSize(MENU_PADDING_NORTH);
        
        pnlPaddingNorth.add(Box.createVerticalStrut(75));
        pnlPaddingNorth.add(lblLogo);
        lblLogo.setAlignmentX(Component.CENTER_ALIGNMENT);     // centers panel contents on X axis
        lblLogo.setAlignmentY(Component.CENTER_ALIGNMENT);     // centers panel contents on Y axis
        
        pnlPaddingNorth.setOpaque(false);
        add(pnlPaddingNorth, BorderLayout.NORTH);
        
        // com.sun.awt.AWTUtilities.setWindowOpacity(this, 0.5f);

    }
    

    @Override
    public void actionPerformed(ActionEvent ae) {
        if (ae.getActionCommand().equals("Play")) {
            playGame();
        } else if (ae.getActionCommand().equals("Help & Credits")) {
            helpMenu();
        } else if (ae.getActionCommand().equals("Exit")) {
            exitConfirm();
        }
        
        // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    private void playGame() {
        
        Connect4BoardGame gameBoard = new Connect4BoardGame();
        gameBoard.setVisible(true);
        this.setVisible(false);
    }
    
    private void helpMenu() {
        JOptionPane.showMessageDialog(this, "Help function not supported yet.");
        //throw new UnsupportedOperationException("Help function not supported yet.");
    }
    
    private void exitConfirm() {
        int selection;
        selection = JOptionPane.showOptionDialog(this, "Are you sure you want to exit the program?", "Exit Confirmation", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[1]);
        
        if (selection == JOptionPane.YES_OPTION) {
            dispose();
            System.exit(0); 
        }
    
    }
    
}

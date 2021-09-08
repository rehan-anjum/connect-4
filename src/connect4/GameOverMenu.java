/**
 * Name: Alex Chen
 * Date: August 24th, 2021
 * File Name: MainMenu
 * Description: This program will open up the Game Over menu of the program, allowing 
 *              the user to play the Connect 4 game again, view stats of the previous
 *              game played, and exit the screen to the main menu.
 */

package connect4;

// import necessary classes
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.io.File;
import java.io.IOException;
import java.awt.Font;
import java.awt.FontFormatException;
import java.util.*;

/**
 *
 * @author Alex Chen
 */
public class GameOverMenu extends JFrame implements ActionListener {
    
    // Declare variables:
    int player1Wins, player2Wins, numTies;      // Variables for storing # of P1 wins, P2 wins, and ties (respectively) in the game just played
    ArrayList<String> gamesResult = new ArrayList<>();      // ArrayList for storing winner of each round in previous game
    ArrayList<Integer> gamesTurns = new ArrayList<>();      // ArrayList for storing # of turns taken by the winner per round in previous game
            
    // Create JLabels to store images
    JLabel lblBackground = new JLabel();        // JLabel storing background image
    JLabel lblGameOver = new JLabel();          // JLabel storing game's logo
    
    // Create JTextArea (with 8 rows & 22 columns) to display information on the game just played
    JTextArea txtAreaGameInfo = new JTextArea();    // JLabel for displaying text listing game info
    JTextArea txtAreaWinner = new JTextArea();      // JLabel for displaying text stating the winner 
    JTextArea txtAreaHighScores = new JTextArea();  // JLabel for displaying text listing high scores (least # of turns taken)
    
    // Create new font for JTextAreas
    Font fontScratch;
    
    // Create JPanel to organize JFrame elements
    JPanel pnlBtns = new JPanel();
    JPanel pnlPaddingWest = new JPanel();
    JPanel pnlPaddingNorth = new JPanel();
    JPanel pnlPaddingEast = new JPanel();
    
    JButton[] menuBtns = {new JButton("Play Again"), new JButton("Main Menu")};
    
    // Create layouts for JPanels and JFrame
    BoxLayout layoutBtns = new BoxLayout(pnlBtns, BoxLayout.Y_AXIS);
    GridBagLayout layoutPaddingEast = new GridBagLayout();          
    GridBagLayout layoutPaddingWest = new GridBagLayout();          
    GridBagLayout layoutPaddingNorth = new GridBagLayout();         
    
    // Create GridBagConstraints object to adjust GridBagLayout "layoutPaddingNorth"
    GridBagConstraints constraintsNorth = new GridBagConstraints();
    
    // Constant to store menu button dimensions
    final Dimension MENU_BTN_SIZE = new Dimension(415, 135);               // size of each individual button
    final Dimension MENU_GAME_INFO_SIZE = new Dimension(600, 600);         // size of each JTextArea containing game info
    final Dimension MENU_PADDING_WEST = new Dimension(710, 690);           // size of west JPanel containing left JTextArea
    final Dimension MENU_PADDING_EAST = new Dimension(710, 690);           // size of east JPanel containing right JTextArea
    final Dimension MENU_PADDING_NORTH = new Dimension(1920, 390);         // size of top JPanel containing Game Over image
    
    // Import images for background and game over picture
    ImageIcon background = new ImageIcon("MenuBackgroundDark.png");
    ImageIcon gameOver = new ImageIcon("Game Over.png");
    
    // Import images in ImageIcon arrays for each button in their different states (normal states, pressed states, and mouse hover states)
    ImageIcon[] imgMenuBtns = {new ImageIcon("ButtonPlayAgain.png"), new ImageIcon("ButtonMainMenu.png")};
    ImageIcon[] imgMenuBtnsPressed = {new ImageIcon("ButtonPlayAgainDown.png"), new ImageIcon("ButtonMainMenuDown.png")};
    ImageIcon[] imgMenuBtnsRollover = {new ImageIcon("ButtonPlayAgainHover.png"), new ImageIcon("ButtonMainMenuHover.png")};    
    
    public GameOverMenu (int _player1Wins, int _player2Wins, int _numTies, ArrayList<String> _gamesResult, ArrayList<Integer> _gamesTurns) {
        // Set up details of main JFrame
        super ("Connect 4 | Game Over Menu");   // sets name of window to "Connect 4 | Game Over Menu"
        setSize(1920, 1080);                    // sets dimensions of window to 1080p
        setLocationRelativeTo(null);            // centers program window
        setResizable(false);                    // sets window to not be resizable        
        setLayout(new BorderLayout(0, 0));      // uses Border Layout for frame
        
        // Initialize variables keeping track of wins, ties, and high scores with arguments used to create GameOverMenu object
        player1Wins = _player1Wins;             // variable for # of player 1 wins
        player2Wins = _player2Wins;             // variable for # of player 2 wins
        numTies = _numTies;                     // variable for # of ties
        gamesResult = _gamesResult;             // arraylist for storing winners of each game
        gamesTurns = _gamesTurns;               // arraylist for storing # of turns per game
        
        // Register custom font "Scratch" to graphics environment
        try {
            // Create new GraphicsEnvironment object
            GraphicsEnvironment graphics = GraphicsEnvironment.getLocalGraphicsEnvironment();
            // Add custom font to GraphicsEnvironment object
            fontScratch = Font.createFont(Font.TRUETYPE_FONT, new File("Fonts\\Scratch_.ttf")).deriveFont(Font.PLAIN, 40f);
            
            graphics.registerFont(fontScratch);
        } catch (IOException | FontFormatException e) {          // If there is an issue with adding custom font to GraphicsEnvironment object...
            // Show popup window notifying user of an error with the font file.
            JOptionPane.showMessageDialog(this, "NOTICE: The font file \"Scratch_.ttf\" was moved, or there were some errors with formatting the font. Switching to default font \"Arial\"...");
            // Sets the custom font to be Arial
            fontScratch = new Font("Arial", Font.PLAIN, 20);
        }
        
        // Set up dimensions for layoutPaddingNorth within constraintsNorth object
        constraintsNorth.gridwidth = 1;            // Number of columns
        constraintsNorth.gridheight = 2;           // Number of rows
        constraintsNorth.gridx = 0;                
        constraintsNorth.gridy = 0;
        
        // Set background of JFrame to Jlabel w/ image "background"
        lblBackground.setIcon(background);
        lblBackground.setLayout(new BorderLayout());      // Set to BorderLayout in order to display img (does not display with "null" layout)
        setContentPane(lblBackground);                    // Set background Jlabel to screen
        
        // Set JPanel for buttons to BoxLayout "layoutBtns"
        pnlBtns.setLayout(layoutBtns);
        pnlBtns.setOpaque(false);                     // Make empty space in button Jpanel transparent
        pnlBtns.add(Box.createVerticalStrut(150));    
        
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
                pnlBtns.add(Box.createVerticalStrut(60));
            }
        }
        
        add(pnlBtns, BorderLayout.CENTER);
        
        // Set up text area for high scores leaderboard and padding on the right of menu buttons
        txtAreaHighScores.setText(txtHighScores(gamesResult, gamesTurns));                 
        txtAreaHighScores.setFont(fontScratch);

        txtAreaHighScores.setOpaque(false);
        txtAreaHighScores.setForeground(Color.WHITE);
        txtAreaHighScores.setSize(MENU_GAME_INFO_SIZE);
        txtAreaHighScores.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
        
        pnlPaddingEast.setLayout(layoutPaddingEast);               
        pnlPaddingEast.setPreferredSize(MENU_PADDING_EAST);        
        
        pnlPaddingEast.add(txtAreaHighScores);
        
        pnlPaddingEast.setOpaque(false);                           // set background of east panel in box layout to be transparent
        add(pnlPaddingEast, BorderLayout.EAST);                    // add east panel to JFrame box layout
        
        // Set up text area for overall stats and padding on the left of menu buttons
        txtAreaGameInfo.setText(txtGameInfo(player1Wins, player2Wins, numTies, gamesTurns));                 // txtGameInfo(player1Wins, player2Wins, numTies)
        txtAreaGameInfo.setFont(fontScratch);
          
        txtAreaGameInfo.setOpaque(false);
        txtAreaGameInfo.setForeground(Color.WHITE);
        txtAreaGameInfo.setSize(MENU_GAME_INFO_SIZE);
        
        pnlPaddingWest.setLayout(layoutPaddingWest);
        pnlPaddingWest.setPreferredSize(MENU_PADDING_WEST);
        
        pnlPaddingWest.add(txtAreaGameInfo);
        
        pnlPaddingWest.setOpaque(false);             // set background of west panel in box layout to be transparent
        add(pnlPaddingWest, BorderLayout.WEST);      // add west panel to JFrame box layout
        
        // Set up game over icon, winner message, and padding above menu buttons
        lblGameOver.setIcon(gameOver);
        
        txtAreaWinner.setText(txtWinner(player1Wins, player2Wins));
        txtAreaWinner.setFont(fontScratch);
        txtAreaWinner.setForeground(Color.WHITE);
        txtAreaWinner.setOpaque(false);
        
        // Set north panel of JFrame BoxLayout to follow set layout "layoutPaddingNorth"
        pnlPaddingNorth.setLayout(layoutPaddingNorth);
        pnlPaddingNorth.setPreferredSize(MENU_PADDING_NORTH);       // set preferred size of panel to prebuilt dimensions for that panel 
        
        // Set "constraintsNorth" constraints to lblGameOver and add to pnlPaddingNorth
        layoutPaddingNorth.setConstraints(lblGameOver, constraintsNorth);      // Set lblGameOver to follow constraints for layoutPaddingNorth
        pnlPaddingNorth.add(lblGameOver);
        
        // Modify constraints for layoutPaddingNorth to place txtAreaWinner below lblGameOver
        constraintsNorth.gridy = 20;
        constraintsNorth.anchor = GridBagConstraints.PAGE_END;
        
        // Set "constraintsNorth" constraints to txtAreaWinner and add to pnlPaddingNorth
        layoutPaddingNorth.setConstraints(txtAreaWinner, constraintsNorth);    // Set txtAreaWinner to follow constraints for layoutPaddingNorth
        pnlPaddingNorth.add(txtAreaWinner);
        
        pnlPaddingNorth.setOpaque(false);         // set background of north panel in box layout to be transparent
        add(pnlPaddingNorth, BorderLayout.NORTH); //add north panel to JFrame box layout
    }

    /**
     * Method that detects any activity with the menu buttons and calls the 
     * respective function (based on what button is pressed).
     * 
     * @param ae Parameter storing the action performed
     */
    @Override
    public void actionPerformed(ActionEvent ae) {
        if (ae.getActionCommand().equals("Play Again")) {
            playAgain();
        } else if (ae.getActionCommand().equals("Main Menu")) {
            mainMenu();
        }
        
    }
    
    /**
     * Method that takes three integer values representing the # of P1 wins, P2
     * wins, and ties, then returns a string to output within the JTextArea
     * left of the menu buttons in the GUI.
     * 
     * @param winsP1 # of P1 wins
     * @param winsP2 # of P2 wins
     * @param ties # of total ties
     * @return String containing game info formatted for the JTextArea "txtAreaGameInfo"
     */
    private String txtGameInfo (int winsP1, int winsP2, int ties, ArrayList<Integer> scoreTurns) {
        // String for storing output and top score for least # of turns
        String output, topScore;
        
        // If score arraylist is empty, default topScore to "N/A"
        if (scoreTurns.isEmpty()) {
            topScore = "N/A" + "\n";
        } else {      // Otherwise, get top score from arraylist
            topScore = scoreTurns.get(0) + "\n";
        }
        
        // Store output for statistics and return "output"
        output = "======= STATISTICS ========\n" 
                + "Player 1 Wins: " + winsP1 + "\n"
                + "Player 2 Wins: " + winsP2 + "\n"
                + "Number of Ties: " + ties + "\n"
                + "Least Turns Taken in a Game: " + topScore
                + "========================";
        return output;
    }
    
    /**
     * Method that takes two ArrayLists for the winner of each round and the # of turns taken
     * per game, and returns output for the leaderboard.
     * 
     * @param scoreWinners
     * @param scoreTurns
     * @return 
     */
    private String txtHighScores (ArrayList<String> scoreWinners, ArrayList<Integer> scoreTurns) {
        int numScores;     // Stores number of scores to display
        String output;     // Stores string output to return
        
        // Adds "High Score" header to output
        output = "======= HIGH SCORES ======="; 
        
        // Determines the number of scores to display on the leaderboard
        if (scoreTurns.isEmpty()) {
            output += "\n(No games registered.)";
            numScores = 0;
        } else if (scoreTurns.size() < 4) {
            numScores = scoreTurns.size();
        } else {
            numScores = 4;
        }
            
        
        // For loop that cycles through given arrayLists and adds up to five scores to output
        for (int x = 0; x < numScores; x++) {
            output += "\n" + (x + 1) + ". " + scoreWinners.get(x) + ": " + scoreTurns.get(x) + " turns";
        }
        
        for (int y = 1; y < (4 - numScores); y++) {
            output += "\n";
        }
            
        output += "\n=========================";
        
        return output;
    }

    /**
     * Method that takes two integer values representing the # of P1 wins and P2
     * wins, then returns a string containing a message that states which player
     * is the overall winner (based on the higher # of wins).
     * 
     * @param winsP1
     * @param winsP2
     * @return 
     */
    private String txtWinner (int winsP1, int winsP2) {
        String output;
        
        if (winsP1 > winsP2) {
            output = "Player 1 wins the whole game!";
        } else if (winsP2 > winsP1) {
            output = "Player 2 wins the whole game!";
        } else {
            output = "The whole game was a tie!";
        }
        
        return output;
    }
    
    private void playAgain() {
        Connect4BoardGame myGame = new Connect4BoardGame();
        myGame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        myGame.setVisible(true); // Displays JFrame
        this.dispose();
    }
    
    private void mainMenu() {
        MainMenu menu = new MainMenu();
        menu.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        menu.setVisible(true); // Displays JFrame
        this.dispose();
    }
    
}

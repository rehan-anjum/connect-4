/**
 * Name: Akhilesh Bandaru and Alireza Behjoee
 * Date: August 24th 2021 
 * File Name: Connect4BoardGame
 * Description: This program will generate the logic and design of the Connect 4
 *              game board.
*/

package connect4;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.Collections;
import javax.swing.Box;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import org.xml.sax.Attributes;

/**
 *
 * @author Akhilesh Bandaru, Alireza Behjoee
 */
public class Connect4BoardGame extends javax.swing.JFrame {
    
    // use arraylists to store winner and number of turns taken per game
    ArrayList<String> gamesResult = new ArrayList<>();
    ArrayList<Integer> gamesTurns = new ArrayList<>();
    
    // use 2D dimensional array for board
    int[][] check = new int[7][7];
    // use 2D dimensional array for all buttons
    JButton[][] btns = new JButton[7][7];
    // use an array to indicate how many discs are dropped in each column
    int[] load = new int[7];

// declare and initialize variables
    // a variable for determining whose turn it is
    int turn = 1;
    // a variable for determining the number of column where the last move was made
    int lastMove = -1;
    // variables for sorting the records
    int p1Turns = 0;
    int p2Turns = 0;

    // Variables for storing the number of wins for each player
    int player1Wins = 0;          // # of times Player 1 wins
    int player2Wins = 0;          // # of times Player 2 wins
    int numTies = 0;              // # of times both players reach a tie
    
    // Constant to store menu button dimensions
    final Dimension MENU_BTN_SIZE = new Dimension(360, 120);               // size of each individual button

    // use get resource method to upload the images
    ImageIcon red = new ImageIcon("Red.png");
    ImageIcon yellow = new ImageIcon("Yellow.png");
   
    ImageIcon[] imgBoardBtns = {new ImageIcon("ButtonReset.png"), new ImageIcon("ButtonEnd.png"), new ImageIcon("ButtonUndo.png"), 
        new ImageIcon("ButtonPlace.png"),  new ImageIcon("ButtonPlace.png"), new ImageIcon("ButtonPlace.png"), new ImageIcon("ButtonPlace.png"), 
        new ImageIcon("ButtonPlace.png"), new ImageIcon("ButtonPlace.png"), new ImageIcon("ButtonPlace.png"), new ImageIcon("ButtonRecords.png")};
    ImageIcon[] imgBoardBtnsPressed = {new ImageIcon("ButtonResetDown.png"), new ImageIcon("ButtonEndDown.png"), 
        new ImageIcon("ButtonUndoDown.png"), new ImageIcon("ButtonPlaceDown.png"),  new ImageIcon("ButtonPlaceDown.png"), 
        new ImageIcon("ButtonPlaceDown.png"), new ImageIcon("ButtonPlaceDown.png"), new ImageIcon("ButtonPlaceDown.png"), 
        new ImageIcon("ButtonPlaceDown.png"), new ImageIcon("ButtonPlaceDown.png"), new ImageIcon("ButtonRecordsDown.png")};
    ImageIcon[] imgBoardBtnsRollover = {new ImageIcon("ButtonResetHighlighted.png"), new ImageIcon("ButtonEndHighlighted.png"), 
        new ImageIcon("ButtonUndoHighlighted.png"), new ImageIcon("ButtonPlaceHighlighted.png"),  new ImageIcon("ButtonPlaceHighlighted.png"), 
        new ImageIcon("ButtonPlaceHighlighted.png"), new ImageIcon("ButtonPlaceHighlighted.png"), new ImageIcon("ButtonPlaceHighlighted.png"), 
        new ImageIcon("ButtonPlaceHighlighted.png"), new ImageIcon("ButtonPlaceHighlighted.png"), new ImageIcon("ButtonRecordsHighlighted.png")};
    ImageIcon logo = new ImageIcon("Connect4Logo_small.png");
    
    // Import images for background, logos, and buttons
    ImageIcon background = new ImageIcon("MenuBackgroundLight.png");
     // Create JLabels to store images
    JLabel lblBackground = new JLabel();        // JLabel storing background image
    
    JButton[] topButtons = null;
    
    String player1Turn = "Player 1's turn.";
    String player2Turn = "Player 2's turn.";
     

    /**
     * Creates new form Connect4BoardGame
     */
    public Connect4BoardGame() {
        super ("Connect 4 | Game Board");
        setSize(1920, 1080);
        setLocationRelativeTo(null);            // centers program window
        setResizable(false);                    // sets window to not be resizable        
        setLayout(new BorderLayout(0, 0));      // uses Border Layout for frame
        
        // Set background of JFrame to Jlabel w/ image "background"
        lblBackground.setIcon(background);
        lblBackground.setLayout(new BorderLayout());      // Set to BorderLayout in order to display img (does not display with "null" layout)
        setContentPane(lblBackground);          
        for(int i = 0; i < 7; i++)
        {
            load[i] = 0;
            for(int j = 0; j < 7; j++)
            {
                check[i][j] = 0;
            }
        }
        initComponents();
        btns[0][0] = btn1;
        btns[0][1] = btn8;
        btns[0][2] = btn15;
        btns[0][3] = btn22;
        btns[0][4] = btn29;
        btns[0][5] = btn36;
        btns[0][6] = btn43;
        btns[1][0] = btn2;
        btns[1][1] = btn9;
        btns[1][2] = btn16;
        btns[1][3] = btn23;
        btns[1][4] = btn30;
        btns[1][5] = btn37;
        btns[1][6] = btn44;
        btns[2][0] = btn3;
        btns[2][1] = btn10;
        btns[2][2] = btn17;
        btns[2][3] = btn24;
        btns[2][4] = btn31;
        btns[2][5] = btn38;
        btns[2][6] = btn45;
        btns[3][0] = btn4;
        btns[3][1] = btn11;
        btns[3][2] = btn18;
        btns[3][3] = btn25;
        btns[3][4] = btn32;
        btns[3][5] = btn39;
        btns[3][6] = btn46;
        btns[4][0] = btn5;
        btns[4][1] = btn12;
        btns[4][2] = btn19;
        btns[4][3] = btn26;
        btns[4][4] = btn33;
        btns[4][5] = btn40;
        btns[4][6] = btn47;
        btns[5][0] = btn6;
        btns[5][1] = btn13;
        btns[5][2] = btn20;
        btns[5][3] = btn27;
        btns[5][4] = btn34;
        btns[5][5] = btn41;
        btns[5][6] = btn48;
        btns[6][0] = btn7;
        btns[6][1] = btn14;
        btns[6][2] = btn21;
        btns[6][3] = btn28;
        btns[6][4] = btn35;
        btns[6][5] = btn42;
        btns[6][6] = btn49;
        
        topButtons = new JButton[]{resetButton, endButton, undoButton, placeb1, placeb2, placeb3, placeb4, placeb5, placeb6, placeb7, recordBtn};
        
        for (int x = 0; x < topButtons.length; x++) {
            topButtons[x].setSize(MENU_BTN_SIZE);
            topButtons[x].setMinimumSize(MENU_BTN_SIZE);
            topButtons[x].setMaximumSize(MENU_BTN_SIZE);
            topButtons[x].setPreferredSize(MENU_BTN_SIZE);
            
            
            topButtons[x].setIcon(imgBoardBtns[x]);
            topButtons[x].setPressedIcon(imgBoardBtnsPressed[x]);
            topButtons[x].setRolloverIcon(imgBoardBtnsRollover[x]);
            topButtons[x].setOpaque(false);
            topButtons[x].setContentAreaFilled(false);
            topButtons[x].setBorderPainted(false);
            
            
            
            topButtons[x].setAlignmentX(Component.CENTER_ALIGNMENT);
            

        }
        jLabel5.setIcon(logo);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btn1 = new javax.swing.JButton();
        btn2 = new javax.swing.JButton();
        btn3 = new javax.swing.JButton();
        btn4 = new javax.swing.JButton();
        btn5 = new javax.swing.JButton();
        btn6 = new javax.swing.JButton();
        btn7 = new javax.swing.JButton();
        btn8 = new javax.swing.JButton();
        btn9 = new javax.swing.JButton();
        btn10 = new javax.swing.JButton();
        btn11 = new javax.swing.JButton();
        btn12 = new javax.swing.JButton();
        btn13 = new javax.swing.JButton();
        btn14 = new javax.swing.JButton();
        btn15 = new javax.swing.JButton();
        btn16 = new javax.swing.JButton();
        btn17 = new javax.swing.JButton();
        btn18 = new javax.swing.JButton();
        btn19 = new javax.swing.JButton();
        btn20 = new javax.swing.JButton();
        btn21 = new javax.swing.JButton();
        btn22 = new javax.swing.JButton();
        btn23 = new javax.swing.JButton();
        btn24 = new javax.swing.JButton();
        btn26 = new javax.swing.JButton();
        btn27 = new javax.swing.JButton();
        btn28 = new javax.swing.JButton();
        btn29 = new javax.swing.JButton();
        btn30 = new javax.swing.JButton();
        btn31 = new javax.swing.JButton();
        btn32 = new javax.swing.JButton();
        btn33 = new javax.swing.JButton();
        btn34 = new javax.swing.JButton();
        btn35 = new javax.swing.JButton();
        btn36 = new javax.swing.JButton();
        btn37 = new javax.swing.JButton();
        btn38 = new javax.swing.JButton();
        btn39 = new javax.swing.JButton();
        btn40 = new javax.swing.JButton();
        btn41 = new javax.swing.JButton();
        btn42 = new javax.swing.JButton();
        btn43 = new javax.swing.JButton();
        btn44 = new javax.swing.JButton();
        btn45 = new javax.swing.JButton();
        btn46 = new javax.swing.JButton();
        btn47 = new javax.swing.JButton();
        btn48 = new javax.swing.JButton();
        undoButton = new javax.swing.JButton();
        resetButton = new javax.swing.JButton();
        endButton = new javax.swing.JButton();
        txt1 = new javax.swing.JTextField();
        txt2 = new javax.swing.JTextField();
        txt3 = new javax.swing.JTextField();
        placeb1 = new javax.swing.JButton();
        placeb2 = new javax.swing.JButton();
        placeb3 = new javax.swing.JButton();
        placeb4 = new javax.swing.JButton();
        placeb5 = new javax.swing.JButton();
        placeb6 = new javax.swing.JButton();
        placeb7 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        btn49 = new javax.swing.JButton();
        btn25 = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jLabel6 = new javax.swing.JLabel();
        recordBtn = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setMaximumSize(null);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btn1.setMaximumSize(null);
        getContentPane().add(btn1, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 290, 75, 75));

        btn2.setMaximumSize(null);
        getContentPane().add(btn2, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 290, 75, 75));

        btn3.setMaximumSize(null);
        getContentPane().add(btn3, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 290, 75, 75));

        btn4.setMaximumSize(null);
        getContentPane().add(btn4, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 290, 75, 75));

        btn5.setMaximumSize(null);
        getContentPane().add(btn5, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 290, 75, 75));

        btn6.setMaximumSize(null);
        getContentPane().add(btn6, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 290, 75, 75));

        btn7.setMaximumSize(null);
        getContentPane().add(btn7, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 290, 75, 75));

        btn8.setMaximumSize(null);
        getContentPane().add(btn8, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 370, 75, 75));

        btn9.setMaximumSize(null);
        getContentPane().add(btn9, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 370, 75, 75));

        btn10.setMaximumSize(null);
        getContentPane().add(btn10, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 370, 75, 75));

        btn11.setMaximumSize(null);
        getContentPane().add(btn11, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 370, 75, 75));

        btn12.setMaximumSize(null);
        getContentPane().add(btn12, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 370, 75, 75));

        btn13.setMaximumSize(null);
        getContentPane().add(btn13, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 370, 75, 75));

        btn14.setMaximumSize(null);
        getContentPane().add(btn14, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 370, 75, 75));

        btn15.setMaximumSize(null);
        getContentPane().add(btn15, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 450, 75, 75));

        btn16.setMaximumSize(null);
        getContentPane().add(btn16, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 450, 75, 75));

        btn17.setMaximumSize(null);
        getContentPane().add(btn17, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 450, 75, 75));

        btn18.setMaximumSize(null);
        getContentPane().add(btn18, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 450, 75, 75));

        btn19.setMaximumSize(null);
        getContentPane().add(btn19, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 450, 75, 75));

        btn20.setMaximumSize(null);
        getContentPane().add(btn20, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 450, 75, 75));

        btn21.setMaximumSize(null);
        getContentPane().add(btn21, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 450, 75, 75));

        btn22.setMaximumSize(null);
        getContentPane().add(btn22, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 530, 75, 75));

        btn23.setMaximumSize(null);
        getContentPane().add(btn23, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 530, 75, 75));

        btn24.setMaximumSize(null);
        getContentPane().add(btn24, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 530, 75, 75));

        btn26.setMaximumSize(null);
        getContentPane().add(btn26, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 530, 75, 75));

        btn27.setMaximumSize(null);
        getContentPane().add(btn27, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 530, 75, 75));

        btn28.setMaximumSize(null);
        getContentPane().add(btn28, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 530, 75, 75));

        btn29.setMaximumSize(null);
        getContentPane().add(btn29, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 610, 75, 75));

        btn30.setMaximumSize(null);
        getContentPane().add(btn30, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 610, 75, 75));

        btn31.setMaximumSize(null);
        getContentPane().add(btn31, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 610, 75, 75));

        btn32.setMaximumSize(null);
        getContentPane().add(btn32, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 610, 75, 75));

        btn33.setMaximumSize(null);
        getContentPane().add(btn33, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 610, 75, 75));

        btn34.setMaximumSize(null);
        getContentPane().add(btn34, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 610, 75, 75));

        btn35.setMaximumSize(null);
        getContentPane().add(btn35, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 610, 75, 75));

        btn36.setMaximumSize(null);
        getContentPane().add(btn36, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 690, 75, 75));

        btn37.setMaximumSize(null);
        getContentPane().add(btn37, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 690, 75, 75));

        btn38.setMaximumSize(null);
        getContentPane().add(btn38, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 690, 75, 75));

        btn39.setMaximumSize(null);
        getContentPane().add(btn39, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 690, 75, 75));

        btn40.setMaximumSize(null);
        getContentPane().add(btn40, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 690, 75, 75));

        btn41.setMaximumSize(null);
        getContentPane().add(btn41, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 690, 75, 75));

        btn42.setMaximumSize(null);
        getContentPane().add(btn42, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 690, 75, 75));

        btn43.setMaximumSize(null);
        getContentPane().add(btn43, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 770, 75, 75));

        btn44.setMaximumSize(null);
        getContentPane().add(btn44, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 770, 75, 75));

        btn45.setMaximumSize(null);
        getContentPane().add(btn45, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 770, 75, 75));

        btn46.setMaximumSize(null);
        getContentPane().add(btn46, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 770, 75, 75));

        btn47.setMaximumSize(null);
        getContentPane().add(btn47, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 770, 75, 75));

        btn48.setMaximumSize(null);
        getContentPane().add(btn48, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 770, 75, 75));

        undoButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                undoButtonActionPerformed(evt);
            }
        });
        getContentPane().add(undoButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 20, -1, -1));

        resetButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                resetButtonActionPerformed(evt);
            }
        });
        getContentPane().add(resetButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 20, -1, -1));

        endButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                endButtonActionPerformed(evt);
            }
        });
        getContentPane().add(endButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 20, -1, -1));

        txt1.setEditable(false);
        txt1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txt1.setText("0");
        getContentPane().add(txt1, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 190, 142, 20));

        txt2.setEditable(false);
        txt2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txt2.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt2.setText("Player 1's turn.");
        getContentPane().add(txt2, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 190, 120, 20));

        txt3.setEditable(false);
        txt3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txt3.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        txt3.setText("0");
        getContentPane().add(txt3, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 190, 142, 20));

        placeb1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn1ActionPerformed(evt);
            }
        });
        getContentPane().add(placeb1, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 220, 75, -1));

        placeb2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn2ActionPerformed(evt);
            }
        });
        getContentPane().add(placeb2, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 220, 75, -1));

        placeb3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn3ActionPerformed(evt);
            }
        });
        getContentPane().add(placeb3, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 220, 75, -1));

        placeb4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn4ActionPerformed(evt);
            }
        });
        getContentPane().add(placeb4, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 220, 75, -1));

        placeb5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn5ActionPerformed(evt);
            }
        });
        getContentPane().add(placeb5, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 220, 75, -1));

        placeb6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn6ActionPerformed(evt);
            }
        });
        getContentPane().add(placeb6, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 220, 75, -1));

        placeb7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn7ActionPerformed(evt);
            }
        });
        getContentPane().add(placeb7, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 220, 75, -1));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 51, 51));
        jLabel1.setText("Player1 Win Count");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 150, -1, -1));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(51, 51, 255));
        jLabel2.setText("Message Box");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 150, 126, 20));

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 153, 0));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel3.setText("Player2 Win Count");
        jLabel3.setToolTipText("");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 150, 183, 20));
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(872, 694, -1, -1));
        getContentPane().add(btn49, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 770, 75, 75));
        getContentPane().add(btn25, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 530, 75, 75));

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 3)); // NOI18N
        jLabel5.setText("Test");
        jLabel5.setToolTipText("");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 850, -1, -1));

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane1.setViewportView(jTextArea1);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 370, 270, 240));

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel6.setText("Game Stats (winner & # of turns taken):");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 330, -1, -1));

        recordBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                recordBtnActionPerformed(evt);
            }
        });
        getContentPane().add(recordBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 640, -1, -1));

        setSize(new java.awt.Dimension(1077, 1026));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    // reset button resets everything from buttons and text fields to their default state
    private void resetButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_resetButtonActionPerformed
       
        // set p1turns and p2turns to zero
        p1Turns = 0;
        p2Turns = 0;
        // clear the gameResults and turnResults
        gamesResult.clear();
        gamesTurns.clear();
        
        for (int i = 0; i < 7; i++) {
            // set load to zero
            load[i] = 0;
            for (int j = 0; j < 7; j++) {
                // set check to zero
                check[i][j] = 0;
            }
        }
        //set return to 1 so p1 can play first       
        turn = 1;
        // set lastmove to its first state
        lastMove = -1;

        for (int i = 0; i < 7; i++) {
            for (int j = 0; j < 7; j++) {
                // clear the buttons 
                btns[i][j].setIcon(null);
            }
        }
        // clear the textfields and set them to zero
        txt1.setText("0");
        txt3.setText("0");
        // Reset variables holding # of wins for each player to 0
        player1Wins = 0;
        player2Wins = 0;
        numTies = 0;
        // display Player 1's turn
        txt2.setText(player1Turn);
    }//GEN-LAST:event_resetButtonActionPerformed

     //undo buttons allows player to reserve mistakes they make during play
    private void undoButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_undoButtonActionPerformed
        
        // use if statement to check whether a user has dropped a disc
        if (lastMove >= 0) {
            // reduce the last disc which was dropped by the last player
            load[lastMove]--;
            // find the last move which was done by the last player and set it to zero
            check[lastMove][6 - load[lastMove]] = 0;
            // clear the button where the last move was made
            btns[lastMove][6 - load[lastMove]].setIcon(null);
            // if Player 1 drops a disc
            if (turn == 1) {
                // Player 2 should drop a disk
                turn = 2;
                // display Player 2's turn
                txt2.setText(player2Turn);
            } // if Player 1 doesn't drop a disc
            else {
                // Player 1 should drop a disk
                turn = 1;
                // display Player 1's turn
                txt2.setText(player1Turn);
            }
            lastMove = -1;
        }
    }//GEN-LAST:event_undoButtonActionPerformed

    private void endButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_endButtonActionPerformed
        GameOverMenu menuGameOver = new GameOverMenu(player1Wins, player2Wins, numTies, gamesResult, gamesTurns);
        menuGameOver.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        menuGameOver.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_endButtonActionPerformed

    private void btn1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn1ActionPerformed
        
        // check if columns are filled
        if (load[0] < 7) {
            //set last move to 2
            lastMove = 0;
            // "check" and "turn" variables should be equal to determine a player's turn
            check[0][6 - load[0]] = turn;
            // if Player 1 drops a disk
            if (turn == 1) {
                
                p1Turns++;
                // p2 should drop a disk
                turn = 2;
                // display Player 2's turn to the text field
                txt2.setText(player2Turn);
                 // place the red disc to the hole
                btns[0][6 - load[0]].setIcon(red);
            } else {
                
                p2Turns++;
                // Player 1 should drop a disk
                turn = 1;
                // display Player 1's turn to the text field
                txt2.setText(player1Turn);
                // place the yellow disc to the hole     
                btns[0][6 - load[0]].setIcon(yellow);
            }
            load[0]++;
        }
        // check if connect 4 is reached
        checkWinner();
    }//GEN-LAST:event_btn1ActionPerformed

    private void btn2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn2ActionPerformed
         
        // check if columns are filled
        if (load[1] < 7) {
            //set last move to 2
            lastMove = 1;
            // "check" and "turn" variables should be equal to determine a player's turn
            check[1][6 - load[1]] = turn;
            // if Player 1 drops a disk
            if (turn == 1) {
                
                p1Turns++;
                // p2 should drop a disk
                turn = 2;
                // display Player 2's turn to the text field
                txt2.setText(player2Turn);
                // place the red disc to the hole
                btns[1][6 - load[1]].setIcon(red);
            } else {
                
                p2Turns++;
                // Player 1 should drop a disk
                turn = 1;
                // display Player 1's turn to the text field
                txt2.setText(player1Turn);
                // place the yellow disc to the hole
                btns[1][6 - load[1]].setIcon(yellow);
            }
            load[1]++;
        }
        // check if connect 4 is reached
        checkWinner();
    }//GEN-LAST:event_btn2ActionPerformed

    private void btn3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn3ActionPerformed
        
        // check if columns are filled
        if (load[2] < 7) {
             //set last move to 2
            lastMove = 2;
            // "check" and "turn" variables should be equal to determine a player's turn
            check[2][6 - load[2]] = turn;
            // if Player 1 drops a disk
            if (turn == 1) {
                
                p1Turns++;
                // p2 should drop a disk
                turn = 2;
                // display Player 2's turn to the text field
                txt2.setText(player2Turn);
                // place the red disc to the hole
                btns[2][6 - load[2]].setIcon(red);
            } else {
               
                p2Turns++;
                // Player 1 should drop a disk
                turn = 1;
                // display Player 1's turn to the text field
                txt2.setText(player1Turn);
                // place the yellow disc to the hole
                btns[2][6 - load[2]].setIcon(yellow);
            }
            load[2]++;
        }
        // check if connect 4 is reached
        checkWinner();
    }//GEN-LAST:event_btn3ActionPerformed

    private void btn5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn5ActionPerformed
        
        // check if columns are filled
        if (load[4] < 7) {
            //set last move to 4
            lastMove = 4;
            // "check" and "turn" variables should be equal to determine a player's turn
            check[4][6 - load[4]] = turn;
            // if Player 1 drops a disk
            if (turn == 1) {
                
                p1Turns++;
                // p2 should drop a disk
                turn = 2;
                // display Player 2's turn to the text field
                txt2.setText(player2Turn);
                // place the red disc to the hole
                btns[4][6 - load[4]].setIcon(red);
            } else {
                
                p2Turns++;
                // Player 1 should drop a disk
                turn = 1;
                // display Player 1's turn to the text field
                txt2.setText(player1Turn);
                // place the yellow disc to the hole
                btns[4][6 - load[4]].setIcon(yellow);
            }
            load[4]++;
        }
        // check if connect 4 is reached
        checkWinner();
    }//GEN-LAST:event_btn5ActionPerformed

    private void btn6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn6ActionPerformed
        
        // check if columns are filled
        if (load[5] < 7) {
            //set last move to 5
            lastMove = 5;
            // "check" and "turn" variables should be equal to determine a player's turn
            check[5][6 - load[5]] = turn;
            // if Player 1 drops a disk
            if (turn == 1) {
                
                p1Turns++;
                // p2 should drop a disk
                turn = 2;
                // display Player 2's turn to the text field 
                txt2.setText(player2Turn);
                // place the red disc to the hole
                btns[5][6 - load[5]].setIcon(red);
            } else {
                
                p2Turns++;
                // Player 1 should drop a disk
                turn = 1;
                // display Player 1's turn to the text field
                txt2.setText(player1Turn);
                // place the yellow disc to the hole
                btns[5][6 - load[5]].setIcon(yellow);
            }
            load[5]++;
        }
        // check if connect 4 is reached
        checkWinner();
    }//GEN-LAST:event_btn6ActionPerformed

    private void btn7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn7ActionPerformed
        
        // check if columns are filled
        if (load[6] < 7) {
            //set last move to 6
            lastMove = 6;
            // "check" and "turn" variables should be equal to determine a player's turn
            check[6][6 - load[6]] = turn;
            // if Player 1 drops a disk
            if (turn == 1) {
                
                p1Turns++;
                // p2 should drop a disk
                turn = 2;
                // display Player 2's turn to the text field
                txt2.setText(player2Turn);
                // place the red disc to the hole
                btns[6][6 - load[6]].setIcon(red);
            } else {
                
                p2Turns++;
                // Player 1 should drop a disk
                turn = 1;
                // display Player 1's turn to the text field
                txt2.setText(player1Turn);
                // place the yellow disc to the hole
                btns[6][6 - load[6]].setIcon(yellow);
            }
            load[6]++;
        }
        // check if connect 4 is reached
        checkWinner();
    }//GEN-LAST:event_btn7ActionPerformed

    private void btn4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn4ActionPerformed
        
        // check if columns are filled
        if (load[3] < 7) {
            //set last move to 3
            lastMove = 3;
            // "check" and "turn" variables should be equal to determine a player's turn
            check[3][6 - load[3]] = turn;
            // if Player 1 drops a disk
            if (turn == 1) {
                
                p1Turns++;
                // p2 should drop a dis
                turn = 2;
                // display Player 2's turn to the text field
                txt2.setText(player2Turn);
                // place the red disc to the hole
                btns[3][6 - load[3]].setIcon(red);
            } else {
                
                p2Turns++;
                 // Player 1 should drop a disk
                turn = 1;
                // display Player 1's turn to the text field
                txt2.setText(player1Turn);
                // place the yellow disc to the hole
                btns[3][6 - load[3]].setIcon(yellow);
            }
            load[3]++;
        }
        // check if connect 4 is reached
        checkWinner();
    }//GEN-LAST:event_btn4ActionPerformed

    // use selection sort algorithm to display the least number of turns took to win the game to the jTextArea
    private void recordBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_recordBtnActionPerformed
        
        for(int i = 0; i <= gamesResult.size() - 2; i++)
        {
            for(int j = i + 1; j <= gamesResult.size() - 1; j++)
            {
                // use if statement to make sure that gamesTurns[i] is greater than gamesTurn[j]
                if(gamesTurns.get(i) > gamesTurns.get(j))
                {
                    // swap the entries
                    Collections.swap(gamesResult, i, j);
                    Collections.swap(gamesTurns, i, j);
                   
                }
            }
        }

        jTextArea1.setText("");
        
        for(int i = 0; i < gamesResult.size(); i++)
        {
            // use append method to add strings and also use \n to put them on a new line
            jTextArea1.append(gamesResult.get(i) + " : " + gamesTurns.get(i) + " turns" + "\n");
        }
        
    }//GEN-LAST:event_recordBtnActionPerformed

    // play again resets everything from buttons to their default state. Unlike the reset button, play again keeps results
    public void playAgain() {
       
        // set p1Turns and p2Turns to zero
        p1Turns = 0;
        p2Turns = 0;

        for (int i = 0; i < 7; i++) {
            // set load to zero
            load[i] = 0;
            for (int j = 0; j < 7; j++) {
                // set check to zero
                check[i][j] = 0;
            }
        }
        //set return to 1 so p1 can play first
        turn = 1;
        // set lastmove to its first state
        lastMove = -1;
        for (int i = 0; i < 7; i++) {
            for (int j = 0; j < 7; j++) {
                // clear the buttons
                btns[i][j].setIcon(null);
            }
        }
        // display Player 1's turn
        txt2.setText(player1Turn);
    }

    // check winner
    // we have to check four different winning possibilities (1 horizontal, 1 vertical, 2 diagonals)
    private void checkWinner() {
        for (int i = 0; i < 7; i++) {
            for (int j = 0; j < 4; j++) {
                // use if statement to check Player 1 wins the game
                if (check[i][j] == 1) {
                    // check columns for winner for Player 1
                    if (check[i][j + 1] == 1 && check[i][j + 2] == 1 && check[i][j + 3] == 1) {
                        // display a message to the screen
                        JOptionPane.showMessageDialog(this, "Player 1 Wins!");
                        // play again automatically
                        gamesTurns.add(p1Turns);
                      
                        gamesResult.add("Player 1");
                        playAgain();
                        // show the number of times Player 1 wins to the text field
                        txt1.setText(Integer.toString(Integer.parseInt(txt1.getText()) + 1));
                        // Add win to counter tracking # of wins for player 1
                        player1Wins++;
                        return;
                    }
                } // use else if statement to check Player 2 wins the game
                else if (check[i][j] == 2) {
                    // check colums for winner for Player 1
                    if (check[i][j + 1] == 2 && check[i][j + 2] == 2 && check[i][j + 3] == 2) {
                        // display a message to the screen
                        JOptionPane.showMessageDialog(this, "Player 2 Wins!");
                        // play again automatically
                        gamesTurns.add(p2Turns);
                      
                        gamesResult.add("Player 2");
                        playAgain();
                        // show the number of times Player 2 wins to the text field
                        txt3.setText(Integer.toString(Integer.parseInt(txt3.getText()) + 1));
                        // Add win to counter tracking # of wins for player 2
                        player2Wins++;
                        return;
                    }
                }
            }
        }

        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 7; j++) {
                // use if statement to check Player 1 wins the game
                if (check[i][j] == 1) {
                    // check rows for winner for Player 1
                    if (check[i + 1][j] == 1 && check[i + 2][j] == 1 && check[i + 3][j] == 1) {
                        // display a message to the screen
                        JOptionPane.showMessageDialog(this, "Player 1 Wins!");
                        // play again automatically
                        gamesTurns.add(p1Turns);
                      
                        gamesResult.add("Player 1");
                        playAgain();
                        // show the number of times Player 1 wins to the text field
                        txt1.setText(Integer.toString(Integer.parseInt(txt1.getText()) + 1));
                        // Add win to counter tracking # of wins for player 1
                        player1Wins ++;
                        return;
                    }
                } // use else statement to check Player 2 wins the game
                else if (check[i][j] == 2) {
                    // check rows for winner for Player 1
                    if (check[i + 1][j] == 2 && check[i + 2][j] == 2 && check[i + 3][j] == 2) {
                        // display a message to the screen
                        JOptionPane.showMessageDialog(this, "Player 2 Wins!");
                        // play again automatically
                        gamesTurns.add(p2Turns);
                      
                        gamesResult.add("Player 2");
                        playAgain();
                        // show the number of times Player 2 wins to the text field
                        txt3.setText(Integer.toString(Integer.parseInt(txt3.getText()) + 1));
                        // Add win to counter tracking # of wins for player 2
                        player2Wins ++;
                        return;
                    }
                }
            }
        }

        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                // use if statement to check Player 1 wins the game 
                if (check[i][j] == 1) {
                    // check diagonals for winner for Player 1
                    if (check[i + 1][j + 1] == 1 && check[i + 2][j + 2] == 1 && check[i + 3][j + 3] == 1) {
                        // display a message to the screen
                        JOptionPane.showMessageDialog(this, "Player 1 Wins!");
                        // play again automatically
                        gamesTurns.add(p1Turns);
                       
                        gamesResult.add("Player 1");
                        playAgain();
                        // show the number of times Player 1 wins to the text field
                        txt1.setText(Integer.toString(Integer.parseInt(txt1.getText()) + 1));
                        // Add win to counter tracking # of wins for player 1
                        player1Wins ++;
                        return;
                    }
                } //use else statement to check Player 2 wins the game
                else if (check[i][j] == 2) {
                    // check diagonals for winner for Player 2
                    if (check[i + 1][j + 1] == 2 && check[i + 2][j + 2] == 2 && check[i + 3][j + 3] == 2) {
                        // display a message to the screen
                        JOptionPane.showMessageDialog(this, "Player 2 Wins!");
                        // play again automatically
                        gamesTurns.add(p2Turns);
                     
                        gamesResult.add("Player 2");
                        playAgain();
                        // show the number of times Player 2 wins to the text field
                        txt3.setText(Integer.toString(Integer.parseInt(txt3.getText()) + 1));
                        // Add win to counter tracking # of wins for player 2
                        player2Wins ++;
                        return;
                    }
                }
            }
        }

        for (int i = 3; i < 7; i++) {
            for (int j = 0; j < 4; j++) {
                // use if statement to check Player 1 wins the game
                if (check[i][j] == 1) {
                    // check diagonals for winner for Player 1
                    if (check[i - 1][j + 1] == 1 && check[i - 2][j + 2] == 1 && check[i - 3][j + 3] == 1) {
                        // display a message to the screen
                        JOptionPane.showMessageDialog(this, "Player 1 Wins!");
                        // play again automatically
                        gamesTurns.add(p1Turns);
                       
                        gamesResult.add("Player 1");
                        playAgain();
                        // show the number of times Player 1 wins to the text field
                        txt1.setText(Integer.toString(Integer.parseInt(txt1.getText()) + 1));
                        // Add win to counter tracking # of wins for player 1
                        player1Wins ++;
                        return;
                    }
                } //use else statement to check Player 2 wins the game
                else if (check[i][j] == 2) {
                    // check diagonals for winner for Player 2
                    if (check[i - 1][j + 1] == 2 && check[i - 2][j + 2] == 2 && check[i - 3][j + 3] == 2) {
                         // display a message to the screen
                        JOptionPane.showMessageDialog(this, "Player 2 Wins!");
                        // play again automatically
                        gamesTurns.add(p2Turns);
                       
                        gamesResult.add("Player 2");
                        playAgain();
                        // show the number of times Player 2 wins to the text field
                        txt3.setText(Integer.toString(Integer.parseInt(txt3.getText()) + 1));
                        // Add win to counter tracking # of wins for player 2
                        player2Wins ++;
                        return;
                    }
                }
            }
        }
    
        // if coonect4 is not reached, the game will be a tie
        // decare and initialize variable 
        boolean isTie = true;
        for(int i = 0; i < 7; i++)
        {
            for(int j = 0; j < 7; j++)
            {
                // check if all buttons are filled
                if(check[i][j] == 0)
                {
                // if all buttons are filled, "check" cannot be zero so "isTie" should be false 
                    isTie = false;
                }
            }
        }
        // if "isTie" is true
        if(isTie)
        {
            // display the game is a tie 
            JOptionPane.showMessageDialog(this, "The game is a tie.");
            // Add tie to counter tracking # of ties overall
            numTies ++;
            // play again automatically
            playAgain();
            return;
        }
    
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Connect4BoardGame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Connect4BoardGame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Connect4BoardGame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Connect4BoardGame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Connect4BoardGame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn1;
    private javax.swing.JButton btn10;
    private javax.swing.JButton btn11;
    private javax.swing.JButton btn12;
    private javax.swing.JButton btn13;
    private javax.swing.JButton btn14;
    private javax.swing.JButton btn15;
    private javax.swing.JButton btn16;
    private javax.swing.JButton btn17;
    private javax.swing.JButton btn18;
    private javax.swing.JButton btn19;
    private javax.swing.JButton btn2;
    private javax.swing.JButton btn20;
    private javax.swing.JButton btn21;
    private javax.swing.JButton btn22;
    private javax.swing.JButton btn23;
    private javax.swing.JButton btn24;
    private javax.swing.JButton btn25;
    private javax.swing.JButton btn26;
    private javax.swing.JButton btn27;
    private javax.swing.JButton btn28;
    private javax.swing.JButton btn29;
    private javax.swing.JButton btn3;
    private javax.swing.JButton btn30;
    private javax.swing.JButton btn31;
    private javax.swing.JButton btn32;
    private javax.swing.JButton btn33;
    private javax.swing.JButton btn34;
    private javax.swing.JButton btn35;
    private javax.swing.JButton btn36;
    private javax.swing.JButton btn37;
    private javax.swing.JButton btn38;
    private javax.swing.JButton btn39;
    private javax.swing.JButton btn4;
    private javax.swing.JButton btn40;
    private javax.swing.JButton btn41;
    private javax.swing.JButton btn42;
    private javax.swing.JButton btn43;
    private javax.swing.JButton btn44;
    private javax.swing.JButton btn45;
    private javax.swing.JButton btn46;
    private javax.swing.JButton btn47;
    private javax.swing.JButton btn48;
    private javax.swing.JButton btn49;
    private javax.swing.JButton btn5;
    private javax.swing.JButton btn6;
    private javax.swing.JButton btn7;
    private javax.swing.JButton btn8;
    private javax.swing.JButton btn9;
    private javax.swing.JButton endButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JButton placeb1;
    private javax.swing.JButton placeb2;
    private javax.swing.JButton placeb3;
    private javax.swing.JButton placeb4;
    private javax.swing.JButton placeb5;
    private javax.swing.JButton placeb6;
    private javax.swing.JButton placeb7;
    private javax.swing.JButton recordBtn;
    private javax.swing.JButton resetButton;
    private javax.swing.JTextField txt1;
    private javax.swing.JTextField txt2;
    private javax.swing.JTextField txt3;
    private javax.swing.JButton undoButton;
    // End of variables declaration//GEN-END:variables
}
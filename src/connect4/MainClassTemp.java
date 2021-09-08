/**
 * Name: Alex Chen, Akhilesh Bandaru, Alireza Behjoee, & Syed Rehan Anjum
 * Date: August 24th, 2021 
 * File Name: MainClassTemp
 * Description: This is the file to run the program from, and was used to test
 *              out the other classes in the project; the program will create a 
 *              new MainMenu object and call it, opening the game's main menu.
 */
package connect4;

// import necessary class
import javax.swing.*;

/**
 *
 * @author Alex Chen
 */
public class MainClassTemp extends JFrame {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // Create a new MainMenu object
        MainMenu myMenu = new MainMenu();
        // Causes program to exit when window is closed
        myMenu.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // Sets JFrame for main menu to be visible
        myMenu.setVisible(true);                                
    }
    
}

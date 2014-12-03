//Josh Dyke
//CS 110
//GUI for war game

import java.util.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class myGUI extends JFrame
{
   private JPanel panel1;
   private JPanel panel2;
   private JPanel panel3;
   
   private JLabel p1Label;
   private JLabel status;
   private JLabel p2Label;
   private JLabel p1DB; 
   private JLabel p2DB;
   private JLabel p1Play;
   private JLabel p2Play; 
   private JLabel round;  
   
   private JButton startGame;
   private JButton flip;
      
   private final int WINDOW_WIDTH = 800;
   private final int WINDOW_HEIGHT = 750;
   
   private gameClass WarGame = new gameClass();
   
   //constructor
   public myGUI()
   {
      // Set this window's title
      setTitle("WAR");
      
      // Set the size of this window
      setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
      
      // Speify what happens when the close button is clicked
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      
      // Set the layout of the GUI
      setLayout(new BorderLayout());
            
      //build the pannel
      buildPanel();
      
      //add the pannel
      add(panel1, BorderLayout.WEST);
      add(panel2, BorderLayout.EAST);
      add(panel3, BorderLayout.CENTER);      
      //Display the window
      setVisible(true);
   }
   
   private void buildPanel()
   {
      //Set image for back of deck
      ImageIcon deckBackIcon = new ImageIcon("cardImages/back.jpg");
      p1DB = new JLabel(deckBackIcon);
      p2DB = new JLabel(deckBackIcon);      

      //Create player labels
      p1Label = new JLabel("Player 1");
      p2Label = new JLabel("Player 2");
      status = new JLabel(" ");
      
      
      p1Play = new JLabel("P1 Card");
      p2Play = new JLabel("P2 Card");
      

      
      startGame = new JButton("Start Game");
      startGame.addActionListener(new ButtonListener());
      
      flip =  new JButton("Flip");
      flip.addActionListener(new ButtonListener());
      
      
      // Create Panels
      panel1 = new JPanel();
      panel2 = new JPanel();
      panel3 = new JPanel();
      
      // Add player labels, flip button
      panel1.add(p1Label);
      panel1.add(p1DB);

      panel2.add(p2Label);
      panel2.add(p2DB);   

      panel3.add(startGame);
      panel3.add(flip);
      panel3.add(p1Play);
      panel3.add(p2Play);
      panel3.add(status);
   }   
   
   
   private class ButtonListener implements ActionListener
   {
      public void actionPerformed(ActionEvent e)
      {
         // Get the action command
         String actionCommand = e.getActionCommand();

         if(actionCommand.equals("Start Game"))
         {
            status.setText("Game has begun");
         }   

         if(actionCommand.equals("Flip"))
         {
            WarGame.playWar();

         }
      }
   }

   public void startGame()
   {
      System.out.println("You've Started the game!");
   }
   
   public static void main(String[]args)
   {
      myGUI g = new myGUI();  
   }
}
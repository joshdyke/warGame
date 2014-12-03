//Josh Dyke
//CS 110
//deck Class - final hw

/**
   Tester for the war game
*/

import java.util.Scanner;

public class deckTester
{
   
   public static void main(String [] args) 
   {
      //create 3 decks
      Deck deck = new Deck();   //master deck - will be split between player 1 and 2
      Deck deck1 = new Deck();  //deck for player 1
      Deck deck2 = new Deck();  //deck for player 2

      deck.freshDeck(); //add all cards to deck
      deck.shuffle();   //shuffle the new deck
      
      
      //deal decks to the 2 players
      for (int i = 0; i < 26; i++)
      {
         deck1.add(deck.dealCard());
         deck2.add(deck.dealCard());
      }

      playWar(deck1, deck2);
       
   }
   
   /**
      The playWar method determines the winner of each round.  After each rounnd
      it then adds the corresponding cards to the winners deck.  When there is a
      tie there is a war between players 1 and 2
      @param d1, d2 - decks corresponding to player 1 and 2
   */
   public static void playWar(Deck d1, Deck d2)
   {
      String input;
      int score1;    //hold the score for player 1
      int score2;    //hold the score for player 2
   
      //Create a scanner object for user input
      Scanner keyboard = new Scanner(System.in);
/*
      System.out.println("Would you like to play war?(y/n) ");

      input = keyboard.nextLine();
      char userAnswer = input.charAt(0);
*/      
      int roundNum = 0;
      //play the game until on of the 2 decks are empty
      while(!(d1.isEmpty()) && !(d2.isEmpty()))
      {
           
         //deal cards for standard rounds
         Card player1_card = d1.dealCard();
         Card player2_card = d2.dealCard();
           
         //if there is a tie deal cards for war round
         if(player1_card.equals(player2_card))
         {
            System.out.println("I DO DECLARE WAR!");
         
            Card player1_war1 = d1.dealCard();
            Card player1_war2 = d1.dealCard();
               
            Card player2_war1 = d2.dealCard();
            Card player2_war2 = d2.dealCard();
                              
               

                 
            //print results of the war dealing

            System.out.println("*******************");
            System.out.println("1:" + player1_war1.toString());
            System.out.println("1:" + player1_war2.toString());

            System.out.println("2:" + player2_war1.toString());
            System.out.println("2:" + player2_war2.toString());

              
            score1 = 0;
            score2 = 0;
                 
            //calculate winner and score for war round
            if(player1_war1.getRank() > player2_war1.getRank())
            {
                 score1 += 1;
            }
            if(player1_war1.getRank()<player2_war1.getRank())
            {
                 score2 += 1;
            }
            if(player1_war2.getRank()<player2_war2.getRank())
            {
                 score2 += 1;
            }
            if(player1_war2.getRank()>player2_war2.getRank())
            {
                 score1 += 1;
            }
                 
            //display war results
            System.out.println("Player 1 score: " + score1 + " " + "Player 2 score: " + score2);
                 
            //determine winner of war and add corresponding cards
            if(score1 > score2)
            {
                  System.out.println("Player 1 wins the war");
                  d1.add(player1_war1);
                  d1.add(player2_war1);
                  d1.add(player1_war2);
                  d1.add(player2_war2);
                  
                  d1.add(player1_card);
                  d1.add(player2_card);

                  
                  System.out.println("Player 1 has: "+d1.cardsRemaining());
                  System.out.println("Player 2 has: "+d2.cardsRemaining());
            }
            else
            {
                  System.out.println("Player 2 wins the war");
                  d2.add(player1_war1);
                  d2.add(player2_war1);
                  d2.add(player1_war2);
                  d2.add(player2_war2);
                  
                  d2.add(player1_card);
                  d2.add(player2_card);
   
                  //display the remaining cards in each players deck
                  System.out.println("Player 1 has: "+d1.cardsRemaining());
                  System.out.println("Player 2 has: "+d2.cardsRemaining());

             }
           }
           
           //determine if a player won a standard round and add corresponding cards
           else if(player1_card.getRank() > player2_card.getRank())
           {
              d1.add(player1_card);
              d1.add(player2_card);
              System.out.println("Player 1 wins round");
           }
           else if(player1_card.getRank()<player2_card.getRank())
           {
              d2.add(player1_card);
              d2.add(player2_card);
              System.out.println("Player 2 wins round");
           }
           
           //display the original round
           System.out.println("What was Played");
           System.out.println("---------------");
           System.out.println("Player 1:"+player1_card.toString());
           System.out.println("Player 2:" + player2_card.toString());
           System.out.println("---------------");           
           
           System.out.println("Player 1 has: " + d1.cardsRemaining());
           System.out.println("Player 2 has: " + d2.cardsRemaining());
   /*        
      //ask again
      System.out.println("Would you like to play another round?(y/n) ");

      input = keyboard.nextLine();
      userAnswer = input.charAt(0);
  */    
            roundNum+=1;
           
      }//end while
           
     //determine which player has won and display results
     if(d1.deckSize() > d2.deckSize())
     {
        System.out.println("Player 1 wins after " + roundNum + " rounds!");
     }
     else if (d1.deckSize() < d2.deckSize())
     {
        System.out.println("Player 2 wins after " + roundNum + " rounds!");
     }
     else
     {
         System.out.println("Did you even play?");
         System.out.println("Exiting...");
     }

   }//end playWar
   
   //allows you to display the contents of the deck
   public static void displayDeck(Deck d)
   {
      int i = 0;
      while (!(d.isEmpty()))
         System.out.println(i++ + " : " + d.dealCard().toString());

   }
}
//Josh Dyke
//CS 110
//deck Class - final hw

/**
   This class simulates the existence of a deck a playing cards
   as a form of an array list.  there is a max of 52 items in the 
   arayList.
*/

import java.util.Random;
import java.util.ArrayList;

public class Deck 
{
   final int CARDS_IN_DECK = 52;
   ArrayList<Card> deck;
   
   
   /**
      Default constuctor initializes the deck arraylist
   */
   public Deck()
   {
      deck = new ArrayList<Card>();
   }
   
   /**
      freshDeck method inicializes a new deck arraylist
      with all of the card objects.
   */
   public void freshDeck()
   {
      //create deck            
      deck = new ArrayList<Card>();
      //loop through each suit
      for (int r = Card.ACE; r<=Card.KING;r++)
      {
         //loop through each possible card
         for (int s=Card.SPADES;s<=Card.CLUBS;s++)
         {
           deck.add(new Card(r,s));
         }
      }
     
   
   }
   
   /**
      add method adds a card object to a deck arraylist
      @param c - a new card object
   */
   public void add(Card c)
   {
      deck.add(c);
   }

   /**
      dealCard method removes a card object from an deck arraylist
      @return c - the card to be removed from the deck
   */
   public Card dealCard()
   {
      Card c = deck.remove(0);  //  remove card at index 0.
                                //  returns removed card 
      return c;
   }

   /**
      returns the number of objects remaining in a deck arraylist object
      @return int value for items in the deck
   */
   public int cardsRemaining()
   {  
      return deck.size();
   }
   
   /**
      shuffle method shuffles randomly the card objects in a deck arraylist
   */
   public void shuffle()
   {
      int randNum;
      Card temp;
      Random r = new Random();
      for (int i = 0; i < deck.size(); i++)
      {
         randNum = r.nextInt(deck.size());
         temp = deck.get(i);
         deck.set(i,deck.get(randNum));
         deck.set(randNum,temp);
      }      
   }
   
   
   /**
      deckSize method 
   */   
   public int deckSize()
   {
      return deck.size();
   }
   
   /**
      isEmpty method returns true if there are no remaining 
      card objects in a deck arraylist
   */
   public boolean isEmpty()
   {
      return (deck.size() == 0);
   }

}


//Josh Dyke
//CS 110
//Card Class - final hw

/**
   The card class holds all of the data for one card
   This includes their value and suit (rank/suit)and 
   provides various methods for accessing these data
*/

public class Card 
{     
    // Constants for suits
    public final static int SPADES = 0,      
                            HEARTS = 1,
                            DIAMONDS = 2,
                            CLUBS = 3;
    // Constants for ranks.  (cards 2 through 9 have face value)
    public final static int ACE = 1,          
                            JACK = 11,        
                            QUEEN = 12,       
                            KING = 13;
                            
    // Data for card class 
    private int suit;   // holds suit of the card from those laid out above
                              
    private int rank;   // the rank of this card, from 1 to 13.
                             
   /**
      Card constructor - creates a new playing card.
      @param suit - suit value of this card.
      @param rank - rank value of this card.
   */
    public Card(int rank, int suit) 
    {
        this.rank = rank;
        this.suit = suit;
    }
    
   /**
      Copy constructor - creates a new playing card
      that is an exact copy of other card object
      @param otherCar the card to be copied
   */
    public Card(Card other) 
    {
         this.rank = other.rank;
         this.suit = other.suit;
    }
    
   /**
      getSuit - returns the suit of the card.
      @return suit - value in the suit field
   */
   public int getSuit() 
   {
      return suit;
   }

   /**
      getRank returns the rank of the card.
      @return rank - value in the rank field
   */
   public int getRank() 
   {
      return rank;
   }
    
   /**
      getSuitAsString method returns a string containing the suit of this card.
      @return the suit value of the card as a string.
   */
   public String getSuitAsString() 
   {
      // Return a String representing the card's suit.
      switch ( suit ) {
           case SPADES:   return "Spades";
           case HEARTS:   return "Hearts";
           case DIAMONDS: return "Diamonds";
           case CLUBS:    return "Clubs";
           default:       return "Invalid";      // If the card's suit is invalid, "Invalid" is returned.
      }
    }
   /**
      getRankAsString returns a description of the rank of this card.
      @return the rank value of the card as a string.
   */
   public String getRankAsString() 
   {
      switch ( rank ) {
           case 1:   return "Ace";
           case 2:   return "2";
           case 3:   return "3";
           case 4:   return "4";
           case 5:   return "5";
           case 6:   return "6";
           case 7:   return "7";
           case 8:   return "8";
           case 9:   return "9";
           case 10:  return "10";
           case 11:  return "Jack";
           case 12:  return "Queen";
           case 13:  return "King";
           default:  return "??";
      }
    }

   /**
      toString returns a description of this card as a string
      @return the name of the card.
   */
   public String toString() 
   {
      return getRankAsString() + " of " + getSuitAsString();
    }
    
   /**
      Compares two cards to determine if they have the same value.
      @param card - the other card
      @return true if the two cards have the same rank false otherwise.
   */
   public boolean equals(Card otherCard ) 
   {
      if (rank != otherCard.rank )
         return false;
      else
         return true;
   }

}
    



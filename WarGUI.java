/*******************************************************************************
 * ** Date: Mar. 7, 2007 
 * ** Name: Felicia Hendrickson 
 * ** Purpose: a Java program that plays the card game of war between 
 * two computer players
 ******************************************************************************/

import java.awt.*;
import java.util.*;
import javax.swing.*;
import javax.swing.border.*;
import java.awt.Color;

public class WarGUI extends JFrame {

	private static final long serialVersionUID = 1L;

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				WarGUI thisClass = new WarGUI();
				thisClass.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				thisClass.setVisible(true);
			}
		});

	}

	/**
	 * This method initializes ControlPanel
	 * 
	 * @return javax.swing.JPanel
	 */

	// these arrays are for the deck of cards.
	// You have have as many or as few cards as you choose.
	private String[] rank = { "2", "3", "4", "5", "6", "7", "8", "9", "t", "j",
			"q", "k", "a" };
	private String[] suit = { "s", "h", "d", "c" };
	private String[] Deck = new String[52];

	// set the background Image for the deck.
	private ImageIcon backgroundImage = new ImageIcon("cardImages/back.jpg");

	// these vectors hold the players hands
	private Vector<String> PlayerA = new Vector<String>();
	private Vector<String> PlayerB = new Vector<String>();

	// these variables keep track of the number of battles
	private int battle = 0;
	private int battleA = 0, battleB = 0;

	// GUI panels and components
	private JPanel jContentPane = null;
	private JLabel PlayerACard = null;
	private JLabel PlayerBCard = null;
	private JPanel ControlPanel = null;
	private Border blackline = BorderFactory.createLineBorder(Color.black);
	private Border raisedetched = BorderFactory
	.createEtchedBorder(EtchedBorder.RAISED);
	private Border raisedbevel = BorderFactory.createRaisedBevelBorder();
	private Border loweredbevel = BorderFactory.createLoweredBevelBorder();
	private JButton Play = null;
	private JButton Quit = null;
	private JLabel ACardsRemaining = null;
	private JLabel BCardsRemaining = null;
	private JLabel AWarSlot1 = null;
	private JLabel AWarSlot2 = null;
	private JLabel BWarSlot1 = null;
	private JLabel BWarSlot2 = null;
	private JTextArea messagebox = null;
	private JLabel jLabelA = null;
	private JLabel jLabelB = null;
	private JLabel lblRemainA = null;
	private JLabel lblRemainB = null;
	private JButton NewGame = null;

	/**
	 * This is the default constructor
	 */
	public WarGUI() {
		super();
		initialize();
	}

	// this method deals each player 26 cards
	private void dealDeck() {
		int i = 0;
		do {
			this.PlayerA.addElement(this.Deck[i]);
			this.PlayerB.addElement(this.Deck[i + 1]);
			i += 2;
		} while (i < this.Deck.length);

		// this puts the number of cards in the box underneath the players hand
		this.ACardsRemaining.setText(Integer.toString(this.PlayerA.size()));
		this.BCardsRemaining.setText(Integer.toString(this.PlayerB.size()));
	}

	// this method takes the suit and rank, then combines them into a full deck
	private void getCards() {
		int index = 0;
		for (int i = 0; i < this.suit.length; i++) {
			for (int j = 0; j < this.rank.length; j++) {
				this.Deck[index] = this.rank[j] + this.suit[i];
				index++;
			}
		}

	}

	// the panel for the game
	private JPanel getControlPanel() {
		if (this.ControlPanel == null) {
			this.ControlPanel = new JPanel();
			this.ControlPanel.setBorder(this.raisedetched);
			this.ControlPanel.setLayout(new GridBagLayout());
		}
		return this.ControlPanel;
	}

	// gets the card image when needed
	private ImageIcon getImage(String card) {
		ImageIcon cardIcon = new ImageIcon("cardImages/" + card + ".jpg");
		return cardIcon;
	}

	/**
	 * This method initializes jContentPane
	 * 
	 * @return javax.swing.JPanel
	 */
	private JPanel getJContentPane() {

		if (this.jContentPane == null) {
			// GUI panels and components
			this.jLabelA = new JLabel();
			this.jLabelA.setBounds(new Rectangle(40, 75, 100, 30));
			this.jLabelA.setText("Player A's Hand");
			this.messagebox = new JTextArea();
			this.messagebox.setBounds(new Rectangle(50, 300, 375, 100));
			this.messagebox.setText("");
			messagebox.setBackground(new Color(51, 204, 51));
			this.messagebox.setEditable(false);
			this.PlayerACard = new JLabel();
			this.PlayerACard.setText("PlayerA");
			this.PlayerACard.setBounds(new Rectangle(50, 100, 73, 97));
			this.PlayerACard.setIcon(this.backgroundImage);
			this.PlayerACard.setBorder(this.raisedbevel);
			this.AWarSlot1 = new JLabel();
			this.AWarSlot1.setBounds(new Rectangle(200, 50, 73, 97));
			this.AWarSlot1.setText("");
			this.AWarSlot1.setBackground(Color.black);
			this.AWarSlot1.setBorder(this.loweredbevel);
			this.AWarSlot2 = new JLabel();
			this.AWarSlot2.setBounds(new Rectangle(350, 50, 73, 97));
			this.AWarSlot2.setText("");
			this.AWarSlot2.setBackground(Color.black);
			this.AWarSlot2.setBorder(this.loweredbevel);
			this.ACardsRemaining = new JLabel();
			this.ACardsRemaining.setBounds(new Rectangle(60, 200, 50, 20));
			this.ACardsRemaining.setText("0");
			this.ACardsRemaining.setHorizontalAlignment(SwingConstants.CENTER);
			this.ACardsRemaining.setBorder(this.blackline);
			this.ACardsRemaining.setForeground(Color.black);
			this.lblRemainA = new JLabel();
			this.lblRemainA.setBounds(new Rectangle(40, 220, 100, 25));
			this.lblRemainA.setText("Cards Remaining");
			this.jLabelB = new JLabel();
			this.jLabelB.setBounds(new Rectangle(490, 75, 100, 30));
			this.jLabelB.setText("Player B's Hand");
			this.PlayerBCard = new JLabel();
			this.PlayerBCard.setText("PlayerB");
			this.PlayerBCard.setBounds(new Rectangle(500, 99, 73, 97));
			this.PlayerBCard.setIcon(this.backgroundImage);
			this.PlayerBCard.setBorder(this.raisedbevel);
			this.BWarSlot1 = new JLabel();
			this.BWarSlot1.setBounds(new Rectangle(200, 150, 73, 97));
			this.BWarSlot1.setText("");
			this.BWarSlot1.setBackground(Color.black);
			this.BWarSlot1.setBorder(this.loweredbevel);
			this.BWarSlot2 = new JLabel();
			this.BWarSlot2.setBounds(new Rectangle(350, 150, 73, 97));
			this.BWarSlot2.setText("");
			this.BWarSlot2.setBackground(Color.black);
			this.BWarSlot2.setBorder(this.loweredbevel);
			this.lblRemainB = new JLabel();
			this.lblRemainB.setBounds(new Rectangle(490, 220, 100, 25));
			this.lblRemainB.setText("Cards Remaining");
			this.BCardsRemaining = new JLabel();
			this.BCardsRemaining.setBounds(new Rectangle(510, 200, 50, 20));
			this.BCardsRemaining.setText("0");
			this.BCardsRemaining.setHorizontalAlignment(SwingConstants.CENTER);
			this.BCardsRemaining.setBorder(this.blackline);
			this.BCardsRemaining.setForeground(Color.black);
			this.jContentPane = new JPanel();
			this.jContentPane.setLayout(null);
			jContentPane.setBackground(new Color(51, 204, 51));
			this.jContentPane.add(this.PlayerACard);
			this.jContentPane.add(this.PlayerBCard);
			this.jContentPane.add(getControlPanel());
			this.jContentPane.add(getPlay(), null);
			this.jContentPane.add(getQuit(), null);
			this.jContentPane.add(this.ACardsRemaining, null);
			this.jContentPane.add(this.BCardsRemaining, null);
			this.jContentPane.add(this.AWarSlot1, null);
			this.jContentPane.add(this.AWarSlot2, null);
			this.jContentPane.add(this.BWarSlot1, null);
			this.jContentPane.add(this.BWarSlot2, null);
			this.jContentPane.add(this.messagebox, null);
			this.jContentPane.add(this.jLabelA, null);
			this.jContentPane.add(this.jLabelB, null);
			this.jContentPane.add(this.lblRemainA, null);
			this.jContentPane.add(this.lblRemainB, null);
			this.jContentPane.add(getNewGame(), null);
		}
		return this.jContentPane;
	}

	/**
	 * This method initializes NewGame
	 * 
	 * @return javax.swing.JButton
	 */
	private JButton getNewGame() {
		if (this.NewGame == null) {
			this.NewGame = new JButton();
			this.NewGame.setBounds(new Rectangle(450, 300, 170, 25));
			this.NewGame.grabFocus();
			this.NewGame.setText("New Game");
			this.NewGame.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {

					// initializes variables and players hands for a new game
					WarGUI.this.PlayerA.removeAllElements();
					WarGUI.this.PlayerB.removeAllElements();
					WarGUI.this.battle = 0;
					WarGUI.this.battleA = 0;
					WarGUI.this.battleB = 0;
					WarGUI.this.ACardsRemaining.setForeground(Color.black);
					WarGUI.this.BCardsRemaining.setForeground(Color.black);
					String msg = "";
					WarGUI.this.messagebox.setText(msg);
					WarGUI.this.PlayerACard.setIcon(WarGUI.this.backgroundImage);
					WarGUI.this.AWarSlot1.setIcon(null);
					WarGUI.this.AWarSlot2.setIcon(null);
					WarGUI.this.PlayerBCard.setIcon(WarGUI.this.backgroundImage);
					WarGUI.this.BWarSlot1.setIcon(null);
					WarGUI.this.BWarSlot2.setIcon(null);

					// get the cards into a new deck
					getCards();
					// shuffle the deck
					shuffle();
					// deal the deck to each player
					dealDeck();
				}
			});
		}
		return this.NewGame;
	}

	/**
	 * This method initializes Play
	 * 
	 * @return javax.swing.JButton
	 */
	private JButton getPlay() {
		if (this.Play == null) {
			this.Play = new JButton();
			this.Play.setBounds(new Rectangle(450, 350, 70, 25));
			this.Play.setText("Play");
			this.Play.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {

					// initialize each battles variables to 0 or null
					int winner = 0;
					String msg = "";
					WarGUI.this.messagebox.setText(msg);
					WarGUI.this.AWarSlot1.setIcon(null);
					WarGUI.this.AWarSlot2.setIcon(null);
					WarGUI.this.BWarSlot1.setIcon(null);
					WarGUI.this.BWarSlot2.setIcon(null);

					// if both players hands are empty, we must start a new game
					if ((WarGUI.this.PlayerA.size() == 0)
							&& (WarGUI.this.PlayerB.size() == 0)) {
						WarGUI.this.messagebox
						.setText("You must start a new game first!");
					} else if ((WarGUI.this.PlayerA.size() == 0)
							|| (WarGUI.this.PlayerB.size() == 0)) {

						// if one players cards are zero, this game is over
						// print statistics
						msg += "\nThis war had " + WarGUI.this.battle
						+ " battles.\nPlayer A won "
						+ WarGUI.this.battleA
						+ " battles.\nPlayer B won "
						+ WarGUI.this.battleB + " battles";

						// keep the text but show the winner of the game
						WarGUI.this.messagebox.setText(msg);
						if (WarGUI.this.PlayerA.size() == 0) {
							msg += "\nPlayer B wins the war!";
							WarGUI.this.messagebox.setText(msg);
						} else if (WarGUI.this.PlayerB.size() == 0) {
							msg += "\nPlayer A wins the war!";
							WarGUI.this.messagebox.setText(msg);
						}

						// remove both players hands after the game is over
						WarGUI.this.PlayerA.removeAllElements();
						WarGUI.this.PlayerB.removeAllElements();
					}

					// if both players still have cards, play a battle
					if ((WarGUI.this.PlayerA.size() != 0)
							&& (WarGUI.this.PlayerB.size() != 0)) {

						// the war method is the battle itself and returns the
						// winner
						// PlayerA is winner 1, PlayerB is winner 2
						// the winner will only be 0 if one player runs out of
						// cards
						// during a war
						winner = war();
						WarGUI.this.battle += 1;

						// if one player runs out of cards, the player with the
						// most
						// cards wins by forfeit
						if (winner == 0) {
							if (WarGUI.this.PlayerA.size() > WarGUI.this.PlayerB
									.size()) {

								// increase number of battles won by A
								WarGUI.this.battleA += 1;
								msg = "Player B forfeits this battle.";
								WarGUI.this.messagebox.setText(msg);
								WarGUI.this.PlayerB.removeAllElements();

							} else if (WarGUI.this.PlayerB.size() > WarGUI.this.PlayerA
									.size()) {

								// increase number of battles won by B
								WarGUI.this.battleB += 1;
								msg = "Player A forfeits this battle.";
								WarGUI.this.messagebox.setText(msg);
								WarGUI.this.PlayerA.removeAllElements();

							}
						} else if (winner == 1) {

							// increase number of battles won by A
							WarGUI.this.battleA += 1;

							// this will keep the current message, useful in
							// cases
							// of war
							msg = WarGUI.this.messagebox.getText();
							msg += "Player A wins battle #" + WarGUI.this.battle;
							WarGUI.this.messagebox.setText(msg);
						} else if (winner == 2) {

							// increase number of battles won by B
							WarGUI.this.battleB += 1;

							// this will keep the current message, useful in
							// cases
							// of war
							msg = WarGUI.this.messagebox.getText();
							msg += "Player B wins battle #" + WarGUI.this.battle;
							WarGUI.this.messagebox.setText(msg);
						}

						// update box showing number of cards remaining for A
						WarGUI.this.ACardsRemaining.setText(Integer
								.toString(WarGUI.this.PlayerA.size()));

						// if the number of cards is 5 or less, change the color
						// to red
						if (WarGUI.this.PlayerA.size() <= 5) {
							WarGUI.this.ACardsRemaining.setForeground(Color.red);
						} else
							WarGUI.this.ACardsRemaining
							.setForeground(Color.black);

						// update box showing number of cards remaining for B
						WarGUI.this.BCardsRemaining.setText(Integer
								.toString(WarGUI.this.PlayerB.size()));

						// if the number of cards is 5 or less, change the color
						// to red
						if (WarGUI.this.PlayerB.size() <= 5) {
							WarGUI.this.BCardsRemaining.setForeground(Color.red);
						} else
							WarGUI.this.BCardsRemaining
							.setForeground(Color.black);

					}
				}
			});
		}
		return this.Play;
	}

	/**
	 * This method initializes Quit
	 * 
	 * @return javax.swing.JButton
	 */
	private JButton getQuit() {
		if (this.Quit == null) {
			this.Quit = new JButton();
			this.Quit.setBounds(new Rectangle(550, 350, 70, 25));
			this.Quit.setText("Quit");
			this.Quit.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					// closes the program
					System.gc();
					System.exit(0);
				}
			});
		}
		return this.Quit;
	}

	// initializes the main frame
	private void initialize() {
		this.setSize(650, 450);
		this.setContentPane(getJContentPane());
		this.add(getControlPanel());
		this.setTitle("WAR");

	}

	// shuffles the deck -- this swaps random index numbers with each card
	// and performs this 5 times.
	private void shuffle() {
		int tempNum = 0;
		String tempStr = "";
		for (int shuffle = 0; shuffle < 5; shuffle++) {
			for (int x = 0; x < 52; x++) {
				tempNum = (int) Math.floor(Math.random() * 52);
				tempStr = this.Deck[tempNum];
				this.Deck[tempNum] = this.Deck[x];
				this.Deck[x] = tempStr;
			}
		}
	}

	private int war() {

		// variables to determine winner, round of war, cards played, and value
		// of them
		int win = 0;
		int pos = 0;
		int round = 1;
		Character ch1 = ' ';
		Character ch2 = ' ';
		String played1 = "";
		String played2 = "";
		int val1 = 0;
		int val2 = 0;

		// this vector holds the cards in case of war
		Vector<String> table = new Vector<String>();

		do {
			if ((pos < this.PlayerA.size()) && (pos < this.PlayerB.size())) {

				// this returns the card at the proper position
				played1 = this.PlayerA.elementAt(pos);
				played2 = this.PlayerB.elementAt(pos);

				if (pos == 0) {
					// this displays the card on the players deck
					this.PlayerACard.setIcon(getImage(played1));
					this.PlayerBCard.setIcon(getImage(played2));
				} else {
					// this displays a background
					// and the next playable card on the table in case of WAR
					this.AWarSlot1.setIcon(this.backgroundImage);
					this.AWarSlot2.setIcon(getImage(played1));
					this.BWarSlot1.setIcon(this.backgroundImage);
					this.BWarSlot2.setIcon(getImage(played2));
				}

				// returns the first character of the card to determine the
				// value
				ch1 = played1.charAt(0);
				switch (ch1) {
				case 't':
					val1 = 10;
					break;
				case 'j':
					val1 = 11;
					break;
				case 'q':
					val1 = 12;
					break;
				case 'k':
					val1 = 13;
					break;
				case 'a':
					val1 = 14;
					break;
				default:
					val1 = Integer.parseInt(ch1.toString());
				}

				// returns the first character of the card to determine the
				// value
				ch2 = played2.charAt(0);
				switch (ch2) {
				case 't':
					val2 = 10;
					break;
				case 'j':
					val2 = 11;
					break;
				case 'q':
					val2 = 12;
					break;
				case 'k':
					val2 = 13;
					break;
				case 'a':
					val2 = 14;
					break;
				default:
					val2 = Integer.parseInt(ch2.toString());

				}

				// if val1 is larger than val2, playerA wins
				if (val1 > val2) {
					win = 1;
					for (int i = 0; i <= pos; i++) {

						// add the cards to the table vector and remove them
						// from the players hand
						table.addElement(this.PlayerA.elementAt(0));
						table.addElement(this.PlayerB.elementAt(0));
						this.PlayerA.removeElementAt(0);
						this.PlayerB.removeElementAt(0);
					}
					// add the cards in the table vector to PlayerA's hand
					for (int i = 0; i < table.size(); i++) {
						this.PlayerA.addElement(table.elementAt(i));
					}

				} else if (val2 > val1) {
					// if val2 is larger than val1, playerB wins
					win = 2;
					for (int i = 0; i <= pos; i++) {
						// add the cards to the table vector and remove them
						// from the players hand
						table.addElement(this.PlayerB.elementAt(0));
						table.addElement(this.PlayerA.elementAt(0));
						this.PlayerB.removeElementAt(0);
						this.PlayerA.removeElementAt(0);
					}
					// add the cards in the table vector to PlayerA's hand
					for (int i = 0; i < table.size(); i++) {
						this.PlayerB.addElement(table.elementAt(i));
					}

				} else if (val1 == val2) {

					// in cases of a draw (WAR) print the message
					// and increase position by 2 since one card is buried.
					this.messagebox.setText("I DO DECLARE " + round
							+ " ROUND(S) OF WAR! \n");
					round += 1;
					pos += 2;
					win = 0;

				}
			} else
				// this will break if a winner is not declared in case one
				// player
				// does not have enough cards to finish a hand
				break;
		} while (win == 0);
		return win;

	}

}
/**
* Represents a Player.
*/

import java.util.ArrayList;

public class Player extends Card{

	private String name = "";
	private String printable = "";
	private Square currentPos = null;
	private ArrayList<Card> hand;

    // Constructor
	public Player(String name, String text) {
		this.name = name;
		this.printable = text;
	}

    // Returns player name
	public String getName() {
		return String.valueOf(this.name.charAt(0));
	}
	
	//Returns players current position as a Square Object.
	public Square getSquare(){
		return this.currentPos;
	}

    // Adds a card to the player's hand
	public void addCard(Card card){
		this.hand.add(card);
	}

    // Moves the player to a given tile (? i think)
	public void moveToTile(Square newTile) {
		if (currentPos != null) {
			currentPos.setObject(null);
		}
		newTile.setObject(this);
		currentPos = newTile;
	}

}

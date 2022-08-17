/**
 * Represents a Player.
 */

import java.util.ArrayList;
import java.util.List;

public class Player implements GameObject{

    private String name = "";
    private String printable = "";
    private Square currentPos = null;
    private ArrayList<Card> hand;
    private int roll;

    public List<Square> visited = new ArrayList<>();
    public Estate currEstate = null;

    // Constructor
    public Player(String name, String text) {
        this.name = name;
        this.printable = text;
    }

    public void setRoll(int r){
        this.roll = r;
    }

    public int getRoll(){
        return this.roll;
    }

    public void clearVisited(){
        visited.clear();
    }

    public void addToVisitied(Square square){
        this.visited.add(square);
    }

    // Returns player name
    public String getName() {
        return this.name;
    }
    
    public String getPrintable() {
    	return this.printable;
    }

    //Returns players current position as a Square Object.
    public Square getSquare(){
        return this.currentPos;
    }

    // Adds a card to the player's hand
    public void addCard(Card card){
        this.hand.add(card);
    }

    public String estate() {
        return "";
    }

    // Moves the player to a given tile (? i think)
    public void moveToTile(Square newTile) {
        if (currentPos != null) {
            currentPos.setObject(null);
        }
        newTile.setObject(this);
        currentPos = newTile;
    }

	@Override
	public void moveToRoom(Estate estate) {
		// TODO Auto-generated method stub
		
	}

}

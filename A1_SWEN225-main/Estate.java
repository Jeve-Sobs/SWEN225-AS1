/**
 * Represents an Estate.
 */

import java.util.ArrayList;
import java.util.Set;

public class Estate implements GameObject{

    private ArrayList<Square> estateSquares;
    private Set<Square> exitSquares;
    private String name = "";
    private String printable = "";

    // Constructor
    public Estate(String name, String text){
        this.name = name;
        this.printable = text;
    }

    // Returns estate name
    public String getName() {
        return name;
    }

    // Adds a given square to the set of exit squares (? i think)
    public void addExitSquare(Square square) {
        exitSquares.add(square);
    }

    public Boolean playerInRoom(Player p){
        for (Square square : estateSquares) {
            if (square.player != null && (square.player.toString() == p.toString())){
                return true;
            }
        }
        return false;
    }

	@Override
	public Square getSquare() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void moveToRoom(Estate estate) {
		// TODO Auto-generated method stub
		
	}
}

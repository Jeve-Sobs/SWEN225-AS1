/**
 * Represents a square from the board. add what the text representation means
 */

public class Square {

    private int row = 0;
    private int column = 0;

    private boolean reachable = false;
    private String textRepresentation;

    private Estate estate = null;
    public Player player = null;
    private Weapon weapon = null;

    // Constructor
    public Square(int row, int column, String str) {
        this.row = row;
        this.column = column;
        this.textRepresentation = str;
    }

    public void setObject(Card card){ //see if this works, otherwise change.
        if (card instanceof Player){
            this.player = (Player) card;
        }
        else if (card instanceof Estate) {
            this.estate = (Estate) card;
        }
        else if (card instanceof Weapon){
            this.weapon = (Weapon) card;
        }
    }

    public void setText(String s) {
        this.textRepresentation = s;
    }

    public void setReachable() {
        this.reachable = !reachable;
    }

    //Returns boolean depending on if this square is occupied
    public Boolean isOccupied(){
        if (estate != null || player != null || weapon != null){
            return true;
        }
        return false;
    }

    // Returns the int row position of the square in board
    public int getRow() {
        return row;
    }

    // Returns the int col position of the square in board
    public int getColumn() {
        return column;
    }

    @Override
    public String toString(){
        return textRepresentation;
    }

}
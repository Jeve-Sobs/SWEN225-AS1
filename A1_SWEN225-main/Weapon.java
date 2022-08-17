/**
 * Represents a weapon.
 */

public class Weapon implements GameObject{

    private String name = "";
    private String printable = "";
    private Square currentPos = null;

    // Constructor
    public Weapon(String name, String text ) {
        this.name = name;
        this.printable = text;
        this.currentPos = null;
    }

    // Returns the name of the weapon
    public String getName() {
        return this.name;
    }
    
    public String getPrintable() {
    	return this.printable;
    }
    
    public void moveToTile(Square newTile) {
        if (currentPos != null) {
            currentPos.setObject(null);
        }
        newTile.setObject(this);
        currentPos = newTile;
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

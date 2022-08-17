/**
* Represents a weapon.
*/

public class Weapon extends Card{

	private String name = "";
	private String printable = "";
	private Square currentPos = null;

    // Constructor
	public Weapon(String name, String text) {
		this.name = name;
		this.printable = text;
		//this.currentPos = square;
	}

    // Returns the name of the weapon
	public String getName() {
		return this.name;
	}
}

/**
 * Creates a new game by initialising the amount of players, creating cards and drawing a new board.
 * Selects solution, and initiates a dice roll for every turn.
 */

import java.util.*;

public class MurderMadness {

    private ArrayList<Card> cards;      // List of cards in game

    private Board board = null;
    private int playerNum = 0;          // Number of players in game

    // List of players, weapons and estates
    private Map<String, Player> players;
    private Map<String, Weapon> weapons;
    private Map<String, Estate> estates;

    private ArrayList<Player> playerList;
    private ArrayList<Weapon> weaponList;
    private ArrayList<Estate> estateList;

    private boolean running = true;

    // Current players turn
    private Player currentPlayer = null;

    // Solution
    private Player murderer = null;
    private Weapon murderWeapon = null;
    private Estate murderEstate = null;

    public MurderMadness(){
    	//Set up lists and maps for playing.
    	cards = new ArrayList<Card>();
    	
    	players = new HashMap<String, Player>();
    	weapons = new HashMap<String, Weapon>();
    	estates = new HashMap<String, Estate>();
    	
    	playerList = new ArrayList<Player>();
    	weaponList = new ArrayList<Weapon>();
    	estateList = new ArrayList<Estate>();
    	
    	
        setUpCards();
        setUpBoard();
        setPlayerTiles();
        
       // Collections.shuffle(players);
        solution();
        
        while(running) {
            this.currentPlayer = playerList.get(0);
            currentPlayer .setRoll(diceRoll());
            int currentRoll = currentPlayer.getRoll();
            takeTurn(currentPlayer);
        }
    }
    
	private void setUpBoard() {
		board = new Board();
	}
	
    // Asks the user to enter an amount of players, checks if the amount of players entered is valid
    public void playerSetup(){
        System.out.println("Enter Number of players: ");
        try{
            Scanner scan = new Scanner(System.in);
            playerNum = scan.nextInt();
            if(playerNum>4 || playerNum<3) throw new IllegalArgumentException();
        }catch (IllegalArgumentException e){
            System.out.println("Invalid number of players");
            playerSetup();
        }
    }

    // Creates cards for a new game
    private void setUpCards() {
        // Creates player cards
        addPlayer(new Player("Lucilla", "L"));
        addPlayer(new Player("Bert", "B"));
        addPlayer(new Player("Maline", "M"));
        addPlayer(new Player("Percy", "P"));

        // Creates weapon cards
        addWeapon(new Weapon("Broom", "b"));
        addWeapon(new Weapon("Scissors", "s"));
        addWeapon(new Weapon("Knife", "k"));
        addWeapon(new Weapon("Shovel", "S"));
        addWeapon(new Weapon("iPad", "i"));

        // Creates estate cards
        addEstate(new Estate("Haunted House", "H"));
        addEstate(new Estate("Manic Manor", "m"));
        addEstate(new Estate("Villa Celia", "V"));
        addEstate(new Estate("Peril Palace", "P"));
        addEstate(new Estate("Calamity Castle", "C"));
    }

    // Adds a new player to the list of cards
    private void addPlayer(Player player) {
        cards.add(player);
        players.put(player.getName(), player);
        playerList.add(player);
    }

    // Adds a new weapon to the list of cards
    private void addWeapon(Weapon weapon) {
        cards.add(weapon);
        weapons.put(weapon.getName(), weapon);
        weaponList.add(weapon);
    }

    // Adds a new estate to the list of cards
    private void addEstate(Estate estate) {
        cards.add((Card) estate);
        estates.put(estate.getName(), estate);
        estateList.add(estate);
    }

    // Sets the initial positions of players on the board
    private void setPlayerTiles() {
        players.get("Lucilla").moveToTile(board.getSquare(12, 23));
        players.get("Bert").moveToTile(board.getSquare(2, 15));
        players.get("Maline").moveToTile(board.getSquare(10, 2));
        players.get("Percy").moveToTile(board.getSquare(23, 10));
    }
    
	private void setWeaponTiles() {
		List<Estate> roomsLeft = new ArrayList<Estate>(estates.values());
		List<Weapon> weaponsLeft = new ArrayList<Weapon>(weapons.values());

	}

    // Randomly selects a murderer, murder weapon, and the estate the murder was held in
    private void solution() {
        Random random = new Random();
        murderer = playerList.get(random.nextInt(playerList.size()));
        murderWeapon = weaponList.get(random.nextInt(weaponList.size()));
        murderEstate = estateList.get(random.nextInt(estateList.size()));
    }

    // Combine and distribute remaining cards to players after a solution has been established
    private void distributeCards() {
        // instructions:
        // The remaining weapon, estate and character cards are then combined and distributed at random to players.
        // Some players may end up with more cards than others but only at most one more.
    }

    // Method for a player making an accusation. Returns true or false.
    public Boolean makeAccusation(){
        //need to add refutation card.
        System.out.println("It is time to make an accusation.");

        System.out.println("Who is the murderer?");
        Scanner scan = new Scanner(System.in);
        String player = scan.next();

        System.out.println("What is the murder weapon?");
        scan = new Scanner(System.in);
        String weapon = scan.next();

        System.out.println("Where was the murder?");
        scan = new Scanner(System.in);
        String estate = scan.next();

        if (player == murderer.getName() && weapon == murderWeapon.getName() && estate == murderEstate.getName()){

        }
        //need to move player and weapon to estate if not in the guessed estate.
        return false;
    }

    public Boolean GameOver(){
        return false;
    }

    // Returns a randomly generated integer from 2 six sided dice, used by players for every turn
    private int diceRoll() {
        int roll = (int)Math.floor(Math.random()*12+2);
        System.out.println("You rolled a "+roll);
        return roll;
    }

    public static void main(String[] args){
        new MurderMadness();
    }

    public void takeTurn(Player player){
        int numMoves = player.getRoll();
        int count = 0;

        while (count < numMoves){
            System.out.println("Enter number and direction: ");
            Scanner scan = new Scanner(System.in);
            int num = scan.nextInt();
            String direction = scan.next();
            if (move(player, numMoves, direction)) {
                count = count + num;
                System.out.println("Moves left: " + (player.getRoll()-count));
            }
        }
        player.clearVisited();
    }

    public boolean move(Player player, int numMoves, String direction){
        int row = player.getSquare().getRow();
        int col = player.getSquare().getColumn();
        String position = player.getName();
        boolean moveable = false;

        if (direction.equals("N")) {
            Square s = new Square(row, col-numMoves, position);
            if (board.validMove(player, s) ) {
                player.moveToTile(s);
                player.addToVisitied(s);
                moveable = true;
            }
        }

        else if (direction.equals("E")) {
            Square s = new Square(row+numMoves, col, position);
            if (board.validMove(player, s) ) {
                player.moveToTile(s);
                player.addToVisitied(s);
                moveable = true;
            }

        }

        else if (direction.equals("S")) {
            Square s = new Square(row, col+numMoves, position);
            if (board.validMove(player, s) ) {
                player.moveToTile(s);
                player.addToVisitied(s);
                moveable = true;
            }

        }

        else if (direction.equals("W")) {
            Square s = new Square(row-numMoves, col, position);
            if (board.validMove(player, s) ) {
                player.moveToTile(s);
                player.addToVisitied(s);
                moveable = true;
            }

        }
        else {
            System.out.println("Invalid Direction");
            moveable = false;
        }
        
        board.drawBoard(); 
        return moveable;
    }
}

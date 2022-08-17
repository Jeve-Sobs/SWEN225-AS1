/**
* Creates a new board for a new game, and updates the board for each round. The board consists of 24x24 squares, and
* represents the position of each four players, and the location of the five estates. There are grey areas which are
* inaccessible to players, each estate represents only one square and players must walk through the door to access each
* estate - cannot be only be accesed through the walls.
*/

public class Board {

    private Square[][] board;
    private int row = 24;
    private int col = 24;

    public Board() {
        board = new Square[row][col];
        createBoard();
        drawBoard();
    }

    // Draws the board to the user
    public void drawBoard() {
        for(int i = 0 ; i < row ; i++){
            System.out.print("|");
            for(int j = 0 ; j < col ; j++){
                System.out.print(board[i][j].toString()+"|");
            }
            System.out.println();
        }
    }

    // Creates 24x24 sqaure board
    public void createBoard() {
        addWalls();
        addDoors();
    }

    public void addWalls(){
        for(int i = 0 ; i < row ; i++){
            for(int j = 0 ; j < col ; j++){

                if((i==2 || i == 6 || i == 21 || i == 17) && ((j >1 && j<7) || (j >16 && j<22))) board[i][j]=new Square(i,j,"#");
                else if((j==2 || j == 6 || j == 21 || j == 17) && ((i >1 && i<7) || (i >16 && i<22))) board[i][j]=new Square(i,j,"#");
                else if((j==9 || j == 14) && ((i >9 && i<14))) board[i][j]=new Square(i,j,"#");
                else if((i==10 || i == 13) && ((j >9 && j<14))) board[i][j]=new Square(i,j,"#");
                else if((i==5 || i == 6 || i == 18 || i == 17) && ((j >10 && j<13))) board[i][j]=new Square(i,j,"#");
                else if((j==5 || j == 6 || j == 18 || j == 17) && ((i >10 && i<13))) board[i][j]=new Square(i,j,"#");
                else if( j == 5 && i == 6) board[i][j]=new Square(i,j,">");
                else if( j == 1 && i == 9) board[i][j]=new Square(i,j,"P");
                else board[i][j]=new Square(i,j,"_");
            }
        }
    }

    public void addDoors(){
        for(int i = 0 ; i < row ; i++){
            for(int j = 0 ; j < col ; j++){
                if( j == 5 && i == 6) board[i][j]=new Square(i,j,">");
                else if( j == 6 && i == 3) board[i][j]=new Square(i,j,">");
                else if( j == 17 && i == 5) board[i][j]=new Square(i,j,">");
                else if( j == 20 && i == 6) board[i][j]=new Square(i,j,">");
                else if( j == 3 && i == 17) board[i][j]=new Square(i,j,">");
                else if( j == 6 && i == 18) board[i][j]=new Square(i,j,">");
                else if( j == 18 && i == 17) board[i][j]=new Square(i,j,">");
                else if( j == 17 && i == 20) board[i][j]=new Square(i,j,">");
                else if( j == 1 && i == 9) board[i][j]=new Square(i,j,"P");
            }
        }
    }

    // Returns square from given row and col
    public Square getSquare(int row, int column) {
        if (board[row][column] != null) {
            return board[row][column];
        }
        return null;
    }
    
    public boolean validMove(Player p, int steps, Square s){ //param s is square the player wants to move towards.
    	if (steps <= 0){
            System.out.println("Invalid move - No more steps left.");
        }
        
        if (this.getSquare(s.getRow(), s.getColumn()).toString() == "#"){
            System.out.println("Invalid move - Cannot move through walls.");
            return false;
        }
        
        if(s.getRowsp.getSquare().getRow()){
            
        }
        
        p.moveToTile(s); //moves player to their selected tile.
        return true;
    }

}
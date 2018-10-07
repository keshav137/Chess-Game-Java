/**
 * Chess board Class
 * Contains 2D array of ChessPieces and locations of the two kings(used for detecting checks)
 * Also contains helper functions for functioning of the game
 */

public class ChessBoard {

    private ChessPiece [][] board;
    private Location player1King;
    private Location player2King;

    public ChessBoard() {
        board = new ChessPiece[8][8];
        for(int i = 0; i < 8; i++){
            for(int j = 0; j < 8; j++){
                board[i][j] = null;
            }
        }
    }

    public Location getPlayer1King() {
        return player1King;
    }

    public Location getPlayer2King() {
        return player2King;
    }

    public Location getOtherKingLocation(boolean player) {
        if(player == true) {
            return getPlayer2King();
        }
        else {
            return getPlayer1King();
        }

    }

    public void setPlayer1King(Location player1King) {
        this.player1King = player1King;
    }

    public void setPlayer2King(Location player2King) {
        this.player2King = player2King;
    }

    public boolean isLocationOccupied(Location location) {
        if (isOutOfBounds(location)) {
            return false;
        }
        if(board[location.getX()][location.getY()] != null) {
            return true;
        }
        else{
            return false;
        }
    }

    /**
     * Used to detect if the given location is occupied by a piece which belongs to the given player
     */

    public boolean isLocationOccupiedWithSamePlayer(Location location, boolean player) {
        if(isLocationOccupied(location)) {
            ChessPiece piece = board[location.getX()][location.getY()];
            if(piece.getPlayer() == player) {
                return true;
            }
        }
        return false;
    }

    public ChessPiece getPieceAt(int x, int y) {
        Location location = new Location(x,y);
        if(isLocationOccupied(location)) {
            return board[x][y];
        }
        return null;
    }

    /**
     * Takes a ChessPiece as input and marks its position on the chess board
     * Also updates the King's position if necessary
     */

    public void initializePieceOnBoard(ChessPiece piece) {
        board[piece.getLocation().getX()][piece.getLocation().getY()] = piece;
        if(piece instanceof King) {
            if(piece.getPlayer()) {
                player1King = new Location(piece.getLocation().getX(),piece.getLocation().getY());
            }
            else {
                player2King = new Location(piece.getLocation().getX(),piece.getLocation().getY());
            }
        }
    }

    /**
     * Initializes the board for player 1 and player 2, and also updates the position of the kings
     */

    public void initializeBoard() {
        initializeBoardForPlayer1();
        initializeBoardForPlayer2();
    }

    public void initializeBoardForPlayer1() {
        for(int i = 0; i < 8; i++) {
            initializePieceOnBoard(new Pawn(new Location(1,i),true));
        }
        initializePieceOnBoard(new Rook(new Location(0,0),true));
        initializePieceOnBoard(new Knight(new Location(0,1), true));
        initializePieceOnBoard(new Bishop(new Location(0,2), true));
        initializePieceOnBoard(new King(new Location(0,3), true));
        initializePieceOnBoard(new Queen(new Location(0,4), true));
        initializePieceOnBoard(new Bishop(new Location(0,5), true));
        initializePieceOnBoard(new Knight(new Location(0,6), true));
        initializePieceOnBoard(new Rook(new Location(0,7), true));
        player1King = new Location(0,3);
    }

    public void initializeBoardForPlayer2() {
        for(int i = 0; i < 8; i++) {
            initializePieceOnBoard(new Pawn(new Location(6,i),false));
        }
        initializePieceOnBoard(new Rook(new Location(7,0),false));
        initializePieceOnBoard(new Knight(new Location(7,1), false));
        initializePieceOnBoard(new Bishop(new Location(7,2), false));
        initializePieceOnBoard(new King(new Location(7,3), false));
        initializePieceOnBoard(new Queen(new Location(7,4), false));
        initializePieceOnBoard(new Bishop(new Location(7,5), false));
        initializePieceOnBoard(new Knight(new Location(7,6), false));
        initializePieceOnBoard(new Rook(new Location(7,7), false));
        player2King = new Location(7,3);
    }


    /**
     * Updates the location of the input piece to the newLocation and updates king's location if necessary
     */

    public void updateLocationForPiece(ChessPiece piece, Location newLocation) {
        Location currentLocation = piece.getLocation();
        board[currentLocation.getX()][currentLocation.getY()] = null;
        board[newLocation.getX()][newLocation.getY()] = piece;
        piece.setLocation(newLocation);
        if(piece instanceof King) {
            if(piece.getPlayer()) {
                player1King = new Location(piece.getLocation().getX(),piece.getLocation().getY());
            }
            else {
                player2King = new Location(piece.getLocation().getX(),piece.getLocation().getY());
            }
        }
    }

    public boolean isOutOfBounds(Location location) {
        if (location == null) {
            return true;
        }
        return (location.getX() > 7) || (location.getY() > 7) || (location.getX() < 0) || (location.getY() < 0);
    }

}

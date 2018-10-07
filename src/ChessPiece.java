import static java.lang.Math.abs;

/**
 * Abstract class for chess pieces. All the chess piece classes are derived from it.
 * Stores the location and owner of the piece
 * Player Owner is a boolean which is True for Player1 and False for Player2
 */

public abstract class ChessPiece {

    private Location location;
    private boolean player;

    public ChessPiece(Location location, boolean player) {
        this.location = location;
        this.player = player;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    /**
     * Abstract method implemented for each piece that moves the piece to the new location
     * and updates the piece's location on the board, if the move is valid
     */

    public abstract void moveTo(ChessBoard board, Location newLocation);

    /**
     * Returns True for Player 1 and False for Player 2
     */

    public boolean getPlayer() {
        return player;
    }

    /**
     *  This method checks if a given move is a Valid move for a Rook
     *  It is implemented here, so it could be used for both the Rook class and the Queen class
     *  since the Queen's moves are chosen from either Rook's or Bishop's moves
     */

    public boolean isValidMoveForRook(ChessBoard board, Location newLocation, boolean player) {
        if (board.isOutOfBounds(newLocation)) {
            return false;
        }
        if (board.isLocationOccupiedWithSamePlayer(newLocation,player)) {
            return false;
        }

        int currX = this.getLocation().getX();
        int currY = this.getLocation().getY();
        int newX = newLocation.getX();
        int newY = newLocation.getY();

        /* Moving horizontally */
        if (currX == newX) {
            /* Moving right */
            if(newY > currY) {
                for(int i = newY + 1; i < currY; i++){
                    Location location = new Location(currX,i);
                    if(board.isLocationOccupied(location)){
                        return false;
                    }
                }
                return true;
            }
            /* Moving left */
            else {
                for(int i = newY - 1; i > currY; i--){
                    Location location = new Location(currX,i);
                    if(board.isLocationOccupied(location)){
                        return false;
                    }
                }
                return true;
            }
        }

        /* Moving vertically */
        if (currY == newY) {
            /* Moving down */
            if(newX > currX) {
                for(int i = currX + 1; i < newX; i++) {
                    Location location = new Location(i,currY);
                    if(board.isLocationOccupied(location)) {
                        return false;
                    }
                    return true;
                }
            }
            /* Moving Up */
            else {
                for(int i = currX - 1; i > newX; i--) {
                    Location location = new Location(i,currY);
                    if(board.isLocationOccupied(location)) {
                        return false;
                    }
                    return true;
                }
            }
        }
        return false;
    }

    /**
     *  Same reasoning as above
     */

    public boolean isValidMoveForBishop(ChessBoard board, Location newLocation, boolean player) {
        if (board.isOutOfBounds(newLocation)) {
            return false;
        }
        if (board.isLocationOccupiedWithSamePlayer(newLocation,player)) {
            return false;
        }

        int currX = this.getLocation().getX();
        int currY = this.getLocation().getY();
        int newX = newLocation.getX();
        int newY = newLocation.getY();

        if(abs(currX - newX) == 1 && abs(currY - newY) == 1){
            return true;
        }

        /* The difference between the X coordinates and the Y coordinates should be the same */
        if(abs(currX - newX) == abs(currX - newX)) {
            if(newX > currX && newY < currY) {
                int i = currX + 1;
                int j = currY - 1;
                while(i < newX && j > newY) {
                    Location location = new Location(i,j);
                    if(board.isLocationOccupied(location)){
                        return false;
                    }
                    i++;
                    j--;
                }
                return true;
            }
            else if(newX < currX && newY > currY) {
                int i = currX - 1;
                int j = currY + 1;
                while(i > newX && j < newY) {
                    Location location = new Location(i,j);
                    if(board.isLocationOccupied(location)){
                        return false;
                    }
                    i--;
                    j++;
                }
                return true;
            }

            else if(newX > currX && newY > currY) {
                int i = currX + 1;
                int j = currY + 1;
                while(i < newX && j < newY) {
                    Location location = new Location(i,j);
                    if(board.isLocationOccupied(location)){
                        return false;
                    }
                    i++;
                    j++;
                }
                return true;
            }

            else {
                int i = currX - 1;
                int j = currY - 1;
                while(i > newX && j > newY) {
                    Location location = new Location(i,j);
                    if(board.isLocationOccupied(location)){
                        return false;
                    }
                    i--;
                    j--;
                }
                return true;
            }
        }
        return false;
    }

    /**
     * This method is overridden for Queen, King and Knight. Rook and Bishop have their own methods which are
     * written above
     */
    public boolean isValidMoveForPlayer(ChessBoard board, Location newLocation, boolean player) {
        return false;
    }

    /**
     * This method is common for Knight and King so it's written here and is not overridden in their classes
     * For the rest of the pieces, this method is overridden since it's different for each of those pieces.
     */

    public boolean isKingBeingCheckedByPlayer(ChessBoard board, boolean player) {
        Location otherKingLocation = board.getOtherKingLocation(player);
        if (isValidMoveForPlayer(board, otherKingLocation, player)) {
            return true;
        }
        return false;
    }
}

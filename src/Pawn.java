public class Pawn extends ChessPiece {
    public Pawn(Location location, boolean player){
        super(location, player);
    }

    public void moveTo(ChessBoard board, Location newLocation){
        if(this.getPlayer()) {
            if(isValidMoveForPlayer1(board,newLocation)){
                board.updateLocationForPiece(this, newLocation);
                if(isKingBeingCheckedByPlayer1(board, newLocation)) {
                    System.out.println("CHECK FROM PLAYER 1");
                }
            }
        }

        else {
            if(isValidMoveForPlayer2(board, newLocation)) {
                board.updateLocationForPiece(this, newLocation);
                if(isKingBeingCheckedByPlayer2(board, newLocation)) {
                    System.out.println("CHECK FROM PLAYER 2");
                }
            }
        }
    }

    public boolean isValidMoveForPlayer1(ChessBoard board, Location newLocation) {

        if (board.isOutOfBounds(newLocation)) {
            return false;
        }

        int currX = this.getLocation().getX();
        int currY = this.getLocation().getY();
        int newX = newLocation.getX();
        int newY = newLocation.getY();

        /* Pawn is present in its initial row */
        if (currX == 1) {
            if ((newX == currX + 1) && !board.isLocationOccupied(newLocation)) {
                return true;
            }
            Location middle = new Location(currX + 1, currY);
            if ((newX == currX + 2) && !board.isLocationOccupied(newLocation) && !board.isLocationOccupied(middle)) {
                return true;
            }
        }

        /* Pawn is present is any other row */
        else {
            if ((newX == currX + 1) && !board.isLocationOccupied(newLocation)) {
                return true;
            }
            if ((newX == currX + 1) && (newY == currY - 1) && !board.isLocationOccupiedWithSamePlayer(newLocation, false)) {
                return true;
            }
            if ((newX == currX + 1) && (newY == currY + 1) && !board.isLocationOccupiedWithSamePlayer(newLocation, false)) {
                return true;
            }
        }
        return false;
    }

    public boolean isValidMoveForPlayer2(ChessBoard board, Location newLocation) {

        if (board.isOutOfBounds(newLocation)) {
            return false;
        }

        int currX = this.getLocation().getX();
        int currY = this.getLocation().getY();
        int newX = newLocation.getX();
        int newY = newLocation.getY();

        /* If the Pawn is present in its initial row, it can either move 1 or 2 blocks */
        if (currX == 6) {
            if ((newX == currX - 1) && !board.isLocationOccupied(newLocation)) {
                return true;
            }
            if ((newX == currX - 2) && !board.isLocationOccupied(newLocation)) {
                return true;
            }
        }

        /* If the Pawn is present is any other row, it can only move one block */
        else {
            if ((newX == currX - 1) && !board.isLocationOccupied(newLocation)) {
                return true;
            }
            if ((newX == currX - 1) && (newY == currY + 1) && !board.isLocationOccupiedWithSamePlayer(newLocation, true)) {
                return true;
            }
            if ((newX == currX - 1) && (newY == currY - 1) && !board.isLocationOccupiedWithSamePlayer(newLocation, true)) {
                return true;
            }
        }
        return false;
    }

    public boolean isKingBeingCheckedByPlayer1(ChessBoard board, Location location) {
        Location firstThreat = new Location(location.getX() + 1, location.getY() + 1);
        Location secondThreat = new Location(location.getX() + 1, location.getY() - 1);
        return (firstThreat.getX() == board.getPlayer2King().getX() && firstThreat.getY() == board.getPlayer2King().getY())
                || (secondThreat.getX() == board.getPlayer2King().getX() && secondThreat.getY() == board.getPlayer2King().getY());
    }

    public boolean isKingBeingCheckedByPlayer2(ChessBoard board, Location location) {
        Location firstThreat = new Location(location.getX() - 1, location.getY() - 1);
        Location secondThreat = new Location(location.getX() - 1, location.getY() + 1);
        return (firstThreat.getX() == board.getPlayer1King().getX() && firstThreat.getY() == board.getPlayer1King().getY())
                || (secondThreat.getX() == board.getPlayer1King().getX() && secondThreat.getY() == board.getPlayer1King().getY());    }
}

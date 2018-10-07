import static java.lang.Math.abs;

public class King extends ChessPiece {

    public King(Location location, boolean player){
        super(location, player);
    }

    public void moveTo(ChessBoard board, Location newLocation) {
        if (isValidMoveForPlayer(board, newLocation, getPlayer())) {
            board.updateLocationForPiece(this, newLocation);
            if(getPlayer()) {
                board.setPlayer1King(newLocation);
            }
            else {
                board.setPlayer2King(newLocation);
            }
            if(isKingBeingCheckedByPlayer(board, getPlayer())) {
                System.out.println("CHECK FROM " + this.getPlayer());
            }
        }
    }

    public boolean isValidMoveForPlayer(ChessBoard board, Location newLocation, boolean player) {
        if (board.isOutOfBounds(newLocation)) {
            return false;
        }
        if (board.isLocationOccupiedWithSamePlayer(newLocation, player)) {
            return false;
        }

        /**
         * Difference between the X coordinates should be at most 1, and same for the Y coordinates
         */
        int currX = this.getLocation().getX();
        int currY = this.getLocation().getY();
        int newX = newLocation.getX();
        int newY = newLocation.getY();
        if (abs((currX - newX)) <= 1 && abs(currY - newY) <= 1){
            return true;
        }
        return false;
    }

}
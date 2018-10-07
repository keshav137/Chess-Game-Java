import static java.lang.Math.abs;


public class PowerPawn extends ChessPiece {
    public PowerPawn(Location location, boolean player){
        super(location, player);
    }

    public void moveTo(ChessBoard board, Location newLocation) {
        if(isValidMoveForPlayer(board, newLocation, this.getPlayer())) {
            board.updateLocationForPiece(this,newLocation);
            if(isKingBeingCheckedByPlayer(board, this.getPlayer())) {
                System.out.println("CHECK FROM " + this.getPlayer());
            }
        }
    }

    /**
     *
     * This pawn is better than your normal pawn as it can move in both directions
     * @param board
     * @param newLocation
     * @param player
     * @return
     */

    public boolean isValidMoveForPlayer(ChessBoard board, Location newLocation, boolean player) {
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

        /* Pawn is present in its initial row */
        if (currX == 1) {
            if (abs(newX - currX) == 1 && !board.isLocationOccupied(newLocation)) {
                return true;
            }
            Location middle = new Location(currX + 1, currY);
            if (abs(newX - currX) == 2 && !board.isLocationOccupied(newLocation) && !board.isLocationOccupied(middle)) {
                return true;
            }
        }

        /* Pawn is present is any other row */
        else {
            if (abs(newX - currX) == 1 && !board.isLocationOccupied(newLocation)) {
                return true;
            }
            if (abs(newX - currX) == 1 && (newY == currY - 1) && !board.isLocationOccupiedWithSamePlayer(newLocation, false)) {
                return true;
            }
            if (abs(newX - currX) == 1 && (newY == currY + 1) && !board.isLocationOccupiedWithSamePlayer(newLocation, false)) {
                return true;
            }
        }
        return false;
    }

}

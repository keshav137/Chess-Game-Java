import static java.lang.Math.abs;

public class Knight extends ChessPiece {

    public Knight(Location location, boolean player){
        super(location, player);
    }

    public void moveTo(ChessBoard board, Location newLocation) {
        if (isValidMoveForPlayer(board, newLocation, getPlayer())) {
            board.updateLocationForPiece(this, newLocation);
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

        int currX = this.getLocation().getX();
        int currY = this.getLocation().getY();
        int newX = newLocation.getX();
        int newY = newLocation.getY();

        /**
         * Either difference between X coordinates should be 2 and Y coordinates should be 1 OR
         * difference between Y coordinates should be 2 and X coordinates should be 1
         */

        if (abs((currX - newX)) == 2 && abs(currY - newY) == 1){
            return true;
        }

        if (abs((currX - newX)) == 1 && abs(currY - newY) == 2){
            return true;
        }
        return false;
    }

}
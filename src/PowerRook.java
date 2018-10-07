public class PowerRook extends ChessPiece {

    public PowerRook(Location location, boolean player){
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
     * This rook is a strong and agile rook that can move like a normal rook but also jump over one piece
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
        if(currX == newX || currY == newY) {
            return true;
        }
        return false;
    }

}

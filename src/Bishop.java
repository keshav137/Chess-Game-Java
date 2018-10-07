public class Bishop extends ChessPiece {
    public Bishop(Location location, boolean player){
        super(location, player);
    }

    public void moveTo(ChessBoard board, Location newLocation) {
        if(isValidMoveForBishop(board, newLocation,this.getPlayer())) {
            board.updateLocationForPiece(this,newLocation);
            if(isKingBeingCheckedByPlayer(board, this.getPlayer())) {
                System.out.println("CHECK FROM " + this.getPlayer());
            }
        }
    }

    /**
     * Method to detect if the opponent's King is being checked by the current move after completion
     */

    public boolean isKingBeingCheckedByPlayer(ChessBoard board, boolean player) {
        Location otherKingLocation = board.getOtherKingLocation(player);
        if (isValidMoveForBishop(board, otherKingLocation, player)) {
            return true;
        }
        return false;
    }

}
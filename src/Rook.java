public class Rook extends ChessPiece {

    public Rook(Location location, boolean player){
        super(location, player);
    }

    public void moveTo(ChessBoard board, Location newLocation){
        if(isValidMoveForRook(board, newLocation,this.getPlayer())) {
            board.updateLocationForPiece(this,newLocation);
            if(isKingBeingCheckedByPlayer(board, this.getPlayer())) {
                System.out.println("CHECK FROM " + this.getPlayer());
            }
        }
    }

    public boolean isKingBeingCheckedByPlayer(ChessBoard board, boolean player) {
        Location otherKingLocation = board.getOtherKingLocation(player);
        if (isValidMoveForRook(board, otherKingLocation, player)) {
            return true;
        }
        return false;
    }
}

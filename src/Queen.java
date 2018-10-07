public class Queen extends ChessPiece {

    public Queen(Location location, boolean player){
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

    public boolean isValidMoveForPlayer(ChessBoard board, Location newLocation, boolean player) {
        return isValidMoveForBishop(board,newLocation,player) || isValidMoveForRook(board,newLocation,player);
    }

}
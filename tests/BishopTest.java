import org.junit.Test;
import static org.junit.Assert.assertEquals;


public class BishopTest {

    ChessBoard board = new ChessBoard();
    Bishop blackBishop = new Bishop(new Location(4,2), false);
    Bishop anotherBlackBishop = new Bishop(new Location(3,1), false);
    Pawn whitePawn = new Pawn(new Location(2,4), true);
    Rook blackRook = new Rook(new Location(2,0), false);
    King whiteKing = new King(new Location(1,5), true);

    @Test
    public void moveTo() {
        board.initializePieceOnBoard(blackBishop);
        board.initializePieceOnBoard(anotherBlackBishop);
        board.initializePieceOnBoard(whitePawn);
        board.initializePieceOnBoard(blackRook);
        board.initializePieceOnBoard(whiteKing);

        blackBishop.moveTo(board, new Location(2,4));
        assertEquals(false, board.isLocationOccupied(new Location(4,2)));
        assertEquals(true, board.isLocationOccupied(new Location(2,4)));
        assertEquals(true, blackBishop.isKingBeingCheckedByPlayer(board, blackBishop.getPlayer()));
        assertEquals(true, blackBishop.isValidMoveForBishop(board, new Location(1,5), false));

    }

}
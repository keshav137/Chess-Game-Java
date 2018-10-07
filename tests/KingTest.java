import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class KingTest {

    ChessBoard board = new ChessBoard();
    Rook blackRook = new Rook(new Location(0,6), false);
    King whiteKing = new King(new Location(1,5), true);

    @Test
    public void moveTo() {
        board.initializePieceOnBoard(blackRook);
        board.initializePieceOnBoard(whiteKing);
        whiteKing.moveTo(board, new Location(0,6));
        assertEquals(false, board.isLocationOccupied(new Location(1,5)));
        assertEquals(true, board.isLocationOccupied(new Location(0,6)));

    }

    @Test
    public void isValidMoveForPlayer() {
        board.initializePieceOnBoard(blackRook);
        board.initializePieceOnBoard(whiteKing);
        assertEquals(false, whiteKing.isValidMoveForPlayer(board, new Location(10,10),true));
        assertEquals(false, whiteKing.isValidMoveForPlayer(board, new Location(2,7),true));
        assertEquals(false, whiteKing.isValidMoveForPlayer(board, new Location(1,5),true));
    }
    
}
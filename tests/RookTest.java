import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class RookTest {

    ChessBoard board = new ChessBoard();
    Rook whiteRook = new Rook(new Location(7,0), true);
    Rook blackRook = new Rook(new Location(7,7), false);
    Bishop blackBishop = new Bishop(new Location(3,0), false);
    Pawn blackPawn = new Pawn(new Location(5,0), false);

    @Test
    public void isValidMoveForRook() {
        board.initializePieceOnBoard(whiteRook);
        board.initializePieceOnBoard(blackRook);
        board.initializePieceOnBoard(blackBishop);
        board.initializePieceOnBoard(blackPawn);
        assertEquals(true, whiteRook.isValidMoveForRook(board, new Location(7,7),true));
        assertEquals(true, whiteRook.isValidMoveForRook(board, new Location(5,0),true));
        assertEquals(false, whiteRook.isValidMoveForRook(board, new Location(0,7),true));
        assertEquals(true, whiteRook.isValidMoveForRook(board, new Location(3,0),true));
    }
}
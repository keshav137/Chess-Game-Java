import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class KnightTest {

    ChessBoard board = new ChessBoard();
    Knight whiteKnight = new Knight(new Location(4,2), true);
    Bishop blackBishop = new Bishop(new Location(3,4), false);
    Pawn blackPawn = new Pawn(new Location(3,2), false);


    @Test
    public void isValidMoveForPlayer() {
        board.initializePieceOnBoard(whiteKnight);
        board.initializePieceOnBoard(blackBishop);
        board.initializePieceOnBoard(blackPawn);
        assertEquals(false, whiteKnight.isValidMoveForPlayer(board, new Location(3,2),true));
        assertEquals(true, whiteKnight.isValidMoveForPlayer(board, new Location(3,4),true));
        assertEquals(true, whiteKnight.isValidMoveForPlayer(board, new Location(5,0),true));
        assertEquals(true, whiteKnight.isValidMoveForPlayer(board, new Location(3,0),true));
        assertEquals(true, whiteKnight.isValidMoveForPlayer(board, new Location(2,1),true));
    }
}
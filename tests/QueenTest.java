import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class QueenTest {

    ChessBoard board = new ChessBoard();
    Rook blackRook = new Rook(new Location(2,7), false);
    Pawn whitePawn = new Pawn(new Location(3,6), true);
    Queen whiteQueen = new Queen(new Location(5,4),true);
    Bishop blackBishop = new Bishop(new Location(7,4), false);

    @Test
    public void isValidMoveForPlayer() {
        board.initializePieceOnBoard(blackRook);
        board.initializePieceOnBoard(whiteQueen);
        board.initializePieceOnBoard(blackBishop);
        board.initializePieceOnBoard(whitePawn);
        assertEquals(false, whiteQueen.isValidMoveForPlayer(board, new Location(2,7),true));
        assertEquals(false, whiteQueen.isValidMoveForPlayer(board, new Location(3,6),true));
        assertEquals(true, whiteQueen.isValidMoveForPlayer(board, new Location(7,4),true));
    }

}
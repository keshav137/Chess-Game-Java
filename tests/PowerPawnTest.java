import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class PowerPawnTest {

    ChessBoard board = new ChessBoard();
    PowerPawn whitePawn = new PowerPawn(new Location(1,3),true);
    PowerPawn blackPawn = new PowerPawn(new Location(5,6),false);
    Queen whiteQueen = new Queen(new Location(6,5), true);

    @Test
    public void isValidMoveForPlayer1() {
        board.initializePieceOnBoard(whitePawn);
        board.initializePieceOnBoard(whiteQueen);
        board.initializePieceOnBoard(blackPawn);
        assertEquals(true, whitePawn.isValidMoveForPlayer(board, new Location(3,3),true));
        assertEquals(true, whitePawn.isValidMoveForPlayer(board, new Location(2,3), true ));
    }

}
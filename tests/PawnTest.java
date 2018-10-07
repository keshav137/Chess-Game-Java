import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class PawnTest {
    ChessBoard board = new ChessBoard();
    Pawn whitePawn = new Pawn(new Location(1,3),true);
    Pawn blackPawn = new Pawn(new Location(5,6),false);
    Queen whiteQueen = new Queen(new Location(6,5), true);
    King whiteKing = new King(new Location(4,7), true);
    King blackKing = new King(new Location(2,2), false);

    @Test
    public void isValidMoveForPlayer1() {
        board.initializePieceOnBoard(whitePawn);
        board.initializePieceOnBoard(whiteQueen);
        board.initializePieceOnBoard(blackPawn);
        assertEquals(true, whitePawn.isValidMoveForPlayer1(board, new Location(3,3)));
        assertEquals(true, whitePawn.isValidMoveForPlayer1(board, new Location(2,3)));


    }

    @Test
    public void isValidMoveForPlayer2() {
        board.initializePieceOnBoard(whitePawn);
        board.initializePieceOnBoard(whiteQueen);
        board.initializePieceOnBoard(blackPawn);
        assertEquals(false, blackPawn.isValidMoveForPlayer2(board, new Location(6,5)));
        assertEquals(true, blackPawn.isValidMoveForPlayer2(board, new Location(4,6)));
        assertEquals(false, blackPawn.isValidMoveForPlayer2(board, new Location(5,7)));
    }

    @Test
    public void isKingBeingCheckedByPlayer2() {
        board.initializePieceOnBoard(whitePawn);
        board.initializePieceOnBoard(whiteQueen);
        board.initializePieceOnBoard(blackPawn);
        board.initializePieceOnBoard(whiteKing);
        assertEquals(true, blackPawn.isKingBeingCheckedByPlayer2(board, new Location(5,6)));

    }

    @Test
    public void isKingBeingCheckedByPlayer1() {
        board.initializePieceOnBoard(whitePawn);
        board.initializePieceOnBoard(whiteQueen);
        board.initializePieceOnBoard(blackPawn);
        board.initializePieceOnBoard(whiteKing);
        board.initializePieceOnBoard(blackKing);
        assertEquals(true, blackPawn.isKingBeingCheckedByPlayer1(board, new Location(1,3)));
    }
}
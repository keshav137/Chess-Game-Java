import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ChessBoardTest {

    @Test
    public void isLocationOccupied() {
        ChessBoard board = new ChessBoard();
        board.initializeBoard();
        assertEquals(true, board.isLocationOccupied(new Location(6,0)));
        assertEquals(true, board.isLocationOccupied(new Location(6,7)));
        assertEquals(true, board.isLocationOccupied(new Location(1,1)));
        assertEquals(true, board.isLocationOccupied(new Location(1,6)));
        assertEquals(false, board.isLocationOccupied(new Location(4,4)));
        assertEquals(false, board.isLocationOccupied(new Location(10,10)));

    }

    @Test
    public void isLocationOccupiedWithSamePlayer() {
        ChessBoard board = new ChessBoard();
        board.initializeBoard();
        assertEquals(true, board.isLocationOccupiedWithSamePlayer(new Location(6,0), false));
        assertEquals(false, board.isLocationOccupiedWithSamePlayer(new Location(1,1), false));
    }

    @Test
    public void updateLocationForPiece() {
        ChessBoard board = new ChessBoard();
        board.initializeBoard();
        ChessPiece piece = board.getPieceAt(6,1);
        piece.moveTo(board, new Location(4,1));
        assertEquals(true, board.isLocationOccupied(new Location(4,1)));
        assertEquals(false, board.isLocationOccupied(new Location(6,1)));
    }

    @Test
    public void isOutOfBounds() {
        ChessBoard board = new ChessBoard();
        board.initializeBoard();
        assertEquals(true, board.isOutOfBounds(new Location(50,100)));
        assertEquals(false, board.isOutOfBounds(new Location(1,7)));

    }
}
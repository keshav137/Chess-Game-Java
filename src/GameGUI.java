import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

/**
 * Referenced from Source : https://github.com/slagyr/chess/blob/master/chess/gui/GuiChessGame.java
 */


public class GameGUI {
    private final JFrame gameFrame;
    private final BoardPanel boardPanel;
    private ArrayList<PieceImage> pieces;
    private ChessBoard board;
    private final static int Chess_Size = 80;
    private final static Dimension OuterDimension = new Dimension(640, 660);
    private final static Dimension BoardDimension = new Dimension(640, 660);

    public GameGUI() {
        this.gameFrame = new JFrame("Chess");
        this.gameFrame.setResizable(false);
        this.gameFrame.setSize(OuterDimension);
        this.gameFrame.setLayout(new BorderLayout());
        this.gameFrame.setVisible(true);
        this.gameFrame.setLocation(100, 100);
        this.gameFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.board = new ChessBoard();
        board.initializeBoard();
        this.pieces = new ArrayList<>();
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                ChessPiece p = board.getPieceAt(i, j);
                if (p != null)
                    pieces.add(new PieceImage(p));
            }
        }
        this.boardPanel = new BoardPanel();
        this.gameFrame.add(this.boardPanel, BorderLayout.CENTER);
    }


    private class BoardPanel extends JPanel {

        BoardPanel() {
            super(new GridLayout(8, 8));
            setLocation(0, 0);
            setBackground(Color.WHITE);
            setPreferredSize(BoardDimension);
            validate();
        }

        @Override
        public void paintComponent(Graphics g) {
            tileColor(g);
            for (PieceImage p : pieces) {
                drawPiece(g, p);
            }
        }

        private void drawPiece(Graphics g, PieceImage p) {
            int cur_x = (7 - p.getLocation().getX()) * Chess_Size;
            int cur_y = (p.getLocation().getY()) * Chess_Size;
            g.drawImage(p.getImage(), cur_y, cur_x, null);
        }

        private void tileColor(Graphics g) {
            for (int i = 0; i < 8; i++) {
                for (int j = 0; j < 8; j++) {
                    if ((i % 2 != 0 && j % 2 == 0)) {
                        g.fillRect(i * Chess_Size, j * Chess_Size, Chess_Size, Chess_Size);
                    }

                }
            }
            for (int i = 0; i < 8; i++) {
                for (int j = 0; j < 8; j++) {
                    if ((i % 2 == 0 && j % 2 != 0)) {
                        g.fillRect(i * Chess_Size, j * Chess_Size, Chess_Size, Chess_Size);
                    }
                }
            }
        }

    }
}

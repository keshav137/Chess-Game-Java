import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;


/**
 * Referenced from Source : https://github.com/slagyr/chess/blob/master/chess/gui/GuiChessGame.java
 */

public class PieceImage {
    private ChessPiece piece;
    private static final Map<String, BufferedImage> imageMap = new HashMap<>();


    public PieceImage() {
    }

    public PieceImage(ChessPiece piece) {
        this.piece = piece;
    }

    private static BufferedImage readImage(String fileName) {
        try {
            return ImageIO.read(new PieceImage().getClass().getResourceAsStream("Images/" + fileName + ".png"));
        } catch (IOException e) {
            return null;
        }
    }

    public Location getLocation() {
        return this.piece.getLocation();
    }


    private static BufferedImage getImage(ChessPiece piece) {
        String className = piece.getClass().getSimpleName();
        String color;
        if (piece.getPlayer())
            color = "_white";
        else
            color = "_black";
        String fileName = className + color;

        if (!imageMap.containsKey(fileName)) {
            imageMap.put(fileName, readImage(fileName));
        }
        return imageMap.get(fileName);
    }

    public BufferedImage getImage(){
        return getImage(piece);
    }
}
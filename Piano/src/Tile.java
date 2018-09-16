import javafx.scene.paint.Color;
import javafx.scene.paint.PhongMaterial;
import javafx.scene.shape.Box;

import java.util.Random;

public class Tile {
    private Box tile;
    private Color tileColor;
    private int tileIndex;

    public Tile(int index) throws Exception {
        if(index <= 0) throw new Exception("Tile index cant be equal 0 or smaller!");
        tileIndex = index;
        tile = new Box();
        tile.setTranslateX(index*160);
        tile.setTranslateY(240);
        tile.setWidth(122);
        tile.setHeight(240);
        tile.setDepth(100);
        tile.setMaterial(new PhongMaterial(Color.rgb(30*index, 10*index, 30*index)));
    }

    public Color getTileColor() {
        return tileColor;
    }

    public void setTileColor(Color tileColor) {
        this.tileColor = tileColor;
    }

    public int getTileIndex() {
        return tileIndex;
    }

    public Box getTile() {
        return tile;
    }
}
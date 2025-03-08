package tile;

import main.GamePanel;

public class TileManager {

    GamePanel gp;
    Tile[] tile;

    public TileManager(GamePanel gp) {
        this.gp = gp;

        // number of elements corresponds to number of different
        // kinds of tiles
        tile = new Tile[10];
    }
}

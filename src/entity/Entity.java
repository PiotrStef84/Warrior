package entity;

import java.awt.*;
import java.awt.image.BufferedImage;

public class Entity {

    public int worldX, worldY;
    public int speed;

    // BufferedImage - describes an Image with an accessible buffer of
    // image data. (We use this to store our image files)
    public BufferedImage up1, up2, down1, down2, left1, left2, right1, right2;
    public String direction;

    public int spriteCounter = 0;
    public int spriteNum = 1;
    // used for creating smaller rectangle for collision
    public Rectangle solidArea;
    public boolean collisionOn = false;
}

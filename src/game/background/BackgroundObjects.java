package game.background;

import config.Assets;
import de.ur.mi.oop.graphics.Image;

public class BackgroundObjects implements Assets {

    private static final float DEFAULT_SKY_MOVEMENT_SPEED = -0.5f;

    private Image sprite;

    public BackgroundObjects(int xPos, int yPos) {
        sprite = new Image(xPos, yPos, BACKGROUND_OBJECTS_IMAGE_PATH);
    }

    public void update() {
        sprite.move(DEFAULT_SKY_MOVEMENT_SPEED, 0);
        if(sprite.getXPos() <= -sprite.getWidth()/2) {
            sprite.setXPos(0);
        }
    }

    public void draw() {
        sprite.draw();
    }
}

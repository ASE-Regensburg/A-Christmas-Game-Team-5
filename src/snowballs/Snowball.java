package snowballs;

import config.Assets;
import config.GameConfig;
import sprites.SpriteActor;
import sprites.SpriteSet;

public class Snowball extends SpriteActor implements GameConfig, Assets {

    private int speed;

    private Snowball(int xPos, SpriteSet[] sprites, SnowballSpeed speed) {
        super(xPos, SNOWBALL_HEIGHT, sprites);
        this.speed = SnowballSpeed.getSpeed(speed);
    }

    @Override
    public void update() {
        move(-speed, 0);
        super.update();

    }

    public static Snowball createSnowball(SnowballSpeed speed) {
        sprites.SpriteSet[] sprites = new SpriteSet[1];
        sprites[0] = SpriteSet.createSet("flying", SNOWBALL_SPRITES, SNOWBALL_ANIMATION_SPEED);
        return new Snowball(SCREEN_WIDTH, sprites, speed);
    }

}

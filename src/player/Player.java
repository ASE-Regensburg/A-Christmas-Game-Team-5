package player;

import config.Assets;
import config.GameConfig;
import sprites.SpriteActor;
import sprites.SpriteSet;

public class Player extends SpriteActor implements GameConfig, Assets {

    private boolean isJumping;
    private boolean isFalling;
    private int jumpTargetPosition;
    private int originalPosition;

    public Player(int xPos, int yPos, SpriteSet[] sprites) {
        super(xPos,yPos,sprites);
        isJumping = false;
        isFalling = false;
    }

    public void jump() {
        if(!isJumping) {
            isJumping = true;
            originalPosition = this.getYPos();
            jumpTargetPosition = originalPosition - PLAYER_JUMP_HEIGHT;
            selectSpriteSet("jumping");
        }
    }

    @Override
    public void update() {
        super.update();
        if(isJumping && !isFalling) {
            move(0,-PLAYER_JUMP_SPEED);
            if(getYPos() == jumpTargetPosition) {
                isFalling = true;
            }
        }
        if(isFalling) {
            move(0, PLAYER_JUMP_SPEED);
            if(getYPos() == originalPosition) {
                isJumping = false;
                isFalling = false;
                selectSpriteSet("running");
            }
        }
    }

}


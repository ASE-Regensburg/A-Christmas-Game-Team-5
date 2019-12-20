package game;

import config.Assets;
import config.GameConfig;
import game.background.BackgroundObjects;
import scenes.Scene;
import scenes.SceneListener;

public class GameScene extends Scene implements GameConfig, Assets {

    private BackgroundObjects backgroundObjects;

    public GameScene(String tag, SceneListener listener) {
        super(tag, BACKGROUND_IMAGE_PATH, listener);
        initBackground();
    }

    private void initBackground() {
        backgroundObjects = new BackgroundObjects(0,0);
    }

    public void update() {
        backgroundObjects.update();
    }

    public void draw() {
        super.draw();
        backgroundObjects.draw();
    }

}

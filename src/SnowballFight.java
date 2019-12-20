import config.Assets;
import de.ur.mi.oop.app.GraphicsApp;
import de.ur.mi.oop.audio.AudioClip;
import de.ur.mi.oop.colors.Colors;
import config.GameConfig;
import de.ur.mi.oop.events.KeyPressedEvent;
import game.GameScene;
import intro.IntroScene;
import scenes.Scene;
import scenes.SceneListener;

public class SnowballFight extends GraphicsApp implements GameConfig, Assets, SceneListener {

    private Scene[] scenes;
    private Scene currentScene;
    private AudioClip backgroundMusic;

    @Override
    public void initialize() {
        setFrameRate(TARGET_FPS);
        setCanvasSize(SCREEN_WIDTH, SCREEN_HEIGHT);
        preloadScenes();
        setScene(INTRO_SCENE_TAG);
        initBackgroundMusic();
    }

    private void preloadScenes() {
        scenes = new Scene[2];
        scenes[0] = new IntroScene(INTRO_SCENE_TAG, this);
        scenes[1] = new GameScene(GAME_SCENE_TAG, this);
    }

    private void setScene(String tag) {
        for(int i = 0; i < scenes.length; i++) {
            if(scenes[i].getTag().equals(tag)) {
                currentScene = scenes[i];
                break;
            }
        }
        currentScene.initialize();
    }

    private void initBackgroundMusic() {
        backgroundMusic = new AudioClip(BACKGROUND_MUSIC_PATH);
        backgroundMusic.loop();
    }

    @Override
    public void draw() {
        drawBackground(Colors.WHITE);
        currentScene.update();
        currentScene.draw();
    }

    @Override
    public void onSceneFinished(Scene scene) {
        setScene(GAME_SCENE_TAG);
    }

    @Override
    public void onKeyPressed(KeyPressedEvent event) {
        currentScene.onKeyPressed(event);
    }
}

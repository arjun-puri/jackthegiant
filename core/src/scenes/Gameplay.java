package scenes;

import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.ScreenUtils;
import com.badlogic.gdx.utils.viewport.StretchViewport;
import com.badlogic.gdx.utils.viewport.Viewport;

import java.util.ArrayList;

import helpers.GameInfo;
import me.arjunpuri.jackthegiant.GameMain;

public class Gameplay implements Screen {
    private GameMain game;
    private SpriteBatch batch;
    private Sprite[] bgs;
    private OrthographicCamera mainCamera;
    private Viewport viewport;

    /**
     * Creates game background by stacking 3 images repeating together.
     * length can be increased later.
     */
    void createBackgrounds() {
        bgs = new Sprite[3];

        for(int i = 0; i<bgs.length; i++) {
            bgs[i] = new Sprite(new Texture("Backgrounds/Game BG.png"));
            bgs[i].setPosition(0, - (i * bgs[i].getHeight()));
        }
    }

    /**
     * Draws the stitched together backgrounds together
     */
    void drawBackgrounds() {
        for (Sprite bg:
             bgs) {
            batch.draw(bg, bg.getX(), bg.getY());
        }
    }


    public Gameplay(GameMain game) {
        this.game = game;
        this.batch = game.getBatch();
        createBackgrounds();

        this.mainCamera = new OrthographicCamera(GameInfo.WIDTH, GameInfo.HEIGHT);
        this.mainCamera.position.set(GameInfo.WIDTH / 2f, GameInfo.HEIGHT / 2f, 0);

        this.viewport = new StretchViewport(GameInfo.WIDTH, GameInfo.HEIGHT, mainCamera);
    }

    void update(float dt) {
        moveCamera();
    }

    void moveCamera() {
        this.mainCamera.position.y -= 1;
    }

    @Override
    public void show() {

    }

    @Override
    public void render(float delta) {
        update(delta);

        ScreenUtils.clear(1, 0, 0, 1);

        batch.begin();
        drawBackgrounds();
        batch.end();

        batch.setProjectionMatrix(mainCamera.combined);
        mainCamera.update();
    }

    @Override
    public void resize(int width, int height) {

    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void hide() {

    }

    @Override
    public void dispose() {

    }
}

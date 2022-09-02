package scenes;

import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.ScreenUtils;

import java.util.ArrayList;

import me.arjunpuri.jackthegiant.GameMain;

public class Gameplay implements Screen {
    private GameMain game;
    private SpriteBatch batch;
    private Sprite[] bgs;


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
    }

    @Override
    public void show() {

    }

    @Override
    public void render(float delta) {
        ScreenUtils.clear(1, 0, 0, 1);

        batch.begin();

        drawBackgrounds();

        batch.end();
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

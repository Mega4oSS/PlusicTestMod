package ru.artem.alaverdyan.firstplusicmod;

import age.of.civilizations2.jakowski.lukasz.*;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.GlyphLayout;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;

public class FirstPlusicMod extends PlusicMod {
    public static Menu activeMenu = Menu.eLOADGAME;
    public static boolean drawMem;
    private ShapeRenderer shapeRenderer;
    private BitmapFont myFont;
    private Texture mem;

    @Override
    public void create() {
        System.out.println("FirstPlusicModActivated!");
        shapeRenderer = new ShapeRenderer();
        shapeRenderer.setAutoShapeType(true);
        Plusic.registerListener(new MyListener());
        myFont = new BitmapFont();
        drawMem = false;
        mem = new Texture(Gdx.files.internal("lolkek.png"));
    }

    @Override
    public void render(SpriteBatch batch) {
        if (!drawMem) return;
        GlyphLayout glyphLayout = new GlyphLayout(myFont, "ActiveMenu: " + activeMenu.toString() + "\nActiveViewID: " + CFG.menuManager.viewID + (activeMenu == Menu.eINGAME ? ("\nActivePlayerCivID: " + CFG.game.getPlayer(CFG.PLAYER_TURNID).getCivID()) : ("\nActivePlayerCivID: " + -1)));
        batch.end();
        shapeRenderer.begin(ShapeRenderer.ShapeType.Filled);
        shapeRenderer.setColor(Color.CYAN);
        shapeRenderer.rect(Gdx.input.getX(), CFG.GAME_HEIGHT - Gdx.input.getY(), glyphLayout.width + 4, glyphLayout.height + 4);
        shapeRenderer.setColor(Color.BLACK);
        shapeRenderer.set(ShapeRenderer.ShapeType.Line);
        shapeRenderer.rect(Gdx.input.getX(), CFG.GAME_HEIGHT - Gdx.input.getY(), glyphLayout.width + 4, glyphLayout.height + 4);
        shapeRenderer.end();
        batch.begin();
        batch.setColor(Color.BLACK);
        myFont.draw(batch, glyphLayout, Gdx.input.getX() + 2, CFG.GAME_HEIGHT - Gdx.input.getY() + 2 + glyphLayout.height);
        batch.setColor(Color.WHITE);
        batch.draw(mem, 10, 10, 100, 100);
    }

    @Override
    public void dispose() {
        shapeRenderer.dispose();
        myFont.dispose();
    }

    public BitmapFont getMyFont() {
        return myFont;
    }

    public void setMyFont(BitmapFont myFont) {
        this.myFont = myFont;
    }
}

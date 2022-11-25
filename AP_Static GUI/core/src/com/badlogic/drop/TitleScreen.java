package com.badlogic.drop;


import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputAdapter;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;


public class TitleScreen extends ScreenAdapter {

        TankStar game;

        Texture texture;

        public TitleScreen(TankStar game) {
            this.game = game;
        }

        @Override
        public void show(){
            texture = new Texture(Gdx.files.internal("Tank.jpg"));
            Gdx.input.setInputProcessor(new InputAdapter() {
                @Override
                public boolean keyDown(int keyCode) {
                    if (keyCode == Input.Keys.SPACE) {
                        game.setScreen(new GameScreen(game));
                    }
                    return true;
                }
            });
        }


        @Override
        public void render(float delta) {
            Gdx.gl.glClearColor(.25f, .25f, .25f, 1);
            Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

            game.batch.begin();
//            game.font.draw(game.batch, "Title Screen!", Gdx.graphics.getWidth() * .25f, Gdx.graphics.getHeight() * .75f);
//            game.font.draw(game.batch, "Click the circle to win.", Gdx.graphics.getWidth() * .25f, Gdx.graphics.getHeight() * .5f);
            game.batch.draw(texture, 0, 0);
            game.font.draw(game.batch, "Press space to play.", Gdx.graphics.getWidth() * .25f, Gdx.graphics.getHeight() * .25f);
            game.batch.end();
        }

        @Override
        public void hide(){
            Gdx.input.setInputProcessor(null);
        }
    }


package com.badlogic.drop;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputAdapter;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Vector2;




    public class GameScreen extends ScreenAdapter {

        TankStar game;
        Texture texture1;

        float circleX = 300;
        float circleY = 150;
        float circleRadius = 50;

        float xSpeed = 4;
        float ySpeed = 3;

        public GameScreen(TankStar game) {
            this.game = game;
        }

        @Override
        public void show() {
            texture1 = new Texture(Gdx.files.internal("Tank2.jpg"));
            Gdx.input.setInputProcessor(new InputAdapter() {
                @Override
                public boolean touchDown(int x, int y, int pointer, int button) {
                    int renderY = Gdx.graphics.getHeight() - y;
                    if (Vector2.dst(circleX, circleY, x, renderY) < circleRadius) {
                        game.setScreen(new EndScreen(game));
                    }
                    return true;
                }
            });
        }

        @Override
        public void render(float delta) {
            circleX += xSpeed;
            circleY += ySpeed;

            if (circleX < 0 || circleX > Gdx.graphics.getWidth()) {
                xSpeed *= -1;
            }

            if (circleY < 0 || circleY > Gdx.graphics.getHeight()) {
                ySpeed *= -1;
            }

            Gdx.gl.glClearColor(0, 0, .25f, 1);
            Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
            game.batch.begin();
            game.batch.draw(texture1, 0, 0);
            game.batch.end();
            game.shapeRenderer.begin(ShapeRenderer.ShapeType.Filled);
            game.shapeRenderer.setColor(1, 0, 0, 1);
            game.shapeRenderer.circle(circleX, circleY, 10);
            game.shapeRenderer.end();

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
            Gdx.input.setInputProcessor(null);
        }

        @Override
        public void dispose() {

        }
    }


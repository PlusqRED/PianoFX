import javafx.animation.AnimationTimer;
import javafx.scene.transform.Rotate;

public class GameProcess {

    private AnimationTimer timer;
    protected GameContent gameContent;

    public GameProcess(GameContent gameContent) {
        this.gameContent = gameContent;
        timer = new AnimationTimer() {
            @Override
            public void handle(long now) {
                gameUpdate();
            }
        };
    }

    public void gameStart() {
        timer.start();
    }

    public void gameStop() {
        timer.stop();
    }

    private void gameUpdate() {
        if(gameContent.rotateTiles) {
          //  ((Rotate)gameContent.camera.getTransforms().get(0)).setAngle(angle+=0.2);
            ((Rotate)gameContent.camera.getTransforms().get(1)).setAngle(((Rotate)gameContent.camera.getTransforms().get(1)).getAngle()+0.4f);
          //zz  ((Rotate)gameContent.camera.getTransforms().get(2)).setAngle(angle+=0.2);

        } else {
           // ((Rotate)gameContent.camera.getTransforms().get(0)).setAngle(angle+=0.1);
            ((Rotate)gameContent.camera.getTransforms().get(1)).setAngle(((Rotate)gameContent.camera.getTransforms().get(1)).getAngle()+0.2f);
          //  ((Rotate)gameContent.camera.getTransforms().get(2)).setAngle(angle+=0.1);
        }

    }
}

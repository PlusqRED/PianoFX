import javafx.scene.paint.Color;

public class GameController {
    private GameProcess gameProcess;
    public GameController(GameProcess gameProcess) {
        this.gameProcess = gameProcess;
    }
    public void setController() {
        gameProcess.gameStart();
        gameProcess.gameContent.createSceneKeyAction(true);
        gameProcess.gameContent.createSceneKeyAction(false);
        gameProcess.gameContent.gameStage.getScene().setCamera(gameProcess.gameContent.camera);
        gameProcess.gameContent.gameStage.getScene().setFill(Color.BLACK);
    }
}

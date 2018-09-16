import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.SceneAntialiasing;
import javafx.stage.Stage;

public class Main extends Application {
    private Stage gameStage;
    private GameContent gameContent;
    @Override
    public void start(Stage primaryStage) throws Exception {
        gameStage = primaryStage;
        gameContent = new GameContent();
        gameStage.setScene(new Scene(gameContent.createCanvas(gameStage,1280, 720), 1280, 720, true, SceneAntialiasing.BALANCED));
        GameController gameController = new GameController(new GameProcess(gameContent));
        gameController.setController();
        gameStage.setTitle("3D piano");
        gameStage.show();
    }
    public static void main(String[] args) {
        launch(args);
    }
}

import javafx.geometry.Insets;
import javafx.geometry.Point3D;
import javafx.scene.Parent;
import javafx.scene.PerspectiveCamera;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.Pane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.paint.Color;
import javafx.scene.shape.Box;
import javafx.scene.transform.Rotate;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.Arrays;

public class GameContent {
    public double windowWIDTH, windowHEIGHT;
    public Pane pane;
    public Stage gameStage;
    public PerspectiveCamera camera;
    public MediaPlayer mediaPlayer;
    public ArrayList<Box> tiles;
    public boolean rotateTiles = false;

    public Parent createCanvas(Stage stage, double windowWIDTH, double windowHEIGHT) throws Exception {
        gameStage = stage;
        pane = new Pane();
        this.windowWIDTH = windowWIDTH;
        this.windowHEIGHT = windowHEIGHT;
        createContent();
        return pane;
    }

    private void createContent() throws Exception {
        pane.setPrefSize(windowWIDTH, windowHEIGHT);
        setUpBackground();
        setUpCamera();
        createTiles();
        createTilesBehaviour();
        setSound();
    }

    private void setSound() {
        String musicFile = "sounds/Nightcall.mp3";
        mediaPlayer = new MediaPlayer(new Media(this.getClass().getResource(musicFile).toExternalForm()));

    }

    private void createTilesBehaviour() {
        for(Box tile : tiles) {
            tile.getTransforms().add(new Rotate(0, Rotate.Z_AXIS));
            tile.setOnMousePressed(e-> tileActionPressed(tile));
            tile.setOnMouseReleased(e-> tileActionReleased(tile));
        }
    }

    public void createSceneKeyAction(boolean pressed) {
        if(pressed) {
            gameStage.getScene().setOnKeyPressed(e-> {
                switch(e.getCode()) {
                    case Z:
                        tileActionPressed(tiles.get(0));
                        break;
                    case X:
                        tileActionPressed(tiles.get(1));
                        break;
                    case C:
                        tileActionPressed(tiles.get(2));
                        break;
                    case V:
                        tileActionPressed(tiles.get(3));
                        break;
                    case B:
                        tileActionPressed(tiles.get(4));
                        break;
                    case N:
                        tileActionPressed(tiles.get(5));
                        break;
                    case M:
                        tileActionPressed(tiles.get(6));
                        break;
                }
            });
        } else {
            gameStage.getScene().setOnKeyReleased(e-> {
                switch(e.getCode()) {
                    case Z:
                        tileActionReleased(tiles.get(0));
                        break;
                    case X:
                        tileActionReleased(tiles.get(1));
                        break;
                    case C:
                        tileActionReleased(tiles.get(2));
                        break;
                    case V:
                        tileActionReleased(tiles.get(3));
                        break;
                    case B:
                        tileActionReleased(tiles.get(4));
                        break;
                    case N:
                        tileActionReleased(tiles.get(5));
                        break;
                    case M:
                        tileActionReleased(tiles.get(6));
                        break;
                }
            });
        }

    }

    private void tileActionPressed(Box tile) {
        rotateTiles = true;
        ((Rotate)tile.getTransforms().get(0)).setAngle(5);
        tile.setDepth(50);
        playSound(true);
    }

    private void tileActionReleased(Box tile) {
        rotateTiles = false;
        ((Rotate)tile.getTransforms().get(0)).setAngle(0);
        tile.setDepth(100);
        playSound(false);
    }

    private void playSound(boolean play) {
        if(play) {
            mediaPlayer.play();
        } else {
            mediaPlayer.pause();
        }
    }

    private void setUpBackground() {
        ImageView backgroundImage = new ImageView(new Image("imgs/Space.png"));
        backgroundImage.setFitWidth(17776);
        backgroundImage.setFitHeight(10000);
        backgroundImage.setTranslateX(-1000);
        backgroundImage.setTranslateY(-1000);
        pane.getChildren().add(backgroundImage);
    }

    private void setUpCamera() {
        camera = new PerspectiveCamera(false);
        Rotate Xrotate = new Rotate(30, Rotate.X_AXIS);
        Rotate Zrotate = new Rotate(0, Rotate.Z_AXIS);
        Rotate Yrotate = new Rotate(0, Rotate.Y_AXIS);
        Zrotate.setPivotX(windowWIDTH/2);
        Zrotate.setPivotY(windowHEIGHT/2);
        Zrotate.setAngle(45);
        camera.getTransforms().addAll(Xrotate, Zrotate, Yrotate);
        camera.setTranslateZ(-800);
        camera.setTranslateY(200);
    }

    private void createTiles() throws Exception {
        tiles = new ArrayList<>();
        for(int i = 1; i <= 7; i++)
            tiles.add(new Tile(i).getTile());
        pane.getChildren().addAll(tiles);
    }
}

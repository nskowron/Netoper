package app;

import javafx.application.Platform;
import javafx.geometry.Rectangle2D;
import javafx.scene.Scene;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseButton;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class BatScene {
    private static ImageView batView = new ImageView(BatImg.idle);
    private static boolean tapState = false;
    private static double offsetX = 0;
    private static double offsetY = 0;

    private BatScene() throws InstantiationError {
        throw new InstantiationError("Static Class: BatScene");
    }

    public static void setScene(Stage stage) {
        // set scene size and fill
        batView.setViewport(new Rectangle2D(425, 160, 570, 370));
        batView.setScaleX(0.5);
        batView.setScaleY(0.5);
        batView.setTranslateX(-140);
        batView.setTranslateY(-90);
        batView.setManaged(false);
        Scene scene = new Scene(new StackPane(batView), 285, 185);
        scene.setFill(null);

        stage.setX(100);
        stage.setY(0);

        // dragging
        scene.setOnMousePressed(e -> {
            offsetX = e.getSceneX();
            offsetY = e.getSceneY();
        });
        scene.setOnMouseDragged(e -> {
            stage.setX(e.getScreenX() - offsetX);
            stage.setY(e.getScreenY() - offsetY);
        });

        // close app
        scene.setOnMouseClicked(e -> {
            if(e.getButton() == MouseButton.SECONDARY) {
                Platform.exit();
                System.exit(0);
            }
        });

        stage.setScene(scene);
    }

    // tap mechanics
    public static void tap() {
        batView.setImage(BatImg.tap[tapState ? 1 : 0]);
        tapState = !tapState;
    }

    public static void untap() {
        batView.setImage(BatImg.idle);
    }
}

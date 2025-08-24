package app;

import javafx.geometry.Rectangle2D;
import javafx.scene.Scene;
import javafx.scene.image.ImageView;
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
        batView.setViewport(new Rectangle2D(425, 150, 570, 370));
        Scene scene = new Scene(new StackPane(batView));
        scene.setFill(null);

        // tap mechanics
        scene.setOnKeyPressed(e -> {
            batView.setImage(BatImg.tap[tapState ? 1 : 0]);
            tapState = !tapState;
        });
        scene.setOnKeyReleased(e -> batView.setImage(BatImg.idle));

        // dragging
        scene.setOnMousePressed(e -> {
            offsetX = e.getSceneX();
            offsetY = e.getSceneY();
        });
        scene.setOnMouseDragged(e -> {
            stage.setX(e.getScreenX() - offsetX);
            stage.setY(e.getScreenY() - offsetY);
        });

        stage.setScene(scene);
    }
}

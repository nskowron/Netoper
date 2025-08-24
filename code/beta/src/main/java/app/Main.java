package app;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class Main extends Application{
    @Override
    public void start(Stage stage) {
        // set stage
        stage.initStyle(StageStyle.TRANSPARENT);
        stage.setAlwaysOnTop(true);
        BatScene.setScene(stage);
        new TapListener();
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
package app;

import javafx.scene.image.Image;

public class BatImg {
    public static Image idle = new Image("file:img/idle.png");
    public static Image[] tap = {
        new Image("file:img/tap_left.png"),
        new Image("file:img/tap_right.png")
    };

    private BatImg() throws InstantiationError {
        throw new InstantiationError("Static Class: BatImg");
    }
}

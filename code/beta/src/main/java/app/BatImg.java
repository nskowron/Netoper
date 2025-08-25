package app;

import javafx.scene.image.Image;

public class BatImg {
    public static Image idle = new Image("img/idle.png");
    public static Image[] tap = {
        new Image("img/tap_left.png"),
        new Image("img/tap_right.png")
    };

    private BatImg() throws InstantiationError {
        throw new InstantiationError("Static Class: BatImg");
    }
}

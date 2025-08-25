package app;

import com.github.kwhat.jnativehook.GlobalScreen;
import com.github.kwhat.jnativehook.NativeHookException;
import com.github.kwhat.jnativehook.keyboard.NativeKeyEvent;
import com.github.kwhat.jnativehook.keyboard.NativeKeyListener;
import com.github.kwhat.jnativehook.mouse.NativeMouseEvent;
import com.github.kwhat.jnativehook.mouse.NativeMouseListener;

public class TapListener implements NativeKeyListener, NativeMouseListener {
    public TapListener() {
        try {
            GlobalScreen.registerNativeHook();
            GlobalScreen.addNativeKeyListener(this);
            GlobalScreen.addNativeMouseListener(this);
        } catch (NativeHookException ex) {
            ex.printStackTrace();
        }

        Runtime.getRuntime().addShutdownHook(new Thread(() -> {
            try {
                GlobalScreen.unregisterNativeHook();
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }));
    }
    
    @Override
    public void nativeKeyPressed(NativeKeyEvent e) {
        BatScene.tap();
    }

    @Override
    public void nativeKeyReleased(NativeKeyEvent e) {
        BatScene.untap();
    }

    @Override
    public void nativeKeyTyped(NativeKeyEvent e) {}

        @Override
    public void nativeMousePressed(NativeMouseEvent e) {
        BatScene.tap();
    }

    @Override
    public void nativeMouseReleased(NativeMouseEvent e) {
        BatScene.untap();
    }

    @Override
    public void nativeMouseClicked(NativeMouseEvent e) {}
}

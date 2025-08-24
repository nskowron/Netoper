package app;

import com.github.kwhat.jnativehook.GlobalScreen;
import com.github.kwhat.jnativehook.NativeHookException;
import com.github.kwhat.jnativehook.keyboard.NativeKeyEvent;
import com.github.kwhat.jnativehook.keyboard.NativeKeyListener;

public class TapListener implements NativeKeyListener {
    public TapListener() {
        try {
            GlobalScreen.registerNativeHook();
            GlobalScreen.addNativeKeyListener(this);
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
}

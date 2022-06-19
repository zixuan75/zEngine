package zEngine.input.keys;

import zEngine.glfw.Display;

public interface KeyReceiver {
    void handleKeyEvent(KeyEvent event);

    public static void add(KeyReceiver receiver) {
        Display.getKeyDevice().addReceiver(receiver);
    }
}

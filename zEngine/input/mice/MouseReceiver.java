package zEngine.input.mice;

import zEngine.glfw.Display;

public interface MouseReceiver {
    void handleMouseEvent(MouseEvent event);

    public static void add(MouseReceiver receiver) {
        Display.getMouse().addReceiver(receiver);
    }
}

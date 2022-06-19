package zEngine.input.keys;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.lwjgl.glfw.GLFW;
import org.lwjgl.glfw.GLFWKeyCallback;

public class KeyDevice {

    private Map<Integer, KeyEvent> pressEvents = new HashMap<>();
    private List<KeyReceiver> receivers = new ArrayList<>();
    private GLFWKeyCallback callback;

    public KeyDevice() {
        for (int i = 0; i < Key.KEY_LAST; i++) {
            pressEvents.put(i, new KeyEvent(i, Key.NO_MODIFIER)); 
        }
        callback = new GLFWKeyCallback() {

            @Override
            public void invoke(long window, int keyId, int scancode, int action, int mods) {
                KeyEvent event = pressEvents.get(keyId);
                event.addNewEvent(mods);
                for (KeyReceiver receiver: receivers) {
                    receiver.handleKeyEvent(event);
                }
            }
            
        };


    }

    public void bind(long window) {
        GLFW.glfwSetKeyCallback(window, callback);
    }

    public void addReceiver(KeyReceiver receiver) {
        receivers.add(receiver);
    }
}

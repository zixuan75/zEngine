package zEngine.input.keys;

import org.lwjgl.glfw.GLFW;
import org.lwjgl.glfw.GLFWKeyCallback;

public class KeyDevice {
    public Key[] keys = new Key[Key.KEY_LAST];
    private GLFWKeyCallback callback;

    public KeyDevice() {
        for (int i = 0; i < keys.length; i++) {
            keys[i] = new Key();
            keys[i].key = i;
        }
        callback = new GLFWKeyCallback() {

            @Override
            public void invoke(long window, int keyId, int scancode, int action, int mods) {
                
                Key key = keys[keyId];  
                key.pressed = (action != GLFW.GLFW_RELEASE);
                keys[keyId] = key;
            }
            
        };


    }

    /**
     * Checks whether a key is pressed
     * @param keyId
     * @return a boolean
     */
    public boolean isPressed(int keyId) {
        Key key = keys[keyId];  
        boolean res = key.pressed;
        key.prev = key.pressed;
        return res;
    }

    /**
     * Similar to isPressed, but checks whether a key is pressed but not held
     * This function is recommended instead of isPressed for precise measure
     * ments.
     * @param keyId
     * @return a boolean
     */
    public boolean isPressedOnce(int keyId) {
        Key key = keys[keyId];  
        boolean res = key.pressed && (!key.prev);
        key.prev = key.pressed;
        return res;
    }

    public void bind(long window) {
        GLFW.glfwSetKeyCallback(window, callback);
    }
}

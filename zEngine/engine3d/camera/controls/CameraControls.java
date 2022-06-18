package zEngine.engine3d.camera.controls;

import static zEngine.input.keys.Key.*;

import zEngine.glfw.Display;
import zEngine.input.keys.KeyDevice;
import zEngine.util.vector.Vector3f;

public class CameraControls {
    private static final int MAX_KEYS = 2;
    // public int[] keys_up = {KEY_SPACE};
    // public int[] keys_down = {KEY_LSHIFT};
    // public int[] keys_left = {KEY_A, KEY_LEFT};
    // public int[] keys_right = {KEY_D, KEY_RIGHT};
    // public int[] keys_forward = {KEY_W, KEY_UP};
    // public int[] keys_backward = {KEY_S, KEY_DOWN};
    public int[] keys_up       = new int[MAX_KEYS];
    public int[] keys_down     = new int[MAX_KEYS];
    public int[] keys_left     = new int[MAX_KEYS];
    public int[] keys_right    = new int[MAX_KEYS];
    public int[] keys_forward  = new int[MAX_KEYS];
    public int[] keys_backward = new int[MAX_KEYS];
    public int orient = Orientation.EYE_ORIENT;
    public float moveSpeed = 0.2f;

    public CameraControls() {
        setDefaultKeys();
    }
    public void keyUpdate(Vector3f position, Vector3f rotation) {
        float x = (float) Math.sin(Math.toRadians(rotation.y)) * moveSpeed;
		float z = (float) Math.cos(Math.toRadians(rotation.y)) * moveSpeed;
    }
    public void mouseUpdate(Vector3f rotation) {

    }
    private void setDefaultKeys() {
        keys_up[0] = KEY_SPACE;
        keys_up[1] = keys_up[2] = keys_up[3] = NO_KEY;
        
        keys_down[0] = KEY_LSHIFT;
        keys_down[1] = keys_down[2] = keys_down[3] = NO_KEY;

        keys_left[0] = KEY_A;
        keys_left[1] = KEY_LEFT;
        keys_left[2] = keys_left[3] = NO_KEY;

        keys_right[0] = KEY_D;
        keys_right[1] = KEY_RIGHT;
        keys_right[2] = keys_right[3] = NO_KEY;

        keys_forward[0] = KEY_W;
        keys_forward[1] = KEY_UP;
        keys_forward[2] = keys_forward[3] = NO_KEY;

        keys_backward[0] = KEY_S;
        keys_backward[1] = KEY_DOWN;
        keys_backward[2] = keys_backward[3] = NO_KEY;
    }
    private boolean keyPressed(int[] keys) {
        boolean keyPressed = false;
        for (int i = 0; i < MAX_KEYS; i++) {
            int key = keys[i];
            if (Display.getKeyDevice().isPressed(key)) {keyPressed = true; }
        }
        return keyPressed;
    }
}

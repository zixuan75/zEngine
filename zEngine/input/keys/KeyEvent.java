package zEngine.input.keys;

import org.lwjgl.glfw.GLFW;

public class KeyEvent {
    
    protected int key;
    protected int action;
    protected int modifier;
    protected KeyEvent lastEvent;

    protected KeyEvent(int key) {
        this.key = key;
        this.action = GLFW.GLFW_RELEASE;
        this.modifier = Key.NO_MODIFIER;
    }

    protected KeyEvent(KeyEvent other) {
        this.key = other.key;
        this.action = other.action;
        this.modifier = other.modifier;
        this.lastEvent = other.lastEvent;
    }

    protected void addNewEvent(int modifier, int action) {
        KeyEvent temp = new KeyEvent(this);
        this.modifier = modifier;
        this.action = action;
        this.lastEvent = temp;
    }

    public int key() {
        return key;
    }

    public int modifier() {
        return modifier;
    }

    public KeyEvent lastEvent() {
        return lastEvent;
    }
}

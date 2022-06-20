package zEngine.input.mice;

import org.lwjgl.glfw.GLFW;

import zEngine.util.vector.Vector2f;

public class MouseEvent {
    
    protected int button;
    protected int action;
    protected Vector2f mousePos;
    protected MouseEvent lastEvent;

    protected MouseEvent(int button) {
        this.button = button;
        this.action = GLFW.GLFW_RELEASE;
        this.mousePos = new Vector2f();
    }

    protected MouseEvent(MouseEvent other) {
        this.button = other.button;
        this.action = other.action;
        this.mousePos = other.mousePos;
        this.lastEvent = other.lastEvent;
    }

    protected void addNewEvent(Vector2f mousePos, int action) {
        MouseEvent temp = new MouseEvent(this);
        this.mousePos = mousePos;
        this.action = action;
        this.lastEvent = temp;
    }

    public int button() {
        return button;
    }

    public int action() {
        return action;
    }

    public Vector2f mousePos() {
        return mousePos;
    }
    
    protected void setMousePos(Vector2f mousePos) {this.mousePos = mousePos; }

    public MouseEvent lastEvent() {
        return lastEvent;
    }
}

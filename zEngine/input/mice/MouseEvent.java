package zEngine.input.mice;

import zEngine.util.vector.Vector2f;

public class MouseEvent {
    
    protected int button;
    protected Vector2f mousePos;
    protected MouseEvent lastEvent;

    protected MouseEvent(int button, Vector2f mousePos) {
        this.button = button;
        this.mousePos = mousePos;
    }

    protected MouseEvent(MouseEvent other) {
        this.button = other.button;
        this.mousePos = other.mousePos;
        this.lastEvent = other.lastEvent;
    }

    protected void addNewEvent(Vector2f mousePos) {
        MouseEvent temp = new MouseEvent(this);
        this.mousePos = mousePos;
        this.lastEvent = temp;
    }

    public int button() {
        return button;
    }

    public Vector2f mousePos() {
        return mousePos;
    }

    public MouseEvent lastEvent() {
        return lastEvent;
    }
}

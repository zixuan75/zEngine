package zEngine.input.keys;

public class KeyEvent {
    
    protected int key;
    protected int modifier;
    protected KeyEvent lastEvent;

    protected KeyEvent(int key, int modifier) {
        this.key = key;
        this.modifier = modifier;
    }

    protected KeyEvent(KeyEvent other) {
        this.key = other.key;
        this.modifier = other.modifier;
        this.lastEvent = other.lastEvent;
    }

    protected void addNewEvent(int modifier) {
        KeyEvent temp = new KeyEvent(this);
        this.modifier = modifier;
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

package zEngine.application;

import zEngine.input.keys.KeyReceiver;

public class DisplaySettings {
    public int width = 1024;
    public int height = 768;
    public String title = "Untitled";
    public boolean centered = true;
    public KeyReceiver receiver;

    public DisplaySettings() {}

    public DisplaySettings(int width, int height) {
        this.width = width;
        this.height = height;
    }
}

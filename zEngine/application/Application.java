package zEngine.application;

import zEngine.glfw.Display;
import zEngine.glfw.DisplayBuilder;

public abstract class Application {
    protected Display display;
    protected boolean closed = false;

    /**
     * Helper function; creates the display
     * @param settings the display settings
     * @param format the format
     */
    protected void createDisplay(DisplaySettings settings, Format format) {
        DisplayBuilder builder = new DisplayBuilder();
        builder.setContextAttribs(format.attribs);
        display = builder.create(settings.width, settings.height, 
            settings.title, settings.centered);
        display.setCurrentContext();
    }

    public abstract void start();
    public abstract void paint();
    public abstract void end();
    public abstract void update();

    protected void close() {
        this.closed = true;
    }
}
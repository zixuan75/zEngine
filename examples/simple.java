package examples;

import zEngine.glfw.ContextAttribs;
import zEngine.glfw.Display;
import zEngine.glfw.DisplayBuilder;

class SimpleExample {
    public static void main(String[] args) {
        DisplayBuilder builder = new DisplayBuilder();
        ContextAttribs attribs = new ContextAttribs()
            .withDefaultHints();
        builder.setContextAttribs(attribs);
        Display display = builder.create(1280, 760, "Window", true);
        display.setCurrentContext();

        while (!display.isCloseRequested()) {
            display.update(); 
        }
        display.close();
    }
}
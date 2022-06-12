package examples;

import zEngine.glfw.ContextAttribs;
import zEngine.glfw.Display;

class SimpleExample {
    public static void main(String[] args) {
        /**
         * Initializes GLFW and creates the GLFW window.
         */
        Display.init();
        ContextAttribs attribs = new ContextAttribs()
            .withVersion(4, 0)
            .withProfileCore();
        Display.setContextAttribs(attribs);
        Display.create(1280, 760, "Window");

        while (!Display.isCloseRequested()) {
            Display.update();
        }

        /** 
         * Closes the window and terminates GLFW.
         */
        Display.close();
    }
}
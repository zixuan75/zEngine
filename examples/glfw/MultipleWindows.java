package examples.glfw;

import org.lwjgl.opengl.GL11;

import zEngine.glfw.*;

/**
 * This is an example that shows two windows with different colors.
 * The current context continually switches between the two windows.
 */

class MultipleWindows {
    public static void main(String[] args) {
        Display display1 = buildWindow(300, 300, "Window 1");
        display1.setCenterPosition(0.4f, 0.4f);

        Display display2 = buildWindow(300, 300, "Window 2");
        display2.setCenterPosition(0.6f, 0.6f);

        while ((!display1.isCloseRequested()) && (!display2.isCloseRequested())) {
            display1.setCurrentContext();
            GL11.glClearColor(1, 0, 0, 0);
            GL11.glClear(GL11.GL_COLOR_BUFFER_BIT);
            display1.update();

            display2.setCurrentContext();
            GL11.glClearColor(0, 0, 1, 0);
            GL11.glClear(GL11.GL_COLOR_BUFFER_BIT);
            display2.update();
        }
        display1.close();
        display2.close();
    }

    private static Display buildWindow(int width, int height, String title) {
        DisplayBuilder builder = new DisplayBuilder();
        ContextAttribs attribs = new ContextAttribs()
            .withDefaultHints();
        builder.setContextAttribs(attribs);
        return builder.create(width, height, title, true);
    }
}

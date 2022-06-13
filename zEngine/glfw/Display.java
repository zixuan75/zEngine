package zEngine.glfw;

import org.lwjgl.glfw.GLFW;
import org.lwjgl.glfw.GLFWFramebufferSizeCallback;
import org.lwjgl.glfw.GLFWVidMode;
import org.lwjgl.opengl.GL;

/**
 * A class for handling the display. 
 * 
 * @author zixuan
 */

public class Display {
    protected long window;
    protected ContextAttribs attribs;
    protected int width;
    protected int height;
    protected GLFWFramebufferSizeCallback framebufferSizeCallback;
    public static Display current;

    protected static void setCurrentDisplay(Display display) {
        current = display;
    }

    public static int getWidth() {
        return current.width;
    }

    public static int getHeight() {
        return current.height;
    }

    public void setCurrentContext() {
        GLFW.glfwMakeContextCurrent(window);
        GL.createCapabilities();
        GLFW.glfwSwapInterval(1);
        GLFW.glfwShowWindow(window);
        setCurrentDisplay(this);
    }

    public void update() {
        GLFW.glfwSwapBuffers(window);
        GLFW.glfwPollEvents();
    }

    public void setCenterPosition(float x, float y) {
        GLFWVidMode vid =   GLFW.glfwGetVideoMode(GLFW.glfwGetPrimaryMonitor());
        int x_over_width =            (int) ((x *  vid.width()) -  (width / 2));
        int y_over_height =           (int) ((y * vid.height()) - (height / 2));
        GLFW.glfwSetWindowPos          (window,  x_over_width,   y_over_height);
    }

    public boolean isCloseRequested() {
        return GLFW.glfwWindowShouldClose(window);
    }

    public void close() {
        GLFW.glfwDestroyWindow(window);
        GLFW.glfwTerminate();
    }

    public int getSamples() {
        if (attribs != null) {
            return attribs.samples;
        }
        return 1;
    }
}

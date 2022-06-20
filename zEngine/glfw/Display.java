package zEngine.glfw;

import org.lwjgl.glfw.GLFW;
import org.lwjgl.glfw.GLFWFramebufferSizeCallback;
import org.lwjgl.glfw.GLFWVidMode;
import org.lwjgl.opengl.GL;

import zEngine.input.keys.KeyDevice;
import zEngine.input.mice.Mouse;

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
    public KeyDevice kDevice;
    public Mouse mouse;
    public static Display current;

    protected static void setCurrentDisplay(Display display) {
        current = display;
    }

    /**
     * 
     * @return width of current display
     */
    public static int getWidth() {
        return current.width;
    }

    /**
     * 
     * @return height of current display
     */
    public static int getHeight() {
        return current.height;
    }

    /**
     * 
     * @return key device of current display
     */
    public static KeyDevice getKeyDevice() {
        return current.kDevice;
    }

    /**
     * 
     * @return mouse of current display
     */
    public static Mouse getMouse() {
        return current.mouse;
    }

    /**
     * Sets the current context to the window
     */
    public void setCurrentContext() {
        GLFW.glfwMakeContextCurrent(window);
        GL.createCapabilities();
        GLFW.glfwSwapInterval(1);
        GLFW.glfwShowWindow(window);
        setCurrentDisplay(this);
    }

    /**
     * Updates the window
     */
    public void update() {
        GLFW.glfwSwapBuffers(window);
        GLFW.glfwPollEvents();
    }

    /**
     * Sets the position of the center of the window
     * @param x
     * @param y
     */
    public void setCenterPosition(float x, float y) {
        GLFWVidMode vid =   GLFW.glfwGetVideoMode(GLFW.glfwGetPrimaryMonitor());
        int x_over_width =            (int) ((x *  vid.width()) -  (width / 2));
        int y_over_height =           (int) ((y * vid.height()) - (height / 2));
        GLFW.glfwSetWindowPos          (window,  x_over_width,   y_over_height);
    }

    /**
     * 
     * @return whether window should be closed
     */
    public boolean isCloseRequested() {
        return GLFW.glfwWindowShouldClose(window);
    }

    /**
     * Closes the window
     */
    public void close() {
        GLFW.glfwDestroyWindow(window);
        GLFW.glfwTerminate();
    }

    /**
     * 
     * @return the amount of samples
     */
    public int getSamples() {
        if (attribs != null) {
            return attribs.samples;
        }
        return 1;
    }
}

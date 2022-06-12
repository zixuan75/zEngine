package zEngine.glfw;

import org.lwjgl.glfw.GLFW;
import org.lwjgl.glfw.GLFWVidMode;
import static org.lwjgl.system.MemoryUtil.*;

import org.lwjgl.opengl.GL;

/**
 * A class for handling the display. 
 * 
 * @author zixuan
 */

public class Display {
    private static long window;
    private static ContextAttribs attribs;
    public static void init() {
        if (!GLFW.glfwInit()) {
            throw new IllegalStateException("GLFW.glfwInit failed; could not initialize GLFW");
        }
    }

    public static void setContextAttribs(ContextAttribs contextAttribs) {
        attribs = contextAttribs;
    }

    public static void create(int width, int height, String title) {
        window = GLFW.glfwCreateWindow(width, height, title, NULL, NULL);
        if (window == NULL) {
            throw new RuntimeException("GLFW.glfwCreateWindow failed; could not create window");
        }
        if (attribs == null) {
            throw new RuntimeException("Context attributes null");
        }

        GLFWVidMode vid = GLFW.glfwGetVideoMode(GLFW.glfwGetPrimaryMonitor());
        GLFW.glfwSetWindowPos(window, (vid.width() - width)/2, 
                (vid.height() - height)/2);

        GLFW.glfwMakeContextCurrent(window);
        GL.createCapabilities();
        GLFW.glfwSwapInterval(1);
        GLFW.glfwShowWindow(window);
    }

    public static void update() {
        GLFW.glfwSwapBuffers(window);
        GLFW.glfwPollEvents();
    }

    public static boolean isCloseRequested() {
        return GLFW.glfwWindowShouldClose(window);
    }

    public static void close() {
        GLFW.glfwDestroyWindow(window);
        GLFW.glfwTerminate();
    }

    public static int getSamples() {
        if (attribs != null) {
            return attribs.samples;
        }
        return 1;
    }
}

package zEngine.glfw;

import org.lwjgl.glfw.GLFW;
import org.lwjgl.glfw.GLFWFramebufferSizeCallback;

import zEngine.input.keys.KeyDevice;

import static org.lwjgl.system.MemoryUtil.*;

public class DisplayBuilder {
    private long window;
    private ContextAttribs attribs;

    public DisplayBuilder() {
        if (!GLFW.glfwInit()) {
            throw new IllegalStateException("GLFW.glfwInit failed");
        }
    }

    public void setContextAttribs(ContextAttribs contextAttribs) {
        attribs = contextAttribs;
    }

    public Display create(int width, int height, String title, boolean centered) {
        window = GLFW.glfwCreateWindow(width, height, title, NULL, NULL);
        if (window == NULL) {
            throw new RuntimeException("GLFW.glfwCreateWindow failed; could not create window");
        }
        if (attribs == null) {
            throw new RuntimeException("Context attributes null");
        }

        Display display = new Display();
        display.window = this.window;
        display.attribs = this.attribs;
        display.width = width;
        display.height = height;
        display.framebufferSizeCallback = new GLFWFramebufferSizeCallback() {

            @Override
            public void invoke(long window, int width, int height) {
                display.width = width;
                display.height = height;
            }
            
        };
        display.kDevice = new KeyDevice();
        display.kDevice.bind(display.window);
        GLFW.glfwSetFramebufferSizeCallback(display.window, display.framebufferSizeCallback);
        if (centered) {
            display.setCenterPosition(0.5f, 0.5f);
        }
        return display;
    }
}

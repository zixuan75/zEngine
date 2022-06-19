package zEngine.input.mice;

import java.util.*;

import org.lwjgl.glfw.GLFW;
import org.lwjgl.glfw.GLFWCursorPosCallback;
import org.lwjgl.glfw.GLFWMouseButtonCallback;

import zEngine.util.vector.Vector2f;

public class Mouse {

    private Map<Integer, MouseEvent> pressEvents = new HashMap<>();
    private List<MouseReceiver> receivers = new ArrayList<>();
    private Vector2f mousePos;

    private GLFWMouseButtonCallback mousePressCallback;
    private GLFWCursorPosCallback mouseMoveCallback;
    
    public Mouse() {
        for (int i = 0; i < MousePress.MOUSE_BUTTON_LAST; i++) {
            pressEvents.put(i, new MouseEvent(i, new Vector2f())); 
        }
        mousePressCallback = new GLFWMouseButtonCallback() {

            @Override
            public void invoke(long window, int button, int action, int mods) {
                MouseEvent event = pressEvents.get(button);
                event.addNewEvent(mousePos);
                for (MouseReceiver receiver: receivers) {
                    receiver.handleMouseEvent(event);
                }
            }
            
        };
    }

    public void bind(long window) {
        GLFW.glfwSetMouseButtonCallback(window, mousePressCallback);
        GLFW.glfwSetCursorPosCallback(window, mouseMoveCallback);
    }
}

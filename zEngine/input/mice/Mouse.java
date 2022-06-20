package zEngine.input.mice;

import java.util.*;

import org.lwjgl.glfw.GLFW;
import org.lwjgl.glfw.GLFWCursorPosCallback;
import org.lwjgl.glfw.GLFWMouseButtonCallback;

import zEngine.util.vector.Vector2f;

public class Mouse {

    private Map<Integer, MouseEvent> pressEvents = new HashMap<>();
    private List<MouseReceiver> receivers = new ArrayList<>();
    private Map<MouseReceiver, MouseEvent> receiversToEvents = new HashMap<>();
    private Vector2f mousePos = new Vector2f();

    private GLFWMouseButtonCallback mousePressCallback;
    private GLFWCursorPosCallback mouseMoveCallback;
    
    public Mouse() {
        for (int i = 0; i < MousePress.BUTTON_LAST; i++) {
            pressEvents.put(i, new MouseEvent(i)); 
        }
        mousePressCallback = new GLFWMouseButtonCallback() {

            @Override
            public void invoke(long window, int button, int action, int mods) {
                MouseEvent event = pressEvents.get(button);
                event.addNewEvent(mousePos, action);
                for (MouseReceiver receiver: receivers) {
                    receiver.handleMouseEvent(event);
                    receiversToEvents.put(receiver, event);
                }
            }
        };

        mouseMoveCallback = new GLFWCursorPosCallback() {

            @Override
            public void invoke(long window, double xpos, double ypos) {
                mousePos.set((float) xpos, (float) ypos);
            }
            
        };
    }

    public void bind(long window) {
        GLFW.glfwSetMouseButtonCallback(window, mousePressCallback);
        GLFW.glfwSetCursorPosCallback(window, mouseMoveCallback);
    }

    public void addReceiver(MouseReceiver receiver) {
        receivers.add(receiver);
    }

    public void invoke(MouseReceiver receiver) {
        if (receiversToEvents.containsKey(receiver)) {
            MouseEvent event = receiversToEvents.get(receiver);
            event.setMousePos(mousePos);
            receiver.handleMouseEvent(event);
        }
    }
}

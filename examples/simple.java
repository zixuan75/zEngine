package examples;

import zEngine.glfw.ContextAttribs;
import zEngine.glfw.Display;
import zEngine.glfw.DisplayBuilder;
import org.lwjgl.system.MemoryStack;
import java.nio.FloatBuffer;
import static org.lwjgl.opengl.GL.*;
import static org.lwjgl.opengl.GL15.*;
import static org.lwjgl.system.MemoryUtil.*;
import static org.lwjgl.system.MemoryStack.*;

class SimpleExample {
    public static void main(String[] args) {
        DisplayBuilder builder = new DisplayBuilder();
        ContextAttribs attribs = new ContextAttribs()
            .withDefaultHints();
        builder.setContextAttribs(attribs);
        Display display = builder.create(1280, 760, "Window", true);
        display.setCurrentContext();

        
        try (MemoryStack stack = stackPush()) {
            /*
             * The following code is identical to Intro3.
             */
            FloatBuffer buffer = stackMallocFloat(3 * 2);
            buffer.put(-0.5f).put(-0.5f);
            buffer.put(+0.5f).put(-0.5f);
            buffer.put(+0.0f).put(+0.5f);
            buffer.flip();
            int vbo = glGenBuffers();
            glBindBuffer(GL_ARRAY_BUFFER, vbo);
            glBufferData(GL_ARRAY_BUFFER, buffer, GL_STATIC_DRAW);

            /*
             * Notice that we do not need a stackPop() here! It will be done automatically at the end of the
             * try-with-resources statement, even in the event of an exception, which was the sole purpose of doing it
             * this way, in the first place.
             */
        }
        glEnableClientState(GL_VERTEX_ARRAY);
        glVertexPointer(2, GL_FLOAT, 0, 0L);
        while (!display.isCloseRequested()) {
            glDrawArrays(GL_TRIANGLES, 0, 3);
            display.update(); 
        }
        display.close();
    }
}
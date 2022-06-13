package examples;

import zEngine.glfw.ContextAttribs;
import zEngine.glfw.Display;
import zEngine.glfw.DisplayBuilder;

import org.lwjgl.opengl.GL11;
import org.lwjgl.opengl.GL20;
import org.lwjgl.opengl.GL30;
import org.lwjgl.system.MemoryStack;
import java.nio.FloatBuffer;
import static org.lwjgl.opengl.GL15.*;
import static org.lwjgl.system.MemoryStack.*;

class SimpleExample {
    public static void main(String[] args) {
        DisplayBuilder builder = new DisplayBuilder();
        ContextAttribs attribs = new ContextAttribs()
            .withDefaultHints();
        builder.setContextAttribs(attribs);
        Display display = builder.create(1280, 760, "Window", true);
        display.setCurrentContext();

        int vao = GL30.glGenVertexArrays();
        GL30.glBindVertexArray(vao);
        int vbo;
        try (MemoryStack stack = stackPush()) {
            FloatBuffer buffer = stackMallocFloat(3 * 2);
            buffer.put(-0.5f).put(-0.5f);
            buffer.put(+0.5f).put(-0.5f);
            buffer.put(+0.0f).put(+0.5f);
            buffer.flip();
            vbo = glGenBuffers();
            glBindBuffer(GL_ARRAY_BUFFER, vbo);
            glBufferData(GL_ARRAY_BUFFER, buffer, GL_STATIC_DRAW);
        }
        GL20.glVertexAttribPointer(0, 2, GL11.GL_FLOAT, false, 0, 0);
        GL30.glBindVertexArray(0);
        while (!display.isCloseRequested()) { 
            
            GL30.glBindVertexArray(vao);
            GL20.glEnableVertexAttribArray(0);
            glDrawArrays(GL_TRIANGLES, 0, 3);
            GL20.glDisableVertexAttribArray(0);
            GL30.glBindVertexArray(0);
            display.update(); 
        }
        display.close();
    }
}
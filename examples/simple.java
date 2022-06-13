package examples;

import zEngine.glfw.ContextAttribs;
import zEngine.glfw.Display;
import zEngine.glfw.DisplayBuilder;
import zEngine.GL.buffers.Vbo;
import zEngine.GL.shaders.ShaderProgram;

import org.lwjgl.opengl.GL11;
import org.lwjgl.opengl.GL15;
import org.lwjgl.opengl.GL30;

class SimpleExample {
    public static void main(String[] args) {
        DisplayBuilder builder = new DisplayBuilder();
        ContextAttribs attribs = new ContextAttribs()
            .withDefaultHints();
        builder.setContextAttribs(attribs);
        Display display = builder.create(1280, 760, "Window", true);
        display.setCurrentContext();

        ShaderProgram program = ShaderProgram.createProgram("res/simple/triangle.vert.glsl", 
            "res/simple/triangle.frag.glsl");
        int vao = GL30.glGenVertexArrays();
        GL30.glBindVertexArray(vao);
        Vbo vbo = Vbo.create(GL15.GL_STATIC_DRAW, 3, 0, new int[] { 2 });
        vbo.bind();
        vbo.put(-0.5f, -0.5f);
        vbo.put(+0.5f, -0.5f);
        vbo.put(+0.0f, +0.5f);
        vbo.flipAndWrite();
        vbo.unbind();
        GL30.glBindVertexArray(0);
        while (!display.isCloseRequested()) { 
            GL11.glClearColor(0, 0, 0, 0);
            GL11.glClear(GL11.GL_COLOR_BUFFER_BIT);
            program.bind();
            GL30.glBindVertexArray(vao);
            vbo.enable();
            GL11.glDrawArrays(GL11.GL_TRIANGLES, 0, 3);
            vbo.disable();
            GL30.glBindVertexArray(0);
            program.unbind();

            
            
           
            display.update(); 
        }
        display.close();
    }
}
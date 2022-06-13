package examples;

import zEngine.glfw.ContextAttribs;
import zEngine.glfw.Display;
import zEngine.glfw.DisplayBuilder;
import zEngine.GL.buffers.Mesh;
import zEngine.GL.buffers.Vao;
import zEngine.GL.buffers.Vbo;
import zEngine.GL.shaders.ShaderProgram;

import org.lwjgl.opengl.GL11;
import org.lwjgl.opengl.GL15;

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
        
        Mesh mesh = loadMesh();
        while (!display.isCloseRequested()) {
            render(program, mesh);
            display.update(); 
        }

        mesh.destroy();
        display.close();
    }

    private static Mesh loadMesh() {
        Vao vao = Vao.create();
        vao.bind();
        Vbo vbo = Vbo.create(GL15.GL_STATIC_DRAW, 3, 0, new int[] { 2, 3 });
        vbo.bind();
        vbo.put(-1.0f, -1.0f);
        vbo.put(+1.0f, +0.0f, +0.0f);

        vbo.put(+1.0f, -1.0f);
        vbo.put(+0.0f, +0.0f, +1.0f);

        vbo.put(+0.0f, +1.0f);
        vbo.put(+0.0f, +1.0f, +0.0f);
        vbo.flipAndWrite();
        vbo.unbind();
        vao.unbind();
        return new Mesh(vao, vbo);
    }

    private static void render(ShaderProgram program, Mesh mesh) {
        GL11.glClearColor(0, 0, 0, 0);
        GL11.glClear(GL11.GL_COLOR_BUFFER_BIT);
        GL11.glViewport(0, 0, Display.getWidth(), Display.getHeight());
        program.bind();
        mesh.render();
        program.unbind();
    }
}
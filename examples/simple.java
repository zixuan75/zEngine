package examples;

import zEngine.GL.buffers.*;
import zEngine.GL.functions.*;
import zEngine.GL.shaders.ShaderProgram;
import zEngine.glfw.*;

class SimpleExample {
    public static void main(String[] args) {
        Display display = loadDisplay();

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

    private static Display loadDisplay() {
        DisplayBuilder builder = new DisplayBuilder();
        ContextAttribs attribs = new ContextAttribs()
            .withDefaultHints();
        builder.setContextAttribs(attribs);
        Display display = builder.create(1280, 760, "Window", true);
        display.setCurrentContext();
        return display;
    }

    private static Mesh loadMesh() {
        MeshBuilder builder = new MeshBuilder(GLEnum.STATIC_DRAW, 
            3, new int[] { 2, 3 });

        builder.put(-1.0f, -1.0f);
        builder.put(+1.0f, +0.0f, +0.0f);

        builder.put(+1.0f, -1.0f);
        builder.put(+0.0f, +0.0f, +1.0f);

        builder.put(+0.0f, +1.0f);
        builder.put(+0.0f, +1.0f, +0.0f);

        Mesh mesh = builder.getMesh();
        return mesh;
    }

    private static void render(ShaderProgram program, Mesh mesh) {
        GLFunc.glClearColor(0, 0, 0, 0);
        GLFunc.glClear();
        GLFunc.glDimensions(Display.getWidth(), Display.getHeight());
        program.bind();
        mesh.render();
        program.unbind();
    }
}
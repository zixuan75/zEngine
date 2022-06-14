# zEngine - an experimental project

This is a small project I'm working on. I do not intend for this to be a complete game engine; this is purely experimental.


Hello World Triangle:

````java
import zEngine.GL.buffers.*;
import static zEngine.GL.functions.GLFunc.*;
import static zEngine.GL.functions.GLEnum.*;
import zEngine.GL.shaders.ShaderProgram;
import zEngine.application.*;
import zEngine.glfw.*;

class TriangleApp extends Application {
    private Mesh mesh;
    private ShaderProgram program;

    private static final float[] TRIANGLE_VERTS = {
        // Vertex 0
        -1.0f, -1.0f, // Position
        +1.0f, +0.0f, +0.0f, // Color
        // Vertex 1
        +1.0f, -1.0f, // Position
        +0.0f, +0.0f, +1.0f, // Color
        // Vertex 2
        +0.0f, +1.0f, // Position
        +0.0f, +1.0f, +0.0f  // Color
    };

    public static void main(String[] args) {
        TriangleApp app = new TriangleApp();
        app.createDisplay(new DisplaySettings(), new Format());
        AppManager.runApplication(app);
    }

    @Override
    public void start() {
        program = ShaderProgram.createProgram(
            "examples/triangle/triangle.vert.glsl", 
            "examples/triangle/triangle.frag.glsl");
        mesh = loadMesh();
    }

    @Override
    public void update() {
        glClearColor(0, 0, 0, 0);
        glClear();
        glDimensions(Display.getWidth(), Display.getHeight());
        program.bind();
        mesh.render();
        program.unbind();
    }

    @Override
    public void end() {
        mesh.destroy();
    }

    @Override
    public boolean isCloseRequested() {
        return false;
    }

    private Mesh loadMesh() {
        MeshBuilder builder = new MeshBuilder(STATIC_DRAW, 
            3, new int[] { 2, 3 });
        builder.put(TRIANGLE_VERTS);
        Mesh mesh = builder.createMesh();
        return mesh;
    }
}

````

Output:

![Hello World Triangle output](/res/hello_world_triangle.png)
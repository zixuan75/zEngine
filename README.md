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

    private static final String VERTEX_CODE = 
        "#version 330 core\n" + 
        "layout(location = 0) in vec2 position;\n" + 
        "layout(location = 1) in vec3 color;\n" + 
        "out vec4 vColor;\n" + 
        "void main() {\n" + 
        "gl_Position = vec4(position, 0.0, 1.0);\n" + 
        "vColor = vec4(color.r, color.g, color.b, 1.0);\n" +
        "}";

    private static final String FRAGMENT_CODE = 
        "#version 330 core\n" +
        "in vec4 vColor;\n" + 
        "out vec4 fColor;\n" + 
        "void main() {\n" + 
        "fColor = vColor;\n" + 
        "}";

    public static void main(String[] args) {
        TriangleApp app = new TriangleApp();
        app.createDisplay(new DisplaySettings(), new Format());
        AppManager.runApplication(app);
    }

    @Override
    public void start() {
        program = ShaderProgram.createProgram(VERTEX_CODE, FRAGMENT_CODE);
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
            3, 3, new int[] { 2, 3 });
        builder.put(TRIANGLE_VERTS);
        builder.put(0, 1, 2);
        Mesh mesh = builder.createMesh();
        return mesh;
    }
}

````

Output:

![Hello World Triangle output](/res/hello_world_triangle.png)
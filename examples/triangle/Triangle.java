package triangle;

import zEngine.GL.buffers.*;
import static zEngine.GL.functions.GLFunc.*;
import static zEngine.GL.functions.GLEnum.*;
import zEngine.GL.shaders.ShaderProgram;
import zEngine.application.*;
import zEngine.glfw.*;

/**
 * This simple example demonstrates zEngine
 * 
 * @author zixuan
 */
class TriangleApp implements IApplication {

    private Display display;
    private Mesh mesh;
    private ShaderProgram program;

    public static void main(String[] args) {
        TriangleApp app = new TriangleApp();
        AppManager.runApplication(app);
    }

    @Override
    public void start() {
        display = loadDisplay();
        program = ShaderProgram.createProgram(
            "examples/triangle/triangle.vert.glsl", 
            "examples/triangle/triangle.frag.glsl");
        mesh = loadMesh();
    }

    @Override
    public void update() {
        /*
         * The order of clearing, rendering and swapping is 
         * very important.
         * 
         * The order should be -clearing, rendering, updating-
         * as shown.
         *
         * If we clear just after we render, we will have 
         * no output since the screen is cleared afterwards,
         * before we can swap the buffer.
         */

        /* The following two lines clear the screen */
        glClearColor(0, 0, 0, 0);
        glClear();
        /* This line resizes the viewport to fit */
        glDimensions(Display.getWidth(), Display.getHeight());
        /* The following three lines render the triangle */
        program.bind();
        mesh.render();
        program.unbind();
        /* Updates the display and swaps the buffers. */
        display.update(); 
    }

    @Override
    public void end() {
        mesh.destroy();
        display.close();
    }

    @Override
    public boolean isCloseRequested() {
        return display.isCloseRequested();
    }
    
    private Display loadDisplay() {
        DisplayBuilder builder = new DisplayBuilder();
        ContextAttribs attribs = new ContextAttribs()
            .withDefaultHints();
        builder.setContextAttribs(attribs);
        Display display = builder.create(1024, 768, "Window", true);
        /*
         * This function call is very important. It creates the OpenGL context 
         * and binds it to the window so that we can use our OpenGL functions. 
         */
        display.setCurrentContext();
        return display;
    }

    /* The vertices of the triangle */
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

    private Mesh loadMesh() {
        /*
         * The first attribute is the storage type. STATIC_DRAW
         * is used because we do not want to modify our data.
         * 
         * The second attribute is the amount of vertices. Here, we have
         * three vertices.
         * 
         * The third attribute is the 'attribute list'. 
         * The index of an array element is the attribute ID, 
         * the element is the size of the attribute
         */
        MeshBuilder builder = new MeshBuilder(STATIC_DRAW, 
            3, new int[] { 2, 3 });
        builder.put(TRIANGLE_VERTS);
        Mesh mesh = builder.createMesh();
        return mesh;
    }
}
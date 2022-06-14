package quad;

import zEngine.GL.buffers.*;
import static zEngine.GL.functions.GLFunc.*;
import static zEngine.GL.functions.GLEnum.*;
import zEngine.GL.shaders.ShaderProgram;
import zEngine.application.*;
import zEngine.glfw.*;
import zEngine.util.vector.Vector3f;

class QuadApp extends Application {

    private Mesh mesh;
    private ShaderProgram program;

    public static void main(String[] args) {
        QuadApp app = new QuadApp();
        app.createDisplay(new DisplaySettings(), new Format());
        AppManager.runApplication(app);
    }

    @Override
    public void start() {
        program = ShaderProgram.createProgram(
            "examples/triangle/quad.vert.glsl", 
            "examples/triangle/quad.frag.glsl");
        mesh = loadMesh();
    }

    @Override
    public void update() {
        glClearColor(0, 0, 0, 0);
        glClear();
        glDimensions(Display.getWidth(), Display.getHeight());
        program.bind();
        program.loadVector3f("color", new Vector3f(0, 1, 0));
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

    private static final float[] QUAD_VERTS = {
        -0.5f, -0.5f, +0.0f,
        +0.5f, -0.5f, +0.0f,
        -0.5f, +0.5f, +0.0f, 
        +0.5f, +0.5f, +0.0f,
    };

    private static final int[] QUAD_INDICES = {
        0, 2, 1,
        2, 3, 1
    };

    private Mesh loadMesh() {
        MeshBuilder builder = new MeshBuilder(STATIC_DRAW, 
            4, 6, new int[] { 3 });
        builder.put(QUAD_VERTS);
        builder.put(QUAD_INDICES);
        Mesh mesh = builder.createMesh();
        return mesh;
    }
}

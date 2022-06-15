package quad;

import zEngine.GL.buffers.*;
import static zEngine.GL.functions.GLFunc.*;
import static zEngine.GL.functions.GLEnum.*;
import zEngine.GL.shaders.ShaderProgram;
import zEngine.GL.textures.Texture;
import zEngine.application.*;
import zEngine.glfw.*;
import zEngine.input.Key;

class QuadApp extends Application {

    private Mesh mesh;
    private Texture texture;
    private ShaderProgram program;

    public static void main(String[] args) {
        QuadApp app = new QuadApp();
        app.createDisplay(new DisplaySettings(), new Format());
        AppManager.runApplication(app);
    }

    @Override
    public void start() {
        program = ShaderProgram.createProgram(
            "examples/quad/quad.vert.glsl", 
            "examples/quad/quad.frag.glsl");
        mesh = loadMesh();
        texture = Texture.load("examples/quad/image.png");
    }

    @Override
    public void update() {
        glClearColor(0, 0, 0, 0);
        glClear();
        glDimensions(Display.getWidth(), Display.getHeight());
        if (Display.getKeyDevice().isPressedOnce(Key.KEY_Q)) {
            System.out.println("YES!");
        }
        program.bind();
        texture.bind(TEXTURE0);
        mesh.render();
        texture.unbind();
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
        -0.5f, -0.5f, +0.0f, 0.0f, 1.0f,
        -0.5f, +0.5f, +0.0f, 0.0f, 0.0f,
        +0.5f, +0.5f, +0.0f, 1.0f, 0.0f,
        +0.5f, -0.5f, +0.0f, 1.0f, 1.0f,
    };

    private static final int[] QUAD_INDICES = {
        0, 1, 2,
        0, 2, 3,
    };

    private Mesh loadMesh() {
        MeshBuilder builder = new MeshBuilder(STATIC_DRAW, 
            4, 6, new int[] { 3, 2 });
        builder.put(QUAD_VERTS);
        builder.put(QUAD_INDICES);
        Mesh mesh = builder.createMesh();
        return mesh;
    }
}

package quad;

import zEngine.GL.buffers.*;
import static zEngine.GL.functions.GLFunc.*;
import static zEngine.GL.functions.GLEnum.*;
import zEngine.GL.shaders.ShaderProgram;
import zEngine.GL.textures.Texture;
import zEngine.application.*;
import zEngine.glfw.*;
import zEngine.input.*;
import zEngine.util.math.zLinear;
import zEngine.util.matrix.Matrix3f;
import zEngine.util.matrix.Matrix4f;
import zEngine.util.vector.Vector2f;

class QuadApp extends Application {

    private Mesh mesh;
    private Texture texture;
    private ShaderProgram program;

    private Vector2f quadPosition = new Vector2f();
    private float angle = 0.0f;

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
        handleKeys();
        program.bind();
        program.loadMatrix3f("model", calculateModel());
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
        -0.3f, +0.3f, +0.0f, 0.0f, 0.0f, // 1 -> 0
        -0.3f, -0.3f, +0.0f, 0.0f, 1.0f, // 0 -> 1
        +0.3f, -0.3f, +0.0f, 1.0f, 1.0f, // 3 -> 2
        +0.3f, +0.3f, +0.0f, 1.0f, 0.0f, // 2 -> 3
    };

    private static final int[] QUAD_INDICES = {
        1, 0, 3,
        1, 3, 2,
    };

    private Mesh loadMesh() {
        MeshBuilder builder = new MeshBuilder(STATIC_DRAW, 
            4, 6, new int[] { 3, 2 });
        builder.put(QUAD_VERTS);
        builder.put(QUAD_INDICES);
        Mesh mesh = builder.createMesh();
        return mesh;
    }

    private Matrix3f calculateModel() {
        // Matrix4f translation = zLinear.translate(quadPosition);
        // Matrix4f rotation = zLinear.rotate(angle, new Vector3f(0, 0, 1));
        // return zLinear.multiply(rotation, translation);

        Matrix3f model = new Matrix3f();
        Matrix3f.rotate(angle, model, model);
        return model;
    }

    private void handleKeys() {
        KeyDevice device = Display.getKeyDevice();
        if (device.isPressed(Key.KEY_W)) {
            quadPosition.y += 0.03f;
        } 

        if (device.isPressed(Key.KEY_A)) {
            quadPosition.x -= 0.03f;
        }

        if (device.isPressed(Key.KEY_S)) {
            quadPosition.y -= 0.03f;
        }

        if (device.isPressed(Key.KEY_D)) {
            quadPosition.x += 0.03f;
        }

        if (device.isPressed(Key.KEY_LEFT)) {
            angle -= 0.4f;
        }

        if (device.isPressed(Key.KEY_RIGHT)) {
            angle += 0.4f;
        }
    }
}

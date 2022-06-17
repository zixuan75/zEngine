package ship;

import zEngine.GL.buffers.*;
import static zEngine.GL.functions.GLFunc.*;
import static zEngine.GL.functions.GLEnum.*;
import zEngine.GL.shaders.ShaderProgram;

import zEngine.glfw.Display;
import zEngine.input.*;
import zEngine.util.collision.Line;
import zEngine.util.matrix.Matrix3f;
import zEngine.util.vector.Vector2f;

public class Ship {
    private static final float[] VERTICES = {
        +0.0f, +1.0f, // 0
        -1.0f, -1.0f, // 1
        +0.0f, -0.5f, // 2
        +1.0f, -1.0f, // 3
    };

    private static final Vector2f[] BOUNDARIES = {
        new Vector2f(+0.0f, +1.0f),
        new Vector2f(-1.0f, -1.0f),
        new Vector2f(+1.0f, -1.0f)
    };

    private static final Line[] BOUNDARY_LINES = {
        new Line(new Vector2f(0f, 1f), new Vector2f(0f, 1f))
    };

    private static final int[] INDICES = {
        0, 1, 2,
        0, 2, 3
    };

    private static final String VERTEX_PATH = "examples/ship/ship.vert.glsl";
    private static final String FRAGMENT_PATH = "examples/ship/ship.frag.glsl";


    private Mesh mesh;
    private ShaderProgram program = ShaderProgram.createProgram(VERTEX_PATH, FRAGMENT_PATH);
    private Matrix3f transform = new Matrix3f();
    private Vector2f position = new Vector2f();
    private Vector2f velocity = new Vector2f();
    private float angle = 0.0f;
    public Ship() {
        MeshBuilder builder = new MeshBuilder(STATIC_DRAW, 4, 6, new int[] {2});
        builder.put(VERTICES);
        builder.put(INDICES);
        mesh = builder.createMesh();
    }

    public void render() {
        glClearColor(0, 0, 0, 0);
        glClear();
        glDimensions(Display.getWidth(), Display.getHeight());
        update();
        program.bind();
        loadTransform();
        mesh.render();
        program.unbind();
    }

    public void loadTransform() {
        transform.setIdentity();
        Matrix3f.translate(position, transform, transform);
        Matrix3f.rotate(angle, transform, transform);
        Matrix3f.scale(new Vector2f(0.2f), transform, transform);
        program.loadMatrix3f("transform", transform);
    }

    public void checkBoundaries(Line line) {
        for (Vector2f boundary: BOUNDARIES) {
            Vector2f transformedBoundary = Matrix3f.multiply(transform, boundary);
            transformedBoundary.print();
            System.out.println();
            
        }
    }

    public void update() {
        KeyDevice device = Display.getKeyDevice();
        if (device.isPressed(Key.KEY_LEFT)) {
            angle -= 1.5f;
        }

        if (device.isPressed(Key.KEY_RIGHT)) {
            angle += 1.5f;
        }

        if (device.isPressed(Key.KEY_UP)) {
            position.x += 0.03f * velocity.x;
            position.y += 0.03f * velocity.y;
        }
        System.out.println(transform);
        checkBoundaries(BOUNDARY_LINES[0]);
        
        updateVelocity();
    }

    public void updateVelocity() {
        velocity.x = (float) Math.sin(Math.toRadians(angle));
        velocity.y = (float) Math.cos(Math.toRadians(angle));
    }


    public void destroy() {
        mesh.destroy();
    }
}

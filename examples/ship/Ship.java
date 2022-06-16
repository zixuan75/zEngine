package ship;

import zEngine.GL.buffers.Mesh;
import zEngine.GL.buffers.MeshBuilder;
import zEngine.GL.functions.GLEnum;
import zEngine.GL.shaders.ShaderProgram;
import zEngine.util.math.zLinear;
import zEngine.util.matrix.Matrix4f;
import zEngine.util.vector.Vector3f;

public class Ship {
    private static final float[] VERTICES = {
        +0.0f, +1.0f, // 0
        -1.0f, -1.0f, // 1
        +0.0f, -0.5f, // 2
        +1.0f, -1.0f, // 3
    };

    private static final int[] INDICES = {
        0, 1, 2,
        0, 2, 3
    };

    private static final String VERTEX_PATH = "examples/ship/ship.vert.glsl";
    private static final String FRAGMENT_PATH = "examples/ship/ship.frag.glsl";


    private Mesh mesh;
    private ShaderProgram program = ShaderProgram.createProgram(VERTEX_PATH, FRAGMENT_PATH);
    private Matrix4f transform = zLinear.scale(new Vector3f(0.3f));
    public Ship() {
        MeshBuilder builder = new MeshBuilder(GLEnum.STATIC_DRAW, 8, 6, new int[] {2});
        builder.put(VERTICES);
        builder.put(INDICES);
        mesh = builder.createMesh();
    }

    public void render() {
        program.bind();
        program.loadMatrix4f("transform", transform);
        mesh.render();
        program.unbind();
    }


    public void destroy() {
        mesh.destroy();
    }
}

package cube;

import zEngine.GL.buffers.Mesh;
import zEngine.GL.shaders.ShaderProgram;
import zEngine.GL.textures.Texture;
import static zEngine.GL.functions.GLFunc.*;
import zEngine.application.*;
import zEngine.engine3d.camera.controls.*;
import zEngine.engine3d.camera.impl.Camera;
import zEngine.glfw.Display;
import zEngine.input.keys.*;
import zEngine.util.mesh.ObjectGenerator;
import zEngine.util.vector.Vector3f;

public class CubeApp extends Application implements KeyReceiver {

// [1]
    private Camera camera;
    private CameraControls controls;
    private static final float AMOUNT = 0.2f;

    private Mesh cube;
    private Texture tex;
    private ShaderProgram program;

// [2]
    public static void main(String[] args) {
        CubeApp app = new CubeApp();
        app.createDisplay(new DisplaySettings(), new Format());
        AppManager.runApplication(app);
    }

// [3]
    @Override
    public void start() {
        KeyReceiver.add(this);
        program = ShaderProgram.createProgram("examples/cube/cube.vert.glsl", 
            "examples/cube/cube.frag.glsl");
        cube = ObjectGenerator.createCube();
        tex = Texture.load("examples/res/wood.png");

// [4]     
        camera = new Camera();
        camera.position = new Vector3f(0, 0, 2);
        controls = new CameraControls(camera);
        controls.orient = Orientation.WORLD_ORIENT;
    }

// [5]
    @Override
    public void update() {
        glClearColor(0, 0, 0, 0);
        glClear();
        glDimensions(Display.getWidth(), Display.getHeight());
        glCull();
        glEnableDepth();
        camera.update();
        program.bind();
        camera.load(program, "projection", "view");
        tex.bind(0);
// [6]
        cube.render();
// [7]
        tex.unbind();
        program.unbind();
    }

// [8]
    @Override
    public void end() {
        cube.destroy();
        tex.destroy();
        program.delete();
    }

// [9]
    @Override
    public void handleKeyEvent(KeyEvent event) {
        switch (event.key()) {
            case Key.KEY_W:
                controls.moveForward(AMOUNT);
                break;
            case Key.KEY_A:
                controls.moveLeft(AMOUNT);
                break;
            case Key.KEY_S:
                controls.moveBackward(AMOUNT);
                break;
            case Key.KEY_D:
                controls.moveRight(AMOUNT);
                break;
            case Key.KEY_SPACE:
                controls.moveUp(AMOUNT);
                break;
            case Key.KEY_LSHIFT:
                controls.moveDown(AMOUNT);
                break;
            default:
                break;
        }
        controls.resync(camera);
        update();
    }
    
}

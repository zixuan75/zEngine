// package cube;

// import zEngine.GL.buffers.Mesh;
// import zEngine.GL.shaders.ShaderProgram;
// import zEngine.GL.textures.Texture;
// import static zEngine.GL.functions.GLFunc.*;
// import zEngine.application.*;
// import zEngine.engine3d.camera.controls.*;
// import zEngine.engine3d.camera.impl.Camera;
// import zEngine.glfw.Display;
// import zEngine.input.Action;
// import zEngine.input.keys.*;
// import zEngine.input.mice.*;
// import zEngine.util.mesh.ObjectGenerator;
// import zEngine.util.vector.*;

// public class CubeApp extends Application implements KeyReceiver, MouseReceiver {

// // [1]
//     private Camera camera;
//     private CameraControls controls;
//     private static final float AMOUNT = 0.2f;

//     private Mesh cube;
//     private Texture tex;
//     private ShaderProgram program;

//     private Vector2f mousePos = new Vector2f();
//     private Vector2f delta = new Vector2f();

// // [2]
//     public static void main(String[] args) {
//         CubeApp app = new CubeApp();
//         app.createDisplay(new DisplaySettings(), new Format());
//         AppManager.runApplication(app);
//     }

// // [3]
//     @Override
//     public void start() {
//         KeyReceiver.add(this);
//         MouseReceiver.add(this);

//         program = ShaderProgram.createProgram("examples/cube/cube.vert.glsl", 
//             "examples/cube/cube.frag.glsl");
//         cube = ObjectGenerator.createCube();
//         tex = Texture.load("examples/res/wood.png");

// // [4]     
//         camera = new Camera();
//         camera.position = new Vector3f(0, 0, 3);
//         controls = new CameraControls(camera);
//         controls.orient = Orientation.WORLD_ORIENT;
//     }

// // [5]
//     @Override
//     public void update() {
//         Display.getMouse().invoke(this);
//     }
// // [6]

//     @Override
//     public void paint() {
//         glClear(0, 0, 0);
//         glSetup(true, true);
//         camera.update();
//         program.bind();
//         program.loadMatrix4f("projection", camera.getProjectionMatrix());
//         program.loadMatrix4f("view", camera.getViewMatrix());  
// // [7]
//         tex.bind(0);  
//         cube.render();
//         tex.unbind();
//         program.unbind();
//         glFinish();
//     }

// // [8]
//     @Override
//     public void end() {
//         cube.destroy();
//         tex.destroy();
//         program.delete();
//     }

// // [9]
//     @Override
//     public void handleKeyEvent(KeyEvent event) {
//         switch (event.key()) {
//             case Key.KEY_W:
//                 controls.moveForward(AMOUNT);
//                 break;
//             case Key.KEY_A:
//                 controls.moveLeft(AMOUNT);
//                 break;
//             case Key.KEY_S:
//                 controls.moveBackward(AMOUNT);
//                 break;
//             case Key.KEY_D:
//                 controls.moveRight(AMOUNT);
//                 break;
//             case Key.KEY_SPACE:
//                 controls.moveUp(AMOUNT);
//                 break;
//             case Key.KEY_LSHIFT:
//                 controls.moveDown(AMOUNT);
//                 break;
//             default:
//                 break;
//         }
//         controls.resync(camera);
//         paint();
//     }

// // [10]
//     @Override
//     public void handleMouseEvent(MouseEvent event) {
//         Vector2f newMousePos = event.mousePos();
//         Vector2f.diff(newMousePos, mousePos, delta);
//         if (delta.length() >= 25.0f) {
//             mousePos.set(newMousePos); 
//             return; 
//         }
//         delta.print();
//         if ((event.button() == MousePress.BUTTON_MIDDLE) && (event.action() == Action.PRESS)) {
//             controls.rotate(delta, AMOUNT);
//         }
//         mousePos.set(newMousePos);
//         controls.resync(camera);
//         paint();
//     }
    
// }

package cube;

import zEngine.application.*;

public class CubeApp extends Application {
    public static void main(String[] args) {
        CubeApp app = new CubeApp();
        app.createDisplay(new DisplaySettings(), new Format());
        AppManager.runApplication(app);
    }
    @Override
    public void start() {

    }
    @Override
    public void update() {

    }
    @Override
    public void paint() {

    }
    @Override
    public void end() {

    }
}

package zEngine.util.mesh;

import zEngine.GL.buffers.Mesh;
import zEngine.GL.buffers.MeshBuilder;
import zEngine.GL.functions.GLEnum;

public class ObjectGenerator {
    
    /**
     * From the OpenGL tutorial code
     */
    private static float[] planeMesh(float psize) {
        return new float[] {
             psize, -0.5f,  psize,  psize,  0.0f,  0.0f, 1.0f, 0.0f,
            -psize, -0.5f,  psize,   0.0f,  0.0f,  0.0f, 1.0f, 0.0f,
            -psize, -0.5f, -psize,   0.0f, psize,  0.0f, 1.0f, 0.0f,
    
             psize, -0.5f,  psize,  psize,  0.0f,  0.0f, 1.0f, 0.0f,
            -psize, -0.5f, -psize,   0.0f, psize,  0.0f, 1.0f, 0.0f,
             psize, -0.5f, -psize,  psize, psize,  0.0f, 1.0f, 0.0f,
        };
    }

    /**
     * 
     */
    private static float[] cubeMesh() {
        return new float[] {
            // back face
            -1.0f, -1.0f, -1.0f, 0.0f, 0.0f, 0.0f,  0.0f, -1.0f, // bottom-left
             1.0f,  1.0f, -1.0f, 1.0f, 1.0f, 0.0f,  0.0f, -1.0f, // top-right
             1.0f, -1.0f, -1.0f, 1.0f, 0.0f, 0.0f,  0.0f, -1.0f, // bottom-right         
             1.0f,  1.0f, -1.0f, 1.0f, 1.0f, 0.0f,  0.0f, -1.0f, // top-right
            -1.0f, -1.0f, -1.0f, 0.0f, 0.0f, 0.0f,  0.0f, -1.0f, // bottom-left
            -1.0f,  1.0f, -1.0f, 0.0f, 1.0f, 0.0f,  0.0f, -1.0f, // top-left

            // front face
            -1.0f, -1.0f,  1.0f, 0.0f, 0.0f, 0.0f,  0.0f, -1.0f, // bottom-left
             1.0f, -1.0f,  1.0f, 1.0f, 0.0f, 0.0f,  0.0f, -1.0f, // bottom-right
             1.0f,  1.0f,  1.0f, 1.0f, 1.0f, 0.0f,  0.0f, -1.0f, // top-right
             1.0f,  1.0f,  1.0f, 1.0f, 1.0f, 0.0f,  0.0f, -1.0f, // top-right
            -1.0f,  1.0f,  1.0f, 0.0f, 1.0f, 0.0f,  0.0f, -1.0f, // top-left
            -1.0f, -1.0f,  1.0f, 0.0f, 0.0f, 0.0f,  0.0f, -1.0f, // bottom-left

            // left face
            -1.0f,  1.0f,  1.0f, 1.0f, 0.0f, -1.0f,  0.0f,  0.0f, // top-right
            -1.0f,  1.0f, -1.0f, 1.0f, 1.0f, -1.0f,  0.0f,  0.0f, // top-left
            -1.0f, -1.0f, -1.0f, 0.0f, 1.0f, -1.0f,  0.0f,  0.0f, // bottom-left
            -1.0f, -1.0f, -1.0f, 0.0f, 1.0f, -1.0f,  0.0f,  0.0f, // bottom-left
            -1.0f, -1.0f,  1.0f, 0.0f, 0.0f, -1.0f,  0.0f,  0.0f, // bottom-right
            -1.0f,  1.0f,  1.0f, 1.0f, 0.0f, -1.0f,  0.0f,  0.0f, // top-right

            // right face
             1.0f,  1.0f,  1.0f, 1.0f, 0.0f,  1.0f,  0.0f,  0.0f, // top-left
             1.0f, -1.0f, -1.0f, 0.0f, 1.0f,  1.0f,  0.0f,  0.0f, // bottom-right
             1.0f,  1.0f, -1.0f, 1.0f, 1.0f,  1.0f,  0.0f,  0.0f, // top-right         
             1.0f, -1.0f, -1.0f, 0.0f, 1.0f,  1.0f,  0.0f,  0.0f, // bottom-right
             1.0f,  1.0f,  1.0f, 1.0f, 0.0f,  1.0f,  0.0f,  0.0f, // top-left
             1.0f, -1.0f,  1.0f, 0.0f, 0.0f,  1.0f,  0.0f,  0.0f, // bottom-left     
            // bottom face
            -1.0f, -1.0f, -1.0f, 0.0f, 1.0f,  0.0f, -1.0f,  0.0f, // top-right
             1.0f, -1.0f, -1.0f, 1.0f, 1.0f,  0.0f, -1.0f,  0.0f, // top-left
             1.0f, -1.0f,  1.0f, 1.0f, 0.0f,  0.0f, -1.0f,  0.0f, // bottom-left
             1.0f, -1.0f,  1.0f, 1.0f, 0.0f,  0.0f, -1.0f,  0.0f, // bottom-left
            -1.0f, -1.0f,  1.0f, 0.0f, 0.0f,  0.0f, -1.0f,  0.0f, // bottom-right
            -1.0f, -1.0f, -1.0f, 0.0f, 1.0f,  0.0f, -1.0f,  0.0f, // top-right
            // top face
            -1.0f,  1.0f, -1.0f, 0.0f, 1.0f,  0.0f,  1.0f,  0.0f, // top-left
             1.0f,  1.0f , 1.0f, 1.0f, 0.0f,  0.0f,  1.0f,  0.0f, // bottom-right
             1.0f,  1.0f, -1.0f, 1.0f, 1.0f,  0.0f,  1.0f,  0.0f, // top-right     
             1.0f,  1.0f,  1.0f, 1.0f, 0.0f,  0.0f,  1.0f,  0.0f, // bottom-right
            -1.0f,  1.0f, -1.0f, 0.0f, 1.0f,  0.0f,  1.0f,  0.0f, // top-left
            -1.0f,  1.0f,  1.0f, 0.0f, 0.0f,  0.0f,  1.0f,  0.0f, // bottom-left        
        };
    }

    public static Mesh createCube() {
        MeshBuilder builder = new MeshBuilder(GLEnum.STATIC_DRAW, 36, -1, new int[] {3, 2, 3});
        builder.put(cubeMesh());
        return builder.createMesh();
    }

    public static Mesh createStretchedPlane(int size) {
        MeshBuilder builder = new MeshBuilder(GLEnum.STATIC_DRAW, 6, -1, new int[] {3, 2, 3});
        builder.put(planeMesh(size));
        return builder.createMesh();
    }
}

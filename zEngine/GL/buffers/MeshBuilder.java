package zEngine.GL.buffers;

/**
 * A builder class for the Mesh class.
 * 
 * @author zixuan
 */
public class MeshBuilder {
    private Mesh mesh;

    /**
     * Creates and binds the VAO, VBO and links the VBO's attributes to the VAO
     * @param draw the storage type of the VBO
     * @param vertexCount the number of vertices
     * @param indexCount the number of indices; specify -1 or other negative number if do not include
     * @param attribs the attribute list of the VBO
     */
    public MeshBuilder(int draw, int vertexCount, int indexCount, int[] attribs) {
        mesh = new Mesh();
        mesh.vao = Vao.create();
        mesh.vao.bind();

        mesh.vbo = Vbo.create(draw, vertexCount, 0, attribs);
        mesh.vbo.bind();

        
        if (indexCount >= 0) {
            mesh.ibo = Ibo.create(draw, indexCount);
            mesh.ibo.bind();
        }

        mesh.vertexCount = vertexCount;
        mesh.indexCount = indexCount;
    }

    /**
     * Puts a list of floats
     * @param dataList
     */
    public void put(float... dataList) {
        mesh.vbo.put(dataList);
    }

    /**
     * Puts a triangle
     * @param x 1st vertex
     * @param y 2nd vertex
     * @param z 3rd vertex
     */
    public void put(int x, int y, int z) {
        if (mesh.indexCount >= 0) {
            mesh.ibo.putTriangle(x, y, z);
        }
    }

    
    /**
     * 
     * @param dataList list of ints
     */
    public void put(int... dataList) {
        if (mesh.indexCount >= 0) {
            mesh.ibo.put(dataList);
        }
    }

    /**
     * Writes the VBO data to the VBO, 
     * unbinds the VAO and VBO 
     * @return the mesh
     */

    public Mesh createMesh() {
        mesh.vbo.flipAndWrite();
        mesh.vbo.unbind();
        if (mesh.indexCount >= 0) {
            mesh.ibo.flipAndWrite();
            mesh.ibo.unbind();
        }
        mesh.vao.unbind();
        return mesh;
    }
}

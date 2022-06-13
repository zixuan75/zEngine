package zEngine.GL.buffers;

public class MeshBuilder {
    private Mesh mesh;

    /**
     * Creates and binds the VAO, VBO and links the VBO's attributes to the VAO
     * @param draw the storage type of the VBO
     * @param vertexCount the number of vertices
     * @param attribs the attribute list of the VBO
     */
    public MeshBuilder(int draw, int vertexCount, int[] attribs) {
        mesh = new Mesh();
        mesh.vao = Vao.create();
        mesh.vao.bind();

        mesh.vbo = Vbo.create(draw, vertexCount, 0, attribs);
        mesh.vbo.bind();
        mesh.vertexCount = vertexCount;
    }

    /**
     * Puts an attribute
     * @param dataList
     */
    public void put(float... dataList) {
        mesh.vbo.put(dataList);
    }

    /**
     * Writes the VBO data to the VBO, 
     * unbinds the VAO and VBO and 
     * returns mesh
     * @return the mesh
     */

    public Mesh getMesh() {
        mesh.vbo.flipAndWrite();
        mesh.vbo.unbind();
        mesh.vao.unbind();
        return mesh;
    }
}

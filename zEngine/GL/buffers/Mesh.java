package zEngine.GL.buffers;

import org.lwjgl.opengl.GL11;

/**
 * A wrapper representing a mesh.
 * 
 * @author zixuan
 */
public class Mesh {
    public Vao vao;
    public Vbo vbo;
    public Ibo ibo;
    public int vertexCount;
    public int indexCount;

    /**
     * Renders the mesh.
     */
    public void render() {
        vao.bind();
        vbo.enable();
        if (indexCount >= 0) {
            ibo.bind();
            GL11.glDrawElements(GL11.GL_TRIANGLES, indexCount, GL11.GL_UNSIGNED_INT, 0);
            ibo.unbind();
        } else {
            GL11.glDrawArrays(GL11.GL_TRIANGLES, 0, vertexCount);
        }
        vbo.disable();
        vao.unbind();
    }

    /**
     * Destroys the mesh.
     */
    public void destroy() {
        vbo.delete();
        vao.delete();
    }
}

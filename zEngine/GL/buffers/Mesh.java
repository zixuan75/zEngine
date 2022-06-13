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
    public int vertexCount;

    /**
     * Renders the mesh.
     */
    public void render() {
        vao.bind();
        vbo.enable();
        GL11.glDrawArrays(GL11.GL_TRIANGLES, 0, vertexCount);
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

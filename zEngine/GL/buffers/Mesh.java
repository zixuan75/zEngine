package zEngine.GL.buffers;

import org.lwjgl.opengl.GL11;

public class Mesh {
    public Vao vao;
    public Vbo vbo;
    public int vertexCount;

    public void render() {
        vao.bind();
        vbo.enable();
        GL11.glDrawArrays(GL11.GL_TRIANGLES, 0, vertexCount);
        vbo.disable();
        vao.unbind();
    }

    public void destroy() {
        vbo.delete();
        vao.delete();
    }
}

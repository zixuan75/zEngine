package zEngine.GL.buffers;

import org.lwjgl.opengl.GL30;

public class Vao {
    private int id;

    public static Vao create() {
        int id = GL30.glGenVertexArrays();
        return new Vao(id);
    }

    public void delete() {
        GL30.glDeleteVertexArrays(id);
    }

    private Vao(int id) {
        this.id = id;
    }

    public void bind() {
        GL30.glBindVertexArray(id);
    }

    public void unbind() {
        GL30.glBindVertexArray(0);
    }
}

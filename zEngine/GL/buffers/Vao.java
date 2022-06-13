package zEngine.GL.buffers;

import org.lwjgl.opengl.GL30;

/**
 * A Vao class representing a Vertex Array Object. 
 * 
 * @author zixuan
 */
public class Vao {
    private int id;

    /**
     * Creates a VAO (this function is a wrapper around glGenVertexArrays)
     * 
     * @return the VAO
     */
    public static Vao create() {
        int id = GL30.glGenVertexArrays();
        return new Vao(id);
    }

    /**
     * Destroys the VAO (this function is a wrapper around glDeleteVertexArrays)
     */
    public void delete() {
        GL30.glDeleteVertexArrays(id);
    }

    private Vao(int id) {
        this.id = id;
    }

    /**
     * Binds the VAO
     */
    public void bind() {
        GL30.glBindVertexArray(id);
    }

    /**
     * Unbinds/releases the VAO
     */
    public void unbind() {
        GL30.glBindVertexArray(0);
    }
}

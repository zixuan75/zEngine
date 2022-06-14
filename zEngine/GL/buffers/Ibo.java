package zEngine.GL.buffers;

import java.nio.IntBuffer;

import org.lwjgl.opengl.GL15;
import org.lwjgl.system.MemoryUtil;

public class Ibo {
    private final int id;
    private final int draw;
    private final IntBuffer buffer;
    public final int indexCount;

    /**
     * Creates the IBO
     * @param draw the storage type
     * @param capacity the maximum index count
     * @return IBO
     */
    public static Ibo create(int draw, int capacity) {
        int id = GL15.glGenBuffers();
        return new Ibo(id, draw, capacity);
    }

    /**
     * Deletes the IBO
     */
    public void delete() {
        MemoryUtil.memFree(buffer);
        GL15.glDeleteBuffers(id);
    }

    private Ibo(int id, int draw, int capacity) {
        this.id = id;
        this.draw = draw;
        this.buffer = MemoryUtil.memAllocInt(capacity);
        this.indexCount = capacity;
    }

    /**
     * Binds the IBO
     */
    public void bind() {
        GL15.glBindBuffer(GL15.GL_ELEMENT_ARRAY_BUFFER, id);
    }

    /**
     * Unbinds the IBO
     */
    public void unbind() {
        GL15.glBindBuffer(GL15.GL_ELEMENT_ARRAY_BUFFER, 0);
    }

    /**
     * Adds a triangle
     * @param x 1st vertex
     * @param y 2nd vertex 
     * @param z 3rd vertex
     */
    public void putTriangle(int x, int y, int z) {
        buffer.put(x).put(y).put(z);
    }

    public void put(int... arr) {
        buffer.put(arr);
    }

    /**
     * Writes the buffer to the IBO
     */
    public void flipAndWrite() {
        buffer.flip();
        GL15.glBufferData(GL15.GL_ELEMENT_ARRAY_BUFFER, buffer, draw);
    }

    /**
     * Clears the buffer
     */
    public void clear() {
        buffer.clear();   
    }

}

package zEngine.GL.buffers;

import java.nio.FloatBuffer;

import org.lwjgl.opengl.GL11;
import org.lwjgl.opengl.GL15;
import org.lwjgl.opengl.GL20;
import org.lwjgl.system.MemoryUtil;

/**
 * A Vbo class representing a Vertex Buffer Object 
 * 
 * @author zixuan
 */
public class Vbo {
    private final int id;
    private final int draw;
    private final int offset;
    private final int[] attribs;
    private final FloatBuffer buffer;
    public final int vertexCount;

    /**
     * @param draw the storage type of the data
     * @param capacity the maximum number of vertices in the data
     * @param offset a number dictating the offset of the attribute IDs
     * @param attribs an array; the index of an array element is the attribute ID, the element is the size of the attribute
     * @return a new VBO
     */
    public static Vbo create(int draw, int capacity, int offset, int[] attribs) {
        int id = GL15.glGenBuffers();
        return new Vbo(id, draw, capacity, offset, attribs);
    }

    /**
     * Deletes the VBO
     */
    public void delete() {
        MemoryUtil.memFree(buffer);
        GL15.glDeleteBuffers(id);
    }

    private Vbo(int id, int draw, int capacity, int offset, int[] attribs) {
        this.id = id;
        this.draw = draw;
        this.offset = offset;
        this.attribs = attribs;
        this.buffer = MemoryUtil.memAllocFloat(capacity * getAttribLength(attribs));
        this.vertexCount = capacity;
        bind();
        setAttribs();
        unbind();
    }

    /**
     * Enables the attributes of the VBO
     */
    public void enable() {
        for (int i = 0; i < attribs.length; i++) {
            GL20.glEnableVertexAttribArray(offset + i);
        }
    }

    /**
     * Disables the attributes of the VBO
     */
    public void disable() {
        for (int i = 0; i < attribs.length; i++) {
            GL20.glDisableVertexAttribArray(offset + i);
        }
    }

    /**
     * Binds the VBO
     */
    public void bind() {
        GL15.glBindBuffer(GL15.GL_ARRAY_BUFFER, id);
    }

    /**
     * Unbinds the VBO
     */
    public void unbind() {
        GL15.glBindBuffer(GL15.GL_ARRAY_BUFFER, 0);
    }

    /**
     * Flips the buffer and writes to the VBO
     */
    public void flipAndWrite() {
        buffer.flip();
        GL15.glBufferData(GL15.GL_ARRAY_BUFFER, buffer, draw);
    }

    /**
     * Puts a list of values into the buffer
     * @param dataList a list of floats
     */
    public void put(float... dataList) {
        buffer.put(dataList);
    }

    /**
     * Puts a FloatBuffer into the buffer
     * @param buf 
     */
    public void put(FloatBuffer buf) {
        buffer.put(buf);
    }

    /**
     * Clears the buffer
     */
    public void clear() {
        buffer.clear();   
    }

    private void setAttribs() {
        int byteLength = getAttribLength(attribs) * 4;
        int pointer = 0;
        for (int i = 0; i < attribs.length; i++) {
            GL20.glVertexAttribPointer(offset + i, attribs[i], GL11.GL_FLOAT, false, byteLength, pointer);
            pointer += attribs[i] * 4;
        }
    }

    protected static int getAttribLength(int[] attribs) {
        int length = 0;
        for (int i = 0; i < attribs.length; i++) {
            length += attribs[i];
        }
        return length;
    }
}

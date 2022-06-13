package zEngine.GL.buffers;

import java.nio.FloatBuffer;

import org.lwjgl.opengl.GL11;
import org.lwjgl.opengl.GL15;
import org.lwjgl.opengl.GL20;
import org.lwjgl.system.MemoryUtil;

public class Vbo {
    private int id;
    private int draw;
    private int offset;
    private int[] attribs;
    private FloatBuffer buffer;

    public static Vbo create(int draw, int capacity, int offset, int[] attribs) {
        int id = GL15.glGenBuffers();
        return new Vbo(id, draw, capacity, offset, attribs);
    }

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
        bind();
        setAttribs();
        unbind();
    }

    public void enable() {
        for (int i = 0; i < attribs.length; i++) {
            GL20.glEnableVertexAttribArray(offset + i);
        }
    }

    public void disable() {
        for (int i = 0; i < attribs.length; i++) {
            GL20.glDisableVertexAttribArray(offset + i);
        }
    }

    public void bind() {
        GL15.glBindBuffer(GL15.GL_ARRAY_BUFFER, id);
    }

    public void unbind() {
        GL15.glBindBuffer(GL15.GL_ARRAY_BUFFER, 0);
    }

    public void flipAndWrite() {
        buffer.flip();
        GL15.glBufferData(GL15.GL_ARRAY_BUFFER, buffer, draw);
    }

    public void put(float... dataList) {
        for (int i = 0; i < dataList.length; i++) {
            buffer.put(dataList[i]);
        }
    }

    public void setAttribs() {
        int byteLength = getAttribLength(attribs) * 4;
        int pointer = 0;
        for (int i = 0; i < attribs.length; i++) {
            GL20.glVertexAttribPointer(offset + i, attribs[i], GL11.GL_FLOAT, false, byteLength, pointer);
            pointer += attribs[i] * 4;
        }
    }

    private static int getAttribLength(int[] attribs) {
        int length = 0;
        for (int i = 0; i < attribs.length; i++) {
            length += attribs[i];
        }
        return length;
    }
}

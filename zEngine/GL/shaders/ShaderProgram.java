package zEngine.GL.shaders;

import org.lwjgl.opengl.GL20;

import zEngine.util.matrix.Matrix3f;
import zEngine.util.matrix.Matrix4f;
import zEngine.util.vector.Vector2f;
import zEngine.util.vector.Vector3f;
import zEngine.util.vector.Vector4f;

/**
 * A wrapper around OpenGL's program
 * 
 * @author zixuan
 */
public class ShaderProgram {
    private int id;

    /**
     * Loads a program from file
     * @param vertPath relative path to vertex shader
     * @param fragPath relative path to fragment shader
     * @return program
     */
    public static ShaderProgram createProgram(String vertPath, String fragPath) {
        int id = GL20.glCreateProgram();
        Shader vertexShader = Shader.create(GL20.GL_VERTEX_SHADER);
        Shader fragmentShader = Shader.create(GL20.GL_FRAGMENT_SHADER);
        System.out.println(vertexShader.compile(vertPath));
        System.out.println(fragmentShader.compile(fragPath));
        GL20.glAttachShader(id, vertexShader.id);
        GL20.glAttachShader(id, fragmentShader.id);
        GL20.glLinkProgram(id);
        GL20.glDetachShader(id, vertexShader.id);
        GL20.glDetachShader(id, fragmentShader.id);
        GL20.glDeleteProgram(vertexShader.id);
        GL20.glDeleteProgram(fragmentShader.id);
        return new ShaderProgram(id);
    }

    /**
     * Loads a program from source
     * @param vert vertex shader source code
     * @param frag fragment shader source coe
     * @return program
     */
    public static ShaderProgram createProgramSource(String vert, String frag) {
        int id = GL20.glCreateProgram();
        Shader vertexShader = Shader.create(GL20.GL_VERTEX_SHADER);
        Shader fragmentShader = Shader.create(GL20.GL_FRAGMENT_SHADER);
        System.out.println(vertexShader.compileSource(vert));
        System.out.println(fragmentShader.compileSource(frag));
        GL20.glAttachShader(id, vertexShader.id);
        GL20.glAttachShader(id, fragmentShader.id);
        GL20.glLinkProgram(id);
        GL20.glDetachShader(id, vertexShader.id);
        GL20.glDetachShader(id, fragmentShader.id);
        GL20.glDeleteProgram(vertexShader.id);
        GL20.glDeleteProgram(fragmentShader.id);
        return new ShaderProgram(id);
    }

    private ShaderProgram(int id) {
        this.id = id;
    }

    /**
     * Binds the program
     */
    public void bind() {
        GL20.glUseProgram(id);
    }

    /**
     * Unbinds the program
     */
    public void unbind() {
        GL20.glUseProgram(0);
    }

    /**
     * Gets the location of an uniform 
     * @param name uniform name
     * @return uniform location
     */
    public int getUniformLocation(String name) {
        return GL20.glGetUniformLocation(id, name);
    }

    public void loadInt(String name, int value) { GL20.glUniform1i(getUniformLocation(name), value); }
    public void loadFloat(String name, float value) { GL20.glUniform1f(getUniformLocation(name), value); }
    public void loadVector2f(String name, Vector2f value) { 
        GL20.glUniform2f(getUniformLocation(name), value.x, value.y); 
    }
    public void loadVector3f(String name, Vector3f value) { 
        GL20.glUniform3f(getUniformLocation(name), value.x, value.y, value.z); 
    }
    public void loadVector4f(String name, Vector4f value) {
        GL20.glUniform4f(getUniformLocation(name), value.x, value.y, value.z, value.w);
    }
    public void loadMatrix3f(String name, Matrix3f value) {
        GL20.glUniformMatrix3fv(getUniformLocation(name), false, value.elements);
    }
    public void loadMatrix4f(String name, Matrix4f value) {
        GL20.glUniformMatrix4fv(getUniformLocation(name), false, value.elements);
    }
    public void loadFloatArray(String[] names, float[] values) {
        for (int i = 0; i < names.length; i++) {
            if (i < values.length) {
                loadFloat(names[i], values[i]);
            } else {
                loadFloat(names[i], 0.0f);
            }
        }
    }
}

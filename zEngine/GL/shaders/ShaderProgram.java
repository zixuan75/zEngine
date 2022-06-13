package zEngine.GL.shaders;

import org.lwjgl.opengl.GL20;

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
}

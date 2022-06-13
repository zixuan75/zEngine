package zEngine.GL.shaders;

import org.lwjgl.opengl.GL20;

public class ShaderProgram {
    private int id;

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

    public void bind() {
        GL20.glUseProgram(id);
    }

    public void unbind() {
        GL20.glUseProgram(0);
    }
}

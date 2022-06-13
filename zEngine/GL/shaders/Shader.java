package zEngine.GL.shaders;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Collectors;

import org.lwjgl.opengl.GL11;
import org.lwjgl.opengl.GL20;

public class Shader {
    protected int id;


    public static Shader create(int type) {
        int id = GL20.glCreateShader(type);
        return new Shader(id);
    }
    private Shader(int id) {
        this.id = id;
    }

    public String compile(String path) {
        try {
            return compileSource(Files.lines(Paths.get(path))
                .collect(Collectors.joining("\n")));
        } catch (IOException e) {
            e.printStackTrace();
            return "";
        }
    }

    public String compileSource(String source) {
        GL20.glShaderSource(id, source);
		GL20.glCompileShader(id);
		if (GL20.glGetShaderi(id, GL20.GL_COMPILE_STATUS) == GL11.GL_FALSE) {
			return GL20.glGetShaderInfoLog(id, 500);
        } else {
            return "";
        }
    }
}

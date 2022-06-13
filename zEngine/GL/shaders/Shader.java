package zEngine.GL.shaders;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Collectors;

import org.lwjgl.opengl.GL11;
import org.lwjgl.opengl.GL20;

/**
 * Shader class; a wrapper around an OpenGL shader 
 * 
 * @author zixuan
 */
public class Shader {
    protected int id;

    /**
     * Creates
     * @param type the 'type' - can be VERTEX_SHADER, FRAGMENT_SHADER, GEOM_SHADER, COMPUTE_SHADER or TESS_SHADER
     * @return an 'empty' shader
     */
    public static Shader create(int type) {
        int id = GL20.glCreateShader(type);
        return new Shader(id);
    }

    private Shader(int id) {
        this.id = id;
    }

    /**
     * Compiles the shader from a path.
     * @param path the relative path
     * @exception IOException
     * @return error; if no error or file not found ""
     * {@code}
     */
    public String compile(String path) {
        try {
            return compileSource(Files.lines(Paths.get(path))
                .collect(Collectors.joining("\n")));
        } catch (IOException e) {
            e.printStackTrace();
            return "";
        }
    }

    /**
     * Compiles the shader from source code
     * @param source the source code
     * @return error; if no error ""
     */
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

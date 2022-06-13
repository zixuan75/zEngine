package zEngine.GL.functions;

import org.lwjgl.opengl.*;

/**
 * GLEnum function. Represents OpenGL enums.
 * 
 * @author zixuan
 */
public class GLEnum {

    /*
     * VBO data storage
     */
    public static final int STATIC_DRAW = GL15.GL_STATIC_DRAW;
    public static final int DYNAMIC_DRAW = GL15.GL_DYNAMIC_DRAW;
    public static final int STREAM_DRAW = GL15.GL_STREAM_DRAW;

    /*
     * Shaders
     */
    public static final int VERTEX_SHADER = GL20.GL_VERTEX_SHADER;
    public static final int FRAGMENT_SHADER = GL20.GL_FRAGMENT_SHADER;
    public static final int GEOM_SHADER = GL32.GL_GEOMETRY_SHADER;
    public static final int COMPUTE_SHADER = GL43.GL_COMPUTE_SHADER;
    public static final int TESS_SHADER = GL46.GL_TESS_CONTROL_SHADER;
}

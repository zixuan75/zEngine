package zEngine.entities;

import zEngine.GL.shaders.ShaderProgram;
import zEngine.GL.textures.Texture;

public class Material {
    public Texture texture;
    public ShaderProgram shader;

    public Material(Texture texture, ShaderProgram shader) {
        this.texture = texture;
        this.shader = shader;
    }

    public void bind(int texBindPoint) {
        shader.bind();
        texture.bind(texBindPoint);
    }

    public void unbind() {
        texture.unbind();
        shader.unbind();
    }

    public void destroy() {
        texture.destroy();
        shader.delete();
    }
}

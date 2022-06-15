package zEngine.GL.textures;

import static org.lwjgl.opengl.GL11.*;
import static zEngine.GL.functions.GLEnum.*;

import org.lwjgl.opengl.GL13;
import org.lwjgl.opengl.GL30;

public class Texture {
    private final int id;
    private final int target;
    public int wrapMode;
    public int interpMode;
    public Texture(int target, int id) {
        this.id = id;
        this.target = target;
        setParams();
    }

    public static Texture load(String path) {
        Texture texture = new Texture(GL_TEXTURE_2D, glGenTextures());
        texture.bind();
        texture.wrapMode = REPEAT;
        texture.interpMode = CLAMP;
        texture.setParams();

        Image image = new Image(path);
        texture.loadImage(image);
        image.delete();

        texture.unbind();
        return texture;
    }

    public static Texture load(String path, int wrapMode, 
            int interpMode, boolean mipMap) {
        Texture texture = new Texture(GL_TEXTURE_2D, glGenTextures());
        texture.bind();
        texture.wrapMode = wrapMode;
        texture.interpMode = interpMode;
        texture.setParams();

        Image image = new Image(path);
        texture.loadImage(image);
        image.delete();

        texture.unbind();
        return texture;
    }

    private void loadImage(Image image) {
        int width = image.width.get(0);
        int height = image.height.get(0);
        if (image.image != null) {
            glTexImage2D(target, 0, GL_RGBA, width, height, 
                0, GL_RGBA, GL_UNSIGNED_BYTE, image.image);
            GL30.glGenerateMipmap(target);
        } else {
            throw new RuntimeException("Could not find image at path: " + image.path);
        }
    }

    public void setParams() {
        glTexParameteri(target, GL_TEXTURE_WRAP_S, wrapMode);
        glTexParameteri(target, GL_TEXTURE_WRAP_T, wrapMode);
        glTexParameteri(target, GL_TEXTURE_MIN_FILTER, interpMode);
        glTexParameteri(target, GL_TEXTURE_MAG_FILTER, interpMode);
    }

    public void bind() {
        glBindTexture(target, id);
    }

    public void bind(int i) {
        
        GL13.glActiveTexture(i);
        glBindTexture(target, id);
    }

    public void unbind() {
        glBindTexture(target, 0);
    }
}

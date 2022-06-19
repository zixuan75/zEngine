package zEngine.GL.textures;

import java.nio.ByteBuffer;
import java.nio.IntBuffer;

import org.lwjgl.BufferUtils;
import org.lwjgl.stb.STBImage;

public class Image {
    public String path;
    public IntBuffer width;
    public IntBuffer height;
    public IntBuffer channels;
    public ByteBuffer image;

    public Image(String filepath) {
        path = filepath;
        width = BufferUtils.createIntBuffer(1);
        height = BufferUtils.createIntBuffer(1);
        channels = BufferUtils.createIntBuffer(1);
        
        image = STBImage.stbi_load(filepath, width, height, channels, 0);
    }

    public void delete() {
        STBImage.stbi_image_free(image);
    }
}

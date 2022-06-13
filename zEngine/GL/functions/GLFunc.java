package zEngine.GL.functions;

import org.lwjgl.opengl.GL11;

public class GLFunc {

    /**
     * Sets the color for the entire window
     * @param R RED channel
     * @param G GREEN channel
     * @param B BLUE channel
     * @param A ALPHA channel
     */
    public static void glClearColor(float R, float G, float B, float A) {
        GL11.glClearColor(R, G, B, A);
    }

    /**
     * Clears the COLOR, DEPTH and STENCIL buffer bits
     */
    public static void glClear() {
        GL11.glClear(GL11.GL_COLOR_BUFFER_BIT | GL11.GL_DEPTH_BUFFER_BIT | GL11.GL_STENCIL_BUFFER_BIT);
    }

    /**
     * Sets the width and height of the viewport
     * @param W the preferred width
     * @param H the preferred height
     */
    public static void glDimensions(int W, int H) {
        GL11.glViewport(0, 0, W, H);
    } 
}

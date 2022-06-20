package zEngine.GL.functions;

import org.lwjgl.opengl.GL11;

import zEngine.glfw.Display;

/**
 * A wrapper around common OpenGL functions
 * 
 * @author zixuan
 */
public class GLFunc {

    private static boolean cullFaces = false;
    private static boolean enableDepth = false;

    /*
     * Window-related functions
     */

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
    public static void glClearBufferBits() {
        GL11.glClear(GL11.GL_COLOR_BUFFER_BIT | GL11.GL_DEPTH_BUFFER_BIT | GL11.GL_STENCIL_BUFFER_BIT);
    }

    /**
     * Enables the depth test
     */
    public static void glEnableDepth() {
        GL11.glEnable(GL11.GL_DEPTH_TEST);
        enableDepth = true;
    }

    /**
     * Disables the depth test
     */
    public static void glDisableDepth() {
        GL11.glDisable(GL11.GL_DEPTH_TEST);
        enableDepth = false;
    }

    /**
     * Sets the width and height of the viewport
     * @param W the preferred width
     * @param H the preferred height
     */
    public static void glDimensions(int W, int H) {
        GL11.glViewport(0, 0, W, H);
    } 

    /**
     * Culls faces. This is an OpenGL optimization
     */
    public static void glCull() {
        GL11.glEnable(GL11.GL_CULL_FACE);
        GL11.glCullFace(GL11.GL_BACK);
        cullFaces = true;
    }

    /**
     * Disables culling
     */
    public static void glStopCull() {
        GL11.glDisable(GL11.GL_CULL_FACE);
        cullFaces = false;
    }


    /** Helper functions */

    /**
     * Sets up OpenGL
     * @param cull
     * @param depth
     */
    public static void glSetup(boolean cull, boolean depth) {
        cullFaces = cull;
        enableDepth = depth;
        if (cullFaces) {
            glCull();
        } else {
            glStopCull();
        }
        if (enableDepth) {
            glEnableDepth();
        } else {
            glDisableDepth();
        }
        glDimensions(Display.getWidth(), Display.getHeight());
    }

    public static void glFinish() {
        if (cullFaces) {
            glStopCull();
        } else {
            glCull();
        }
        if (enableDepth) {
            glDisableDepth();
        } else {
            glEnableDepth();
        }
    }

    public static void glClear(float r, float g, float b) {
        glClearColor(r, g, b, 1);
        glClearBufferBits();
    }
}

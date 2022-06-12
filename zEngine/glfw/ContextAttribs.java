package zEngine.glfw;

import org.lwjgl.glfw.GLFW;

public class ContextAttribs {

    public int samples = 1;

    public ContextAttribs withVersion(int major, int minor) {
        GLFW.glfwWindowHint(GLFW.GLFW_CONTEXT_VERSION_MAJOR, major);
        GLFW.glfwWindowHint(GLFW.GLFW_CONTEXT_VERSION_MINOR, minor);
        return this;
    }

    public ContextAttribs withProfileCore() {
        GLFW.glfwWindowHint(GLFW.GLFW_OPENGL_PROFILE, GLFW.GLFW_OPENGL_CORE_PROFILE);
        return this;
    }

    public ContextAttribs withSamples(int samples) {
        GLFW.glfwWindowHint(GLFW.GLFW_SAMPLES, samples);
        this.samples = samples;
        return this;
    }

    public ContextAttribs withDefaultHints() {
        GLFW.glfwDefaultWindowHints();
        GLFW.glfwWindowHint(GLFW.GLFW_VISIBLE, GLFW.GLFW_FALSE);
        return this;
    }
}

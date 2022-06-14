package zEngine.application;

import zEngine.glfw.ContextAttribs;

public class Format {
    public ContextAttribs attribs;

    public Format() {
        attribs = new ContextAttribs().withDefaultHints();
    }

    public Format(ContextAttribs attribs) {
        this.attribs = attribs;
    }
}

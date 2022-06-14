package zEngine.application;

public interface IApplication {
    void start();
    void update();
    void end();

    /**
     * 
     * @return if the application wants to close
     */
    boolean isCloseRequested();
}
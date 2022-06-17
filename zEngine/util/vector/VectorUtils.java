package zEngine.util.vector;

public class VectorUtils {
    public static Vector loadVector(int size) {
        switch (size) {
            case 2: 
                return new Vector2f();
            case 3:
                return new Vector3f();
            case 4:
                return new Vector4f();
            default:
                return null;
        }
    }
}

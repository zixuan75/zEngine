package zEngine.input.keys;

import java.util.HashMap;
import java.util.Map;

public class KeyMapping {
    private Map<Key, KeyResponse> keyMap = new HashMap<>();

    public void act() {
        for (Key action: keyMap.keySet()) {
            KeyResponse response = keyMap.get(action);
            response.invoke(action);
        }
    }

    public void addEntry(Key action, KeyResponse response) {
        keyMap.put(action, response);
    }
}

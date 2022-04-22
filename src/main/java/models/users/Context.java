package models.users;

import java.util.HashMap;
import java.util.Map;

public class Context {

    private static Map<String, Object> container = new HashMap<>();

    public static void set(String key, Object value) {
        container.put(key, value);
    }

    public static Object get(String key) {
        if (hasKey(key)) {
            return container.get(key);
        }

        return null;
    }

    public static boolean hasKey(String key) {
        return container.containsKey(key);
    }
}

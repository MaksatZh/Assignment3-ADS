package test;

import java.util.Objects;

public class MyTestKey {
    int key;
    String name;

    public MyTestKey(int key, String name) {
        this.key = key;
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof MyTestKey myTestKey)) return false;
        return key == myTestKey.key && Objects.equals(name, myTestKey.name);
    }

    @Override
    public int hashCode() {
        return stringHashCode(name) + key * 31;
    }

    private int stringHashCode(String str) {
        int h = 0;
        for (int i = 0; i < str.length(); i++) {
            h = 31 * h + str.charAt(i);
        }
        return h;
    }
}



package ru.geekbrains.lesson6.notes.presentation.queries.views;

import java.util.HashMap;
import java.util.Map;

public enum EditorCommands {
    CREATE_NOTE(1),
    SHOW_ALL(0),
    SHOW_NOTE(2),
    EDIT_NOTE(3),
    EXIT(4);
    private final int value;

    private static Map<Integer, EditorCommands> map = new HashMap<>();

    EditorCommands(final int newValue) {
        value = newValue;
    }

    static {
        for (EditorCommands command : EditorCommands.values()) {
            map.put(command.value, command);
        }
    }

    public static EditorCommands valueOf(int command) {
        return map.get(command);
    }

    public int getValue() { return value; }
}

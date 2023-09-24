package ru.geekbrains.lesson6.notes.presentation.queries.views;

public class CommandElement {

    private final EditorCommands command;
    private final String commandName;

    public CommandElement(EditorCommands command, String commandName) {
        this.command=command;
        this.commandName=commandName;
    }

    public EditorCommands getCommand() {
        return command;
    }

    public String getCommandName() {
        return commandName;
    }
}

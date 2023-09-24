package ru.geekbrains.lesson6.notes.presentation.queries.controllers;

import ru.geekbrains.lesson6.notes.presentation.queries.views.EditorCommands;
import ru.geekbrains.lesson6.notes.presentation.queries.views.Presenter;

public abstract class Controller {

    public <T extends Presenter> void view(T presenter){
    }

    public abstract void runCommand(EditorCommands commands);

    public abstract void init();

}

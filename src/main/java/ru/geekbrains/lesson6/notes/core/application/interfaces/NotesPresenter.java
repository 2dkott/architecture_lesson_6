package ru.geekbrains.lesson6.notes.core.application.interfaces;

import ru.geekbrains.lesson6.notes.core.domain.Note;
import ru.geekbrains.lesson6.notes.presentation.queries.views.CommandElement;

import java.util.Collection;
import java.util.List;

public interface NotesPresenter {

    void showAvailableCommands(List<CommandElement> commandElements);
    void printAll(Collection<Note> notes);

    void printNote(Note note);
}

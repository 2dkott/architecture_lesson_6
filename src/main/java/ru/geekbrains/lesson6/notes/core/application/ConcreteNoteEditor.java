package ru.geekbrains.lesson6.notes.core.application;

import ru.geekbrains.lesson6.notes.core.application.interfaces.NoteEditor;
import ru.geekbrains.lesson6.notes.core.application.interfaces.NotesDatabaseContext;
import ru.geekbrains.lesson6.notes.core.application.interfaces.NotesPresenter;
import ru.geekbrains.lesson6.notes.core.domain.Note;
import ru.geekbrains.lesson6.notes.presentation.queries.views.CommandElement;

import java.util.*;

public class ConcreteNoteEditor implements NoteEditor {

    private final NotesDatabaseContext dbContext;
    private final NotesPresenter notesPresenter;

    public ConcreteNoteEditor(NotesDatabaseContext dbContext,
                              NotesPresenter notesPresenter) {
        this.dbContext = dbContext;
        this.notesPresenter = notesPresenter;
    }

    @Override
    public void showCommands(List<CommandElement> commands) {
        notesPresenter.showAvailableCommands(commands);
    }

    @Override
    public boolean add(Note note) {
        dbContext.saveNote(note);
        return dbContext.saveChanges();
    }

    @Override
    public void edit(Note note) {
        dbContext.removeNoteById(note.getId());
        dbContext.saveNote(note);
    }

    @Override
    public boolean remove(Note item) {
        dbContext.removeNoteById(item.getId());
        return dbContext.saveChanges();
    }

    @Override
    public Optional<Note> getById(Integer id) {
        return dbContext.getAll().stream().filter(p -> p.getId() == id).findFirst();
    }

    @Override
    public void showById(Integer id) {
        Note note = getById(id).orElseThrow();
        notesPresenter.printNote(note);
    }

    @Override
    public Collection<Note> getAll() {
        return dbContext.getAll();
    }

    @Override
    public void printAll() {
        notesPresenter.printAll(getAll());
    }
}

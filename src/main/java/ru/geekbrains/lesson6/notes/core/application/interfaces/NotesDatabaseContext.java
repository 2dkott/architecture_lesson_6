package ru.geekbrains.lesson6.notes.core.application.interfaces;

import ru.geekbrains.lesson6.notes.core.domain.Note;

import java.util.Collection;

public interface NotesDatabaseContext {

    Collection<Note> getAll();

    Note getById(int noteId);

    void saveNote(Note note);

    void removeNoteById(int noteId);
    boolean saveChanges();

}

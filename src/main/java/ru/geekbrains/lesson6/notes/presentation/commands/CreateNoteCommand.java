package ru.geekbrains.lesson6.notes.presentation.commands;

import ru.geekbrains.lesson6.notes.core.application.interfaces.NoteEditor;
import ru.geekbrains.lesson6.notes.core.domain.Note;

public class CreateNoteCommand implements Command{

    private NoteEditor noteEditor;
    private Note newNote;
    public CreateNoteCommand(Note newNote, NoteEditor noteEditor) {
        this.noteEditor = noteEditor;
        this.newNote = newNote;
    }

    @Override
    public void run() {
        noteEditor.add(newNote);
    }

    @Override
    public String toString() {
        return "Команда: Создать заметку";
    }
}

package ru.geekbrains.lesson6.notes.infrastructure.persistance.configurations;

import ru.geekbrains.lesson6.database.NotesRecord;
import ru.geekbrains.lesson6.notes.core.domain.Note;
import ru.geekbrains.lesson6.notes.infrastructure.persistance.ModelConfiguration;

public class NoteConfiguration implements ModelConfiguration<Note, NotesRecord> {

    @Override
    public NotesRecord mapToRecord(Note note) {
        return new NotesRecord(note.getTitle(), note.getDetails());
    }

    @Override
    public Note mapToEntity(NotesRecord record) {
        return new Note(record.getId(), record.getUserId(), record.getTitle(), record.getDetails(), record.getCreationDate());
    }
}

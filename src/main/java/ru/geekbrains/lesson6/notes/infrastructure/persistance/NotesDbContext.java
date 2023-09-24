package ru.geekbrains.lesson6.notes.infrastructure.persistance;

import ru.geekbrains.lesson6.database.NotesDatabase;
import ru.geekbrains.lesson6.database.NotesRecord;
import ru.geekbrains.lesson6.notes.core.application.interfaces.NotesDatabaseContext;
import ru.geekbrains.lesson6.notes.core.domain.Note;
import ru.geekbrains.lesson6.notes.infrastructure.persistance.configurations.NoteConfiguration;

import java.util.ArrayList;
import java.util.Collection;
import java.util.stream.Collectors;

public class NotesDbContext extends DbContext implements NotesDatabaseContext {

    ModelConfiguration<Note, NotesRecord> mapper = new NoteConfiguration();
    @Override
    public Collection<Note> getAll() {
        return ((NotesDatabase)database).getNotesTable().getRecords().stream()
                .map(notesRecord -> mapper.mapToEntity(notesRecord))
                .collect(Collectors.toCollection(ArrayList::new));
    }

    @Override
    public Note getById(int noteId) {
        return mapper.mapToEntity(((NotesDatabase)database).getNotesTable().getRecords().stream().filter(notesRecord -> noteId==notesRecord.getId()).findFirst().get());
    }

    @Override
    public void removeNoteById(int noteId) {
        NotesRecord notesRecord = ((NotesDatabase)database).getNotesTable().getRecords().stream().filter(record -> record.getId()==noteId).findFirst().orElseThrow();
        ((NotesDatabase)database).getNotesTable().getRecords().remove(notesRecord);
    }

    @Override
    public void saveNote(Note note) {
        ((NotesDatabase)database).getNotesTable().save(mapper.mapToRecord(note));
    }

    public NotesDbContext(Database database) {
        super(database);
    }

    @Override
    protected void onModelCreating(ModelBuilder builder) {
        builder.applyConfiguration(new NoteConfiguration());
    }
}

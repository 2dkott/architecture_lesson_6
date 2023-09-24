package ru.geekbrains.lesson6.notes.presentation.queries.controllers;

import ru.geekbrains.lesson6.notes.core.application.interfaces.NoteEditor;
import ru.geekbrains.lesson6.notes.core.domain.Note;
import ru.geekbrains.lesson6.notes.presentation.queries.views.CommandElement;
import ru.geekbrains.lesson6.notes.presentation.queries.views.EditorCommands;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

public class NotesController extends Controller{

    private final NoteEditor notesEditor;

    static Scanner scanner = new Scanner(System.in);

    List<CommandElement> commands = new ArrayList<>();

    public NotesController(NoteEditor notesEditor){
        this.notesEditor = notesEditor;
        commands.add(new CommandElement(EditorCommands.SHOW_ALL, "Показать все заметки"));
        commands.add(new CommandElement(EditorCommands.CREATE_NOTE, "Создать заметку"));
        commands.add(new CommandElement(EditorCommands.SHOW_NOTE, "Посмотреть заметку"));
        commands.add(new CommandElement(EditorCommands.EDIT_NOTE, "Редактировать заметку"));
        commands.add(new CommandElement(EditorCommands.EXIT, "Выйти"));
    }

    @Override
    public void init() {
        while(true) {
            showMenu();
            if (scanner.hasNextInt()) {
                try {
                    EditorCommands command = EditorCommands.valueOf(scanner.nextInt());

                    if (Objects.isNull(command)) {
                        System.out.println("Укажите корректный пункт меню.");
                    } else {
                        if (command.equals(EditorCommands.EXIT)) {
                            break;
                        }
                        runCommand(command);
                    }

                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }
            }
        }
    }

    @Override
    public void runCommand(EditorCommands commands) {
        try {
            switch (commands) {
                case SHOW_ALL -> this.notesEditor.printAll();
                case CREATE_NOTE -> {
                    System.out.print("Укажите Ваш Id: ");
                    int userId = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Укажите название заметки: ");
                    String noteName = scanner.nextLine();
                    System.out.print("Укажите содержание заметки: ");
                    String noteDetails = scanner.nextLine();
                    Note newNote = new Note(userId, noteName, noteDetails);
                    this.notesEditor.add(newNote);
                }
                case SHOW_NOTE -> {
                    System.out.print("Укажите Id заметки: ");
                    int noteId = scanner.nextInt();
                    this.notesEditor.showById(noteId);
                }
                case EDIT_NOTE -> {
                    System.out.print("Укажите Id заметки: ");
                    int noteId = scanner.nextInt();
                    Note oldNote = this.notesEditor.getById(noteId).orElseThrow();
                    scanner.nextLine();
                    System.out.print("Укажите название заметки: ");
                    String noteName = scanner.nextLine();
                    System.out.print("Укажите содержание заметки: ");
                    String noteDetails = scanner.nextLine();
                    Note newNote = new Note(oldNote.getId(), oldNote.getUserId(), noteName, noteDetails, oldNote.getCreationDate());
                    this.notesEditor.edit(newNote);
                }
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    public void showMenu() {
        this.notesEditor.showCommands(commands);
    }
}

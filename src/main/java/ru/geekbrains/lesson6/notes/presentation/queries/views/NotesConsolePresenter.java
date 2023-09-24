package ru.geekbrains.lesson6.notes.presentation.queries.views;

import ru.geekbrains.lesson6.notes.core.application.interfaces.NotesPresenter;
import ru.geekbrains.lesson6.notes.core.domain.Note;

import java.util.Collection;
import java.util.Comparator;
import java.util.List;

public class NotesConsolePresenter implements NotesPresenter {
    @Override
    public void printAll(Collection<Note> notes) {
        for (Note note: notes) {
            System.out.println(note);
        }
    }

    @Override
    public void showAvailableCommands(List<CommandElement> commandElements) {
        System.out.println("*** Команды ***");
        System.out.println("=======================");
        commandElements.stream().sorted(Comparator.comparing(commandElement -> commandElement.getCommand().getValue())).forEach(commandElement -> {
            System.out.printf("%s. %s%n", commandElement.getCommand().getValue(), commandElement.getCommandName());
        });
        System.out.print("Пожалуйста, выберите команду: ");
    }

    @Override
    public void printNote(Note note) {
        System.out.println("*** Заметка ***");
        System.out.printf("Id: %s%n", note.getId());
        System.out.printf("Title: %s%n", note.getTitle());
        System.out.printf("Details: %s%n", note.getDetails());
        System.out.println("=======================");
    }
}

package ru.geekbrains.lesson6.notes.core.application.interfaces;

import ru.geekbrains.lesson6.notes.presentation.queries.views.CommandElement;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

public interface Editor<T, TId> {

    boolean add(T item);

    void edit(T item);

    boolean remove(T item);

    Optional<T> getById(TId id);

    Collection<T> getAll();

    void showCommands(List<CommandElement> commands);
}

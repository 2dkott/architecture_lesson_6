package ru.geekbrains.lesson6.notes.infrastructure.persistance;

public interface ModelConfiguration<T, E> {

    E mapToRecord (T object);
    T mapToEntity (E object);
}

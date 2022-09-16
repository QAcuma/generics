package ru.acuma.generics.service;

import ru.acuma.generics.model.Animal;

public interface IAnimalHandler<A extends Animal> {

    String getLocation(A animal);

}

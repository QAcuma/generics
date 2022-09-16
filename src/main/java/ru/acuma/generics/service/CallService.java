package ru.acuma.generics.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import ru.acuma.generics.model.Animal;
import ru.acuma.generics.model.Cat;
import ru.acuma.generics.model.Frog;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class CallService<A extends Animal> {

    private final AnimalHandler<A> animalHandler;

    @PostConstruct
    @SuppressWarnings("unchecked")
    public void printAnimal() {
        Animal cat = Cat.builder()
                .flat("Высотка на набережной")
                .build();
        Animal frog = Frog.builder()
                .river("Яуза")
                .build();

        var animals = List.of(cat, frog);

        animals.stream()
                .map(animal -> (A) animal)
                .map(animalHandler::handle)
                .forEach(log::info);
    }

}

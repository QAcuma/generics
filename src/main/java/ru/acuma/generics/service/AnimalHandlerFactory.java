package ru.acuma.generics.service;

import lombok.RequiredArgsConstructor;
import org.springframework.core.ResolvableType;
import org.springframework.stereotype.Component;
import ru.acuma.generics.model.Animal;

import java.util.List;
import java.util.NoSuchElementException;

@Component
@RequiredArgsConstructor
public class AnimalHandlerFactory<A extends Animal> {

    private final List<IAnimalHandler<A>> animalHandlers;

    public IAnimalHandler<A> getHandler(Animal animal) {
        ResolvableType type = ResolvableType.forClassWithGenerics(IAnimalHandler.class, animal.getClass());

        return animalHandlers.stream()
                .filter(type::isInstance)
                .findFirst()
                .orElseThrow(() -> new NoSuchElementException("Implement handler for " + animal.getClass().getSimpleName()));
    }

}

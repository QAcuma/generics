package ru.acuma.generics.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import ru.acuma.generics.model.Animal;
import ru.acuma.generics.model.Cat;
import ru.acuma.generics.model.Frog;

@Component
@RequiredArgsConstructor
public class AnimalHandler<A extends Animal> {

    private final AnimalHandlerFactory<A> animalHandlerFactory;

    public String handle(A animal) {
        var handler = animalHandlerFactory.getHandler(animal);

        return handler.getLocation(animal);
    }

    @Component
    public static class CatHandler implements IAnimalHandler<Cat> {
        @Override
        public String getLocation(Cat animal) {
            return animal.getFlat();
        }
    }

    @Component
    public static class FrogHandler implements IAnimalHandler<Frog> {
        @Override
        public String getLocation(Frog animal) {
            return animal.getRiver();
        }
    }

}

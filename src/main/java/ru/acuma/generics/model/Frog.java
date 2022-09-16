package ru.acuma.generics.model;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class Frog extends Animal{

    private String river;
    private String color;

}

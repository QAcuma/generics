package ru.acuma.generics.model;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class Cat extends Animal {

    private Integer tailLength;
    private String owner;
    private String flat;

}

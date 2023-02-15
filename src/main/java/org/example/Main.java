package org.example;
/*1.
2.
3.
Создать классы Собака и Кот с наслелованием от класса Животное
Все животные могут бежать и плыть. В качестве параметра каждому методу передается длина препятствия. Результатом выполнения дейстоия будет печать в консоль. (например, dogBobik.run(150): -» 'Бобик пробежал 150 м.):
у каждого жиботного есть ограничения на действия (бег: кот 200 м. собака 500 м г плавание: кот не уивет плавать, собака 10 м.).
* Добавить полочет созданных котов, собак и животных*/


public class Main {
    public static void main(String[] args) {
        Cat cat = new Cat(200);
        Dog dog = new Dog(500, 30);

        IAnimal[] animals = {cat, dog};
        for (IAnimal animal : animals) {
            System.out.println(animal);
            System.out.println(animal.run(150));
            System.out.println(animal.run(250));
            System.out.println(animal.run(550));
            System.out.println(animal.swim(5));
            System.out.println(animal.swim(15));
        }
        System.out.println("Animals were created: " + Animal.getCountOfAnimals());
    }
}

class Dog extends Animal {

    Dog(int runLimit, int swimLimit) {
        super(runLimit, swimLimit);
    }
}

class Cat extends Animal {

    Cat(int runLimit) {
        super(runLimit, -1);
    }

    @Override
    public String swim(int distance) {
        return getClassName() + " cant swim";
    }

}

abstract class Animal implements IAnimal {
    protected int runLimit;
    protected int swimLimit;
    protected String className;
    protected static int countOfAnimals = 0;

    Animal(int runLimit, int swimLimit) {
        this.runLimit = runLimit;
        this.swimLimit = swimLimit;
        className = getClass().getSimpleName();
        countOfAnimals++;
    }

    public String getClassName(){
        return className;
    }
    public static int getCountOfAnimals() {
        return countOfAnimals;
    }

    @Override
    public String run(int distance) {
        if (distance > runLimit) {
            return className + " couldnt run " + distance;
        } else {
            return className + " successfully run " + distance;
        }
    }


    @Override
    public String swim(int distance) {
        if (distance > swimLimit) {
            return className + " couldnt swim " + distance;
        } else {
            return className + " successfully swim " + distance;
        }
    }

    @Override
    public String toString() {
        return className + ". runLimit: " + runLimit + ", swimLimit: " + swimLimit;
    }
}


interface IAnimal {
    String run(int distance);

    String swim(int distance);
}
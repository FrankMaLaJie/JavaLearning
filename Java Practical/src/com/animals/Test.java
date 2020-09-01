package com.animals;

public class Test
{
    public static void main(String[] args)
    {
        Animal a = new Cat();
        a.setName("布丁");
        a.setAge(5);
        a.show();
        a.eat();

        a = new Cat("布丁", 5);
        a.show();
        a.eat();


//        Dog dog = new Dog();
//        dog.setName("布丁");
//        dog.setAge(3);
//        System.out.println(dog.getName()+","+dog.getAge());
//        dog.guard();
//
//        Dog dog1 = new Dog("猪猪", 5);
//        System.out.println(dog1.getName()+","+dog1.getAge());
//        dog1.guard();
//        AnimalBehavior animalBehavior = new AnimalBehavior();
//
//        Cat cat = new Cat();
//        animalBehavior.useAnimal(cat);
//
//        Dog dog = new Dog();
//        animalBehavior.useAnimal(dog);
    }
}

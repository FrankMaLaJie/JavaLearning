package com.animals;

public class Dog extends Animal
{
    public Dog()
    {
    }

    public Dog(String name, int age)
    {
        super(name, age);
    }

    public void guard(){
        System.out.println("看门");
    }

    @Override
    public void eat()
    {
        System.out.println("狗吃骨头");
    }
}

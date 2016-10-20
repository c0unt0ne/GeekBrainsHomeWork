/**
* Created by Anton Avraamov on 19.10.2016.
*/
import java.util.Scanner;

class Homework05 {
    public static void main (String[] args){
        Scanner in = new Scanner(System.in);

        int speed;
        double height;

        Animal[] arrAnimal = new Animal[3];
        arrAnimal[0] = new Cat();
        arrAnimal[1] = new Dog();
        arrAnimal[2] = new Horse();

        System.out.println("Enter speed (km/h): ");
        speed = in.nextInt();
        System.out.println("Enter jump height (m): ");
        height = in.nextDouble();

        for(int i = 0; i < arrAnimal.length; i++){
            arrAnimal[i].sound();
            arrAnimal[i].run(speed);
            arrAnimal[i].swim();
            arrAnimal[i].jump(height);
            System.out.println("********************************");
        }

    }
}
/**
* Abstract class Animal
*/
abstract class Animal {
    protected String unit;
    protected int speed;
    protected double height;

    public void sound(){
        System.out.println(this.unit + " makes a sound");
    }

    public void run(int speed){
        System.out.println(this.unit + " runs with a speed: " + speed + "km/h");
    }

    public void swim(){
        System.out.println(this.unit + " is swimming!");
    }

    public void jump(double height){
        System.out.println(this.unit + " jumps " + height + "m");
    }
}

/**
* class Cat
*/
class Cat extends Animal {

    public Cat(){
        this.unit = "Cat";
        this.speed = 15;
        this.height = 1.5;
    }

    @Override
    public void sound(){
        System.out.println(this.unit + " makes a sound: Meow!");
    }

    @Override
    public void run(int speed){
        if(speed <= this.speed){
            System.out.println(this.unit + " is running. Speed:" + speed + " km/h");
        } else {
            System.out.println(this.unit + " can't run with this speed (" + speed + " km/h)");
        }
    }

    @Override
    public void swim(){
        System.out.println(this.unit + " can't swim");
    }

    @Override
    public void jump(double height){
        if(height <= this.height){
            System.out.println(this.unit + " jumps. Height:" + height + " m");
        } else {
            System.out.println(this.unit + " can't jump with this height (" + height + " m)");
        }
    }
}

/**
* class Dog
*/
class Dog extends Animal {

    public Dog(){
        this.unit = "Dog";
        this.speed = 12;
        this.height = 0.5;
    }

    @Override
    public void sound(){
        System.out.println(this.unit + " makes a sound: Bow-wow!");
    }

    @Override
    public void run(int speed){
        if(speed <= this.speed){
            System.out.println(this.unit + " is running. Speed:" + speed + " km/h");
        } else {
            System.out.println(this.unit + " can't run with this speed (" + speed + " km/h)");
        }
    }

    @Override
    public void jump(double height){
        if(height <= this.height){
            System.out.println(this.unit + " jumps. Height:" + height + " m");
        } else {
            System.out.println(this.unit + " can't jump with this height (" + height + " m)");
        }
    }
}

/**
* class Horse
*/
class Horse extends Animal {

    public Horse(){
        this.unit = "Horse";
        this.speed = 55;
        this.height = 2.7;
    }

    @Override
    public void sound(){
        System.out.println(this.unit + " makes a sound: Neigh-neigh!");
    }

    @Override
    public void run(int speed){
        if(speed <= this.speed){
            System.out.println(this.unit + " is running. Speed:" + speed + " km/h");
        } else {
            System.out.println(this.unit + " can't run with this speed (" + speed + " km/h)");
        }
    }

    @Override
    public void jump(double height){
        if(height <= this.height){
            System.out.println(this.unit + " jumps. Height:" + height + " m");
        } else {
            System.out.println(this.unit + " can't jump with this height (" + height + " m)");
        }
    }
}
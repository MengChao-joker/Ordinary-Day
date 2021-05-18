package java_5_10;


import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Scanner;

abstract class Animal{
    public abstract void doSome();
}
class Cat extends Animal{
    private static String cat = "猫";

    @Override
    public void doSome() {
        System.out.println("你要的猫猫到了~");
    }
}
class Dog extends Animal{
    private String dog = "狗";
    @Override
    public void doSome() {
        System.out.println("你要的狗狗到了~");
    }
    public static void action(){
        System.out.println("汪汪");
    }

}

public class RefelctTest {


    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, IllegalAccessException, InstantiationException {
        Scanner scanner = new Scanner(System.in);
        String name = scanner.nextLine();
        Class<Animal> animal = (Class<Animal>) Class.forName("java_5_10."+name);
        Animal animal1 = animal.newInstance();
        animal1.doSome();

        Method doSome = animal.getDeclaredMethod("doSome");
        Dog dog = new Dog();
        doSome.invoke(dog);
        doSome.invoke(dog);

//        Method catMethod = Cat.class.getDeclaredMethod("doSome");
//        Method DogMethod = Dog.class.getDeclaredMethod("doSome");
//        Method action = Dog.class.getDeclaredMethod("action");
//        Cat cat = new Cat();
//        Dog dog = new Dog();
//        catMethod.invoke(cat);
////        catMethod.invoke(dog);
////        DogMethod.invoke(cat);
//        DogMethod.invoke(dog);
//        action.invoke(dog);
//        System.out.println("~~~~~~~~~~~~");
        System.out.println(animal.getName());
        Field[] fields = animal.getFields();
        for (Field f:fields){
            System.out.println(f);
        }
        System.out.println(doSome.toString());
        System.out.println(Arrays.toString(animal.getMethods()));

    }
}

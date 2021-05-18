package java_4_22;

import java.util.Scanner;

class Animal{
    public void doSome(){
        System.out.println("我是Animal！");
    }

}
class Dog extends Animal{
    @Override
    public void doSome() {
        System.out.println("我是Dog！");
    }
}
class Cat extends Animal{
    @Override
    public void doSome() {
        System.out.println("我是Cat！");
    }

}
public class Test {
    @Override
    public boolean equals(Object obj) {
        return this.equals((Animal)obj);
    }

    public static void main(String[] args) {
        Dog d = new Dog();
        Animal a = new Dog();
        try {
            Cat c = (Cat) new Animal();//父类引用指向父类对象时，不可以将此父类引用强转为子类引用（原因：父类实例不能提供子类的扩展方法）
            c.doSome();
        } catch (Exception e) {
            e.printStackTrace();
        }
        Dog dog1 = (Dog)a;//父类引用指向子类对象时，可以将此父类引用强转为子类引用（原因：此时父类引用的对象时子类的实例）
        dog1.doSome();
        System.out.println(dog1 == d);
        System.out.println(a instanceof Dog);
        System.out.println(a instanceof Animal);
        System.out.println(a instanceof Object);//子类的实例是其所有父类的实例
        Cat cat = new Cat();
        System.out.println(a instanceof Cat);
        System.out.println(cat instanceof Animal);
        a.doSome();
        Animal a1 = new Animal();
        a.doSome();

        
    }


    //左上角——》右下角的走法数
    public int countWays(int x, int y) {
        // write code here
        if(x<2&&y<2) return 0;
        int[][] nums = new int[x][y];
        nums[1][0] = 1;
        nums[0][1] = 1;
        for (int i = 1; i < x; i++) {
            for (int j = 1; j < y; j++) {
                nums[i][j] = nums[i-1][j]+nums[i][j-1];
            }
        }
        return nums[x-1][y-1];
    }

    public static void main3(String[] args) {
        Scanner s = new Scanner(System.in);
        while(s.hasNext()){
            int n = s.nextInt();
            if(n<2){
                System.out.println(0);
            }else {
                int[] nums = new int[n+1];
                nums[1] = 1;
                int i = 2;
                for (; i <= n; i++) {
                    nums[i] = nums[i - 1] + nums[i - 2];
                    if (nums[i] > n) break;
                }
                System.out.println(Math.min(nums[i] - n, n - nums[i - 1]));
            }
        }

    }
    public static void main2(String[] args) {
        byte a = 1;
        byte b = 2;
        System.out.println(a+b);
    }
    public static void func(StringBuilder x,StringBuilder y){

        System.out.println(x.append(y).toString());
        y=x;
        System.out.println(y);
    }
    public static void main1(String[] args) {
        StringBuilder x = new StringBuilder("4567");
        StringBuilder y = new StringBuilder("456");
        func(x,y);
        System.out.println(y);
        System.out.println(x);

    }
}

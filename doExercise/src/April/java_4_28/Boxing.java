package java_4_28;

public class Boxing {

    //装箱——拆箱
    public static void main(String[] args) {
        //装箱
        Integer num = new Integer(10);
        Integer num1 = 10;//自动装箱
        Integer num2 = Integer.valueOf(128);//-128~127之间在数组取值，否则new Integer(i)
        Integer num3 = Integer.valueOf(128);
        System.out.println(num2==num3);

        //拆箱
        int num4 = num.intValue();//手动拆箱
        int num5 = num2;//自动拆箱


    }
}

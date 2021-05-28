package everday_practice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main{

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while(scanner.hasNext()){
            String from = scanner.nextLine();
            String to = scanner.nextLine();
            String[] fromDate = from.split(" ");
            String[] toDate = to.split(" ");
            int year = Integer.parseInt(fromDate[0]);
            int month = Integer.parseInt(fromDate[1]);
            int day = Integer.parseInt(fromDate[2]);
            int year1 = Integer.parseInt(toDate[0]);
            int month1 = Integer.parseInt(toDate[1]);
            int day1 = Integer.parseInt(toDate[2]);
            int y = year1-year;
            int d = day1-day;
            int m = month1-month;
            int sum = 0;
            for (int i = 0; i < y; i++) {
                if(isLeapYear(year+i)){
                    sum+=(7*31*2+29*2+30*4);
                }else {
                    sum+=(7*31*2+28+30*4);
                }
            }
            List<Integer> list = new ArrayList<>();
            list.add(1);
            list.add(3);
            list.add(5);
            list.add(7);
            list.add(8);
            list.add(10);
            list.add(12);
            for (int i = 1; i < m; i++) {
                if(isLeapYear(year1)){
                    if(month+i==2) {
                        sum+=29*2;
                    }else if(list.contains(month+i)){
                        sum+=31*2;
                    }else {
                        sum+=30;
                    }
                }
            }
            if(isLeapYear(year)){
                if(month==2){
                    sum+=(29-day+1)*2;
                }else if(list.contains(month)){
                    sum+=(31-day+1)*2;
                }else {
                    sum+=30-day+1;
                }
            }
            if(isLeapYear(year1)){
                if(month1==2){
                    sum+=(29-day1+1)*2;
                }else if(list.contains(month1)){
                    sum+=(31-day1+1)*2;
                }else {
                    sum+=30-day1+1;
                }
            }
            System.out.println(sum);

        }

    }
    public static boolean isLeapYear(int year){
        return year%4==0&&year%100!=0||year%400==0;
    }


    public static void main1(String[] args){
        Scanner s = new Scanner(System.in);
        while(s.hasNext()){
            int from = s.nextInt();
            int to = s.nextInt();
            int num = to-from+1;
            System.out.println(fib(num));
        }
    }
    public static double fib(int nums) {
        if(nums<=2) return 1;
        double[] doubles = new double[nums];
        doubles[0] = 1;
        doubles[1] = 1;
        for (int i = 2; i < nums; i++) {
            doubles[i] = doubles[i-1]+doubles[i-2];
        }
        return doubles[nums-1];
    }

}
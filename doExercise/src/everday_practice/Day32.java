package everday_practice;

import org.omg.PortableInterceptor.INACTIVE;

import java.util.*;

public class Day32 {
    //五子棋
    public static void main1(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Character[][] map = new Character[20][20];
        while (scanner.hasNext()) {
            for (int i = 0; i < 20; i++) {
                String ip = scanner.nextLine();
                for (int j = 0; j < 20; j++) {
                    map[i][j] = ip.charAt(j);
                }
            }
            if (isSuccess(map)) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }

        }
    }

    //static int[][] direction = {{0, 1}, {0, - 1}, {1, 0}, { - 1, 0}, {1, 1}, {1, - 1}, { - 1, 1}, { - 1, - 1}};
    private static int[][] direction = {{1, 0}, {0, 1}, {1, 1},{-1,1}};

    private static boolean isSuccess(Character[][] map) {
        for (int i = 0; i < 20; i++) {
            for (int j = 0; j < 20; j++) {
                char cur = map[i][j];
                if (cur == '+' || cur == '*') {
                    for (int k = 0; k < 4; k++) {
                        int count = 1;
                        int x = i + direction[k][0];
                        int y = j + direction[k][1];
                        while (x >= 0 && x < 20 && y >= 0 && y < 20 && map[x][y] == cur) {
                            count++;
                            x+=direction[k][0];
                            y+=direction[k][1];
                        }
                        if(count==5) return true;
                    }
                }

            }
        }
        return false;


}

    //Emacs计算器
    public static void main2(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()){
            int n = scanner.nextInt();
            Stack<Integer> stack = new Stack<>();
            int ret = 0;
            for (int i = 0; i < n; i++) {
                String cur = scanner.next();
                if(cur.equals("+")){
                    ret = stack.pop()+stack.pop();
                    stack.push(ret);
                }else if(cur.equals("-")){
                    ret = -stack.pop()+stack.pop();
                    stack.push(ret);
                }else if(cur.equals("*")){
                    ret = stack.pop()*stack.pop();
                    stack.push(ret);
                }else if(cur.equals("/")){
                    int a = stack.pop();
                    int b = stack.pop();
                    ret = b/a;
                    stack.push(ret);
                }else {
                    int num = Integer.parseInt(cur);
                    stack.push(num);
                }
            }
            System.out.println(ret);

        }

    }

    public static void main(String[] args) {
        Map<String,String> map = new HashMap<>();
        map.put(null,"saca");
        Map<String,String> map1 = new Hashtable<>();
        map1.put(null, "caca");
        System.out.println(map.get(null));
        System.out.println(map1.get(null));

    }
}

package requiredClasses;

import java.util.Set;
import java.util.TreeSet;

public class Solution_TurkcellCodility {
    public static void main(String[] args) {

        int[] A = {1, 3, 6, 4, 1, 2};

        int num = new Solution_TurkcellCodility().solution(A);
        System.out.println(num);

        int num2 = new Solution_TurkcellCodility().solution2(A);
        System.out.println(num2);

    }

    public int solution(int[] A) {

        int temp = 0;
        boolean flag = true;
        while (flag) {
            temp++;
            flag = false;
            for (int i = 0; i < A.length; i++) {
                if (A[i] == temp) {
                    flag = true;
                    break;
                }
            }

        }
        return temp;
    }


    public int solution2(int[] array) {
        Set<Integer> mytreeSet = new TreeSet<>();

        for (int a : array) {
            mytreeSet.add(a);
        }

        int num = mytreeSet.size();

        int[] newArr = new int[num];

        int temp = 0;

        for (int a : mytreeSet) {
            newArr[temp++] = a;
        }

        for (int itr = 0; itr < num; itr++) {

            if (newArr[itr] > 0 && newArr[itr] <= num) {
                newArr[itr] = 0;
            }
        }

        for (int i = 0; i < num; i++) {

            if (newArr[i] != 0) {
                return (i + 1);
            }
        }

        return (num + 1);

    }
}






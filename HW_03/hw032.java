// модифицированный код с удалением повторяющихся элементов в задаче про Солнечную систему

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;

public class Seminar3 {
    public static void main(String[] args) {
        randomNumbers(10, 100);
    }

    static void randomNumbers(int size, int maxValue) {
        ArrayList<Integer> nums = new ArrayList<>(size);
        Random rand = new Random();

        for (int i = 0; i < size; i++) {
            nums.add(rand.nextInt(maxValue));
        }

        for (int num : nums) {
            System.out.print(num + " ");
        }
        System.out.println();

        nums = removeDuplicates(nums);

        Iterator<Integer> iter = nums.iterator();
        while (iter.hasNext()) {
            System.out.print(iter.next() + " ");
        }
    }

    static <T> ArrayList<T> removeDuplicates(ArrayList<T> list) {
        ArrayList<T> uniqueList = new ArrayList<>();
        for (T element : list) {
            if (!uniqueList.contains(element)) {
                uniqueList.add(element);
            }
        }
        return uniqueList;
    }
}

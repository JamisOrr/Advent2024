package DailyFiles;

import java.util.ArrayList;

public class Advent1 {

    public static String challenge1(ArrayList<String> data) {
        ArrayList<Integer> left = new ArrayList<>();
        ArrayList<Integer> right = new ArrayList<>();
        for (String line : data) {
            left.add(Integer.parseInt(line.split(" ")[0]));
            right.add(Integer.parseInt(line.split(" ")[3]));
        }
        left.sort(null);
        right.sort(null);
        int sum = 0;
        for (int i = 0; i < left.size(); i++) {
            sum += (int) Math.abs(left.get(i) - right.get(i));
        }
        return String.valueOf(sum);
    }

    public static String challenge2(ArrayList<String> data) {
        ArrayList<Integer> left = new ArrayList<>();
        ArrayList<Integer> right = new ArrayList<>();
        for (String line : data) {
            left.add(Integer.parseInt(line.split(" ")[0]));
            right.add(Integer.parseInt(line.split(" ")[3]));
        }
        right.sort(null);
        int sum = 0;
        for (int num : left) {
            if (!right.contains(num)) {
                continue;
            }
            sum += num * (right.lastIndexOf(num) - right.indexOf(num) + 1);
        }
        return String.valueOf(sum);
    }
}

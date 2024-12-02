package DailyFiles;

import java.util.ArrayList;
import java.util.StringTokenizer;

public class Advent2 {
    
    public static String challenge1(ArrayList<String> data) {
        int sum = 0;
        for (String report : data) {
            StringTokenizer tokenizer = new StringTokenizer(report, " ");
            int previous = Integer.parseInt(tokenizer.nextToken());
            int inc = 0;
            boolean safe = true;
            while (tokenizer.hasMoreTokens()) {
                int current = Integer.parseInt(tokenizer.nextToken());
                if (Math.abs(current - previous) > 3 || Math.abs(current - previous) == 0) {
                    safe = false;
                    break;
                } 
                if (inc != 0) {
                    if (inc != (current - previous) / Math.abs(current - previous)) {
                        safe = false;
                        break;
                    } 
                } else {
                    inc = (current - previous) / Math.abs(current - previous);
                }
                previous = current;
            }
            if (safe) {
                sum++;
            }
        }
        return String.valueOf(sum);
    }

    public static String challenge2(ArrayList<String> data) {
        int sum = 0;
        for (String report : data) {
            StringTokenizer tokenizer = new StringTokenizer(report, " ");
            ArrayList<Integer> tokens = new ArrayList<>();
            while (tokenizer.hasMoreTokens()) {
                tokens.add(Integer.parseInt(tokenizer.nextToken()));
            }
            if (works(tokens, true)) {
                sum++;
            }
        }
        return String.valueOf(sum);
    }

    public static boolean works(ArrayList<Integer> ints, boolean first) {
        int previous = ints.get(0);
        int inc = 0;
        for (int i = 1; i < ints.size(); i++) {
            int current = ints.get(i);
            if (Math.abs(current - previous) > 3 || Math.abs(current - previous) == 0) {
                if (first) {
                    //This is an ugly ass solution that i'm not proud of but I need to get up early tomorrow
                    ArrayList<Integer> one = (ArrayList<Integer>) ints.clone();
                    one.remove(i);
                    ArrayList<Integer> two = (ArrayList<Integer>) ints.clone();
                    two.remove(i - 1);
                    ArrayList<Integer> zero = (ArrayList<Integer>) ints.clone();
                    zero.remove(0);
                    return (works(one, false) || works(two, false) || works(zero, false));
                } else {
                    return false;
                }
            } 
            if (inc != 0) {
                if (inc != (current - previous) / Math.abs(current - previous)) {
                    if (first) {
                        ArrayList<Integer> one = (ArrayList<Integer>) ints.clone();
                        one.remove(i);
                        ArrayList<Integer> two = (ArrayList<Integer>) ints.clone();
                        two.remove(i - 1);
                        ArrayList<Integer> zero = (ArrayList<Integer>) ints.clone();
                        zero.remove(0);
                        return (works(one, false) || works(two, false) || works(zero, false));
                    } else {
                        return false;
                    }
                } 
            } else {
                inc = (current - previous) / Math.abs(current - previous);
            }
            previous = current;
        }
        return true;
    }
}

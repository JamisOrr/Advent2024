package DailyFiles;

import java.util.ArrayList;
import java.util.Arrays;

public class Advent5 {
    
    public static String challenge1(ArrayList<String> data) {
        int sum = 0;
        ArrayList<String[]> rules = new ArrayList<>();
        for (String line : data) {
            if (line.contains("|")) {
                rules.add(new String[] {line.substring(0, line.indexOf("|")), line.substring(line.indexOf("|") + 1)});
            } else {
                boolean good = true;
                for (String[] rule : rules) {
                    if (line.contains(rule[0]) && line.contains(rule[1])) {
                        if (line.indexOf(rule[0]) > line.indexOf(rule[1])) {
                            good = false;
                            break;
                        }
                    }
                }
                if (good == true) {
                    String[] temp = line.split(",");
                    sum += Integer.parseInt(temp[temp.length /2]);
                }
            }
        }
        return String.valueOf(sum);
    }

    public static String challenge2(ArrayList<String> data) {
        int sum = 0;
        ArrayList<String[]> rules = new ArrayList<>();
        ArrayList<String> bad = new ArrayList<>();
        for (String line : data) {
            if (line.contains("|")) {
                rules.add(new String[] {line.substring(0, line.indexOf("|")), line.substring(line.indexOf("|") + 1)});
            } else {
                boolean good = true;
                for (String[] rule : rules) {
                    if (line.contains(rule[0]) && line.contains(rule[1])) {
                        if (line.indexOf(rule[0]) > line.indexOf(rule[1])) {
                            bad.add(line);
                            break;
                        }
                    }
                }
                
            }
        }
        for (String baddie : bad) {
            ArrayList<String> nums = new ArrayList<>(Arrays.asList(baddie.split(",")));
            boolean loop = true;
            while (loop) { 
                loop = false;
                for (String[] rule : rules) {
                    if (!(nums.contains(rule[0]) && nums.contains(rule[1]))) {
                        continue;
                    }
                    int index1 = nums.indexOf(rule[0]);
                    int index2 = nums.indexOf(rule[1]);
                    if (index1 > index2) {
                        loop = true;
                        String temp = nums.get(index1);
                        nums.set(index1, rule[1]);
                        nums.set(index2, temp);
                    }
                }

            }
            sum += Integer.parseInt(nums.get(nums.size() / 2));
        }
        return String.valueOf(sum);
    }
}

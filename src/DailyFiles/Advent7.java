package DailyFiles;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.regex.*;

public class Advent7 {
    
    public static String challenge1(ArrayList<String> data) {
        long sum = 0;
        for (String line : data) {
            // System.out.println(line);
            String[] stringNums = line.split(" ");
            stringNums[0] = stringNums[0].substring(0, stringNums[0].indexOf(":"));
            Long[] nums = new Long[stringNums.length];
            for (int i = 0; i < stringNums.length; i++) {
                nums[i] = Long.parseLong(stringNums[i]);
            }
            if (recursiveSolve(nums[1], Arrays.copyOfRange(nums, 2, nums.length), nums[0])) {
                sum += nums[0];
            }
 
        }
        return String.valueOf(sum);
    }

    public static boolean recursiveSolve(long tempSum, Long[] possibilities, long target) {

        // System.out.println(target + ": " + tempSum + ", " + Arrays.toString(possibilities));
        if (possibilities.length == 0) {
            return tempSum == target;
        } 

        long temperSum = Long.parseLong(String.valueOf(tempSum).concat(String.valueOf(possibilities[0])));
        return (recursiveSolve(tempSum * possibilities[0], Arrays.copyOfRange(possibilities, 1, possibilities.length), target) ||  recursiveSolve(tempSum + possibilities[0], Arrays.copyOfRange(possibilities, 1, possibilities.length), target));
        
    }

    public static String challenge2(ArrayList<String> data) {
        long sum = 0;
        for (String line : data) {
            // System.out.println(line);
            String[] stringNums = line.split(" ");
            stringNums[0] = stringNums[0].substring(0, stringNums[0].indexOf(":"));
            Long[] nums = new Long[stringNums.length];
            for (int i = 0; i < stringNums.length; i++) {
                nums[i] = Long.parseLong(stringNums[i]);
            }
            if (recursiveSolve2(nums[1], Arrays.copyOfRange(nums, 2, nums.length), nums[0])) {
                sum += nums[0];
            }
 
        }
        return String.valueOf(sum);
    }

    public static boolean recursiveSolve2(long tempSum, Long[] possibilities, long target) {

        // System.out.println(target + ": " + tempSum + ", " + Arrays.toString(possibilities));
        if (possibilities.length == 0) {
            return tempSum == target;
        } 

        long temperSum = Long.parseLong(String.valueOf(tempSum).concat(String.valueOf(possibilities[0])));
        return (recursiveSolve2(tempSum * possibilities[0], Arrays.copyOfRange(possibilities, 1, possibilities.length), target) || recursiveSolve2(temperSum, Arrays.copyOfRange(possibilities, 1, possibilities.length), target) || recursiveSolve2(tempSum + possibilities[0], Arrays.copyOfRange(possibilities, 1, possibilities.length), target));
        
    }
}

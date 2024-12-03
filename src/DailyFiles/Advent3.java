package DailyFiles;

import java.util.ArrayList;
import java.util.regex.*;

public class Advent3 {
    
    public static String challenge1(ArrayList<String> data) {
        int sum = 0;
        Pattern pattern = Pattern.compile("mul\\(([1-9][0-9]{0,2}),([1-9][0-9]{0,2})\\)");
        for (String line : data) {
            String[] goTime = line.split("mul");
            for (String chunk : goTime) {
                String temp = "mul" + chunk;
                Matcher matcher = pattern.matcher(temp);
                if (matcher.find()) {        
                    int num1 = Integer.parseInt(temp.substring(4, temp.indexOf(",")));
                    int num2 = Integer.parseInt(temp.substring(temp.indexOf(",") + 1, temp.indexOf(")"))); 
                    sum += num1 * num2;   
                }
            }
        }
        return String.valueOf(sum);
    }

    public static String challenge2(ArrayList<String> data) {
        int sum = 0;
        Pattern pattern = Pattern.compile("mul\\(([1-9][0-9]{0,2}),([1-9][0-9]{0,2})\\)");
        boolean allow = true;
        for (String line : data) {
            String[] goTime = line.split("mul");
            for (String chunk : goTime) {
                String temp = "mul" + chunk;
                Matcher matcher = pattern.matcher(temp);
                if (matcher.find()) {        
                    int num1 = Integer.parseInt(temp.substring(4, temp.indexOf(",")));
                    int num2 = Integer.parseInt(temp.substring(temp.indexOf(",") + 1, temp.indexOf(")")));
                    if (allow) {
                        sum += num1 * num2;
                    }
                }
                if (temp.contains("do()") && temp.contains("don't()")) {
                    allow = temp.indexOf("do()") >= temp.indexOf("don't()");
                    continue;
                }
                if (temp.contains("do()")) {
                    allow = true;
                }
                if (temp.contains("don't()")) {
                    allow = false;
                }
            }
        }
        return String.valueOf(sum);
    }
}

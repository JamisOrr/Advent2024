package DailyFiles;

import java.util.ArrayList;


public class Advent4 {
    public static String challenge1(ArrayList<String> data) {
        char[][] tempData = new char[data.size()][data.get(0).length()];
        for (int i = 0; i < data.size(); i++) {
            tempData[i] = data.get(i).toCharArray();
        }
        int sum = 0;
        for (int i = 0; i < tempData.length; i++) {
            for (int j = 0; j < tempData[i].length; j++) {
                //right
                try {
                    if (tempData[i][j] == 'X' && tempData[i][j+1] == 'M' && tempData[i][j+2] == 'A' && tempData[i][j+3] == 'S') {
                        sum++;
                    }
                } catch (Exception e) {

                }
                //left
                try {
                    if (tempData[i][j] == 'X' && tempData[i][j-1] == 'M' && tempData[i][j-2] == 'A' && tempData[i][j-3] == 'S') {
                        sum++;
                    }
                } catch (Exception e) {

                }
                //down
                try {
                    if (tempData[i][j] == 'X' && tempData[i+1][j] == 'M' && tempData[i+2][j] == 'A' && tempData[i+3][j] == 'S') {
                        sum++;
                    }
                } catch (Exception e) {

                }
                //up
                try {
                    if (tempData[i][j] == 'X' && tempData[i-1][j] == 'M' && tempData[i-2][j] == 'A' && tempData[i-3][j] == 'S') {
                        sum++;
                    }
                } catch (Exception e) {

                }
                //up right
                try {
                    if (tempData[i][j] == 'X' && tempData[i-1][j+1] == 'M' && tempData[i-2][j+2] == 'A' && tempData[i-3][j+3] == 'S') {
                        sum++;
                    }
                } catch (Exception e) {

                }
                //up left
                try {
                    if (tempData[i][j] == 'X' && tempData[i-1][j-1] == 'M' && tempData[i-2][j-2] == 'A' && tempData[i-3][j-3] == 'S') {
                        sum++;
                    }
                } catch (Exception e) {

                }
                //down right
                try {
                    if (tempData[i][j] == 'X' && tempData[i+1][j+1] == 'M' && tempData[i+2][j+2] == 'A' && tempData[i+3][j+3] == 'S') {
                        sum++;
                    }
                } catch (Exception e) {

                }
                //down left
                try {
                    if (tempData[i][j] == 'X' && tempData[i+1][j-1] == 'M' && tempData[i+2][j-2] == 'A' && tempData[i+3][j-3] == 'S') {
                        sum++;
                    }
                } catch (Exception e) {

                }
            }
        }
        return String.valueOf(sum);
    }

    public static String challenge2(ArrayList<String> data) {
        char[][] tempData = new char[data.size()][data.get(0).length()];
        for (int i = 0; i < data.size(); i++) {
            tempData[i] = data.get(i).toCharArray();
        }
        int sum = 0;
        for (int i = 0; i < tempData.length; i++) {
            for (int j = 0; j < tempData[i].length; j++) {
                //M . S
                //. A .
                //M . S
                try {
                    if (tempData[i][j] == 'A' && tempData[i+1][j+1] == 'S' && tempData[i-1][j-1] == 'M' && tempData[i+1][j-1] == 'M' && tempData[i-1][j+1] == 'S') {
                        sum++;
                    }
                } catch (Exception e) {
                }
                //S . M
                //. A .
                //S . M
                try {
                    if (tempData[i][j] == 'A' && tempData[i+1][j+1] == 'M' && tempData[i-1][j-1] == 'S' && tempData[i+1][j-1] == 'S' && tempData[i-1][j+1] == 'M') {
                        sum++;
                    }
                } catch (Exception e) {

                }
                //S . S
                //. A .
                //M . M
                try {
                    if (tempData[i][j] == 'A' && tempData[i+1][j+1] == 'M' && tempData[i-1][j-1] == 'S' && tempData[i+1][j-1] == 'M' && tempData[i-1][j+1] == 'S') {
                        sum++;
                    }
                } catch (Exception e) {

                }
                //M . M
                //. A .
                //S . S
                try {
                    if (tempData[i][j] == 'A' && tempData[i+1][j+1] == 'S' && tempData[i-1][j-1] == 'M' && tempData[i+1][j-1] == 'S' && tempData[i-1][j+1] == 'M') {
                        sum++;
                    }
                } catch (Exception e) {

                }
            }
        }
        return String.valueOf(sum);
    }
}

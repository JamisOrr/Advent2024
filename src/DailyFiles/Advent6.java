package DailyFiles;

import java.util.ArrayList;
import java.util.HashMap;

public class Advent6 {

    public static String challenge1(ArrayList<String> data) {
        char[][] map = new char[data.size()][data.get(0).length()];
        int[] position  = new int[2];
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[0].length; j++) {
                map[i][j] = data.get(i).toCharArray()[j];
                if (map[i][j] == '^') {
                    position[0] = i;
                    position[1] = j;
                }
            }
        }
        int[][] movementVector = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
        int direction = 0;
        while (true) {
            try {
                if (map[position[0] + movementVector[direction][0]][position[1] + movementVector[direction][1]] == '#') {
                    direction++;
                    if (direction == 4) {
                        direction = 0;
                    }
                }
                map[position[0]][position[1]] = '*';
                position[0] = position[0] + movementVector[direction][0];
                position[1] = position[1] + movementVector[direction][1];
            } catch (Exception e) {
                break;
            }
        }
        int sum = 1;
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[0].length; j++) {
                if (map[i][j] == '*') {
                    sum++;
                }
            }
        }
        return String.valueOf(sum);
    }

    public static String challenge2(ArrayList<String> data) {
        char[][] map = new char[data.size()][data.get(0).length()];
        int[] position  = new int[2];
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[0].length; j++) {
                map[i][j] = data.get(i).toCharArray()[j];
                if (map[i][j] == '^') {
                    position[0] = i;
                    position[1] = j;
                }
            }
        }
        int[][] movementVector = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
        int sum = 0;
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[0].length; j++) {
                int direction = 0;
                if (map[i][j] == '#') {
                    continue;
                }
                map[i][j] = '#';
                // printMap(map);
                int[] tempPosition = {position[0], position[1], direction};
                HashMap<String, Integer> positions = new HashMap<>();
                positions.clear();
                // System.out.println(positions.get(String.format("%d,%d,%d", tempPosition[0], tempPosition[1], direction)));
                
                while (true) {
                    try {
                        Integer pastDirection = positions.get(String.format("%d,%d,%d", tempPosition[0], tempPosition[1], direction));
                        if (pastDirection != null) {
                            sum++;
                            break;
                        }
                        positions.put(String.format("%d,%d,%d", tempPosition[0], tempPosition[1], direction), 1);
                        while (map[tempPosition[0] + movementVector[direction][0]][tempPosition[1] + movementVector[direction][1]] == '#') {
                            direction++;
                            if (direction == 4) {
                                direction = 0;
                            }
                        }
                        tempPosition[0] = tempPosition[0] + movementVector[direction][0];
                        tempPosition[1] = tempPosition[1] + movementVector[direction][1];
                        
                        
                        
                        
                    } catch (Exception e) {
                        break;
                    }
                }
                map[i][j] = '*';
            }
        }
        
        return String.valueOf(sum);
    }

    public static void printMap(char[][] map) {
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[i].length; j++) {
                System.out.print(map[i][j]);
            }
            System.out.println();
        }
    }
}

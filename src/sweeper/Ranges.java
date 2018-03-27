package sweeper;

import java.util.ArrayList;

public class Ranges {
    private static Coord size;
    private static ArrayList<Coord> allCoords; // в этот список мы добавляем координаты

    public static void setSize(Coord size) {
        Ranges.size = size;
        allCoords = new ArrayList<>();
        for (int x = 0; x < size.x; x++) {
            for (int y = 0; y < size.y; y++) {
                allCoords.add(new Coord(x, y));
            }
        }
    }

    public static Coord getSize() {
        return size;
    }

    public static ArrayList<Coord> getAllCoords() {
        return allCoords;
    }

    public static boolean inRange(Coord coord) {
        return coord.x >= 0 && coord.x < size.x && coord.y >= 0 && coord.y < size.y;
    }
}

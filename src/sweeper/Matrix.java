package sweeper;

public class Matrix {
    Box[][] matrix;

    public Matrix(Box box) {
        matrix = new Box[Ranges.getSize().x][Ranges.getSize().y];
        for (Coord coord : Ranges.getAllCoords()) {
            matrix[coord.x][coord.y] = box;
        }
    }
}

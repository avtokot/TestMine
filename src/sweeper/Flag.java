package sweeper;

public class Flag {

    private Matrix flagMap;
    private int totalFlaged;
    private int totalClosed;

    public void start() {
        flagMap = new Matrix(Box.CLOSED);
        totalFlaged = 0;
        totalClosed = Ranges.getSquare();
    }

    Box get(Coord coord) {

        return flagMap.get(coord);
    }

    public void setOpenedToBox(Coord coord) {
        flagMap.set(coord, Box.OPENED);
        totalClosed--;
    }

    public void setFlagedToBox(Coord coord) {
        flagMap.set(coord, Box.FLAGED);
        totalFlaged++;
    }


    private void setClosedToBox(Coord coord) {
        flagMap.set(coord, Box.CLOSED);
        totalFlaged--;
    }

    public void toggleFlagedToBox(Coord coord) {
        switch (flagMap.get(coord)) {
            case FLAGED:
                setClosedToBox(coord);
                break;
            case CLOSED:
                setFlagedToBox(coord);
                break;
        }
    }

    int getTotalFlaged() {
        return totalFlaged;
    }

    int getTotalClosed() {
        return totalClosed;
    }
}

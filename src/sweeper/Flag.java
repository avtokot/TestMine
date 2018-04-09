package sweeper;

public class Flag {

    private Matrix flagMap;
    private int totalFlagged;
    private int totalClosed;

    public void start() {
        flagMap = new Matrix(Box.CLOSED);
        totalFlagged = 0;
        totalClosed = Ranges.getSquare();
    }

    Box get(Coord coord) {

        return flagMap.get(coord);
    }

    public void setOpenedToBox(Coord coord) {
        flagMap.set(coord, Box.OPENED);
        totalClosed--;
    }

    public void setFlaggedToBox(Coord coord) {
        flagMap.set(coord, Box.FLAGGED);
        totalFlagged++;
    }


    private void setClosedToBox(Coord coord) {
        flagMap.set(coord, Box.CLOSED);
        totalFlagged--;
    }

    public void toggleFlaggedToBox(Coord coord) {
        switch (flagMap.get(coord)) {
            case FLAGGED:
                setClosedToBox(coord);
                break;
            case CLOSED:
                setFlaggedToBox(coord);
                break;
        }
    }

    int getTotalFlagged() {
        return totalFlagged;
    }

    int getTotalClosed() {
        return totalClosed;
    }

    public void setFlaggedToLastClosedBoxes() {
        for (Coord coord : Ranges.getAllCoords()) {
            if (Box.CLOSED == flagMap.get(coord)) {
                setFlaggedToBox(coord);
            }
        }
    }

    void setBombedToBox(Coord coord) {
        flagMap.set(coord, Box.BOMBED);
    }
}

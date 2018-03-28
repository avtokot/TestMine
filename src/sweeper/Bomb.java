package sweeper;

class Bomb {
    private Matrix bombMap;
    private int totalBombs;

    Bomb(int totalBombs) {
        this.totalBombs = totalBombs;
    }

    void start() {
        bombMap = new Matrix(Box.ZERO);
        for (int i = 0; i < totalBombs; i++) {
            placeBomb();
        }
    }

    Box get(Coord coord) {
        return bombMap.get(coord);
    }

    private void placeBomb() {
        Coord coordBomb = Ranges.getRandomCoord(); // случайное расположение бомб
        bombMap.set(coordBomb, Box.BOMB);
        for (Coord around : Ranges.getAroundCoord(coordBomb)) {
            bombMap.set(around, Box.NUM1);
        }
    }

}

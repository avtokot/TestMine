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
        incNumbersAroundBomb(coordBomb);
    }

    private void incNumbersAroundBomb(Coord coordBomb) {
        for (Coord around : Ranges.getAroundCoord(coordBomb)) {
            if (Box.BOMB != get(around)) {
                bombMap.set(around, bombMap.get(around).nextNumberBox());
            }
        }
    }

}

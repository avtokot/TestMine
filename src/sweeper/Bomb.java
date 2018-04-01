package sweeper;

class Bomb {
    private Matrix bombMap;
    private int totalBombs;

    Bomb(int totalBombs) {
        this.totalBombs = totalBombs;
        fixTotalBombs();
    }

    private void fixTotalBombs() {
        int maxBombs = Ranges.getSize().x * Ranges.getSize().y / 2;
        if (totalBombs > maxBombs) {
            totalBombs = maxBombs;
        }
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

        while (true) {
            Coord coordBomb = Ranges.getRandomCoord(); // случайное расположение бомб
            if (Box.BOMB == bombMap.get(coordBomb)) {
                continue;
            }
            bombMap.set(coordBomb, Box.BOMB);
            incNumbersAroundBomb(coordBomb);
            break;
        }


    }

    private void incNumbersAroundBomb(Coord coordBomb) {
        for (Coord around : Ranges.getAroundCoord(coordBomb)) {
            if (Box.BOMB != get(around)) {
                bombMap.set(around, bombMap.get(around).nextNumberBox());
            }
        }
    }

}

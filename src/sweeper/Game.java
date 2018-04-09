package sweeper;

public class Game {

    private Bomb bomb;
    private Flag flag;

    private GameState state;

    public Game(int cols, int rows, int bombs) {
        Ranges.setSize(new Coord(cols, rows));
        bomb = new Bomb(bombs);
        flag = new Flag();
    } // конструктор

    /**
     * метод запуска игры
     */
    public void start() {
        bomb.start();
        flag.start();
        state = GameState.PLAYED;
    }

    public Box getBox(Coord coord) {
        if (Box.OPENED == flag.get(coord)) {
            return bomb.get(coord);
        } else {
            return flag.get(coord);
        }
    }

    public GameState getState() {
        return state;
    }

    public void pressLeftButton(Coord coord) {
        openBox(coord);
    }

    public int getTotalBombs() {
        return bomb.getTotalBombs();
    }

    public int getTotalFlaged() {
        return flag.getTotalFlaged();
    }

    private void openBox(Coord coord) {
        switch (flag.get(coord)) {
            case FLAGED:
                break;
            case OPENED:
                break;
            case CLOSED:
                switch (bomb.get(coord)) {
                    case ZERO:
                        openBoxesAroundZero(coord); // открывает пустые клетки
                        break;
                    case BOMB:
                        break;
                    default:
                        flag.setOpenedToBox(coord); // открывает клетки вокруг цифр
                        break;
                }
        }
    }

    private void openBoxesAroundZero(Coord coord) {
        flag.setOpenedToBox(coord);
        for (Coord around : Ranges.getAroundCoord(coord)) {
            openBox(around);
        }
    }

    public void pressRightButton(Coord coord) {
        flag.toggleFlagedToBox(coord);
    }
}

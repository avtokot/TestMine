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
        if (isGameOver()) return;
        openBox(coord);
        checkWinner();
    }

    public void pressRightButton(Coord coord) {
        if (isGameOver()) return;
        flag.toggleFlaggedToBox(coord);

    }

    private boolean isGameOver() {
        if (GameState.PLAYED != state) {
            start();
            return true;
        } else {
            return false;
        }
    }

    private void checkWinner() {
        if (GameState.PLAYED == state) {
            if (flag.getTotalClosed() == bomb.getTotalBombs()) {
                state = GameState.WINNER;
                flag.setFlaggedToLastClosedBoxes();
            }
        }
    }

    public int getTotalBombs() {
        return bomb.getTotalBombs();
    }

    public int getTotalFlagged() {
        return flag.getTotalFlagged();
    }

    private void openBox(Coord coord) {
        switch (flag.get(coord)) {
            case FLAGGED:
                break;
            case OPENED:
                setOpenedToClosedBoxesAroundNumber(coord);
                break;
            case CLOSED:
                switch (bomb.get(coord)) {
                    case ZERO:
                        openBoxesAroundZero(coord); // открывает пустые клетки
                        break;
                    case BOMB:
                        openBombs(coord);
                        break;
                    default:
                        flag.setOpenedToBox(coord); // открывает клетки вокруг цифр
                        break;
                }
        }
    }

    private void setOpenedToClosedBoxesAroundNumber(Coord coord) {
        if (Box.BOMB != bomb.get(coord)) {
            if (bomb.get(coord).getNumber() == flag.getCountOfFlaggedBoxesAround(coord)) {
                for (Coord around : Ranges.getAroundCoord(coord)) {
                    if (Box.CLOSED == flag.get(around)) {
                        openBox(around);
                    }
                }
            }
        }
    }

    private void openBombs(Coord bombedCoords) {
        flag.setBombedToBox(bombedCoords);
        for (Coord coord : Ranges.getAllCoords()) {
            if (bomb.get(coord) == Box.BOMB) {
                flag.setOpenedToClosedBox(coord);
            } else {
                flag.setNobombToFlaggedBox(coord);
            }
        }

        state = GameState.BOMBED;
    }

    private void openBoxesAroundZero(Coord coord) {
        flag.setOpenedToBox(coord);
        for (Coord around : Ranges.getAroundCoord(coord)) {
            openBox(around);
        }
    }
}

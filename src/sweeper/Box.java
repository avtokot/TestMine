package sweeper;


/**
 * Created by go on 18.03.2018.
 */
public enum Box {
    ZERO,
    NUM1,
    NUM2,
    NUM3,
    NUM4,
    NUM5,
    NUM6,
    NUM7,
    NUM8,
    BOMB,

    OPENED,
    CLOSED,
    FLAGGED,
    BOMBED,
    NOBOMB;

    public Object mImage;

    public Box nextNumberBox() {
        return Box.values()[this.ordinal() + 1];
    } // возвращает следующую цифру вокруг бомбы

    int getNumber() {
        int nr = ordinal();
        if (nr >= NUM1.ordinal() && nr <= NUM8.ordinal()) {

            return ordinal();
        }
        return -1;
    }
}

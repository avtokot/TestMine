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
    FLAGED,
    BOMBED,
    NOBOMB;

    public Object mImage;

    public Box nextNumberBox() {
        return Box.values()[this.ordinal() + 1];
    } // возвращает следующую цифру вокруг бомбы
}

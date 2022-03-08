package com.gridnine.testing;

public enum Rules {
    DEPDATE ("Отфильтрованы полеты с датой вылета до текущего момента времени"),
    SEGMENTCONTROL ("Отфильтрованы полеты, содержащие сегменты с датой прилёта раньше даты вылета"),
    GROUNDCONTROL_2H ("Отфильтрованы полеты с общим временем, проведённым на земле, превышающим два часа");

    String rulename;

    Rules(String s) {
        this.rulename =s;
    }
}

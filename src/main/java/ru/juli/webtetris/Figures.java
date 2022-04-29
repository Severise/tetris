package ru.juli.webtetris;

public enum Figures {
    lFigure,
    jFigure,
    oFigure,
    tFigure,
    iFigure,
    sFigure,
    zFigure;

    public static <T extends Enum<?>> T randomFigure(Class<T> Figs) {
        int x = (int) (Math.random() * Figs.getEnumConstants().length);
        return Figs.getEnumConstants()[x];
    }
}

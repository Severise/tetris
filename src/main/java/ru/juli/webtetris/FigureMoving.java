package ru.juli.webtetris;

import java.awt.event.KeyListener;

public interface FigureMoving{
    public void rotate();

    public boolean fall();

    public void moveLeft();

    public void moveRight();

}

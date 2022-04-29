package ru.juli.webtetris;


import java.awt.event.KeyEvent;

public class Figure implements FigureMoving{
    protected int[][] blocks;
    protected final int[] position;
    protected final String color;
    public final static int size = 4;
    public final static int starterX = 3;
    public final static int starterY = 18;
    public final int id;


    public Figure(Figures fig, int id) {
        this.position = new int[]{starterY, starterX};
        this.id = id;
        switch (fig) {
            default : {
                blocks = new int[size][size];
                color = "#555";
                return;
            }
            case jFigure : {
                blocks = new int[][]{{0, 1, 1, 0}, {0, 0, 1, 0}, {0, 0, 1, 0}, {0, 0, 0, 0}};
                color = "#00f";
                return;
            }
            case lFigure :{
                blocks = new int[][]{{0, 1, 1, 0}, {0, 1, 0, 0}, {0, 1, 0, 0}, {0, 0, 0, 0}};
                color = "#f00";
                return;
            }
            case oFigure : {
                blocks = new int[][]{{0, 0, 0, 0}, {0, 1, 1, 0}, {0, 1, 1, 0}, {0, 0, 0, 0}};
                color = "#ff0";
                return;
            }
            case tFigure :{
                blocks = new int[][]{{0, 0, 0, 0}, {0, 1, 1, 1}, {0, 0, 1, 0}, {0, 0, 0, 0}};
                color = "#f0f";
                return;
            }
            case iFigure : {
                blocks = new int[][]{{0, 0, 1, 0}, {0, 0, 1, 0}, {0, 0, 1, 0}, {0, 0, 1, 0}};
                color = "#0ff";
                return;
            }
            case zFigure :{
                blocks = new int[][]{{0, 0, 0, 0}, {0, 0, 1, 1}, {0, 1, 1, 0}, {0, 0, 0, 0}};
                color = "#0f0";
                return;
            }
            case sFigure :{
                blocks = new int[][]{{0, 0, 0, 0}, {0, 1, 1, 0}, {0, 0, 1, 1}, {0, 0, 0, 0}};
                color = "#fa0";
                return;
            }
        }
    }


    @Override
    public String toString() {
        StringBuilder s = new StringBuilder();
        for (int[] block : blocks) {
            for (int j = 0; j < blocks.length; j++)
                s.append(block[j]);
            s.append('\n');
        }
        return s.toString();
    }

    @Override
    public void rotate() {

    }

    @Override
    public boolean fall() {
        return false;
    }

    @Override
    public void moveLeft() {

    }

    @Override
    public void moveRight() {

    }
}

package ru.juli.webtetris;


import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;

public class Field {
    private final int[][] cells;
    public static int height = 22;
    public static int width = 10;
    private Figure current;
    private final int offset = 5;
    private final Figure[] next;
    private final List<Figure> figures;


    public Field() {
        this.cells = new int[height][width];

//        this.current = new Figure(Figures.jFigure, 0);
        this.current = new Figure(Figures.randomFigure(Figures.class), 1);
        figures = new ArrayList<>();
        figures.add(null);
        figures.add(current);
        next = new Figure[3];
        addFigure();
//        for (int i = 0; i < next.length; i++)
//            next[i] = new Figure(Figures.randomFigure(Figures.class));
//
//
//        for (int i = 0; i < Figure.size; i++)
//            for (int j = 0; j < Figure.size; j++)
//                if (current.blocks[i][j] == 1)
//                    cells[Figure.starterX + i][Figure.starterY + j] = 1;

//        drawField();
//        draw();
//        nextFigure();
    }

    public void nextFigure() {

        if (isEnd()) return;
//        if (StdDraw.isKeyPressed(87)) {
//            System.out.println("up");
////            current.rotate();
//        } else if (StdDraw.isKeyPressed(65)) {
//            System.out.println("left");
////            currentMoveLeft();
//        } else if (StdDraw.isKeyPressed(68)) {
//            System.out.println("right");
////            currentMoveRight();
//        } else if (StdDraw.isKeyPressed(83)) {
//            System.out.println("down");
////            currentFall();
//        }

        this.current = new Figure(Figures.randomFigure(Figures.class), current.id + 1);
        figures.add(current);
        for (int i = 0; i < Figure.size; i++)
            for (int j = 0; j < Figure.size; j++)
                if (current.blocks[i][j] == 1)
                    cells[Figure.starterY + i][Figure.starterX + j] = current.id;
//        this.current = next[0];
//        System.arraycopy(next, 1, next, 0, next.length - 1);
//        next[2] = new Figure(Figures.randomFigure(Figures.class), current.id + 3);//?
        draw();

    }

    private boolean isEnd() {
        for (int i = 0; i < width; i++)
            if (cells[height - 4][i] > 0)
                return true;
        return false;
    }

    public void draw(int... args) {
//        drawField();

        init();
//
//        StdDraw.text(0, 0, "0, 0");
//        StdDraw.text(offset, 0, offset + ", 0");
//        StdDraw.text(3 * offset, 22, 3 * offset + ", 22");
//        StdDraw.text(offset, 22, offset + ", 22");
        for (int i = 0; i < height; i++) {
//            if (current.position[1] < 22)
            for (int j = 0; j < width; j++)
                if (cells[i][j] > 0) {
//                    StdDraw.setPenColor(figures.get(cells[i][j]).color);
//                    StdDraw.filledSquare(j + offset + .5, i + .5, .5);
//                    StdDraw.setPenColor(StdDraw.BLACK);
//                    StdDraw.setPenRadius(0.004);
//                    StdDraw.square(j + offset + .5, i + .5, .5);
                }
        }
//        if (args.length > 0)
//            StdDraw.show(args[0]);
//        else

//            StdDraw.show(200);
//        if (StdDraw.isKeyPressed(87)) {
//            System.out.println("up");
//            rotate();
//        } else if (StdDraw.isKeyPressed(65)) {
//            System.out.println("left");
//            moveLeft();
//        } else if (StdDraw.isKeyPressed(68)) {
//            System.out.println("right");
//            moveRight();
//        } else if (StdDraw.isKeyPressed(83)) {
//            System.out.println("down");
//            fall();
//        }
//        if (!fall())
//            nextFigure();
    }

    public void init() {
//        StdDraw.clear();
//        StdDraw.setPenRadius();
        for (int i = 0; i <= height; i++) {
//            StdDraw.line(offset, i, width + offset, i);
        }
//        for (int i = 0; i <= width; i++)
//            StdDraw.line(i + offset, 0, i + offset, height);
    }

    public void rotate() {
        int size = current.blocks.length;
        int[][] temp = new int[size][size];
        for (int i = 0; i < size; ++i)
            for (int j = 0; j < size; ++j)
                temp[i][j] = current.blocks[size - j - 1][i];

        //shit happens if rotate when touch bot
        //sw here mb?
        //check if the lowest block upper then free cell
        //else quit


        for (int i = 0; i < size; i++)
            if ((temp[size - 1][i] == 1 && current.position[0] < 1) || (temp[size - 2][i] == 1 && current.position[0] < 0))
                return;

        for (int i = 0; i < size; i++)
            for (int j = 0; j < size; j++) {
                if (temp[i][j] == 1 && current.blocks[i][j] == 0) {
                    //shit    current.position[1] < 0
                    if (current.position[0] < 0 || cells[current.position[0] + i][current.position[1] + j] > 0) {
                        return;
                    }
                }
            }
        removeFigure();
        current.blocks = temp;
        addFigure();
        draw(0);
    }

    private void removeFigure() {
        for (int i = 0; i < Figure.size; i++)
            for (int j = 0; j < Figure.size; j++)
                if (current.position[0] + i > -1 && current.id == (cells[current.position[0] + i][current.position[1] + j]))
                    cells[current.position[0] + i][current.position[1] + j] = 0;
    }

    private void addFigure() {
        for (int i = 0; i < Figure.size; i++)
            for (int j = 0; j < Figure.size; j++)
                if (current.blocks[i][j] == 1)
                    cells[current.position[0] + i][current.position[1] + j] = current.id;
    }

    public boolean fall() {
        for (int i = 0; i < Figure.size; i++) {
            for (int j = 0; j < Figure.size; j++) {
                if (current.blocks[j][i] == 1) {
                    if (current.position[0] + j < 1 || cells[current.position[0] + j - 1][current.position[1] + i] > 0) {
                        removeLine();
                        return false;
                    }
                    break;
                }
            }
        }

        removeFigure();
        current.position[0]--;
        addFigure();

        draw();
        return true;
    }

    private void removeLine() {
        int curY;
        boolean line = true;
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++)
                if (cells[i][j] == 0) {
                    line = false;
                    break;
                }
//            System.out.println(line);
            if (line)
                for (int k = 0; k < width; k++) {
                    curY = i;
                    while (curY < height - 2)
                        cells[curY][k] = cells[++curY][k];
                }

//change
            //removeLine

        }
    }

    public void moveLeft() {
        if (this.current.position[0] > 0)
            this.current.position[0]--;
    }

    public void moveRight() {
        if (this.current.position[0] < Field.width)
            this.current.position[0]++;
    }

    public void drawField() {
//        System.out.println(Arrays.toString(cells[0]));
        for (int i = height - 1; i > -1; i--) {
            for (int j = 0; j < width; j++)
//                if (cells[i][j] > 0)
                System.out.printf("%1s ", cells[i][j]);
//                else
//                    System.out.print("*** ");
            System.out.println();
        }
        System.out.println();
    }

    //    @Override
    public void keyTyped(KeyEvent e) {

    }

    //    @Override
    public void keyPressed(KeyEvent e) {
//        if (StdDraw.isKeyPressed(87)) {
//            System.out.println("up");
////            current.rotate();
//        } else if (StdDraw.isKeyPressed(65)) {
//            System.out.println("left");
////            currentMoveLeft();
//        } else if (StdDraw.isKeyPressed(68)) {
//            System.out.println("right");
////            currentMoveRight();
//        } else if (StdDraw.isKeyPressed(83)) {
//            System.out.println("down");
////            currentFall();
//        }
    }

    //    @Override
    public void keyReleased(KeyEvent e) {

    }
}

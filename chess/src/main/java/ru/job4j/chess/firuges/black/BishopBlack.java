package ru.job4j.chess.firuges.black;

import ru.job4j.chess.firuges.Cell;
import ru.job4j.chess.firuges.Figure;

public class BishopBlack implements Figure {
    private final Cell position;

    public BishopBlack(final Cell ps) {
        position = ps;
    }

    @Override
    public Cell position() {
        return position;
    }


    @Override
    public Cell[] way(Cell source, Cell dest) {
        if (isDiagonal(source, dest)) {
            throw new IllegalStateException(
                    String.format("Could not way by diagonal from %s to %s", source, dest)// метод выводит строку с заменой символов на значения
            );
        }

        int x = source.getX();
        int y = source.getY();
        int deltaX = Integer.compare(source.getX(),dest.getX());
        int deltaY = Integer.compare(source.getY(),dest.getY());
        int size = Math.abs(source.getX()- dest.getX()) ;
        Cell[] steps = new Cell[size];
        for (int i = 0; i < size; i++) {
            steps[i] = Cell.findBy(x, y);
            x += deltaX;
            y += deltaY;
        }
        return steps;

    }
    /*проверка диагонали, разница между координатами х и у начала и конца пути всегда будет
        равна друг друг*/
    public boolean isDiagonal(Cell source, Cell dest) {
        boolean res = true;
        int deltaX = Math.abs(source.getX()-dest.getX());
        int deltaY = Math.abs(source.getY()-dest.getY());
        if( deltaX == deltaY){
            res = false;
        }
        return res;
    }

    @Override
    public Figure copy(Cell dest) {
        return new BishopBlack(dest);
    }
}
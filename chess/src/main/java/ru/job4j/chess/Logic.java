package ru.job4j.chess;

import ru.job4j.chess.firuges.Cell;
import ru.job4j.chess.firuges.Figure;
import ru.job4j.chess.firuges.black.BishopBlack;

import java.util.Arrays;

/**
 * //TODO add comments.
 *
 * @author Petr Arsentev (parsentev@yandex.ru)
 * @version $Id$
 * @since 0.1
 */
public class Logic {
    private final Figure[] figures = new Figure[32];
    private int index = 0;

    public void add(Figure figure) {
        figures[index++] = figure;
    }

    public void move(Cell source, Cell dest)
            throws FigureNotFoundException, ImpossibleMoveException, OccupiedCellException {
        int index = findBy(source);
        Cell[] steps = figures[index].way(source, dest);
        if (!isFree(steps)) {
            throw new OccupiedCellException();
        }
        figures[index] = figures[index].copy(dest);
    }
// проверка наличия фигур на пути BishopBlack..класс BishopBlack подключен выше
    private boolean isFree(Cell[] steps) {
        for(Cell cell : steps) {
                for (int index = 0; index != figures.length; index++){
                    if (figures[index].position().equals(cell)){
                        return false;
                    }
                }

            }

        return true;
    }

    public void clean() {
        Arrays.fill(figures, null);
        index = 0;
    }

    private int findBy(Cell cell) throws FigureNotFoundException {
        for (int index = 0; index != figures.length; index++) {
            if (figures[index] != null && figures[index].position().equals(cell)) {
                return index;
            }
        }
        throw new FigureNotFoundException();
    }
}

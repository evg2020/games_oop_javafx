package ru.job4j.chess;

import org.junit.Ignore;
import org.junit.Test;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

import ru.job4j.chess.firuges.Cell;
import ru.job4j.chess.Logic;
import ru.job4j.chess.firuges.Figure;
import ru.job4j.chess.firuges.black.BishopBlack;
import ru.job4j.chess.firuges.white.QueenWhite;

public class LogicTest {

    @Ignore
    @Test
    public void move()
            throws FigureNotFoundException, OccupiedCellException, ImpossibleMoveException {
        Logic logic = new Logic();
        logic.add(new BishopBlack(Cell.C1));
        logic.move(Cell.C1, Cell.H6);
    }

    @Test
    public void isFreeWhenFigureisOnTheWay() {

        Logic logic = new Logic();
        Figure queenWhite = new QueenWhite(Cell.B2);
        logic.add(queenWhite);
        Cell[] steps = new Cell[]{Cell.B2, Cell.A1};
        boolean real = logic.isFree(steps);
        assertThat(real, is(false));
    }

    @Test
    public void isFreeWhenFigureIsNotOnTheWay() {
         Logic logic = new Logic();
        Cell[] steps = new Cell[]{Cell.B2, Cell.A1};
        boolean real = logic.isFree(steps);
        boolean expect = true;
        assertThat(real, is(expect));
    }


}
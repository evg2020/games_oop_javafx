package ru.job4j.chess.firuges.black;

import org.junit.Test;
import ru.job4j.chess.firuges.Cell;
import ru.job4j.chess.firuges.Figure;




import static org.hamcrest.core.Is.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.Assert.*;

public class BishopBlackTest {

// проверка метода Copy
    @Test
    public void position() {
        Cell source = Cell.A3;
        assertThat(new BishopBlack(source).position(), is(source));
    }
    // проверка метода way заполнение массива пути
    @Test
    public void way() {
        Cell source = Cell.C1;
        Cell dest = Cell.A3;
        BishopBlack bishopBlack = new BishopBlack(source);
        Cell[]real = bishopBlack.way(source, dest);
        Cell[] expect = new Cell[]{Cell.B2, Cell.A3};
          assertThat(real, is(expect));
    }


    // проверка метода правильности диаганали
    @Test
    public void isDiagonal() {
        Cell source = Cell.C1;
        Cell dest = Cell.A3;
        assertThat(new BishopBlack(source).isDiagonal(source, dest), is(true));
    }


    @Test
    public void copy() {
               Cell dest = Cell.A3;
        Figure dd = new BishopBlack(dest);
        Figure newDD = dd.copy(dest);
        assertThat(newDD, is(newDD));
    }
}
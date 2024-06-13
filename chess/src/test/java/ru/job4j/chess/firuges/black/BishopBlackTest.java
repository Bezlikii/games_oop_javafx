package ru.job4j.chess.firuges.black;


import org.junit.jupiter.api.Test;
import ru.job4j.chess.ImpossibleMoveException;
import ru.job4j.chess.firuges.Cell;
import ru.job4j.chess.firuges.Figure;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertThrows;

class BishopBlackTest {

    @Test
    void checkPosition() {
        BishopBlack bishopBlack = new BishopBlack(Cell.C1);
        Cell result = bishopBlack.position();
        assertThat(result).isEqualTo(Cell.C1);
    }

    @Test
    void checkCopy() {
        Figure bishopBlack = new BishopBlack(Cell.C1);
        Figure copiedBishop = bishopBlack.copy(Cell.G5);
        Cell result = copiedBishop.position();
        assertThat(result).isEqualTo(Cell.G5);
        assertThat(bishopBlack.position()).isEqualTo(Cell.C1);
    }

    @Test
    void checkWay() {
        Figure bishopBlack = new BishopBlack(Cell.C1);
        Cell[] result = bishopBlack.way(Cell.G5);
        Cell[] expected = {Cell.D2, Cell.E3, Cell.F4, Cell.G5};
        assertThat(result).isEqualTo(expected);
    }

    @Test
    void checkDiagonalIfBusy() {
        Figure bishopBlack = new BishopBlack(Cell.C1);
        Cell result = Cell.F6;
        assertThrows(ImpossibleMoveException.class, () -> {
            bishopBlack.way(result);
        });
    }
}
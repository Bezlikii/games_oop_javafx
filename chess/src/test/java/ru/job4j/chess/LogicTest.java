package ru.job4j.chess;

import org.junit.jupiter.api.Test;
import ru.job4j.chess.firuges.Cell;
import ru.job4j.chess.firuges.Figure;
import ru.job4j.chess.firuges.black.BishopBlack;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class LogicTest {

    @Test
    public void whenMoveThenFigureNotFoundException()
            throws FigureNotFoundException, OccupiedCellException, ImpossibleMoveException {
        Logic logic = new Logic();
        FigureNotFoundException exception = assertThrows(FigureNotFoundException.class, () -> {
            logic.move(Cell.C1, Cell.H6);
        });
        assertThat(exception.getMessage()).isEqualTo("Figure not found on the board.");
    }

    @Test
    void whenMoveThenOccupiedCellException() throws OccupiedCellException {
        Logic logic = new Logic();
        Figure bishopBlack = new BishopBlack(Cell.C1);
        Figure bishopBlack2 = new BishopBlack(Cell.G5);
        logic.add(bishopBlack);
        logic.add(bishopBlack2);
        OccupiedCellException exception = assertThrows(OccupiedCellException.class,
                () -> logic.move(Cell.C1, Cell.G5));
        assertThat(exception.getMessage()).isEqualTo("This diagonal is busy.");
    }
}
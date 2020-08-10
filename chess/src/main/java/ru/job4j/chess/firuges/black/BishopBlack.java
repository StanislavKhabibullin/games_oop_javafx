package ru.job4j.chess.firuges.black;

import ru.job4j.chess.Logic;
import ru.job4j.chess.firuges.Cell;
import ru.job4j.chess.firuges.Figure;
import static java.lang.Math.*;

public class BishopBlack implements Figure {
    private final Cell position;

    public BishopBlack(final Cell position) {
        this.position = position;
    }

    @Override
    public Cell position() {
        return this.position;
    }

    @Override
    public Cell[] way(Cell source, Cell dest) {

        int deltaX = dest.x - source.x;
        int deltaY = dest.y - source.y;
        if (!isDiagonal(source, dest)) {
            throw new IllegalStateException(
                    String.format("Could not move by diagonal from %s to %s", source, dest)
            );
        } else {

            Cell[] rezult = new Cell[abs(deltaX)];
            int x = source.x;
            int y = source.y;
            for (int i = 0; i < abs(deltaX); i++) {
                x = x + (deltaX / abs(deltaX));
                y = y + (deltaY / abs(deltaY));
                rezult[i] = Cell.findBy(x, y);
            }

            return rezult;
        }
    }


    public boolean isDiagonal(Cell source, Cell dest) {
        int deltaX = dest.x - source.x;
        int deltaY = dest.y - source.y;
        if (abs(deltaX) == abs(deltaY)) {
            return true;
        }
        return false;
    }

    @Override
    public Figure copy(Cell dest) {
        return new BishopBlack(dest);
    }
}

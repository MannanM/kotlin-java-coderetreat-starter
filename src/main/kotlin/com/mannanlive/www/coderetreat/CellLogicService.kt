package com.mannanlive.www.coderetreat

class CellLogicService {
    fun calculateCellState(
        targetCell: Cell,
        neighbourCells: List<Cell>,
    ): CellState {
        val numberOfAliveNeighbours = neighbourCells
            .filter { it.state == CellState.ALIVE }
            .size

        return if (targetCell.state == CellState.DEAD) {
            if (numberOfAliveNeighbours == 3) {
                CellState.ALIVE
            } else {
                CellState.DEAD
            }
        } else {
            if (numberOfAliveNeighbours == 2 || numberOfAliveNeighbours == 3) {
                CellState.ALIVE
            } else {
                CellState.DEAD
            }
        }
    }

}

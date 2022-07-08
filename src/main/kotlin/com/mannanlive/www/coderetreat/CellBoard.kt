package com.mannanlive.www.coderetreat

data class CellBoard(val board: List<List<Cell>>) {
    private val cellLogicService = CellLogicService()

    fun calculateNextState(): CellBoard {
        return CellBoard(
            board.mapIndexed { rowIndex: Int, row ->
                row.mapIndexed { cellIndex: Int, cell ->
                    Cell(
                        cellLogicService.calculateCellState(
                            cell,
                            getNeighbourCells(rowIndex, cellIndex),
                        )
                    )
                }
            }
        )
    }

    fun getNeighbourCells(rowIndex: Int, cellIndex: Int): List<Cell> {
        val leftCell = if (cellIndex - 1 < 0) {
            board[0].size - 1
        } else {
            cellIndex - 1
        }
        val rightCell = if (cellIndex + 1 == board[0].size) {
            0
        } else {
            cellIndex + 1
        }

        val topRow = if (rowIndex - 1 < 0) {
            board.size - 1
        } else {
            rowIndex - 1
        }

        val bottomRow = if (rowIndex + 1 == board.size) {
            0
        } else {
            rowIndex + 1
        }
        return listOf(
            board[topRow][leftCell],
            board[topRow][cellIndex],
            board[topRow][rightCell],
            board[rowIndex][leftCell],
            board[rowIndex][rightCell],
            board[bottomRow][leftCell],
            board[bottomRow][cellIndex],
            board[bottomRow][rightCell],
        )
    }

    fun print(): String {
        val sb = StringBuilder()
        for (i in 0..board[0].size + 2) {
            sb.append("-")
        }
        sb.append("\r\n")
        board.forEach { row ->
            sb.append("|")
            row.forEach { cell ->
                if (cell.state == CellState.ALIVE) {
                    sb.append('X')
                } else {
                    sb.append(' ')
                }
            }
            sb.append("|\r\n")
        }
        for (i in 0..board[0].size + 2) {
            sb.append("-")
        }
        sb.append("\r\n")
        return sb.toString()
    }

}

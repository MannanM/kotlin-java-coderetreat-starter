package com.mannanlive.www.coderetreat

import io.kotest.matchers.collections.shouldHaveSize
import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.Test

class CellBoardTest {

    private val deadCell = Cell(CellState.DEAD)
    private val aliveCell = Cell(CellState.ALIVE)

    private val deadRow = listOf(
        deadCell,
        deadCell,
        deadCell,
        deadCell,
        deadCell,
        deadCell,
        deadCell,
        deadCell,
    )

    private val rowWithOneAliveCell = listOf(
        deadCell,
        deadCell,
        deadCell,
        aliveCell,
        deadCell,
        deadCell,
        deadCell,
        deadCell,
    )

    private val boardWithOneAliveCell = CellBoard(
        listOf(
            deadRow,
            deadRow,
            deadRow,
            deadRow,
            rowWithOneAliveCell,
            deadRow,
            deadRow,
            deadRow,
        )
    )

    @Test
    fun `can get neighbour cells`() {
        boardWithOneAliveCell.getNeighbourCells(4, 3).filter { it.state == CellState.DEAD } shouldHaveSize 8
        boardWithOneAliveCell.getNeighbourCells(4, 3).filter { it.state == CellState.ALIVE } shouldHaveSize 0
    }

    @Test
    fun `can get neighbour cells that are alive`() {
        boardWithOneAliveCell.getNeighbourCells(4, 4).filter { it.state == CellState.DEAD } shouldHaveSize 7
        boardWithOneAliveCell.getNeighbourCells(4, 4).filter { it.state == CellState.ALIVE } shouldHaveSize 1
    }

    @Test
    fun `can get neighbour on the edge of the board`() {
        boardWithOneAliveCell.getNeighbourCells(4, 0).filter { it.state == CellState.DEAD } shouldHaveSize 8
        boardWithOneAliveCell.getNeighbourCells(4, 7).filter { it.state == CellState.DEAD } shouldHaveSize 8
        boardWithOneAliveCell.getNeighbourCells(0, 4).filter { it.state == CellState.DEAD } shouldHaveSize 8
        boardWithOneAliveCell.getNeighbourCells(7, 4).filter { it.state == CellState.DEAD } shouldHaveSize 8
    }

    @Test
    fun `board with one alive cell should become all dead`() {
        val board = CellBoard(
            listOf(
                deadRow,
                deadRow,
                deadRow,
                deadRow,
                rowWithOneAliveCell,
                deadRow,
                deadRow,
                deadRow,
                deadRow,
            )
        )

        val nextState = board.calculateNextState()

        nextState.board.forEach { row ->
            row.forEach { cell ->
                cell.state shouldBe CellState.DEAD
            }
        }

        println(board.print())
        println("Next state")
        println(nextState.print())
    }

    @Test
    fun `does it work?`() {
        val rows = mutableListOf<List<Cell>>()
        for (i in 0..10) {
            val row = mutableListOf<Cell>()
            for (j in 0..60) {
                row.add(creteRandomCell())
            }
            rows.add(row)
        }

        var board = CellBoard(rows)
        while (true) {
            println(board.print())
            board = board.calculateNextState()
            Thread.sleep(1000)
        }

    }

    private fun creteRandomCell(): Cell {
        return if (Math.random() < 0.2) {
            Cell(CellState.ALIVE)
        } else {
            Cell(CellState.DEAD)
        }
    }
}

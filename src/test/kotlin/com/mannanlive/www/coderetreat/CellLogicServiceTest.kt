package com.mannanlive.www.coderetreat

import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test

class CellLogicServiceTest {

    @Nested
    inner class AliveScenarios {
        @Test
        fun `alive cell with no neighbours should die`() {
            CellLogicService().calculateCellState(
                targetCell = Cell(CellState.ALIVE),
                neighbourCells = listOf()
            ) shouldBe CellState.DEAD
        }

        @Test
        fun `alive cell with four neighbours should die`() {
            CellLogicService().calculateCellState(
                targetCell = Cell(CellState.ALIVE),
                neighbourCells = listOf(
                    Cell(CellState.ALIVE),
                    Cell(CellState.ALIVE),
                    Cell(CellState.ALIVE),
                    Cell(CellState.ALIVE),
                )
            ) shouldBe CellState.DEAD
        }

        @Test
        fun `alive cell with two neighbours should live`() {
            CellLogicService().calculateCellState(
                targetCell = Cell(CellState.ALIVE),
                neighbourCells = listOf(
                    Cell(CellState.ALIVE),
                    Cell(CellState.ALIVE),
                )
            ) shouldBe CellState.ALIVE
        }

        @Test
        fun `alive cell with three neighbours should live`() {
            CellLogicService().calculateCellState(
                targetCell = Cell(CellState.ALIVE),
                neighbourCells = listOf(
                    Cell(CellState.ALIVE),
                    Cell(CellState.ALIVE),
                    Cell(CellState.ALIVE),
                )
            ) shouldBe CellState.ALIVE
        }
    }


    @Nested
    inner class DeadScenarios {
        @Test
        fun `dead cell with three neighbours should live`() {
            CellLogicService().calculateCellState(
                targetCell = Cell(CellState.DEAD),
                neighbourCells = listOf(
                    Cell(CellState.ALIVE),
                    Cell(CellState.ALIVE),
                    Cell(CellState.ALIVE),
                )
            ) shouldBe CellState.ALIVE
        }

        @Test
        fun `dead cell with two neighbours should remain dead`() {
            CellLogicService().calculateCellState(
                targetCell = Cell(CellState.DEAD),
                neighbourCells = listOf(
                    Cell(CellState.ALIVE),
                    Cell(CellState.ALIVE),
                )
            ) shouldBe CellState.DEAD
        }

        @Test
        fun `dead cell with four neighbours should remain dead`() {
            CellLogicService().calculateCellState(
                targetCell = Cell(CellState.DEAD),
                neighbourCells = listOf(
                    Cell(CellState.ALIVE),
                    Cell(CellState.ALIVE),
                    Cell(CellState.ALIVE),
                    Cell(CellState.ALIVE),
                )
            ) shouldBe CellState.DEAD
        }
    }

}

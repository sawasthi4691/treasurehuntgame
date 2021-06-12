package com.treasure.hunt.game.service;

import com.treasure.hunt.game.model.GameHuntBoard;
import com.treasure.hunt.game.repository.GameBoardRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;

@Service
public class OutputService implements  TreasureHuntOutputServiceIntf{

    private static final Logger LOGGER = LoggerFactory.getLogger(OutputService.class);
    private static final String TREASURE_FOUND = "Treasure Found!!!";
    private static final String ROW_VISITED = "Row Visited!!!";

    private final GameBoardRepository gameBoardRepository;

    @Autowired
    public OutputService(GameBoardRepository gameBoardRepository){
        this.gameBoardRepository = gameBoardRepository;
    }

    /**
     * Show the output to the user by passing user id which want to play the treasure hunt game.
     *
     * @param uniqueId : uniqueId
     * @return : List<String>
     */
    @Override
    public List<String> output(String uniqueId) {
        GameHuntBoard gameHuntBoard = gameBoardRepository.output(uniqueId);
        return findTreasure(gameHuntBoard);
    }


    /**
     * Find treasure index and row column visited.
     *
     * @param gameHuntBoard : gameHuntBoard
     * @return : Map<String, String>
     */
    private List<String> findTreasure(GameHuntBoard gameHuntBoard) {
        boolean found = false;
        List<String> list = new LinkedList<>();
        Integer[][] treasureArray = gameHuntBoard.getBoard();
        int currentCellRow = 0;
        int currentCellCol = 0;
        while (!found) {
            LOGGER.info("Currently in row  {} and col {}", (currentCellRow + 1), (currentCellCol + 1));
            String row = String.valueOf(currentCellRow + 1);
            String column = String.valueOf(currentCellCol + 1);
            list.add(row + "" + column + " : " + ROW_VISITED);
            int value = treasureArray[currentCellRow][currentCellCol];
            int nextCellCol = value % 10 - 1;
            value /= 10;
            int nextCellRow = value % 10 - 1;
            FindTreasure findTreasure = new FindTreasure(found, list, currentCellRow, currentCellCol, nextCellCol, nextCellRow).invoke();
            found = findTreasure.isFound();
            currentCellRow = findTreasure.getCurrentCellRow();
            currentCellCol = findTreasure.getCurrentCellCol();
        }
        return list;
    }


    /**
     * FindTreasure
     * Inner class created.
     * To avoid logic in one place.
     */
    private static class FindTreasure {
        private boolean found;
        private final List<String> list;
        private int currentCellRow;
        private int currentCellCol;
        private final int nextCellCol;
        private final int nextCellRow;

        public FindTreasure(boolean found, List<String> list, int currentCellRow, int currentCellCol, int nextCellCol, int nextCellRow) {
            this.found = found;
            this.list = list;
            this.currentCellRow = currentCellRow;
            this.currentCellCol = currentCellCol;
            this.nextCellCol = nextCellCol;
            this.nextCellRow = nextCellRow;
        }

        public boolean isFound() {
            return found;
        }

        public int getCurrentCellRow() {
            return currentCellRow;
        }

        public int getCurrentCellCol() {
            return currentCellCol;
        }

        public FindTreasure invoke() {
            if (nextCellCol == currentCellCol && nextCellRow == currentCellRow) {
                LOGGER.info("Currently in row  {} and col {} and  {} ", (currentCellRow + 1), (currentCellCol + 1), TREASURE_FOUND);
                String row1 = String.valueOf(currentCellRow + 1);
                String column1 = String.valueOf(currentCellCol + 1);
                list.add(row1 + "" + column1 + " : " + TREASURE_FOUND);
                found = true;
            } else {
                currentCellCol = nextCellCol;
                currentCellRow = nextCellRow;
            }
            return this;
        }
    }
}

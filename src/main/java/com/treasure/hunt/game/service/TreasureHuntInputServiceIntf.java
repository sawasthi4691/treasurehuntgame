package com.treasure.hunt.game.service;

import com.treasure.hunt.game.model.GameHunt;
import com.treasure.hunt.game.model.GameHuntBoard;

import java.util.List;
import java.util.Map;

import static com.treasure.hunt.game.util.ErrorConstant.SIZE;

public interface TreasureHuntInputServiceIntf {

    String takeInput( GameHunt gameHunt);

    GameHuntBoard output(String Id);

    /**
     * Get the GameHuntBoardValue
     * @param arrayMap :arrayMap
     * @param userId : userId
     * @return GameHuntBoard
     */
    default GameHuntBoard getGameBoardValue(Map<String, List<Integer>> arrayMap, String userId) {
        GameHuntBoard gameHuntBoard = new GameHuntBoard();
        Integer[][] board = new Integer[SIZE][SIZE];
        for (Map.Entry<String,List<Integer>> entry: arrayMap.entrySet()) {
            Integer row = Integer.parseInt(entry.getKey()) - 1;
            List<Integer> list = entry.getValue();
            for (int i =0 ; i< list.size() ;i++) {
                board[row][i] = list.get(i);
            }
        }
        gameHuntBoard.setUserId(userId);
        gameHuntBoard.setBoard(board);
        return gameHuntBoard;
    }
}

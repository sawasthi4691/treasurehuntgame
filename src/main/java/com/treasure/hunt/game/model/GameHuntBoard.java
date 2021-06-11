package com.treasure.hunt.game.model;

import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
public class GameHuntBoard {

    private  String userId;
    private  Integer[][] board;

    public Integer[][] getBoard() {
        return board;
    }

    public void setBoard(Integer[][] board) {
        this.board = board;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    @Override
    public String toString() {
        return "GameHuntBoard{" +
                "userId='" + userId + '\'' +
                ", board=" + Arrays.toString(board) +
                '}';
    }
}

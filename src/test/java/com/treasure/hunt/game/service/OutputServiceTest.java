package com.treasure.hunt.game.service;

import com.treasure.hunt.game.model.GameHuntBoard;
import com.treasure.hunt.game.repository.GameBoardRepository;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.data.redis.core.RedisTemplate;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;


class OutputServiceTest {

    @InjectMocks
    private OutputService outputService;
    @Mock
    private GameBoardRepository gameBoardRepository;
    @Mock
    private RedisTemplate<String, GameHuntBoard> redisTemplate;

    @Test
    void outputTest(){
        MockitoAnnotations.openMocks(this);
        when(gameBoardRepository.output(anyString())).thenReturn(getGameHuntBoard());
        List<String> result = outputService.output(anyString());
        assertNotNull(result);
        assertEquals(20,result.size());
    }


    /**
     * {
     * 	"user-id" : "15",
     * 	"treasure-map" : {
     * 		  "1" : [34 , 21 , 32 , 41 ,25],
     * 		  "2" : [14 , 42 , 43 , 14 ,31],
     * 		  "3" : [54 , 45 , 52 , 42,  23  ],
     * 		  "4" : [33 , 15 , 51 , 31 , 35  ],
     * 		  "5" : [21 , 52 , 33 , 13 , 23  ]
     *
     *        }
     *
     * }
     * @return :GameHuntBoard
     */
    private GameHuntBoard getGameHuntBoard(){
        GameHuntBoard gameHuntBoard = new GameHuntBoard();
        gameHuntBoard.setUserId("1");
        Integer[][] board = new Integer[5][5];
        board[0][0] = 34;
        board[0][1] = 21;
        board[0][2] = 32;
        board[0][3] = 41;
        board[0][4] = 25;
        board[1][0] = 14;
        board[1][1] = 42;
        board[1][2] = 43;
        board[1][3] = 14;
        board[1][4] = 31;
        board[2][0] = 54;
        board[2][1] = 45;
        board[2][2] = 52;
        board[2][3] = 42;
        board[2][4] = 23;
        board[3][0] = 33;
        board[3][1] = 15;
        board[3][2] = 51;
        board[3][3] = 31;
        board[3][4] = 35;
        board[4][0] = 21;
        board[4][1] = 52;
        board[4][2] = 33;
        board[4][3] = 13;
        board[4][4] = 23;
        gameHuntBoard.setBoard(board);
        return gameHuntBoard;
    }
}

package com.treasure.hunt.game.repository;

import com.treasure.hunt.game.model.GameHuntBoard;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.*;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.SetOperations;
import org.springframework.data.redis.core.ValueOperations;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;


public class GameBoardRepositoryTest {

    @InjectMocks
    private GameBoardRepository gameBoardRepository;

    @Mock
    private RedisTemplate<String, GameHuntBoard> redisTemplate;

    @Before
    public void setup() {
        MockitoAnnotations.openMocks(this);

        RedisTemplate redisTemplate = Mockito.mock(RedisTemplate.class);
        ValueOperations valueOperations = Mockito.mock(ValueOperations.class);
        SetOperations setOperations = Mockito.mock(SetOperations.class);

        when(redisTemplate.opsForValue()).thenReturn(valueOperations);
        doNothing().when(redisTemplate.opsForValue()).set(any(), any());
    }

    @Test
    public void testSaveBoard() {

        GameHuntBoard gameHuntBoard = new GameHuntBoard();
        gameHuntBoard.setUserId("1");
        Integer[][] board = new Integer[5][5];
        gameHuntBoard.setBoard(board);

        gameBoardRepository.saveBoard(gameHuntBoard);
        Mockito.verify(redisTemplate, Mockito.times(1)).opsForValue().set(gameHuntBoard.getUserId(), gameHuntBoard);
    }

    @Test
    public void testOutput() {
        GameHuntBoard output = gameBoardRepository.output("1");
        Assert.assertNotNull(output);
    }
}

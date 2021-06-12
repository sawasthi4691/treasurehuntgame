package com.treasure.hunt.game.service;

import com.treasure.hunt.game.model.GameHunt;
import com.treasure.hunt.game.model.GameHuntBoard;
import com.treasure.hunt.game.repository.GameBoardRepository;
import com.treasure.hunt.game.validation.InputValidation;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.util.Assert;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertNotNull;

class InputServiceTest {

    @InjectMocks
    private InputService inputService;
    @Mock
    private GameBoardRepository gameBoardRepository;
    @Mock
    private RedisTemplate<String, GameHuntBoard> redisTemplate;
    @Mock
    private InputValidation inputValidation;


    @Test
    void takeInputTest(){
        MockitoAnnotations.openMocks(this);
        inputService.takeInput(getGameHunt());
        assertNotNull(getGameHunt());
    }

    private GameHunt getGameHunt(){
        Map<String,List<Integer>> map = new HashMap<>();
        GameHunt gameHunt = new GameHunt();
        gameHunt.setUserId("15");
        map.put("1", Arrays.asList(34,21,32,41,25));
        map.put("2", Arrays.asList(14 , 42 , 43 , 14 ,31));
        map.put("3", Arrays.asList(54 , 45 , 52 , 42,  23 ));
        map.put("4", Arrays.asList(33 , 15 , 51 , 31 , 35 ));
        map.put("5", Arrays.asList(21 , 52 , 33 , 13 , 23));
        gameHunt.setArrayMap(map);
        return gameHunt;
    }
}

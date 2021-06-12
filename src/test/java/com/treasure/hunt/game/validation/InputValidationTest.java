package com.treasure.hunt.game.validation;

import com.treasure.hunt.game.exception.ValidationException;
import com.treasure.hunt.game.model.GameHunt;
import org.apache.commons.lang3.StringUtils;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.doThrow;

class InputValidationTest {

    @InjectMocks
    private InputValidation inputValidation;

    @Mock
    private InputValidation validation;

    @Test
    void successTest(){
        MockitoAnnotations.openMocks(this);
        assertNotNull(getGameHunt());
        inputValidation.validateInput(getGameHunt());
    }


    @Test
    void emptyUserTest(){
        MockitoAnnotations.openMocks(this);
        GameHunt gameHunt = getGameHunt();
        gameHunt.setUserId(StringUtils.EMPTY);
        doThrow(ValidationException.class).when(validation).validateInput(gameHunt);
    }

    @Test
    void isBoardEmpty(){
        MockitoAnnotations.openMocks(this);
        GameHunt gameHunt = getGameHunt();
        gameHunt.setArrayMap(null);
        doThrow(ValidationException.class).when(validation).validateInput(gameHunt);
    }

    @Test
    void isRowNotValidTest(){
        MockitoAnnotations.openMocks(this);
        GameHunt gameHunt = getGameHuntForInValidRow();
        doThrow(ValidationException.class).when(validation).validateInput(gameHunt);
    }


    @Test
    void isColumnNotValidTest(){
        MockitoAnnotations.openMocks(this);
        GameHunt gameHunt = getGameHuntForInValidColumn();
        doThrow(ValidationException.class).when(validation).validateInput(gameHunt);
    }


    private GameHunt getGameHunt(){
        Map<String, List<Integer>> map = new HashMap<>();
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

    private GameHunt getGameHuntForInValidRow(){
        Map<String, List<Integer>> map = new HashMap<>();
        GameHunt gameHunt = new GameHunt();
        gameHunt.setUserId("15");
        map.put("1", Arrays.asList(34,21,32,41,25));
        map.put("2", Arrays.asList(14 , 42 , 43 , 19 ,31));
        map.put("3", Arrays.asList(54 , 45 , 52 , 42,  23 ));
        map.put("4", Arrays.asList(33 , 15 , 51 , 31 , 35 ));
        map.put("5", Arrays.asList(21 , 52 , 33 , 13 , 23));
        gameHunt.setArrayMap(map);
        return gameHunt;
    }

    private GameHunt getGameHuntForInValidColumn(){
        Map<String, List<Integer>> map = new HashMap<>();
        GameHunt gameHunt = new GameHunt();
        gameHunt.setUserId("15");
        map.put("1", Arrays.asList(34,21,32,41,25));
        map.put("2", Arrays.asList(14 , 42 , 43 , 14 ,31));
        map.put("3", Arrays.asList(54 , 45 , 91 , 42,  23 ));
        map.put("4", Arrays.asList(33 , 15 , 51 , 31 , 35 ));
        map.put("5", Arrays.asList(21 , 52 , 33 , 13 , 23));
        gameHunt.setArrayMap(map);
        return gameHunt;
    }
}

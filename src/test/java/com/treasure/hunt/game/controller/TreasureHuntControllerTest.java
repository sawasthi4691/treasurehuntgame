package com.treasure.hunt.game.controller;

import com.treasure.hunt.game.model.GameHunt;
import com.treasure.hunt.game.service.TreasureHuntInputServiceIntf;
import com.treasure.hunt.game.service.TreasureHuntOutputServiceIntf;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;


public class TreasureHuntControllerTest {

    @InjectMocks
    private TreasureHuntController treasureHuntController;

    @Mock
    private TreasureHuntInputServiceIntf inputService;
    @Mock
    private TreasureHuntOutputServiceIntf outputService;
    @Mock
    private HttpServletRequest httpServletRequest;

    @Before
    public void setup() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testTakeInput() {
        Mockito.doNothing().when(inputService).takeInput(ArgumentMatchers.any(GameHunt.class));
        ResponseEntity<HttpStatus> response = treasureHuntController.takeInput(new GameHunt(), httpServletRequest);
        Assert.assertEquals(HttpStatus.ACCEPTED, response.getStatusCode());
        Mockito.verify(inputService, Mockito.times(1)).takeInput(ArgumentMatchers.any(GameHunt.class));
    }

    @Test
    public void testOutput() {
        List<String> output = new ArrayList<>();
        output.add("11");
        Mockito.when(outputService.output(ArgumentMatchers.anyString())).thenReturn(output);
        ResponseEntity<Object> response = treasureHuntController.output(ArgumentMatchers.anyString());
        Assert.assertEquals(HttpStatus.OK, response.getStatusCode());
        Mockito.verify(outputService, Mockito.times(1)).output(ArgumentMatchers.any(String.class));
    }


}

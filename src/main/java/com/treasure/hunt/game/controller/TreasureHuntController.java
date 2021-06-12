package com.treasure.hunt.game.controller;

import com.treasure.hunt.game.model.GameHunt;
import com.treasure.hunt.game.service.TreasureHuntInputServiceIntf;
import com.treasure.hunt.game.service.TreasureHuntOutputServiceIntf;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.List;

@RestController
public class TreasureHuntController {

    private static final Logger LOGGER = LoggerFactory.getLogger(TreasureHuntController.class);

    private TreasureHuntInputServiceIntf treasureHuntInputServiceIntf;
    private TreasureHuntOutputServiceIntf treasureHuntOutputServiceIntf;

    @Autowired
    public TreasureHuntController(TreasureHuntInputServiceIntf treasureHuntInputServiceIntf,TreasureHuntOutputServiceIntf treasureHuntOutputServiceIntf){
        this.treasureHuntInputServiceIntf = treasureHuntInputServiceIntf;
        this.treasureHuntOutputServiceIntf = treasureHuntOutputServiceIntf;
    }

    @PostMapping(value = "/input")
    public ResponseEntity<HttpStatus> takeInput(@RequestBody @Valid  final GameHunt gameHunt, HttpServletRequest request) {
        LOGGER.info("TreasureHuntController : takeInput  : start");
        treasureHuntInputServiceIntf.takeInput(gameHunt);
        LOGGER.info("TreasureHuntController : takeInput  : end");
        return ResponseEntity.ok(HttpStatus.ACCEPTED);
    }


    @GetMapping(value = "/output/{id}")
    public ResponseEntity<Object> output(@PathVariable final String id)  {
        LOGGER.info("TreasureHuntController : output  : start");
        List<String>  outputResult = treasureHuntOutputServiceIntf.output(id);
        return ResponseEntity.ok(outputResult);
    }

}

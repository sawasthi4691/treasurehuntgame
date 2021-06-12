package com.treasure.hunt.game.service;

import com.treasure.hunt.game.model.GameHunt;
import com.treasure.hunt.game.model.GameHuntBoard;
import com.treasure.hunt.game.repository.GameBoardRepository;
import com.treasure.hunt.game.validation.InputValidation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class InputService implements TreasureHuntInputServiceIntf {

    private static final Logger LOGGER = LoggerFactory.getLogger(InputService.class);

    private InputValidation inputValidation;
    private GameBoardRepository gameBoardRepository;

    @Autowired
    public InputService(InputValidation inputValidation, GameBoardRepository gameBoardRepository) {
        this.inputValidation = inputValidation;
        this.gameBoardRepository = gameBoardRepository;
    }

    /**
     * Take input from user and save it.
     *
     * @param gameHunt :gameHunt
     */
    @Override
    public void takeInput(final GameHunt gameHunt) {
        LOGGER.info("InputService : takeInput : takeInput : {}", gameHunt);
        inputValidation.validateInput(gameHunt);
        GameHuntBoard gameHuntBoard = getGameBoardValue(gameHunt.getArrayMap(), gameHunt.getUserId());
        gameBoardRepository.saveBoard(gameHuntBoard);
        LOGGER.info("InputService : takeInput : takeInput : end");
    }

}

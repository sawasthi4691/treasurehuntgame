package com.treasure.hunt.game.repository;

import com.treasure.hunt.game.model.GameHuntBoard;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

import java.util.Map;

@Repository
public class GameBoardRepository {

    private static final Logger LOGGER = LoggerFactory.getLogger(GameBoardRepository.class);

    private RedisTemplate<String, GameHuntBoard> redisTemplate;

    @Autowired
    public GameBoardRepository(RedisTemplate<String, GameHuntBoard> redisTemplate){
        this.redisTemplate = redisTemplate;
    }

    /**
     * Save Board Game value
     * @param gameHuntBoard : gameHuntBoard
     */
    public void saveBoard(GameHuntBoard gameHuntBoard) {
        LOGGER.info("Inside GameBoardRepository : saveBoard : start");
        redisTemplate.opsForValue().set(gameHuntBoard.getUserId(), gameHuntBoard);
        LOGGER.info("Inside GameBoardRepository : saveBoard : end");
    }

    /**
     * Fetch the value from Redis DB.
     * @param uniqueID
     * @return
     */
    public GameHuntBoard output(String uniqueID){
        return redisTemplate.opsForValue().get(uniqueID);
    }
}

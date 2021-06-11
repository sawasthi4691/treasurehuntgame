package com.treasure.hunt.game.validation;

import com.treasure.hunt.game.exception.ValidationException;
import com.treasure.hunt.game.model.GameHunt;
import org.apache.commons.collections4.MapUtils;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

import static com.treasure.hunt.game.util.ErrorConstant.*;

@Component
public class InputValidation {

    private static final Logger LOGGER = LoggerFactory.getLogger(InputValidation.class);

    /**
     * Validate input given by the user.
     * @param gameHunt : gameHunt
     */
    public void validateInput(final GameHunt gameHunt) {
        LOGGER.info("InputValidation : validateInput :start");
        validateGameBoard(StringUtils.isEmpty(gameHunt.getUserId()), EMPTY_USER);
        checkSizeOfArray(gameHunt.getArrayMap());
        LOGGER.info("InputValidation : validateInput :end");
    }

    private void validateGameBoard(boolean empty, String emptyUser) {
        if (empty) {
            throw new ValidationException(emptyUser);
        }
    }

    /**
     * This method check array is of 5x5.
     * @param arrayMap : arrayMap
     */
    private void checkSizeOfArray(Map<String, List<Integer>> arrayMap) {
        LOGGER.info("InputValidation : validateInput : checking treasure-map size");
        checkSize(MapUtils.isEmpty(arrayMap), EMPTY_MAP);
        LOGGER.info("InputValidation : validateInput : checking row size");
        checkSize(arrayMap.size() != SIZE, INVALID_ROW);
        checkColumnSize(arrayMap);
        checkTreasureBoxValues(arrayMap);
    }



    /**
     * Size of column should be 5.
     * @param arrayMap :arrayMap
     */
    private void checkColumnSize(Map<String, List<Integer>> arrayMap) {
        LOGGER.info("InputValidation : validateInput : checking column size");
        for (Map.Entry<String,List<Integer>> entry: arrayMap.entrySet()) {
            List<Integer> list = entry.getValue();
            checkSize(list.size() != SIZE,INVALID_COLUMN);
        }
    }

    /**
     * Check the value passed should be between 11 and 55.
     * @param arrayMap : arrayMap
     */
    private void checkTreasureBoxValues(Map<String, List<Integer>> arrayMap) {
        for (Map.Entry<String,List<Integer>> entry: arrayMap.entrySet()) {
            String row = entry.getKey();
            List<Integer> list = entry.getValue();
            for (Integer val: list) {
                validateGameBoard(val <= 10 || val > 55, OUT_OF_LIMIT + row);
                /*check row value should not be greater than 5.*/
                validateGameBoard(val % 10 > SIZE, ARRAY_INDEX_OUT_OF_BOUND  + val);
            }
        }
    }

    /**
     * Check the size.
     * @param result : result
     * @param invalidRow : invalidRow
     */
    private void checkSize(boolean result, String invalidRow) {
        validateGameBoard(result, invalidRow);
    }
}

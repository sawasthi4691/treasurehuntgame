package com.treasure.hunt.game.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.stereotype.Component;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class GameHunt {

    @NotEmpty
    private Map<String, List<@NotBlank Integer>> arrayMap;

    @NotBlank
    private String userId;

    @JsonCreator
    public GameHunt() {
        arrayMap = new HashMap<>();
    }

    @JsonCreator
    private GameHunt(@JsonProperty(value = "treasure-map") Map<String, List<Integer>> arrayMap,@JsonProperty(value = "user-id") String userId) {
        this.arrayMap = arrayMap;
        this.userId = userId;
    }

    public Map<String, List<Integer>> getArrayMap() {
        return arrayMap;
    }

    public void setArrayMap(Map<String, List<Integer>> arrayMap) {
        this.arrayMap = arrayMap;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    @Override
    public String toString() {
        return "GameHunt{" +
                "arrayMap=" + arrayMap +
                ", userId='" + userId + '\'' +
                '}';
    }
}

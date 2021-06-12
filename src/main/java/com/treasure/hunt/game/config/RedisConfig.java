package com.treasure.hunt.game.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.treasure.hunt.game.model.GameHuntBoard;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;

@Configuration
public class RedisConfig {

    private final ObjectMapper objectMapper;

    private final RedisConnectionFactory redisConnectionFactory;

    @Autowired
    public RedisConfig(ObjectMapper objectMapper, RedisConnectionFactory redisConnectionFactory) {
        this.objectMapper = objectMapper;
        this.redisConnectionFactory = redisConnectionFactory;
    }

    /**
     * Setting up the Redis template object.
     * @return : RedisTemplate
     */
    @Bean
    public RedisTemplate<String, GameHuntBoard> redisTemplate() {
        final Jackson2JsonRedisSerializer<GameHuntBoard> jackson2JsonRedisSerializer = new Jackson2JsonRedisSerializer<>(GameHuntBoard.class);
        jackson2JsonRedisSerializer.setObjectMapper(objectMapper);
        final RedisTemplate<String, GameHuntBoard> redisTemplate = new RedisTemplate<>();
        redisTemplate.setConnectionFactory(redisConnectionFactory);
        redisTemplate.setKeySerializer(new StringRedisSerializer());
        redisTemplate.setValueSerializer(jackson2JsonRedisSerializer);
        return redisTemplate;
    }
}

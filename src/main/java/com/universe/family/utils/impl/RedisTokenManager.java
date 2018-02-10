package com.universe.family.utils.impl;

import com.universe.family.config.Constants;
import com.universe.family.utils.TokenManager;
import com.universe.family.model.TokenModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

@Component
public class RedisTokenManager implements TokenManager {

    @Autowired
    @Resource(name = "strRedisTemplate")
    private StringRedisTemplate redis;
/*
    @Autowired
    @Resource(name = "stringRedisTemplate")
    public void setRedis(StringRedisTemplate redis) {
        this.redis = redis;
        redis.setKeySerializer(new JdkSerializationRedisSerializer());
    }
*/
    public TokenModel createToken(String userId) {
        String token = UUID.randomUUID().toString().replace("-", "");
        TokenModel model = new TokenModel(userId, token);

        System.out.println("createToken:" + userId +"_"+ token);

        redis.boundValueOps(userId).set(token, Constants.TOKEN_EXPIRES_HOUR, TimeUnit.HOURS);

        return model;
    }

    public TokenModel getToken(String authentication) {
        if (authentication == null || authentication.length() == 0) {
            return null;
        }

        String[] param = authentication.split("_");
        if (param.length != 2) {
            return null;
        }

        //使用userId和源token简单拼接成的token，可以增加加密措施
        String userId = param[0];
        String token = param[1];

        System.out.println("getToken:" + userId +"_"+ token);

        return new TokenModel(userId, token);
    }

    public boolean checkToken(TokenModel model) {
        if (model == null) {
            return false;
        }
        String token = redis.boundValueOps(model.getUserId()).get();
        System.out.println("checkToken from Redis:" +  token);
        if (token == null || !token.equals(model.getToken())) {
            return false;
        }

        redis.boundValueOps(model.getUserId()).expire(Constants.TOKEN_EXPIRES_HOUR, TimeUnit.HOURS);

        return true;
    }

    public void deleteToken(String userId) {
        redis.delete(userId);
    }

    public boolean IsInRedis(String userId) {

        String token = redis.boundValueOps(userId).get();

        if (token == null || token.isEmpty() ) return false;

        else return true;
    }
}

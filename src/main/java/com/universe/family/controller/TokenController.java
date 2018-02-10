package com.universe.family.controller;

import com.universe.family.utils.ResultStatus;
import com.universe.family.model.TokenModel;
import com.universe.family.model.video.User;
import com.universe.family.model.net.ResultModel;

import com.universe.family.model.video.UserRepository;
import com.universe.family.utils.TokenManager;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/tokens")
@Api(value = "好电影用户API", description = "包括用户注册/登陆/登出等")
public class TokenController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private TokenManager tokenManager;

    @GetMapping(value = "all1")
    public ResponseEntity<ResultModel> findAll1() {
        List<User> users = userRepository.findAll();
        if (users.size()==0) {
            return new ResponseEntity<>(ResultModel.error(ResultStatus.NOT_FOUND_USER), HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(ResultModel.ok(users), HttpStatus.OK);
    }

    @GetMapping(value = "regUser1/{username}/{password}/{email}")
    @ApiOperation(value = "注册")
    public @ResponseBody ResponseEntity<ResultModel> regUser1(@PathVariable String username,
                                                             @PathVariable String password, @PathVariable String email) {
        Assert.notNull(username, "用户名不能为空");
        Assert.notNull(password, "密码不能为空");
        Assert.notNull(password, "邮箱用户名不能为空");

        User user = new User();
        user.setNickname(email);
        user.setUsername(username);
        user.setPassword(password);
        user.setType("普通会员");

        User ret = userRepository.save(user);

        // Must be List, don't know why?
        List<User> retList = new ArrayList<>();
        retList.add(ret);

        return new ResponseEntity<>(ResultModel.ok(retList), HttpStatus.OK);
    }

    @GetMapping(value = "login1/{username}/{password}")
    @ApiOperation(value="登陆")
    public ResponseEntity<ResultModel> login1(@PathVariable String username, @PathVariable String password) {
        Assert.notNull(username, "username can not be empty");
        Assert.notNull(password, "password can not be empty");

        User user = userRepository.findByUsername(username);
        if (user == null || !user.getPassword().equals(password)) {
            return new ResponseEntity<>(ResultModel.error(ResultStatus.USERNAME_OR_PASSWORD_ERROR), HttpStatus.NOT_FOUND);
        }

        TokenModel model = tokenManager.createToken(String.valueOf(user.getId()));
        return new ResponseEntity<>(ResultModel.ok(model), HttpStatus.OK);
    }

    @GetMapping(value = "logout1/{id}")
    @ApiOperation(value = "退出当前登录")
    public @ResponseBody ResponseEntity<ResultModel> logout1(@PathVariable String id) {
        tokenManager.deleteToken(id);
        return new ResponseEntity<>(ResultModel.ok("Success"),HttpStatus.OK);
    }

}
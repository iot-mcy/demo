package com.example.demo.controller;

import com.example.demo.model.AjaxResponse;
import com.example.demo.model.UserVO;
import com.example.demo.service.UserServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@Slf4j
@RestController
@RequestMapping("/user")
public class UserController {

    private final String TAG = UserController.class.getSimpleName() + " : {}";

    ///@Autowired
    @Resource(name = "userServiceImpl")
    private UserServiceImpl userService;

    @PostMapping(value = "/save")
    public AjaxResponse saveUser(@RequestBody UserVO user) {
        log.info(TAG, user.toString());
        user = userService.saveUser(user);
        return user == null ? AjaxResponse.failure() : AjaxResponse.success(user);
    }

    @GetMapping("/{userID}")
    public AjaxResponse getUser(@PathVariable int userID) {
        log.info(TAG, String.valueOf(userID));
        UserVO userVO = userService.getUser(userID);
        if (userVO != null) {
            log.info(TAG, userVO.toString());
            return AjaxResponse.success(userVO);
        } else {
            return AjaxResponse.failure();
        }
    }

    @GetMapping("/all")
    public AjaxResponse getAllUser() {
        List<UserVO> list = userService.getAll();
        log.info(TAG, list.toString());
        return AjaxResponse.success(list);
    }

    @DeleteMapping("/{userID}")
    public AjaxResponse deleteUser(@PathVariable int userID) {
        log.info(TAG, String.valueOf(userID));
        int i = userService.deleteUser(userID);
        return i > 0 ? AjaxResponse.success() : AjaxResponse.failure();
    }

    @PutMapping("/update")
    public AjaxResponse updateUser(@RequestBody UserVO userVO) {
        log.info(TAG, userVO.toString());
        int i = userService.updateUser(userVO);
        return i > 0 ? AjaxResponse.success() : AjaxResponse.failure();
    }
}

package com.example.demo.service;

import com.example.demo.generator.testdb.User;
import com.example.demo.generator.testdb.UserMapper;
import com.example.demo.generator.testdb2.Items;
import com.example.demo.generator.testdb2.ItemsMapper;
import com.example.demo.model.UserVO;
import com.example.demo.utils.DozerUtils;
import lombok.extern.slf4j.Slf4j;
import org.dozer.Mapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@Slf4j
@Service
public class UserServiceImpl implements UserService {
    private final String TAG = UserServiceImpl.class.getSimpleName();

    @Resource
    private Mapper dozerMapper;

    @Resource
    private UserMapper userMapper;

    @Resource
    private ItemsMapper itemsMapper;

    @Override
    @Transactional
    public UserVO saveUser(UserVO userVO) {
        log.info(TAG, userVO);
        User user = dozerMapper.map(userVO, User.class);
        int i = userMapper.insertSelective(user);

        //测试分布式事务
//        Items items = new Items();
//        items.setName("苹果11");
//        items.setPrice(9.99);
//        int i2 = itemsMapper.insertSelective(items);

//        int a = 1/0;//异常抛出自动回滚

        if (i == 1) {
            return getUser(user.getId());
        }
        return null;
    }

    @Override
    public int deleteUser(int id) {
        return userMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int updateUser(UserVO userVO) {
        User user = dozerMapper.map(userVO, User.class);
        return userMapper.updateByPrimaryKeySelective(user);
    }

    @Override
    public UserVO getUser(int id) {
        User user = userMapper.selectByPrimaryKey(id);
        if (user != null) {
            return dozerMapper.map(user, UserVO.class);
        } else {
            return null;
        }
    }

    @Override
    public List<UserVO> getAll() {
        List<User> userList = userMapper.selectByExample(null);
        return DozerUtils.mapList(userList, UserVO.class);
    }
}

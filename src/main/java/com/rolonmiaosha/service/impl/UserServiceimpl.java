package com.rolonmiaosha.service.impl;

import com.rolonmiaosha.dao.UserMapper;
import com.rolonmiaosha.dao.UserPasswordMapper;
import com.rolonmiaosha.pojo.User;
import com.rolonmiaosha.pojo.UserPassword;
import com.rolonmiaosha.service.UserService;
import com.rolonmiaosha.service.model.UserModel;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceimpl implements UserService {

    @Autowired
    private UserMapper userMapper;
    @Autowired
    private UserPasswordMapper userPasswordMapper;

    @Override
    public UserModel getUserById(Integer id) {
        User user = userMapper.selectByPrimaryKey(id);

        if (user==null){
            return null;
        }
        //通过用户id获取对应的用户加密密码信息
        UserPassword userPassword = userPasswordMapper.selectByUserId(user.getId());

        return  convertFromDataObject(user,userPassword);
    }

    private  UserModel convertFromDataObject(User user, UserPassword userPassword){
        if (user==null){
            return null;
        }
        UserModel userModel =new UserModel();
        BeanUtils.copyProperties(user,userModel);
        if (userPassword==null){
            return null;
        }
        userModel.setEncrptPassword(userPassword.getEncrptPassword());

        return  userModel;

    }

}

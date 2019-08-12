package com.tlzx.mapper;

import com.tlzx.model.User;

import java.util.List;

public interface UserMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);

    public List<User> selectAllUser();

    public int insertUser(User user);

    public int deleteUser(int id);

    public List<User> findUsers(String keyWords);

    public int editUser(User user);

    public Integer selectUsersCount();

    public List<Integer> selectIds();
}
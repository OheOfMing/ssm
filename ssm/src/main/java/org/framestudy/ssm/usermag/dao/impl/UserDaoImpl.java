package org.framestudy.ssm.usermag.dao.impl;

import javax.annotation.Resource;

import org.framestudy.ssm.usermag.beans.UserBean;
import org.framestudy.ssm.usermag.dao.IUserDao;
import org.framestudy.ssm.usermag.mapper.UserMapper;
import org.springframework.stereotype.Repository;

@Repository
public class UserDaoImpl implements IUserDao {

	@Resource
	private UserMapper userMapper;
	
	@Override
	public int saveUserInfo(UserBean user) {
		// TODO Auto-generated method stub
		return userMapper.saveUserInfo(user);
	}

	@Override
	public int updateUserInfo(UserBean user) {
		// TODO Auto-generated method stub
		return userMapper.updateUserInfo(user);
	}

	@Override
	public int deleteUserInfo(Long id) {
		// TODO Auto-generated method stub
		return userMapper.deleteUserInfo(id);
	}

	@Override
	public UserBean getUserBeanById(Long id) {
		// TODO Auto-generated method stub
		return userMapper.getUserBeanById(id);
	}

}

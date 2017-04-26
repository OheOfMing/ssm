package org.framestudy.ssm.usermag.service.impl;

import javax.annotation.Resource;

import org.framestudy.ssm.usermag.beans.UserBean;
import org.framestudy.ssm.usermag.dao.IUserDao;
import org.framestudy.ssm.usermag.service.IUserService;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements IUserService{

	@Resource
	private IUserDao userDaoImpl;	
	
	@Override
	public int saveUserInfo(UserBean user) {
		// TODO Auto-generated method stub
		return userDaoImpl.saveUserInfo(user);
	}

	@Override
	public int updateUserInfo(UserBean user) {
		// TODO Auto-generated method stub
		return userDaoImpl.updateUserInfo(user);
	}

	@Override
	public int deleteUserInfo(Long id) {
		// TODO Auto-generated method stub
		return userDaoImpl.deleteUserInfo(id);
	}

	@Override
	public UserBean getUserBeanById(Long id) {
		// TODO Auto-generated method stub
		return userDaoImpl.getUserBeanById(id);
	}

}

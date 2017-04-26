package org.framestudy.ssm.usermag.dao;

import org.framestudy.ssm.usermag.beans.UserBean;

public interface IUserDao {
	/**
	 * 保存用户
	 * @param user
	 * @return
	 */
	public int saveUserInfo(UserBean user);
	/**
	 * 修改用户
	 * @param user
	 * @return
	 */
	public int updateUserInfo(UserBean user);
	/**
	 * 删除用户
	 * @param id
	 * @return
	 */
	public int deleteUserInfo(Long id);
	/**
	 * 根据id查询用户
	 * @param id
	 * @return
	 */
	public UserBean getUserBeanById(Long id);
}

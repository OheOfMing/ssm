package org.framestudy.ssm.usermag.mapper;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.framestudy.ssm.usermag.beans.UserBean;

public interface UserMapper {
	/**
	 * 保存用户
	 * @param user
	 * @return
	 */
	@Insert("insert into t_user (user_name,password,login_name,age) values (#{user.userName},#{user.password},#{user.loginName},#{user.age})")
	@Options(useGeneratedKeys=true,keyProperty="user.id")
	public int saveUserInfo(@Param("user")UserBean user);
	
	/**
	 * 修改用户
	 * @param user
	 * @return
	 */
	@Update("update t_user set user_name = #{user.userName},password = #{user.password},login_name = #{user.loginName},age = #{user.age} where id = #{user.id}")
	public int updateUserInfo(@Param("user")UserBean user);
	/**
	 * 删除用户
	 * @param id
	 * @return
	 */
	@Delete("delete from t_user where id = #{id}")
	public int deleteUserInfo(Long id);
	/**
	 * 根据id查询用户
	 * @param id
	 * @return
	 */
	@Select("select * from t_user where id = #{id}")
	@Results({
		@Result(id=true,property="id",column="id",javaType=Long.class),
		@Result(property="userName",column="user_name",javaType=String.class),
		@Result(property="loginName",column="login_name",javaType=String.class),
		@Result(property="password",column="password",javaType=String.class),
		@Result(property="age",column="age",javaType=Integer.class)
	})
	public UserBean getUserBeanById(Long id);
}

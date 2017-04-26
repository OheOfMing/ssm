package org.framestudy.ssm.usermag.controller;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.framestudy.ssm.pojos.Messager;
import org.framestudy.ssm.usermag.beans.UserBean;
import org.framestudy.ssm.usermag.service.IUserService;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/users")
@RestController
//将所有方法的执行结果放入到响应体中，并且将该组件交给spring容器
public class UserAjaxController {

	//对当前类记录日志
	private Logger logger = Logger.getLogger(this.getClass());
	
	@Resource
	private IUserService userServiceImpl;
	
	@RequestMapping(value="/{id}",method=RequestMethod.POST,produces={"application/json;charset=utf-8"})
	public Messager saveUserInfo(@RequestBody UserBean user){
		
		Messager msg = new Messager(true,"操作成功！");
		logger.info(user);
		
		System.out.println(System.getProperty("ssm.root"));
		
		try {
			userServiceImpl.saveUserInfo(user);
		} catch (Exception e) {
			// TODO: handle exception
			logger.error("UserAjaxController----------saveUserInfo()",e);
			msg.setStatus(false);
			msg.setMsg("系统繁忙，请稍后重试！");
		}
		logger.info(msg);
		return msg;
	}
	
	/**
	 * 修改
	 * @param user
	 * @param id
	 * @return
	 */
	@RequestMapping(value="/{id}",method=RequestMethod.PUT,produces={"application/json;charset=utf-8"})
	public Messager updateUserInfo(@RequestBody UserBean user,@PathVariable("id")Long id){
		
		Messager msg = new Messager(true,"操作成功！");
		logger.info(user);
		logger.info(id);
		try {
			user.setId(id);
			userServiceImpl.updateUserInfo(user);
		} catch (Exception e) {
			// TODO: handle exception
			logger.error("UserAjaxController----------updateUserInfo()",e);
			msg.setStatus(false);
			msg.setMsg("系统繁忙，请稍后重试！");
		}
		logger.info(msg);
		return msg;
	}
	/**
	 * 根据ID查询资源
	 * @param id
	 * @return
	 */
	@RequestMapping(value="/{id}",method=RequestMethod.GET,produces={"application/json;charset=utf-8"})
	public UserBean queryUserInfo(@PathVariable("id")Long id){
		
		UserBean user = null;
		logger.info(id);
		try {
			user = userServiceImpl.getUserBeanById(id);
		} catch (Exception e) {
			// TODO: handle exception
			logger.error("UserAjaxController----------queryUserInfo()",e);
		}
		logger.info(user);
		return user;
	}
	
	/**
	 * 根据ID删除资源
	 * @param id
	 * @return
	 */
	@RequestMapping(value="/{id}",method=RequestMethod.DELETE,produces={"application/json;charset=utf-8"})
	public Messager deleteUserInfo(@PathVariable("id")Long id){
		
		Messager msg = new Messager(true,"操作成功！");
		logger.info(id);
		try {
			userServiceImpl.deleteUserInfo(id);
		} catch (Exception e) {
			// TODO: handle exception
			logger.error("UserAjaxController----------deleteUserInfo()",e);
			msg.setStatus(false);
			msg.setMsg("系统繁忙，请稍后重试！");
		}
		logger.info(msg);
		return msg;
	}
	
	
	
	
	
	
	
	
}

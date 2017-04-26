package org.framestudy.ssm.usermag.controller;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.framestudy.ssm.usermag.beans.UserBean;
import org.framestudy.ssm.usermag.service.IUserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@RequestMapping("/persons")
@Controller
//将所有方法的执行结果放入到响应体中，并且将该组件交给spring容器
public class UserFormController {

	//对当前类记录日志
	private Logger logger = Logger.getLogger(this.getClass());
	
	@Resource
	private IUserService userServiceImpl;
	
	/**
	 * 修改
	 * @param user
	 * @param id
	 * @return
	 */
	@RequestMapping(value="/{id}",method=RequestMethod.PUT)
	public String updateUserInfo(UserBean user,@PathVariable("id")Long id){
		logger.info(user);
		logger.info(id);
		try {
			user.setId(id);
			userServiceImpl.updateUserInfo(user);
		} catch (Exception e) {
			// TODO: handle exception
			logger.error("UserFormController----------updateUserInfo()",e);
		}
		logger.info("/layout/main");
		return "/layout/main";
	}
	
	
	/**
	 * 根据ID删除资源
	 * @param id
	 * @return
	 */
	@RequestMapping(value="/{id}",method=RequestMethod.DELETE)
	public String deleteUserInfo(@PathVariable("id")Long id){
		logger.info(id);
		
		try {
			userServiceImpl.deleteUserInfo(id);
		} catch (Exception e) {
			// TODO: handle exception
			logger.error("UserFormController----------deleteUserInfo()",e);
		}
		
		logger.info("/layout/main");
		return "/layout/main";
	}
	
	
	
	
	
	
	
	
}

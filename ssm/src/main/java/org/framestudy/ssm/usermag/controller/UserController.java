package org.framestudy.ssm.usermag.controller;

import javax.annotation.Resource;

import org.framestudy.ssm.pojos.Messager;
import org.framestudy.ssm.usermag.beans.UserBean;
import org.framestudy.ssm.usermag.service.IUserService;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/users")
@RestController
//将所有方法的执行结果放入到响应体中，并且将该组件交给spring容器
public class UserController {

	@Resource
	private IUserService userServiceImpl;
	
	@RequestMapping(value="/user",method=RequestMethod.POST,produces={"application/json;charset=utf-8"})
	public Messager saveUserInfo(@RequestBody UserBean user){
		
		Messager msg = new Messager(true,"操作成功！");
		try {
			userServiceImpl.saveUserInfo(user);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			msg.setStatus(false);
			msg.setMsg("系统繁忙，请稍后重试！");
		}
		return msg;
	}
}

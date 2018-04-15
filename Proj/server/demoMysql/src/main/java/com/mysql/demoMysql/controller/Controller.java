package com.mysql.demoMysql.controller;

import static com.mysql.demoMysql.controller.ControllerUrl.BASE_URL;
import static com.mysql.demoMysql.controller.ControllerUrl.ADD_USER;
import static com.mysql.demoMysql.controller.ControllerUrl.LIST_USER;
import static com.mysql.demoMysql.controller.ControllerUrl.DELETE;
import static com.mysql.demoMysql.controller.ControllerUrl.LOAD_BY_ID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.mysql.demoMysql.model.RequestVO;
import com.mysql.demoMysql.model.ResponseVO;
import com.mysql.demoMysql.model.User;
import com.mysql.demoMysql.service.UserService;

@RestController
@RequestMapping(BASE_URL)
public class Controller {

	@Autowired
	UserService userService;

	@RequestMapping(value = ADD_USER, method = RequestMethod.POST)
	public ResponseVO<User> saveUser(@RequestBody RequestVO<User> requestVO) throws Exception {
		ResponseVO<User> responseVO = new ResponseVO<>();
		responseVO.setValueObject(userService.saveUser(requestVO.getValueObject()));
		responseVO.setStatusCode("A200");
		responseVO.setStatusDescription("OK");
		return responseVO;
	}
	
	@RequestMapping(value = LIST_USER, method = RequestMethod.POST)
	public ResponseVO<User> listUserList() throws Exception {
		ResponseVO<User> responseVO = new ResponseVO<>();
		responseVO.setData(userService.getUserList());
		responseVO.setStatusCode("A200");
		responseVO.setStatusDescription("OK");
		return responseVO;
	}
	
	@RequestMapping(value = LOAD_BY_ID, method = RequestMethod.POST)
	public ResponseVO<User> loadUserById(@RequestBody RequestVO<String> requestVO) throws Exception {
		ResponseVO<User> responseVO = new ResponseVO<>();
		responseVO.setValueObject(userService.getUserById(requestVO.getValueObject()));
		responseVO.setStatusCode("A200");
		responseVO.setStatusDescription("OK");
		return responseVO;
	}
	
	@RequestMapping(value = DELETE, method = RequestMethod.POST)
	public ResponseVO<User> delete(@RequestBody RequestVO<String> requestVO) throws Exception {
		userService.deleteUserById(requestVO.getValueObject());

		ResponseVO<User> responseVO = new ResponseVO<>();
		responseVO.setStatusCode("A200");
		responseVO.setStatusDescription("OK");
		return responseVO;
	}
	
}

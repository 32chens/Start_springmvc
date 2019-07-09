package com.ssm.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.ssm.pojo.Orders;
import com.ssm.pojo.User;
import com.ssm.pojo.UserVO;
@Controller
@RequestMapping("/user")
public class UserController {
	
	/*简单数据绑定*/
	
	//绑定简单数据类型
	@RequestMapping("/selectUser")
	public String selectUser(@RequestParam(value="user_id")Integer id) {
		//String id =request.getParameter("id");
		System.out.println("id="+id);
		return "/seccess";
	}
	//跳转注册页面
	@RequestMapping("toRegister")
	public String toRegister() {
		return "register";
	}
	//查询注册信息，绑定POJO类型
	@RequestMapping("/registerUser")
	public String registerUser(User user) {
		String username=user.getUsername();
		Integer password=user.getPassword();
		System.out.println("username="+username);
		System.out.println("password="+password);
		return "seccess";
	}
	//查询用户订单，绑定包装POJO
	@RequestMapping("/findOrdersWithUser")
	public String findOrdersWithUser(Orders orders) {
		 Integer orderId = orders.getOrdersId();
		 User user = orders.getUser();
		 String username = user.getUsername();
		 System.out.println("orderId="+orderId);
		 System.out.println("username="+username);
		 return "seccess";
	}
	//跳转订单页面
	@RequestMapping("/toOrders")
	public String toOrders() {
		return "orders";
	}
	
	/*复杂数据绑定*/
	
	//跳转用户列表
	@RequestMapping("/toUser")
	public String toUser() {
		return "user";
	}
	//实现用户批量删除，绑定数组
	@RequestMapping("/deleteUsers")
    public String deleteUsers(Integer[] ids) {
         if(ids !=null){
                for (Integer id : ids) {
                	System.out.println("删除了id为"+id+"的用户！");
                	}	
          }else{
        	  System.out.println("ids=null");
        	  }
                return "seccess";
    }
	
	//跳转批量修改
	@RequestMapping("/toEdit")
	public String toEdit() {
		return "user_edit";
	}
	//实现用户批量修改，绑定集合
	@RequestMapping("/editUsers")
    public String editUsers(UserVO userList) {
		//不能写成List<User> userlist框架不支持直接使用集合形参，只能用一个包装类
           List<User> users = userList.getUsers();
           for (User user : users) {
                if(user.getId() !=null){ 
               System.out.println("修改了id为"+user.getId()+"的用户名为："+user.getUsername());
                }
           }
            return "seccess";
    }


}

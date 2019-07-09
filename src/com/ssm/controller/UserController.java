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
	
	/*�����ݰ�*/
	
	//�󶨼���������
	@RequestMapping("/selectUser")
	public String selectUser(@RequestParam(value="user_id")Integer id) {
		//String id =request.getParameter("id");
		System.out.println("id="+id);
		return "/seccess";
	}
	//��תע��ҳ��
	@RequestMapping("toRegister")
	public String toRegister() {
		return "register";
	}
	//��ѯע����Ϣ����POJO����
	@RequestMapping("/registerUser")
	public String registerUser(User user) {
		String username=user.getUsername();
		Integer password=user.getPassword();
		System.out.println("username="+username);
		System.out.println("password="+password);
		return "seccess";
	}
	//��ѯ�û��������󶨰�װPOJO
	@RequestMapping("/findOrdersWithUser")
	public String findOrdersWithUser(Orders orders) {
		 Integer orderId = orders.getOrdersId();
		 User user = orders.getUser();
		 String username = user.getUsername();
		 System.out.println("orderId="+orderId);
		 System.out.println("username="+username);
		 return "seccess";
	}
	//��ת����ҳ��
	@RequestMapping("/toOrders")
	public String toOrders() {
		return "orders";
	}
	
	/*�������ݰ�*/
	
	//��ת�û��б�
	@RequestMapping("/toUser")
	public String toUser() {
		return "user";
	}
	//ʵ���û�����ɾ����������
	@RequestMapping("/deleteUsers")
    public String deleteUsers(Integer[] ids) {
         if(ids !=null){
                for (Integer id : ids) {
                	System.out.println("ɾ����idΪ"+id+"���û���");
                	}	
          }else{
        	  System.out.println("ids=null");
        	  }
                return "seccess";
    }
	
	//��ת�����޸�
	@RequestMapping("/toEdit")
	public String toEdit() {
		return "user_edit";
	}
	//ʵ���û������޸ģ��󶨼���
	@RequestMapping("/editUsers")
    public String editUsers(UserVO userList) {
		//����д��List<User> userlist��ܲ�֧��ֱ��ʹ�ü����βΣ�ֻ����һ����װ��
           List<User> users = userList.getUsers();
           for (User user : users) {
                if(user.getId() !=null){ 
               System.out.println("�޸���idΪ"+user.getId()+"���û���Ϊ��"+user.getUsername());
                }
           }
            return "seccess";
    }


}

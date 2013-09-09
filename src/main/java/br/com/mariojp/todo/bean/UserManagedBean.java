package br.com.mariojp.todo.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;

import org.springframework.dao.DataAccessException;

import br.com.mariojp.todo.model.User;
import br.com.mariojp.todo.service.IUserService;

/**
 * 
 * @author mariojp
 *
 */
@ManagedBean(name="userMB")
@RequestScoped
public class UserManagedBean implements Serializable {
	
	private static final long serialVersionUID = 1L;
	private static final String ERROR   = "error";
	
	//Spring User Service is injected...
	@ManagedProperty(value="#{UserService}")
	IUserService userService;
	
	List<User> userList;
	
	private int id;
	private String name;
	private String senha;
	
	
	
	
	public String login() {
		try {
			//Consulta no banco 
			//if(getUserService().getUserByUsuarioSenha(name,senha)){
			 if(name.equals(senha)){
				 User user = new User();
				 user.setName(name);
				 user.setSenha(senha);
				 getUserService().addUser(user);
			      ExternalContext externalContext = FacesContext.getCurrentInstance().getExternalContext();
			      Map<String, Object> sessionMap = externalContext.getSessionMap();
			      sessionMap.put("User",user);
				 return "tarefa";
			 }
		} catch (DataAccessException e) {
			e.printStackTrace();
		} 	
		return ERROR;
	}
	

	
	/**
	 * Reset Fields
	 * 
	 */
	public void reset() {
		this.setId(0);
		this.setName("");
		this.setSenha("");
	}
	
	/**
	 * Get User List
	 * 
	 * @return List - User List
	 */
	public List<User> getUserList() {
		userList = new ArrayList<User>();
		userList.addAll(getUserService().getUsers());
		return userList;
	}
	
	/**
	 * Get User Service
	 * 
	 * @return IUserService - User Service
	 */
	public IUserService getUserService() {
		return userService;
	}

	/**
	 * Set User Service
	 * 
	 * @param IUserService - User Service
	 */
	public void setUserService(IUserService userService) {
		this.userService = userService;
	}
	
	/**
	 * Set User List
	 * 
	 * @param List - User List
	 */
	public void setUserList(List<User> userList) {
		this.userList = userList;
	}
	
	/**
	 * Get User Id
	 * 
	 * @return int - User Id
	 */
	public int getId() {
		return id;
	}

	/**
	 * Set User Id
	 * 
	 * @param int - User Id
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * Get User Name
	 * 
	 * @return String - User Name
	 */
	public String getName() {
		return name;
	}
	
	/**
	 * Set User Name
	 * 
	 * @param String - User Name
	 */
	public void setName(String name) {
		this.name = name;
	}
	

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}
	
}
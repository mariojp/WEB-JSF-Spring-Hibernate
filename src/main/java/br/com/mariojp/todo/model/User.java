package br.com.mariojp.todo.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;


/**
 * 
 * User Entity
 * 
 * @author onlinetechvision.com
 * @since 25 Mar 2012
 * @version 1.0.0
 *
 */
@Entity
@Table(name="USER")
public class User implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="ID", nullable = false)
	private int id;
	@Column(name="NAME", unique = true, nullable = false)
	private String name;
	@Column(name="SENHA", unique = false, nullable = true)
	private String senha;
	@OneToMany(targetEntity=Tarefa.class, fetch = FetchType.LAZY, mappedBy = "user")
	private List<Tarefa> tarefa = new ArrayList<Tarefa>();
	
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
	
	/**
	 * Get User Senha
	 * 
	 * @return String - User Senha
	 */
	public String getSenha() {
		return senha;
	}
	

	public List<Tarefa> getTarefa() {
		return tarefa;
	}

	
	public void setTarefa(List<Tarefa> tarefa) {
		this.tarefa = tarefa;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}	
	

}

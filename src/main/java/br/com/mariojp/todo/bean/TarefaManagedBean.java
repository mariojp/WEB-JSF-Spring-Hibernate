package br.com.mariojp.todo.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

import org.springframework.dao.DataAccessException;

import br.com.mariojp.todo.model.Tarefa;
import br.com.mariojp.todo.model.User;
import br.com.mariojp.todo.service.ITarefaService;

@ManagedBean(name="tarefaMB")
@RequestScoped
public class TarefaManagedBean implements Serializable {

	private static final long serialVersionUID = 1L;
	
	
	@ManagedProperty(value="#{TarefaService}")
	ITarefaService tarefaService;
	
	List<Tarefa> tarefaList;
	
	private int id;
	private String titulo;
	private String descricao;
	

	public ITarefaService getTarefaService() {
		return tarefaService;
	}

	public void setTarefaService(ITarefaService tarefaService) {
		this.tarefaService = tarefaService;
	}

	public List<Tarefa> getTarefaList() {
		tarefaList = new ArrayList<Tarefa>();
		tarefaList.addAll(getTarefaService().getTarefas());
		return tarefaList;
	}

	public void setTarefaList(List<Tarefa> tarefaList) {
		this.tarefaList = tarefaList;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
	
	public void addTarefa() {
		try {
			Tarefa tarefa = new Tarefa();
			tarefa.setUser( (User) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("User"));
			tarefa.setId(getId());
			tarefa.setTitulo(getTitulo());
			tarefa.setDescricao(getDescricao());
			getTarefaService().addTarefa(tarefa);
			tarefa = new Tarefa();
		} catch (DataAccessException e) {
			e.printStackTrace();
		} 	
	}
	
	
}

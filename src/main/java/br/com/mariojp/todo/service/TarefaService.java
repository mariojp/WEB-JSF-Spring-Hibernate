package br.com.mariojp.todo.service;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import br.com.mariojp.todo.dao.ITarefaDAO;
import br.com.mariojp.todo.model.Tarefa;

@Transactional(readOnly = true)
public class TarefaService implements ITarefaService {

	ITarefaDAO tarefaDAO;
	
	
	/* (non-Javadoc)
	 * @see br.com.mariojp.todo.service.ITarefaService#addTarefa(br.com.mariojp.todo.model.Tarefa)
	 */
	@Transactional(readOnly = false)
	public void addTarefa(Tarefa tarefa) {
		getTarefaDAO().addTarefa(tarefa);
	}

	/* (non-Javadoc)
	 * @see br.com.mariojp.todo.service.ITarefaService#deleteTarefa(br.com.mariojp.todo.model.Tarefa)
	 */
	@Transactional(readOnly = false)
	public void deleteTarefa(Tarefa tarefa) {
		getTarefaDAO().deleteTarefa(tarefa);
	}
	
	/* (non-Javadoc)
	 * @see br.com.mariojp.todo.service.ITarefaService#updateTarefa(br.com.mariojp.todo.model.Tarefa)
	 */
	@Transactional(readOnly = false)
	public void updateTarefa(Tarefa tarefa) {
		getTarefaDAO().updateTarefa(tarefa);
	}
	
	/* (non-Javadoc)
	 * @see br.com.mariojp.todo.service.ITarefaService#getTarefaById(int)
	 */
	public Tarefa getTarefaById(int id) {
		return getTarefaDAO().getTarefaById(id);
	}

	/* (non-Javadoc)
	 * @see br.com.mariojp.todo.service.ITarefaService#getTarefas()
	 */
	public List<Tarefa> getTarefas() {	
		return getTarefaDAO().getTarefas();
	}

	
	public ITarefaDAO getTarefaDAO() {
		return tarefaDAO;
	}

	public void setTarefaDAO(ITarefaDAO tarefaDAO) {
		this.tarefaDAO = tarefaDAO;
	}


}

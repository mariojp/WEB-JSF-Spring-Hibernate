package br.com.mariojp.todo.dao;

import java.util.List;

import org.hibernate.SessionFactory;

import br.com.mariojp.todo.model.Tarefa;


public class TarefaDAO implements ITarefaDAO {
	
	
	private SessionFactory sessionFactory;

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}
	
	public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
	
	/* (non-Javadoc)
	 * @see br.com.mariojp.todo.dao.ITarefaDAO#addTarefa(br.com.mariojp.todo.model.Tarefa)
	 */
	public void addTarefa(Tarefa tarefa) {
		getSessionFactory().getCurrentSession().save(tarefa);
	}


	/* (non-Javadoc)
	 * @see br.com.mariojp.todo.dao.ITarefaDAO#deleteTarefa(br.com.mariojp.todo.model.Tarefa)
	 */
	public void deleteTarefa(Tarefa tarefa) {
		getSessionFactory().getCurrentSession().delete(tarefa);
	}

	
	/* (non-Javadoc)
	 * @see br.com.mariojp.todo.dao.ITarefaDAO#updateTarefa(br.com.mariojp.todo.model.Tarefa)
	 */
	public void updateTarefa(Tarefa tarefa) {
		getSessionFactory().getCurrentSession().update(tarefa);
	}


	/* (non-Javadoc)
	 * @see br.com.mariojp.todo.dao.ITarefaDAO#getTarefaById(int)
	 */
	public Tarefa getTarefaById(int id) {
		List<Tarefa> list = getSessionFactory().getCurrentSession()
											.createQuery("from Tarefa where id=?")
									        .setParameter(0, id).list();
		return list.get(0);
	}


	/* (non-Javadoc)
	 * @see br.com.mariojp.todo.dao.ITarefaDAO#getTarefas()
	 */
	public List<Tarefa> getTarefas() {
		List<Tarefa> list = getSessionFactory().getCurrentSession().createQuery("from Tarefa").list();
		return list;
	}

}

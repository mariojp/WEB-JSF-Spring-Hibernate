package br.com.mariojp.todo.dao;

import java.util.List;

import br.com.mariojp.todo.model.Tarefa;

public interface ITarefaDAO {

	public abstract void addTarefa(Tarefa tarefa);

	public abstract void deleteTarefa(Tarefa tarefa);

	public abstract void updateTarefa(Tarefa tarefa);

	public abstract Tarefa getTarefaById(int id);

	public abstract List<Tarefa> getTarefas();

}
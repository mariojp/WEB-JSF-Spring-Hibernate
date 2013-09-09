package br.com.mariojp.todo.service;

import java.io.Serializable;
import java.util.List;

import br.com.mariojp.todo.model.Tarefa;

public interface ITarefaService extends Serializable{

	public abstract void addTarefa(Tarefa tarefa);

	public abstract void deleteTarefa(Tarefa tarefa);

	public abstract void updateTarefa(Tarefa tarefa);

	public abstract Tarefa getTarefaById(int id);

	public abstract List<Tarefa> getTarefas();

}
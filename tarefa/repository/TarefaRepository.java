package com.tarefa.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tarefa.entities.Tarefa;

public interface TarefaRepository  extends JpaRepository<Tarefa, Long>{

}


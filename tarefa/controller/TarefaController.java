package com.tarefa.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tarefa.entities.Tarefa;
import com.tarefa.service.TarefaService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/tarefa")
public class TarefaController {
	private final TarefaService tarefaService;




	@Autowired
	public TarefaController(TarefaService tarefaService) {
		this.tarefaService = tarefaService;
	}

	@GetMapping("/{id}")
	public ResponseEntity<Tarefa> gettarefaById(@PathVariable Long id) {
		Tarefa tarefa = tarefaService.getTarefaById(id);
		if (tarefa != null) {
			return ResponseEntity.ok(tarefa);
		} else {
			return ResponseEntity.notFound().build();
		}
	}

	@GetMapping("/")
	public ResponseEntity<List<Tarefa>> getAllTarefa() {
		List<Tarefa> tarefa = tarefaService.getAllTarefa();
		return ResponseEntity.ok(tarefa);
	}

	@PostMapping("/")
	public ResponseEntity<Tarefa> criarTarefa(@RequestBody @Valid Tarefa tarefa) {
		Tarefa criarTarefa = tarefaService.salvarTarefa(tarefa);
		return ResponseEntity.status(HttpStatus.CREATED).body(criarTarefa);
	}


	@PutMapping("/{id}")
	public ResponseEntity<Tarefa> updateTarefa(@PathVariable Long id, @RequestBody @Valid Tarefa tarefa) {
		Tarefa updatedTarefa = tarefaService.updatetarefa(id, tarefa);
		if (updatedTarefa != null) {
			return ResponseEntity.ok(updatedTarefa);
		} else {
			return ResponseEntity.notFound().build();
		}
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<String> deleteTarefa(@PathVariable Long id) {
		boolean deleted = tarefaService.deleteTarefa(id);
		if (deleted) {
			return ResponseEntity.ok().body("a Tarefa foi excluída com sucessa.");
		} else {
			return ResponseEntity.notFound().build();
		}
	}


}


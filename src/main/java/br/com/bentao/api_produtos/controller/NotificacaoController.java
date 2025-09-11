package br.com.bentao.api_produtos.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.bentao.api_produtos.model.Calendario;
import br.com.bentao.api_produtos.repository.CalendarioRepository;

@RestController
@RequestMapping("/Calendario")
public class CalendarioController {

    private final CalendarioRepository repository;

    public CalendarioController(CalendarioRepository repository) {
        this.repository = repository;
    }

    @PostMapping
    public Calendario criar(@RequestBody Calendario calendario) {
        return repository.save(calendario);
    }

    @GetMapping
    public List<Calendario> listar() {
        return repository.findAll();
    }

    @GetMapping("/{id}")
    public Calendario buscar(@PathVariable Long id) {
        return repository.findById(id).orElse(null);
    }

    @PutMapping("/{id}")
    public Calendario atualizar(@PathVariable Long id, @RequestBody Calendario novoCalendario) {
        return repository.findById(id).map(calendario -> {
            calendario.setNome(novoCalendario.getNome());
            calendario.setPreco(novoCalendario.getPreco());
            return repository.save(calendario);
        }).orElse(null);
    }

    @DeleteMapping("/{id}")
    public void excluir(@PathVariable Long id) {
        repository.deleteById(id);
    }

}



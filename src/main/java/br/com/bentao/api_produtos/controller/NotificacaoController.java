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

import br.com.bentao.api_produtos.model.Notificacao;
import br.com.bentao.api_produtos.repository.NotificacaoRepository;

@RestController
@RequestMapping("/notificacoes")
public class NotificacaoController {
    private final NotificacaoRepository repository;

    public NotificacaoController(NotificacaoRepository repository) {
        this.repository = repository;
    }

    @PostMapping
    public Notificacao criar(@RequestBody Notificacao notificacao) {
        return repository.save(notificacao);
    }

    @GetMapping
    public List<Notificacao> listar() {
        return repository.findAll();
    }

    @GetMapping("/{id}")
    public Notificacao buscar(@PathVariable Long id) {
        return repository.findById(id).orElse(null);
    }

    @PutMapping("/{id}")
    public Notificacao atualizar(@PathVariable Long id, @RequestBody Notificacao novaNotificacao) {
        return repository.findById(id).map(notificacao -> {
            notificacao.setTitulo(novaNotificacao.getTitulo());
            notificacao.setMensagem(novaNotificacao.getMensagem());
            notificacao.setHora(novaNotificacao.getHora());
            notificacao.setLido(novaNotificacao.getLido());
            notificacao.setUsuarioCalendario(novaNotificacao.getUsuarioCalendario());
            notificacao.setUsuario(novaNotificacao.getUsuario());
            return repository.save(notificacao);
        }).orElse(null);
    }

    @DeleteMapping("/{id}")
    public void excluir(@PathVariable Long id) {
        repository.deleteById(id);
    }
}



package br.com.bentao.api_produtos.model;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Notificacao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idNotificacao; // lowercase

    private String titulo;
    private String mensagem;
    private LocalDateTime hora;
    private Boolean lido;

    @ManyToOne
    @JoinColumn(name = "ID_Calendario")
    private Calendario usuarioCalendario;

    @ManyToOne
    @JoinColumn(name = "ID_Usuario")
    private Usuario usuario;

    public Notificacao() {}

    public Notificacao(String titulo, String mensagem, LocalDateTime hora, Boolean lido, Calendario usuarioCalendario, Usuario usuario) {
        this.titulo = titulo;
        this.mensagem = mensagem;
        this.hora = hora;
        this.lido = lido;
        this.usuarioCalendario = usuarioCalendario;
        this.usuario = usuario;
    }

    // Getters and Setters
    public Long getIdNotificacao() {
        return idNotificacao;
    }

    public void setIdNotificacao(Long idNotificacao) {
        this.idNotificacao = idNotificacao;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getMensagem() {
        return mensagem;
    }

    public void setMensagem(String mensagem) {
        this.mensagem = mensagem;
    }

    public LocalDateTime getHora() {
        return hora;
    }

    public void setHora(LocalDateTime hora) {
        this.hora = hora;
    }

    public Boolean getLido() {
        return lido;
    }

    public void setLido(Boolean lido) {
        this.lido = lido;
    }

    public Calendario getUsuarioCalendario() {
        return usuarioCalendario;
    }

    public void setUsuarioCalendario(Calendario usuarioCalendario) {
        this.usuarioCalendario = usuarioCalendario;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
}

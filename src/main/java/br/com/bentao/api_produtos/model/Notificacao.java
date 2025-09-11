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
    private Long ID_Notificacao;
    
    private String Titulo;
    private String Mensagem;
    private LocalDateTime Hora;
    private Boolean Lido;
    @ManyToOne
    @JoinColumn(name = "ID_Calendario") 
    private Calendario usuario_ID_Calendario;
    @ManyToOne
    @JoinColumn(name = "ID_Usuario") 
    private Usuario ID_Usuario;

    public Notificacao() {}

    public Notificacao(String Titulo, String Mensagem, LocalDateTime Hora, Boolean Lido, Calendario usuario_ID_Calendario, Usuario ID_Usuario) {
        this.Titulo = Titulo;
        this.Mensagem = Mensagem;
        this.Hora = Hora;
        this.Lido = Lido;
        this.usuario_ID_Calendario = usuario_ID_Calendario;
        this.ID_Usuario = ID_Usuario;
    }


    // Getters e Setters
    public Long getID_Notificacao() {
        return ID_Notificacao;
    }

    public void setID_Notificacao(Long ID_Notificacao) {
        this.ID_Notificacao = ID_Notificacao;
    }

    public String getTitulo() {
        return Titulo;
    }

    public void setTitulo(String Titulo) {
        this.Titulo = Titulo;
    }

    public String getMensagem() {
        return Mensagem;
    }

    public void setMensagem(String Mensagem) {
        this.Mensagem = Mensagem;
    }

    public LocalDateTime getHora() {
        return Hora;
    }

    public void setHora(LocalDateTime Hora) {
        this.Hora = Hora;
    }

    public Boolean getLido() {
        return Lido;
    }

    public void setLido(Boolean Lido) {
        this.Lido = Lido;
    }

    public Calendario getUsuario_ID_Calendario() {
        return usuario_ID_Calendario;
    }

    public void setUsuario_ID_Calendario(Calendario usuario_ID_Calendario) {
        this.usuario_ID_Calendario = usuario_ID_Calendario;
    }

    public Usuario getID_Usuario() {
        return ID_Usuario;
    }

    public void setID_Usuario(Usuario ID_Usuario) {
        this.ID_Usuario = ID_Usuario;
    }
}

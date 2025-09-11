package br.com.bentao.api_produtos.repository;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.bentao.api_produtos.model.Notificacao;

public interface NotificacaoRepository extends JpaRepository<Notificacao, Long> {
    List<Notificacao> findByTitulo(String titulo);
    List<Notificacao> findByTituloContaining(String parteDoTitulo);
    List<Notificacao> findByLido(Boolean lido);
    List<Notificacao> findByUsuario_ID_Calendario_Id(Long calendarioId);
    List<Notificacao> findByID_Usuario_Id(Long usuarioId);
    List<Notificacao> findByHoraBetween(LocalDateTime start, LocalDateTime end);
}

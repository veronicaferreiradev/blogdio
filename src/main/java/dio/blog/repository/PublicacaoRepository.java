package dio.blog.repository;

import dio.blog.model.Publicacao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PublicacaoRepository extends JpaRepository<Publicacao, Long> {
    boolean existsByTitulo(String titulo);

}

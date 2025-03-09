package dio.blog.service;

import dio.blog.model.Publicacao;

public interface PublicacaoService {

    Publicacao findById(Long id);

    Publicacao create(Publicacao publicacao);

}

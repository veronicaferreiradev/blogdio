package dio.blog.service.impl;

import dio.blog.model.Publicacao;
import dio.blog.repository.PublicacaoRepository;
import dio.blog.service.PublicacaoService;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
public class PublicacaoServiceImpl implements PublicacaoService {

    private final PublicacaoRepository publicacaoRepository;

    public PublicacaoServiceImpl(PublicacaoRepository publicacaoRepository) {
        this.publicacaoRepository = publicacaoRepository;
    }

    @Override
    public Publicacao findById(Long id) {
        return publicacaoRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Publicação não encontrada com o ID: " + id));
    }

    @Override
    public Publicacao create(Publicacao publicacao) {
        if (publicacao.getId() != null) {
            throw new IllegalArgumentException("O ID não deve ser fornecido. Ele será gerado automaticamente.");
        }
        if (publicacaoRepository.existsByTitulo(publicacao.getTitulo())) {
            throw new IllegalArgumentException("Já existe uma publicação com este título.");
        }
        return publicacaoRepository.save(publicacao);
    }
}


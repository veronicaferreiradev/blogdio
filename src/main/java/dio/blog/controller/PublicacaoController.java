package dio.blog.controller;

import dio.blog.model.Publicacao;
import dio.blog.service.PublicacaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("/publicacao")
public class PublicacaoController {

    @Autowired
    private final PublicacaoService publicacaoService;

    public PublicacaoController(PublicacaoService publicacaoService) {
        this.publicacaoService = publicacaoService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Publicacao> findById(@PathVariable Long id){
        var publicacao = publicacaoService.findById(id);
        return ResponseEntity.ok(publicacao);
    }

    @PostMapping
    public ResponseEntity<Publicacao> create(@RequestBody Publicacao publicacao) {
        var savedPublicacao = publicacaoService.create(publicacao);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(savedPublicacao.getId())
                .toUri();
        return ResponseEntity.created(location).body(savedPublicacao);
    }
}

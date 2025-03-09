package dio.blog.model;

import jakarta.persistence.*;

import java.util.List;

@Entity(name = "tb_tema")
public class Tema {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String descricao;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Publicacao> publicacao;


    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<Publicacao> getPublicacao() {
        return publicacao;
    }

    public void setPublicacao(List<Publicacao> publicacao) {
        this.publicacao = publicacao;
    }

    public Tema(String descricao, Long id, List<Publicacao> publicacao) {
        this.descricao = descricao;
        this.id = id;
        this.publicacao = publicacao;
    }

    public Tema() {
    }
}

package comunica_ajuda.comunica_ajuda.entities;

import comunica_ajuda.comunica_ajuda.service.CategoriaService;
import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "relatos")
public class Relatos
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "titulo")
    private String titulo;

    @Column(name = "descricao")
    private String descricao;

    @Column(name = "urgencia")
    private int urgencia;

    @ManyToOne
    @JoinColumn(name = "categoria_id", nullable = false)
    private Categoria categoria;

    @Column(name = "localizacao")
    private String localizacao;

    @Column(name = "status")
    private String status;

    @Column(name = "notas_admin")
    private String notasAdmin;

    @Column(name = "criado_em")
    private LocalDate criadoEm;

    public Relatos(Long id, String titulo, String descricao, int urgencia, Categoria categoria, String localizacao, String status, String notasAdmin, LocalDate criadoEm)
    {
        this.id = id;
        this.titulo = titulo;
        this.descricao = descricao;
        this.urgencia = urgencia;
        this.categoria = categoria;
        this.localizacao = localizacao;
        this.status = status;
        this.notasAdmin = notasAdmin;
        this.criadoEm = criadoEm;
    }

    public Relatos()
    {
        this(0L,"","",0,null,"","","",null);
    }

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescricao() {
        return descricao;
    }
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public int getUrgencia() {
        return urgencia;
    }
    public void setUrgencia(int urgencia) {
        this.urgencia = urgencia;
    }

    public Categoria getCategoria() {
        return categoria;
    }
    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public String getLocalizacao() {
        return localizacao;
    }
    public void setLocalizacao(String localizacao) {
        this.localizacao = localizacao;
    }

    public String getStatus() {
        return status;
    }
    public void setStatus(String status) {
        this.status = status;
    }

    public String getNotasAdmin() {
        return notasAdmin;
    }
    public void setNotasAdmin(String notasAdmin) {
        this.notasAdmin = notasAdmin;
    }

    public LocalDate getCriadoEm() {
        return criadoEm;
    }
    public void setCriadoEm(LocalDate criadoEm) {
        this.criadoEm = criadoEm;
    }
}
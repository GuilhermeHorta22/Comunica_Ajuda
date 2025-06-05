package comunica_ajuda.comunica_ajuda.entities;


import jakarta.persistence.*;

@Entity
@Table(name = "categorias")
public class Categoria
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "nome")
    private String nome;

    public Categoria(Long id, String nome)
    {
        this.id = id;
        this.nome = nome;
    }

    public Categoria()
    {
        this(0L,"");
    }

    public Long getId()
    {
        return id;
    }
    public void setId(Long id)
    {
        this.id = id;
    }

    public String getNome()
    {
        return nome;
    }
    public void setNome(String nome)
    {
        this.nome = nome;
    }
}

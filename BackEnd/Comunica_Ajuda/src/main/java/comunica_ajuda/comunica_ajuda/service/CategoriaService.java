package comunica_ajuda.comunica_ajuda.service;

import comunica_ajuda.comunica_ajuda.entities.Categoria;
import comunica_ajuda.comunica_ajuda.repository.CategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoriaService
{
    @Autowired
    private CategoriaRepository categoriaRepository;

    //retornar todos os dados cadastrado na categoria
    public List<Categoria> getAll()
    {
        return categoriaRepository.findAll();
    }

    //retorna apenas os dados da categoria passado o id
    public Optional<Categoria> getById(Long id)
    {
        return categoriaRepository.findById(id);
    }

    //salva a categoria passada para o backEnd
    public Categoria save(Categoria categoria)
    {
        return categoriaRepository.save(categoria);
    }

    //atualiza uma categoria passada para o backEnd
    public Categoria update(Categoria categoria)
    {
        if(categoriaRepository.existsById(categoria.getId())) //verifica se existe a categoria para ser atualizada
            return categoriaRepository.save(categoria);
        return null;
    }

    //deleta um usuario
    public Boolean delete(Long id)
    {
        if(categoriaRepository.existsById(id))
        {
            categoriaRepository.deleteById(id);
            return true;
        }
        return false;
    }
}

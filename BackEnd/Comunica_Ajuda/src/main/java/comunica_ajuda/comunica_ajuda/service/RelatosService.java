package comunica_ajuda.comunica_ajuda.service;

import comunica_ajuda.comunica_ajuda.entities.Relatos;
import comunica_ajuda.comunica_ajuda.repository.RelatosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RelatosService
{
    @Autowired
    private RelatosRepository relatosRepository;

    public List<Relatos> getAll()
    {
        return relatosRepository.findAll();
    }

    public Optional<Relatos> getById(Long id)
    {
        return relatosRepository.findById(id);
    }

    public Relatos save(Relatos relatos)
    {
        return relatosRepository.save(relatos);
    }

    public Relatos update(Relatos relatos)
    {
        if(relatosRepository.existsById(relatos.getId()))
            return relatosRepository.save(relatos);
        return null;
    }

    public Boolean delete(Long id)
    {
        if(relatosRepository.existsById(id))
        {
            relatosRepository.deleteById(id);
            return true;
        }
        return false;
    }
}

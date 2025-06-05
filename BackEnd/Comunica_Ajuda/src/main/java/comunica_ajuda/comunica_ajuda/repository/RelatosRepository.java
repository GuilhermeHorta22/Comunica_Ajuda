package comunica_ajuda.comunica_ajuda.repository;

import comunica_ajuda.comunica_ajuda.entities.Relatos;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RelatosRepository extends JpaRepository<Relatos, Long>
{

}

package comunica_ajuda.comunica_ajuda.repository;

import comunica_ajuda.comunica_ajuda.entities.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoriaRepository extends JpaRepository<Categoria, Long> {
}

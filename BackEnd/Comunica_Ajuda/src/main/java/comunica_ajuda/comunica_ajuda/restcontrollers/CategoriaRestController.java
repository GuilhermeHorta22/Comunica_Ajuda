package comunica_ajuda.comunica_ajuda.restcontrollers;

import comunica_ajuda.comunica_ajuda.entities.Categoria;
import comunica_ajuda.comunica_ajuda.repository.CategoriaRepository;
import comunica_ajuda.comunica_ajuda.service.CategoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("apis/categoria")
public class CategoriaRestController
{
    @Autowired
    private CategoriaService categoriaService;

    @GetMapping
    public ResponseEntity<Object> getCategoria()
    {
        List<Categoria> categoriaList = categoriaService.getAll();
        if(!categoriaList.isEmpty())
            return ResponseEntity.ok(categoriaList);
        return ResponseEntity.badRequest().body("Nenhuma categoria encontrada!");
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> getCategoriaById(@PathVariable Long id)
    {
        Categoria categoria = categoriaService.getById(id).orElse(null);
        if(categoria != null)
            return ResponseEntity.ok(categoria);
        return ResponseEntity.badRequest().body(String.format("Categoria com id: %d não foi encontrada",id));
    }

    @PostMapping
    public ResponseEntity<Object> addCategoria(@RequestBody Categoria categoria)
    {
        try
        {
            Categoria novaCategoria = categoriaService.save(categoria);
            return ResponseEntity.ok(novaCategoria);
        }
        catch(Exception e)
        {
            e.printStackTrace();
            return ResponseEntity.badRequest().body("Erro ao adicionar nova categoria");
        }
    }

    @PutMapping
    public ResponseEntity<Object> updateCategoria(@RequestBody Categoria categoria)
    {
        Categoria novaCategoria = null;
        try
        {
            novaCategoria = categoriaService.save(categoria);
            return ResponseEntity.ok(novaCategoria);
        }
        catch(Exception e)
        {
            e.printStackTrace();
            return ResponseEntity.badRequest().body("Erro ao atualizar categoria!");
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteCategoria(@PathVariable Long id)
    {
        Categoria categoria = categoriaService.getById(id).orElse(null);
        if(categoria != null)
        {
            categoriaService.delete(id);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.badRequest().body(String.format("Erro ao deletar categoria com id: %d",id));
    }
}

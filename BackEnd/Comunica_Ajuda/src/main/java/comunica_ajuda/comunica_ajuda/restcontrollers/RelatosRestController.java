package comunica_ajuda.comunica_ajuda.restcontrollers;

import comunica_ajuda.comunica_ajuda.entities.Relatos;
import comunica_ajuda.comunica_ajuda.service.RelatosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("apis/relatos")
@CrossOrigin(origins = "*")
public class RelatosRestController
{
    @Autowired
    private RelatosService relatosService;

    @GetMapping
    public ResponseEntity<Object> getRelatos()
    {
        List<Relatos> relatosList = relatosService.getAll();
        if(!relatosList.isEmpty())
            return ResponseEntity.ok(relatosList);
        return ResponseEntity.badRequest().body("Nenhum relato encontrado!");
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> getRelatosById(@PathVariable Long id)
    {
        Relatos relatos = relatosService.getById(id).orElse(null);
        if(relatos != null)
            return ResponseEntity.ok(relatos);
        return ResponseEntity.badRequest().body(String.format("Relato com id: %d não foi encontrado!",id));
    }

    @PostMapping
    public ResponseEntity<Object> addRelatos(@RequestBody Relatos relatos)
    {
        try
        {
            Relatos novoRelato = relatosService.save(relatos);
            return ResponseEntity.ok(novoRelato);
        }
        catch(Exception e)
        {
            e.printStackTrace();
            return ResponseEntity.badRequest().body("Erro ao adicionar novo relato!");
        }
    }

    @PutMapping
    public ResponseEntity<Object> updateRelatos(@RequestBody Relatos relatos)
    {
        Relatos novoRelato = null;
        try
        {
            novoRelato = relatosService.save(relatos);
            return ResponseEntity.ok(novoRelato);
        }
        catch(Exception e)
        {
            e.printStackTrace();
            return ResponseEntity.badRequest().body("Erro ao atualizar relato!");
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteRelato(@PathVariable Long id)
    {
        Relatos relatos = relatosService.getById(id).orElse(null);
        if(relatos != null)
        {
            relatosService.delete(id);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.badRequest().body(String.format("Erro ao deletar relato com id: %d",id));
    }
}

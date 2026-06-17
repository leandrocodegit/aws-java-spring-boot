package aws.demo.dynamo;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("")
public class DinamoController {

    private final ItemSimplesService itemSimplesService;

    public DinamoController(ItemSimplesService itemSimplesService) {
        this.itemSimplesService = itemSimplesService;
    }

    @GetMapping
    public ResponseEntity<?> lista(){
        return ResponseEntity.ok(itemSimplesService.listarTodos());
    }

    @PostMapping
    public ResponseEntity<?> salve(
            @RequestBody Pessoa pessoa
    ){
        itemSimplesService.salvar(pessoa);
        return ResponseEntity.ok(Map.of("status", "ok"));
    }
}

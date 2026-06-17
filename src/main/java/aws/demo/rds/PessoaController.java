package aws.demo.rds;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/pessoa")
public class PessoaController {

    private final PessoaRepository pessoaRepository;

    public PessoaController(PessoaRepository pessoaRepository) {
        this.pessoaRepository = pessoaRepository;
    }

    @GetMapping
    public ResponseEntity<?> list(){
        return ResponseEntity.ok(pessoaRepository.findAll());
    }

    @PostMapping
    public ResponseEntity<?> create(
            @RequestBody Pessoa pessoa
    ){
        pessoaRepository.save(pessoa);
        return ResponseEntity.ok().build();
    }
}

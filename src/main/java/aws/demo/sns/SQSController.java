package aws.demo.sns;

import aws.demo.rds.Pessoa;
import aws.demo.rds.PessoaRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/sqs")
public class SQSController {

    private final SqsProducer sqsProducer;

    public SQSController(SqsProducer sqsProducer) {
        this.sqsProducer = sqsProducer;
    }

    @PostMapping
    public ResponseEntity<?> create(
            @RequestBody Menssagem pessoa
    ){

        return ResponseEntity.ok().build();
    }
}

package aws.demo.sns;

import io.awspring.cloud.sqs.annotation.SqsListener;
import io.awspring.cloud.sqs.operations.SqsTemplate;
import org.springframework.stereotype.Service;

@Service
public class SqsProducer {

    private final SqsTemplate sqsTemplate;

    public SqsProducer(SqsTemplate sqsTemplate) {
        this.sqsTemplate = sqsTemplate;
    }

    public void enviar(String fila, Object mensagem) {
        sqsTemplate.send(fila, mensagem);
    }

    @SqsListener("fileira")
    public void receber(String mensagem) {
        System.out.println("Mensagem recebida: " + mensagem);
    }
}
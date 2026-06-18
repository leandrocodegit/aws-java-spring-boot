package aws.demo.sns;

import io.awspring.cloud.sqs.annotation.SqsListener;
import io.awspring.cloud.sqs.operations.SqsTemplate;
import org.springframework.stereotype.Service;

@Service
public class SqsProducer {



    @SqsListener("fileira")
    public void receber(String mensagem) {
        System.out.println("Mensagem recebida: " + mensagem);
    }
}
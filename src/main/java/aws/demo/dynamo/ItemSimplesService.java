package aws.demo.dynamo;

import org.springframework.stereotype.Service;
import software.amazon.awssdk.enhanced.dynamodb.DynamoDbEnhancedClient;
import software.amazon.awssdk.enhanced.dynamodb.DynamoDbTable;
import software.amazon.awssdk.enhanced.dynamodb.TableSchema;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ItemSimplesService {

    private final DynamoDbTable<Pessoa> tabela;

    public ItemSimplesService(DynamoDbEnhancedClient enhancedClient) {
        this.tabela = enhancedClient.table("banco-dinamico", TableSchema.fromBean(Pessoa.class));
    }

    public List<Pessoa> listarTodos() {
        return tabela.scan()
                .items()
                .stream()
                .collect(Collectors.toList());
    }

    public Pessoa salvar(Pessoa item) {
        tabela.putItem(item);
        return item;
    }
}
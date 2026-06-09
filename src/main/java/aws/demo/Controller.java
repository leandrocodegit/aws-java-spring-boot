package aws.demo;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/helth")
public class Controller {

    public ResponseEntity<?> heath(){
        return ResponseEntity.ok(Map.of("status", "ok"));
    }
}

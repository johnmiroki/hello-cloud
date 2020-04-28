package how.john.hello.cloud.consumer.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RefreshScope
public class PrintConfigController {

    @Value("${message:this is a local message}")
    private String configFromConfigServer;

    @GetMapping("message")
    public String messageOut(){
        return configFromConfigServer;
    }
}

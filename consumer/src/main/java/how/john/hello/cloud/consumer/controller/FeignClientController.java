package how.john.hello.cloud.consumer.controller;

import how.john.hello.cloud.consumer.client.ServiceProvider;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class FeignClientController {

    @Autowired
    private ServiceProvider serviceProvider;

    @Value("${spring.application.name}")
    private String myName;

    @RequestMapping("/callProvider")
    public Object query(){

        ResponseEntity responseEntity = serviceProvider.whoAmI(myName);


        log.info("received " + responseEntity);
        return responseEntity;
    }
}

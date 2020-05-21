package how.john.hello.cloud.serviceprovider.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
@Slf4j
public class ApiController {


    @RequestMapping("/whoami")
    public ResponseEntity whoAmI(@RequestParam("caller") String caller){

        log.info("whoAmI called by" + caller);
        return ResponseEntity.ok("Provider is being called by " + caller);
    }
}

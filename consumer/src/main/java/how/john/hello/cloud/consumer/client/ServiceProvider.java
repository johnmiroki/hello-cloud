package how.john.hello.cloud.consumer.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;



@FeignClient("service-provider")
public interface ServiceProvider {

    @RequestMapping("/api/whoami")
    // the generic type is a must, otherwise feign won't be able to decode
    public ResponseEntity<String> whoAmI(@RequestParam("caller") String caller);
}

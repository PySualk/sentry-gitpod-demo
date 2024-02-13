package org.sualk.sentrygitpoddemo;

import io.sentry.Sentry;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@Slf4j
class DemoController {

    @GetMapping("error")
    public void error() {
        log.info("GET /error");
        try {
          throw new Exception("This is a generic error.");
        } catch (Exception e) {
          Sentry.captureException(e);
        }
    }

    @GetMapping("data")
    public List<String> data() {
        log.info("GET /data");
        return List.of("apple", "banana", "orange");
    }
}
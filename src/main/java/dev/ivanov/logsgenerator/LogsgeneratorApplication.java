package dev.ivanov.logsgenerator;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.RoundingMode;
import java.util.UUID;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.MarkerFactory;
import org.slf4j.helpers.BasicMarker;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static net.logstash.logback.argument.StructuredArguments.*;

@SpringBootApplication
@Slf4j
@RestController
public class LogsgeneratorApplication implements CommandLineRunner {


  public static void main(String[] args) {
    SpringApplication.run(LogsgeneratorApplication.class, args);
  }

  @RequestMapping("/")
  public String home() {
    log.info("[{}] Hello3", value("RqUID", "234"));
    return "hello";
  }

  @Override
  public void run(String... args) throws Exception {
    for (int i = 0; i < 10_000; i++) {
      log.info("[{}] MSG: 12345", value("RqUID", UUID.randomUUID().toString()));
      Thread.sleep(1000);
    }
  }
}

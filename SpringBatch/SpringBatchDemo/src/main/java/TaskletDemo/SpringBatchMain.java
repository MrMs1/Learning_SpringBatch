package TaskletDemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class SpringBatchMain {
    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(SpringBatchMain.class, args);
        System.exit(SpringApplication.exit(context, () -> 0));
    }
}

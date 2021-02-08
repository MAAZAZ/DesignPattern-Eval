import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(value = {"dessin","entities","figure","observable","aspects"})
public class AppConfig {
}

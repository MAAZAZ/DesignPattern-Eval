import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(value = {"aspects","dessin","entities","figure","observable"})
public class AppConfig {
}

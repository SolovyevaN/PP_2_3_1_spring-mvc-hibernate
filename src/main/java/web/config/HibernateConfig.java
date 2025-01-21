
package web.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;


@Configuration
@ComponentScan("web")
@PropertySource(value = "classpath:db.properties")
public class HibernateConfig {


}


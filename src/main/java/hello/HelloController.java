package hello;

import java.util.concurrent.atomic.AtomicLong;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@RestController
public class HelloController
{
   private static final String template = "Hello, %s";
   private final AtomicLong counter = new AtomicLong();

   @RequestMapping("/")
   public String index()
   {
      return "Hello World";
   }

   @RequestMapping("/greeting")
   public Greeting greeting(@RequestParam(value="name", defaultValue="User") String name)
   {
      Greeting g = new Greeting();
      g.setId(counter.incrementAndGet());
      g.setContent(String.format(template,name));
      return g;
   }
}

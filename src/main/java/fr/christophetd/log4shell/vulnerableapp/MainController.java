package fr.christophetd.log4shell.vulnerableapp;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@RestController
public class MainController {

    private static final Logger logger = LogManager.getLogger("HelloWorld");
    @GetMapping("/nice_page")
    public String index(@RequestHeader("User-Agent") String user_agent) {
        logger.info("User-Agent = " + user_agent);
        return "Hello, Visitors!<BR><a href='/testParams?username=frank'>Click Here if your name is Frank</a>";
    }
    @GetMapping("/")
    public String index(@RequestHeader("X-Api-Version") String apiVersion) {
        logger.info("Received a request for API version " + apiVersion);
        return "Hello, world!<BR><a href='/testParams?username=frank'>Click Here</a>";
    }
    
    @GetMapping("/testParams")
    public String binder(@RequestParam("username") String username) {
        logger.info("Received a get request for username " + username);
        return "Hello, world 2.0!";
    }

}

package edu.my.service;

import edu.my.service.player.PlayerService;
import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import org.eclipse.microprofile.config.inject.ConfigProperty;

import java.io.File;
import java.util.Optional;

@Path("/hello")
public class GreetingResource {
    @Inject
    GreetingService service;

    @ConfigProperty(name = "greeting.message")
    String message;

    @ConfigProperty(name = "greeting.suffix", defaultValue = "!")
    String suffix;

    @ConfigProperty(name = "greeting.name")
    Optional<String> name;

    @ConfigProperty(name = "greeting.musictype")
    String musicType;

    @Inject
    PlayerService playerService;


    File folder = new File("src/main/resources/sounds/");



    @GET
    @Produces(MediaType.TEXT_PLAIN)
    @Path("/greeting/{name}")
    public String greeting(@PathParam("name") String name) {
        for (File file:folder.listFiles()) {
            if(file.getName().endsWith("mp3")) {
                playerService.returnMp3Player().playMusic(file.getName());
            }
        }

        return service.greeting(name);
    }

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String hello() {
        for (File file:folder.listFiles()) {
            if(file.getName().endsWith("wav")) {
               playerService.returnWavPlayer().playMusic(file.getName());
            }
        }

        return message + " " + name.orElse("world") + suffix;

    }

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    @Path("/greeting")
    public  String Greeting() {
        return "Greeting ";
    }


}

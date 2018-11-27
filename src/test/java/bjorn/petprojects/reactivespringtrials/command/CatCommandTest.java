package bjorn.petprojects.reactivespringtrials.command;

import bjorn.petprojects.reactivespringtrials.model.Cat;
import lombok.extern.slf4j.Slf4j;
import org.junit.Before;
import org.junit.Test;
import reactor.core.publisher.Mono;

import static org.junit.Assert.*;

@Slf4j
public class CatCommandTest {

    Cat chihiro = new Cat("Chihiro", "Exotic-Colourpoint");
    Cat jack = new Cat("Jack", "Exotic-Panda");
    Cat roger = new Cat("Roger", "Exotic-Panda");
    Cat whiskey = new Cat("Whiskey", "Exotic-Lapjeskat");


    @Test
    public void monoTest() {
        Mono<Cat> catMono = Mono.just(chihiro);

        Cat cat = catMono.block();

        log.info(cat.describeMe());
    }

    @Test
    public void monoTransform() {
        Mono<Cat> catMono = Mono.just(jack);

        CatCommand command = catMono
                .map(cat -> {
                    return new CatCommand(cat);
                }).block();

        log.info(command.describeMe());
    }

    @Test(expected = NullPointerException.class)
    public void monoFilter() throws Exception{
        Mono<Cat> catMono = Mono.just(roger);

        Cat rogerAxe = catMono
                .filter(cat -> cat.getName().equalsIgnoreCase("foo"))
                .block();
        log.info(rogerAxe.describeMe());
    }

    

}
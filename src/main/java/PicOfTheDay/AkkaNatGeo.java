package PicOfTheDay;

import akka.actor.AbstractActor;
import akka.actor.ActorRef;
import akka.actor.ActorSystem;
import akka.actor.Props;
import akka.event.Logging;
import akka.event.LoggingAdapter;
import akka.japi.pf.ReceiveBuilder;

public class AkkaNatGeo extends AbstractActor {
    private final LoggingAdapter log = Logging.getLogger(context().system(), this);

    public AkkaNatGeo() {
        receive(ReceiveBuilder.
                        match(String.class, s -> {
                            //this bit uses the method to create a file named like the string received + the current day
                            //currently "test2015-01-20.jpg"
                            NatGeo.saveImage(NatGeo.getUrl(), s + NatGeo.getDay()+ ".jpg");
                            log.info("Received String message: {}", s);
                        }).
                        matchAny(o -> log.info("received unknown message"))
                        .build()
        );
    }

    public static void main(String[] args) {

        final ActorSystem system = ActorSystem.create("AkkaNatGeo");

        final ActorRef myactor = system.actorOf(Props.create(AkkaNatGeo.class), "myactor");

        myactor.tell("test", ActorRef.noSender());

        //this command shutdown the system actor, thus killing the process
        //system.shutdown();

    }
}



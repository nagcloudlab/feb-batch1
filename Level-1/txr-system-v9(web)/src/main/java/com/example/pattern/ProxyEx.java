package com.example.pattern;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Slf4j
class Actor {
    private String name;
    private String role;

    public void getAct() {
        log.info("{} playing {} role ", this.name, this.role);
    }
}

class Security {
    public void doSec() {
        System.out.println("security...");
    }
}


class ActorProxy extends Actor {
    Actor actor = new Actor("Nag", "Villain");
    Security security = new Security();
    public void getAct() {
        security.doSec();
        actor.getAct();
    }
}


public class ProxyEx {

    public static void main(String[] args) {

        ActorProxy actorProxy = new ActorProxy();
        actorProxy.getAct();

    }

}

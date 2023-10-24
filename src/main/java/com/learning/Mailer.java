package com.learning;

import java.util.function.Consumer;

public class Mailer {

    private Mailer(){

    }

    public Mailer from(String addr) {
        System.out.println("from");
        return this;
    }

    public Mailer to(String addr) {
        System.out.println("to");
        return this;
    }

    public Mailer subject(String subject) {
        System.out.println("subject");
        return this;
    }

    public Mailer body(String body) {
        System.out.println("body");
        return this;
    }

   /* public void send() {
        System.out.println("sending");
    }*/

    public static void send(Consumer<Mailer> block) {
        Mailer mailer = new Mailer();
        block.accept(mailer);
        System.out.println("sending");
    }

    public static void main(String[] args) {
       //Mailer mailer = new Mailer();
        /*mailer.from("singh.ram25327@gmail.com");
        mailer.to("ram.singh@ril.com");
        mailer.subject("HI");
        mailer.body("testing");
        mailer.send();*/

        /*mailer.from("singh.ram25327@gmail.com")
              .to("ram.singh@ril.com")
              .subject("HI")
              .body("testing")
              .send();*/

        Mailer.send(mailer->mailer.from("singh.ram25327@gmail.com")
                .to("ram.singh@ril.com")
                .subject("HI")
                .body("testing")
        );


    }

}

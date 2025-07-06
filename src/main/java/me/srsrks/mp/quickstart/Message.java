package me.srsrks.mp.quickstart;

public class Message {

    private String message;

    private String greeting;

    private String pokeData;

    public Message() {
    }

    public Message(String message) {
        this.message = message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return this.message;
    }

    public void setGreeting(String greeting) {
        this.greeting = greeting;
    }

    public String getGreeting() {
        return this.greeting;
    }

    public String getPokeData() {
        return this.pokeData;
    }

    public void setPokeData(String pokeData) {
        this.pokeData = pokeData;
    }
}

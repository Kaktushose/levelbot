package de.kaktushose.nrtv.discord.frameworks.event;

public enum EventType {

    EASTER(0),
    SUMMER(1),
    WINTER(2);

    EventType(int id) {
        this.id = id;
    }

    public final int id;

}
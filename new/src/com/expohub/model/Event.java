package com.expohub.model;

public class Event {
    private int eventId;
    private String eventName;
    private String eventType;

    // Constructor
    public Event(int eventId, String eventName, String eventType) {
        this.eventId = eventId;
        this.eventName = eventName;
        this.eventType = eventType;
    }

    // Getters and Setters
    public int getEventId() {
        return eventId;
    }

    public void setEventId(int eventId) {
        this.eventId = eventId;
    }

    public String getEventName() {
        return eventName;
    }

    public void setEventName(String eventName) {
        this.eventName = eventName;
    }

    public String getEventType() {
        return eventType;
    }

    public void setEventType(String eventType) {
        this.eventType = eventType;
    }
}

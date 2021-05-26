package com.sushil.cs.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Objects;

/**
 * The type Event detail.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class EventDetail {

    private String id;
    private State state;
    private String type;
    private String host;
    private Long timestamp;

    /**
     * Instantiates a new Event detail.
     *
     * @param id        the id
     * @param state     the state
     * @param type      the type
     * @param host      the host
     * @param timestamp the timestamp
     */
    @JsonCreator
    public EventDetail(@JsonProperty(value="id", required = true) String id, @JsonProperty(value="state", required = true) State state, @JsonProperty("type") String type,
             @JsonProperty("host") String host, @JsonProperty(value="timestamp", required = true) Long timestamp) {
        this.id = id;
        this.state = state;
        this.type = type;
        this.host = host;
        this.timestamp = timestamp;
    }


    /**
     * Gets id.
     *
     * @return the id
     */
    public String getId() {
        return id;
    }

    /**
     * Sets id.
     *
     * @param id the id
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * Gets state.
     *
     * @return the state
     */
    public State getState() {
        return state;
    }

    /**
     * Sets state.
     *
     * @param state the state
     */
    public void setState(State state) {
        this.state = state;
    }

    /**
     * Gets type.
     *
     * @return the type
     */
    public String getType() {
        return type;
    }

    /**
     * Sets type.
     *
     * @param type the type
     */
    public void setType(String type) {
        this.type = type;
    }

    /**
     * Gets host.
     *
     * @return the host
     */
    public String getHost() {
        return host;
    }

    /**
     * Sets host.
     *
     * @param host the host
     */
    public void setHost(String host) {
        this.host = host;
    }

    /**
     * Gets timestamp.
     *
     * @return the timestamp
     */
    public Long getTimestamp() {
        return timestamp;
    }

    /**
     * Sets timestamp.
     *
     * @param timestamp the timestamp
     */
    public void setTimestamp(Long timestamp) {
        this.timestamp = timestamp;
    }


    /**
     * The enum State.
     */
    public enum State {
        /**
         * Started state.
         */
        @JsonProperty("STARTED")
        STARTED,
        /**
         * Finished state.
         */
        @JsonProperty("FINISHED")
        FINISHED
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EventDetail that = (EventDetail) o;
        return Objects.equals(id, that.id) && state == that.state && Objects.equals(type, that.type) && Objects.equals(host, that.host) && Objects.equals(timestamp, that.timestamp);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, state, type, host, timestamp);
    }

    @Override
    public String toString() {
        return "EventDetails{" +
                "id='" + id + '\'' +
                ", state=" + state +
                ", type='" + type + '\'' +
                ", host='" + host + '\'' +
                ", timestamp=" + timestamp +
                '}';
    }
}

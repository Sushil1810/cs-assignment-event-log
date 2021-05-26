package com.sushil.cs.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Objects;

/**
 * The type Event entity.
 */
@Entity
public class EventEntity {

    @Id
    private String id;
    private Long duration;
    private String type;
    private String host;
    private boolean alert;

    /**
     * Instantiates a new Event entity.
     */
    public EventEntity(){}

    /**
     * Instantiates a new Event entity.
     *
     * @param id       the id
     * @param duration the duration
     * @param type     the type
     * @param host     the host
     * @param alert    the alert
     */
    public EventEntity(String id, Long duration, String type, String host, boolean alert) {
        super();
        this.id = id;
        this.duration = duration;
        this.type = type;
        this.host = host;
        this.alert = alert;
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
     * Gets duration.
     *
     * @return the duration
     */
    public Long getDuration() {
        return duration;
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
     * Is alert boolean.
     *
     * @return the boolean
     */
    public boolean isAlert() {
        return alert;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EventEntity that = (EventEntity) o;
        return alert == that.alert && Objects.equals(id, that.id) && Objects.equals(duration, that.duration) && Objects.equals(type, that.type) && Objects.equals(host, that.host);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, duration, type, host, alert);
    }

    @Override
    public String toString() {
        return "EventEntity{" +
                "id='" + id + '\'' +
                ", duration=" + duration +
                ", type='" + type + '\'' +
                ", host='" + host + '\'' +
                ", alert=" + alert +
                '}';
    }
}

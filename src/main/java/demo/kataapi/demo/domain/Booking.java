package demo.kataapi.demo.domain;

import javax.persistence.*;

@Table
@Entity
public class Booking {

    @Id
    private String idTech;

    @Column(length = 8)
    private String date;

    @Column(length = 2)
    private Integer startTime;

    @Column(length = 2)
    private Integer endTime;

    @Column
    private String personName;

    @ManyToOne(optional = false)
    private Room room;

    public String getIdTech() {
        return idTech;
    }

    public void setIdTech(String idTech) {
        this.idTech = idTech;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public Integer getStartTime() {
        return startTime;
    }

    public void setStartTime(Integer startTime) {
        this.startTime = startTime;
    }

    public Integer getEndTime() {
        return endTime;
    }

    public void setEndTime(Integer endTime) {
        this.endTime = endTime;
    }

    public String getPersonName() {
        return personName;
    }

    public void setPersonName(String personName) {
        this.personName = personName;
    }

    public Room getRoom() {
        return room;
    }

    public void setRoom(Room room) {
        this.room = room;
    }
}

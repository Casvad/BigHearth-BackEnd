package escuelaing.edu.co.bighearth.model;

public class EventType {

    private int idEvent;
    private String nameEventType;

    public EventType(){

    }

    public EventType(int idEvent, String nameEventType) {
        this.idEvent = idEvent;
        this.nameEventType = nameEventType;
    }

    public int getIdEvent() {
        return idEvent;
    }

    public void setIdEvent(int idEvent) {
        this.idEvent = idEvent;
    }

    public String getNameEventType() {
        return nameEventType;
    }

    public void setNameEventType(String nameEventType) {
        this.nameEventType = nameEventType;
    }

    public boolean equals (EventType et){
        if (this==et) return true;
        if (this == null) return false;
        if (this.getClass() != et.getClass()) return false;
        return this.getIdEvent() == (et.getIdEvent());
    }
}

package escuelaing.edu.co.bighearth.model;

public class EventId {

    private int id;
    private String name;

    public EventId(int id, String name){
        this.id=id;
        this.name=name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public Boolean sameEventId(EventId event){
        Boolean itSame =false;
        if (this.id==event.getId() && this.name.equals(event.getName())) itSame=true;
        return itSame;
    }
}

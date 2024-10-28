package org.launchcode.techjobs.oo;

import java.util.Objects;

public class Job {

    private int id;
    private static int nextId = 1;

    private String name;
    private Employer employer;
    private Location location;
    private PositionType positionType;
    private CoreCompetency coreCompetency;

    // TODO: Add two constructors - one to initialize a unique ID and a second to initialize the
    //  other five fields. The second constructor should also call the first in order to initialize
    //  the 'id' field.

    public Job(){
        //this.id = ++nextId;
        this.id = nextId;
        nextId++;
    }

    public Job( String name, Employer employer, Location location, PositionType positionType, CoreCompetency coreCompetency) {
        this();
        this.name = name;
        this.employer = employer;
        this.location = location;
        this.positionType = positionType;
        this.coreCompetency = coreCompetency;
    }



    // TODO: Add custom equals and hashCode methods. Consider two Job objects "equal" when their id fields
    //  match.

    @Override
    public String toString() {
        String returnNoData = "Data not available";

        if(getName().isEmpty()
                && getEmployer().getValue().isEmpty()
                && getLocation().getValue().isEmpty()
                && getPositionType().getValue().isEmpty()
                && getCoreCompetency().getValue().isEmpty()
        ){ return "OOPS! This job does not seem to exist.";}

        if(getName().equals("")){
            name = returnNoData;
        }
        if(getEmployer().getValue().isEmpty()){
            employer.setValue(returnNoData);
        }
        if(getLocation().getValue().isEmpty()){
            location.setValue(returnNoData);
        }
        if(getPositionType().getValue().isEmpty()){
            positionType.setValue(returnNoData);
        }
        if(getCoreCompetency().getValue().isEmpty()){
            coreCompetency.setValue(returnNoData);
        }
        return "\n" +
                "ID: " + getId() +
                "\nName: " + getName() +
                "\nEmployer: " + getEmployer() +
                "\nLocation: " + getLocation() +
                "\nPosition Type: " + getPositionType() +
                "\nCore Competency: " + getCoreCompetency() +
                "\n";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Job)) return false;
        Job that = (Job) o;
        return id == that.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    // TODO: Add getters for each field EXCEPT nextId. Add setters for each field EXCEPT nextID
    //  and id.


    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Employer getEmployer() {
        return employer;
    }

    public void setEmployer(Employer employer) {
        this.employer = employer;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public PositionType getPositionType() {
        return positionType;
    }

    public void setPositionType(PositionType positionType) {
        this.positionType = positionType;
    }

    public CoreCompetency getCoreCompetency() {
        return coreCompetency;
    }

    public void setCoreCompetency(CoreCompetency coreCompetency) {
        this.coreCompetency = coreCompetency;
    }
}

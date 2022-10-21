package edu.javacourse.studentorder.domain;

public class CityRegisterCheckerResponse {

    boolean existing;
    Boolean temporal;

    public void setExisting (boolean existing){
        this.existing = existing;
    }

    public boolean isExisting (){
        return existing;
    }

    public void setTemporal (Boolean temporal){
        this.temporal = temporal;
    }

    public Boolean getTemporal (){
        return temporal;
    }

    @Override
    public String toString() {
        return "CityRegisterCheckerResponse{" +
                "existing=" + existing +
                ", temporal=" + temporal +
                '}';
    }
}

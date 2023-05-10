package org.example.pojo;

import java.util.ArrayList;
import java.util.List;

public class Garage {


    List<Voiture> lesVoitures;

    public Garage(){
        this.lesVoitures = new ArrayList<>();
    }

    public Garage(List<Voiture> lesVoitures){
        this.lesVoitures = lesVoitures;
    }

    public List<Voiture> getLesVoitures() {
        return lesVoitures;
    }

    public boolean addVoiture(Voiture voiture){
        return this.lesVoitures.add(voiture);
    }
    public void setLesVoitures(List<Voiture> lesVoitures) {
        this.lesVoitures = lesVoitures;
    }

    @Override
    public String toString(){
        return this.lesVoitures.toString();
    }
}

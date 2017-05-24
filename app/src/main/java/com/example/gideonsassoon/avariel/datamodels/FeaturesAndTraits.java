package com.example.gideonsassoon.avariel.datamodels;

import io.realm.RealmObject;

/**
 * Created by Gideon Sassoon on 20/03/2017.
 */

public class FeaturesAndTraits  extends RealmObject {

    String fATName;
    String fATDescription;

    public String getfATName() {
        return fATName;
    }

    public void setfATName(String fATName) {
        this.fATName = fATName;
    }

    public String getfATDescription() {
        return fATDescription;
    }

    public void setfATDescription(String fATDescription) {
        this.fATDescription = fATDescription;
    }
}
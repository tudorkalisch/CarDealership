package com.accenture.tudorckalisch.cardealership;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by tudor.c.kalisch on 6/30/2017.
 */

public class Car implements Parcelable {
    public String name;
    public String type;
    public String description;
    public String imageId;

    public Car(String name, String type, String description, String imageId) {
        this.name = name;
        this.type = type;
        this.description = description;
        this.imageId = imageId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImageId() {
        return imageId;
    }

    public void setImageId(String imageId) {
        this.imageId = imageId;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.name);
        dest.writeString(this.type);
        dest.writeString(this.description);
        dest.writeString(this.imageId);
    }

    protected Car(Parcel in) {
        this.name = in.readString();
        this.type = in.readString();
        this.description = in.readString();
        this.imageId = in.readString();
    }

    public static final Creator<Car> CREATOR = new Creator<Car>() {
        @Override
        public Car createFromParcel(Parcel source) {
            return new Car(source);
        }

        @Override
        public Car[] newArray(int size) {
            return new Car[size];
        }
    };

    @Override
    public String toString() {
        return "Car{" +
                "name='" + name + '\'' +
                ", type='" + type + '\'' +
                ", description='" + description + '\'' +
                ", imageId='" + imageId + '\'' +
                '}';
    }
}

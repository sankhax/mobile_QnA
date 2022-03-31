package com.example.question;

import com.google.gson.annotations.SerializedName;

public class model {
    @SerializedName("name")
    public String name;

    @SerializedName("email")
    public String email;

    public model(String name, String email) {
        this.name = name;
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    @Override
    public String toString() {
        return "MyUserData{" +
                "name='" + name + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}

package com.cydeo.entity;

import com.cydeo.enums.UserRole;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@NoArgsConstructor
@Getter
@Setter
@Table(name = "account_details ")
@JsonIgnoreProperties(value = {"state", "postalCode"}, ignoreUnknown = true)
public class Account extends BaseEntity{
    private String name;
    private String address;
    private String country;
    private String state;
    private String city;
    private String postalCode;
    private Integer age;
    @Enumerated(EnumType.STRING)
    private UserRole role = UserRole.USER;

    @OneToOne(mappedBy = "account")
    @JsonBackReference //is the back part of the reference, will be omitted from serialization
    private User user;

    @Override
    public String toString() {
        return "Account{" +
                "name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", country='" + country + '\'' +
                ", state='" + state + '\'' +
                ", city='" + city + '\'' +
                ", postalCode='" + postalCode + '\'' +
                ", age=" + age +
                ", role=" + role +
                '}';
    }
}

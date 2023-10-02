package com.example.MsAdolescente.domain.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.relational.core.mapping.Table;

import java.time.LocalDate;
import java.util.List;

@Table
@Getter
@Setter
@NoArgsConstructor
public class Adolescent {

    @Id
    private Integer id;
    private String name;
    private String paternal_last_name;
    private String maternal_last_name;
    private LocalDate birthday;
    private String gender;
    private String active;
    private String document_type;
    private String document_number;
    private LocalDate date_of_admission;
    private String crime_committed;
    private String contact_information;
    @Transient
    private List<Address> address;

    public Adolescent(String name, String paternal_last_name , String maternal_last_name, LocalDate birthday, String gender, String active , String document_type , String document_number , LocalDate date_of_admission , String crime_committed, String contact_information, List<Address> address) {
        this.name = name;
        this.paternal_last_name = paternal_last_name;
        this.maternal_last_name = maternal_last_name;
        this.birthday = birthday;
        this.gender = gender;
        this.active = active;
        this.document_type = document_type;
        this.document_number = document_number;
        this.date_of_admission = date_of_admission;
        this.crime_committed = crime_committed;
        this.contact_information = contact_information;
        this.address = address;
    }

    public Adolescent(Integer id, String name, String paternal_last_name , String maternal_last_name, LocalDate birthday, String gender, String active , String document_type , String document_number , LocalDate date_of_admission , String crime_committed, String contact_information, List<Address> address) {
        this.id = id;
        this.name = name;
        this.paternal_last_name = paternal_last_name;
        this.maternal_last_name = maternal_last_name;
        this.birthday = birthday;
        this.gender = gender;
        this.active = active;
        this.document_type = document_type;
        this.document_number = document_number;
        this.date_of_admission = date_of_admission;
        this.crime_committed = crime_committed;
        this.contact_information = contact_information;
        this.address = address;
    }
}

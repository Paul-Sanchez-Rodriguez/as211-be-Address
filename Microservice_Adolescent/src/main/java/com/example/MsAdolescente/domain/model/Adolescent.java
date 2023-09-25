package com.example.MsAdolescente.domain.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

import java.time.LocalDate;

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
    private LocalDate release_date;
    private String crime_committed;
    private String workshops;
    private String programs;
    private String progress_status;
    private String behavior_history;
    private String contact_information;

    public Adolescent(String name, String paternal_last_name , String maternal_last_name, LocalDate birthday, String gender, String active , String document_type , String document_number , LocalDate date_of_admission , LocalDate release_date, String crime_committed, String workshops, String programs, String progress_status, String behavior_history, String contact_information) {
        this.name = name;
        this.paternal_last_name = paternal_last_name;
        this.maternal_last_name = maternal_last_name;
        this.birthday = birthday;
        this.gender = gender;
        this.active = active;
        this.document_type = document_type;
        this.document_number = document_number;
        this.date_of_admission = date_of_admission;
        this.release_date = release_date;
        this.crime_committed = crime_committed;
        this.workshops = workshops ;
        this.programs = programs;
        this.progress_status = progress_status;
        this.behavior_history = behavior_history;
        this.contact_information = contact_information;
    }

    public Adolescent(Integer id, String name, String paternal_last_name , String maternal_last_name, LocalDate birthday, String gender, String active , String document_type , String document_number , LocalDate date_of_admission , LocalDate release_date, String crime_committed, String workshops, String programs, String progress_status, String behavior_history, String contact_information) {
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
        this.release_date = release_date;
        this.crime_committed = crime_committed;
        this.workshops = workshops ;
        this.programs = programs;
        this.progress_status = progress_status;
        this.behavior_history = behavior_history;
        this.contact_information = contact_information;
    }
}

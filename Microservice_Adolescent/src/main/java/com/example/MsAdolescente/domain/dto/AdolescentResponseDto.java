package com.example.MsAdolescente.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDate;

@Data
@AllArgsConstructor
public class AdolescentResponseDto implements Serializable {
    private static final long serialVersionUID = 8735757125749188522L;

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

    public AdolescentResponseDto() {

    }
}
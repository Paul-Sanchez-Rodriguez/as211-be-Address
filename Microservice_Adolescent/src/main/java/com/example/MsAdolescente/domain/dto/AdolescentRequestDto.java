package com.example.MsAdolescente.domain.dto;

import com.example.MsAdolescente.domain.model.Address;
import lombok.Data;
import org.springframework.data.annotation.Transient;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

@Data
public class AdolescentRequestDto implements Serializable {
    private static final long serialVersionUID = 8222253670338491507L;

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
    private List<Address> address;

}

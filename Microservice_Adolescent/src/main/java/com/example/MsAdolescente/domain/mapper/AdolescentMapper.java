package com.example.MsAdolescente.domain.mapper;

import com.example.MsAdolescente.domain.dto.AdolescentRequestDto;
import com.example.MsAdolescente.domain.dto.AdolescentResponseDto;
import com.example.MsAdolescente.domain.model.Adolescent;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class AdolescentMapper {

    public static Adolescent toModel(AdolescentRequestDto dto) {
        return new Adolescent(
                dto.getName(),
                dto.getPaternal_last_name(),
                dto.getMaternal_last_name(),
                dto.getBirthday(),
                dto.getGender(),
                dto.getActive(),
                dto.getDocument_type(),
                dto.getDocument_number(),
                dto.getDate_of_admission(),
                dto.getRelease_date(),
                dto.getCrime_committed(),
                dto.getWorkshops(),
                dto.getPrograms(),
                dto.getProgress_status(),
                dto.getBehavior_history(),
                dto.getContact_information()
        );
    }

    public static Adolescent toModel(Integer id, AdolescentRequestDto dto) {
        return new Adolescent(
                id,
                dto.getName(),
                dto.getPaternal_last_name(),
                dto.getMaternal_last_name(),
                dto.getBirthday(),
                dto.getGender(),
                dto.getActive(),
                dto.getDocument_type(),
                dto.getDocument_number(),
                dto.getDate_of_admission(),
                dto.getRelease_date(),
                dto.getCrime_committed(),
                dto.getWorkshops(),
                dto.getPrograms(),
                dto.getProgress_status(),
                dto.getBehavior_history(),
                dto.getContact_information()
        );
    }

    public static AdolescentResponseDto toDto(Adolescent model) {
        return new AdolescentResponseDto(
                model.getId(),
                model.getName(),
                model.getPaternal_last_name(),
                model.getMaternal_last_name(),
                model.getBirthday(),
                model.getGender(),
                model.getActive(),
                model.getDocument_type(),
                model.getDocument_number(),
                model.getDate_of_admission(),
                model.getRelease_date(),
                model.getCrime_committed(),
                model.getWorkshops(),
                model.getPrograms(),
                model.getProgress_status(),
                model.getBehavior_history(),
                model.getContact_information()
        );
    }
}
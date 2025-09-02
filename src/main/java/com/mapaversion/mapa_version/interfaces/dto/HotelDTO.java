package com.mapaversion.mapa_version.interfaces.dto;

import java.util.List;

import com.mapaversion.mapa_version.domain.enums.HotelType;

import lombok.Data;

@Data
public class HotelDTO {
    private String name;
    private String description;
    private String facilities;
    private Boolean isEco;
    private Double pricePerNight;
    private HotelType type;
    private List<String> photos;

    private AvailabilityDTO availability;
    private LocationDTO location;
}

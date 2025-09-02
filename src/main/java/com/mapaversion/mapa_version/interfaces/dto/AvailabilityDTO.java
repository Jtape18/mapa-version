package com.mapaversion.mapa_version.interfaces.dto;

import lombok.Data;

@Data
public class AvailabilityDTO {
    private Integer availableRooms;
    private Integer totalRooms;
    private Integer capacity;
}

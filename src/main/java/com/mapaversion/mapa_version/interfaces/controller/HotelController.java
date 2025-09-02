package com.mapaversion.mapa_version.interfaces.controller;

import java.net.URI;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mapaversion.mapa_version.domain.entities.AvailabilityEntity;
import com.mapaversion.mapa_version.domain.entities.HotelEntity;
import com.mapaversion.mapa_version.domain.entities.LocationEntity;
import com.mapaversion.mapa_version.infra.database.repositories.jpa.HotelRepository;
import com.mapaversion.mapa_version.interfaces.dto.AvailabilityDTO;
import com.mapaversion.mapa_version.interfaces.dto.HotelDTO;
import com.mapaversion.mapa_version.interfaces.dto.LocationDTO;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/hotels")
@RequiredArgsConstructor
public class HotelController {

    private final HotelRepository hotelRepository;

    @GetMapping
    public ResponseEntity<List<HotelEntity>> getAll() {
        return ResponseEntity.ok(hotelRepository.findAll());
    }

    @PostMapping
    public ResponseEntity<HotelEntity> create(@RequestBody HotelDTO dto) {
        // Mapear Availability
        AvailabilityEntity availability = null;
        AvailabilityDTO a = dto.getAvailability();
        if (a != null) {
            availability = AvailabilityEntity.builder()
                    .availableRooms(a.getAvailableRooms())
                    .totalRooms(a.getTotalRooms())
                    .capacity(a.getCapacity())
                    .build();
        }

        // Mapear Location
        LocationEntity location = null;
        LocationDTO l = dto.getLocation();
        if (l != null) {
            location = LocationEntity.builder()
                    .address(l.getAddress())
                    .latitude(l.getLatitude())
                    .longitude(l.getLongitude())
                    .build();
        }

        HotelEntity hotel = HotelEntity.builder()
                .name(dto.getName())
                .description(dto.getDescription())
                .facilities(dto.getFacilities())
                .isEco(dto.getIsEco())
                .pricePerNight(dto.getPricePerNight())
                .type(dto.getType())
                .photos(dto.getPhotos())
                .availability(availability) // NÃO pode ficar null por causa do @NotNull
                .location(location) // idem
                .build();

        HotelEntity saved = hotelRepository.save(hotel);
        return ResponseEntity.created(URI.create("/hotels/" + saved.getId())).body(saved);
    }
}

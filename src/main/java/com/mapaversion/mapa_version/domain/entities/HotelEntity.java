package com.mapaversion.mapa_version.domain.entities;

import java.util.List;

import com.mapaversion.mapa_version.domain.enums.HotelType;

import jakarta.persistence.CascadeType;
import jakarta.persistence.CollectionTable;
import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "hotels")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class HotelEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String description;
    private String facilities;
    private Boolean isEco;
    private String name;

    @ElementCollection
    @CollectionTable(name = "hotel_photos", joinColumns = @JoinColumn(name = "hotel_id"))
    @Column(name = "photo_url")
    private List<String> photos;

    private Double pricePerNight;

    @Enumerated(EnumType.STRING)
    private HotelType type;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "availability_id")
    private AvailabilityEntity availability;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "location_id")
    private LocationEntity location;
}

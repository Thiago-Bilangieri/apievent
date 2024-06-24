package com.bilanevent.api.domain.event;

import com.bilanevent.api.domain.address.Address;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
import java.util.UUID;

@Table(name = "event")
@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Event {
    @Id
    @GeneratedValue
    private UUID id;
    private String title;
    private String description;
    private String imageUrl;
    private String eventUrl;
    private Boolean remote;
    private Date date;
    @OneToOne(mappedBy = "event", cascade = CascadeType.ALL)
    private Address address;
}

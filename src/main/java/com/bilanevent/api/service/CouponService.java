package com.bilanevent.api.service;

import com.bilanevent.api.domain.coupon.Coupon;
import com.bilanevent.api.domain.coupon.CouponRequestDTO;
import com.bilanevent.api.domain.event.Event;
import com.bilanevent.api.repositories.CouponRepository;
import com.bilanevent.api.repositories.EventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.UUID;

@Service
public class CouponService {

    @Autowired
    private CouponRepository couponRepository;

    @Autowired
    private EventRepository eventRepository;

    public Coupon addCouponToEvent(UUID eventId, CouponRequestDTO couponData) {
        Event event = eventRepository.findById(eventId)
                .orElseThrow(() -> new IllegalArgumentException("Event not found"));
        Coupon coupon = new Coupon();
        coupon.setCode(couponData.code());
        coupon.setDiscount(couponData.discount());
        coupon.setValid(new Date(couponData.valid()));
        coupon.setEvent(event);
        return couponRepository.save(coupon);
    }
}
package com.example.carrental.controller;

import com.example.carrental.controller.DTO.BookingDTO;
import com.example.carrental.controller.DTO.ReservationDTO;
import com.example.carrental.repository.BookingRepository;
import com.example.carrental.repository.model.BookingModel;
import com.example.carrental.repository.ReservationRepository;
import com.example.carrental.repository.model.ReservationModel;
import com.example.carrental.service.BookingService;
import com.example.carrental.service.CurrencyService;
import com.example.carrental.service.ReservationService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequiredArgsConstructor
@RequestMapping("/bookings")
public class BookingController {


    private final BookingService bookingService;
    private final CurrencyService currencyService;
    private final BookingRepository bookingRepository;


    @GetMapping("/getall")
    public List<BookingDTO> getBookings() {
        return bookingService.getAllBookings();
    }

    @PostMapping("/add")
    public UUID addBooking(@RequestBody BookingDTO bookingDTO, @PathVariable UUID id) {
        return bookingService.addBooking(bookingDTO, id);

    }

    @DeleteMapping("/delete/{id}")
    public UUID deleteBookingById(@PathVariable("id") UUID id) {
        return bookingService.deleteBooking(id);
    }

    @PutMapping("/edit/{id}")
    public UUID editBooking(@PathVariable("id") UUID id, @RequestBody BookingDTO bookingDTO) {
        return bookingService.editBooking(bookingDTO, id);
    }


}

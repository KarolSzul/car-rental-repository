package com.example.carrental.controller;

import com.example.carrental.DTO.BookingDTO;
import com.example.carrental.model.BookingModel;
import com.example.carrental.model.ReservationModel;
import com.example.carrental.repository.CustomerRepository;
import com.example.carrental.repository.ReservationRepository;
import com.example.carrental.service.BookingService;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/bookings")
public class BookingController {


    private final BookingService bookingService;
    private final ReservationRepository reservationRepository;

    @GetMapping
    public List<BookingModel> getBookings() {
        return bookingService.getAllBookings();
    }

    @PostMapping()
    public void addBooking(@RequestBody BookingDTO bookingDTO, @PathVariable Long id) {
        BookingModel bookingModel = bookingService.addBooking(bookingDTO);
        reservationRepository.getReservationModelById(id).setBookingModel(bookingModel);
    }

    @DeleteMapping("/{id}")
    public void deleteBookingById(@PathVariable("id") Long id) {
        bookingService.deleteBooking(id);
    }

    @PutMapping("/{id}")
    public void editBooking(@PathVariable("id") Long id, @RequestBody BookingDTO bookingDTO) {
        BookingModel bookingModel = bookingService.getBookingModelById(id);
        bookingService.editBooking(bookingDTO, bookingModel);
    }

}

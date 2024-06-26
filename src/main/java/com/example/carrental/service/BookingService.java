package com.example.carrental.service;

import com.example.carrental.controller.DTO.BookingDTO;
import com.example.carrental.service.mapper.BookingMapper;
import com.example.carrental.repository.model.BookingModel;
import com.example.carrental.repository.BookingRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class BookingService {

    private final BookingRepository bookingRepository;

    private final BookingMapper bookingMapper;


    public BookingModel addBooking(BookingDTO bookingDTO) {
        BookingModel newBooking = new BookingModel();
        bookingMapper.bookingDTOToBookingModel(bookingDTO, newBooking);
        bookingRepository.save(newBooking);
        return newBooking;
    }

    public UUID deleteBooking(UUID id) {
        bookingRepository.deleteById(id);
        return id;
    }


    public UUID editBooking(BookingDTO bookingDTO, UUID id) {
        BookingModel bookingModel = bookingRepository.findById(id).orElse(null);
        bookingMapper.bookingDTOToBookingModel(bookingDTO, bookingModel);
        bookingRepository.save(bookingModel);
        return id;
    }


    public List<BookingDTO> getAllBookings() {
        return bookingRepository
                .findAll()
                .stream()
                .map(b ->bookingMapper.bookingModelToBookingDTO(b))
                .collect(Collectors.toList());

    }

    public BookingDTO getBookingDTOById(UUID id) {
        BookingModel bookingModel = bookingRepository.findById(id).orElse(null);
        return bookingMapper.bookingModelToBookingDTO(bookingModel);
    }


}

package com.example.carrental.service.mapper;

import com.example.carrental.controller.DTO.BookingDTO;
import com.example.carrental.repository.model.BookingModel;
import org.springframework.stereotype.Component;

@Component
public class BookingMapper {


    public BookingModel bookingDTOToBookingModel(BookingDTO bookingDTO, BookingModel bookingModel) {


        if (bookingDTO.getEmployeeModel() != null) {
            bookingModel.setEmployeeModel(bookingDTO.getEmployeeModel());
        }

        if (bookingDTO.getBookingStartDay() != null) {
            bookingModel.setBookingStartDay(bookingDTO.getBookingStartDay());
        }

        if (bookingDTO.getComments() != null) {
            bookingModel.setComments(bookingDTO.getComments());
        }

        return bookingModel;


    }

    public BookingDTO bookingModelToBookingDTO(BookingModel bookingModel) {
        BookingDTO bookingDTO = new BookingDTO();
        bookingDTO.setEmployeeModel(bookingModel.getEmployeeModel());
        bookingDTO.setComments(bookingModel.getComments());
        bookingDTO.setBookingStartDay(bookingModel.getBookingStartDay());
        return bookingDTO;
    }


}

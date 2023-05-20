package com.example.carrental.controller;

import com.example.carrental.DTO.ReturnDTO;
import com.example.carrental.model.ReturnModel;
import com.example.carrental.service.ReturnService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping
@RequiredArgsConstructor
public class ReturnController {

    private final ReturnService returnService;

    @GetMapping
    public List<ReturnModel> getReturns(){
        return returnService.getAllReturns();

    }

    @PostMapping
    public void addReturn (@RequestBody ReturnDTO returnDTO) { returnService.addReturn(returnDTO); }

    @DeleteMapping("/{id}")
    public void deleteReturnById(@PathVariable("id") Long id) { returnService.deleteReturn(id); }

    @PostMapping("/edit/{id}")
    public void editReturn(@PathVariable("id") Long id,@RequestBody ReturnDTO returnDTO) {
        ReturnModel returnModel = returnService.getReturnModelById(id);
        returnService.editReturn(returnDTO, returnModel);
    }




}


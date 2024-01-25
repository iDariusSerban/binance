package com.example.binance.controller;

import com.example.binance.model.Kline;
import com.example.binance.model.Symbol;
import com.example.binance.service.KlineService;
import com.example.binance.service.SymbolService;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Controller
@RequestMapping("/kline")
public class KlineController {


    private KlineService klineService;


    public KlineController(KlineService klineService) {
        this.klineService = klineService;
    }


    @PostMapping("/addKline/{symbolName}")
    public ResponseEntity<Kline> addKline(@PathVariable String symbolName) {
        try {
            return ResponseEntity.ok(klineService.addKline(symbolName));
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, e.getMessage());
        }
    }
}
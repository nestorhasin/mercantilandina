package ar.com.mercantilandina.challenge.controller;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import ar.com.mercantilandina.challenge.entity.PedidoCabecera;
import ar.com.mercantilandina.challenge.request.PedidoRequest;
import ar.com.mercantilandina.challenge.service.interfaces.IPedidoService;

@RestController
@RequestMapping("/pedidos")
public class PedidoController {
    
    @Autowired
    private IPedidoService iPedidoService;

    @PostMapping
    public ResponseEntity<?> create(@RequestBody PedidoRequest pedidoRequest){
        return new ResponseEntity<>(iPedidoService.create(pedidoRequest), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<?> readByFecha(@RequestParam(value = "fecha", required = false) String fecha){
        return new ResponseEntity<>(iPedidoService.readByFecha(fecha), HttpStatus.OK);
    }

}

package br.com.eda.compras.demo.controller;

import br.com.eda.compras.demo.model.CompraRequest;
import br.com.eda.compras.demo.producer.CompraProducer;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/compras")
public class CompraController {

    private final CompraProducer compraProducer;

    public CompraController(CompraProducer compraProducer) {
        this.compraProducer = compraProducer;
    }

    @PostMapping
    public ResponseEntity<String> criarCompra(@RequestBody CompraRequest compraRequest) {
        compraProducer.enviarParaFila(compraRequest);
        return ResponseEntity.ok("Compra enviada para processamento com sucesso.");
    }
}
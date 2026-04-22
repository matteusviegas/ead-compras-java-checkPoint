package br.com.eda.compras.demo.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CompraRequest implements Serializable {

    private Long id;
    private String cliente;
    private String produto;
    private Double valor;
}
package com.nttd.dto;

import lombok.Data;

@Data
public class ProductDto {
    private long idProducto;
    private String tipoProducto;
    private String nombre;
    private Double saldo;
}

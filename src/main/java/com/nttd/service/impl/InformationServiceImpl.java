package com.nttd.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.microprofile.config.inject.ConfigProperty;
import org.eclipse.microprofile.rest.client.inject.RestClient;

import com.nttd.api.AuditApi;
import com.nttd.api.OperationApi;
import com.nttd.api.response.AccountResponse;
import com.nttd.dto.ProductDto;
import com.nttd.dto.ResponseDto;
import com.nttd.service.InformationService;

import io.smallrye.mutiny.Uni;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class InformationServiceImpl implements InformationService {

    @RestClient
    AuditApi auditApi;

    @RestClient
    OperationApi operationApi;

    @ConfigProperty(name = "mensaje.general")
    String mensajeGeneral;

    @ConfigProperty(name = "exception.general")
    String exceptionGeneral;

    @Override
    public Uni<ResponseDto> getProducts(long id) {
        try {

            return operationApi.getProducts(id, true)
                    .map(operation -> {
                        List<AccountResponse> accounts = new ArrayList<>();
                        if (operation.getCode() == 200) {
                            accounts = operation.getListaccount();
                        } else {
                            accounts = null;
                        }
                        return accounts;
                    })
                    .map(accounts -> {
                        if (accounts == null) {
                            return new ResponseDto(400, exceptionGeneral, "Ocurrio un error en operationApi");
                        }
                        List<ProductDto> products = new ArrayList<>();
                        for (AccountResponse account : accounts) {
                            ProductDto productDto = new ProductDto();

                            productDto.setIdProducto(account.getIdAccountCustomer());
                            productDto.setNombre(account.getDescription());
                            productDto.setTipoProducto(account.getFlag_creation());
                            productDto.setSaldo(account.getCurrent_amount());

                            products.add(productDto);
                        }
                        return new ResponseDto(201, mensajeGeneral, products);
                    })
                    .onFailure().recoverWithItem(error -> new ResponseDto(400, exceptionGeneral, error.getMessage()));

        } catch (Exception ex) {
            return Uni.createFrom().item(new ResponseDto(400, exceptionGeneral, ex.getMessage()));
        }

    }

}

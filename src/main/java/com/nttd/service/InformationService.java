package com.nttd.service;

import com.nttd.dto.ResponseDto;

import io.smallrye.mutiny.Uni;

public interface InformationService {

    public Uni<ResponseDto> getProducts(long id);
}

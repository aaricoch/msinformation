package com.nttd.api.request;

import lombok.Data;

@Data
public class AuditRequest {
    private String idAuditoria;
    private String aplicacion;
    private String usuarioAplicacion;
    private String usuarioSesion;
    private String codigoTransaccion;
    private String fechaTransaccion;
    private String mensaje;
    private String request;
    private String response;
}

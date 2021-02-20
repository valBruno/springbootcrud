package com.empresa.springbootcrud.config.validation;

public class ErroDTO {

    private String campo;
    private String mensagem;

    public ErroDTO() {
    }

    public ErroDTO(String campo, String mensagem) {
        this.campo = campo;
        this.mensagem = mensagem;
    }

    public String getCampo() {
        return campo;
    }

    public void setCampo(String campo) {
        this.campo = campo;
    }

    public String getMensagem() {
        return mensagem;
    }

    public void setMensagem(String mensagem) {
        this.mensagem = mensagem;
    }
}

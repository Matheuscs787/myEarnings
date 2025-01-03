package br.com.earnings.model.enums;

import lombok.Getter;

@Getter
public enum TipoMovimentacaoEnum {
    COMPRA(1L, "Compra"),
    VENDA(2L, "Venda"),
    ALUGUEL(3L, "Aluguel");

    private final Long id;
    private final String tipoMovimentacao;

    TipoMovimentacaoEnum(Long id, String tipoMovimentacao) {
        this.id = id;
        this.tipoMovimentacao = tipoMovimentacao;
    }
}

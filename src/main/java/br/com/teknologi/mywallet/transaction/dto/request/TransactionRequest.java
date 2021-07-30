package br.com.teknologi.mywallet.transaction.dto.request;

import br.com.teknologi.mywallet.transaction.enums.TransactionTypeEnum;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
public class TransactionRequest {

    private String description;
    private TransactionTypeEnum type;
    private BigDecimal value;

}

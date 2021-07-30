package br.com.teknologi.mywallet.transaction.model;

import br.com.teknologi.mywallet.transaction.dto.request.TransactionRequest;
import br.com.teknologi.mywallet.transaction.enums.TransactionTypeEnum;
import lombok.*;
import org.modelmapper.ModelMapper;

import java.math.BigDecimal;
import java.time.LocalDate;

@Getter
@Setter
@EqualsAndHashCode(doNotUseGetters = true, onlyExplicitlyIncluded = true)
@ToString
@NoArgsConstructor(onConstructor = @__(@Deprecated))
@RequiredArgsConstructor
public class Transaction {

    @EqualsAndHashCode.Include
    @Setter(onMethod = @__(@Deprecated))
    private Long id;

    @NonNull
    @Setter(onMethod = @__(@Deprecated))
    private String description;

    @NonNull
    @Setter(onMethod = @__(@Deprecated))
    private TransactionTypeEnum type;

    @NonNull
    @Setter(onMethod = @__(@Deprecated))
    private BigDecimal value;

    @Setter(onMethod = @__(@Deprecated))
    private LocalDate date = LocalDate.now();

    public static Transaction fromRequest(ModelMapper mapper, TransactionRequest request) {
        return mapper.map(request, Transaction.class);
    }

}

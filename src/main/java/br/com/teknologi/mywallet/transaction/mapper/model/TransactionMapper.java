package br.com.teknologi.mywallet.transaction.mapper.model;

import br.com.teknologi.mywallet.transaction.dto.request.TransactionRequest;
import br.com.teknologi.mywallet.transaction.model.Transaction;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class TransactionMapper {

    private ModelMapper mapper;

    public Transaction fromRequest(TransactionRequest request) {
        return mapper.map(request, Transaction.class);
    }

}

package br.com.teknologi.mywallet.transaction.mapper.model;


import br.com.teknologi.mywallet.transaction.config.ModelMapperConfig;
import br.com.teknologi.mywallet.transaction.dto.request.TransactionRequest;
import br.com.teknologi.mywallet.transaction.enums.TransactionTypeEnum;
import br.com.teknologi.mywallet.transaction.model.Transaction;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.modelmapper.ModelMapper;

import java.math.BigDecimal;
import java.time.LocalDate;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.nullValue;

public class TransactionMapperTest {

    private TransactionMapper transactionMapper;

    @BeforeEach
    public void init(){
        ModelMapperConfig mapperConfig = new ModelMapperConfig();
        ModelMapper modelMapper = mapperConfig.modelMapper();
        this.transactionMapper = new TransactionMapper(modelMapper);
    }

    @Test
    public void ShouldReturnIncomeEntityFromIncomeRequest(){
        TransactionRequest request = new TransactionRequest();
        request.setDescription("ABC");
        request.setType(TransactionTypeEnum.INCOME);
        request.setValue(BigDecimal.valueOf(100));

        Transaction transaction = this.transactionMapper.fromRequest(request);

        assertThat(transaction.getId(), is(nullValue()));
        assertThat(transaction.getDescription(), is("ABC"));
        assertThat(transaction.getType(), is(TransactionTypeEnum.INCOME));
        assertThat(transaction.getValue(), is(BigDecimal.valueOf(100)));
        assertThat(transaction.getDate(), is(LocalDate.now()));
    }

    @Test
    public void ShouldReturnExpenseEntityFromExpenseRequest(){
        TransactionRequest request = new TransactionRequest();
        request.setDescription("ABC");
        request.setType(TransactionTypeEnum.EXPENSE);
        request.setValue(BigDecimal.valueOf(100));

        Transaction transaction = this.transactionMapper.fromRequest(request);

        assertThat(transaction.getId(), is(nullValue()));
        assertThat(transaction.getDescription(), is("ABC"));
        assertThat(transaction.getType(), is(TransactionTypeEnum.EXPENSE));
        assertThat(transaction.getValue(), is(BigDecimal.valueOf(100)));
        assertThat(transaction.getDate(), is(LocalDate.now()));
    }

}
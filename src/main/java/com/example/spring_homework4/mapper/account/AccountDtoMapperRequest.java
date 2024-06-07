package com.example.spring_homework4.mapper.account;

import com.example.spring_homework4.domain.Account;
import com.example.spring_homework4.dto.account.AccountDtoRequest;
import com.example.spring_homework4.mapper.DtoMapperFacade;
import org.springframework.stereotype.Service;

@Service
public class AccountDtoMapperRequest extends DtoMapperFacade<Account, AccountDtoRequest> {
    public AccountDtoMapperRequest() {
        super(Account.class, AccountDtoRequest.class);
    }
}

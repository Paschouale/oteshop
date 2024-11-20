package gr.oteshop.tech.service.impl;

import gr.oteshop.tech.model.Account;
import gr.oteshop.tech.service.AccountService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AccountManager implements AccountService {
    @Override
    public void transferFunds(Long fromAccountId, Long toAccountId, Double amount) {

    }

    @Override
    public Optional<Account> findUserAccount(String userName) {
        return Optional.empty();
    }

    @Override
    public boolean existsByBalanceGreaterThan(double amount) {
        return false;
    }
}

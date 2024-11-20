package gr.oteshop.tech.service.impl;

import gr.oteshop.tech.model.Account;
import gr.oteshop.tech.repository.AccountRepository;
import gr.oteshop.tech.service.AccountService;
import gr.oteshop.tech.service.SubscriberService;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Primary
@AllArgsConstructor
@Slf4j
public class AccountServiceImpl implements AccountService {
    private final AccountRepository accountRepository;
    private final SubscriberService subscriberService;

    @Override
    @Transactional
    public void transferFunds(Long fromAccountId, Long toAccountId, Double amount) {
        log.debug("Debug.Transfer funds from {} to {}", fromAccountId, toAccountId);
        log.info("Info.Transfer funds from {} to {}", fromAccountId, toAccountId);
        Account fromAccount = accountRepository.findById(fromAccountId)
                .orElseThrow(() -> {
                    log.error("Error the account {} does not exist", fromAccountId);
                    return new IllegalArgumentException("Source account not found");
                        });
        Account toAccount = accountRepository.findById(toAccountId)
                .orElseThrow(() -> new IllegalArgumentException("Target account not found"));

        // Deduct amount from source account
        fromAccount.setBalance(fromAccount.getBalance() - amount);
        accountRepository.save(fromAccount);

        // Simulate a failure (e.g., network issue, validation error)
        if (amount > 1000) {
            throw new IllegalArgumentException("Transfer amount exceeds limit");
        }

        // Add amount to target account
        toAccount.setBalance(toAccount.getBalance() + amount);
    }

    @Override
    public Optional<Account> findUserAccount(String userName) {
        return accountRepository.findAccountByAccountHolderStartsWith(userName).stream().findFirst();
    }

    @Override
    public boolean existsByBalanceGreaterThan(double amount) {
        return accountRepository.existsByBalanceGreaterThan(amount+"");
    }
}

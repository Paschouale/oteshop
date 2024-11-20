package gr.oteshop.tech.bootstrap;

import gr.oteshop.tech.model.Account;
import gr.oteshop.tech.repository.AccountRepository;
import lombok.AllArgsConstructor;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class DataLoader implements ApplicationRunner {

    private final AccountRepository accountRepository;

    public void run(ApplicationArguments args){
        accountRepository.save(Account.builder().balance(1000.).accountHolder("Nikos").build());
        accountRepository.save(Account.builder().balance(2000.).accountHolder("Dora").build());
        accountRepository.save(Account.builder().balance(5000.).accountHolder("Dimitris").build());
    }
}

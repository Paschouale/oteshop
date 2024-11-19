package gr.oteshop.tech.service;

import gr.oteshop.tech.model.Mobile;
import gr.oteshop.tech.repository.MobileRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class MobileServiceImpl implements MobileService{
    private final MobileRepository mobileRepository;

    @Override
    public List<Mobile> getMobiles() {
        return mobileRepository.findAll();
    }

    @Override
    public Optional<Mobile> getMobile(Long id) {
        return mobileRepository.findById(id);
    }

    @Override
    public Optional<Mobile> createMobile(Mobile mobile) {
        mobileRepository.save(mobile);
        return Optional.of(mobile);
    }
}

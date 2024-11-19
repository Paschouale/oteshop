package gr.oteshop.tech.service;

import gr.oteshop.tech.model.Mobile;

import java.util.List;
import java.util.Optional;

public interface MobileService {
    List<Mobile> getMobiles();
    Optional<Mobile> getMobile(Long id);
    Optional<Mobile> createMobile(Mobile mobile);
}

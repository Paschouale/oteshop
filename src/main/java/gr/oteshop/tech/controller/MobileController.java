package gr.oteshop.tech.controller;

import gr.oteshop.tech.model.Mobile;
import gr.oteshop.tech.service.MobileService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@AllArgsConstructor
@RequestMapping("/api/mobile")
public class MobileController {
    private final MobileService mobileService;

    @GetMapping
    public List<Mobile> getMobiles(){
        return mobileService.getMobiles();
    }

    @GetMapping("{id}")
    public Optional<Mobile> getMobile(@PathVariable Long id){
        return mobileService.getMobile(id);
    }

    @PostMapping
    public Optional<Mobile> saveMobile(@RequestBody Mobile mobile){
        return mobileService.createMobile(mobile);
    }
}

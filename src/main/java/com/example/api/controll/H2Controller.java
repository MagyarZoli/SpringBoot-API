package com.example.api.controll;

import com.example.api.dto.UserH2Dto;
import com.example.api.model.UserH2;
import com.example.api.repository.UserH2Repository;
import com.example.api.services.UserH2ServicesImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/h2")
public class H2Controller
        extends CController<UserH2, UserH2Dto, Long, UserH2ServicesImpl, UserH2Repository> {

    @Autowired
    public H2Controller(UserH2ServicesImpl services) {
        super(services);
    }
}
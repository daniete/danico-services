package com.danico.danicoservices.bootstrap;

import com.danico.danicoservices.model.Patroon;
import com.danico.danicoservices.repositories.PatroonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

@Component
public class DevBootstrap implements ApplicationListener<ContextRefreshedEvent> {

    @Autowired
    private PatroonRepository patroonRepository;

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        initData();
    }

    private void initData(){

        //Daniels
        Patroon daniels = new Patroon("Daniels", "A", "test");

        patroonRepository.save(daniels);
    }
}

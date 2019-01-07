package com.danico.danicoservices.bootstrap;

import com.danico.danicoservices.dao.DoosRepository;
import com.danico.danicoservices.dao.PatroonRepository;
import com.danico.danicoservices.model.Patroon;
import com.danico.danicoservices.dao.KlantRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class DevBootstrap implements ApplicationListener<ContextRefreshedEvent> {

    @Autowired
    private PatroonRepository patroonRepository;

    @Autowired
    private KlantRepository klantRepository;

    @Autowired
    private DoosRepository doosRepository;

    public DevBootstrap(PatroonRepository patroonRepository, KlantRepository klantRepository, DoosRepository doosRepository) {
        this.patroonRepository = patroonRepository;
        this.klantRepository = klantRepository;
        this.doosRepository = doosRepository;
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        initData();
    }

    private void initData(){

        Patroon daniels = new Patroon(klantRepository.findById((long) 2).get(), doosRepository.findById((long) 52).get(), "blablabla", "C:\\Users\\daniete\\Documents\\danico\\patronen");
        patroonRepository.save(daniels);
    }
}

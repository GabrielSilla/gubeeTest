package com.gubee.gubee.core.service;

import com.gubee.gubee.core.entity.Config;
import com.gubee.gubee.core.repository.ConfigRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ConfigService {

    private final ConfigRepository configRepository;

    @Autowired
    public ConfigService(ConfigRepository configRepository) {
        this.configRepository = configRepository;
    }

    public Config findConfigByKey(String key) {
        return !key.isEmpty() ? configRepository.findFirstByKey(key) : null;
    }

    public Config updateConfig(Config config) {
        return configRepository.save(config);
    }
}

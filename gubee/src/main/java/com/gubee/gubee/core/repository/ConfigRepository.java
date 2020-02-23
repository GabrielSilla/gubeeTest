package com.gubee.gubee.core.repository;

import com.gubee.gubee.core.entity.Config;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ConfigRepository extends JpaRepository<Config, Integer> {

    public Config findFirstByKey(String key);
}

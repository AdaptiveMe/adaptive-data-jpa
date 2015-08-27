package me.adaptive.core.data.util;

import me.adaptive.core.data.domain.SystemSetting;
import me.adaptive.core.data.repo.SystemSettingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.validation.constraints.NotNull;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

/**
 * Created by panthro on 27/08/15.
 */
@SuppressWarnings("unused")
@Service
public class SystemSettingHolder {


    private static final Map<String, SystemSetting> MAP = new HashMap<>();
    @Autowired
    private SystemSettingRepository repository;

    public static Optional<SystemSetting> getSettingByKey(@NotNull String key) {
        return Optional.ofNullable(MAP.get(key));
    }

    public static Map<String, SystemSetting> getAll() {
        return MAP;
    }


    private void loadSettings() {
        List<SystemSetting> settings = repository.findAll();
        for (SystemSetting setting : settings) {
            MAP.put(setting.getKey(), setting);
        }
    }

    @Scheduled(fixedRate = 3600 * 1000) // 1 hour
    private void reloadSettings() {
        loadSettings();
    }

    @PostConstruct
    private void init() {
        loadSettings();
    }

}

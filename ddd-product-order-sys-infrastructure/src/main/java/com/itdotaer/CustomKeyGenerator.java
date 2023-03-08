package com.itdotaer;

import org.apache.shardingsphere.spi.keygen.ShardingKeyGenerator;

import java.util.Properties;
import java.util.concurrent.atomic.AtomicLong;

public class CustomKeyGenerator implements ShardingKeyGenerator {

    private AtomicLong ger = new AtomicLong(0);

    @Override
    public Comparable<?> generateKey() {
        return ger.incrementAndGet();
    }

    @Override
    public String getType() {
        return "CustomKeyGenerator";
    }

    @Override
    public Properties getProperties() {
        return null;
    }

    @Override
    public void setProperties(Properties properties) {

    }
}

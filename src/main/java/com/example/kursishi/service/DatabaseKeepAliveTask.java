package com.example.kursishi.service;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.jdbc.core.JdbcTemplate;

@Component
public class DatabaseKeepAliveTask {

    private final JdbcTemplate jdbcTemplate;

    public DatabaseKeepAliveTask(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    // 🟢 Har 10 daqiqada (600000 millisekund) bazaga "SELECT 1" so‘rovini yuboradi
    @Scheduled(fixedRate = 600000)
    public void keepDatabaseAlive() {
        try {
            jdbcTemplate.execute("SELECT 1");
            System.out.println("✅ Database keep-alive query executed!");
        } catch (Exception e) {
            System.err.println("❌ Database keep-alive query failed: " + e.getMessage());
        }
    }
}


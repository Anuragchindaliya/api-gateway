package in.anurag.gatekeeper.management.service;

import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class HealthService {

    private final JdbcTemplate jdbcTemplate;

    public String getHealth() {
        String databaseStatus = "Down";

        try {
            Integer result = jdbcTemplate.queryForObject("SELECT 1", Integer.class);
            if (Integer.valueOf(1).equals(result)) {
                databaseStatus = "Up";
            }
        } catch (Exception e) {
            System.out.println("MySQL Health check failed" + e.getMessage());
        }
        return databaseStatus;
    }
}

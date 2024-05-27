package com.example.mobile_programming.Repository;

import com.example.mobile_programming.Entity.Schedule;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ScheduleRepository extends JpaRepository<Schedule, Long> {
}

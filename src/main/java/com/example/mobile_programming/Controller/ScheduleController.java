package com.example.mobile_programming.Controller;

import com.example.mobile_programming.Entity.Schedule;
import com.example.mobile_programming.Repository.ProjectRepository;
import com.example.mobile_programming.Repository.ScheduleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/yourSchedule")
public class ScheduleController {
    @Autowired
    private ScheduleRepository scheduleRepository;

    @GetMapping
    public List<Schedule> getAllSchedule() {

        return scheduleRepository.findAll();
    }
    @PostMapping
    public Schedule createSchedule(@RequestBody Schedule schedule)
    {

        return scheduleRepository.save(schedule);
    }

}

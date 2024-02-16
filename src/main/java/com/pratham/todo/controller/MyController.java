package com.pratham.todo.controller;

import org.springframework.web.bind.annotation.RestController;

import com.pratham.todo.entities.Activities;
import com.pratham.todo.services.ActivityService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
public class MyController 
{
    @Autowired
    private ActivityService activityService;

    @GetMapping("/")
    public String home()
    {
        return "This is the home page";
    }

    //Get the activities 
    @GetMapping("/activities")
    public List<Activities> getActivities() 
    {
        return this.activityService.getActivities();
    }

    //for adding the activities 
    @PostMapping("/activities")
    public Activities addActivities(@RequestBody Activities activities)
    {
        return this.activityService.addActivities(activities);
    }
    
    //for updating activities 
    @PutMapping("/activities/{id}")
    public Activities updateActivity(@PathVariable int id, @RequestBody String title)
    {
        return this.activityService.updateActivity(id,title);
    }

    //for updating time 
    @PutMapping("/time/{id}")
    public Activities updateTime(@PathVariable int id, @RequestBody String time)
    {
        return this.activityService.updateTime(id,time);
    }

    //for Updating Status 
    @PutMapping("/status/{id}")
    public Activities updateStatus(@PathVariable int id, @RequestBody String status)
    {
        return this.activityService.updateStatus(id,status);
    }

    //for deleting the task
    @DeleteMapping("/activities/{id}")
    public ResponseEntity<Object> deleteActivity(@PathVariable int id)
    {
        try 
        {
            this.activityService.deleteActivity(id);   
            return new ResponseEntity<>(HttpStatus.OK);
        } 
        catch (Exception e) 
        {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}

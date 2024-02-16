package com.pratham.todo.services;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.pratham.todo.entities.Activities;

/**
 * ActivityService
 */
public interface ActivityService 
{
    public List<Activities> getActivities();

    public Activities addActivities(Activities activity);

    public Activities updateActivity(int id , String des);

    public Activities updateTime(int id , String time);

    public Activities updateStatus(int id , String status);

    public ResponseEntity<Object> deleteActivity(int id);
} 

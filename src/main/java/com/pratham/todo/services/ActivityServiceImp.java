package com.pratham.todo.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.pratham.todo.entities.Activities;

@Service
public class ActivityServiceImp implements ActivityService
{
    List<Activities> list;

    public ActivityServiceImp()
    {
        list = new ArrayList<>();
        list.add(new Activities(0,"1/12/2024","Do Something","1:00","Not Done"));
        list.add(new Activities(1,"1/12/2024","Walking for an hour", "2:00","Not Done"));
    }

    @Override
    public List<Activities> getActivities() 
    {
        return list;
    }

    @Override
    public Activities addActivities(Activities activity) 
    {
        list.add(activity);
        return activity;
    }

    @Override
    public Activities updateActivity(int id, String des) 
    {
        if (id >= 0 && id < list.size()) { // Check if id is valid
           Activities activity = list.get(id); // Retrieve activity object
            activity.setTitle(des); // Update description
            return activity; // Return updated activity
        } else {
            // Handle invalid id, return null or throw an exception
            return null;
        }
    }

    @Override
    public Activities updateTime(int id, String time) 
    {
        if (id >= 0 && id < list.size()) 
        { 
            Activities activity = list.get(id); 
             activity.setTime(time); 
             return activity; 
         } else 
         {
             
             return null;
         }
    }

    @Override
    public Activities updateStatus(int id, String status) 
    {
        if (id >= 0 && id < list.size()) 
        { 
            Activities activity = list.get(id);
             activity.setStatus(status); 
             return activity; 
         } else 
         {
             return null;
         }
    }

    @Override
    public void deleteActivity(int id) 
    {
        try {
            if (id >= 0 && id < list.size()) 
            {
                list.remove(id);
            }
            else 
            {
                throw new IndexOutOfBoundsException();
            }
        
        } catch (IndexOutOfBoundsException e) {

        }
    }
    
}

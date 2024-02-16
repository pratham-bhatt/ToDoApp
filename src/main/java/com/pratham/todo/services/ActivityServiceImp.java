package com.pratham.todo.services;

// import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.pratham.todo.dao.ActivityDao;
import com.pratham.todo.entities.Activities;

@Service
public class ActivityServiceImp implements ActivityService
{
    // List<Activities> list;

    @Autowired
    private ActivityDao activityDao;

    public ActivityServiceImp()
    {
        // list = new ArrayList<>();
        // list.add(new Activities(0,"1/12/2024","Do Something","1:00","Not Done"));
        // list.add(new Activities(1,"1/12/2024","Walking for an hour", "2:00","Not Done"));
    }

    @Override
    public List<Activities> getActivities() 
    {
        return activityDao.findAll();
        // return list;
    }

    @SuppressWarnings("null")
    @Override
    public Activities addActivities(Activities activity) 
    {
        // list.add(activity);

        activityDao.save(activity);
        return activity;
    }

    @Override
    public Activities updateActivity(int id, String des) 
    {
        // Retrieve the activity from the database using its ID
        Optional<Activities> optionalActivity = activityDao.findById(id);
        
        // Check if the activity exists
        if (optionalActivity.isPresent()) 
        {
            // Get the activity object from Optional
            Activities activity = optionalActivity.get();

            // Update the title of the activity
            activity.setTitle(des);
            
            // Save the updated activity back to the database
            return activityDao.save(activity);
        } 
        else 
        {
            // Handle the case where the activity with the specified ID does not exist
            // For example, you can throw an exception or return null
            throw new RuntimeException("Activity not found with ID: " + id);
        }


       /*  if (id >= 0 && id < list.size()) { // Check if id is valid
           Activities activity = list.get(id); // Retrieve activity object
            activity.setTitle(des); // Update description
            return activity; // Return updated activity
        } else {
            // Handle invalid id, return null or throw an exception
            return null;
        }*/
    }

    @Override
    public Activities updateTime(int id, String time) 
    {
        Optional<Activities> optionalActivity = activityDao.findById(id);
        
        if (optionalActivity.isPresent()) 
        {
            Activities activity = optionalActivity.get();
            activity.setTime(time);
            return activityDao.save(activity);
        } 
        else 
        {
            throw new RuntimeException("Activity not found with ID: " + id);
        }
        /*
        if (id >= 0 && id < list.size()) 
        { 
                Activities activity = list.get(id); 
                 activity.setTime(time); 
                 return activity; 
             } else 
             {
                
                     return null;
                 }*/
            }
            
            @Override
            public Activities updateStatus(int id, String status) 
            {
                Optional<Activities> optionalActivity = activityDao.findById(id);
                if (optionalActivity.isPresent()) 
                {
                    Activities activity = optionalActivity.get();
                    activity.setStatus(status);
                    return activityDao.save(activity);
                } 
                else 
                {
                    throw new RuntimeException("Activity not found with ID: " + id);
                }
                
                /*
                if (id >= 0 && id < list.size()) 
                { 
                    Activities activity = list.get(id);
                    activity.setStatus(status); 
                    return activity; 
                } 
                else 
                {
                    return null;
                }*/
            }
            

            @Override
            public ResponseEntity<Object> deleteActivity(int id) 
            {

                if (activityDao.existsById(id)) 
                {
                    activityDao.deleteById(id);
                    return ResponseEntity.ok("Activity with ID " + id + " has been deleted successfully.");
                } 
                else 
                {
                    return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Activity not found with ID: " + id);
                }

                /*try {
                    if (id >= 0 && id < list.size()) 
                    {
                        list.remove(id);
                    }
                    else 
                    {
                        throw new IndexOutOfBoundsException();
                    }
        
                } catch (IndexOutOfBoundsException e) { }*/
            }
    
}

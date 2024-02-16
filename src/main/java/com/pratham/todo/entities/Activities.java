package com.pratham.todo.entities;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Activities 
{
    @Id
    private int id;
    private String date;
    private String title;
    private String time;
    
    private String status;
    
    public Activities(int id, String date, String title, String time ,String status) 
    {
        this.id = id;
        this.date = date;
        this.title = title;
        this.time = time;
        this.status = status;
    }
    
    public Activities() 
    {
        
    }
    
    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }
    public int getId() 
    {
        return id;
    }

    public void setId(int id) 
    {
        this.id = id;
    }

    public String getDate() 
    {
        return date;
    }

    public void setDate(String date) 
    {
        this.date = date;
    }

    public String getTitle() 
    {
        return title;
    }

    public void setTitle(String title) 
    {
        this.title = title;
    }

    public String getStatus() 
    {
        return status;
    }

    public void setStatus(String status) 
    {
        this.status = status;
    }

    @Override
    public String toString() 
    {
        return "Activities [id=" + id + ", date=" + date + ", title=" + title + ", time=" + time + ", status=" + status + "]";
    }
    

    
}

package com.pratham.todo.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pratham.todo.entities.Activities;

public interface ActivityDao extends JpaRepository<Activities, Integer>
{

    
} 

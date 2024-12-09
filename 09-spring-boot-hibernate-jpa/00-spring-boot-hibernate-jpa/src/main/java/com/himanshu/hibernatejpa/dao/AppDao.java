package com.himanshu.hibernatejpa.dao;

import com.himanshu.hibernatejpa.entity.Instructor;

public interface AppDao {
    void save(Instructor instructor);

    Instructor findById(int id);
}

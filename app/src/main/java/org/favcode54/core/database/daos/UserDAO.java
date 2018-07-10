package org.favcode54.core.database.daos;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import org.favcode54.core.database.entities.User;

import io.reactivex.Flowable;

@Dao
public interface UserDAO {
    @Insert
    void insertUser(User user);

    @Delete
    void deleteUser(User user);

    @Query("SELECT * FROM User WHERE `Logged In` = 1")
    Flowable<User> getUser();
}

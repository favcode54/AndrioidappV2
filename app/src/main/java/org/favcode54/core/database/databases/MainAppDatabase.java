package org.favcode54.core.database.databases;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;

import org.favcode54.core.database.daos.UserDAO;
import org.favcode54.core.database.entities.User;

@Database(entities = {User.class}, version = 1)
public abstract class MainAppDatabase extends RoomDatabase {
    public abstract UserDAO getUserDAO();
}

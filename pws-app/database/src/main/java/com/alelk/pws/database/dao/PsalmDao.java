package com.alelk.pws.database.dao;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;

import com.alelk.pws.database.model.Psalm;

/**
 * Psalm Dao
 *
 * Created by Alex Elkin on 03.10.2017.
 */
@Dao
public interface PsalmDao {

    @Insert (onConflict = OnConflictStrategy.REPLACE)
    void save(Psalm psalm);

    @Query("SELECT * from psalms WHERE id = :psalmId")
    LiveData<Psalm> load(int psalmId);
}

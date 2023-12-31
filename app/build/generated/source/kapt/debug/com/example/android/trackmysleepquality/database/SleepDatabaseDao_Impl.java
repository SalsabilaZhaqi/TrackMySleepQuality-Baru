package com.example.android.trackmysleepquality.database;

import android.database.Cursor;
import androidx.lifecycle.LiveData;
import androidx.room.EntityDeletionOrUpdateAdapter;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.SharedSQLiteStatement;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.sqlite.db.SupportSQLiteStatement;
import java.lang.Exception;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;

@SuppressWarnings({"unchecked", "deprecation"})
public final class SleepDatabaseDao_Impl implements SleepDatabaseDao {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter<SleepNight> __insertionAdapterOfSleepNight;

  private final EntityDeletionOrUpdateAdapter<SleepNight> __updateAdapterOfSleepNight;

  private final SharedSQLiteStatement __preparedStmtOfClear;

  public SleepDatabaseDao_Impl(RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfSleepNight = new EntityInsertionAdapter<SleepNight>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR ABORT INTO `daily_sleep_quality_table` (`nightId`,`start_time_milli`,`end_time_milli`,`quality_rating`) VALUES (nullif(?, 0),?,?,?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, SleepNight value) {
        stmt.bindLong(1, value.getNightId());
        stmt.bindLong(2, value.getStartTimeMilli());
        stmt.bindLong(3, value.getEndTimeMilli());
        stmt.bindLong(4, value.getSleepQuality());
      }
    };
    this.__updateAdapterOfSleepNight = new EntityDeletionOrUpdateAdapter<SleepNight>(__db) {
      @Override
      public String createQuery() {
        return "UPDATE OR ABORT `daily_sleep_quality_table` SET `nightId` = ?,`start_time_milli` = ?,`end_time_milli` = ?,`quality_rating` = ? WHERE `nightId` = ?";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, SleepNight value) {
        stmt.bindLong(1, value.getNightId());
        stmt.bindLong(2, value.getStartTimeMilli());
        stmt.bindLong(3, value.getEndTimeMilli());
        stmt.bindLong(4, value.getSleepQuality());
        stmt.bindLong(5, value.getNightId());
      }
    };
    this.__preparedStmtOfClear = new SharedSQLiteStatement(__db) {
      @Override
      public String createQuery() {
        final String _query = "DELETE FROM daily_sleep_quality_table";
        return _query;
      }
    };
  }

  @Override
  public void insert(final SleepNight night) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __insertionAdapterOfSleepNight.insert(night);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void update(final SleepNight night) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __updateAdapterOfSleepNight.handle(night);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void clear() {
    __db.assertNotSuspendingTransaction();
    final SupportSQLiteStatement _stmt = __preparedStmtOfClear.acquire();
    __db.beginTransaction();
    try {
      _stmt.executeUpdateDelete();
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
      __preparedStmtOfClear.release(_stmt);
    }
  }

  @Override
  public SleepNight get(final long key) {
    final String _sql = "SELECT * from daily_sleep_quality_table WHERE nightId = ?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    _statement.bindLong(_argIndex, key);
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _cursorIndexOfNightId = CursorUtil.getColumnIndexOrThrow(_cursor, "nightId");
      final int _cursorIndexOfStartTimeMilli = CursorUtil.getColumnIndexOrThrow(_cursor, "start_time_milli");
      final int _cursorIndexOfEndTimeMilli = CursorUtil.getColumnIndexOrThrow(_cursor, "end_time_milli");
      final int _cursorIndexOfSleepQuality = CursorUtil.getColumnIndexOrThrow(_cursor, "quality_rating");
      final SleepNight _result;
      if(_cursor.moveToFirst()) {
        _result = new SleepNight();
        final long _tmpNightId;
        _tmpNightId = _cursor.getLong(_cursorIndexOfNightId);
        _result.setNightId(_tmpNightId);
        final long _tmpStartTimeMilli;
        _tmpStartTimeMilli = _cursor.getLong(_cursorIndexOfStartTimeMilli);
        _result.setStartTimeMilli(_tmpStartTimeMilli);
        final long _tmpEndTimeMilli;
        _tmpEndTimeMilli = _cursor.getLong(_cursorIndexOfEndTimeMilli);
        _result.setEndTimeMilli(_tmpEndTimeMilli);
        final int _tmpSleepQuality;
        _tmpSleepQuality = _cursor.getInt(_cursorIndexOfSleepQuality);
        _result.setSleepQuality(_tmpSleepQuality);
      } else {
        _result = null;
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }

  @Override
  public SleepNight getTonight() {
    final String _sql = "SELECT * FROM daily_sleep_quality_table ORDER BY nightId DESC LIMIT 1";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _cursorIndexOfNightId = CursorUtil.getColumnIndexOrThrow(_cursor, "nightId");
      final int _cursorIndexOfStartTimeMilli = CursorUtil.getColumnIndexOrThrow(_cursor, "start_time_milli");
      final int _cursorIndexOfEndTimeMilli = CursorUtil.getColumnIndexOrThrow(_cursor, "end_time_milli");
      final int _cursorIndexOfSleepQuality = CursorUtil.getColumnIndexOrThrow(_cursor, "quality_rating");
      final SleepNight _result;
      if(_cursor.moveToFirst()) {
        _result = new SleepNight();
        final long _tmpNightId;
        _tmpNightId = _cursor.getLong(_cursorIndexOfNightId);
        _result.setNightId(_tmpNightId);
        final long _tmpStartTimeMilli;
        _tmpStartTimeMilli = _cursor.getLong(_cursorIndexOfStartTimeMilli);
        _result.setStartTimeMilli(_tmpStartTimeMilli);
        final long _tmpEndTimeMilli;
        _tmpEndTimeMilli = _cursor.getLong(_cursorIndexOfEndTimeMilli);
        _result.setEndTimeMilli(_tmpEndTimeMilli);
        final int _tmpSleepQuality;
        _tmpSleepQuality = _cursor.getInt(_cursorIndexOfSleepQuality);
        _result.setSleepQuality(_tmpSleepQuality);
      } else {
        _result = null;
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }

  @Override
  public LiveData<List<SleepNight>> getAllNights() {
    final String _sql = "SELECT * FROM daily_sleep_quality_table ORDER BY nightId DESC";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    return __db.getInvalidationTracker().createLiveData(new String[]{"daily_sleep_quality_table"}, false, new Callable<List<SleepNight>>() {
      @Override
      public List<SleepNight> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfNightId = CursorUtil.getColumnIndexOrThrow(_cursor, "nightId");
          final int _cursorIndexOfStartTimeMilli = CursorUtil.getColumnIndexOrThrow(_cursor, "start_time_milli");
          final int _cursorIndexOfEndTimeMilli = CursorUtil.getColumnIndexOrThrow(_cursor, "end_time_milli");
          final int _cursorIndexOfSleepQuality = CursorUtil.getColumnIndexOrThrow(_cursor, "quality_rating");
          final List<SleepNight> _result = new ArrayList<SleepNight>(_cursor.getCount());
          while(_cursor.moveToNext()) {
            final SleepNight _item;
            _item = new SleepNight();
            final long _tmpNightId;
            _tmpNightId = _cursor.getLong(_cursorIndexOfNightId);
            _item.setNightId(_tmpNightId);
            final long _tmpStartTimeMilli;
            _tmpStartTimeMilli = _cursor.getLong(_cursorIndexOfStartTimeMilli);
            _item.setStartTimeMilli(_tmpStartTimeMilli);
            final long _tmpEndTimeMilli;
            _tmpEndTimeMilli = _cursor.getLong(_cursorIndexOfEndTimeMilli);
            _item.setEndTimeMilli(_tmpEndTimeMilli);
            final int _tmpSleepQuality;
            _tmpSleepQuality = _cursor.getInt(_cursorIndexOfSleepQuality);
            _item.setSleepQuality(_tmpSleepQuality);
            _result.add(_item);
          }
          return _result;
        } finally {
          _cursor.close();
        }
      }

      @Override
      protected void finalize() {
        _statement.release();
      }
    });
  }
}

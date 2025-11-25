package com.raquetel.app.data.local.dao;

import android.database.Cursor;
import android.os.CancellationSignal;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.room.CoroutinesRoom;
import androidx.room.EntityDeletionOrUpdateAdapter;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.SharedSQLiteStatement;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.room.util.StringUtil;
import androidx.sqlite.db.SupportSQLiteStatement;
import com.raquetel.app.data.local.database.Converters;
import com.raquetel.app.data.local.entities.BookingEntity;
import java.lang.Class;
import java.lang.Exception;
import java.lang.IllegalStateException;
import java.lang.Long;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.lang.StringBuilder;
import java.lang.SuppressWarnings;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Callable;
import javax.annotation.processing.Generated;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.flow.Flow;

@Generated("androidx.room.RoomProcessor")
@SuppressWarnings({"unchecked", "deprecation"})
public final class BookingDao_Impl implements BookingDao {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter<BookingEntity> __insertionAdapterOfBookingEntity;

  private final Converters __converters = new Converters();

  private final EntityDeletionOrUpdateAdapter<BookingEntity> __deletionAdapterOfBookingEntity;

  private final EntityDeletionOrUpdateAdapter<BookingEntity> __updateAdapterOfBookingEntity;

  private final SharedSQLiteStatement __preparedStmtOfDeleteBookingById;

  public BookingDao_Impl(@NonNull final RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfBookingEntity = new EntityInsertionAdapter<BookingEntity>(__db) {
      @Override
      @NonNull
      protected String createQuery() {
        return "INSERT OR REPLACE INTO `bookings` (`id`,`customerId`,`courtId`,`bookingDate`,`startTime`,`endTime`,`durationHours`,`totalAmount`,`status`,`checkInTime`,`cancellationReason`,`createdAt`,`updatedAt`) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?)";
      }

      @Override
      protected void bind(@NonNull final SupportSQLiteStatement statement,
          @NonNull final BookingEntity entity) {
        statement.bindString(1, entity.getId());
        statement.bindString(2, entity.getCustomerId());
        statement.bindString(3, entity.getCourtId());
        final String _tmp = __converters.fromLocalDate(entity.getBookingDate());
        if (_tmp == null) {
          statement.bindNull(4);
        } else {
          statement.bindString(4, _tmp);
        }
        final String _tmp_1 = __converters.fromLocalTime(entity.getStartTime());
        if (_tmp_1 == null) {
          statement.bindNull(5);
        } else {
          statement.bindString(5, _tmp_1);
        }
        final String _tmp_2 = __converters.fromLocalTime(entity.getEndTime());
        if (_tmp_2 == null) {
          statement.bindNull(6);
        } else {
          statement.bindString(6, _tmp_2);
        }
        statement.bindDouble(7, entity.getDurationHours());
        statement.bindDouble(8, entity.getTotalAmount());
        statement.bindString(9, entity.getStatus());
        if (entity.getCheckInTime() == null) {
          statement.bindNull(10);
        } else {
          statement.bindLong(10, entity.getCheckInTime());
        }
        if (entity.getCancellationReason() == null) {
          statement.bindNull(11);
        } else {
          statement.bindString(11, entity.getCancellationReason());
        }
        statement.bindLong(12, entity.getCreatedAt());
        statement.bindLong(13, entity.getUpdatedAt());
      }
    };
    this.__deletionAdapterOfBookingEntity = new EntityDeletionOrUpdateAdapter<BookingEntity>(__db) {
      @Override
      @NonNull
      protected String createQuery() {
        return "DELETE FROM `bookings` WHERE `id` = ?";
      }

      @Override
      protected void bind(@NonNull final SupportSQLiteStatement statement,
          @NonNull final BookingEntity entity) {
        statement.bindString(1, entity.getId());
      }
    };
    this.__updateAdapterOfBookingEntity = new EntityDeletionOrUpdateAdapter<BookingEntity>(__db) {
      @Override
      @NonNull
      protected String createQuery() {
        return "UPDATE OR ABORT `bookings` SET `id` = ?,`customerId` = ?,`courtId` = ?,`bookingDate` = ?,`startTime` = ?,`endTime` = ?,`durationHours` = ?,`totalAmount` = ?,`status` = ?,`checkInTime` = ?,`cancellationReason` = ?,`createdAt` = ?,`updatedAt` = ? WHERE `id` = ?";
      }

      @Override
      protected void bind(@NonNull final SupportSQLiteStatement statement,
          @NonNull final BookingEntity entity) {
        statement.bindString(1, entity.getId());
        statement.bindString(2, entity.getCustomerId());
        statement.bindString(3, entity.getCourtId());
        final String _tmp = __converters.fromLocalDate(entity.getBookingDate());
        if (_tmp == null) {
          statement.bindNull(4);
        } else {
          statement.bindString(4, _tmp);
        }
        final String _tmp_1 = __converters.fromLocalTime(entity.getStartTime());
        if (_tmp_1 == null) {
          statement.bindNull(5);
        } else {
          statement.bindString(5, _tmp_1);
        }
        final String _tmp_2 = __converters.fromLocalTime(entity.getEndTime());
        if (_tmp_2 == null) {
          statement.bindNull(6);
        } else {
          statement.bindString(6, _tmp_2);
        }
        statement.bindDouble(7, entity.getDurationHours());
        statement.bindDouble(8, entity.getTotalAmount());
        statement.bindString(9, entity.getStatus());
        if (entity.getCheckInTime() == null) {
          statement.bindNull(10);
        } else {
          statement.bindLong(10, entity.getCheckInTime());
        }
        if (entity.getCancellationReason() == null) {
          statement.bindNull(11);
        } else {
          statement.bindString(11, entity.getCancellationReason());
        }
        statement.bindLong(12, entity.getCreatedAt());
        statement.bindLong(13, entity.getUpdatedAt());
        statement.bindString(14, entity.getId());
      }
    };
    this.__preparedStmtOfDeleteBookingById = new SharedSQLiteStatement(__db) {
      @Override
      @NonNull
      public String createQuery() {
        final String _query = "DELETE FROM bookings WHERE id = ?";
        return _query;
      }
    };
  }

  @Override
  public Object insertBooking(final BookingEntity booking,
      final Continuation<? super Unit> $completion) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      @NonNull
      public Unit call() throws Exception {
        __db.beginTransaction();
        try {
          __insertionAdapterOfBookingEntity.insert(booking);
          __db.setTransactionSuccessful();
          return Unit.INSTANCE;
        } finally {
          __db.endTransaction();
        }
      }
    }, $completion);
  }

  @Override
  public Object deleteBooking(final BookingEntity booking,
      final Continuation<? super Unit> $completion) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      @NonNull
      public Unit call() throws Exception {
        __db.beginTransaction();
        try {
          __deletionAdapterOfBookingEntity.handle(booking);
          __db.setTransactionSuccessful();
          return Unit.INSTANCE;
        } finally {
          __db.endTransaction();
        }
      }
    }, $completion);
  }

  @Override
  public Object updateBooking(final BookingEntity booking,
      final Continuation<? super Unit> $completion) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      @NonNull
      public Unit call() throws Exception {
        __db.beginTransaction();
        try {
          __updateAdapterOfBookingEntity.handle(booking);
          __db.setTransactionSuccessful();
          return Unit.INSTANCE;
        } finally {
          __db.endTransaction();
        }
      }
    }, $completion);
  }

  @Override
  public Object deleteBookingById(final String bookingId,
      final Continuation<? super Unit> $completion) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      @NonNull
      public Unit call() throws Exception {
        final SupportSQLiteStatement _stmt = __preparedStmtOfDeleteBookingById.acquire();
        int _argIndex = 1;
        _stmt.bindString(_argIndex, bookingId);
        try {
          __db.beginTransaction();
          try {
            _stmt.executeUpdateDelete();
            __db.setTransactionSuccessful();
            return Unit.INSTANCE;
          } finally {
            __db.endTransaction();
          }
        } finally {
          __preparedStmtOfDeleteBookingById.release(_stmt);
        }
      }
    }, $completion);
  }

  @Override
  public Flow<List<BookingEntity>> getAllBookings() {
    final String _sql = "SELECT * FROM bookings ORDER BY bookingDate DESC, startTime DESC";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    return CoroutinesRoom.createFlow(__db, false, new String[] {"bookings"}, new Callable<List<BookingEntity>>() {
      @Override
      @NonNull
      public List<BookingEntity> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
          final int _cursorIndexOfCustomerId = CursorUtil.getColumnIndexOrThrow(_cursor, "customerId");
          final int _cursorIndexOfCourtId = CursorUtil.getColumnIndexOrThrow(_cursor, "courtId");
          final int _cursorIndexOfBookingDate = CursorUtil.getColumnIndexOrThrow(_cursor, "bookingDate");
          final int _cursorIndexOfStartTime = CursorUtil.getColumnIndexOrThrow(_cursor, "startTime");
          final int _cursorIndexOfEndTime = CursorUtil.getColumnIndexOrThrow(_cursor, "endTime");
          final int _cursorIndexOfDurationHours = CursorUtil.getColumnIndexOrThrow(_cursor, "durationHours");
          final int _cursorIndexOfTotalAmount = CursorUtil.getColumnIndexOrThrow(_cursor, "totalAmount");
          final int _cursorIndexOfStatus = CursorUtil.getColumnIndexOrThrow(_cursor, "status");
          final int _cursorIndexOfCheckInTime = CursorUtil.getColumnIndexOrThrow(_cursor, "checkInTime");
          final int _cursorIndexOfCancellationReason = CursorUtil.getColumnIndexOrThrow(_cursor, "cancellationReason");
          final int _cursorIndexOfCreatedAt = CursorUtil.getColumnIndexOrThrow(_cursor, "createdAt");
          final int _cursorIndexOfUpdatedAt = CursorUtil.getColumnIndexOrThrow(_cursor, "updatedAt");
          final List<BookingEntity> _result = new ArrayList<BookingEntity>(_cursor.getCount());
          while (_cursor.moveToNext()) {
            final BookingEntity _item;
            final String _tmpId;
            _tmpId = _cursor.getString(_cursorIndexOfId);
            final String _tmpCustomerId;
            _tmpCustomerId = _cursor.getString(_cursorIndexOfCustomerId);
            final String _tmpCourtId;
            _tmpCourtId = _cursor.getString(_cursorIndexOfCourtId);
            final LocalDate _tmpBookingDate;
            final String _tmp;
            if (_cursor.isNull(_cursorIndexOfBookingDate)) {
              _tmp = null;
            } else {
              _tmp = _cursor.getString(_cursorIndexOfBookingDate);
            }
            final LocalDate _tmp_1 = __converters.toLocalDate(_tmp);
            if (_tmp_1 == null) {
              throw new IllegalStateException("Expected NON-NULL 'java.time.LocalDate', but it was NULL.");
            } else {
              _tmpBookingDate = _tmp_1;
            }
            final LocalTime _tmpStartTime;
            final String _tmp_2;
            if (_cursor.isNull(_cursorIndexOfStartTime)) {
              _tmp_2 = null;
            } else {
              _tmp_2 = _cursor.getString(_cursorIndexOfStartTime);
            }
            final LocalTime _tmp_3 = __converters.toLocalTime(_tmp_2);
            if (_tmp_3 == null) {
              throw new IllegalStateException("Expected NON-NULL 'java.time.LocalTime', but it was NULL.");
            } else {
              _tmpStartTime = _tmp_3;
            }
            final LocalTime _tmpEndTime;
            final String _tmp_4;
            if (_cursor.isNull(_cursorIndexOfEndTime)) {
              _tmp_4 = null;
            } else {
              _tmp_4 = _cursor.getString(_cursorIndexOfEndTime);
            }
            final LocalTime _tmp_5 = __converters.toLocalTime(_tmp_4);
            if (_tmp_5 == null) {
              throw new IllegalStateException("Expected NON-NULL 'java.time.LocalTime', but it was NULL.");
            } else {
              _tmpEndTime = _tmp_5;
            }
            final float _tmpDurationHours;
            _tmpDurationHours = _cursor.getFloat(_cursorIndexOfDurationHours);
            final double _tmpTotalAmount;
            _tmpTotalAmount = _cursor.getDouble(_cursorIndexOfTotalAmount);
            final String _tmpStatus;
            _tmpStatus = _cursor.getString(_cursorIndexOfStatus);
            final Long _tmpCheckInTime;
            if (_cursor.isNull(_cursorIndexOfCheckInTime)) {
              _tmpCheckInTime = null;
            } else {
              _tmpCheckInTime = _cursor.getLong(_cursorIndexOfCheckInTime);
            }
            final String _tmpCancellationReason;
            if (_cursor.isNull(_cursorIndexOfCancellationReason)) {
              _tmpCancellationReason = null;
            } else {
              _tmpCancellationReason = _cursor.getString(_cursorIndexOfCancellationReason);
            }
            final long _tmpCreatedAt;
            _tmpCreatedAt = _cursor.getLong(_cursorIndexOfCreatedAt);
            final long _tmpUpdatedAt;
            _tmpUpdatedAt = _cursor.getLong(_cursorIndexOfUpdatedAt);
            _item = new BookingEntity(_tmpId,_tmpCustomerId,_tmpCourtId,_tmpBookingDate,_tmpStartTime,_tmpEndTime,_tmpDurationHours,_tmpTotalAmount,_tmpStatus,_tmpCheckInTime,_tmpCancellationReason,_tmpCreatedAt,_tmpUpdatedAt);
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

  @Override
  public Object getBookingById(final String bookingId,
      final Continuation<? super BookingEntity> $completion) {
    final String _sql = "SELECT * FROM bookings WHERE id = ?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    _statement.bindString(_argIndex, bookingId);
    final CancellationSignal _cancellationSignal = DBUtil.createCancellationSignal();
    return CoroutinesRoom.execute(__db, false, _cancellationSignal, new Callable<BookingEntity>() {
      @Override
      @Nullable
      public BookingEntity call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
          final int _cursorIndexOfCustomerId = CursorUtil.getColumnIndexOrThrow(_cursor, "customerId");
          final int _cursorIndexOfCourtId = CursorUtil.getColumnIndexOrThrow(_cursor, "courtId");
          final int _cursorIndexOfBookingDate = CursorUtil.getColumnIndexOrThrow(_cursor, "bookingDate");
          final int _cursorIndexOfStartTime = CursorUtil.getColumnIndexOrThrow(_cursor, "startTime");
          final int _cursorIndexOfEndTime = CursorUtil.getColumnIndexOrThrow(_cursor, "endTime");
          final int _cursorIndexOfDurationHours = CursorUtil.getColumnIndexOrThrow(_cursor, "durationHours");
          final int _cursorIndexOfTotalAmount = CursorUtil.getColumnIndexOrThrow(_cursor, "totalAmount");
          final int _cursorIndexOfStatus = CursorUtil.getColumnIndexOrThrow(_cursor, "status");
          final int _cursorIndexOfCheckInTime = CursorUtil.getColumnIndexOrThrow(_cursor, "checkInTime");
          final int _cursorIndexOfCancellationReason = CursorUtil.getColumnIndexOrThrow(_cursor, "cancellationReason");
          final int _cursorIndexOfCreatedAt = CursorUtil.getColumnIndexOrThrow(_cursor, "createdAt");
          final int _cursorIndexOfUpdatedAt = CursorUtil.getColumnIndexOrThrow(_cursor, "updatedAt");
          final BookingEntity _result;
          if (_cursor.moveToFirst()) {
            final String _tmpId;
            _tmpId = _cursor.getString(_cursorIndexOfId);
            final String _tmpCustomerId;
            _tmpCustomerId = _cursor.getString(_cursorIndexOfCustomerId);
            final String _tmpCourtId;
            _tmpCourtId = _cursor.getString(_cursorIndexOfCourtId);
            final LocalDate _tmpBookingDate;
            final String _tmp;
            if (_cursor.isNull(_cursorIndexOfBookingDate)) {
              _tmp = null;
            } else {
              _tmp = _cursor.getString(_cursorIndexOfBookingDate);
            }
            final LocalDate _tmp_1 = __converters.toLocalDate(_tmp);
            if (_tmp_1 == null) {
              throw new IllegalStateException("Expected NON-NULL 'java.time.LocalDate', but it was NULL.");
            } else {
              _tmpBookingDate = _tmp_1;
            }
            final LocalTime _tmpStartTime;
            final String _tmp_2;
            if (_cursor.isNull(_cursorIndexOfStartTime)) {
              _tmp_2 = null;
            } else {
              _tmp_2 = _cursor.getString(_cursorIndexOfStartTime);
            }
            final LocalTime _tmp_3 = __converters.toLocalTime(_tmp_2);
            if (_tmp_3 == null) {
              throw new IllegalStateException("Expected NON-NULL 'java.time.LocalTime', but it was NULL.");
            } else {
              _tmpStartTime = _tmp_3;
            }
            final LocalTime _tmpEndTime;
            final String _tmp_4;
            if (_cursor.isNull(_cursorIndexOfEndTime)) {
              _tmp_4 = null;
            } else {
              _tmp_4 = _cursor.getString(_cursorIndexOfEndTime);
            }
            final LocalTime _tmp_5 = __converters.toLocalTime(_tmp_4);
            if (_tmp_5 == null) {
              throw new IllegalStateException("Expected NON-NULL 'java.time.LocalTime', but it was NULL.");
            } else {
              _tmpEndTime = _tmp_5;
            }
            final float _tmpDurationHours;
            _tmpDurationHours = _cursor.getFloat(_cursorIndexOfDurationHours);
            final double _tmpTotalAmount;
            _tmpTotalAmount = _cursor.getDouble(_cursorIndexOfTotalAmount);
            final String _tmpStatus;
            _tmpStatus = _cursor.getString(_cursorIndexOfStatus);
            final Long _tmpCheckInTime;
            if (_cursor.isNull(_cursorIndexOfCheckInTime)) {
              _tmpCheckInTime = null;
            } else {
              _tmpCheckInTime = _cursor.getLong(_cursorIndexOfCheckInTime);
            }
            final String _tmpCancellationReason;
            if (_cursor.isNull(_cursorIndexOfCancellationReason)) {
              _tmpCancellationReason = null;
            } else {
              _tmpCancellationReason = _cursor.getString(_cursorIndexOfCancellationReason);
            }
            final long _tmpCreatedAt;
            _tmpCreatedAt = _cursor.getLong(_cursorIndexOfCreatedAt);
            final long _tmpUpdatedAt;
            _tmpUpdatedAt = _cursor.getLong(_cursorIndexOfUpdatedAt);
            _result = new BookingEntity(_tmpId,_tmpCustomerId,_tmpCourtId,_tmpBookingDate,_tmpStartTime,_tmpEndTime,_tmpDurationHours,_tmpTotalAmount,_tmpStatus,_tmpCheckInTime,_tmpCancellationReason,_tmpCreatedAt,_tmpUpdatedAt);
          } else {
            _result = null;
          }
          return _result;
        } finally {
          _cursor.close();
          _statement.release();
        }
      }
    }, $completion);
  }

  @Override
  public Flow<List<BookingEntity>> getBookingsByCustomer(final String customerId) {
    final String _sql = "SELECT * FROM bookings WHERE customerId = ? ORDER BY bookingDate DESC";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    _statement.bindString(_argIndex, customerId);
    return CoroutinesRoom.createFlow(__db, false, new String[] {"bookings"}, new Callable<List<BookingEntity>>() {
      @Override
      @NonNull
      public List<BookingEntity> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
          final int _cursorIndexOfCustomerId = CursorUtil.getColumnIndexOrThrow(_cursor, "customerId");
          final int _cursorIndexOfCourtId = CursorUtil.getColumnIndexOrThrow(_cursor, "courtId");
          final int _cursorIndexOfBookingDate = CursorUtil.getColumnIndexOrThrow(_cursor, "bookingDate");
          final int _cursorIndexOfStartTime = CursorUtil.getColumnIndexOrThrow(_cursor, "startTime");
          final int _cursorIndexOfEndTime = CursorUtil.getColumnIndexOrThrow(_cursor, "endTime");
          final int _cursorIndexOfDurationHours = CursorUtil.getColumnIndexOrThrow(_cursor, "durationHours");
          final int _cursorIndexOfTotalAmount = CursorUtil.getColumnIndexOrThrow(_cursor, "totalAmount");
          final int _cursorIndexOfStatus = CursorUtil.getColumnIndexOrThrow(_cursor, "status");
          final int _cursorIndexOfCheckInTime = CursorUtil.getColumnIndexOrThrow(_cursor, "checkInTime");
          final int _cursorIndexOfCancellationReason = CursorUtil.getColumnIndexOrThrow(_cursor, "cancellationReason");
          final int _cursorIndexOfCreatedAt = CursorUtil.getColumnIndexOrThrow(_cursor, "createdAt");
          final int _cursorIndexOfUpdatedAt = CursorUtil.getColumnIndexOrThrow(_cursor, "updatedAt");
          final List<BookingEntity> _result = new ArrayList<BookingEntity>(_cursor.getCount());
          while (_cursor.moveToNext()) {
            final BookingEntity _item;
            final String _tmpId;
            _tmpId = _cursor.getString(_cursorIndexOfId);
            final String _tmpCustomerId;
            _tmpCustomerId = _cursor.getString(_cursorIndexOfCustomerId);
            final String _tmpCourtId;
            _tmpCourtId = _cursor.getString(_cursorIndexOfCourtId);
            final LocalDate _tmpBookingDate;
            final String _tmp;
            if (_cursor.isNull(_cursorIndexOfBookingDate)) {
              _tmp = null;
            } else {
              _tmp = _cursor.getString(_cursorIndexOfBookingDate);
            }
            final LocalDate _tmp_1 = __converters.toLocalDate(_tmp);
            if (_tmp_1 == null) {
              throw new IllegalStateException("Expected NON-NULL 'java.time.LocalDate', but it was NULL.");
            } else {
              _tmpBookingDate = _tmp_1;
            }
            final LocalTime _tmpStartTime;
            final String _tmp_2;
            if (_cursor.isNull(_cursorIndexOfStartTime)) {
              _tmp_2 = null;
            } else {
              _tmp_2 = _cursor.getString(_cursorIndexOfStartTime);
            }
            final LocalTime _tmp_3 = __converters.toLocalTime(_tmp_2);
            if (_tmp_3 == null) {
              throw new IllegalStateException("Expected NON-NULL 'java.time.LocalTime', but it was NULL.");
            } else {
              _tmpStartTime = _tmp_3;
            }
            final LocalTime _tmpEndTime;
            final String _tmp_4;
            if (_cursor.isNull(_cursorIndexOfEndTime)) {
              _tmp_4 = null;
            } else {
              _tmp_4 = _cursor.getString(_cursorIndexOfEndTime);
            }
            final LocalTime _tmp_5 = __converters.toLocalTime(_tmp_4);
            if (_tmp_5 == null) {
              throw new IllegalStateException("Expected NON-NULL 'java.time.LocalTime', but it was NULL.");
            } else {
              _tmpEndTime = _tmp_5;
            }
            final float _tmpDurationHours;
            _tmpDurationHours = _cursor.getFloat(_cursorIndexOfDurationHours);
            final double _tmpTotalAmount;
            _tmpTotalAmount = _cursor.getDouble(_cursorIndexOfTotalAmount);
            final String _tmpStatus;
            _tmpStatus = _cursor.getString(_cursorIndexOfStatus);
            final Long _tmpCheckInTime;
            if (_cursor.isNull(_cursorIndexOfCheckInTime)) {
              _tmpCheckInTime = null;
            } else {
              _tmpCheckInTime = _cursor.getLong(_cursorIndexOfCheckInTime);
            }
            final String _tmpCancellationReason;
            if (_cursor.isNull(_cursorIndexOfCancellationReason)) {
              _tmpCancellationReason = null;
            } else {
              _tmpCancellationReason = _cursor.getString(_cursorIndexOfCancellationReason);
            }
            final long _tmpCreatedAt;
            _tmpCreatedAt = _cursor.getLong(_cursorIndexOfCreatedAt);
            final long _tmpUpdatedAt;
            _tmpUpdatedAt = _cursor.getLong(_cursorIndexOfUpdatedAt);
            _item = new BookingEntity(_tmpId,_tmpCustomerId,_tmpCourtId,_tmpBookingDate,_tmpStartTime,_tmpEndTime,_tmpDurationHours,_tmpTotalAmount,_tmpStatus,_tmpCheckInTime,_tmpCancellationReason,_tmpCreatedAt,_tmpUpdatedAt);
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

  @Override
  public Flow<List<BookingEntity>> getBookingsByCourtAndDate(final String courtId,
      final LocalDate date) {
    final String _sql = "SELECT * FROM bookings WHERE courtId = ? AND bookingDate = ? ORDER BY startTime ASC";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 2);
    int _argIndex = 1;
    _statement.bindString(_argIndex, courtId);
    _argIndex = 2;
    final String _tmp = __converters.fromLocalDate(date);
    if (_tmp == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, _tmp);
    }
    return CoroutinesRoom.createFlow(__db, false, new String[] {"bookings"}, new Callable<List<BookingEntity>>() {
      @Override
      @NonNull
      public List<BookingEntity> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
          final int _cursorIndexOfCustomerId = CursorUtil.getColumnIndexOrThrow(_cursor, "customerId");
          final int _cursorIndexOfCourtId = CursorUtil.getColumnIndexOrThrow(_cursor, "courtId");
          final int _cursorIndexOfBookingDate = CursorUtil.getColumnIndexOrThrow(_cursor, "bookingDate");
          final int _cursorIndexOfStartTime = CursorUtil.getColumnIndexOrThrow(_cursor, "startTime");
          final int _cursorIndexOfEndTime = CursorUtil.getColumnIndexOrThrow(_cursor, "endTime");
          final int _cursorIndexOfDurationHours = CursorUtil.getColumnIndexOrThrow(_cursor, "durationHours");
          final int _cursorIndexOfTotalAmount = CursorUtil.getColumnIndexOrThrow(_cursor, "totalAmount");
          final int _cursorIndexOfStatus = CursorUtil.getColumnIndexOrThrow(_cursor, "status");
          final int _cursorIndexOfCheckInTime = CursorUtil.getColumnIndexOrThrow(_cursor, "checkInTime");
          final int _cursorIndexOfCancellationReason = CursorUtil.getColumnIndexOrThrow(_cursor, "cancellationReason");
          final int _cursorIndexOfCreatedAt = CursorUtil.getColumnIndexOrThrow(_cursor, "createdAt");
          final int _cursorIndexOfUpdatedAt = CursorUtil.getColumnIndexOrThrow(_cursor, "updatedAt");
          final List<BookingEntity> _result = new ArrayList<BookingEntity>(_cursor.getCount());
          while (_cursor.moveToNext()) {
            final BookingEntity _item;
            final String _tmpId;
            _tmpId = _cursor.getString(_cursorIndexOfId);
            final String _tmpCustomerId;
            _tmpCustomerId = _cursor.getString(_cursorIndexOfCustomerId);
            final String _tmpCourtId;
            _tmpCourtId = _cursor.getString(_cursorIndexOfCourtId);
            final LocalDate _tmpBookingDate;
            final String _tmp_1;
            if (_cursor.isNull(_cursorIndexOfBookingDate)) {
              _tmp_1 = null;
            } else {
              _tmp_1 = _cursor.getString(_cursorIndexOfBookingDate);
            }
            final LocalDate _tmp_2 = __converters.toLocalDate(_tmp_1);
            if (_tmp_2 == null) {
              throw new IllegalStateException("Expected NON-NULL 'java.time.LocalDate', but it was NULL.");
            } else {
              _tmpBookingDate = _tmp_2;
            }
            final LocalTime _tmpStartTime;
            final String _tmp_3;
            if (_cursor.isNull(_cursorIndexOfStartTime)) {
              _tmp_3 = null;
            } else {
              _tmp_3 = _cursor.getString(_cursorIndexOfStartTime);
            }
            final LocalTime _tmp_4 = __converters.toLocalTime(_tmp_3);
            if (_tmp_4 == null) {
              throw new IllegalStateException("Expected NON-NULL 'java.time.LocalTime', but it was NULL.");
            } else {
              _tmpStartTime = _tmp_4;
            }
            final LocalTime _tmpEndTime;
            final String _tmp_5;
            if (_cursor.isNull(_cursorIndexOfEndTime)) {
              _tmp_5 = null;
            } else {
              _tmp_5 = _cursor.getString(_cursorIndexOfEndTime);
            }
            final LocalTime _tmp_6 = __converters.toLocalTime(_tmp_5);
            if (_tmp_6 == null) {
              throw new IllegalStateException("Expected NON-NULL 'java.time.LocalTime', but it was NULL.");
            } else {
              _tmpEndTime = _tmp_6;
            }
            final float _tmpDurationHours;
            _tmpDurationHours = _cursor.getFloat(_cursorIndexOfDurationHours);
            final double _tmpTotalAmount;
            _tmpTotalAmount = _cursor.getDouble(_cursorIndexOfTotalAmount);
            final String _tmpStatus;
            _tmpStatus = _cursor.getString(_cursorIndexOfStatus);
            final Long _tmpCheckInTime;
            if (_cursor.isNull(_cursorIndexOfCheckInTime)) {
              _tmpCheckInTime = null;
            } else {
              _tmpCheckInTime = _cursor.getLong(_cursorIndexOfCheckInTime);
            }
            final String _tmpCancellationReason;
            if (_cursor.isNull(_cursorIndexOfCancellationReason)) {
              _tmpCancellationReason = null;
            } else {
              _tmpCancellationReason = _cursor.getString(_cursorIndexOfCancellationReason);
            }
            final long _tmpCreatedAt;
            _tmpCreatedAt = _cursor.getLong(_cursorIndexOfCreatedAt);
            final long _tmpUpdatedAt;
            _tmpUpdatedAt = _cursor.getLong(_cursorIndexOfUpdatedAt);
            _item = new BookingEntity(_tmpId,_tmpCustomerId,_tmpCourtId,_tmpBookingDate,_tmpStartTime,_tmpEndTime,_tmpDurationHours,_tmpTotalAmount,_tmpStatus,_tmpCheckInTime,_tmpCancellationReason,_tmpCreatedAt,_tmpUpdatedAt);
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

  @Override
  public Flow<List<BookingEntity>> getBookingsByStatus(final List<String> statuses) {
    final StringBuilder _stringBuilder = StringUtil.newStringBuilder();
    _stringBuilder.append("SELECT * FROM bookings WHERE status IN (");
    final int _inputSize = statuses.size();
    StringUtil.appendPlaceholders(_stringBuilder, _inputSize);
    _stringBuilder.append(") ORDER BY bookingDate DESC");
    final String _sql = _stringBuilder.toString();
    final int _argCount = 0 + _inputSize;
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, _argCount);
    int _argIndex = 1;
    for (String _item : statuses) {
      _statement.bindString(_argIndex, _item);
      _argIndex++;
    }
    return CoroutinesRoom.createFlow(__db, false, new String[] {"bookings"}, new Callable<List<BookingEntity>>() {
      @Override
      @NonNull
      public List<BookingEntity> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
          final int _cursorIndexOfCustomerId = CursorUtil.getColumnIndexOrThrow(_cursor, "customerId");
          final int _cursorIndexOfCourtId = CursorUtil.getColumnIndexOrThrow(_cursor, "courtId");
          final int _cursorIndexOfBookingDate = CursorUtil.getColumnIndexOrThrow(_cursor, "bookingDate");
          final int _cursorIndexOfStartTime = CursorUtil.getColumnIndexOrThrow(_cursor, "startTime");
          final int _cursorIndexOfEndTime = CursorUtil.getColumnIndexOrThrow(_cursor, "endTime");
          final int _cursorIndexOfDurationHours = CursorUtil.getColumnIndexOrThrow(_cursor, "durationHours");
          final int _cursorIndexOfTotalAmount = CursorUtil.getColumnIndexOrThrow(_cursor, "totalAmount");
          final int _cursorIndexOfStatus = CursorUtil.getColumnIndexOrThrow(_cursor, "status");
          final int _cursorIndexOfCheckInTime = CursorUtil.getColumnIndexOrThrow(_cursor, "checkInTime");
          final int _cursorIndexOfCancellationReason = CursorUtil.getColumnIndexOrThrow(_cursor, "cancellationReason");
          final int _cursorIndexOfCreatedAt = CursorUtil.getColumnIndexOrThrow(_cursor, "createdAt");
          final int _cursorIndexOfUpdatedAt = CursorUtil.getColumnIndexOrThrow(_cursor, "updatedAt");
          final List<BookingEntity> _result = new ArrayList<BookingEntity>(_cursor.getCount());
          while (_cursor.moveToNext()) {
            final BookingEntity _item_1;
            final String _tmpId;
            _tmpId = _cursor.getString(_cursorIndexOfId);
            final String _tmpCustomerId;
            _tmpCustomerId = _cursor.getString(_cursorIndexOfCustomerId);
            final String _tmpCourtId;
            _tmpCourtId = _cursor.getString(_cursorIndexOfCourtId);
            final LocalDate _tmpBookingDate;
            final String _tmp;
            if (_cursor.isNull(_cursorIndexOfBookingDate)) {
              _tmp = null;
            } else {
              _tmp = _cursor.getString(_cursorIndexOfBookingDate);
            }
            final LocalDate _tmp_1 = __converters.toLocalDate(_tmp);
            if (_tmp_1 == null) {
              throw new IllegalStateException("Expected NON-NULL 'java.time.LocalDate', but it was NULL.");
            } else {
              _tmpBookingDate = _tmp_1;
            }
            final LocalTime _tmpStartTime;
            final String _tmp_2;
            if (_cursor.isNull(_cursorIndexOfStartTime)) {
              _tmp_2 = null;
            } else {
              _tmp_2 = _cursor.getString(_cursorIndexOfStartTime);
            }
            final LocalTime _tmp_3 = __converters.toLocalTime(_tmp_2);
            if (_tmp_3 == null) {
              throw new IllegalStateException("Expected NON-NULL 'java.time.LocalTime', but it was NULL.");
            } else {
              _tmpStartTime = _tmp_3;
            }
            final LocalTime _tmpEndTime;
            final String _tmp_4;
            if (_cursor.isNull(_cursorIndexOfEndTime)) {
              _tmp_4 = null;
            } else {
              _tmp_4 = _cursor.getString(_cursorIndexOfEndTime);
            }
            final LocalTime _tmp_5 = __converters.toLocalTime(_tmp_4);
            if (_tmp_5 == null) {
              throw new IllegalStateException("Expected NON-NULL 'java.time.LocalTime', but it was NULL.");
            } else {
              _tmpEndTime = _tmp_5;
            }
            final float _tmpDurationHours;
            _tmpDurationHours = _cursor.getFloat(_cursorIndexOfDurationHours);
            final double _tmpTotalAmount;
            _tmpTotalAmount = _cursor.getDouble(_cursorIndexOfTotalAmount);
            final String _tmpStatus;
            _tmpStatus = _cursor.getString(_cursorIndexOfStatus);
            final Long _tmpCheckInTime;
            if (_cursor.isNull(_cursorIndexOfCheckInTime)) {
              _tmpCheckInTime = null;
            } else {
              _tmpCheckInTime = _cursor.getLong(_cursorIndexOfCheckInTime);
            }
            final String _tmpCancellationReason;
            if (_cursor.isNull(_cursorIndexOfCancellationReason)) {
              _tmpCancellationReason = null;
            } else {
              _tmpCancellationReason = _cursor.getString(_cursorIndexOfCancellationReason);
            }
            final long _tmpCreatedAt;
            _tmpCreatedAt = _cursor.getLong(_cursorIndexOfCreatedAt);
            final long _tmpUpdatedAt;
            _tmpUpdatedAt = _cursor.getLong(_cursorIndexOfUpdatedAt);
            _item_1 = new BookingEntity(_tmpId,_tmpCustomerId,_tmpCourtId,_tmpBookingDate,_tmpStartTime,_tmpEndTime,_tmpDurationHours,_tmpTotalAmount,_tmpStatus,_tmpCheckInTime,_tmpCancellationReason,_tmpCreatedAt,_tmpUpdatedAt);
            _result.add(_item_1);
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

  @Override
  public Flow<List<BookingEntity>> getBookingsByDateRange(final LocalDate startDate,
      final LocalDate endDate) {
    final String _sql = "SELECT * FROM bookings WHERE bookingDate BETWEEN ? AND ? ORDER BY bookingDate DESC";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 2);
    int _argIndex = 1;
    final String _tmp = __converters.fromLocalDate(startDate);
    if (_tmp == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, _tmp);
    }
    _argIndex = 2;
    final String _tmp_1 = __converters.fromLocalDate(endDate);
    if (_tmp_1 == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, _tmp_1);
    }
    return CoroutinesRoom.createFlow(__db, false, new String[] {"bookings"}, new Callable<List<BookingEntity>>() {
      @Override
      @NonNull
      public List<BookingEntity> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
          final int _cursorIndexOfCustomerId = CursorUtil.getColumnIndexOrThrow(_cursor, "customerId");
          final int _cursorIndexOfCourtId = CursorUtil.getColumnIndexOrThrow(_cursor, "courtId");
          final int _cursorIndexOfBookingDate = CursorUtil.getColumnIndexOrThrow(_cursor, "bookingDate");
          final int _cursorIndexOfStartTime = CursorUtil.getColumnIndexOrThrow(_cursor, "startTime");
          final int _cursorIndexOfEndTime = CursorUtil.getColumnIndexOrThrow(_cursor, "endTime");
          final int _cursorIndexOfDurationHours = CursorUtil.getColumnIndexOrThrow(_cursor, "durationHours");
          final int _cursorIndexOfTotalAmount = CursorUtil.getColumnIndexOrThrow(_cursor, "totalAmount");
          final int _cursorIndexOfStatus = CursorUtil.getColumnIndexOrThrow(_cursor, "status");
          final int _cursorIndexOfCheckInTime = CursorUtil.getColumnIndexOrThrow(_cursor, "checkInTime");
          final int _cursorIndexOfCancellationReason = CursorUtil.getColumnIndexOrThrow(_cursor, "cancellationReason");
          final int _cursorIndexOfCreatedAt = CursorUtil.getColumnIndexOrThrow(_cursor, "createdAt");
          final int _cursorIndexOfUpdatedAt = CursorUtil.getColumnIndexOrThrow(_cursor, "updatedAt");
          final List<BookingEntity> _result = new ArrayList<BookingEntity>(_cursor.getCount());
          while (_cursor.moveToNext()) {
            final BookingEntity _item;
            final String _tmpId;
            _tmpId = _cursor.getString(_cursorIndexOfId);
            final String _tmpCustomerId;
            _tmpCustomerId = _cursor.getString(_cursorIndexOfCustomerId);
            final String _tmpCourtId;
            _tmpCourtId = _cursor.getString(_cursorIndexOfCourtId);
            final LocalDate _tmpBookingDate;
            final String _tmp_2;
            if (_cursor.isNull(_cursorIndexOfBookingDate)) {
              _tmp_2 = null;
            } else {
              _tmp_2 = _cursor.getString(_cursorIndexOfBookingDate);
            }
            final LocalDate _tmp_3 = __converters.toLocalDate(_tmp_2);
            if (_tmp_3 == null) {
              throw new IllegalStateException("Expected NON-NULL 'java.time.LocalDate', but it was NULL.");
            } else {
              _tmpBookingDate = _tmp_3;
            }
            final LocalTime _tmpStartTime;
            final String _tmp_4;
            if (_cursor.isNull(_cursorIndexOfStartTime)) {
              _tmp_4 = null;
            } else {
              _tmp_4 = _cursor.getString(_cursorIndexOfStartTime);
            }
            final LocalTime _tmp_5 = __converters.toLocalTime(_tmp_4);
            if (_tmp_5 == null) {
              throw new IllegalStateException("Expected NON-NULL 'java.time.LocalTime', but it was NULL.");
            } else {
              _tmpStartTime = _tmp_5;
            }
            final LocalTime _tmpEndTime;
            final String _tmp_6;
            if (_cursor.isNull(_cursorIndexOfEndTime)) {
              _tmp_6 = null;
            } else {
              _tmp_6 = _cursor.getString(_cursorIndexOfEndTime);
            }
            final LocalTime _tmp_7 = __converters.toLocalTime(_tmp_6);
            if (_tmp_7 == null) {
              throw new IllegalStateException("Expected NON-NULL 'java.time.LocalTime', but it was NULL.");
            } else {
              _tmpEndTime = _tmp_7;
            }
            final float _tmpDurationHours;
            _tmpDurationHours = _cursor.getFloat(_cursorIndexOfDurationHours);
            final double _tmpTotalAmount;
            _tmpTotalAmount = _cursor.getDouble(_cursorIndexOfTotalAmount);
            final String _tmpStatus;
            _tmpStatus = _cursor.getString(_cursorIndexOfStatus);
            final Long _tmpCheckInTime;
            if (_cursor.isNull(_cursorIndexOfCheckInTime)) {
              _tmpCheckInTime = null;
            } else {
              _tmpCheckInTime = _cursor.getLong(_cursorIndexOfCheckInTime);
            }
            final String _tmpCancellationReason;
            if (_cursor.isNull(_cursorIndexOfCancellationReason)) {
              _tmpCancellationReason = null;
            } else {
              _tmpCancellationReason = _cursor.getString(_cursorIndexOfCancellationReason);
            }
            final long _tmpCreatedAt;
            _tmpCreatedAt = _cursor.getLong(_cursorIndexOfCreatedAt);
            final long _tmpUpdatedAt;
            _tmpUpdatedAt = _cursor.getLong(_cursorIndexOfUpdatedAt);
            _item = new BookingEntity(_tmpId,_tmpCustomerId,_tmpCourtId,_tmpBookingDate,_tmpStartTime,_tmpEndTime,_tmpDurationHours,_tmpTotalAmount,_tmpStatus,_tmpCheckInTime,_tmpCancellationReason,_tmpCreatedAt,_tmpUpdatedAt);
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

  @NonNull
  public static List<Class<?>> getRequiredConverters() {
    return Collections.emptyList();
  }
}

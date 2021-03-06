package com.hailan.HaiLanPrint.greendao;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteStatement;

import de.greenrobot.dao.AbstractDao;
import de.greenrobot.dao.Property;
import de.greenrobot.dao.internal.DaoConfig;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT.
/** 
 * DAO for table "LOCATION".
*/
public class LocationDao extends AbstractDao<Location, Long> {

    public static final String TABLENAME = "LOCATION";

    /**
     * Properties of entity Location.<br/>
     * Can be used for QueryBuilder and for referencing column names.
    */
    public static class Properties {
        public final static Property EnglishName = new Property(0, String.class, "EnglishName", false, "ENGLISH_NAME");
        public final static Property IsCity = new Property(1, Boolean.class, "IsCity", false, "IS_CITY");
        public final static Property IsHot = new Property(2, Boolean.class, "IsHot", false, "IS_HOT");
        public final static Property IsValid = new Property(3, Boolean.class, "IsValid", false, "IS_VALID");
        public final static Property LocationCode = new Property(4, Long.class, "LocationCode", false, "LOCATION_CODE");
        public final static Property LocationID = new Property(5, Long.class, "LocationID", true, "LOCATION_ID");
        public final static Property LocationName = new Property(6, String.class, "LocationName", false, "LOCATION_NAME");
        public final static Property LocationX = new Property(7, Float.class, "LocationX", false, "LOCATION_X");
        public final static Property LocationY = new Property(8, Float.class, "LocationY", false, "LOCATION_Y");
        public final static Property ParentID = new Property(9, Long.class, "ParentID", false, "PARENT_ID");
    };


    public LocationDao(DaoConfig config) {
        super(config);
    }
    
    public LocationDao(DaoConfig config, DaoSession daoSession) {
        super(config, daoSession);
    }

    /** Creates the underlying database table. */
    public static void createTable(SQLiteDatabase db, boolean ifNotExists) {
        String constraint = ifNotExists? "IF NOT EXISTS ": "";
        db.execSQL("CREATE TABLE " + constraint + "\"LOCATION\" (" + //
                "\"ENGLISH_NAME\" TEXT," + // 0: EnglishName
                "\"IS_CITY\" INTEGER," + // 1: IsCity
                "\"IS_HOT\" INTEGER," + // 2: IsHot
                "\"IS_VALID\" INTEGER," + // 3: IsValid
                "\"LOCATION_CODE\" INTEGER," + // 4: LocationCode
                "\"LOCATION_ID\" INTEGER PRIMARY KEY ," + // 5: LocationID
                "\"LOCATION_NAME\" TEXT," + // 6: LocationName
                "\"LOCATION_X\" REAL," + // 7: LocationX
                "\"LOCATION_Y\" REAL," + // 8: LocationY
                "\"PARENT_ID\" INTEGER);"); // 9: ParentID
    }

    /** Drops the underlying database table. */
    public static void dropTable(SQLiteDatabase db, boolean ifExists) {
        String sql = "DROP TABLE " + (ifExists ? "IF EXISTS " : "") + "\"LOCATION\"";
        db.execSQL(sql);
    }

    /** @inheritdoc */
    @Override
    protected void bindValues(SQLiteStatement stmt, Location entity) {
        stmt.clearBindings();
 
        String EnglishName = entity.getEnglishName();
        if (EnglishName != null) {
            stmt.bindString(1, EnglishName);
        }
 
        Boolean IsCity = entity.getIsCity();
        if (IsCity != null) {
            stmt.bindLong(2, IsCity ? 1L: 0L);
        }
 
        Boolean IsHot = entity.getIsHot();
        if (IsHot != null) {
            stmt.bindLong(3, IsHot ? 1L: 0L);
        }
 
        Boolean IsValid = entity.getIsValid();
        if (IsValid != null) {
            stmt.bindLong(4, IsValid ? 1L: 0L);
        }
 
        Long LocationCode = entity.getLocationCode();
        if (LocationCode != null) {
            stmt.bindLong(5, LocationCode);
        }
 
        Long LocationID = entity.getLocationID();
        if (LocationID != null) {
            stmt.bindLong(6, LocationID);
        }
 
        String LocationName = entity.getLocationName();
        if (LocationName != null) {
            stmt.bindString(7, LocationName);
        }
 
        Float LocationX = entity.getLocationX();
        if (LocationX != null) {
            stmt.bindDouble(8, LocationX);
        }
 
        Float LocationY = entity.getLocationY();
        if (LocationY != null) {
            stmt.bindDouble(9, LocationY);
        }
 
        Long ParentID = entity.getParentID();
        if (ParentID != null) {
            stmt.bindLong(10, ParentID);
        }
    }

    /** @inheritdoc */
    @Override
    public Long readKey(Cursor cursor, int offset) {
        return cursor.isNull(offset + 5) ? null : cursor.getLong(offset + 5);
    }    

    /** @inheritdoc */
    @Override
    public Location readEntity(Cursor cursor, int offset) {
        Location entity = new Location( //
            cursor.isNull(offset + 0) ? null : cursor.getString(offset + 0), // EnglishName
            cursor.isNull(offset + 1) ? null : cursor.getShort(offset + 1) != 0, // IsCity
            cursor.isNull(offset + 2) ? null : cursor.getShort(offset + 2) != 0, // IsHot
            cursor.isNull(offset + 3) ? null : cursor.getShort(offset + 3) != 0, // IsValid
            cursor.isNull(offset + 4) ? null : cursor.getLong(offset + 4), // LocationCode
            cursor.isNull(offset + 5) ? null : cursor.getLong(offset + 5), // LocationID
            cursor.isNull(offset + 6) ? null : cursor.getString(offset + 6), // LocationName
            cursor.isNull(offset + 7) ? null : cursor.getFloat(offset + 7), // LocationX
            cursor.isNull(offset + 8) ? null : cursor.getFloat(offset + 8), // LocationY
            cursor.isNull(offset + 9) ? null : cursor.getLong(offset + 9) // ParentID
        );
        return entity;
    }
     
    /** @inheritdoc */
    @Override
    public void readEntity(Cursor cursor, Location entity, int offset) {
        entity.setEnglishName(cursor.isNull(offset + 0) ? null : cursor.getString(offset + 0));
        entity.setIsCity(cursor.isNull(offset + 1) ? null : cursor.getShort(offset + 1) != 0);
        entity.setIsHot(cursor.isNull(offset + 2) ? null : cursor.getShort(offset + 2) != 0);
        entity.setIsValid(cursor.isNull(offset + 3) ? null : cursor.getShort(offset + 3) != 0);
        entity.setLocationCode(cursor.isNull(offset + 4) ? null : cursor.getLong(offset + 4));
        entity.setLocationID(cursor.isNull(offset + 5) ? null : cursor.getLong(offset + 5));
        entity.setLocationName(cursor.isNull(offset + 6) ? null : cursor.getString(offset + 6));
        entity.setLocationX(cursor.isNull(offset + 7) ? null : cursor.getFloat(offset + 7));
        entity.setLocationY(cursor.isNull(offset + 8) ? null : cursor.getFloat(offset + 8));
        entity.setParentID(cursor.isNull(offset + 9) ? null : cursor.getLong(offset + 9));
     }
    
    /** @inheritdoc */
    @Override
    protected Long updateKeyAfterInsert(Location entity, long rowId) {
        entity.setLocationID(rowId);
        return rowId;
    }
    
    /** @inheritdoc */
    @Override
    public Long getKey(Location entity) {
        if(entity != null) {
            return entity.getLocationID();
        } else {
            return null;
        }
    }

    /** @inheritdoc */
    @Override    
    protected boolean isEntityUpdateable() {
        return true;
    }
    
}

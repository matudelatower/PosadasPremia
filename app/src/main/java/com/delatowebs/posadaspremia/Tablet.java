package com.delatowebs.posadaspremia;

/**
 * Created by matias on 22/04/15.
 */
public class Tablet {

    // Labels table name
    public static final String TABLE = "tablet";

    // Labels Table Columns names
    public static final String KEY_ID = "_id";
    public static final String KEY_ID_TABLET = "tablet_id";

    private Integer id;
    private Integer IdTablet;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getIdTablet() {
        return this.IdTablet;
    }

    public void setIdTablet(Integer idTablet) {
        this.IdTablet = idTablet;
    }
}

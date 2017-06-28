package com.danielvilha.asup.common.entity;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;

import java.util.Date;
import org.greenrobot.greendao.annotation.ToOne;
import org.greenrobot.greendao.annotation.Generated;
import org.greenrobot.greendao.DaoException;

/**
 * Created by Daniel Vilha 28/06/17.
 */
@Entity
public class Personal {

    @Id(autoincrement = true)
    private Long id;

    private Date date;

    @ToOne(joinProperty="id")
    private Social social;

    @ToOne(joinProperty="id")
    private Economic economic;

    @ToOne(joinProperty="id")
    private Environmental environmental;
}

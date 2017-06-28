package com.danielvilha.asup.common.entity;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.ToMany;

import java.util.List;
import org.greenrobot.greendao.annotation.Generated;
import org.greenrobot.greendao.DaoException;

/**
 * Created by Daniel Vilha 28/06/17.
 */
@Entity
public class Social {

    @Id(autoincrement = true)
    private Long id;

    @ToMany()
    private List<Answer> answers;
}

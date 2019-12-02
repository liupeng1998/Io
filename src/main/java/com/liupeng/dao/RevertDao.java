package com.liupeng.dao;

import com.liupeng.entiey.REVERT;

import java.util.List;

public interface RevertDao {

    boolean Revereadd(REVERT revert);

    List<REVERT> find();
}

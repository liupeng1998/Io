package com.liupeng.server;

import com.liupeng.entiey.REVERT;

import java.util.List;

public interface RevertServer {
    boolean Revereadd(REVERT revert);

    List<REVERT> find();
}

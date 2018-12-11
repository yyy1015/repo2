package cn.itcast.yyy.service;

import cn.itcast.yyy.domain.SysLog;

import java.util.List;

public interface SysLogService {

    public void save(SysLog sysLog) ;

    List<SysLog> findAll(Integer page, Integer size);
}

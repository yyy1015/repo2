package cn.itcast.yyy.service.impl;

import cn.itcast.yyy.dao.SysLogDao;
import cn.itcast.yyy.domain.SysLog;
import cn.itcast.yyy.service.SysLogService;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class SysLogServiceImpl implements SysLogService {

    @Autowired
    private SysLogDao sysLogDao;

    @Override
    public void save(SysLog sysLog)  {
        sysLogDao.save(sysLog);
    }

    @Override
    public List<SysLog> findAll(Integer page, Integer size) {
        PageHelper.startPage(page,size);
        return sysLogDao.findAll();
    }
}

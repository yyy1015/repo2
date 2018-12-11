package cn.itcast.yyy.dao;

import cn.itcast.yyy.domain.Member;
import org.apache.ibatis.annotations.Select;

public interface MemberDao {

    @Select("select * from member where id = #{id}")
    public Member findById(String id);
}

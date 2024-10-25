package com.example.prjjsp.mapper;

import com.example.prjjsp.dto.Member;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface MemberMapper {

    @Insert("""
            INSERT INTO member
            (id, password, nick_name, description)
            VALUES (#{id}, #{password}, #{nickName}, #{description})
            """)
    int insert(Member member);

    @Select("""
            SELECT *
            FROM member
            ORDER BY id 
            """)
    List<Member> selectAll();

    @Select("""
            SELECT * FROM member
            WHERE id = #{id}
            """)
    Member selectById(String id);

    @Delete("""
            DELETE FROM member
            WHERE id = #{id}
            AND password = #{password}
            """)
    int deleteByIdAndPassword(String id, String password);

    @Update("""
            UPDATE member
            SET nick_name = #{nickName},
                description = #{description}
            WHERE id = #{id}
            """)
    int update(Member member);
}
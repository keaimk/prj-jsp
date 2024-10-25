package com.example.prjjsp.mapper;

import com.example.prjjsp.dto.Board;
import com.example.prjjsp.dto.Member;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface BoardMapper {


    @Insert("""
            INSERT INTO board
            (title, content, writer)
            VALUES (#{board.title}, #{board.content}, #{member.id})
            """)
    @Options(useGeneratedKeys = true, keyProperty = "board.id")
    int insert(Board board, Member member);

    @Select("""
            SELECT * FROM board
            ORDER BY id DESC
            """)
    List<Board> selectAll();

    @Select("""
            SELECT * 
            FROM board
            WHERE id = #{id}
            """)
    Board selectById(Integer id);

    @Delete("""
            DELETE FROM board
            WHERE id = #{id}
            """)
    int deleteById(Integer id);

    @Update("""
            UPDATE board
            SET title=#{title},
                content=#{content}, 
                writer=#{writer}
            WHERE   
                id = #{id}
            """)
    int update(Board board);

    @Select("""
            SELECT *
            FROM board
            ORDER BY id DESC
            LIMIT #{offset}, 10
            """)
    List<Board> selectAllPaging(Integer offset);

    @Select("""
            SELECT COUNT(id) FROM board
            """)
    Integer countAll();
}
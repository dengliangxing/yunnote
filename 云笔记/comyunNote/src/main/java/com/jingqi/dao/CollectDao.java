package com.jingqi.dao;

import com.jingqi.domain.Collect;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 收藏的dao层
 * @author   Huxudong
 * @date     2019-02-21
 */
@Repository
public interface CollectDao {
    /**
     * 新建一个收藏笔记本
     * @author            Huxudong
     * @date              2019-02-21
     * @param collect     收藏笔记本的对象
     * @return            收藏成功后受影响的行数
     */
    public int createCollect(Collect collect);

    /**
     * 根据用户登录的id查询收藏的所有的笔记的总数
     * @author             Huxudong
     * @date               2019-02-21
     * @param userId       用户的登录id
     * @return             收藏的所有的笔记的总数
     */
    public int findCollectCount(@Param("userId") String userId);

    /**
     * 分页查询所有的收藏的笔记本
     * @author             Huxudong
     * @date               2019-02-21
     * @param userId       用户登录的id
     * @param begin        每页分页的开始
     * @param pageSize     每页的大小
     * @return             所有的收藏的笔记本的列表
     */
    public List<Collect> findAllCollect(@Param("userId") String userId,@Param("begin") Integer begin,@Param("pageSize") Integer pageSize);

    /**
     * 根据收藏的id删除一个收藏的笔记
     * @param collectId    收藏的id
     * @author             Huxudong
     * @date               2019-02-21
     * @return             删除收藏的笔记本后受影响的行数
     */
    public int deleteCollect(String collectId);

    /**
     * 根据收藏的id查看收藏的笔记本
     * @param collectId     收藏的id
     * @author              Huxudong
     * @date                2019-02-21
     * @return              返回收藏的笔记本的实体类对象信息
     */
    public Collect lookBookNote(String collectId);

    /**
     * 根据用户的登录id来查询收藏的笔记的总数
     * @param userId        用户的登录的id
     * @author              Huxudong
     * @date                2019-02-21
     * @return              收藏的笔记的总数
     */
    public int findCollectNoteCount(@Param("userId") String userId);

    /**
     * 分页查询所有的收藏的笔记的列表
     * @param userId        用户的登录的id
     * @param begin         每页分页的开始
     * @param pageSize      每页的大小
     * @author              Huxudong
     * @date                2019-02-21
     * @return              所有的收藏的笔记的信息列表
     */
    public List<Collect> findAllCollectNote(@Param("userId") String userId,@Param("begin") Integer begin,@Param("pageSize") Integer pageSize);

    /**
     * 新增一条收藏的笔记
     * @param collect       收藏的笔记的对象
     * @author              Huxudong
     * @date                2019-02-21
     * @return              创建一个收藏笔记后受影响的行数
     */
    public int createCollectNote(Collect collect);
}

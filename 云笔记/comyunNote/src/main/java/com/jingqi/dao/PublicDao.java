package com.jingqi.dao;
import com.jingqi.domain.Public;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import java.util.List;

/**
 * 公开笔记dao层
 * @author Huxudong
 * @date 2019-03-30 19:50:14
 **/
@Repository
public interface PublicDao {

    /**
     * 公开笔记
     * @author Huxudong
     * @createTime 2019-03-30 20:03:27
     * @param pub        公开表的实体类
     * @return int       返回受影响的行数
     **/
    public int addPublicNote(Public pub);

    /**
     * 公开笔记的总数
     * @author Huxudong
     * @createTime 2019-03-30 20:30:18
     * @param
     * @return int      公开笔记的总数
     **/
    public int findCount();

    /**
     * 查询所有的公开笔记的集合
     * @author Huxudong
     * @createTime 2019-03-30 20:38:14
     * @param begin                     分页初始
     * @param pageSize                  分页大小
     * @return java.util.List<com.jingqi.domain.Public>     公开笔记的集合
     **/
    public List<Public> findAllPublic(@Param("begin")Integer begin,@Param("pageSize")Integer pageSize);

    /**
     * 根据公开笔记id查询公开笔记本
     * @author Huxudong
     * @createTime 2019-03-30 22:31:37
     * @param  id                            公开的笔记id
     * @return com.jingqi.domain.Public     公开笔记本信息
     **/
    public Public findByPublicId(String id);

    /**
     * 删除一条公开的笔记
     * @author Huxudong
     * @createTime 2019-03-30 23:54:53
     * @param id        笔记id
     * @return int      返回受影响的行数
     **/
    public int deletePublicNote(String id);

    /**
     * 根据笔记的id查询笔记的公开的信息
     * @author Huxudong
     * @createTime 2019-03-31 08:59:35
     * @param noteId                 笔记id
     * @return com.jingqi.domain.Public 公开的笔记信息
     **/
    public Public findByPublicNoteId(String noteId);

    /**
     * 根据笔记id删除一条公开的笔记
     * @author Huxudong
     * @createTime 2019-03-31 11:06:03
     * @param noteId     笔记id
     * @return int       受影响的行数
     **/
    public int deleteByNoteId(String noteId);
}

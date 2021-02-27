package cn.edu.gues.mapper;

import cn.edu.gues.pojo.Notice;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author NIRLIN
 * @version 1.0
 * @date 2020/7/13 15:40
 */

@Mapper
@Repository
public interface NoticeMapper {
    /**
     * 功能：查询所有通知
     * 异常：为SQL异常
     *
     * @return List<Notice>
     */
    List<Notice> selectAllNotice();

    /**
     * 功能：根据id查询通知
     * 异常：SQL异常
     *
     * @param id Notice的id
     * @return Notice
     */
    Notice selectNoticeById(String id);

    /**
     * 功能：通知插入数据库
     * 异常：SQL异常
     *
     * @param notice Notice
     * @return int
     */
    int insertNotice(Notice notice);

    /**
     * 功能：据通知id修改通知信息
     * 异常：SQL异常
     *
     * @param notice Notice
     * @return int
     */
    int updateNoticeById(Notice notice);

    /**
     * 功能：根据id删除通知
     * 异常：SQL异常
     *
     * @param id Notice的id
     * @return int
     */
    int deleteNoticeById(String id);
}

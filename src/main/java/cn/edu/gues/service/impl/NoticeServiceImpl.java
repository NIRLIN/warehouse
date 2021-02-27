package cn.edu.gues.service.impl;

import cn.edu.gues.mapper.NoticeMapper;
import cn.edu.gues.pojo.Notice;
import cn.edu.gues.service.NoticeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.UUID;

/**
 * @author NIRLIN
 * @version 1.0
 * @date 2020/7/13 15:44
 */

@Service
public class NoticeServiceImpl implements NoticeService {
    @Autowired
    private NoticeMapper noticeMapper;
    @Override
    public List<Notice> selectAllNotice() {
        return noticeMapper.selectAllNotice();
    }

    @Override
    public Notice selectNoticeById(String id) {
        return noticeMapper.selectNoticeById(id);
    }

    @Override
    public int insertNotice(Notice notice) {
        notice.setId(String.valueOf(UUID.randomUUID()));
        notice.setCreateTime(new Date());
        return noticeMapper.insertNotice(notice);
    }

    @Override
    public int updateNoticeById(Notice notice) {
        notice.setCreateTime(new Date());
        return noticeMapper.updateNoticeById(notice);
    }

    @Override
    public int deleteNoticeById(String id) {
        return noticeMapper.deleteNoticeById(id);
    }
}

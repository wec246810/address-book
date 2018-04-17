package com.ysk.addressbook.service.Impl;

import com.ysk.addressbook.dao.NoticeDao;
import com.ysk.addressbook.service.NoticeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class NoticeServiceImpl implements NoticeService {
    @Autowired
    private NoticeDao noticeDao;


    @Override
    public String getMyNotice() {

        return noticeDao.getMyNotice();
    }

    @Override
    public void update(String content) {
        noticeDao.update(content);
    }
}

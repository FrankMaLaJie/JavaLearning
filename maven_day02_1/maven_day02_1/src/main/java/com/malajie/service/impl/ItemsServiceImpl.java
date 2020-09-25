package com.malajie.service.impl;

import com.malajie.dao.ItemsDao;
import com.malajie.domain.Items;
import com.malajie.service.ItemsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ItemsServiceImpl implements ItemsService
{
    @Autowired
    private ItemsDao itemsDao;

    public Items findById(Integer id)
    {
        return itemsDao.findById(id);
    }
}

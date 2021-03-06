package ga.rugal.fridge.core.service.impl;

import ga.rugal.fridge.core.dao.ItemDao;
import ga.rugal.fridge.core.service.ItemService;

import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ItemServiceImpl implements ItemService {

  @Autowired
  @Getter
  @Setter
  private ItemDao dao;
}

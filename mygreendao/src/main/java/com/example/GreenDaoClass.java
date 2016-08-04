package com.example;

import de.greenrobot.daogenerator.DaoGenerator;
import de.greenrobot.daogenerator.Entity;
import de.greenrobot.daogenerator.Schema;

public class GreenDaoClass {
  public static void main(String[] args) throws Exception{
    Schema schema = new Schema(1,"com.river.news.greendao");
    addTable(schema);
    new DaoGenerator().generateAll(schema,"./app/src/main/java-gen");

  }

  private static void addTable(Schema schema) {
    Entity note = schema.addEntity("NewsChannelTable");
    /**
     * 频道名称
     */
    note.addStringProperty("newsChannelName").notNull().primaryKey().index();
    /**
     * 频道id
     */
    note.addStringProperty("newsChannelId").notNull();
    /**
     * 频道类型
     */
    note.addStringProperty("newsChannelType").notNull();
    /**
     * 选中的频道
     */
    note.addBooleanProperty("newsChannelSelect").notNull();
    /**
     * 频道的排序位置
     */
    note.addIntProperty("newsChannelIndex").notNull();
    /**
     * 频道是否是固定的
     */
    note.addBooleanProperty("newsChannelFixed");
  }
}

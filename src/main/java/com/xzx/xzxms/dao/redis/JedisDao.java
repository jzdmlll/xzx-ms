package com.xzx.xzxms.dao.redis;

public interface JedisDao {
    /**
     * 判断key是否存在
     * @param key
     * @return
     */
    boolean exists(String key);

    /**
     * 删除
     * @param key
     * @return
     */
    boolean del(String key);

    /**
     * 设置值
     * @param key
     * @param value
     * @return
     */
    void set(String key, String value);
    /**
     * 设置值, minutes分钟后过期
     * @param key
     * @param value
     * @param minutes
     * @return
     */
    void setCode(String key, String value, long minutes);

    /**
     * 取值
     * @param key
     * @return
     */
    String get(String key);
}


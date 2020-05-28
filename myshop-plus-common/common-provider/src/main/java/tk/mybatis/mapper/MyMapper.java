package tk.mybatis.mapper;

import tk.mybatis.mapper.common.Mapper;
import tk.mybatis.mapper.common.MySqlMapper;

/**
 * @author loven.
 * @version 1.0.0
 * @date 2020/5/20.
 */
public interface MyMapper<T> extends Mapper<T>, MySqlMapper<T> {
}

package cn.mlgbteam.core.mapper.provider;

import java.util.Set;
import org.apache.ibatis.mapping.MappedStatement;
import tk.mybatis.mapper.entity.EntityColumn;
import tk.mybatis.mapper.mapperhelper.EntityHelper;
import tk.mybatis.mapper.mapperhelper.MapperHelper;
import tk.mybatis.mapper.mapperhelper.MapperTemplate;
import tk.mybatis.mapper.mapperhelper.SqlHelper;

public class MLGBProvider extends MapperTemplate {

    public MLGBProvider(final Class<?> mapperClass,
            final MapperHelper mapperHelper) {
        super(mapperClass, mapperHelper);
    }

    /**
     * 批量插入
     */
    public String insertList(final MappedStatement ms) {
        final Class<?> entityClass = getEntityClass(ms);
        //开始拼sql
        final StringBuilder sql = new StringBuilder();
        sql.append(SqlHelper.insertIntoTable(entityClass, tableName(entityClass)));
        sql.append(SqlHelper.insertColumns(entityClass, false, false, false));
        sql.append(" VALUES ");
        sql.append("<foreach collection=\"list\" item=\"record\" separator=\",\" >");
        sql.append("<trim prefix=\"(\" suffix=\")\" suffixOverrides=\",\">");
        //获取全部列
        final Set<EntityColumn> columnList = EntityHelper.getColumns(entityClass);
        //当某个列有主键策略时，不需要考虑他的属性是否为空，因为如果为空，一定会根据主键策略给他生成一个值
        for (final EntityColumn column : columnList) {
            if (column.isInsertable()) {
                sql.append(column.getColumnHolder("record", null, ","));
            }
        }
        sql.append("</trim>");
        sql.append("</foreach>");
        return sql.toString();
    }

    /**
     * 批量插入
     */
    public String insertListSelective(final MappedStatement ms) {
        final Class<?> entityClass = getEntityClass(ms);
        //获取全部列
        final Set<EntityColumn> columnList = EntityHelper.getColumns(entityClass);
        //开始拼sql
        final StringBuilder sql = new StringBuilder();
        sql.append(SqlHelper.insertIntoTable(entityClass, tableName(entityClass)));
        sql.append("<trim prefix=\"(\" suffix=\")\" suffixOverrides=\",\">");
        for (final EntityColumn column : columnList) {
            if (!column.isInsertable()) {
                continue;
            }

            sql.append(SqlHelper
                    .getIfNotNull("list.get(0)", column, column.getColumn() + ",", isNotEmpty()));
        }
        sql.append("</trim>");
        sql.append(" VALUES ");
        sql.append("<foreach collection=\"list\" item=\"record\" separator=\",\" >");
        sql.append("<trim prefix=\"(\" suffix=\")\" suffixOverrides=\",\">");
        for (final EntityColumn column : columnList) {
            if (!column.isInsertable()) {
                continue;
            }
            //其他情况值仍然存在原property中
            sql.append(SqlHelper
                    .getIfNotNull("record", column, column.getColumnHolder("record", null, ","),
                            isNotEmpty()));
        }
        sql.append("</trim>");
        sql.append("</foreach>");
        return sql.toString();
    }

}

/**
 *    Copyright 2009-2015 the original author or authors.
 *
 *    Licensed under the Apache License, Version 2.0 (the "License");
 *    you may not use this file except in compliance with the License.
 *    You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 *
 *    Unless required by applicable law or agreed to in writing, software
 *    distributed under the License is distributed on an "AS IS" BASIS,
 *    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *    See the License for the specific language governing permissions and
 *    limitations under the License.
 */
package org.apache.ibatis.type;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @author Clinton Begin
 */
public interface TypeHandler<T> {
  /**
   * 设置PreparedStatement 的指定参数
   *
   *  java type => jdbc type
   * @param ps
   * @param i
   * @param parameter
   * @param jdbcType
   * @throws SQLException
   */
  void setParameter(PreparedStatement ps, int i, T parameter, JdbcType jdbcType) throws SQLException;

  /**
   * 获得 ResultSet的指定字段的值
   * @param rs  ResultSet 对象
   * @param columnName  字段名称
   * @return
   * @throws SQLException
   */
  T getResult(ResultSet rs, String columnName) throws SQLException;

  /**
   * 获得ResultSet的指定字段值
   * JDBC Type => Java Type
   * @param rs  ResultSet 对象
   * @param columnIndex  字段位置
   * @return
   * @throws SQLException
   */
  T getResult(ResultSet rs, int columnIndex) throws SQLException;

  /**
   * 获得CallableStatement 的字段值
   *
   * Jdbc type => Java type
   *
   * @param cs  CallableStatement 对象，用来调用存储过程
   * @param columnIndex 参数位置
   * @return
   * @throws SQLException
   */
  T getResult(CallableStatement cs, int columnIndex) throws SQLException;

}

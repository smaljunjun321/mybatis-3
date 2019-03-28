/**
 *    Copyright 2009-2017 the original author or authors.
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

package org.apache.ibatis.reflection;

import java.lang.reflect.Constructor;
import java.lang.reflect.Executable;
import java.lang.reflect.Method;
import java.lang.reflect.Parameter;
import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.lang.UsesJava8;

@UsesJava8
public class ParamNameUtil {
  /**
   * 获取普通方法的的参数列表
   * @param method
   * @return
   */
  public static List<String> getParamNames(Method method) {
    return getParameterNames(method);
  }

  /**
   * 获得构造函数的参数列表
   * @param constructor
   * @return
   */
  public static List<String> getParamNames(Constructor<?> constructor) {
    return getParameterNames(constructor);
  }

  private static List<String> getParameterNames(Executable executable) {
    final List<String> names = new ArrayList<String>();
    //获得参数数据
    final Parameter[] params = executable.getParameters();
    // 放到list中去
    for (Parameter param : params) {
      names.add(param.getName());
    }
    return names;
  }

  private ParamNameUtil() {
    super();
  }
}

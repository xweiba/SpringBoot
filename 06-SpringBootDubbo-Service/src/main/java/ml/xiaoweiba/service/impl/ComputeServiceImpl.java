package ml.xiaoweiba.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import ml.xiaoweiba.service.ComputeService;

/**
 * @program: demo
 * @description: 组件实现类
 * @author: Mr.xweiba
 * @create: 2018-06-30 00:43
 **/

@Service
public class ComputeServiceImpl implements ComputeService{
    @Override
    public Integer add(int a, int b) {
        return a + b;
    }
}

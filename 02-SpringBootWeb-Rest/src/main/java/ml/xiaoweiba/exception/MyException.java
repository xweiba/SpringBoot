package ml.xiaoweiba.exception;

/**
 * @program: demo
 * @description: 自定义异常类
 * @author: Mr.xweiba
 * @create: 2018-06-28 15:53
 **/

public class MyException extends Exception {
    public MyException(String memssage) {
        super(memssage);
    }
}

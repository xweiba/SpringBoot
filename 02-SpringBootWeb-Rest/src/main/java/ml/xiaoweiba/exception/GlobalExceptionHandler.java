package ml.xiaoweiba.exception;

import ml.xiaoweiba.model.ErrorInfo;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

/**
 * @program: demo
 * @description: 全局异常处理
 * @author: Mr.xweiba
 * @create: 2018-06-28 11:15
 **/

@ControllerAdvice
public class GlobalExceptionHandler {

    private static final String DEFAULT_ERROR_VIEW = "error";

    @ExceptionHandler(value = Exception.class)
    public ModelAndView defaultErrorHandler(HttpServletRequest request, Exception e) throws Exception {
        ModelAndView modelAndView = new ModelAndView();
        System.out.println("excption: " + e.getMessage());
        modelAndView.addObject("exception", e);
        System.out.println("url: " + request.getRequestURI());
        modelAndView.addObject("url", request.getRequestURL());
        modelAndView.setViewName(DEFAULT_ERROR_VIEW);
        return modelAndView;
    }

    @ExceptionHandler(value = MyException.class)
    @ResponseBody
    public ErrorInfo<String> jsonErrorHandler (HttpServletRequest request, MyException e) {
        ErrorInfo<String> stringErrorInfo = new ErrorInfo<>();
        stringErrorInfo.setCode(ErrorInfo.ERROR);
        stringErrorInfo.setMessage(e.getMessage());
        stringErrorInfo.setUrl(request.getRequestURI().toString());
        stringErrorInfo.setDate("这里是数据块");
        return stringErrorInfo;
    }
}

package ml.xiaoweiba.model;

import io.swagger.annotations.ApiModel;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

/**
 * @program: demo
 * @description: 返回View 对象
 * @author: Mr.xweiba
 * @create: 2018-06-27 21:02
 **/
@ApiModel(value="Msg",description="返回值")
public class Msg implements Serializable{
    private static final long serialVersionUID = 1997823629970794363L;
    // 返回状态码
    private int code;
    // 返回提示信息
    private String msg;
    // 返回的业务数据
    private Map<String, Object> extend = new HashMap<String, Object>();

    //写个快捷的提示成功和失败的方法
    public static Msg success(){
        Msg result=new Msg();
        result.setCode(200);
        result.setMsg("处理成功");
        return result;
    }
    public static Msg success(String msg){
        Msg result=new Msg();
        result.setCode(200);
        result.setMsg(msg);
        return result;
    }
    public static Msg success(String msg, int code){
        Msg result=new Msg();
        result.setCode(code);
        result.setMsg(msg);
        return result;
    }

    public static Msg fail(){
        Msg result=new Msg();
        result.setCode(500);
        result.setMsg("处理失败");
        return result;
    }
    public static Msg fail(String msg){
        Msg result=new Msg();
        result.setCode(500);
        result.setMsg(msg);
        return result;
    }
    public static Msg fail(String msg, int code){
        Msg result=new Msg();
        result.setCode(code);
        result.setMsg(msg);
        return result;
    }

    public Msg add(String key, Object value){
        this.getExtend().put(key, value);
        return this;
    }

    @Override
    public String toString() {
        return "Msg{" +
                "code=" + code +
                ", msg='" + msg + '\'' +
                ", extend=" + extend +
                '}';
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Map<String, Object> getExtend() {
        return extend;
    }

    public void setExtend(Map<String, Object> extend) {
        this.extend = extend;
    }
}

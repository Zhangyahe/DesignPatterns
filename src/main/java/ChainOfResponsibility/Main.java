package ChainOfResponsibility;

import java.util.ArrayList;
import java.util.List;

/**
 * @description: 责任链模式（封装变化）
 * @author: YaHe
 * @createDate: 2020/5/10
 * @version: 1.0
 */
public class Main {
    public static void main(String[] args) {
        Msg msg = new Msg();
        msg.setMsg("大家好:); <script> ,欢迎访问 taobao.com ,大家都是996");

        FilterChain filterChain = new FilterChain();
        filterChain.add(new HtmlFilter()).add(new SensitiveFilter());

        FilterChain filterChain2 = new FilterChain();
        filterChain2.add(new EmjogFilter()).add(new UrlFilter());
/**
 *  让FilterChain实现Filter接口，这个链条也可以当作是一个Filter加到别的链条上去
 */
        filterChain.add(filterChain2);

        filterChain.doFilter(msg);
        System.out.println(msg);
    }
}

class Msg {
    private String name;
    private String msg;

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Msg{" +
                "name=" + name +
                ", msg='" + msg + '\'' +
                '}';
    }
}

/**
 * 为了实现filter链条的顺序执行依赖于上一个Filter的返回值
 * 修改Filter中的doFilter的返回类型为boolean
 */
interface Filter {
   boolean  doFilter(Msg msg);
}

class HtmlFilter implements Filter {

    @Override
    public boolean doFilter(Msg msg) {
        String r = msg.getMsg();
        r = r.replace("<", "[");
        r = r.replace(">", "]");
        msg.setMsg(r);
        return true;
    }
}

class SensitiveFilter implements Filter {

    @Override
    public boolean doFilter(Msg msg) {
        String r = msg.getMsg();
        r = r.replace("996", "955");
        msg.setMsg(r);
        return false;
    }
}

class EmjogFilter implements Filter {

    @Override
    public boolean doFilter(Msg msg) {
        String r = msg.getMsg();
        r = r.replace(":)", "0.0");
        msg.setMsg(r);
        return true;
    }
}

class UrlFilter implements Filter {

    @Override
    public boolean doFilter(Msg msg) {
        String r = msg.getMsg();
        r = r.replace("taobao.com", "http://www.taobao.com");
        msg.setMsg(r);
        return true;
    }
}


//过滤链
class FilterChain implements Filter {
    List<Filter> filters = new ArrayList<>(16);

    //直接返回FilterChain，再进行add时代码易读性增大（链式编程）
    public FilterChain add(Filter filter) {
        filters.add(filter);
        return this;
    }

    public void remove(Filter filter) {
        filters.remove(filter);
    }

    public boolean doFilter(Msg msg) {
        for (Filter filter : filters) {
           if(!filter.doFilter(msg)){
               return false;
           }
        }
        return true;
    }
}
package ChainOfResponsibility.ServletFilter;

import java.util.ArrayList;
import java.util.List;

/**
 * @description: 责任链模式（封装变化）
 * @author: YaHe
 * @createDate: 2020/5/10
 * @version: 1.0
 */
public class ServletMain {
    public static void main(String[] args) {
        Request request = new Request();
        request.setStr("大家好:); <script> ,欢迎访问 taobao.com ,大家都是996");
        Response response = new Response();
        response.setStr("response");

        FilterChain filterChain = new FilterChain();
        filterChain.add(new HtmlFilter()).add(new SensitiveFilter());
        filterChain.doFilter(request, response, filterChain);
        System.out.println(request.getStr());
        System.out.println(response.getStr());
    }
}

/**
 * 为了实现filter链条的顺序执行依赖于上一个Filter的返回值
 * 修改Filter中的doFilter的返回类型为boolean
 */
interface Filter {
    boolean doFilter(Request request, Response reponse, FilterChain chain);
}

class HtmlFilter implements Filter {

    @Override
    public boolean doFilter(Request request, Response reponse, FilterChain chain) {
        request.setStr(request.getStr().replaceAll("<", "[").replace(">", "]"));
        chain.doFilter(request, reponse, chain);
        reponse.str += "---HTMLFilter()";
        return true;
    }
}

class SensitiveFilter implements Filter {

    @Override
    public boolean doFilter(Request request, Response reponse, FilterChain chain) {
        request.setStr(request.getStr().replaceAll("996", "955"));
        chain.doFilter(request, reponse, chain);
        reponse.str += "---SensitiveFilter()";
        return false;
    }
}

class Request {
    String str;

    public String getStr() {
        return str;
    }

    public void setStr(String str) {
        this.str = str;
    }
}

class Response {
    String str;

    public String getStr() {
        return str;
    }

    public void setStr(String str) {
        this.str = str;
    }
}

//过滤链
class FilterChain implements Filter {
    List<Filter> filters = new ArrayList<>(16);
    int index = 0;

    //直接返回FilterChain，再进行add时代码易读性增大（链式编程）
    public FilterChain add(Filter filter) {
        filters.add(filter);
        return this;
    }

    @Override
    public boolean doFilter(Request request, Response reponse, FilterChain chain) {
        if (index == filters.size()) {
            return false;
        }
        Filter f = filters.get(index);
        index++;

        return f.doFilter(request, reponse, chain);
    }
}
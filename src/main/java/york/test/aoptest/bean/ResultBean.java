package york.test.aoptest.bean;

import lombok.Data;

import java.io.Serializable;

/**
 * Reference {@link https://xwjie.github.io/rule/aop.html#resultbean%E5%AE%9A%E4%B9%89}
 * @param <T>
 */

@Data
public class ResultBean<T> implements Serializable {

    public static final int SUCCESS = 0;

    public static final int FAIL = 1;

    private String msg = "success";

    private int code = SUCCESS;

    private T data;

    public ResultBean() {
        super();
    }

    public ResultBean(T data) {
        super();
        this.data = data;
    }

    public ResultBean(Throwable throwable) {
        super();
        this.msg = throwable.toString();
        this.code = FAIL;
    }

}

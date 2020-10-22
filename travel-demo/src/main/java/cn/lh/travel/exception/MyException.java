package cn.lh.travel.exception;

public class MyException extends RuntimeException {
    private int code;

    public MyException(String message, int code) {
        super(message);
        this.code = code;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }
}

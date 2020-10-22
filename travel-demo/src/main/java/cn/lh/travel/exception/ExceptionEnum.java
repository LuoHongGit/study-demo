package cn.lh.travel.exception;

public enum ExceptionEnum {
    PRODUCT_TOPRODUCTLIST_EXCEPTION(new MyException("查询商品列表失败",401));

    private final MyException myException;
    
    private ExceptionEnum(MyException myException)
    {
        this.myException = myException;
    }

    public MyException getName() {

        return myException;
    }
}
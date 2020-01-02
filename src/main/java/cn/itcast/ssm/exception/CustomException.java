package cn.itcast.ssm.exception;

/**
 * 作者：高俊欣
 * 日期：2019/10/21
 * 微信：15000952623
 **/

public class CustomException extends Exception {

    //异常信息
    private String message;


    public CustomException(String message){

        super(message);
        this.message=message;

    }




    @Override
    public String getMessage() {
        return message;
    }




    public void setMessage(String message) {
        this.message = message;
    }



}

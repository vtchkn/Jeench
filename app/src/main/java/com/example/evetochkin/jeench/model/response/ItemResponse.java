package com.example.evetochkin.jeench.model.response;

import com.example.evetochkin.jeench.model.content.Message;

public class ItemResponse
{
    private Message message;

    private String code;

    public Message getMessage ()
    {
        return message;
    }

    public void setMessage (Message message)
    {
        this.message = message;
    }

    public String getCode ()
    {
        return code;
    }

    public void setCode (String code)
    {
        this.code = code;
    }

    @Override
    public String toString()
    {
        return "[message = "+message+", code = "+code+"]";
    }
}
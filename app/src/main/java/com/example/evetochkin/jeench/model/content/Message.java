package com.example.evetochkin.jeench.model.content;

public class Message
{
    private Item[] item;

    public Item[] getItem ()
    {
        return item;
    }

    public void setItem (Item[] item)
    {
        this.item = item;
    }

    @Override
    public String toString()
    {
        return "[item = "+item+"]";
    }
}
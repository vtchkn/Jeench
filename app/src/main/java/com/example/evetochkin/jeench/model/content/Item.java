package com.example.evetochkin.jeench.model.content;

import io.realm.RealmObject;

public class Item extends RealmObject {
    private String point_distance;

    private String group_type;

    private String currency_id;

    private String item_shares;

    private String item_likes;

    private String item_price;

    private String shop_id;

    private String item_bonus_amount;

    private String shop_logo;

    private String item_bonus_price;

    private String shop_name;

    private String point_address;

    private String item_image;

    private String shop_rank;

    private String point_coords;

    private String item_is_liked;

    private String item_name;

    private String point_time_id;

    private String point_rank;

    private String item_id;

    private String item_comments;

    private String point_id;

    public String getPoint_distance ()
    {
        return point_distance;
    }

    public void setPoint_distance (String point_distance)
    {
        this.point_distance = point_distance;
    }

    public String getGroup_type ()
    {
        return group_type;
    }

    public void setGroup_type (String group_type)
    {
        this.group_type = group_type;
    }

    public String getCurrency_id ()
    {
        return currency_id;
    }

    public void setCurrency_id (String currency_id)
    {
        this.currency_id = currency_id;
    }

    public String getItem_shares ()
    {
        return item_shares;
    }

    public void setItem_shares (String item_shares)
    {
        this.item_shares = item_shares;
    }

    public String getItem_likes ()
    {
        return item_likes;
    }

    public void setItem_likes (String item_likes)
    {
        this.item_likes = item_likes;
    }

    public String getItem_price ()
    {
        return item_price;
    }

    public void setItem_price (String item_price)
    {
        this.item_price = item_price;
    }

    public String getShop_id ()
    {
        return shop_id;
    }

    public void setShop_id (String shop_id)
    {
        this.shop_id = shop_id;
    }

    public String getItem_bonus_amount ()
    {
        return item_bonus_amount;
    }

    public void setItem_bonus_amount (String item_bonus_amount)
    {
        this.item_bonus_amount = item_bonus_amount;
    }

    public String getShop_logo ()
    {
        return shop_logo;
    }

    public void setShop_logo (String shop_logo)
    {
        this.shop_logo = shop_logo;
    }

    public String getItem_bonus_price ()
    {
        return item_bonus_price;
    }

    public void setItem_bonus_price (String item_bonus_price)
    {
        this.item_bonus_price = item_bonus_price;
    }

    public String getShop_name ()
    {
        return shop_name;
    }

    public void setShop_name (String shop_name)
    {
        this.shop_name = shop_name;
    }

    public String getPoint_address ()
    {
        return point_address;
    }

    public void setPoint_address (String point_address)
    {
        this.point_address = point_address;
    }

    public String getItem_image ()
    {
        return item_image;
    }

    public void setItem_image (String item_image)
    {
        this.item_image = item_image;
    }

    public String getShop_rank ()
    {
        return shop_rank;
    }

    public void setShop_rank (String shop_rank)
    {
        this.shop_rank = shop_rank;
    }

    public String getPoint_coords ()
    {
        return point_coords;
    }

    public void setPoint_coords (String point_coords)
    {
        this.point_coords = point_coords;
    }

    public String getItem_is_liked ()
    {
        return item_is_liked;
    }

    public void setItem_is_liked (String item_is_liked)
    {
        this.item_is_liked = item_is_liked;
    }

    public String getItem_name ()
    {
        return item_name;
    }

    public void setItem_name (String item_name)
    {
        this.item_name = item_name;
    }

    public String getPoint_time_id ()
    {
        return point_time_id;
    }

    public void setPoint_time_id (String point_time_id)
    {
        this.point_time_id = point_time_id;
    }

    public String getPoint_rank ()
    {
        return point_rank;
    }

    public void setPoint_rank (String point_rank)
    {
        this.point_rank = point_rank;
    }

    public String getItem_id ()
    {
        return item_id;
    }

    public void setItem_id (String item_id)
    {
        this.item_id = item_id;
    }

    public String getItem_comments ()
    {
        return item_comments;
    }

    public void setItem_comments (String item_comments)
    {
        this.item_comments = item_comments;
    }

    public String getPoint_id ()
    {
        return point_id;
    }

    public void setPoint_id (String point_id)
    {
        this.point_id = point_id;
    }

    @Override
    public String toString()
    {
        return "[point_distance = "+point_distance+", group_type = "+group_type+", currency_id = "+currency_id+", item_shares = "+item_shares+", item_likes = "+item_likes+", item_price = "+item_price+", shop_id = "+shop_id+", item_bonus_amount = "+item_bonus_amount+", shop_logo = "+shop_logo+", item_bonus_price = "+item_bonus_price+", shop_name = "+shop_name+", point_address = "+point_address+", item_image = "+item_image+", shop_rank = "+shop_rank+", point_coords = "+point_coords+", item_is_liked = "+item_is_liked+", item_name = "+item_name+", point_time_id = "+point_time_id+", point_rank = "+point_rank+", item_id = "+item_id+", item_comments = "+item_comments+", point_id = "+point_id+"]";
    }
}
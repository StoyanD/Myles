package com.hack.twenty.api;

/**
 * Created by stoyan on 10/24/15.
 * {
 "id": 1,
 "shipment_id": null,
 "item_id": 1,
 "created_at": "2015-10-25T03:23:22.015Z",
 "updated_at": "2015-10-25T03:23:22.015Z",
 "recipient_id": 1,
 "item": {
 "id": 1,
 "name": "Rolling Pin",
 "description": null,
 "price": 1000,
 "image_url": "http://ecx.images-amazon.com/images/I/61YHMj9Zx1L._SL1500_.jpg",
 "category_id": 1,
 "created_at": "2015-10-25T02:43:53.396Z",
 "updated_at": "2015-10-25T02:59:43.818Z"
 }
 }
 */
public class RecipientApi {
    public Long id;
    public Long shipment_id;
    public Long recipient_id;
    public ItemApi item;

}


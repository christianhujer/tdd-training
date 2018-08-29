package com.nelkinda.training.tdd;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAttribute;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBHashKey;

public class Card {
    private Integer id;
    private String title;
    private String text;

    public Card() {
    }

    public Card(final Integer id) {
        this.id = id;
    }

    public Card(final Integer id, final String title, final String text) {
        this.id = id;
        this.title = title;
        this.text = text;
    }

    @DynamoDBHashKey
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @DynamoDBAttribute
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @DynamoDBAttribute
    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}

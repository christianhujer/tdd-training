package com.nelkinda.training.tdd;

import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapperConfig;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapperConfig.TableNameOverride;

public class CardDao {
    private final DynamoDBMapper mapper;

    public CardDao(final AmazonDynamoDB amazonDynamoDB, final String tableName) {
        mapper = new DynamoDBMapper(amazonDynamoDB, createDynamoDBMapperConfig(tableName));
    }

    private static DynamoDBMapperConfig createDynamoDBMapperConfig(final String tableName) {
        return DynamoDBMapperConfig
                    .builder()
                    .withTableNameOverride(new TableNameOverride(tableName))
                    .build();
    }

    public void createCard(final Card testCard) {
        mapper.save(testCard);
    }

    public Card getCardById(final int id) {
        return mapper.load(new Card(id));

    }
}

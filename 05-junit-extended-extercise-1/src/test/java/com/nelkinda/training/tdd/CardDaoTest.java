package com.nelkinda.training.tdd;

import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.document.DynamoDB;
import com.amazonaws.services.dynamodbv2.document.Item;
import com.amazonaws.services.dynamodbv2.document.Table;
import com.amazonaws.services.dynamodbv2.document.spec.GetItemSpec;
import com.amazonaws.services.dynamodbv2.local.embedded.DynamoDBEmbedded;
import com.amazonaws.services.dynamodbv2.model.*;
import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import java.math.BigDecimal;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class CardDaoTest {

    private static AmazonDynamoDB amazonDynamoDB;
    private CardDao cardDao;

    @BeforeClass
    public static void setupDynamoDbEmbedded() {
        System.setProperty("sqlite4java.library.path", "native-libs");
        amazonDynamoDB = DynamoDBEmbedded.create().amazonDynamoDB();
    }

    @Before
    public void createTable() {
        amazonDynamoDB.createTable(new CreateTableRequest()
                .withTableName("testTable")
                .withKeySchema(
                        new KeySchemaElement("id", KeyType.HASH)
                )
                .withAttributeDefinitions(
                        new AttributeDefinition("id", ScalarAttributeType.N)
                )
                .withProvisionedThroughput(
                        new ProvisionedThroughput(10L, 10L)
                )
        );
    }

    @After
    public void deleteTable() {
        amazonDynamoDB.deleteTable("testTable");
    }

    @Before
    public void createDao() {
        cardDao = new CardDao(amazonDynamoDB, "testTable");
    }

    @Test
    public void testCreate() {
        cardDao.createCard(new Card(1, "Test Card", "This is a test card."));

        DynamoDB dynamoDB = new DynamoDB(amazonDynamoDB);
        Table table = dynamoDB.getTable("testTable");
        Item item = table.getItem(new GetItemSpec().withPrimaryKey("id", 1));
        assertThat(item.get("id"), is(BigDecimal.valueOf(1)));
        assertThat(item.get("title"), is("Test Card"));
        assertThat(item.get("text"), is("This is a test card."));
    }

    @Test
    public void testRead() {
        DynamoDB dynamoDB = new DynamoDB(amazonDynamoDB);
        Table table = dynamoDB.getTable("testTable");
        table.putItem(new Item()
                .withInt("id" ,1)
                .withString("title", "Test Card")
                .withString("text", "This is a test card.")
        );
        Card card = cardDao.getCardById(1);
        assertThat(card.getId(), is(1));
        assertThat(card.getTitle(), is("Test Card"));
        assertThat(card.getText(), is("This is a test card."));
    }
}

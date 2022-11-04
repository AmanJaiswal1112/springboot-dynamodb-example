package com.javatechie.aws.config;

import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.client.builder.AwsClientBuilder;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClientBuilder;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DynamoDbConfig {

    public static final String SERVICE_ENDPOINT = "dynamodb.us-east-1.amazonaws.com";
    public static final String REGION = "us-east-1";
    public static final String ACCESS_KEY = "AKIA42IL442M4SYNLCN7";
    public static final String PASSWORD = "nU1OqPeA+yL8/bXeet9B1oH2GBV1dQZ+rcghJU7B";
    @Bean
    public DynamoDBMapper dynamoDBMapper(){
        return new DynamoDBMapper(amazonDynamoDbConfig());
    }

    private AmazonDynamoDB amazonDynamoDbConfig() {
        return AmazonDynamoDBClientBuilder.standard()
                .withEndpointConfiguration(
                        new AwsClientBuilder.EndpointConfiguration(
                                SERVICE_ENDPOINT, REGION))
                .withCredentials(new AWSStaticCredentialsProvider(new BasicAWSCredentials(ACCESS_KEY, PASSWORD))).build();
    }
}

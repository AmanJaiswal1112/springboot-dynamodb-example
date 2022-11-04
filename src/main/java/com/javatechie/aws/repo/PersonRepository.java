package com.javatechie.aws.repo;

import ch.qos.logback.core.net.SyslogOutputStream;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBSaveExpression;
import com.amazonaws.services.dynamodbv2.model.AttributeValue;
import com.amazonaws.services.dynamodbv2.model.ExpectedAttributeValue;
import com.javatechie.aws.model.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

@Repository
public class PersonRepository {

    @Autowired
    private DynamoDBMapper dynamoDBMapper;

    public Person addPerson(Person person){
        System.out.println("person========="+person);
        dynamoDBMapper.save(person);
        return person;
    }

    public Person findPersonByPersonId(String personId){
        return dynamoDBMapper.load(Person.class, personId);
    }

    public String deletePerson(Person person){
        dynamoDBMapper.delete(person);
        return "person Removed";
    }

    public String updatePerson(Person person){
        dynamoDBMapper.save(person, buildExpression(person));
        return "Record updated...........";
    }

    private DynamoDBSaveExpression buildExpression(Person person){
        DynamoDBSaveExpression dynamoDBSaveExpression = new DynamoDBSaveExpression();
        Map<String, ExpectedAttributeValue> expectedAttributeValueMap = new HashMap<>();
        expectedAttributeValueMap.put("personId", new ExpectedAttributeValue(new AttributeValue().withS(person.getPersonId())));
        dynamoDBSaveExpression.setExpected(expectedAttributeValueMap);
        return dynamoDBSaveExpression;
    }
}

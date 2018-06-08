package com.jwcjlu.demos.graphql;
import static graphql.Scalars.GraphQLInt;
import static graphql.Scalars.GraphQLString;
import static graphql.schema.GraphQLFieldDefinition.newFieldDefinition;
import static graphql.schema.GraphQLObjectType.newObject;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import graphql.GraphQL;
import graphql.schema.*;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
public class MainApp {
    private static List<Person> persons;

    public static void main(String[] args) throws IOException {
        init();

        GraphQLObjectType dogType = newObject()
            .name("dog")

            .field(newFieldDefinition()
                .name("id")
                .type(GraphQLInt))

            .field(newFieldDefinition()
                .name("name")
                .type(GraphQLString))

            .field(newFieldDefinition()
                .name("age")
                .type(GraphQLInt))

            .build();

        GraphQLObjectType personType = newObject()
            .name("person")

            .field(newFieldDefinition()
                .name("id")
                .type(GraphQLInt))

            .field(newFieldDefinition()
                .name("name")
                .type(GraphQLString))

            .field(newFieldDefinition()
                .name("password")
                .type(GraphQLString))

            .field(newFieldDefinition()
                .name("dogs")
                .type(new GraphQLList(dogType)))

            .build();

        GraphQLFieldDefinition personDefinition =
            GraphQLFieldDefinition.newFieldDefinition()
                .name("person")
                .type(personType)
                .argument(GraphQLArgument.newArgument().name("id").type(GraphQLInt))
                .dataFetcher(new DataFetcher() {
                    public Object get(DataFetchingEnvironment dataFetchingEnvironment) {
                        int id = dataFetchingEnvironment.getArgument("id");
                        for (Person person : persons) {
                            if (person.getId() == id) {
                                return person;
                            }
                        }
                        return null;
                    }
                })
                .build();

        GraphQLSchema schema = GraphQLSchema.newSchema()
            .query(newObject()
                .name("personQuery")
                .field(personDefinition)
                .build())
            .build();

        GraphQL graphQL = GraphQL.newGraphQL(schema).build();
        System.err.println("====================================");
        System.err.println(graphQL.execute("{person(id:1){id,name,dogs{id,name,age}}}").getData());
        System.err.println(graphQL.execute("{person(id:2){id,name,dogs{id,name}}}").getData());
        System.err.println(graphQL.execute("{person(id:3){id,name,dogs{id,name,age}}}").getData());
    }

    private static void init() throws IOException {
        InputStream inputStream = MainApp.class.getClassLoader().getResourceAsStream("person.json");
        byte[] bytes = new byte[1024];
        int length;
        StringBuilder stringBuilder = new StringBuilder();
        while ((length = inputStream.read(bytes)) != -1) {
            stringBuilder.append(new String(bytes, 0, length));
        }

        persons = new Gson()
            .fromJson(stringBuilder.toString(),
                new TypeToken<ArrayList<Person>>() {
                }.getType()
            );
    }
}

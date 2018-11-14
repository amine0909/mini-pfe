package com.mini_pfe.services;


import com.mini_pfe.services.Fetchers.AllMaterielsByChefDepart;
import graphql.GraphQL;
import graphql.schema.GraphQLSchema;
import graphql.schema.idl.RuntimeWiring;
import graphql.schema.idl.SchemaGenerator;
import graphql.schema.idl.SchemaParser;
import graphql.schema.idl.TypeDefinitionRegistry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import org.springframework.core.io.Resource;
import java.io.File;
import java.io.IOException;

@Service
public class GraphQlService {


    @Autowired
    private AllMaterielsByChefDepart allMaterielsByChefDepart;

    @Value("classpath:graphql/Materiel.graphqls")
    Resource resourceMateriel;



    private GraphQL graphQL;




    // load schema at application start up
    @PostConstruct
    private void loadSchema() throws IOException {
        // parse schema
        TypeDefinitionRegistry typeRegistry = new SchemaParser().parse(resourceMateriel.getFile());

        RuntimeWiring wiring = buildRuntimeWiring();
        GraphQLSchema schema = new SchemaGenerator().makeExecutableSchema(typeRegistry, wiring);
        graphQL = GraphQL.newGraphQL(schema).build();
    }

    private RuntimeWiring buildRuntimeWiring() {
        return RuntimeWiring.newRuntimeWiring()
                .type("Query", typeWiring -> typeWiring
                        .dataFetcher("AllMaterielsByChefDepart", this.allMaterielsByChefDepart))
                .build();
    }


    public GraphQL getGraphQL() {
        return graphQL;
    }
}

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

    @Value("classpath:graphql/Reclamation.graphqls")
    Resource resourceReclamation;

    @Value("classpath:graphql/Departement.graphqls")
    Resource resourceDepartement;

    @Value("classpath:graphql/Classe.graphqls")
    Resource resourceClasse;

    @Value("classpath:graphql/ChefDepartement.graphqls")
    Resource resourceChefDep;

    private GraphQL graphQL;




    // load schema at application start up
    @PostConstruct
    private void loadSchema() throws IOException {
        SchemaParser schemaParser = new SchemaParser();
        // get the schema
        File schemaFileMateriel = this.resourceMateriel.getFile();
        File schemaFileReclamation = this.resourceReclamation.getFile();
        File schemaFileClasse = this.resourceClasse.getFile();
        File schemaFileDepart = this.resourceDepartement.getFile();
        File schemaFileChefDep = this.resourceChefDep.getFile();
        // parse schema
        //TypeDefinitionRegistry typeRegistry = new SchemaParser().parse(schemaFile);
        TypeDefinitionRegistry typeDefinitionRegistry = new TypeDefinitionRegistry();
        typeDefinitionRegistry.merge(schemaParser.parse(schemaFileMateriel));
        typeDefinitionRegistry.merge(schemaParser.parse(schemaFileClasse));
        typeDefinitionRegistry.merge(schemaParser.parse(schemaFileDepart));
        typeDefinitionRegistry.merge(schemaParser.parse(schemaFileChefDep));
        typeDefinitionRegistry.merge(schemaParser.parse(schemaFileReclamation));


        RuntimeWiring wiring = this.buildRuntimeWiring();
        GraphQLSchema schema = new SchemaGenerator().makeExecutableSchema(typeDefinitionRegistry, wiring);
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

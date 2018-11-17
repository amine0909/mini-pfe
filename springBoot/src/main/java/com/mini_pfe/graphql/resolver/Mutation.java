package com.mini_pfe.graphql.resolver;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import com.mini_pfe.dao.repositories.MaterielsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Mutation implements GraphQLMutationResolver {
    @Autowired
    private MaterielsRepository materielsRepository;


   public Boolean deleteMateriel(Long matId) {
      this.materielsRepository.deleteById(matId);
      return true;
   }
}

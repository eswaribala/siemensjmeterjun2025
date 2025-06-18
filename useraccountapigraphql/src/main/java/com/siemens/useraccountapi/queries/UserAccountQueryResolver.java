package com.siemens.useraccountapi.queries;

import com.siemens.useraccountapi.models.UserAccount;
import com.siemens.useraccountapi.services.UserAccountService;
import graphql.kickstart.tools.GraphQLQueryResolver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class UserAccountQueryResolver implements GraphQLQueryResolver {

    @Autowired
    private UserAccountService userAccountService;


    public List<UserAccount> getAllUserAccounts(){
            return this.userAccountService.getAllUserAccounts();
    }
    public UserAccount getUserAccountById(String userId){
          return this.userAccountService.getUserAccountById(userId);
    }
    public List<UserAccount> getUserAccountByEmail(String email){

        return this.userAccountService.getUserAccountByEmail(email);
    }
}

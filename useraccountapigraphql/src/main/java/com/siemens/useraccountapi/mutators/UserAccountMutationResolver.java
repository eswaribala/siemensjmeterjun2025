package com.siemens.useraccountapi.mutators;

import com.siemens.useraccountapi.dtos.UserAccountInput;
import com.siemens.useraccountapi.models.FullName;
import com.siemens.useraccountapi.models.UserAccount;
import com.siemens.useraccountapi.services.UserAccountService;
import graphql.kickstart.tools.GraphQLMutationResolver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UserAccountMutationResolver implements GraphQLMutationResolver {

    @Autowired
    private UserAccountService userAccountService;

    public UserAccount addUserAccount(UserAccountInput userAccountInput){
        UserAccount userAccount=UserAccount.builder()
                .fullName(FullName.builder()
                        .firstName(userAccountInput.getFullName().getFirstName())
                        .lastName(userAccountInput.getFullName().getLastName())
                        .build())
                .dob(userAccountInput.getDob())
                .email(userAccountInput.getEmail())
                .password(userAccountInput.getPassword())
                .gender(userAccountInput.getGender())
                .build();

        return this.userAccountService.addUserAccount(userAccount);
    }

    public UserAccount updateUserAccount(String userId, String email){

        return this.userAccountService.updateUserAccount(userId,email);
    }
    public boolean deleteUserAccount(String userId){

        return this.userAccountService.deleteUserAccount(userId);
    }
}

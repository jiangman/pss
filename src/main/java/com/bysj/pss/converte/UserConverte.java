package com.bysj.pss.converte;

import com.bysj.pss.model.matadata.UserMetadata;
import com.bysj.pss.model.pojo.User;

public class UserConverte {

    public static UserMetadata Converte(User user) {
        if(user==null){
            return null;
        }else{
            UserMetadata userMetadata = new UserMetadata();
            userMetadata.setId(user.getId());
            userMetadata.setUserName(user.getUserName());
            userMetadata.setRole(user.getRole());
            userMetadata.setToken(user.getToken());
            return userMetadata;
        }
    }
}

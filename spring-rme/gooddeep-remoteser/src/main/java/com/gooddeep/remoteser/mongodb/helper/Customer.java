package com.gooddeep.remoteser.mongodb.helper;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

// 注意这里的注解哦，简单看看mongodb的文档就知道这个是文档集合

@Document(collection="aaa")
public class Customer {

   

    private String firstName;
    private String lastName;


/*    @Override
    public String toString() {
        return String.format(
                "Customer[id=%s, firstName=&#039;%s&#039;, lastName=&#039;%s&#039;]",
                id, firstName, lastName);
    }*/

  

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

}
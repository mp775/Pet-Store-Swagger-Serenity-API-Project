package io.swagger.petstore.userinfotest;

import io.swagger.petstore.testbase.TestBase;
import io.swagger.petstore.userinfo.UserSteps;
import io.swagger.petstore.utils.TestUtils;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.annotations.Title;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(SerenityRunner.class)
public class UserCurdTestWithSteps extends TestBase {
    static String id = "1099";
    static String username = "vp" + id;
    static String firstName = "ved";
    static String lastName = "puran";
    static String updateLastName = "gita";
    static String email = TestUtils.getRandomValue()+ "v.puran123@gmail.com";
    static String password = "vr11";
    static String phone = "07865432987";
    static double userStatus = 1;
    static String message;
    static String userName;
    static String updatedLaseNameResponse;

    @Steps
    UserSteps userSteps;

    @Title("creat new user")
    @Test
    public void test001(){
        userSteps.createNewUser( id,  username,  firstName,  updateLastName,  email,  password,  phone,  userStatus).statusCode(200);

}
@Title("get user by username")
    @Test
    public void test002(){
        userSteps.getUserByUserName(userName);
}
@Title("update user by lastname")
    @Test
    public void test003(){
        userSteps.updateByLastName(id,  username,  firstName,  updateLastName,  email,  password,  phone,  userStatus);
}
}

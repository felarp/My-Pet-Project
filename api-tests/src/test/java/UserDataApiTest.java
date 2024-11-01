import URLs.Urls;
import accertions.HttpAssertions;
import dto.*;
import io.restassured.response.Response;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

 public class UserDataApiTest extends BaseApiTest {

     public static String token;
     public static User user;

     @BeforeAll
     public static void initializeUserData() {
         user = new User("string", "string");
         token = apiProvider.post("/login", user).as(Token.class).getAccessToken();
     }

     @Test
     public void testRegisteredUser() {
         Response response = apiProvider.post(Urls.LOGIN, user);
         new HttpAssertions(response, Token.class)
                 .statusCode(200)
                 .assertionsJsonPathValueNotEmpty("access_token");
     }

     @Test
     public void testUnregisteredUser() {
         User unregistereduser = new User("unregistered", "user");
         Response response = apiProvider.post(Urls.LOGIN, unregistereduser);
         new HttpAssertions(response, Message.class)
                 .statusCode(401)
                 .assertionsMessage("Invalid credentials");
     }

     @Test
     public void testGetProductList() {
         Response response = apiProvider.get(Urls.PRODUCTS);
         new HttpAssertions(response, Product.class, true)
                 .statusCode(200)
                 .assertListNotEmpty();
     }

     @Test
     public void testGetSpecificProduct() {
         CartRequest requestBody = new CartRequest(1, 2);
         Response response = apiProvider.get("/products/" + requestBody.getProductId());
         new HttpAssertions(response, Product.class, true)
                 .statusCode(200)
                 .assertListNotEmpty();

     }
 }
//    @Test
//    public void testGetCustomerCart() {
//        Response response = apiProvider.get(Urls.CART, token);
//        new HttpAssertions(response, Product.class)
//                .statusCode(200);
//    }

  //  @Test

//    public void testAddExistingProductToCart() {
//        Response response = apiProvider.post(Urls.CART, new CartRequest(1,2), token);
//        new HttpAssertions(response, Message.class)
//                .statusCode(201)
//                .assertionsMessage("Product added to cart successfully");
//    }
//}

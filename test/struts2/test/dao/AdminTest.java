package struts2.test.dao;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;


public class AdminTest {

    public AdminTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    
    @Test
    public void testRegisterUser() throws Exception {
        System.out.println("registerUser");
        String userName = "Har";
        String password = "1234";
        String firstName = "Harpreet";
        String lastName = "Kaur";
        String email = "hart@gmail.com";
        String phoneNumber = "9876543210";
        Admin instance = new Admin();
        int expResult = 1;
        int result = instance.registerUser(userName, password, firstName, lastName, email, phoneNumber);
        assertEquals(expResult, result);

    }

    @Test
    public void testUpdateUserDetails() throws Exception {
        System.out.println("updateUserDetails");
        String userName = " Har";
        String password = "3333";
        String firstName = "Harpreet";
        String lastName = "Singh";
        String email = "hart@gmail.com";
        String phoneNumber = "9876543210";
        Admin instance = new Admin();
        int expResult = 1;
        int result = instance.updateUserDetails(userName, password, firstName, lastName, email, phoneNumber);
        assertEquals(expResult, result);

    }

    @Test
    public void testDeleteUserDetails() throws Exception {
        System.out.println("deleteUserDetails");
        String userName = "Ankita";
        Admin instance = new Admin();
        int expResult = 1;
        int result = instance.deleteUserDetails(userName);
        assertEquals(expResult, result);

    }

    @Test
    public void testRegisterProduct() {
        System.out.println("registerProduct");
        int productId = 99999;
        String productName = "Flowers";
        String productMake = "12-01-1987";
        double price = 76.98;
        int availability = 70;
        Admin instance = new Admin();
        int expResult = 1;
        int result = instance.registerProduct(productId, productName, productMake, price, availability);
        assertEquals(expResult, result);

    }

    @Test
    public void testUpdateProductDetails() throws Exception {
        System.out.println("updateProductDetails");
        int productId = 778001;
        String productName = "Biscuits";
        String productMake = "11-01-1987";
        Double price = 786.98;
        int availability = 19;
        Admin instance = new Admin();
        int expResult = 1;
        int result = instance.updateProductDetails(productId, productName, productMake, price, availability);
        assertEquals(expResult, result);

    }

    @Test
    public void testDeleteProductDetails() throws Exception {
        System.out.println("deleteProductDetails");
        int productId = 778001;
        Admin instance = new Admin();
        int expResult = 1;
        int result = instance.deleteProductDetails(productId);
        assertEquals(expResult, result);

    }

}

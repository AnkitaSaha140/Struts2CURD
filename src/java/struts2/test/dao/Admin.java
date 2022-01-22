package struts2.test.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import struts2.test.beans.Product;
import struts2.test.beans.User;
import struts2.test.core.ConnectionManager;

/**
 *
 * @author Avijit Chattopadhyay
 */
public class Admin {

    public int registerUser(String userName, String password, String firstName, String lastName,
            String email, String phoneNumber) throws Exception {
        int i = 0;
        Connection con = null;
        try {
            con = ConnectionManager.getConnection();
            String sql = "INSERT INTO users VALUES (?,?,?,?,?,?,?)";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, userName);
            ps.setString(2, password);
            ps.setString(3, firstName);
            ps.setString(4, lastName);
            ps.setString(5, email);
            ps.setString(6, phoneNumber);
            ps.setInt(7, 1);
            System.out.println("SQL for insert=" + ps);
            i = ps.executeUpdate();
            return i;
        } catch (Exception e) {
            e.printStackTrace();
            return i;
        } finally {
            if (con != null) {
                con.close();
            }
        }
    }

    public List report() throws SQLException, Exception {
        ResultSet rs = null;
        Connection con = null;
        List<User> userList = new ArrayList<>();
        try {
            String sql = "SELECT userName, password, firstName, lastName, email, phoneNumber FROM users where status=1";
            con = ConnectionManager.getConnection();
            System.out.println("Connection is " + con);
            PreparedStatement ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {

                User user = new User();
                user.setUserName(rs.getString("userName"));
                user.setPassword(rs.getString("password"));
                user.setFirstName(rs.getString("firstName"));
                user.setLastName(rs.getString("lastName"));
                user.setEmail(rs.getString("email"));
                user.setPhoneNumber(rs.getString("phoneNumber"));

                userList.add(user);
            }
            return userList;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        } finally {
            if (con != null) {
                con.close();
            }
        }
    }

    public User fetchUserDetails(String userName) throws SQLException, Exception {
        ResultSet rs = null;
        Connection con = null;
        User user = new User();
        try {
            con = ConnectionManager.getConnection();
            String sql = "SELECT userName, password, firstName, lastName, "
                    + "email, phoneNumber FROM users WHERE userName=?";
            PreparedStatement ps = con.prepareStatement(sql);
            System.out.println("userName = " + userName);
            ps.setString(1, userName);
            System.out.println("Select SQL = " + ps);

            rs = ps.executeQuery();
            if (rs.next()) {

                user.setUserName(rs.getString("userName"));
                user.setPassword(rs.getString("password"));
                user.setFirstName(rs.getString("firstName"));
                user.setLastName(rs.getString("lastName"));
                user.setEmail(rs.getString("email"));
                user.setPhoneNumber(rs.getString("phoneNumber"));

            }
            return user;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        } finally {
            if (con != null) {
                con.close();
            }
        }
    }

    public int updateUserDetails(String userName, String password, String firstName, String lastName,
            String email, String phoneNumber) throws SQLException, Exception {

        Connection con = ConnectionManager.getConnection();
        int i = 0;
        try {
            String sql = "UPDATE users SET password = ?, firstName = ?, "
                    + "lastName = ?, email = ?, phoneNumber = ? "
                    + "WHERE userName = ?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, password);
            ps.setString(2, firstName);
            ps.setString(3, lastName);
            ps.setString(4, email);
            ps.setString(5, phoneNumber);
            ps.setString(6, userName);
            System.out.println("Select SQL = " + ps);
            i = ps.executeUpdate();
            return i;
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        } finally {
            if (con != null) {
                con.close();
            }
        }
    }

    public int deleteUserDetails(String userName) throws SQLException, Exception {
        Connection con = ConnectionManager.getConnection();
        int i = 0;
        try {
            String sql = "UPDATE users SET status = 0 WHERE userName = ?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, userName);
            i = ps.executeUpdate();
            return i;
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        } finally {
            if (con != null) {
                con.close();
            }
        }
    }

    public int registerProduct(int productId, String productName, String productMake, double price, int availability) {
        int i = 0;
        Connection con = null;
        try {
            con = ConnectionManager.getConnection();
            String sql = "INSERT INTO product VALUES(?,?,?,?,?,?)";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, productId);
            ps.setString(2, productName);
            ps.setString(3, productMake);
            ps.setDouble(4, price);
            ps.setInt(5, availability);
            ps.setInt(6, 1);
            System.out.println("SQL for insert=" + ps);
            i = ps.executeUpdate();
            return i;
        } catch (Exception e) {
            e.printStackTrace();
            return i;
        } finally {
            if (con != null) {
                try {
                    con.close();
                } catch (SQLException ex) {
                  ex.printStackTrace();
            return 0; 
                }
            }
        }
    }

    public List reportProduct() throws SQLException, Exception {
        ResultSet rs = null;
        Connection con = null;
        List<Product> productList = new ArrayList<>();
        try {
            String sql = "SELECT productId,productName,productMake,price,availability FROM product where status = 1";
            con = ConnectionManager.getConnection();
            System.out.println("Connection is " + con);
            PreparedStatement ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {

                Product product = new Product();
                product.setProductId(rs.getInt("productId"));
                product.setProductName(rs.getString("productName"));
                product.setProductMake(rs.getString("productMake"));
                product.setPrice(rs.getDouble("price"));
                product.setAvailability(rs.getInt("availability"));

                productList.add(product);
            }
            return productList;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        } finally {
            if (con != null) {
                con.close();
            }
        }
    }


    public Product fetchProductDetails(int productId) throws SQLException, Exception {
        ResultSet rs = null;
        Connection con = null;
        Product product = new Product();
        try {
            con = ConnectionManager.getConnection();
            String sql = "SELECT productId,productName,productMake,price,availability FROM product WHERE productId=? ";
            PreparedStatement ps = con.prepareStatement(sql);
            System.out.println("ProductId = " + productId);
            ps.setInt(1, productId);
            System.out.println("Select SQL = " + ps);

            rs = ps.executeQuery();
            if (rs.next()) {

                product.setProductId(rs.getInt("productId"));
                product.setProductName(rs.getString("productName"));
                product.setProductMake(rs.getString("productMake"));
                product.setPrice(rs.getDouble("price"));
                product.setAvailability(rs.getInt("availability"));

            }
            return product;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        } finally {
            if (con != null) {
                con.close();
            }
        }
    }
    
    
    public int updateProductDetails(int productId, String productName, String productMake, Double price,
            int availability) throws SQLException, Exception {

        Connection con = ConnectionManager.getConnection();
        int i = 0;
        try {
            String sql = "UPDATE product SET\n"
                    + "productName = ?,\n"
                    + "productMake = ?,\n"
                    + "price = ?,\n"
                    + "availability =?\n"
                    + "WHERE productId = ?";
            PreparedStatement ps = con.prepareStatement(sql);

            ps.setString(1, productName);
            ps.setString(2, productMake);
            ps.setDouble(3, price);
            ps.setInt(4, availability);
            ps.setInt(5, productId);

            System.out.println("Select SQL = " + ps);
            i = ps.executeUpdate();
            return i;
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        } finally {
            if (con != null) {
                con.close();
            }
        }
    }
    public int deleteProductDetails(int productId) throws SQLException, Exception {
        Connection con = ConnectionManager.getConnection();
        int i = 0;
        try {
            String sql = "UPDATE product SET status = 0 WHERE productId = ?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, productId);
            i = ps.executeUpdate();
            return i;
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        } finally {
            if (con != null) {
                con.close();
            }
        }
    }


}

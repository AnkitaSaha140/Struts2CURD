package struts2.test.actions;

import com.opensymphony.xwork2.ActionSupport;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import org.junit.Test;
import struts2.test.beans.Product;
import struts2.test.dao.Admin;
/**
 *
 * @author Ankush Saha
 */
public class InsertProductAction extends ActionSupport {

    private int productId;
    private String productName;
    private String productMake;
    private double price;
    private int availability;
    private int ctr = 0;
    private boolean status;
    private String submitType;
    private String msg = "";
    private boolean noData = false;
    private List<Product> productList = null;
    private Admin admin = null;
    private ResultSet rs = null;
    Product product = null;
    
   
   

//    @Override
    
    public String insertProduct() throws Exception {
        setAdmin(new Admin());

        try {
            setCtr(getAdmin().registerProduct(productId, productName, productMake, price,
                    availability));
            System.out.println(getCtr());
             if (getCtr() > 0) {
                setMsg("Product Insertion Successfull");
            } else {
                setMsg("Some error");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "INSERTED";

    }

    public String getAllProducts() throws Exception {
        try {
            Admin admin = new Admin();
            Product product = null;
            setProductList(new ArrayList<>());
            setProductList(admin.reportProduct());

            if (!productList.isEmpty()) {
                setNoData(false);
                
                System.out.println("Products retrieve = " + getProductList().size());
                System.out.println("setting nodata=false");
            } else {
                setNoData(true);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "PRODREPORT";
    }
 
    public String updateProducts() throws Exception {

        try {
            Admin dao = new Admin();
            if (getSubmitType().equals("updateproductsdata")) {
                Product product = dao.fetchProductDetails(productId);
                if (product != null) {
                    productId = product.getProductId();
                    productName = product.getProductName();
                    productMake = product.getProductMake();
                    price = product.getPrice();
                    availability = product.getAvailability();

                }
            } else {
                int i = dao.updateProductDetails(productId, productName, productMake, price,
                        availability);
                if (i > 0) {
                    msg = "Record Updated Successfuly";
                } else {
                    msg = "error";
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return "PRODUCTUPDATE";
    }

    public String deleteProducts() throws Exception {
        try {
            Admin dao = new Admin();
            int isDeleted = dao.deleteProductDetails(productId);
            if (isDeleted > 0) {
                msg = "Record deleted successfully";
            } else {
                msg = "Some error";
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "PRODDELETE";
    }

    /**
     * @return the productId
     */
    public int getProductId() {
        return productId;
    }

    /**
     * @param productId the productId to set
     */
    public void setProductId(int productId) {
        this.productId = productId;
    }

    /**
     * @return the productName
     */
    public String getProductName() {
        return productName;
    }

    /**
     * @param productName the productName to set
     */
    public void setProductName(String productName) {
        this.productName = productName;
    }

    /**
     * @return the productMake
     */
    
    
    public String getProductMake() {
        return productMake;
    }

    /**
     * @param productMake the productMake to set
     */
    
    
    public void setProductMake(String productMake) {
        this.productMake = productMake;
    }

    /**
     * @return the price
     */
    public double getPrice() {
        return price;
    }

    /**
     * @param price the price to set
     */
    public void setPrice(double price) {
        this.price = price;
    }

    /**
     * @return the availability
     */
    public int getAvailability() {
        return availability;
    }

    /**
     * @param availability the availability to set
     */
    public void setAvailability(int availability) {
        this.availability = availability;
    }

    /**
     * @return the ctr
     */
    public int getCtr() {
        return ctr;
    }

    /**
     * @param ctr the ctr to set
     */
    public void setCtr(int ctr) {
        this.ctr = ctr;
    }

    /**
     * @return the msg
     */
    public String getMsg() {
        return msg;
    }

    /**
     * @param msg the msg to set
     */
    public void setMsg(String msg) {
        this.msg = msg;
    }

    /**
     * @return the status
     */
    public boolean isStatus() {
        return status;
    }

    /**
     * @param status the status to set
     */
    public void setStatus(boolean status) {
        this.status = status;
    }

    /**
     * @return the rs
     */
    public ResultSet getRs() {
        return rs;
    }

    /**
     * @param rs the rs to set
     */
    public void setRs(ResultSet rs) {
        this.rs = rs;
    }

    /**
     * @return the productList
     */
    public List<Product> getProductList() {
        return productList;
    }

    /**
     * @param productList the productList to set
     */
    public void setProductList(List<Product> productList) {
        this.productList = productList;
    }

    /**
     * @return the noData
     */
    public boolean isNoData() {
        return noData;
    }

    /**
     * @param noData the noData to set
     */
    public void setNoData(boolean noData) {
        this.noData = noData;
    }

    /**
     * @return the submitType
     */
    public String getSubmitType() {
        return submitType;
    }

    /**
     * @param submitType the submitType to set
     */
    public void setSubmitType(String submitType) {
        this.submitType = submitType;
    }

    /**
     * @return the products
     */
//    public Products getProducts() {
//        return products;
//    }
//
//    /**
//     * @param products the products to set
//     */
//    public void setProducts(Products products) {
//        this.products = products;
//    }

    /**
     * @return the admin
     */
    
    public Admin getAdmin() {
        return admin;
    }

    /**
     * @param admin the admin to set
     */
    public void setAdmin(Admin admin) {
        this.admin = admin;
    }

    /**
     * @return the admin
     */
    

    /**
     * @return the products
     */
    
    @Test
    public void printMessage(){
        System.out.println(msg);
        
    }
}
